package org.scauhci.official;

import java.io.IOException;

import org.scauhci.official.util.PropertityReader;

public class Config {
	public static String tmpPath=System.getProperty("java.io.tmpdir");
	public static String avatarPath;
	public static String filePath;
	public static String INIT_PASSWORD = "123456";
	
	public static int MANAGER_PAGE_SIZE;
	
	 static {
	        PropertityReader pr = null;
	        try {
	            pr = new PropertityReader("config.properties");
	        } catch (IOException ex) {
	        	ex.printStackTrace();	            
	        }
	        avatarPath=pr.get("avatarPath");
	        filePath=pr.get("filePath");
	        
	        MANAGER_PAGE_SIZE=Integer.parseInt(pr.get("managerPageSize"));
	        
	 }
	
}
