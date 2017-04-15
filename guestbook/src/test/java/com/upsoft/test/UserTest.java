package com.upsoft.test;

import static org.junit.Assert.*;

import java.io.Serializable;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.upsoft.dao.UserDao;
import com.upsoft.entity.User;
import com.upsoft.util.IDGenerator;
import com.upsoft.util.MD5;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath*:applicationContext.xml")
public class UserTest implements Serializable{
	@Autowired
	private UserDao userdao;
	/**
	 * 通过用户名查看密码（判断密码是否正确）
	 * @param username
	 * @return 用户密码
	 */@Test
	public void daoCheckPassword(){
		 System.out.println();
		 System.out.println();
		 System.out.println();
		 System.out.println();
		System.out.println(userdao.daoCheckLogin("ninig",MD5.getMd5("123")));
		System.out.println("1111111111111111111111111111111");
		System.out.println("1111111111111111111111111111111");
		System.out.println("1111111111111111111111111111111");
		System.out.println("1111111111111111111111111111111");
		System.out.println();
		System.out.println();
		System.out.println();
	 }
	/**
	 * 新增用户
	 * @param user
	 */@Test
	public void daoAddUser(){
		 userdao.daoAddUser(new User(IDGenerator.getId(), "ninig",MD5.getMd5("123"), 21, 1));
	 }
	/**
	 * 更新用户密码
	 * @param id
	 * @param password
	 */@Test
	public void daoUpdatePassword(){
		 userdao.daoUpdatePassword("a1af2aed148048b8a6bf8fbaf47a63b9", MD5.getMd5("123453"));
	 }
	/**
	 * 更新用户发帖数(+1)
	 * @param id
	 * @param postNumber
	 */@Test
	public void daoUpdatePostNumber(){
		 userdao.daoUpdatePostNumber("a1af2aed148048b8a6bf8fbaf47a63b9");
	 }
	/**
	 * 更新用户状态
	 * @param id
	 * @param state
	 */@Test
	public void daoUpdateState(){
		 userdao.daoUpdateState("a1af2aed148048b8a6bf8fbaf47a63b9", 5);
	 }
	/**
	 * 更新用户信息
	 * @param user
	 */@Test
	public void daoUpdateUser(){
		 User user = new User("a1af2aed148048b8a6bf8fbaf47a63b9", "ninig",MD5.getMd5("123"), 21, 1);
		 userdao.daoUpdateUser(user);
	 }
	/**
	 * 通过id查看用户
	 * @param id
	 * @return 用户
	 */@Test
	public void daoSelectUserById(){
		 User user = userdao.daoSelectUserById("a1af2aed148048b8a6bf8fbaf47a63b9");
		 System.out.println(user);
	 }
	/**
	 * 查看所有用户
	 * @return 用户集合
	 */@Test
	public void daoSelectAllUser(){
		 List<User> users = userdao.daoSelectAllUser("");
		 for (User user : users) {
			System.out.println(user);
			System.out.println();
			System.out.println();
		}
	 }
	@Test
	public void daoAddUserRole() {
		userdao.daoAddUserRole(IDGenerator.getId(),IDGenerator.getId());
	}
	@Test
	public void daoupdateUserRole() {
		userdao.daoUpdateUserRole("a1af2aed148048b8a6bf8fbaf47a63b9", "bca3a39147ad4xxxxxxxxxxx5f9dc275");
	}
	@Test 
	public void daoSelectUserByName(){
		System.out.println(userdao.daoSelectUserByName("ninglanhao"));
	}
	@Test 
	public void daoSelectUserByContent(){
		List<User> users = userdao.daoSelectUserByContent("%i%");
		for (User user : users) {
			System.out.println(user);
			System.out.println();
			System.out.println();
			System.out.println();
		}
	}
	 
}