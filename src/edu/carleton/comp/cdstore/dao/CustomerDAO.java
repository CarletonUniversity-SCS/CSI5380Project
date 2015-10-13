package edu.carleton.comp.cdstore.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.MessageFormat;
import java.util.List;

import edu.carleton.comp.cdstore.models.Customer;

public class CustomerDAO extends DAO {
		
		public CustomerDAO(){
			super.init();
			this.dao=new DAOHelper();
		}
		public CustomerDAO(DAOHelper daohelper){
			super.init();
			this.dao=daohelper;
		}
		
		public List<Object> findall(){
			String sql=this.sqlcode.getProperty("customer.findall");
			return super.processResultSet(this.dao.executeLookup(sql, "customer.findall"));
		}
		
	
		
		
		@Override
		public Object findByPrimaryKey(String paramString) {
			String sql=this.sqlcode.getProperty("test.lookupuser");
			String sqlstring=MessageFormat.format(sql, new Object[]{paramString});
			return getDataObject(this.dao.executeLookup(sqlstring,"test.lookupuser"),true);
		}
		@Override
		protected Object getDataObject(ResultSet rs, boolean close) {
			Customer customer=null;
			try{
				if(rs.next()){
					customer=new Customer(rs.getString(2),rs.getString(3),rs.getString(4),rs.getString(5));
				}
			}catch(SQLException e){
				e.printStackTrace();
			}
			finally{
				if(close){
					close(rs);
				}
			}
			return customer;
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
	public Object findByPrimaryKey(int paramInt) {
		// TODO Auto-generated method stub
		return null;
	}
	
	@Override
	public Object find(Object paramObject) {
		// TODO Auto-generated method stub
		return null;
	}
}
