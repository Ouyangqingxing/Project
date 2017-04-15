package com.upsoft.test;

import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

import oracle.sql.DATE;
import oracle.sql.TIMESTAMP;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.upsoft.dao.ReplyPostDao;
import com.upsoft.entity.ReplyPost;
import com.upsoft.util.IDGenerator;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath*:applicationContext.xml")
public class ReplyPostTest {
	
	@Autowired
	private	ReplyPostDao replyDao ;
	/**
	 * 新增回复贴
	 * @param replyPost
	 */
	@Test
	public void AddReplyPost(){
		 ReplyPost rp = new ReplyPost(IDGenerator.getId(), IDGenerator.getId(), "水346", 
				 IDGenerator.getId(), "还2fwer", 
				 new Timestamp(new Date().getTime()), 22, 1);
		 replyDao.daoAddReplyPost(rp);
		
	}
	/**
	 * 通过id删除回复贴
	 * @param id
	 */@Test
	public void DeleteReplyPost(){
		 replyDao.daoDeleteReplyPost("123ba5eb564f4bb09ade8540e554a717");
	 }
	/**
	 * 更新回复贴
	 * @param replyPost
	 */@Test
	public void UpdateReplyPost(){
		 ReplyPost rp = new ReplyPost("ab5f0e81f84d4f439dcf285f7a5355cd", IDGenerator.getId(), "水346", 
				 IDGenerator.getId(), "还234asdsadasdds事", 
				 new Timestamp(new Date().getTime()), 22, 1);
		 replyDao.daoUpdateReplyPost(rp);
	 }
	/**
	 * 更新回复贴状态
	 * @param id
	 * @param state
	 */@Test
	public void UpdateReplyPostState(){
		 replyDao.daoUpdateReplyPostState("ab5f0e81f84d4f439dcf285f7a5355cd", 2);
	 }
	/**
	 * 通过id查看回复贴
	 * @param id
	 * @return 回复贴
	 */@Test
	public void SelectReplyPostById(){
		 List<ReplyPost> post = replyDao.daoSelectAllReplyPost();
		 System.out.println();
		 System.out.println();
		 System.out.println();
		 System.out.println();
		 for (ReplyPost replyPost : post) {
			System.out.println(replyPost);
		}
		 System.out.println();
		 System.out.println();
		 System.out.println();
	 }
	/**
	 * 通过用户id查看回复贴
	 * @param userId
	 * @return 回复贴集合
	 */@Test
	public void SelectReplyPostByUserId(){
		ReplyPost re = replyDao.daoSelectReplyPostById("ab5f0e81f84d4f439dcf285f7a5355cd");
		System.out.println();
		System.out.println();
		System.out.println();
		System.out.println();
		System.out.println(re);
		
	 }
	/**
	 * 通过主题贴id查看回复贴
	 * @param topicPostId
	 * @return 回复贴集合
	 */@Test
	public void SelectReplyPostByTopicPostId(){
		 System.out.println();
		 System.out.println();
		 System.out.println();
		 System.out.println();
		 System.out.println();
		 System.out.println(replyDao.daoSelectReplyPostById("ab5f0e81f84d4f439dcf285f7a5355cd"));
		 System.out.println();
		 System.out.println();
		 System.out.println();
		 System.out.println();
	 }
	/**
	 * 通过搜索内容模糊匹配查看回复贴
	 * @param searchContent 搜索内容
	 * @return 回复贴集合
	 */@Test
	public void SelectReplyPostBySearch(){
		 System.out.println(replyDao.daoSelectReplyPostBySearch("%还%"));
		 System.out.println();
		 System.out.println();
		 System.out.println();
		 System.out.println();
		 System.out.println();
		 System.out.println();
	 }
	/**
	 * 查看所有回复贴 
	 * @return 回复贴集合
	 */@Test
	public void SelectAllReplyPost(){
		 List<ReplyPost> posts = replyDao.daoSelectAllReplyPost();
		 for (ReplyPost replyPost : posts) {
			 System.out.println();
			 System.out.println();
			 System.out.println();
			System.out.println(replyPost);
			System.out.println();
			System.out.println();
			System.out.println();
		}
	 }
}