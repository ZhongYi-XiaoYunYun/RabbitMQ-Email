package com.sc.entity;

public class User implements java.io.Serializable {
	private static final long serialVersionUID = 1L;
	private String username;
	private String pwd;
	private String email;
	
	public User(String username, String pwd, String email) {
		super();
		this.username = username;
		this.pwd = pwd;
		this.email = email;
	}
	public String getUsername() {return username;}
	public String getPwd() {return pwd;}
	public String getEmail() {return email;}
	public void setUsername(String username) {this.username = username;}
	public void setPwd(String pwd) {this.pwd = pwd;}
	public void setEmail(String email) {this.email = email;}
	
	@Override
	public String toString() {
		return "User [username=" + username + ", pwd=" + pwd + ", email=" + email + "]";
	}
	
}
