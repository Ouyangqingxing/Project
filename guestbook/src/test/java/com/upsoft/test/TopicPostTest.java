package com.upsoft.test;

import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.upsoft.dao.TopicPostDao;
import com.upsoft.entity.TopicPost;
import com.upsoft.util.IDGenerator;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath*:applicationContext.xml")
public class TopicPostTest{
	@Autowired
	private TopicPostDao topicpostdao;
	
	Timestamp currentTime = new Timestamp(new Date().getTime());
	
	/**
	 * 新增主题贴
	 * @param topicPost
	 */@Test
	public void daoAddTopicPost(){
		TopicPost topicpost = new TopicPost(IDGenerator.getId(),IDGenerator.getId(),
			"maojianying","宝兰高铁今年内开通","较sadf为埃及sdf法你joaasdfijoij",currentTime,0,1);
		topicpostdao.daoAddTopicPost(topicpost);
	 }
	/**
	 * 通过id删除主题帖
	 * @param id
	 */@Test
	public void daoDeleteTopicPost(){
		 Timestamp currentTime = new Timestamp(new Date().getTime());
			TopicPost topicpost = new TopicPost(IDGenerator.getId(),IDGenerator.getId(),
					"Jason","中方回应赴韩封杀","较sadf为埃及sdf法你joaasdfijoij",currentTime,0,1);
		 topicpostdao.daoDeleteTopicPost("5037d3f2300b4305bdda9a39a009754b");
	 }
	/**
	 * 更新主题帖
	 * @param topicPost
	 */@Test
	public void daoUpdateTopicPost(){
		 Timestamp currentTime = new Timestamp(new Date().getTime());
			TopicPost topicpost = new TopicPost(IDGenerator.getId(),IDGenerator.getId(),"Jason123",
					"中方回应赴韩封杀","较sadf为埃及sdf法你joaasdfijoij",currentTime,0,1);
		 topicpost.setUserName("Jason well");
		topicpostdao.daoUpdateTopicPost(topicpost);
	 }
	/**
	 * 更新主题帖回复数（加一）
	 * @param id
	 */@Test
	public void daoUpdateTopicPostReplyNumber(){
		 topicpostdao.daoUpdateTopicPostReplyNumber("90e3c83f1c014468a5a672bdfbd8899d");
	 }
	/**
	 * 更新主题帖状态
	 * @param id
	 * @param state
	 */@Test
	public void daoUpdateTopicPostState(){
		 topicpostdao.daoUpdateTopicPostState("90e3c83f1c014468a5a672bdfbd8899d", 2);
	 }
	/**
	 * 通过id查看主题帖
	 * @param id
	 * @return 主题帖
	 */@Test
	public void daoSelectTopicPostById(){
		 System.out.println(topicpostdao.daoSelectTopicPostByUserId("78aea787a12441fcaf45d2e7a467fcdf"));
	 }
	/**
	 * 通过用户id查看主题帖
	 * @param userId
	 * @return 主题帖集合
	 */@Test
	public void daoSelectTopicPostByUserId(){
		 System.out.println(topicpostdao.daoSelectTopicPostByUserId("78aea787a12441fcaf45d2e7a467fcdf"));
	 }
	/**
	 * 通过搜索内容模糊匹配查看主题帖
	 * @param searchContent 搜索内容
	 * @return 主题帖集合
	 */@Test
	public void daoSelectTopicPostBySearch(){
		 String searchContent = "%较%";
		 List<TopicPost> posts = topicpostdao.daoSelectTopicPostBySearch(searchContent);
		 for (TopicPost topicPost : posts) {
			System.out.println(topicPost);
		}
	 }
	/**
	 * 查看所有主题帖
	 * @return 主题帖集合
	 */@Test
	public void daoSelectAllTopicPost(){
		 List<TopicPost> posts = topicpostdao.daoSelectAllTopicPost();
		 for (TopicPost topicPost : posts) {
			System.out.println(topicPost);
		}
	 }
}