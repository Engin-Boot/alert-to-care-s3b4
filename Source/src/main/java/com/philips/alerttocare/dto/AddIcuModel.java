package com.philips.alerttocare.dto;

public class AddIcuModel {
	
	private String layoutInfo;
	private Integer bedLimit;

	public String getLayoutInfo() {
		return layoutInfo;
	}

	public void setLayoutInfo(String layoutInfo) {
		this.layoutInfo = layoutInfo;
	}

	public Integer getBedLimit() {
		return bedLimit;
	}

	public void setBedLimit(Integer bedLimit) {
		this.bedLimit = bedLimit;
	}

}
