package edu.carleton.comp.cdstore.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.MessageFormat;
import edu.carleton.comp.cdstore.models.Address;

public class AddressDAO extends DAO {
	public AddressDAO(){
		super.init();
		this.dao=new DAOHelper();
	}
	public AddressDAO(DAOHelper daohelper){
		super.init();
		this.dao=daohelper;
	}
	
	@Override
	protected Object getDataObject(ResultSet rs, boolean close) {
		Address address=null;
		try{
			if(rs.next()){
				address=new Address(rs.getInt(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getString(5),rs.getString(6),rs.getString(7),rs.getString(8),rs.getInt(9));
			}
		}catch(SQLException e){
			e.printStackTrace();
		}
		finally{
			if(close){
				close(rs);
			}
		}
		return address;
	}
	@Override
	public Object findByPrimaryKey(int userid) {
		String sql=this.sqlcode.getProperty("address.searchbyuserid");
		String sqlstring=MessageFormat.format(sql, new Object[]{userid});
		return getDataObject(this.dao.executeLookup(sqlstring,"customer.lookupuser"),true);
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
