package edu.carleton.comp.cdstore.util;

import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;
import java.util.Vector;
public final class ConnectionPool {
	private static String dbURL=null;
	private static String username=null;
	private static String password=null;
	private static String host=null;
	private static String port=null;
	private static String schema=null;
	private static String driverType=null;
	private static String jdbcDriver=null;
	private static Integer maxNumberofConnections=null;
	private static ConnectionPool instance=null;
	private Vector<Connection> connectionPool=null;	
	private static int connectionID=0;
	/*define a connection pool*/
	private ConnectionPool(){
		setURL();
		this.connectionPool=new Vector<Connection>(maxNumberofConnections.intValue());
		for(int i=0;i<maxNumberofConnections.intValue();i++){
			this.connectionPool.add(getDefaultConnection());
		}
	}
	/*method for returning a instance of connection pool*/
	public static synchronized ConnectionPool getInstance(){
		if(instance==null){
			synchronized(ConnectionPool.class){
				if(instance==null){
					instance=new ConnectionPool();
				}
			}
		}
		return instance;
	}
	/*method for pulling out a connection from pool to use*/
	public Connection getConnection(){
		return (Connection)this.connectionPool.get(connectionID++);
	}
	/*return a connection to the pool*/
	public boolean returnConnection(Connection connection){
		connectionID-=1;
		this.connectionPool.set(connectionID, connection);
		return true;
	}
	/*shutdown the entire connectionPool instance release resource*/
	public boolean shutDown(){
		for(int i=maxNumberofConnections.intValue()-1;i>=0;i++){
			try{
				
				((Connection)this.connectionPool.get(i)).close();
				this.connectionPool.remove(i);
			}catch(SQLException e)
			{
				e.printStackTrace();
				return false;
			}	
		}
		this.connectionPool=null;
		instance=null;
		return true;
	}
	
	public void finalize()throws Throwable{}
	/*default getting connection method*/
	private Connection getDefaultConnection(){
		Connection connection=null;
		try{
			Class.forName(jdbcDriver).newInstance();
			connection=DriverManager.getConnection(dbURL,username,password);
			connection.setAutoCommit(true);
		}catch(Exception e){
			e.printStackTrace();
		}
		return connection;
	}
	
//	public static Connection getConnection(String schema, String username, String password){
//		Connection connection=null;
//		try{
//			Class.forName(jdbcDriver).newInstance();
//			connection=DriverManager.getConnection(dbURL,username,password);
//			connection.setAutoCommit(true);
//		}catch(Exception e){
//			e.printStackTrace();
//		}
//		return connection;
//	}
	/*get database parameter from configure.properties*/
	private static void setURL(){
		Properties p=new Properties();
		try{
			FileReader reader=new FileReader(ConfigProperties.getInstance().URL);
			p.load(reader);
			host=p.getProperty("host");
			port=p.getProperty("port");
			username=p.getProperty("username");
			password=p.getProperty("password");
			schema=p.getProperty("schema");
			jdbcDriver=p.getProperty("jdbcDriver");
			driverType=p.getProperty("driverType");
			maxNumberofConnections=new Integer(p.getProperty("maxNumberofConnections"));
			dbURL="";
			dbURL+=driverType;
			dbURL+="://";
			dbURL+=host;
			dbURL+=":";
			dbURL+=port;
			dbURL+="/";
			dbURL+=schema;
		}
		catch(IOException e){
			e.printStackTrace();
		}
	}


}
