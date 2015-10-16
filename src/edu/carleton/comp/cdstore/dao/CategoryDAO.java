package edu.carleton.comp.cdstore.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.MessageFormat;
import java.util.List;

import edu.carleton.comp.cdstore.models.Category;

public class CategoryDAO extends DAO{
	public CategoryDAO(){
		super.init();
		this.dao=new DAOHelper();
	}
	public CategoryDAO(DAOHelper daohelper){
		super.init();
		this.dao=daohelper;
	}
	
	public List<Object> findall(){
		String sql=this.sqlcode.getProperty("category.findall");
		return super.processResultSet(this.dao.executeLookup(sql, "category.findall"));
	}
	
	@Override
	protected Object getDataObject(ResultSet rs, boolean close) {
		Category category=null;
		try{
			if(rs.next()){
				category=new Category(rs.getInt(1),rs.getString(2));
			}
		}catch(SQLException e){
			e.printStackTrace();
		}
		finally{
			if(close){
				close(rs);
			}
		}
		return category;
	}
	
	
	@Override
	public Object findByPrimaryKey(int cateid) {
		String sql=this.sqlcode.getProperty("category.searchbyid");
		String sqlstring=MessageFormat.format(sql, new Object[]{cateid});
		return getDataObject(this.dao.executeLookup(sqlstring,"category.searchbyid"),true);
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
	
}
