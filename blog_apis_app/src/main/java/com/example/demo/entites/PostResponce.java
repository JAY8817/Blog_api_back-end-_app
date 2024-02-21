package com.example.demo.entites;

import java.util.List;

import com.example.demo.payload.PostDto;

public class PostResponce {
	
	List<PostDto> content;
	private int pagesize;
	private int pagenumber;
	private long totalelement;
	private int totalpages;
    private boolean lastpage;

	public List<PostDto> getContent() {
		return content;
	}
	
	public void setContent(List<PostDto> content) {
		this.content = content;
	}
	
	public int getPagesize() {
		return pagesize;
	}
	
	public void setPagesize(int pagesize) {
		this.pagesize = pagesize;
	}
	
	public int getPagenumber() {
		return pagenumber;
	}
	
	public void setPagenumber(int pagenumber) {
		this.pagenumber = pagenumber;
	}
	
	public long getTotalelement() {
		return totalelement;
	}
	
	public void setTotalelement(long totalelement) {
		this.totalelement = totalelement;
	}
	
	public int getTotalpages() {
		return totalpages;
	}
	
	public void setTotalpages(int totalpages) {
		this.totalpages = totalpages;
	}
	
	public boolean isLastpage() {
		return lastpage;
	}
	
	public void setLastpage(boolean lastpage) {
		this.lastpage = lastpage;
	}
	
	public PostResponce(List<PostDto> content, int pagesize, int pagenumber, long totalelement, int totalpages,
			boolean lastpage) {
		super();
		this.content = content;
		this.pagesize = pagesize;
		this.pagenumber = pagenumber;
		this.totalelement = totalelement;
		this.totalpages = totalpages;
		this.lastpage = lastpage;
	}

	public PostResponce() {
		super();
	}
    
    
    
    
    
    

}
