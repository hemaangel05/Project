package com.verizon.abt.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="cinfo")
public class ClInfo {
	@Id
	private String cname;
	private String phone;
	private String email;
	public ClInfo() {
	}
	public ClInfo(String cname, String phone, String email) {
		super();
		this.cname = cname;
		this.phone = phone;
		this.email = email;
	}
	public String getCname() {
		return cname;
	}
	public void setCname(String cname) {
		this.cname = cname;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	
	

}
