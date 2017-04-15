package com.upsoft.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.upsoft.dao.JurisdictionDao;
import com.upsoft.entity.Jurisdiction;


public interface JurisdictionService {
	
	/**
	 * 查找所有权限
	 * @return
	 */
	public List <Jurisdiction> selectedAllJurisdiction () ;
	/**
	 * 通过id找权限
	 * @param id
	 * @return
	 */
	public Jurisdiction selectedJurisdictionById (String id);
	/**
	 * 通过用户ID查权限
	 * @param UserId
	 * @return
	 */
	public List<Jurisdiction> selectedJurisdictionByUserId (String UserId);
	
	
}
