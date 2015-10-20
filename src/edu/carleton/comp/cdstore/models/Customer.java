package edu.carleton.comp.cdstore.models;

public class Customer {
	private int userid;
	private String password;
	private String fname;
	private String iname;
	private String email;
	private String sex;
	public Customer(Integer userid,String password, String fname, String iname,String email,String sex){
		this.userid=userid;
		this.password=password;
		this.fname=fname;
		this.iname=iname;
		this.email=email;
		this.sex=sex;
	}
	public Customer(String password, String fname, String iname,String email,String sex){
		this.password=password;
		this.fname=fname;
		this.iname=iname;
		this.email=email;
		this.sex=sex;
	}
	
	public Customer(String password, String fname, String iname,String sex){
		
		this.password=password;
		this.fname=fname;
		this.iname=iname;
		this.sex=sex;
	}
	
	public final int getUserid() {
		return userid;
	}
	public final void setUserid(int userid) {
		this.userid = userid;
	}

	public final String getPassword() {
		return password;
	}
	public final void setPassword(String password) {
		this.password = password;
	}
	public final String getFname() {
		return fname;
	}
	public final void setFname(String fname) {
		this.fname = fname;
	}
	public final String getIname() {
		return iname;
	}
	public final void setIname(String iname) {
		this.iname = iname;
	}
	public final String getEmail() {
		return email;
	}
	public final void setEmail(String email) {
		this.email = email;
	}
	public final String getSex() {
		return sex;
	}
	public final void setSex(String sex) {
		this.sex = sex;
	}
	
}
