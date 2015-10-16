package edu.carleton.comp.cdstore.cookies;

import java.sql.Date;

public class Cart {
	int cdid;
	String title;
	String artist;
	Date date;
	String intro;
	float price;
	int stock;
	String imgurl;
	int cateid;	
	int quantity;
	
	public Cart(int cdid,String title,String artist,Date date,String intro,float price,int stock,String imgurl,int cateid,int quantity) {
		super();
		this.cdid = cdid;
		this.title = title;
		this.artist = artist;
		this.date = date;
		this.intro = intro;
		this.price = price;
		this.stock = stock;
		this.imgurl = imgurl;
		this.cateid = cateid;
		this.quantity=quantity;
	}
	
	public int getCdid() {
		return cdid;
	}
	public void setCdid(int cdid) {
		this.cdid = cdid;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getArtist() {
		return artist;
	}
	public void setArtist(String artist) {
		this.artist = artist;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public String getIntro() {
		return intro;
	}
	public void setIntro(String intro) {
		this.intro = intro;
	}
	public float getPrice() {
		return price;
	}
	public void setPrice(float price) {
		this.price = price;
	}
	public int getStock() {
		return stock;
	}
	public void setStock(int stock) {
		this.stock = stock;
	}
	public String getImgurl() {
		return imgurl;
	}
	public void setImgurl(String imgurl) {
		this.imgurl = imgurl;
	}
	public int getCateid() {
		return cateid;
	}
	public void setCateid(int cateid) {
		this.cateid = cateid;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	
	
}
