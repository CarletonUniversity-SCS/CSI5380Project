package edu.carleton.comp.cdstore.models;

public class Item {
	int itemsid;
	int count;
	int ordid;
	int cdid;
	
	public Item(int itemsid, int count, int ordid, int cdid) {
		this.itemsid = itemsid;
		this.count = count;
		this.ordid = ordid;
		this.cdid = cdid;
	}
	public Item(int count, int ordid, int cdid) {
		this.count = count;
		this.ordid = ordid;
		this.cdid = cdid;
	}
	
	public final int getItemsid() {
		return itemsid;
	}
	public final void setItemsid(int itemsid) {
		this.itemsid = itemsid;
	}
	public final int getCount() {
		return count;
	}
	public final void setCount(int count) {
		this.count = count;
	}
	public final int getOrdid() {
		return ordid;
	}
	public final void setOrdid(int ordid) {
		this.ordid = ordid;
	}
	public final int getCdid() {
		return cdid;
	}
	public final void setCdid(int cdid) {
		this.cdid = cdid;
	}
	
}
