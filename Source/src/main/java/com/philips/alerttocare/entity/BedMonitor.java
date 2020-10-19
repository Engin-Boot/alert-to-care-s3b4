package com.philips.alerttocare.entity;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "BED_MONITOR")
public class BedMonitor {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name = "BED_ID")
	private Integer bedId; //FK
	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "BED_ID", referencedColumnName = "BED_ID", insertable=false, updatable=false)
	private Bed bed;

	@Column(name = "DEVICE_ID")
	private long deviceID; //FK
	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "DEVICE_ID", referencedColumnName = "DEVICE_ID", insertable=false, updatable=false)
	private MonitoringDevice monitoringDevice;
	
	@Column(name = "MESSAGE")
	private  String message;
	
	private Integer spo2;
	
	private Integer bodyTemperature;
	
	private Integer respirationRate;
	
	@CreationTimestamp
	private Date createdAt;
	
	@UpdateTimestamp
	private Date updatedAt;
	
	private String status;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Integer getBedId() {
		return bedId;
	}

	public void setBedId(Integer bedId) {
		this.bedId = bedId;
	}

	public Bed getBed() {
		return bed;
	}

	public void setBed(Bed bed) {
		this.bed = bed;
	}

	public long getDeviceID() {
		return deviceID;
	}

	public void setDeviceID(long deviceID) {
		this.deviceID = deviceID;
	}

	@JsonIgnore
	public MonitoringDevice getMonitoringDevice() {
		return monitoringDevice;
	}

	public void setMonitoringDevice(MonitoringDevice monitoringDevice) {
		this.monitoringDevice = monitoringDevice;
	}

	public Integer getSpo2() {
		return spo2;
	}

	public void setSpo2(Integer spo2) {
		this.spo2 = spo2;
	}

	public Integer getBodyTemperature() {
		return bodyTemperature;
	}

	public void setBodyTemperature(Integer bodyTemperature) {
		this.bodyTemperature = bodyTemperature;
	}

	public Integer getRespirationRate() {
		return respirationRate;
	}

	public void setRespirationRate(Integer respirationRate) {
		this.respirationRate = respirationRate;
	}

	public Date getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}

	public Date getUpdatedAt() {
		return updatedAt;
	}

	public void setUpdatedAt(Date updatedAt) {
		this.updatedAt = updatedAt;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
	
	
	
}
