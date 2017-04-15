package com.upsoft.dao;

import java.util.List;

import org.springframework.stereotype.Component;

import com.upsoft.entity.Keyword;

@Component
public interface KeywordDao {
	/**
	 * 新增关键字
	 * @param keyword
	 */
	public void daoAddKeyword(Keyword keyword);
	/**
	 * 通过id删除关键字
	 * @param id
	 */
	public void daoDeleteKeyword(String id);
	/**
	 * 更新关键字
	 * @param keyword
	 */
	public void daoUpdateKeyword(Keyword keyword);
	/**
	 * 通过id查看关键字
	 * @param id
	 * @return 关键字
	 */
	public Keyword daoSelectKeywordById(String id);
	/**
	 * 通过主题帖id查看关键字
	 * @param id 主题帖id
	 * @return 关键字集合
	 */
	public List<Keyword> daoSelectKeywordByTopicPostId(String id);
	/**
	 * 通过搜索内容模糊匹配查看关键字
	 * @param searchContent 搜索内容
	 * @return 关键字集合
	 */
	public List<Keyword> daoSelectKeywordBySearch(String searchContent);
	/**
	 * 查看所有关键字
	 * @return 关键字集合
	 */
	public List<Keyword> daoSelectAllKeyword();
}