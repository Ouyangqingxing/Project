package com.upsoft.dao;

import java.util.List;

import org.springframework.stereotype.Component;

import com.upsoft.entity.Role;

@Component
public interface RoleDao {
	/**
	 * 新增角色
	 * @param role
	 */
	public void daoAddRole(Role role);
	/**
	 * 通过id删除角色
	 * @param id
	 */
	public void daoDeleteRole(String id);
	/**
	 * 修改角色
	 * @param role
	 */
	public void daoUpdateRole(Role role);
	/**
	 * 通过id查看角色
	 * @param id
	 * @return 角色
	 */
	public Role daoSelectRoleById(String id);
	/**
	 * 通过role名查看角色
	 * @param 名字:管理员/普通用户
	 * @return 角色
	 */
	public Role daoSelectRoleByName(String name);
	/**
	 * 查看所有角色
	 * @return 角色集合
	 */
	public List<Role> daoSelectAllRole();
	/**
	 * 通过用户名查看角色
	 * @return 角色
	 */
	public Role daoselectRoleByUserName(String userName);
	
	
	
}