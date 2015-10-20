package edu.carleton.comp.cdstore.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.MessageFormat;
import edu.carleton.comp.cdstore.models.Item;

public class ItemDAO extends DAO {
	public ItemDAO(){
		super.init();
		this.dao=new DAOHelper();
	}
	public ItemDAO(DAOHelper daohelper){
		super.init();
		this.dao=daohelper;
	}
	@Override
	protected Object getDataObject(ResultSet rs, boolean close) {
			Item item=null;	
			try{
				if(rs.next())
					item=new Item(rs.getInt(0),rs.getInt(1),rs.getInt(2),rs.getInt(3));	
			}catch(SQLException e){
				e.printStackTrace();
			}
			finally{
				if(close){
					close(rs);
				}
			}
			return item;
		}
	@Override
	public boolean create(Object o) {
		Item item=(Item) o;
		String sql=this.sqlcode.getProperty("item.create");
		String sqlString=MessageFormat.format(sql, new Object[]{
			item.getCount(),
			item.getOrdid(),
			item.getCdid()
		});
		return this.dao.execute(sqlString);
	}
	@Override
	public Object findByPrimaryKey(int orderid) {
		String sql=this.sqlcode.getProperty("item.searchbyorderid");
		String sqlstring=MessageFormat.format(sql, new Object[]{orderid});
		return getDataObject(this.dao.executeLookup(sqlstring,"item.searchbyorderid"),true);
	}
	
	@Override
	public boolean delete(int itemid) {
		// TODO Auto-generated method stub
		return false;
	}


	@Override
	public boolean update(Object paramObject) {
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
