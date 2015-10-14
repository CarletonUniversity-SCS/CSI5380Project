package edu.carleton.comp.cdstore.dao;

import java.sql.ResultSet;

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
		// TODO Auto-generated method stub
		return null;
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
