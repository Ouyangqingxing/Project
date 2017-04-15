package com.upsoft.service.impl;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.upsoft.dao.RoleDao;
import com.upsoft.entity.Role;
import com.upsoft.service.RoleServive;
@Service("roleRestService")
public class RoleServiveImpl implements RoleServive {
	static Logger log = Logger.getLogger(RoleServiveImpl.class);
	@Autowired
	private RoleDao roleDao ;
	
	@Override
	public Role SelectRoleById(String id) {
		Role role = null;
		try {
			role = roleDao.daoSelectRoleById(id);
		} catch (Exception e) {
			log.error("查询角色失败"+e.toString());
			e.printStackTrace();
		}
		return role;
	}

	@Override
	public List<Role> SelectAllRole() {
		List<Role> roles = null;
		try {
			roles = roleDao.daoSelectAllRole();
		} catch (Exception e) {
			log.error("查询所有角色失败"+e.toString());
			e.printStackTrace();
		}
		return roles;
	}

	@Override
	public Role SelectRoleByName(String name) {
		Role role = null;
		try {
			if(name != null && !name.equals("")){
				role = roleDao.daoSelectRoleByName(name);
			}
		} catch (Exception e) {
			log.error("查询指定角色失败"+e.toString());
			e.printStackTrace();
		}
		return role;
	}

	@Override
	public Role SelectRoleByUserName(String userName) {
		Role role = null;
		try {
			role = roleDao.daoselectRoleByUserName(userName);
		} catch (Exception e) {
			log.error("查询失败");
			e.printStackTrace();
		}
		return role;
	}

}
