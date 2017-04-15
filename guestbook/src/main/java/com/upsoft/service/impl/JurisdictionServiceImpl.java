package com.upsoft.service.impl;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.upsoft.dao.JurisdictionDao;
import com.upsoft.dao.UserDao;
import com.upsoft.entity.Jurisdiction;
import com.upsoft.service.JurisdictionService;

@Service("jurisdictionRestService")
public class JurisdictionServiceImpl implements JurisdictionService {
	static Logger log = Logger.getLogger(JurisdictionServiceImpl.class);
	@Autowired
	private JurisdictionDao jurdao;
	@Autowired
	private UserDao userdao;
	@Override
	public List<Jurisdiction> selectedAllJurisdiction() {
		List<Jurisdiction> jurs = null;
		try {
			jurs = jurdao.daoSelectAllJurisdiction();
		} catch (Exception e) {
			log.error("查询所有权限失败"+e.toString());
			e.printStackTrace();
		}
		return jurs;
	}


	@Override
	public Jurisdiction selectedJurisdictionById(String id) {
		Jurisdiction jur = null;
		try {
			jur = jurdao.daoSelectJurisdictionById(id);
		} catch (Exception e) {
			log.error("id查询权限失败"+e.toString());
			e.printStackTrace();
		}
		return jur;
	}


	@Override
	public List<Jurisdiction> selectedJurisdictionByUserId(String id) {
		List<Jurisdiction> jurs = null;
		try {
			jurs = jurdao.daoSelectJurisdictionByUserId(id);
		} catch (Exception e) {
			log.error("用户id查询权限失败"+e.toString());
			e.printStackTrace();
		}
		return jurs;
	}

}
