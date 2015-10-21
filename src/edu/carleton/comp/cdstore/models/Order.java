package edu.carleton.comp.cdstore.models;


public class Order {
	int orderid;
	String date;
	String status;
	float total;
	int userid;
	Integer addrid;
	Integer billid;
	int shipid;
	int taxid;

	public Order(String date, String status, float total, int userid, Integer addrid,Integer billid,int shipid,int taxid) {
		super();	
		this.date = date;
		this.status = status;
		this.total = total;
		this.userid = userid;
		this.addrid=addrid;
		this.billid=billid;
		this.shipid = shipid;
		this.taxid = taxid;
	}
	public Order(String date, String status, float total, int userid, int shipid,int taxid) {
		super();	
		this.date = date;
		this.status = status;
		this.total = total;
		this.userid = userid;
		this.shipid = shipid;
		this.taxid = taxid;
	}
	public Order(int orderid, String date, String status, float total, int userid, int addrid, int billid, int shipid, int taxid) {
		this.orderid = orderid;
		this.date = date;
		this.status = status;
		this.total = total;
		this.userid = userid;
		this.addrid = addrid;
		this.billid = billid;
		this.shipid = shipid;
		this.taxid = taxid;
	}
	public final int getOrderid() {
		return orderid;
	}
	public final void setOrderid(int orderid) {
		this.orderid = orderid;
	}
	public final String getDate() {
		return date;
	}
	public final void setDate(String date) {
		this.date = date;
	}
	public final String getStatus() {
		return status;
	}
	public final void setStatus(String status) {
		this.status = status;
	}
	public final float getTotal() {
		return total;
	}
	public final void setTotal(float total) {
		this.total = total;
	}
	public final int getUserid() {
		return userid;
	}
	public final void setUserid(int userid) {
		this.userid = userid;
	}
	public final Integer getAddrid() {
		return addrid;
	}
	public final void setAddrid(Integer addrid) {
		this.addrid = addrid;
	}
	public final int getShipid() {
		return shipid;
	}
	public final void setShipid(int shipid) {
		this.shipid = shipid;
	}
	public final int getTaxid() {
		return taxid;
	}
	public final void setTaxid(int taxid) {
		this.taxid = taxid;
	}
	
	public final Integer getBillid() {
		return billid;
	}
	public final void setBillid(Integer billid) {
		this.billid = billid;
	}
	
}
