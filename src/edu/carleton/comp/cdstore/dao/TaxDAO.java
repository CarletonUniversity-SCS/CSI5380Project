package edu.carleton.comp.cdstore.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.MessageFormat;
import java.util.List;

import edu.carleton.comp.cdstore.models.Tax;

public class TaxDAO extends DAO{
	public TaxDAO(){
		super.init();
		this.dao=new DAOHelper();
	}
	public TaxDAO(DAOHelper daohelper){
		super.init();
		this.dao=daohelper;
	}
	
	@Override
	protected Object getDataObject(ResultSet rs, boolean close) {
		Tax tax=null;
		try{
			if(rs.next())
				tax=new Tax(rs.getInt(1),rs.getString(2),rs.getFloat(3));
		}catch(SQLException e){
			e.printStackTrace();
		}
		finally{
			if(close){
				close(rs);
			}
		}
		return tax;
}
	@Override
	public Object findByPrimaryKey(int taxid) {
		String sql=this.sqlcode.getProperty("tax.searchbytaxid");
		String sqlstring=MessageFormat.format(sql, new Object[]{taxid});
		return getDataObject(this.dao.executeLookup(sqlstring, "tax.searchbytaxid"),true);
	}

	public List<Object> findall(){
		String sql=this.sqlcode.getProperty("tax.findall");
		return super.processResultSet(this.dao.executeLookup(sql, "tax.findall"));
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
	protected Integer getInteger(ResultSet paramResultSet, boolean paramBoolean) {
		// TODO Auto-generated method stub
		return null;
	}


	
}
