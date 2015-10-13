package edu.carleton.comp.cdstore.models;

public class Customer {
	private int userid;
	
	private String password;
	private String fname;
	private String iname;
	private String email;
	public Customer(String password, String fname, String iname,String email){
		
		this.password=password;
		this.fname=fname;
		this.iname=iname;
		this.email=email;
	}
	public int getUserid() {
		return userid;
	}
	public void setUserid(int userid) {
		this.userid = userid;
	}

	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getFname() {
		return fname;
	}
	public void setFname(String fname) {
		this.fname = fname;
	}
	public String getIname() {
		return iname;
	}
	public void setIname(String iname) {
		this.iname = iname;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
}
