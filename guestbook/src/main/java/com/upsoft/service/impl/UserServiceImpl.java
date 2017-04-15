package com.upsoft.service.impl;

import java.net.URLDecoder;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.upsoft.dao.UserDao;
import com.upsoft.entity.Jurisdiction;
import com.upsoft.entity.Role;
import com.upsoft.entity.User;
import com.upsoft.service.JurisdictionService;
import com.upsoft.service.ReplyPostService;
import com.upsoft.service.RoleServive;
import com.upsoft.service.UserService;
import com.upsoft.service.param.CustAdminParam;
import com.upsoft.service.param.PageCustInfoReplyPost;
import com.upsoft.service.param.PageSearchUser;
import com.upsoft.service.param.StateParam;
import com.upsoft.service.param.UpdatePwdParam;
import com.upsoft.service.param.UserParam;
import com.upsoft.util.IDGenerator;
import com.upsoft.util.MD5;

@Service("userRestService")
public class UserServiceImpl implements UserService {
	static Logger log = Logger.getLogger(UserServiceImpl.class);
	
	@Autowired
	private UserDao userdao;
	@Autowired
	private JurisdictionService jurservice ;
	@Autowired
	private RoleServive roleService;
	@Autowired
	private ReplyPostService replyPostServive;
	
	@Override
	public boolean checkLogin(UserParam userParam, HttpServletRequest request) {
		User user = null;
		try {
			user = userdao.daoCheckLogin(userParam.getUserName(), MD5.getMd5(userParam.getPwd()));
			//存入session
			HttpSession session = request.getSession();
			if(user != null){
				session.setAttribute("user", user);
				List<Jurisdiction> jurs = jurservice.selectedJurisdictionByUserId(user.getId());
				session.setAttribute("jurs", jurs);
				log.info("登录成功，"+user);
				return true;
			} 
			log.info("用户不存在");
			return false;
		} catch (Exception e) {
			log.error("登录检查失败"+e.toString());
			e.printStackTrace();
			return false;
		}
	} 

	@Override
	public boolean addUser(UserParam userParam) {
		String name = userParam.getUserName();
		try {
			//判断是否已经存在用户
			User isExist = userdao.daoSelectUserByName(name);
			if( isExist != null){
				log.info("用户已经存在");
				return false;
			}
			//不存在，添加，并赋予普通用户权限
			User user = new User(IDGenerator.getId(),name , MD5.getMd5(userParam.getPwd()), 0, 1);
			userdao.daoAddUser(user);
			Role role = roleService.SelectRoleByName("普通用户");
			userdao.daoAddUserRole(user.getId(), role.getId());
			log.info("注册成功，userId = "+user.getId()+" username = "+name);
			return true;
		} catch (Exception e) {
			log.error("增加用户失败"+e.toString());
			e.printStackTrace();
			return false;
		}
	}

	@Override
	public boolean updatePassword(UpdatePwdParam param,HttpServletRequest request) {
		//得到当前存在session中的user ，先比较用户输入的原密码是否正确，再调用dao修改密码
		User user = (User) request.getSession().getAttribute("user");
		if(user == null){
			log.info("session中没有user对象");
			return false;
		}
		String id = user.getId();
		String oldPwd = param.getOldPwd();
		String newPwd = param.getNewPwd();
		boolean result = false;
		result = user.getPassword().equals(MD5.getMd5(oldPwd));
		try {
			if(result){
				userdao.daoUpdatePassword(id, MD5.getMd5(newPwd));
				log.info("修改密码成功，userId = "+user.getId()+" username = "+user.getName());
				return true;
			}
		} catch (Exception e) {
			log.error("更新密码失败"+e.toString());
			e.printStackTrace();
			return false;
		}
		return false;
		/*try {
			User trueUser = userdao.daoCheckLogin(user.getName(), MD5.getMd5(oldPwd));
			if(trueUser == null){
				return false;
			}
			userdao.daoUpdatePassword(id, MD5.getMd5(newPwd));
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}*/
	}

	@Override
	public boolean updatePostNumber(String id, int postNumber) {
		try {
			userdao.daoUpdatePostNumber(id);
			return true;
		} catch (Exception e) {
			log.error("更新回帖数失败"+e.toString());
			e.printStackTrace();
			return false;
		}
	}

	@Override
	public boolean updateState(StateParam stateParam) {
		if(stateParam == null){
			log.info("stateParam传值为空");
			return false;
		}
		try {
			//先customer表中更改状态，然后更改role_customer表中角色关联
			userdao.daoUpdateState(stateParam.getId(), stateParam.getState());
			Role role = roleService.SelectRoleByName("普通用户");
			userdao.daoUpdateUserRole(stateParam.getId(), role.getId());
			log.info("修改状态成功，userId = "+stateParam.getId()+" ，当前状态为："+stateParam.getState());
			return true;
		} catch (Exception e) {
			log.error("修改状态失败"+e.toString());
			e.printStackTrace();
			return false;
		}
	}

	@Override
	public boolean UpdateUserRole(String userID) {
		//去除json对象中的引号
		userID = userID.replace("\"", "");
		//得到指定用户的名字即可获得角色名 ，通过角色更新角色状态
		try {
			String userName = this.selectUserById(userID).getName();
			String roleName = roleService.SelectRoleByUserName(userName).getName();
			if("普通用户".equals(roleName)){
				roleName = "管理员";
			}else {
				roleName = "普通用户";
			}
			Role role = roleService.SelectRoleByName(roleName);
			userdao.daoUpdateUserRole(userID, role.getId());
			log.info("更新管理员状态成功，用户ID为："+userID+",当前角色为'"+roleName+"'");
			return true;
		} catch (Exception e) {
			log.error("设置管理员状态失败"+e.toString());
			e.printStackTrace();
			return false;
		}
		
	}
	
	@Override
	public User selectUserById(String id) {
		User user = null;
		try {
			user = userdao.daoSelectUserById(id);
		} catch (Exception e) {
			log.error("查询用户失败"+e.toString());
			e.printStackTrace();
		}
		return user;
	}

	@Override
	public PageInfo<User> selectUserByContent(PageSearchUser pageUser) {
		int pageSize = 10;
		String content = pageUser.getSearchContent();
		PageInfo<User> users = new PageInfo<User>();
		try {
			content = URLDecoder.decode(content, "UTF-8");
			content = "%"+content+"%";
			PageHelper.startPage(pageUser.getPageNum(), pageSize);
			users = ((Page<User>)userdao.daoSelectUserByContent(content)).toPageInfo();
		} catch (Exception e) {
			log.error("搜索内容查询失败"+e.toString());
			e.printStackTrace();
		}
		return users;
	}

	@Override
	public PageInfo<CustAdminParam> selectAllUser(int pageNum , HttpServletRequest request) {
		int pageSize = 10;
		User currentUser = (User) request.getSession().getAttribute("user");
		if (currentUser == null){
			log.info("session中没有user");
			return null;
		}
		String id = currentUser.getId();
		PageInfo<User> users = new PageInfo<User>();
		
		try {
			PageHelper.startPage(pageNum, pageSize);
			users = ((Page<User>)userdao.daoSelectAllUser(id)).toPageInfo();
		} catch (Exception e) {
			log.error("查询所有用户失败"+e.toString());
			e.printStackTrace();
		}
		return getCustAdminParam(users,request);
	}
	/**
	 * 将user类型转换为custAdminParam类型 传送到cust_admin页面
	 * @param users
	 * @param request
	 * @return
	 */
	private PageInfo<CustAdminParam> getCustAdminParam(PageInfo<User> users,HttpServletRequest request){
		PageInfo<CustAdminParam> result = new PageInfo<CustAdminParam>();
		List<CustAdminParam> list = new ArrayList<CustAdminParam>();
		for(int i = 0 ; i < users.getList().size() ; i++){
			User theUser = users.getList().get(i);
			PageCustInfoReplyPost pcirp = new PageCustInfoReplyPost(theUser.getId(),1);
			int replyNumber = (int)replyPostServive.selectReplyPostByUserId(pcirp, request).getTotal();
			Role role = roleService.SelectRoleByUserName(theUser.getName());
			String roleName = role.getName();
			CustAdminParam cap = new CustAdminParam(users.getList().get(i),replyNumber,roleName);
			list.add(cap);
		}
		result.setList(list);
		result.setPageNum(users.getPageNum());
		result.setPageSize(users.getPageSize());
		result.setSize(users.getSize());
		result.setTotal(users.getTotal());
		result.setPages(users.getPages());
		result.setPrePage(users.getPrePage());
		result.setNextPage(users.getNextPage());
		result.setIsFirstPage(users.isIsFirstPage());
		result.setIsLastPage(users.isIsLastPage());
		
		return result;
	}

	@Override
	public boolean logout(HttpServletRequest request) {
		HttpSession session = request.getSession();
		session.removeAttribute("user");
		session.removeAttribute("jurs");
		return true;
	
	}
}