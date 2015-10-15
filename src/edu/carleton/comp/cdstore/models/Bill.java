package edu.carleton.comp.cdstore.models;

public class Bill {
int billid;
String addrline1;
String addrline2;
String city;
String province;
String country;
String zipcode;
int userid;

public Bill(int billid, String addrline1, String addrline2, String city, String province, String country,
		String zipcode, int userid) {
	this.billid = billid;
	this.addrline1 = addrline1;
	this.addrline2 = addrline2;
	this.city = city;
	this.province = province;
	this.country = country;
	this.zipcode = zipcode;
	this.userid = userid;
}



public Bill(String addrline1, String addrline2, String city, String province, String country,
		String zipcode, int userid) {
	
	this.addrline1 = addrline1;
	this.addrline2 = addrline2;
	this.city = city;
	this.province = province;
	this.country = country;
	this.zipcode = zipcode;
	this.userid = userid;
}

public Bill(String addrline1, String addrline2, String city, String province, String country,
		String zipcode) {
	
	this.addrline1 = addrline1;
	this.addrline2 = addrline2;
	this.city = city;
	this.province = province;
	this.country = country;
	this.zipcode = zipcode;
}




public final int getBillid() {
	return billid;
}
public final void setBillid(int billid) {
	this.billid = billid;
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
public final String getCountry() {
	return country;
}
public final void setCountry(String country) {
	this.country = country;
}
public final String getZipcode() {
	return zipcode;
}
public final void setZipcode(String zipcode) {
	this.zipcode = zipcode;
}
public final int getUserid() {
	return userid;
}
public final void setUserid(int userid) {
	this.userid = userid;
}


}
