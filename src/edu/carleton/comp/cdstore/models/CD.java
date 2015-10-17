package edu.carleton.comp.cdstore.models;

import java.sql.Date;

public class CD {
	int cdid;
	String title;
	String artist;
	Date date;
	String intro;
	float price;
	int stock;
	String imgurl;
	int cateid;
	
	
	
	public CD(int cdid, String title, String artist, Date date, String intro, float price, int stock, String imgurl,
			int cateid) {
		
		this.cdid = cdid;
		this.title = title;
		this.artist = artist;
		this.date = date;
		this.intro = intro;
		this.price = price;
		this.stock = stock;
		this.imgurl = imgurl;
		this.cateid = cateid;
	}
	
	public CD(String title, String artist, Date date, String intro, float price, int stock, String imgurl,
			int cateid) {
		
		this.title = title;
		this.artist = artist;
		this.date = date;
		this.intro = intro;
		this.price = price;
		this.stock = stock;
		this.imgurl = imgurl;
		this.cateid = cateid;
	}
	
	
	public final int getCdid() {
		return cdid;
	}
	public final void setCdid(int cdid) {
		this.cdid = cdid;
	}
	public final String getTitle() {
		return title;
	}
	public final void setTitle(String title) {
		this.title = title;
	}
	public final String getArtist() {
		return artist;
	}
	public final void setArtist(String artist) {
		this.artist = artist;
	}
	public final Date getDate() {
		return date;
	}
	public final void setDate(Date date) {
		this.date = date;
	}
	public final String getIntro() {
		return intro;
	}
	public final void setIntro(String intro) {
		this.intro = intro;
	}
	public final float getPrice() {
		return price;
	}
	public final void setPrice(float price) {
		this.price = price;
	}
	public final int getStock() {
		return stock;
	}
	public final void setStock(int stock) {
		this.stock = stock;
	}
	public final String getImgurl() {
		return imgurl;
	}
	public final void setImgurl(String imgurl) {
		this.imgurl = imgurl;
	}
	public final int getCateid() {
		return cateid;
	}
	public final void setCateid(int cateid) {
		this.cateid = cateid;
	}
	
	
}
