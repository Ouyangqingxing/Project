package com.upsoft.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.upsoft.entity.Role;

public interface RoleServive {
	/**
	 * 通过id查看角色
	 * @param id
	 * @return 角色
	 */
	public Role SelectRoleById(String id);
	/**
	 * 通过name查看角色
	 * @param name:管理员/普通用户
	 * @return 角色
	 */
	public Role SelectRoleByName(String name);
	/**
	 * 查看所有角色
	 * @return 角色集合
	 */
	public List<Role> SelectAllRole();
	/**
	 * 通过用户名查角色
	 * @return 角色
	 */
	public Role SelectRoleByUserName(String userName);
}
