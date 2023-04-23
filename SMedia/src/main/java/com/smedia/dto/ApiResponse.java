package com.smedia.dto;

import java.util.List;

import com.smedia.entity.Post;

public class ApiResponse<T> {
	private List<T> content;
	private int pageNumber;
	private int pageSize;
	private long totleElements;
	private int totlePages;
	private boolean isFirst;
	private boolean isLast;
	
	
	public ApiResponse() {
		super();
		// TODO Auto-generated constructor stub
	}
	public ApiResponse(List<T> content, int pageNumber, int pageSize, long totleElements, int totlePages,
			boolean isFirst, boolean isLast) {
		super();
		this.content = content;
		this.pageNumber = pageNumber;
		this.pageSize = pageSize;
		this.totleElements = totleElements;
		this.totlePages = totlePages;
		this.isFirst = isFirst;
		this.isLast = isLast;
	}
	public List<T> getContent() {
		return content;
	}
	public void setContent(List<Post> list) {
		this.content = (List<T>) list;
	}
	public int getPageNumber() {
		return pageNumber;
	}
	public void setPageNumber(int pageNumber) {
		this.pageNumber = pageNumber;
	}
	public int getPageSize() {
		return pageSize;
	}
	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}
	public long getTotleElements() {
		return totleElements;
	}
	public void setTotleElements(long totleElements) {
		this.totleElements = totleElements;
	}
	public int getTotlePages() {
		return totlePages;
	}
	public void setTotlePages(int totlePages) {
		this.totlePages = totlePages;
	}
	public boolean isFirst() {
		return isFirst;
	}
	public void setFirst(boolean isFirst) {
		this.isFirst = isFirst;
	}
	public boolean isLast() {
		return isLast;
	}
	public void setLast(boolean isLast) {
		this.isLast = isLast;
	}
	@Override
	public String toString() {
		return "ApiResponse [content=" + content + ", pageNumber=" + pageNumber + ", pageSize=" + pageSize
				+ ", totleElements=" + totleElements + ", totlePages=" + totlePages + ", isFirst=" + isFirst
				+ ", isLast=" + isLast + "]";
	}
	
	
	
}
