package com.jimboo.util;

public class Page {
	/**页码*/
	private int pageNum;
	/**每页显示的记录数*/
	private int count;
	/**开始的标志*/
	private int begin;
	/**结束*/
	private int end;
	/**总记录数*/
	private int allCount;
	/**总页数*/
	private int allPage;
	/**查询模式:1.按照父类查询 2.按照子类查询 3.按照关键字查询*/
	private int model;
	/**
	 * @param page 当前页码
	 * @param count 每页要显示的记录数
	 * @param allCount 总记录数
	 * */
	public Page(int pageNum, int count, int allCount) {
		super();
		this.pageNum = pageNum;
		this.count = count;
		this.begin=(pageNum-1)*count+1;
		this.end=this.begin+count-1;
		this.allCount = allCount;
		if(allCount%count==0) {
			this.allPage=allCount/count;
		}else {
			this.allPage=allCount/count+1;
		}
	}

	public int getPageNum() {
		return pageNum;
	}

	public void setPageNum(int pageNum) {
		this.pageNum = pageNum;
	}

	public int getCount() {
		return count;
	}
	public void setCount(int count) {
		this.count = count;
	}
	public int getBegin() {
		return begin;
	}
	public void setBegin(int begin) {
		this.begin = begin;
	}
	public int getEnd() {
		return end;
	}
	public void setEnd(int end) {
		this.end = end;
	}
	public int getAllCount() {
		return allCount;
	}
	public void setAllCount(int allCount) {
		this.allCount = allCount;
	}
	public int getAllPage() {
		return allPage;
	}
	public void setAllPage(int allPage) {
		this.allPage = allPage;
	}
	
	public int getModel() {
		return model;
	}

	public void setModel(int model) {
		this.model = model;
	}

	@Override
	public String toString() {
		return "Page [pageNum=" + pageNum + ", count=" + count + ", begin=" + begin + ", end=" + end + ", allCount="
				+ allCount + ", allPage=" + allPage + "]";
	}
	
	
}
