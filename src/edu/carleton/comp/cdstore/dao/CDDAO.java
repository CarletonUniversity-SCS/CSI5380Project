package edu.carleton.comp.cdstore.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.MessageFormat;
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
	@Override
	protected Object getDataObject(ResultSet rs, boolean close) {
		CD cd=null;
		try{
			if(rs.next()){
				cd=new CD(rs.getInt(1),rs.getString(2),rs.getString(3),rs.getDate(4),rs.getString(5),rs.getFloat(6),rs.getInt(7),rs.getString(8),rs.getInt(9));
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
	
	

	@Override
	public Object findByPrimaryKey(int cdid) {
		String sql=this.sqlcode.getProperty("cd.searchbyid");
		String sqlstring=MessageFormat.format(sql, new Object[]{cdid});
		return getDataObject(this.dao.executeLookup(sqlstring,"cd.searchbyid"),true);
	}

	public Object defaultsearch(String input) {
		String sql=this.sqlcode.getProperty("cd.defaultsearch");
		String sqlstring=MessageFormat.format(sql, new Object[]{input});
		return getDataObject(this.dao.executeLookup(sqlstring,"cd.defaultsearch"),true);
	}
	public Object advancesearch(String input, int cateid) {
		String sql=this.sqlcode.getProperty("cd.advancesearch");
		String sqlstring=MessageFormat.format(sql, new Object[]{input,cateid});
		return getDataObject(this.dao.executeLookup(sqlstring,"cd.advancesearch"),true);
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
