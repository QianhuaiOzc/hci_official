package org.scauhci.official;

import java.io.IOException;

import org.scauhci.official.util.PropertityReader;

public class Config {
	
	public static String apiKey;
	public static String base ;
	
	//系统临时文件夹
	public static String tmpPath=System.getProperty("java.io.tmpdir");
	//头像路径
	public static String avatarPath;
	//项目图片路径
	public static String projectImagePath;
	//默认头像
	public static String defaultAvatar;
	//默认项目图片
	public static String defaultProjectImage;
	
	public static String memberIndexPath;
	public static String projectIndexPath;
	public static String articleIndexPath;
	
	public static String filePath;
	public static String INIT_PASSWORD = "123456";
	
	public static int SEARCH_PAGE_SIZE;
	public static int SEARCH_MAX_PAGE_SIZE;
	
	public static int MANAGER_PAGE_SIZE;
	
	 static {
	        PropertityReader pr = null;
	        try {
	            pr = new PropertityReader("config.properties");
	        } catch (IOException ex) {
	        	ex.printStackTrace();	            
	        }
	        apiKey=pr.get("apiKey");
	        base=pr.get("base");
	        avatarPath=pr.get("avatarPath");
	        filePath=pr.get("filePath");
	        projectImagePath=pr.get("projectImagePath");
	        defaultAvatar=pr.get("defaultAvatar");
	        defaultProjectImage=pr.get("defaultProjectImage");
	        memberIndexPath=pr.get("memberIndexPath");
	        projectIndexPath=pr.get("projectIndexPath");
	        
	        MANAGER_PAGE_SIZE=Integer.parseInt(pr.get("managerPageSize"));
	        SEARCH_PAGE_SIZE=Integer.parseInt(pr.get("searchPageSize"));
	        SEARCH_MAX_PAGE_SIZE=Integer.parseInt(pr.get("searchMaxPageSize"));
	        
	 }
	
}
