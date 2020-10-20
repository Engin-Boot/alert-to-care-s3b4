package com.philips.alerttocare.entity;

import java.sql.Timestamp;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.UpdateTimestamp;

@Entity
@Table(name = "ICU")
public class Icu {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ICU_ID")
	private Integer icuId;

	@Column(name = "LAYOUT_INFO")
	private String layoutInfo;

	@Column(name = "TOTAL_BEDS")
	private Integer totalBeds;

	@Column(name = "BED_LIMIT")
	private Integer bedLimit;

	@Column(name = "TIMESTAMP")
	private Timestamp timestamp;

	@UpdateTimestamp
	private Timestamp updatedAt;
	
	public Integer getIcuId() {
		return icuId;
	}

	public void setIcuId(Integer icuId) {
		this.icuId = icuId;
	}

	public String getLayoutInfo() {
		return layoutInfo;
	}

	public void setLayoutInfo(String layoutInfo) {
		this.layoutInfo = layoutInfo;
	}

	public Integer getTotalBeds() {
		return totalBeds;
	}

	public void setTotalBeds(Integer totalBeds) {
		this.totalBeds = totalBeds;
	}

	public Integer getBedLimit() {
		return bedLimit;
	}

	public void setBedLimit(Integer bedLimit) {
		this.bedLimit = bedLimit;
	}

	public Timestamp getTimestamp() {
		return timestamp;
	}

	public void setTimestamp(Timestamp timestamp) {
		this.timestamp = timestamp;
	}

	public Date getUpdatedAt() {
		return updatedAt;
	}

	public void setUpdatedAt(Timestamp updatedAt) {
		this.updatedAt = updatedAt;
	}

	
}
