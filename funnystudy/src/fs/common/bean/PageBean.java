package fs.common.bean;

import java.io.Serializable;

/**分页用的bean
 * @author Jason_★ 
 */
@SuppressWarnings("serial")
public class PageBean implements Serializable
{
	//数据总条数
	private int totalItem;
	//每页显示条数
	private int eachPage;
	//总页数
	private int totalPage;
	//当前页数
	private int currentPage=1;
	public PageBean()
	{
		super();
	}
	public PageBean(int totalItem, int eachPage, int totalPage, int currentPage) 
	{
		super();
		this.totalItem = totalItem;
		this.eachPage = eachPage;
		this.totalPage = totalPage;
		this.currentPage = currentPage;
	}
	public int getTotalItem() {
		return totalItem;
	}
	public void setTotalItem(int totalItem) {
		this.totalItem = totalItem;
	}
	public int getEachPage() {
		return eachPage;
	}
	public void setEachPage(int eachPage) {
		this.eachPage = eachPage;
	}
	public int getTotalPage() {
		return totalPage;
	}
	public void setTotalPage(int totalPage) {
		this.totalPage = totalPage;
	}
	public int getCurrentPage() {
		return currentPage;
	}
	public void setCurrentPage(int currentPage) {
		this.currentPage = currentPage;
	}	
}
