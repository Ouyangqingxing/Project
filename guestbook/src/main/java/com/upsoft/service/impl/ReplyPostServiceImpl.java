package com.upsoft.service.impl;

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
import com.upsoft.dao.ReplyPostDao;
import com.upsoft.dao.TopicPostDao;
import com.upsoft.dao.UserDao;
import com.upsoft.entity.ReplyPost;
import com.upsoft.entity.User;
import com.upsoft.service.ReplyPostService;
import com.upsoft.service.param.AddReplyPostParam;
import com.upsoft.service.param.PageContentsReplyPost;
import com.upsoft.service.param.PageCustInfoReplyPost;
import com.upsoft.service.param.SelectReplyPostByUserIdParam;
import com.upsoft.service.param.UpdateReplyPostStateParam;
import com.upsoft.util.IDGenerator;

@Component
public class ReplyPostServiceImpl implements ReplyPostService{
	static Logger log = Logger.getLogger(ReplyPostServiceImpl.class);
	
	@Autowired
	private TopicPostDao topicPostDao;
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
	public boolean addReplyPost(AddReplyPostParam addReplyPostParam , HttpServletRequest request){
		Timestamp currentTime = new Timestamp(new Date().getTime());
		HttpSession session = request.getSession();
		User user = (User) session.getAttribute("user");
		if(user.getState() > 0){
			int floor = 0;
			try {
				floor = topicPostDao.daoSelectTopicPostById(addReplyPostParam.getTopicPostId()).getReplyNumber() + 1;
				ReplyPost replypost = new ReplyPost(IDGenerator.getId(),user.getId(),user.getName(),addReplyPostParam.getTopicPostId(),addReplyPostParam.getContent(),currentTime,floor,1);
				replyPostDao.daoAddReplyPost(replypost);
				topicPostDao.daoUpdateTopicPostReplyNumber(addReplyPostParam.getTopicPostId());
				userDao.daoUpdatePostNumber(user.getId());
				log.info("新增回复贴成功，userId = "+user.getId()+" username = "+user.getName());
				return true;
			} catch (Exception e) {
				log.error("新增回复贴失败 "+e.toString());
				e.printStackTrace();
				return false;
			}
		}
		return false;
	}
	
	@Override
	public void deleteReplyPost(String replyPostId, HttpServletRequest request){
		if(checkLogin(request)){
			replyPostId = replyPostId.replace("\"", "");
			try {
				replyPostDao.daoDeleteReplyPost(replyPostId);
				log.info("删除回复贴成功");
			} catch (Exception e) {
				log.error("删除回复贴失败！"+e.toString());
				e.printStackTrace();
			}
		}
	}
	
	@Override
	public void updateReplyPost(ReplyPost replyPost){
		try {
			replyPostDao.daoUpdateReplyPost(replyPost);
			log.info("修改回复贴成功");
		} catch (Exception e) {
			log.error("修复回复贴失败！"+e.toString());
			e.printStackTrace();
		}
	}
	
	@Override
	public void updateReplyPostState(UpdateReplyPostStateParam updateReplyPostStateParam, HttpServletRequest request){
		if(checkLogin(request)){
			try {
				replyPostDao.daoUpdateReplyPostState(updateReplyPostStateParam.getReplyPostId(), updateReplyPostStateParam.getState());
				log.info("更新回帖贴状态成功");
			} catch (Exception e) {
				log.error("更新回复贴状态失败！"+e.toString());
				e.printStackTrace();
			}
		}
	}
	
	@Override
	public ReplyPost selectReplyPostById(String replyPostId){
		ReplyPost result = new ReplyPost();
		try {
			result = replyPostDao.daoSelectReplyPostById(replyPostId);
		} catch (Exception e) {
			log.error("查询回复贴失败！"+e.toString());
			e.printStackTrace();
		}
		return result;
	}
	
	@Override
	public PageInfo<SelectReplyPostByUserIdParam> selectReplyPostByUserId(PageCustInfoReplyPost pageCustInfoReplyPost,HttpServletRequest request){	
		String userId = pageCustInfoReplyPost.getUserId();
		if(userId == null || userId.equals("")){
			HttpSession session = request.getSession();
			userId = ( (User)session.getAttribute("user") ).getId();
		}
		
		int pageSize = 10;
		PageInfo<ReplyPost> replyPostList = new PageInfo<ReplyPost>();
		try {
			PageHelper.startPage(pageCustInfoReplyPost.getPageNum(), pageSize);
			replyPostList = ((Page<ReplyPost>)replyPostDao.daoSelectReplyPostByUserId(userId)).toPageInfo();
			
		} catch (Exception e) {
			log.error("查询回复贴失败！"+e.toString());
			e.printStackTrace();
		}
		return getReplyPostParam(replyPostList);
	}
	
	/**
	 * 将回复贴信息转换为回复贴整合信息
	 * @param replyPostList 回复贴集合
	 * @return 整合信息集合
	 */
	private PageInfo<SelectReplyPostByUserIdParam> getReplyPostParam(PageInfo<ReplyPost> replyPostList){
		PageInfo<SelectReplyPostByUserIdParam> result = new PageInfo<SelectReplyPostByUserIdParam>();
		List<SelectReplyPostByUserIdParam> list = new ArrayList<SelectReplyPostByUserIdParam>();
		try {
			for(int i = 0 ; i < replyPostList.getList().size() ; i++){
				String topicPostId = replyPostList.getList().get(i).getTopicPostId();
				String topicPostTitle = topicPostDao.daoSelectTopicPostById(topicPostId).getTitle();
				list.add(new SelectReplyPostByUserIdParam(replyPostList.getList().get(i).getId(),topicPostId,topicPostTitle,replyPostList.getList().get(i).getContent(),replyPostList.getList().get(i).getTime()));
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
	
	@Override
	public PageInfo<ReplyPost> selectReplyPostByTopicPostId(PageContentsReplyPost pageReplyPost){
		int pageSize = 20;
		PageInfo<ReplyPost> result = new PageInfo<ReplyPost>();
		try {
			PageHelper.startPage(pageReplyPost.getPageNum(), pageSize);
			result = ((Page<ReplyPost>) replyPostDao.daoSelectReplyPostByTopicPostId(pageReplyPost.getTopicPostId())).toPageInfo();
		} catch (Exception e) {
			log.error("查询回复贴失败！"+e.toString());
			e.printStackTrace();
		}
		return result;
	}
	
	@Override
	public List<ReplyPost> selectAllReplyPost(){
		List<ReplyPost> result = new ArrayList<ReplyPost>();
		try {
			result = replyPostDao.daoSelectAllReplyPost();
		} catch (Exception e) {
			log.error("查询回复贴失败！"+e.toString());
			e.printStackTrace();
		}
		return result;
	}
}