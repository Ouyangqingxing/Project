package com.upsoft.service;

import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;

import com.github.pagehelper.PageInfo;
import com.upsoft.entity.User;
import com.upsoft.service.param.CustAdminParam;
import com.upsoft.service.param.PageSearchUser;
import com.upsoft.service.param.StateParam;
import com.upsoft.service.param.UpdatePwdParam;
import com.upsoft.service.param.UserParam;

@Path("/user")
public interface UserService {
	
	/**
	 * 将用户名密码进行正确性检查
	 * @param username
	 * @param password
	 * @return 检查结果
	 */
	@Path("/checklogin")
	@POST
	@Produces({ MediaType.APPLICATION_JSON + "; " + MediaType.CHARSET_PARAMETER + "=UTF-8" })
	@Consumes({ MediaType.APPLICATION_JSON + "; " + MediaType.CHARSET_PARAMETER + "=UTF-8" })
	public boolean checkLogin(UserParam userParam ,@Context HttpServletRequest request) ;
	/**
	 * 注销
	 * @return 注销结果
	 */
	@Path("/logout")
	@POST
	@Produces({ MediaType.APPLICATION_JSON + "; " + MediaType.CHARSET_PARAMETER + "=UTF-8" })
	@Consumes({ MediaType.APPLICATION_JSON + "; " + MediaType.CHARSET_PARAMETER + "=UTF-8" })
	public boolean logout(@Context HttpServletRequest request) ;
	/**
	 * 
	 * @param user
	 * @return true : 增加成功
	 * 			false : 增加失败
	 */
	@Path("/regist")
	@POST
	@Produces({ MediaType.APPLICATION_JSON })
	@Consumes({ MediaType.APPLICATION_JSON  })
	public boolean addUser(UserParam userParam);
	/**
	 * 修改密码 
	 * @param id
	 * @param password
	 * @return 是否成功
	 */
	@Path("/update")
	@POST
	@Produces({ MediaType.APPLICATION_JSON + "; " + MediaType.CHARSET_PARAMETER + "=UTF-8" })
	@Consumes({ MediaType.APPLICATION_JSON + "; " + MediaType.CHARSET_PARAMETER + "=UTF-8" })
	public boolean updatePassword(UpdatePwdParam param,@Context HttpServletRequest request);
	/**
	 * 更新用户发帖数(+1)
	 * @param id
	 * @param postNumber
	 */
	public boolean updatePostNumber(String id,int postNumber);
	/**
	 * 更新用户状态
	 * @param id
	 * @param state
	 */
	@Path("/state")
	@POST
	@Produces({ MediaType.APPLICATION_JSON + "; " + MediaType.CHARSET_PARAMETER + "=UTF-8" })
	@Consumes({ MediaType.APPLICATION_JSON + "; " + MediaType.CHARSET_PARAMETER + "=UTF-8" })
	public boolean updateState(StateParam stateParam);
	/**
	 * 通过用户ID设置成为管理员
	 * @param userID
	 * @return
	 */
	@Path("/beadmin")
	@POST
	@Produces({ MediaType.APPLICATION_JSON + "; " + MediaType.CHARSET_PARAMETER + "=UTF-8" })
	@Consumes({ MediaType.APPLICATION_JSON + "; " + MediaType.CHARSET_PARAMETER + "=UTF-8" })
	public boolean UpdateUserRole(String userID);
	/**
	 * 通过id查看用户
	 * @param id
	 * @return 用户
	 */
	public User selectUserById(String id);  
	/**
	 * 通过搜索内容查找用户集合
	 * @param content
	 * @return 用户集合
	 */
	@Path("/content")
	@POST
	@Produces({ MediaType.APPLICATION_JSON + "; " + MediaType.CHARSET_PARAMETER + "=UTF-8" })
	@Consumes({ MediaType.APPLICATION_JSON + "; " + MediaType.CHARSET_PARAMETER + "=UTF-8" })
	public PageInfo<User> selectUserByContent(PageSearchUser pageUser);  
	/**
	 * 查看所有用户
	 * @return 用户集合
	 */
	@Path("/alluser")
	@POST
	@Produces({ MediaType.APPLICATION_JSON })
	@Consumes({ MediaType.APPLICATION_JSON })
	public PageInfo<CustAdminParam> selectAllUser(int pageNum ,@Context HttpServletRequest request);
}
