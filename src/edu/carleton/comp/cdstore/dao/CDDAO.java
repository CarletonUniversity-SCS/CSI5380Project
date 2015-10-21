package edu.carleton.comp.cdstore.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.MessageFormat;
import java.text.SimpleDateFormat;
import java.util.List;

import edu.carleton.comp.cdstore.models.CD;

public class CDDAO extends DAO{
	public CDDAO(){
		super.init();
		this.dao=new DAOHelper();
	}
	public CDDAO(DAOHelper daohelper){
		super.init();
		this.dao=daohelper;
	}
	public List<Object> findall(){
		String sql=this.sqlcode.getProperty("CD.findall");
		return super.processResultSet(this.dao.executeLookup(sql, "CD.findall"));
	}
	public List<Object> findbymenu(String menu){
		String sql=this.sqlcode.getProperty("CD.querybymenu");
		String sqlstring=MessageFormat.format(sql, new Object[]{menu});
		return super.processResultSet(this.dao.executeLookup(sqlstring, "CD.querybymenu"));
	}
	public List<Object> findorderall(String key){
		String sql;
		String sqlstring;
		ResultSet condition = null;
		String keys;
		if(key.equals("redate")){
			keys="date";
			sql=this.sqlcode.getProperty("CD.findorderall");
			sqlstring=MessageFormat.format(sql, new Object[]{keys});
			condition=this.dao.executeLookup(sqlstring, "CD.findorderall");
		}else if(key.equals("price")){
			keys="price";
			sql=this.sqlcode.getProperty("CD.findorderall");
			sqlstring=MessageFormat.format(sql, new Object[]{keys});
			condition=this.dao.executeLookup(sqlstring, "CD.findorderall");
		}else if(key.equals("popular")){
			sql=this.sqlcode.getProperty("CD.findorderallp");
			condition=this.dao.executeLookup(sql, "CD.findorderallp");
		}else if(key.equals("discount")){
			sql=this.sqlcode.getProperty("CD.findorderalld");
			condition=this.dao.executeLookup(sql, "CD.findorderalld");
		}
		return super.processResultSet(condition);
	}
	
		
	public List<Object> findorderbymenu(String menu,String key){
		String sql;
		String sqlstring;
		ResultSet condition = null;
		if(key.equals("popular")){
			sql=this.sqlcode.getProperty("CD.queryorderbysales");
			sqlstring=MessageFormat.format(sql, new Object[]{menu});
			condition=this.dao.executeLookup(sqlstring, "CD.queryorderbysales");
		}else if(key.equals("redate")){
			sql=this.sqlcode.getProperty("CD.queryorderbydate");
			sqlstring=MessageFormat.format(sql, new Object[]{menu});
			condition=this.dao.executeLookup(sqlstring, "CD.queryorderbydate");
		}else if(key.equals("discount")){
			sql=this.sqlcode.getProperty("CD.queryorderbdiscount");
			sqlstring=MessageFormat.format(sql, new Object[]{menu});
			condition=this.dao.executeLookup(sqlstring, "CD.queryorderbdiscount");
		}else if(key.equals("price")){
			sql=this.sqlcode.getProperty("CD.queryorderbyprice");
			sqlstring=MessageFormat.format(sql, new Object[]{menu});
			condition=this.dao.executeLookup(sqlstring, "CD.queryorderbyprice");
		}
		
		return super.processResultSet(condition);
		
	}
	
	
	public int getstock(int cdid){
		String sql=this.sqlcode.getProperty("CD.getstock");
		String sqlstring=MessageFormat.format(sql, new Object[]{cdid});
		return getInteger(this.dao.executeLookup(sqlstring, "CD.getstock"), true);
		
	}

	
	@Override
	protected Object getDataObject(ResultSet rs, boolean close) {
		CD cd=null;
		try{
			if(rs.next()){
			
				SimpleDateFormat format=new SimpleDateFormat("yyyy-MM-dd");
				String date=format.format(rs.getDate(4).getTime());
				cd=new CD(rs.getInt(1),rs.getString(2),rs.getString(3),date,rs.getString(5),rs.getFloat(6),rs.getInt(7),rs.getString(8),rs.getInt(9));
			}
		}catch(SQLException e){
				e.printStackTrace();
			}finally{
				if(close){
					close(rs);
				}
			}
		return cd;
	}
	public boolean updatestock(int stock, int cdid) {
			String sql=this.sqlcode.getProperty("CD.updatestock");
			String sqlstring=MessageFormat.format(sql, new Object[]{stock,cdid});
			return this.dao.executeUpdate(sqlstring);	
	}


	@Override
	public Object findByPrimaryKey(int cdid) {
		String sql=this.sqlcode.getProperty("CD.searchbyid");
		String sqlstring=MessageFormat.format(sql, new Object[]{cdid});
		return getDataObject(this.dao.executeLookup(sqlstring,"CD.searchbyid"),true);
	}

	public List<Object> defaultsearch(String input) {
		String sql=this.sqlcode.getProperty("CD.defaultsearch");
		String sqlstring=MessageFormat.format(sql, new Object[]{input});
		return super.processResultSet(this.dao.executeLookup(sqlstring, "CD.defaultsearch"));
	}
	public List<Object> advancesearch(String input, String catename) {
		String sql=this.sqlcode.getProperty("CD.advancesearch");
		String sqlstring=MessageFormat.format(sql, new Object[]{input,catename});
		return super.processResultSet(this.dao.executeLookup(sqlstring, "CD.advancesearch"));
	}
	public List<Object> advancesearch(String input, String catename,String key) {
		String sql;
		String sqlstring;
		ResultSet condition = null;
		String keys;
		if(key.equals("redate")){
			keys="date";
			sql=this.sqlcode.getProperty("CD.ordersearch");
			sqlstring=MessageFormat.format(sql, new Object[]{input,catename,keys});
			condition=this.dao.executeLookup(sqlstring, "CD.ordersearch");
		}else if(key.equals("price")){
			keys="price";
			sql=this.sqlcode.getProperty("CD.ordersearch");
			sqlstring=MessageFormat.format(sql, new Object[]{input,catename,keys});
			condition=this.dao.executeLookup(sqlstring, "CD.ordersearch");
		}else if(key.equals("popular")){
			sql=this.sqlcode.getProperty("CD.ordersearchp");
			sqlstring=MessageFormat.format(sql, new Object[]{input,catename});
			condition=this.dao.executeLookup(sqlstring, "CD.ordersearchp");
		}else if(key.equals("discount")){
			sql=this.sqlcode.getProperty("CD.ordersearchd");
			sqlstring=MessageFormat.format(sql, new Object[]{input,catename});
			condition=this.dao.executeLookup(sqlstring, "CD.ordersearchd");
		}
		return super.processResultSet(condition);
	}
	
	
	@Override
	public boolean create(Object paramObject) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean update(Object paramObject) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean delete(int paramInt) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean delete(String paramString) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean delete(Object paramObject) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean deleteAll() {
		// TODO Auto-generated method stub
		return false;
	}


	@Override
	public Object findByPrimaryKey(String paramString) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Object find(Object paramObject) {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	protected Integer getInteger(ResultSet rs, boolean close) {
		Integer stock=0;
		try{
			if(rs.next()){
				stock=rs.getInt(1);
			}
		}catch(SQLException e){
				e.printStackTrace();
			}finally{
				if(close){
					close(rs);
				}
			}
		return stock;
	}
	
}
