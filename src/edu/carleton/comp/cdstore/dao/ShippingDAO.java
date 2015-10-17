package edu.carleton.comp.cdstore.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.MessageFormat;
import java.util.List;

import edu.carleton.comp.cdstore.models.Shipping;

public class ShippingDAO extends DAO{
	
	public ShippingDAO(){
		super.init();
		this.dao=new DAOHelper();
	}
	public ShippingDAO(DAOHelper daohelper){
		super.init();
		this.dao=daohelper;
	}
	
	public List<Object> findall(){
		String sql=this.sqlcode.getProperty("shipping.findall");
		return super.processResultSet(this.dao.executeLookup(sql, "shipping.findall"));
	}
	
	
	
	@Override
	public Object findByPrimaryKey(int shipid) {
		String sql=this.sqlcode.getProperty("shipping.searchbyshipid");
		String sqlstring=MessageFormat.format(sql, new Object[]{shipid});
		return getDataObject(this.dao.executeLookup(sqlstring, "shipping.searchbyshipid"),true);
	}

	@Override
	protected Object getDataObject(ResultSet rs, boolean close) {
			Shipping shipping=null;
			try{
				if(rs.next())
					shipping=new Shipping(rs.getInt(1),rs.getString(2),rs.getFloat(3));
			}catch(SQLException e){
				e.printStackTrace();
			}
			finally{
				if(close){
					close(rs);
				}
			}
			return shipping;
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
