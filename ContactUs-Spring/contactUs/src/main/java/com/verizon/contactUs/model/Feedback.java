package com.verizon.contactUs.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;


@Entity
@Table(name="fbform")
public class Feedback {
	@Id
    @NotEmpty
	private String name;
	@NotEmpty
	private String email;
	@NotEmpty
	private String message;
	public Feedback(String name, String email, String message) {
		this.name = name;
		this.email = email;
		this.message = message;
	}
	
	public Feedback() {
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
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	
	
	

	
	

}
