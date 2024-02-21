package com.example.demo.exception;

public class ResourceNotFoundException extends RuntimeException {

	String resourcename;
	String fildName;
	long fildValue;

	public ResourceNotFoundException(String resourcename, String fildName, long fildValue) {
		super(String.format("%s not found %s" + " %s ", resourcename, fildName, fildValue));
		this.resourcename = resourcename;
		this.fildName = fildName;
		this.fildValue = fildValue;
	}

	public String getResourcename() {
		return resourcename;
	}

	public void setResourcename(String resourcename) {
		this.resourcename = resourcename;
	}

	public String getFildName() {
		return fildName;
	}

	public void setFildName(String fildName) {
		this.fildName = fildName;
	}

	public long getFildValue() {
		return fildValue;
	}

	public void setFildValue(long fildValue) {
		this.fildValue = fildValue;
	}

}
