package com.upsoft.dao;

import java.util.List;

import org.springframework.stereotype.Component;

import com.upsoft.entity.ReplyPost;

@Component
public interface ReplyPostDao {
	/**
	 * 新增回复贴
	 * @param replyPost
	 */
	public void daoAddReplyPost(ReplyPost replyPost);
	/**
	 * 通过id删除回复贴
	 * @param id
	 */
	public void daoDeleteReplyPost(String id);
	/**
	 * 更新回复贴
	 * @param replyPost
	 */
	public void daoUpdateReplyPost(ReplyPost replyPost);
	/**
	 * 更新回复贴状态
	 * @param id
	 * @param state
	 */
	public void daoUpdateReplyPostState(String id,int state);
	/**
	 * 通过id查看回复贴
	 * @param id
	 * @return 回复贴
	 */
	public ReplyPost daoSelectReplyPostById(String id);
	/**
	 * 通过用户id查看回复贴
	 * @param userId
	 * @return 回复贴集合
	 */
	public List<ReplyPost> daoSelectReplyPostByUserId(String userId);
	/**
	 * 通过主题贴id查看回复贴
	 * @param topicPostId
	 * @return 回复贴集合
	 */
	public List<ReplyPost> daoSelectReplyPostByTopicPostId(String topicPostId);
	/**
	 * 通过搜索内容模糊匹配查看回复贴
	 * @param searchContent 搜索内容
	 * @return 回复贴集合
	 */
	public List<ReplyPost> daoSelectReplyPostBySearch(String searchContent);
	/**
	 * 查看所有回复贴 
	 * @return 回复贴集合
	 */
	public List<ReplyPost> daoSelectAllReplyPost();
}