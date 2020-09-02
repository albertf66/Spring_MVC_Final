package com.spring.entity;

public class User {
	private Integer user_id;
	private String user_name;
	private String user_email;
	private String user_pw;
	private String user_phone;
	private String user_country;
	private String user_status;
	
	public User() {
		
	}


	public User(Integer user_id, String user_name, String user_email, String user_pw, String user_phone,
			String user_country, String user_status) {
		super();
		this.user_id = user_id;
		this.user_name = user_name;
		this.user_email = user_email;
		this.user_pw = user_pw;
		this.user_phone = user_phone;
		this.user_country = user_country;
		this.user_status = user_status;
	}


	public Integer getUser_id() {
		return user_id;
	}


	public void setUser_id(Integer user_id) {
		this.user_id = user_id;
	}


	public String getUser_name() {
		return user_name;
	}

	public void setUser_name(String user_name) {
		this.user_name = user_name;
	}

	public String getUser_email() {
		return user_email;
	}

	public void setUser_email(String user_email) {
		this.user_email = user_email;
	}

	public String getUser_pw() {
		return user_pw;
	}

	public void setUser_pw(String user_pw) {
		this.user_pw = user_pw;
	}

	public String getUser_phone() {
		return user_phone;
	}

	public void setUser_phone(String user_phone) {
		this.user_phone = user_phone;
	}

	public String getUser_country() {
		return user_country;
	}

	public void setUser_country(String user_country) {
		this.user_country = user_country;
	}

	public String getUser_status() {
		return user_status;
	}

	public void setUser_status(String user_status) {
		this.user_status = user_status;
	}


	@Override
	public String toString() {
		return "User [user_id=" + user_id + ", user_name=" + user_name + ", user_email=" + user_email + ", user_pw="
				+ user_pw + ", user_phone=" + user_phone + ", user_country=" + user_country + ", user_status="
				+ user_status + "]";
	}


	
}
