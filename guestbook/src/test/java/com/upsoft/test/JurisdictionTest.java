package com.upsoft.test;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.upsoft.dao.JurisdictionDao;
import com.upsoft.entity.Jurisdiction;
import com.upsoft.util.IDGenerator;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath*:applicationContext.xml")
public class JurisdictionTest{
	@Autowired
	private JurisdictionDao jurdao;
	
	@Test
	public void addJurisdiction(){
		Jurisdiction managerJur = new Jurisdiction(IDGenerator.getId(),"管理员首页","/guestbook/admin/admin_index.html",1);
		jurdao.daoAddJurisdiction(managerJur);
	}
	@Test
	public void deleteJurisdiction(){
		jurdao.daoDeleteJurisdiction("32d61d3c691440abb42b7afbf9728534");
	}
	@Test
	public void UpdateJurisdiction(){
		Jurisdiction jur = new Jurisdiction("6545f0b14a2c43e68af4bb940d8b355a","lalala我被修改了","xxx.html",2);
		jurdao.daoUpdateJurisdiction(jur);
	}
	@Test
	public void SelectJurisdictionById(){
		Jurisdiction selected = jurdao.daoSelectJurisdictionById("6545f0b14a2c43e68af4bb940d8b355a");
		System.out.println();
		System.out.println();
		System.out.println();
		System.out.println();
		System.out.println();
		System.out.println();
		System.out.println(selected.toString()+"........");
		System.out.println();
		System.out.println();
		System.out.println();
		System.out.println();
		System.out.println();
		System.out.println();
		System.out.println();
		System.out.println();
	}
	@Test
	public void SelectAllJurisdiction(){
		List<Jurisdiction> list = jurdao.daoSelectAllJurisdiction();
		System.out.println("222222222222222222222222222222222222222222222222222222222222");
		for (Jurisdiction l:list){
			System.out.println(l);
		}
		System.out.println("22222222222222222222222222222222222222");
	}
	
	@Test
	public void selectJurByUserId(){
	List<Jurisdiction> jurs = jurdao.daoSelectJurisdictionByUserId("7d65c61dfd75433db6f40f23b9f78713");
		for (Jurisdiction jurisdiction : jurs) {
			System.out.println(jurisdiction);
			System.out.println("");
		}
	}
	
	
	
	
	
	
}