package com.upsoft.dao;

import java.util.List;
import org.springframework.stereotype.Component;
import com.upsoft.entity.User;

@Component
public interface UserDao {
	/**
	 * 通过用户名,密码
	 * @param username
	 * @param pwd
	 * @return User对象
	 */
	public User daoCheckLogin(String username , String pwd);
	/**
	 * 新增用户,必须调用daoAddUserRole
	 * @param user
	 */
	public void daoAddUser(User user);
	/**
	 * 注册时必须调用赋值管理员权限
	 * @param userId
	 * @param roleId
	 */
	public void daoAddUserRole(String userId , String roleId);
	/**
	 * 更新用户密码
	 * @param id
	 * @param password
	 */
	public void daoUpdatePassword(String id,String password);
	/**
	 * 更新用户发帖数(+1)
	 * @param id
	 * @param postNumber
	 */
	public void daoUpdatePostNumber(String id);
	/**
	 * 更新用户状态
	 * @param id
	 * @param state
	 */
	public void daoUpdateState(String id,int state);
	/**
	 * 更新用户信息
	 * @param user
	 */
	public void daoUpdateUser(User user);
	
	/**
	 * 通过用户ID修改用户权限
	 * @param userId
	 * @param roleId
	 */
	
	public void daoUpdateUserRole(String userId , String roleId);
	/**
	 * 通过id查看用户
	 * @param id
	 * @return 用户
	 */
	public User daoSelectUserById(String id);
	/**
	 * 通过用户名查看用户
	 * @param 用户名
	 * @return 用户
	 */
	public User daoSelectUserByName(String Name);
	/**
	 * 通过内容查看用户集合
	 * @param 内容
	 * @return 用户集合
	 */
	public List<User> daoSelectUserByContent(String content);
	/**
	 * 查看所有用户,除了当前用户
	 * @return 用户集合
	 */
	public List<User> daoSelectAllUser(String id);
}	