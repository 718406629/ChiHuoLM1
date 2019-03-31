package org.address.entity;

import java.util.List;


//分页帮助类
public class Page {
    //当前页 currentPage(用户设定)
	private int currentPage;
	//页面大小(用户设定)
	private int pageSize;
	//总数据totalCount
	private int totalCount;
	//总页数 
	private int totalPage;
	//当前页的数据集合
	private List<Address> addresses;
	public int getCurrentPage() {
		return currentPage;
	}
	public void setCurrentPage(int currentPage) {
		this.currentPage = currentPage;
	}
	public int getPageSize() {
		return pageSize;
	}
	public void setPageSize(int pageSize) {
		this.pageSize=pageSize;
		this.totalPage=this.totalCount%this.pageSize==0?this.totalCount/this.pageSize:this.totalCount/this.pageSize+1;
	}
	public int getTotalCount() {
		return totalCount;
	}
	public void setTotalCount(int totalCount) {
		this.totalCount = totalCount;
	}
	public int getTotalPage() {
		return totalPage;
	}
	public void setTotalPage(int tatalPage) {
		this.totalPage = tatalPage;
	}
	public List<Address> getAddresses() {
		return addresses;
	}
	public void setAddresses(List<Address> students) {
		this.addresses = students;
	}
	public Page(int currentPage, int pageSize, int totalCount, int tatalPage, List<Address> students) {
		
		this.currentPage = currentPage;
		this.pageSize = pageSize;
		this.totalCount = totalCount;
		this.totalPage = tatalPage;
		this.addresses = students;
	}
	public Page() {
		
	}
	
}
