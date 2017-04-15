package com.upsoft.service;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;

import com.github.pagehelper.PageInfo;
import com.upsoft.entity.Keyword;
import com.upsoft.entity.TopicPost;
import com.upsoft.service.param.AddTopicPostParam;
import com.upsoft.service.param.PageCustInfoTopicPost;
import com.upsoft.service.param.PageSearchContent;
import com.upsoft.service.param.PageSearchKeyword;
import com.upsoft.service.param.PageSearchReplyContent;
import com.upsoft.service.param.PageSearchTitle;
import com.upsoft.service.param.SelectReplyPostBySearchParam;
import com.upsoft.service.param.TopicPostParam;
import com.upsoft.service.param.UpdateTopicPostStateParam;

@Path("/topicpost")
public interface TopicPostService {
	/**
	 * 新增主题贴
	 * @return 
	 */
	@Path("/user/add")
	@POST
	@Produces({ MediaType.APPLICATION_JSON })
	@Consumes({ MediaType.APPLICATION_JSON  })
	public boolean addTopicPost(AddTopicPostParam addTopicPostParam ,@Context HttpServletRequest request);
	
	/**
	 * 删除主题帖
	 * @param topicPostId
	 */
	@Path("/user/delete")
	@POST
	@Produces({ MediaType.APPLICATION_JSON })
	@Consumes({ MediaType.APPLICATION_JSON  })
	public void deleteTopicPost(String topicPostId,@Context HttpServletRequest request);
	
	/**
	 * 更新主题帖
	 * @param topicPost
	 */
	@Path("/update")
	@POST
	@Produces({ MediaType.APPLICATION_JSON })
	@Consumes({ MediaType.APPLICATION_JSON  })
	public void updateTopicPost(TopicPost topicPost);

	/**
	 * 更新所有未通过审核的帖子为通过审核
	 */
	@Path("/admin/adoptalltopicpost")
	@POST
	@Produces({ MediaType.APPLICATION_JSON })
	@Consumes({ MediaType.APPLICATION_JSON  })
	public void adoptAllTopicPost();

	/**
	 * 更新主题帖状态
	 * @param topicPostId
	 * @param state
	 */
	@Path("/admin/updatestate")
	@POST
	@Produces({ MediaType.APPLICATION_JSON })
	@Consumes({ MediaType.APPLICATION_JSON  })
	public void updateTopicPostState(UpdateTopicPostStateParam updateTopicPostStateParam,@Context HttpServletRequest request);
	
	/**
	 * 通过id查看主题帖
	 * @param topicPostId
	 * @return 主题帖
	 */
	@Path("/selecttopicpostbyid")
	@POST
	@Produces({ MediaType.APPLICATION_JSON })
	@Consumes({ MediaType.APPLICATION_JSON  })
	public TopicPost selectTopicPostById(String topicPostId);
	
	/**
	 * 通过主题帖id查看关键字
	 * @param topicPostId
	 * @return 关键字集合
	 */
	@Path("/selectkeywordbytopicpostid")
	@POST
	@Produces({ MediaType.APPLICATION_JSON })
	@Consumes({ MediaType.APPLICATION_JSON  })
	public List<Keyword> selectKeywordByTopicPostId(String topicPostId);
	
	/**
	 * 通过主题帖id查看关键字（字符串形式）
	 * @param topicPostId
	 * @return
	 */
	@Path("/selectkeywordstrbytopicpostid")
	@POST
	@Produces({ MediaType.APPLICATION_JSON })
	@Consumes({ MediaType.APPLICATION_JSON  })
	public String selectKeywordStrByTopicPostId(String topicPostId);
	
	/**
	 * 通过用户id查看主题帖
	 * @param userId
	 * @return 主题帖集合
	 */
	@Path("/selecttopicpostbyuserid")
	@POST
	@Produces({ MediaType.APPLICATION_JSON })
	@Consumes({ MediaType.APPLICATION_JSON  })
	public PageInfo<TopicPostParam> selectTopicPostByUserId(PageCustInfoTopicPost pageCustInfoTopicPost,@Context HttpServletRequest request);
	
	/**
	 * 通过搜索内容匹配主题帖标题查看主题帖
	 * @param searchContent 查找内容
	 * @return 主题帖集合
	 */
	@Path("/selecttopicpostbysearchtitle")
	@POST
	@Produces({ MediaType.APPLICATION_JSON })
	@Consumes({ MediaType.APPLICATION_JSON  })
	public PageInfo<TopicPostParam> selectTopicPostBySearchTitle(PageSearchTitle pageSearchTitle);
	
	/**
	 * 通过搜索内容匹配主题帖内容查看主题帖
	 * @param searchContent 查找内容
	 * @return 主题帖集合
	 */
	@Path("/selecttopicpostbysearchcontent")
	@POST
	@Produces({ MediaType.APPLICATION_JSON })
	@Consumes({ MediaType.APPLICATION_JSON  })
	public PageInfo<TopicPostParam> selectTopicPostBySearchContent(PageSearchContent pageSearchContent);
	
	/**
	 * 通过搜索内容匹配回复帖内容查看主题帖
	 * @param searchContent
	 * @return
	 */
	@Path("/selecttopicpostbysearchreplypostcontent")
	@POST
	@Produces({ MediaType.APPLICATION_JSON })
	@Consumes({ MediaType.APPLICATION_JSON  })
	public PageInfo<SelectReplyPostBySearchParam> selectTopicPostBySearchReplyPostContent(PageSearchReplyContent pageSearchReplyContent);
	
	/**
	 * 通过搜索内容匹配关键字内容查看主题帖
	 * @param searchContent
	 * @return
	 */
	@Path("/selecttopicpostbysearchkeywordcontent")
	@POST
	@Produces({ MediaType.APPLICATION_JSON })
	@Consumes({ MediaType.APPLICATION_JSON  })
	public PageInfo<TopicPostParam> selectTopicPostBySearchKeywordContent(PageSearchKeyword PageSearchKeyword);
	
	/**
	 * 查看所有待审核状态的主题帖
	 * @param 查看的页数
	 * @return 主题帖集合
	 */
	@Path("/admin/selectallexaminetopicpost")
	@POST
	@Produces({ MediaType.APPLICATION_JSON })
	@Consumes({ MediaType.APPLICATION_JSON  })
	public PageInfo<TopicPostParam> selectAllExamineTopicPost(int pageNum);
	
	/**
	 * 查看所有正常状态的主题帖
	 * @param 查看的页数
	 * @return 主题帖集合
	 */
	@Path("/selectallpublictopicpost")
	@POST
	@Produces({ MediaType.APPLICATION_JSON })
	@Consumes({ MediaType.APPLICATION_JSON  })
	public PageInfo<TopicPostParam> selectAllPublicTopicPost(int pageNum);
	
	/**
	 * 查看所有通过审核的主题帖
	 * @return 主题帖集合
	 */
	@Path("/admin/selectalltopicpost")
	@POST
	@Produces({ MediaType.APPLICATION_JSON })
	@Consumes({ MediaType.APPLICATION_JSON  })
	public PageInfo<TopicPostParam> selectAllTopicPost(int pageNum);
}