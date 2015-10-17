package edu.carleton.comp.cdstore.util;

import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

public class ConfigProperties {
	private static ConfigProperties instance=null;
	public String URL=null;
	public String SQL_DIR=null;
	public static String WORKING_DIR=null;
	private ConfigProperties(){
		this.URL=(WORKING_DIR+"/configure.properties");
		this.SQL_DIR=(WORKING_DIR+"/sql.properties");
		System.out.println("URL:"+this.URL);
		System.out.println("Sql dir:"+this.SQL_DIR);
		//init();
	}
	/*getting a property file reader instance */
	public static synchronized ConfigProperties getInstance() {
		String loc=ConfigProperties.class.getProtectionDomain().getCodeSource().getLocation().getPath();
		// TODO Auto-generated method stub
		if(instance==null){
			WORKING_DIR=loc;
			synchronized(ConfigProperties.class){
				if(instance==null){
					instance=new ConfigProperties();
				}
			}
		}
		return instance;
	}
	/*method for retrieving a property by name*/
	public String getProperty(String property){
	String pValue=null;
	Properties p=new Properties();
	try{
		FileReader reader =new FileReader(this.URL);
		p.load(reader);
		pValue=p.getProperty(property);
		reader.close();
		}catch(IOException e){
			e.printStackTrace();
		}
	return pValue;
	}
	/*private void init(){
		Properties p=new Properties();
		try{
			FileReader reader =new FileReader(this.URL);
			p.load(reader);
			reader.close();
		}catch(Exception e){
			e.printStackTrace();
		}
	}*/
	/*destory the reader instance*/
	public void destory(){
		instance=null;
	}
}
