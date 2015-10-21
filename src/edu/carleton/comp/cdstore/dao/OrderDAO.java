package edu.carleton.comp.cdstore.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.MessageFormat;
import java.util.List;

import edu.carleton.comp.cdstore.models.Order;



public class OrderDAO extends DAO{
	public OrderDAO(){
		super.init();
		this.dao=new DAOHelper();
	}
	public OrderDAO(DAOHelper daohelper){
		super.init();
		this.dao=daohelper;
	}
	
	
	
	@Override
	public List<Object> findByPrimaryKey(int userid) {
		String sql=this.sqlcode.getProperty("order.searchbyuserid");
		String sqlstring=MessageFormat.format(sql, new Object[]{userid});
		return super.processResultSet(this.dao.executeLookup(sqlstring, "order.searchbyuserid"));
	
	}

	
	@Override
	protected Object getDataObject(ResultSet rs, boolean close) {
		Order order=null;
		try{
			if(rs.next()){
		order=new Order(rs.getInt(1),rs.getString(2),rs.getString(3),rs.getFloat(4),rs.getInt(5),rs.getInt(6),rs.getInt(7),rs.getInt(8),rs.getInt(9));
			}
		}catch(SQLException e){
			e.printStackTrace();
		}
		finally{
			if(close){
				close(rs);
			}
		}
		return order;
	}
	
	public  int createandgetkey(Object o){
	Order order=(Order) o;
	String sql=this.sqlcode.getProperty("order.create");
	String sqlString=MessageFormat.format(sql, new Object[]{
			order.getDate(),
			order.getStatus(),
			order.getTotal(),
			order.getUserid(),
			order.getAddrid(),
			order.getBillid(),
			order.getShipid(),
			order.getTaxid()
	});
	return this.dao.executeandgetkey(sqlString);
	}
	
	public  int createandgetkeynull(Object o){
		Order order=(Order) o;
		

		String sql=this.sqlcode.getProperty("order.createnull");
		String sqlString=MessageFormat.format(sql, new Object[]{
				order.getOrderid(),
				order.getDate(),
				order.getStatus(),
				order.getTotal(),
				order.getUserid(),
				order.getAddrid(),
				order.getBillid(),
				order.getShipid(),
				order.getTaxid()
		});
		return this.dao.executeandgetkey(sqlString);
		}
		
	public boolean updateaddr(int orderid, int addrid) {
		String sql=this.sqlcode.getProperty("order.updateaddr");
		String sqlstring=MessageFormat.format(sql, new Object[]{orderid,addrid});
		return this.dao.executeUpdate(sqlstring);	
}
	public boolean updatebilladdr(int orderid, int billid) {
		String sql=this.sqlcode.getProperty("order.updatebilladdr");
		String sqlstring=MessageFormat.format(sql, new Object[]{orderid,billid});
		return this.dao.executeUpdate(sqlstring);	
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
	public boolean create(Object paramObject) {
		// TODO Auto-generated method stub
		return false;
	}
	@Override
	protected Integer getInteger(ResultSet paramResultSet, boolean paramBoolean) {
		// TODO Auto-generated method stub
		return null;
	}
	public List<Object> getrecentorder(int userid) {
		String sql=this.sqlcode.getProperty("order.getrecentorder");
		String sqlstring=MessageFormat.format(sql, new Object[]{userid});
		return super.processResultSet(this.dao.executeLookup(sqlstring, "order.getrecentorder"));
	}

	
}
