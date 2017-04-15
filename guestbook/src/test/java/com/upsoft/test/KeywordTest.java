package com.upsoft.test;

import java.io.Serializable;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.upsoft.dao.KeywordDao;
import com.upsoft.entity.Keyword;
import com.upsoft.util.IDGenerator;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath*:applicationContext.xml")
public class KeywordTest{
	@Autowired
	private KeywordDao keydao;
	
	/**
	 * 新增关键字
	 * @param keyword
	 */
	@Test
	public void AddKeyword(){
		Keyword key = new Keyword(IDGenerator.getId(), "woshitopicid123123123", "关键1241345测4");
		keydao.daoAddKeyword(key);
	}
	/**
	 * 通过id删除关键字
	 * @param id
	 */
	@Test
	public void DeleteKeyword(){
		keydao.daoDeleteKeyword("c9d2e3fe3c494c42bf7f8bf6ac4b7408");
	}
	/**
	 * 更新关键字
	 * @param keyword
	 */
	@Test
	public void UpdateKeyword(){
		
		keydao.daoUpdateKeyword(new Keyword("58aca9af43594775a7fa5ee78e1e39dd", 
				"testtopicIdupdate", 
				"修改后的内容"));
	}
	/**
	 * 通过id查看关键字
	 * @param id
	 * @return 关键字
	 */
	@Test
	public void SelectKeywordById(){
		Keyword key = keydao.daoSelectKeywordById("58aca9af43594775a7fa5ee78e1e39dd");
		System.out.println();
		System.out.println();
		System.out.println();
		System.out.println();
		System.out.println(key);
		System.out.println();
		System.out.println();
		System.out.println();
		System.out.println();
		
	}
	/**
	 * 通过主题帖id查看关键字
	 * @param id 主题帖id
	 * @return 关键字集合
	 */
	@Test
	public void SelectKeywordByTopicPostId(){
		System.out.println("22222222222222222222222");
		System.out.println();
		System.out.println();
		System.out.println();
		List<Keyword> list = keydao.daoSelectKeywordByTopicPostId("testtopicIdupdate               ");
		for (Keyword k : list) {
			System.out.println(k);
		}
		System.out.println();
		System.out.println();
		System.out.println();
		System.out.println("222222222222222222");
	}
	/**
	 * 通过搜索内容模糊匹配查看关键字
	 * @param searchContent 搜索内容
	 * @return 关键字集合
	 */
	@Test
	public void SelectKeywordBySearch(){
		System.out.println();
		System.out.println();
		System.out.println();
		System.out.println();
		System.out.println();
		List<Keyword> keywords = keydao.daoSelectKeywordBySearch("%关键%");
		for (Keyword keyword : keywords) {
			System.out.println(keyword);
		}
		System.out.println();
		System.out.println();
		System.out.println();
		System.out.println();
		System.out.println();
		
		
	}
	/**
	 * 查看所有关键字
	 * @return 关键字集合
	 */
	@Test
	public void SelectAllKeyword(){
		List<Keyword> keys = keydao.daoSelectAllKeyword();
		System.out.println();
		System.out.println();
		System.out.println();
		System.out.println();
		System.out.println();
		for (Keyword keyword : keys) {
			System.out.println(keyword);
		}
		System.out.println();
		System.out.println();
		System.out.println();
		System.out.println();
		System.out.println();
		
	}
	
	
}