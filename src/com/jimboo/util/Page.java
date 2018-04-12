package com.jimboo.util;

public class Page {
	/**ҳ��*/
	private int pageNum;
	/**ÿҳ��ʾ�ļ�¼��*/
	private int count;
	/**��ʼ�ı�־*/
	private int begin;
	/**����*/
	private int end;
	/**�ܼ�¼��*/
	private int allCount;
	/**��ҳ��*/
	private int allPage;
	/**��ѯģʽ:1.���ո����ѯ 2.���������ѯ 3.���չؼ��ֲ�ѯ*/
	private int model;
	/**
	 * @param page ��ǰҳ��
	 * @param count ÿҳҪ��ʾ�ļ�¼��
	 * @param allCount �ܼ�¼��
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
