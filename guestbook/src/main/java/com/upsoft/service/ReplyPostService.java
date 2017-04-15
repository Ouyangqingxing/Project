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
import com.upsoft.entity.ReplyPost;
import com.upsoft.service.param.AddReplyPostParam;
import com.upsoft.service.param.PageContentsReplyPost;
import com.upsoft.service.param.PageCustInfoReplyPost;
import com.upsoft.service.param.SelectReplyPostByUserIdParam;
import com.upsoft.service.param.UpdateReplyPostStateParam;

@Path("/replypost")
public interface ReplyPostService {
	/**
	 * 新增回复贴
	 * @param replyPost
	 * @return 
	 */
	@Path("/user/add")
	@POST
	@Produces({ MediaType.APPLICATION_JSON })
	@Consumes({ MediaType.APPLICATION_JSON  })
	public boolean addReplyPost(AddReplyPostParam addReplyPostParm ,@Context HttpServletRequest request);
	
	/**
	 * 删除回复贴
	 * @param id
	 */
	@Path("/delete")
	@POST
	@Produces({ MediaType.APPLICATION_JSON })
	@Consumes({ MediaType.APPLICATION_JSON  })
	public void deleteReplyPost(String replyPostId,@Context HttpServletRequest request);
	
	/**
	 * 更新回复贴
	 * @param replyPost
	 */
	@Path("/update")
	@POST
	@Produces({ MediaType.APPLICATION_JSON })
	@Consumes({ MediaType.APPLICATION_JSON  })
	public void updateReplyPost(ReplyPost replyPost);
	
	/**
	 * 更新回复贴状态
	 * @param id
	 * @param state
	 */
	@Path("/admin/updateState")
	@POST
	@Produces({ MediaType.APPLICATION_JSON })
	@Consumes({ MediaType.APPLICATION_JSON  })
	public void updateReplyPostState(UpdateReplyPostStateParam updateReplyPostStateParam,@Context HttpServletRequest request);
	
	/**
	 * 通过id查看回复贴
	 * @param id
	 * @return 回复贴
	 */
	@Path("/selectreplypostbyid")
	@POST
	@Produces({ MediaType.APPLICATION_JSON })
	@Consumes({ MediaType.APPLICATION_JSON  })
	public ReplyPost selectReplyPostById(String replyPostId);
	
	/**
	 * 通过用户id查看回复贴
	 * @param userId
	 * @return 回复贴集合
	 */
	@Path("/selectreplypostbyuserid")
	@POST
	@Produces({ MediaType.APPLICATION_JSON })
	@Consumes({ MediaType.APPLICATION_JSON  })
	public PageInfo<SelectReplyPostByUserIdParam> selectReplyPostByUserId(PageCustInfoReplyPost pageCustInfoReplyPost ,@Context HttpServletRequest request);
	
	/**
	 * 通过主题贴id查看回复贴
	 * @param topicPostId
	 * @return 回复贴集合
	 */
	@Path("/selectreplypostbytopicpostid")
	@POST
	@Produces({ MediaType.APPLICATION_JSON })
	@Consumes({ MediaType.APPLICATION_JSON  })
	public PageInfo<ReplyPost> selectReplyPostByTopicPostId(PageContentsReplyPost pageReplyPost);
	
	/**
	 * 查看所有回复贴
	 * @return 回复贴集合
	 */
	@Path("/selectallreplypost")
	@POST
	@Produces({ MediaType.APPLICATION_JSON })
	@Consumes({ MediaType.APPLICATION_JSON  })
	public List<ReplyPost> selectAllReplyPost();
}