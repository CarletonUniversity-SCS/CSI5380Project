package edu.carleton.comp.cdstore.models;

public class Address {
	int addrid;
	String addrline1;
	String addrline2;
	String city;
	String province;
	String zipcode;
	String country;
	String phone;
	int userid;
	
	
	public Address(int addrid, String addrline1, String addrline2, String city, String province, String zipcode,
			String country, String phone, int userid) {
		super();
		this.addrid = addrid;
		this.addrline1 = addrline1;
		this.addrline2 = addrline2;
		this.city = city;
		this.province = province;
		this.zipcode = zipcode;
		this.country = country;
		this.phone = phone;
		this.userid = userid;
	}
	public final int getAddrid() {
		return addrid;
	}
	public final void setAddrid(int addrid) {
		this.addrid = addrid;
	}
	public final String getAddrline1() {
		return addrline1;
	}
	public final void setAddrline1(String addrline1) {
		this.addrline1 = addrline1;
	}
	public final String getAddrline2() {
		return addrline2;
	}
	public final void setAddrline2(String addrline2) {
		this.addrline2 = addrline2;
	}
	public final String getCity() {
		return city;
	}
	public final void setCity(String city) {
		this.city = city;
	}
	public final String getProvince() {
		return province;
	}
	public final void setProvince(String province) {
		this.province = province;
	}
	public final String getZipcode() {
		return zipcode;
	}
	public final void setZipcode(String zipcode) {
		this.zipcode = zipcode;
	}
	public final String getCountry() {
		return country;
	}
	public final void setCountry(String country) {
		this.country = country;
	}
	public final String getPhone() {
		return phone;
	}
	public final void setPhone(String phone) {
		this.phone = phone;
	}
	public final int getUserid() {
		return userid;
	}
	public final void setUserid(int userid) {
		this.userid = userid;
	}
}
