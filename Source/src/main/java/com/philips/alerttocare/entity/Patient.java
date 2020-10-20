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
@Table(name = "PATIENTS")
public class Patient {
	
	@Id 
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long pid;
	private String name;
	private String email;
	private String gender;
	
	@Column(name = "BED_ID")
	private long bedId; //FK
	
	@OneToOne
	@JoinColumn(name = "BED_ID", referencedColumnName = "BED_ID", insertable=false, updatable=false)
	private Bed bed;
	
	@CreationTimestamp
	private Date createdAt;
	
	@UpdateTimestamp
	private Date updatedAt;

	public Date getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}

	public long getPid() {
		return pid;
	}
	
	public void setPid(long pid) {
		this.pid = pid;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public long getBedId() {
		return bedId;
	}
	public void setBedId(long bedId) {
		this.bedId = bedId;
	}
	@JsonIgnore
	public Bed getBed() {
		return bed;
	}
	public void setBed(Bed bed) {
		this.bed = bed;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}

	public Date getUpdatedAt() {
		return updatedAt;
	}

	public void setUpdatedAt(Date updatedAt) {
		this.updatedAt = updatedAt;
	}
	
	
}