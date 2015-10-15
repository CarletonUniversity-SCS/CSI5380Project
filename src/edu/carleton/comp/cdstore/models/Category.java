package edu.carleton.comp.cdstore.models;

public class Category {
int cateid;
String catename;


public Category(int cateid, String catename) {

	this.cateid = cateid;
	this.catename = catename;
}


public final int getCateid() {
	return cateid;
}
public final void setCateid(int cateid) {
	this.cateid = cateid;
}
public final String getCatename() {
	return catename;
}
public final void setCatename(String catename) {
	this.catename = catename;
}


}
