package com.upsoft.dao;

import java.util.List;

import org.springframework.stereotype.Component;

import com.upsoft.entity.Jurisdiction;

@Component
public interface JurisdictionDao {
	/**
	 * 新增权限
	 * @param jur 权限
	 */
	public void daoAddJurisdiction(Jurisdiction jur);
	/**
	 * 通过id删除权限
	 * @param id
	 */
	public void daoDeleteJurisdiction(String id);
	/**
	 * 修改权限
	 * @param jur
	 */
	public void daoUpdateJurisdiction(Jurisdiction jur);
	/**
	 * 通过id查看权限
	 * @param id
	 * @return 权限
	 */
	public Jurisdiction daoSelectJurisdictionById(String id);
	/**
	 * 查看所有权限
	 * @return 权限集合
	 */
	public List<Jurisdiction> daoSelectAllJurisdiction();
	/**
	 * 通过用户id查看权限
	 * @return 权限集合
	 */
	public List<Jurisdiction> daoSelectJurisdictionByUserId(String userId);
}