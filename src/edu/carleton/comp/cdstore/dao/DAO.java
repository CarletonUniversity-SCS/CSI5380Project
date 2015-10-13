package edu.carleton.comp.cdstore.dao;

import java.io.File;
import java.io.FileInputStream;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Properties;

import edu.carleton.comp.cdstore.util.ConfigProperties;

public abstract class DAO implements DAOInterface{
	protected DAOHelper dao=null;
	protected Properties sqlcode=null;
	public DAO(){}
	protected abstract Object getDataObject(ResultSet paramResultSet, boolean paramBoolean);
	protected void init(){
		try{
			String sqlFile =ConfigProperties.getInstance().SQL_DIR;
			File resFile=new File(sqlFile);
			FileInputStream fileinput=new FileInputStream(resFile);
			this.sqlcode=new Properties();
			this.sqlcode.load(fileinput);
			fileinput.close();
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	public void destory(){
		if(this.dao!=null){
			this.dao.returnConnection();
			this.dao=null;
			this.sqlcode=null;
		}
		try{
			super.finalize();
		}catch(Throwable t)
		{
			t.printStackTrace();
		}
	}
	
	protected ArrayList<Object> processResultSet(ResultSet rs){
		ArrayList<Object> list=new ArrayList<Object>();
		Object obj;
		while((obj=getDataObject(rs,false))!=null){
			list.add(obj);
		}
		this.dao.close(rs);
		return list;
	}
	protected void close(ResultSet rs){
		this.dao.close(rs);
	}
}
