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
		return getDataObject(this.dao.executeLookup(sqlstring,"address.searchbyuserid"),true);
	}

	public int getaddrid(int userid){
		String sql=this.sqlcode.getProperty("address.getaddrid");
		String sqlstring=MessageFormat.format(sql, new Object[]{userid});
		return getInteger(this.dao.executeLookup(sqlstring, "address.getaddrid"), true);
	}

	public boolean create(Object o) {
		Address address=(Address) o;
		String sql=this.sqlcode.getProperty("address.create");
		String sqlString=MessageFormat.format(sql, new Object[]{
			address.getAddrline1(),
			address.getAddrline2(),
			address.getCity(),
			address.getProvince(),
			address.getZipcode(),
			address.getCountry(),
			address.getPhone(),
			address.getUserid()});
		return this.dao.executeUpdate(sqlString);
}
	

	public boolean update(int userid,Object o) {
		Address address=(Address) o;
		String sql=this.sqlcode.getProperty("address.update");
		String sqlString=MessageFormat.format(sql, new Object[]{
				address.getAddrline1(),
				address.getAddrline2(),
				address.getCity(),
				address.getProvince(),
				address.getZipcode(),
				address.getCountry(),
				address.getPhone(),
				userid});
		return this.dao.executeUpdate(sqlString);
	}

	//@Override
//	public boolean update(Object o) {
//		Address address=(Address)o;
//		if(findByPrimaryKey(address.getAddrid())==null){
//			return false;
//		String sql=this.sqlcode.getProperty("address.update");
//		String sqlString=MessageFormat.format(sql, new Object[]{
//			//	address.get
//		})
//		}
//		
//	}

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
	public boolean update(Object paramObject) {
		// TODO Auto-generated method stub
		return false;
	}
	@Override
	protected Integer getInteger(ResultSet rs, boolean close) {
		Integer addrid=0;
		try{
			if(rs.next()){
				addrid=rs.getInt(1);
			}
		}catch(SQLException e){
				e.printStackTrace();
			}finally{
				if(close){
					close(rs);
				}
			}
		return addrid;
	}
	}
	

	