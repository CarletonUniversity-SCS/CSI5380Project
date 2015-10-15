package edu.carleton.comp.cdstore.models;

public class Shipping {
	int shipid;
	String method;
	float price;
		
	public Shipping(int shipid, String method, float price) {
		this.shipid = shipid;
		this.method = method;
		this.price = price;
	}
	public final int getShipid() {
		return shipid;
	}
	public final void setShipid(int shipid) {
		this.shipid = shipid;
	}
	public final String getMethod() {
		return method;
	}
	public final void setMethod(String method) {
		this.method = method;
	}
	public final float getPrice() {
		return price;
	}
	public final void setPrice(float price) {
		this.price = price;
	}
	
	
	
}
