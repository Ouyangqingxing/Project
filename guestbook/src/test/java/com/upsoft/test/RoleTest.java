package com.upsoft.test;

import java.io.Serializable;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.upsoft.dao.RoleDao;
import com.upsoft.entity.Role;
import com.upsoft.util.IDGenerator;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath*:applicationContext.xml")
public class RoleTest implements Serializable{
	@Autowired
	private RoleDao role;
	
	/**
	 * 新增角色
	 * @param role
	 */@Test
	public void daoAddRole(){
		 Role managerRole = new Role(IDGenerator.getId(), "管454531ds31员");
		 role.daoAddRole(managerRole);
	 }
	/**
	 * 通过id删除角色
	 * @param id
	 */@Test
	public void daoDeleteRole(){
		 role.daoDeleteRole("865c18fd90de44ae8bfff7ffac132287");
	 }
	/**
	 * 修改角色
	 * @param role
	 */@Test
	public void daoUpdateRole(){
		 Role updateRole = new Role("f82c1bbf47a24bc980aaffb9a70569cb","管理员吗");
		 role.daoUpdateRole(updateRole);
		 
	 }
	/**
	 * 通过id查看角色
	 * @param id
	 * @return 角色
	 */@Test
	public void daoSelectRoleById(){
		System.out.println(role.daoSelectRoleById("f82c1bbf47a24bc980aaffb9a70569cb")); 
	 }
	/**
	 * 查看所有角色
	 * @return 角色集合
	 */@Test
	public void daoSelectAllRole(){
		 List<Role> lists = role.daoSelectAllRole();
		 for (Role role : lists) {
			System.out.println();
			System.out.println(role);
			System.out.println();
		}
		 
	 }
	 @Test
	 public void selectRoleByName(){
		 Role r = role.daoSelectRoleByName("管理员");
		 System.out.println();
		 System.out.println();
		 System.out.println();
		 System.out.println(r);
		 System.out.println();
		 System.out.println();
		 System.out.println();
		 System.out.println();
	 }
	 @Test
	 public void selectRoleByUserName(){
		 Role r = role.daoselectRoleByUserName("admin123");
		 System.out.println();
		 System.out.println();
		 System.out.println();
		 System.out.println();
		 System.out.println(r);
		 System.out.println();
		 System.out.println();
		 System.out.println();
		 System.out.println();
	 }
	 
}