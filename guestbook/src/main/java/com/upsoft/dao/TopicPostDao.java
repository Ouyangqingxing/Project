package com.upsoft.dao;

import java.util.List;

import org.springframework.stereotype.Component;

import com.upsoft.entity.TopicPost;

@Component
public interface TopicPostDao {
	/**
	 * 新增主题贴
	 * @param topicPost
	 */
	public void daoAddTopicPost(TopicPost topicPost);
	/**
	 * 通过id删除主题帖
	 * @param id
	 */
	public void daoDeleteTopicPost(String id);
	/**
	 * 更新所有未通过审核的帖子为通过审核状态
	 */
	public void daoAdoptAllTopicPost();
	/**
	 * 更新主题帖
	 * @param topicPost
	 */
	public void daoUpdateTopicPost(TopicPost topicPost);
	/**
	 * 更新主题帖回复数（加一）
	 * @param id
	 */
	public void daoUpdateTopicPostReplyNumber(String id);
	/**
	 * 更新主题帖状态
	 * @param id
	 * @param state
	 */
	public void daoUpdateTopicPostState(String id , int state);
	/**
	 * 通过id查看主题帖
	 * @param id
	 * @return 主题帖
	 */
	public TopicPost daoSelectTopicPostById(String id);
	/**
	 * 通过用户id查看主题帖
	 * @param userId
	 * @return 主题帖集合
	 */
	public List<TopicPost> daoSelectTopicPostByUserId(String userId);
	/**
	 * 通过搜索标题模糊匹配查看主题帖 
	 * @param searchContent 搜索内容
	 * @return 主题帖集合
	 */
	public List<TopicPost> daoSelectTopicPostByTitle(String searchContent);
	/**
	 * 通过搜索内容模糊匹配查看主题帖
	 * @param searchContent 搜索内容
	 * @return 主题帖集合
	 */
	public List<TopicPost> daoSelectTopicPostBySearch(String searchContent);
	
	/**
	 * 查看所有待审核状态的主题帖
	 * @return 主题帖集合
	 */
	public List<TopicPost> daoSelectAllExamineTopicPost();
	
	/**
	 * 查看所有状态正常的主题帖
	 * @return 主题帖集合
	 */
	public List<TopicPost> daoSelectAllPublicTopicPost();
	
	/**
	 * 查看所有主题帖
	 * @return 主题帖集合
	 */
	public List<TopicPost> daoSelectAllTopicPost();
}