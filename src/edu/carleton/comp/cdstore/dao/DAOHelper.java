package edu.carleton.comp.cdstore.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import edu.carleton.comp.cdstore.util.DBConnection;

public class DAOHelper {
	public int affectedrow;
	private DBConnection connection=null;
	
	public DAOHelper(){
		this.connection=new DBConnection();
	}
	
	public boolean execute(String sql){
		return this.connection.executeStatement(sql);
	}
	
	public boolean executeUpdate(String sql){
		affectedrow=this.connection.executeUpdate(sql);
		return affectedrow!=0;
	}
	
	public ResultSet executeLookup(String sql, String originator){
		PreparedStatement ps=null;
		try{
			ps=this.connection.prepareStatement(sql);
			return ps.executeQuery(sql);
		}catch(Exception e){
			e.printStackTrace();
		}
		return null;
	}
	
	
	
//	public boolean executeStoredProcedure(String sql, String originator){
//		PreparedStatement ps=null;
//		try{
//			ps=this.connection.prepareStatement(sql);
//			return ps.execute();
//		}catch(Exception e){
//			e.printStackTrace();
//		}
//		return false;
//	} 
	
	public boolean returnConnection(){
		if(this.connection!=null){
			this.connection.returnConnection();
			this.connection=null;
		}
		return true;
	}
	
//	protected ResultSet getNextRow(ResultSet rs){
//		try{
//			if(rs.next())
//				return rs;
//		}catch(SQLException e){
//			e.printStackTrace();
//			return null;
//		}
//		return rs;
//	}
	
	protected void close(ResultSet rs){
		if(rs!=null){
		try{	
			rs.close();
			}catch(SQLException e){
			e.printStackTrace();
				}
			}
		}
}
