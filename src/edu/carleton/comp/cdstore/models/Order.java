package edu.carleton.comp.cdstore.models;

import java.sql.Timestamp;;

public class Order {
	int orderid;
	Timestamp date;
	String status;
	float total;
	int userid;
	int addrid;
	int billid;
	int shipid;
	int taxid;
	
	
	
	public Order(Timestamp date, String status, float total, int userid, int addrid, int billid, int shipid,int taxid) {
		super();	
		this.date = date;
		this.status = status;
		this.total = total;
		this.userid = userid;
		this.addrid = addrid;
		this.billid = billid;
		this.shipid = shipid;
		this.taxid = taxid;
	}
	public Order(int orderid, Timestamp date, String status, float total, int userid, int addrid, int billid, int shipid, int taxid) {
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
	public final Timestamp getDate() {
		return date;
	}
	public final void setDate(Timestamp date) {
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
	public final int getAddrid() {
		return addrid;
	}
	public final void setAddrid(int addrid) {
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
	
	public final int getBillid() {
		return billid;
	}
	public final void setBillid(int billid) {
		this.billid = billid;
	}
	
}
