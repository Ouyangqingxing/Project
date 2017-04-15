package com.upsoft.service.impl;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.upsoft.dao.KeywordDao;
import com.upsoft.dao.ReplyPostDao;
import com.upsoft.dao.TopicPostDao;
import com.upsoft.dao.UserDao;
import com.upsoft.entity.Keyword;
import com.upsoft.entity.ReplyPost;
import com.upsoft.entity.TopicPost;
import com.upsoft.entity.User;
import com.upsoft.service.TopicPostService;
import com.upsoft.service.param.AddTopicPostParam;
import com.upsoft.service.param.PageCustInfoTopicPost;
import com.upsoft.service.param.PageSearchContent;
import com.upsoft.service.param.PageSearchKeyword;
import com.upsoft.service.param.PageSearchReplyContent;
import com.upsoft.service.param.PageSearchTitle;
import com.upsoft.service.param.SelectReplyPostBySearchParam;
import com.upsoft.service.param.TopicPostParam;
import com.upsoft.service.param.UpdateTopicPostStateParam;
import com.upsoft.util.FormatConverter;
import com.upsoft.util.IDGenerator;

@Component
public class TopicPostServiceImpl implements TopicPostService{
	static Logger log = Logger.getLogger(TopicPostServiceImpl.class);
	
	@Autowired
	private TopicPostDao topicPostDao;
	@Autowired
	private KeywordDao keywordDao;
	@Autowired
	private UserDao userDao;
	@Autowired
	private ReplyPostDao replyPostDao;
	
	/**
	 * 判断是否登录
	 * @param request
	 * @return 结果
	 */
	private boolean checkLogin(HttpServletRequest request){
		HttpSession session = request.getSession();
		try {
			session.getAttribute("user");
			return true;
		} catch (Exception e) {return false;}
	}
	
	@Override
	public boolean addTopicPost(AddTopicPostParam addTopicPostParam , HttpServletRequest request){
		Timestamp currentTime = new Timestamp(new Date().getTime());
		HttpSession session = request.getSession();
		User user = (User) session.getAttribute("user");
		if(user != null && user.getState() > 0){
			TopicPost topicpost = new TopicPost(IDGenerator.getId(),user.getId(),user.getName(),addTopicPostParam.getTitle(),addTopicPostParam.getContent(),currentTime,0,-1);
			List<Keyword> keywordList = getKeyword(topicpost.getId(),addTopicPostParam.getKeywordStr());
			try {
				for(int i = 0 ; i < keywordList.size() ; i++){
					keywordDao.daoAddKeyword(keywordList.get(i));
				}
				topicPostDao.daoAddTopicPost(topicpost);
				userDao.daoUpdatePostNumber(topicpost.getUserId());
				log.info("新增主题帖成功，userId = "+user.getId()+",username = "+user.getName()+"");
				return true;
			} catch (Exception e) {
				log.error("新增主题帖失败！"+e.toString());
				e.printStackTrace();
				return false;
			}
		}
		return false;
	}
	private List<Keyword> getKeyword(String topicPostId,String resStr){
		List<Keyword> result = new ArrayList<Keyword>();
		resStr = resStr.replaceAll(" +", " ");
		resStr = resStr + " ";
		StringBuffer tempSb = new StringBuffer("");
		for(int i = 0 ; i < resStr.length() ; i++){
			if(resStr.charAt(i) == ' '){
				Keyword keyword = new Keyword(IDGenerator.getId(),topicPostId,tempSb.toString());
				result.add(keyword);
				tempSb.setLength(0);
				continue;	
			}
			tempSb.append( resStr.charAt(i) );
		}
		return result;
	}
	
	@Override
	public void deleteTopicPost(String topicPostId, HttpServletRequest request){
		if(checkLogin(request)){
			topicPostId = topicPostId.replace("\"", "");
			try {
				topicPostDao.daoDeleteTopicPost(topicPostId);
				List<ReplyPost> replyPostList= replyPostDao.daoSelectReplyPostByTopicPostId(topicPostId);
				for(int i = 0 ; i < replyPostList.size(); i++){
					replyPostDao.daoDeleteReplyPost(replyPostList.get(i).getId());
				}
				log.info("成功删除主题帖");
			} catch (Exception e) {
				log.error("删除主题帖失败！"+e.toString());
				e.printStackTrace();
			}
		}
	}
	
	@Override
	public void updateTopicPost(TopicPost topicPost){
		try {
			topicPostDao.daoUpdateTopicPost(topicPost);
			log.info("成功更新主题帖");
		} catch (Exception e) {
			log.error("更新主题帖失败！"+e.toString());
			e.printStackTrace();
		}
	}

	@Override
	public void adoptAllTopicPost() {
		try {
			topicPostDao.daoAdoptAllTopicPost();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@Override
	public void updateTopicPostState(UpdateTopicPostStateParam updateTopicPostStateParam,HttpServletRequest request){
		if(checkLogin(request)){
			try {
				topicPostDao.daoUpdateTopicPostState(updateTopicPostStateParam.getTopicPostId(), updateTopicPostStateParam.getState());
				List<ReplyPost> replyPostList = replyPostDao.daoSelectReplyPostByTopicPostId(updateTopicPostStateParam.getTopicPostId());
				for(int i = 0 ; i < replyPostList.size() ; i++){
					replyPostDao.daoUpdateReplyPostState(replyPostList.get(i).getId(), updateTopicPostStateParam.getState());
				}
				log.info("成功更新主题帖状态");
			} catch (Exception e) {
				log.error("更新主题帖状态失败！"+e.toString());
				e.printStackTrace();
			}
		}
	}
	
	@Override
	public TopicPost selectTopicPostById(String topicPostId){
		topicPostId = FormatConverter.getStrFromJsonObjStr(topicPostId, "topicPostId");
		TopicPost result = new TopicPost();
		try {
			result = topicPostDao.daoSelectTopicPostById(topicPostId);
		} catch (Exception e) {
			log.error("查询主题帖失败！"+e.toString());
			e.printStackTrace();
		}
		return result;
	}
	
	@Override
	public List<Keyword> selectKeywordByTopicPostId(String topicPostId){
		List<Keyword> result = keywordDao.daoSelectKeywordByTopicPostId(topicPostId);
		try {
			result = keywordDao.daoSelectKeywordByTopicPostId(topicPostId);
		} catch (Exception e) {
			log.error("查询关键字失败！"+e.toString());
			e.printStackTrace();
		}
		return result;
	}
	
	@Override
	public String selectKeywordStrByTopicPostId(String topicPostId) {
		List<Keyword> keywordList = new ArrayList<Keyword>();
		try {
			keywordList = keywordDao.daoSelectKeywordByTopicPostId(topicPostId);
		} catch (Exception e) {
			log.error("查询关键字失败！"+e.toString());
			e.printStackTrace();
		}
		List<String> resultList = new ArrayList<String>();
		for(int i = 0 ; i < keywordList.size() ; i++){
			resultList.add(keywordList.get(i).getContent());
		}
		String result = resultList.toString();
		result = FormatConverter.getStrFromListStr(result);
		return result;
	}
	
	@Override
	public PageInfo<TopicPostParam> selectTopicPostByUserId(PageCustInfoTopicPost pageCustInfoTopicPost,HttpServletRequest request){
		String userId = pageCustInfoTopicPost.getUserId();
		if(userId == null || userId.equals("")){
			HttpSession session = request.getSession();
			User sessionUser = (User)session.getAttribute("user");
			if(sessionUser == null){
				return null;
			}
			userId = sessionUser.getId();
		}
		int pageSize = 10;
		int pageNum = pageCustInfoTopicPost.getPageNum();
		PageInfo<TopicPost> topicPostList = new PageInfo<TopicPost>();
		try {
			PageHelper.startPage(pageNum, pageSize);
			topicPostList = ((Page<TopicPost>)topicPostDao.daoSelectTopicPostByUserId(userId)).toPageInfo();
		} catch (Exception e) {
			log.error("查询主题帖失败！"+e.toString());
			e.printStackTrace();
		}
		return getTopicPostParam(topicPostList);
	}
	
	@Override
	public PageInfo<TopicPostParam> selectTopicPostBySearchTitle(PageSearchTitle pageSearchTitle) {
		int pageSize = 10;
		String searchContent = pageSearchTitle.getSearchContent();
		try {
			searchContent = URLDecoder.decode(searchContent, "UTF-8");
		} catch (UnsupportedEncodingException e) {
			log.error("解码失败！"+e.toString());
			e.printStackTrace();
		}
		searchContent = FormatConverter.getSQLStrFromSearchStr(searchContent);
		PageInfo<TopicPost> topicPostList = new PageInfo<TopicPost>();
		try {
			PageHelper.startPage(pageSearchTitle.getPageNum(), pageSize);
			topicPostList = ((Page<TopicPost>)topicPostDao.daoSelectTopicPostByTitle(searchContent)).toPageInfo();
		} catch (Exception e) {
			log.info("查询不到相关内容的主题帖！ 查询内容为("+searchContent+")"+e.toString());
		}
		return getTopicPostParam(topicPostList);
	}
	
	@Override
	public PageInfo<TopicPostParam> selectTopicPostBySearchContent(PageSearchContent pageSearchContent){
		int pageSize = 10;
		String searchContent = pageSearchContent.getSearchContent();
		try {
			searchContent = URLDecoder.decode(searchContent, "UTF-8");
		} catch (UnsupportedEncodingException e) {
			log.error("解码失败！"+e.toString());
			e.printStackTrace();
		}
		searchContent = FormatConverter.getSQLStrFromSearchStr(searchContent);
		String searchStr = FormatConverter.getFirstWordFromSearchStr(searchContent);
		PageInfo<TopicPost> topicPostList = new PageInfo<TopicPost>();
		try {
			PageHelper.startPage(pageSearchContent.getPageNum(), pageSize);
			topicPostList = ((Page<TopicPost>)topicPostDao.daoSelectTopicPostBySearch(searchContent)).toPageInfo();
		} catch (Exception e) {
			log.info("查询不到相关内容的主题帖！ 查询内容为("+searchContent+")"+e.toString());
		}
		return getTopicPostParamFromTopicPost(topicPostList,searchStr);
	}
	
	@Override
	public PageInfo<SelectReplyPostBySearchParam> selectTopicPostBySearchReplyPostContent(PageSearchReplyContent pageSearchReplyContent){
		int pageSize = 10;
		String searchContent = pageSearchReplyContent.getSearchContent();
		try {
			searchContent = URLDecoder.decode(searchContent, "UTF-8");
		} catch (UnsupportedEncodingException e) {
			log.error("解码失败！"+e.toString());
			e.printStackTrace();
		}
		searchContent = FormatConverter.getSQLStrFromSearchStr(searchContent);
		String searchStr = FormatConverter.getFirstWordFromSearchStr(searchContent);
		PageInfo<ReplyPost> replyPostList = null;
		try {
			PageHelper.startPage(pageSearchReplyContent.getPageNum(), pageSize);
			replyPostList = ((Page<ReplyPost>)replyPostDao.daoSelectReplyPostBySearch(searchContent)).toPageInfo();
		} catch (Exception e) {
			log.info("查询不到相关内容的主题帖！ 查询内容为("+searchContent+")"+e.toString());
		}
		return getReplyPostParamFromReplyPost(replyPostList,searchStr);
	}
	
	@Override
	public PageInfo<TopicPostParam> selectTopicPostBySearchKeywordContent(PageSearchKeyword pageSearchKeyword){
		int pageSize = 2;
		String searchContent = pageSearchKeyword.getSearchContent();
		PageInfo<Keyword> keywordList = null;
		try {
			searchContent = URLDecoder.decode(searchContent, "UTF-8");
			PageHelper.startPage(pageSearchKeyword.getPageNum(), pageSize);
			keywordList = ((Page<Keyword>)keywordDao.daoSelectKeywordBySearch(searchContent)).toPageInfo();	
		} catch (Exception e) {
			log.error("解码失败或查询不到("+searchContent+")相关的关键字内容！"+e.toString());	
		}
		searchContent = FormatConverter.getSQLStrFromSearchStr(searchContent);
		
		return getTopicPostParam(keywordList,searchContent);
	}
	
	@Override
	public PageInfo<TopicPostParam> selectAllTopicPost(int pageNum){
		int pageSize = 10;
		PageInfo<TopicPost> topicPostList = new PageInfo<TopicPost>();//主题帖表
		try {
			PageHelper.startPage(pageNum, pageSize);
			topicPostList =  ((Page<TopicPost>)topicPostDao.daoSelectAllTopicPost()).toPageInfo();
		} catch (Exception e) {
			log.error("查询状态正常的主题帖失败！"+e.toString());
			e.printStackTrace();
		}
		return getTopicPostParam(topicPostList);
	}
	
	@Override
	public PageInfo<TopicPostParam> selectAllExamineTopicPost(int pageNum) {
		int pageSize = 10;
		PageInfo<TopicPost> topicPostList = new PageInfo<TopicPost>();//主题帖表
		try {
			PageHelper.startPage(pageNum, pageSize);
			topicPostList =  ((Page<TopicPost>)topicPostDao.daoSelectAllExamineTopicPost()).toPageInfo();
		} catch (Exception e) {
			log.error("查询状态正常的主题帖失败！"+e.toString());
			e.printStackTrace();
		}
		return getTopicPostParam(topicPostList);
	}
	
	@Override
	public PageInfo<TopicPostParam> selectAllPublicTopicPost(int pageNum) {
		int pageSize = 10;
		PageInfo<TopicPost> topicPostList = new PageInfo<TopicPost>();//主题帖表
		try {
			PageHelper.startPage(pageNum, pageSize);
			topicPostList =  ((Page<TopicPost>)topicPostDao.daoSelectAllPublicTopicPost()).toPageInfo();
		} catch (Exception e) {
			log.error("查询状态正常的主题帖失败！"+e.toString());
			e.printStackTrace();
		}
		return getTopicPostParam(topicPostList);
	}
	
	/**
	 * 将PageInfo<TopicPost>转为PageInfo<TopicPostParam>
	 * @param topicPostList 主题帖集合
	 * @return 主题帖+关键字 集合
	 */
	private PageInfo<TopicPostParam> getTopicPostParam(PageInfo<TopicPost> topicPostList){
		PageInfo<TopicPostParam> result = new PageInfo<TopicPostParam>();
		List<TopicPostParam> list = new ArrayList<TopicPostParam>();
		try {
			for(int i = 0 ; i < topicPostList.getList().size() ; i++){
				list.add((new TopicPostParam(topicPostList.getList().get(i),selectKeywordStrByTopicPostId(topicPostList.getList().get(i).getId()))));
			}
		} catch (Exception e) {
			log.error("取不到主题帖" + e.toString());
		}
		result.setList(list);
		result.setPageNum(topicPostList.getPageNum());
		result.setPageSize(topicPostList.getPageSize());
		result.setSize(topicPostList.getSize());
		result.setTotal(topicPostList.getTotal());
		result.setPages(topicPostList.getPages());
		result.setPrePage(topicPostList.getPrePage());
		result.setNextPage(topicPostList.getNextPage());
		result.setIsFirstPage(topicPostList.isIsFirstPage());
		result.setIsLastPage(topicPostList.isIsLastPage());
		
		return result;
	}
	
	/**
	 * 将PageInfo<Keyword>转为PageInfo<TopicPostParam>
	 * @param keywordList 关键字集合
	 * @param searchContent 搜索内容
	 * @return 主题帖+关键字 集合
	 */
	private PageInfo<TopicPostParam> getTopicPostParam(PageInfo<Keyword> keywordList,String searchContent){
		PageInfo<TopicPostParam> result = new PageInfo<TopicPostParam>();
		List<TopicPostParam> list = new ArrayList<TopicPostParam>();
		try {
			for(int i = 0 ; i < keywordList.getList().size() ; i++){
				String topicPostId = keywordList.getList().get(i).getTopicPostId();
				String content = keywordList.getList().get(i).getContent();
				list.add(new TopicPostParam(topicPostDao.daoSelectTopicPostById(topicPostId),content));
			}
		} catch (Exception e) {
			log.info("查询不到相关内容的主题帖！ 查询内容为("+searchContent+")"+e.toString());
		}
		result.setList(list);
		result.setPageNum(keywordList.getPageNum());
		result.setPageSize(keywordList.getPageSize());
		result.setSize(keywordList.getSize());
		result.setTotal(keywordList.getTotal());
		result.setPages(keywordList.getPages());
		result.setPrePage(keywordList.getPrePage());
		result.setNextPage(keywordList.getNextPage());
		result.setIsFirstPage(keywordList.isIsFirstPage());
		result.setIsLastPage(keywordList.isIsLastPage());
		
		return result;
	}
	
	/**
	 * 将PageInfo<TopicPost>转为PageInfo<TopicPostParam>并做内容做提取处理
	 * @param topicPostList 主题帖集合
	 * @param searchContent 搜索内容
	 * @return 主题帖+关键字 集合
	 */
	private PageInfo<TopicPostParam> getTopicPostParamFromTopicPost(PageInfo<TopicPost> topicPostList,String searchStr){
		PageInfo<TopicPostParam> result = new PageInfo<TopicPostParam>();
		List<TopicPostParam> list = new ArrayList<TopicPostParam>();
		try {
			for(int i = 0 ; i < topicPostList.getList().size() ; i++){
				String content = topicPostList.getList().get(i).getContent();
				content = FormatConverter.getStrFromHtmlStr(content);
				topicPostList.getList().get(i).setContent(FormatConverter.getSubStrFromContent(content, searchStr));
				list.add(new TopicPostParam(topicPostList.getList().get(i),selectKeywordStrByTopicPostId(topicPostList.getList().get(i).getId())));
			}
		} catch (Exception e) {
			log.error("取不到主题帖" + e.toString());
		}
		result.setList(list);
		result.setPageNum(topicPostList.getPageNum());
		result.setPageSize(topicPostList.getPageSize());
		result.setSize(topicPostList.getSize());
		result.setTotal(topicPostList.getTotal());
		result.setPages(topicPostList.getPages());
		result.setPrePage(topicPostList.getPrePage());
		result.setNextPage(topicPostList.getNextPage());
		result.setIsFirstPage(topicPostList.isIsFirstPage());
		result.setIsLastPage(topicPostList.isIsLastPage());
		
		return result;
	}
	
	/**
	 * 将PageInfo<ReplyPost>转为PageInfo<SelectReplyPostBySearchParam>并做内容做提取处理
	 * @param replyPostList 回复帖集合
	 * @param searchContent 搜索内容
	 * @return 主题帖+回复贴 集合
	 */
	private PageInfo<SelectReplyPostBySearchParam> getReplyPostParamFromReplyPost(PageInfo<ReplyPost> replyPostList,String searchStr){
		PageInfo<SelectReplyPostBySearchParam> result = new PageInfo<SelectReplyPostBySearchParam>();
		List<SelectReplyPostBySearchParam> list = new ArrayList<SelectReplyPostBySearchParam>();
		try {
			for(int i = 0 ; i < replyPostList.getList().size() ; i++){
				String topicPostTitle = topicPostDao.daoSelectTopicPostById(replyPostList.getList().get(i).getTopicPostId()).getTitle();
				String content = replyPostList.getList().get(i).getContent();
				content = FormatConverter.getStrFromHtmlStr(content);
				replyPostList.getList().get(i).setContent(FormatConverter.getSubStrFromContent(content, searchStr));
				list.add(new SelectReplyPostBySearchParam(replyPostList.getList().get(i),topicPostTitle));
			}
		} catch (Exception e) {
			log.error("取不到主题帖" + e.toString());
		}
		result.setList(list);
		result.setPageNum(replyPostList.getPageNum());
		result.setPageSize(replyPostList.getPageSize());
		result.setSize(replyPostList.getSize());
		result.setTotal(replyPostList.getTotal());
		result.setPages(replyPostList.getPages());
		result.setPrePage(replyPostList.getPrePage());
		result.setNextPage(replyPostList.getNextPage());
		result.setIsFirstPage(replyPostList.isIsFirstPage());
		result.setIsLastPage(replyPostList.isIsLastPage());
		
		return result;
	}
}