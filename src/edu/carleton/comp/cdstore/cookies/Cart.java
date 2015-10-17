package edu.carleton.comp.cdstore.cookies;


public class Cart {
	int cdid;
	String title;
	String artist;
	float price;
	int stock;
	String imgurl;
	int quantity;
	
	public Cart() {
		super();

		}
	
	public Cart(int cdid,String title,String artist,float price,int stock,String imgurl,int quantity) {
		super();
		this.cdid = cdid;
		this.title = title;
		this.artist = artist;
		this.price = price;
		this.stock=stock;
		this.imgurl = imgurl;
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
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	
	
}
