package edu.carleton.comp.cdstore.models;

public class Tax {
	int taxid;
	String taxname;
	float taxrate;
	
	
	
	public Tax(int taxid, String taxname, float taxrate) {
		super();
		this.taxid = taxid;
		this.taxname = taxname;
		this.taxrate = taxrate;
	}
		
	public final int getTaxid() {
		return taxid;
	}
	public final void setTaxid(int taxid) {
		this.taxid = taxid;
	}
	public final String getTaxname() {
		return taxname;
	}
	public final void setTaxname(String taxname) {
		this.taxname = taxname;
	}

	public final float getTaxrate() {
		return taxrate;
	}

	public final void setTaxrate(float taxrate) {
		this.taxrate = taxrate;
	}
	
	

}

