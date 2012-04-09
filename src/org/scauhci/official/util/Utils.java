package org.scauhci.official.util;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class Utils {
	public static String getMD5(String s)
	{
		MessageDigest md;
		try {
			md = MessageDigest.getInstance("MD5");
			md.update(s.getBytes());
			byte[] bs=md.digest();
			StringBuilder sb=new StringBuilder();
			for(byte b:bs)
			{
				 String tmp=Integer.toHexString(b & 0xFF);
				 if(tmp.length()==1)
					 sb.append("0");
				 sb.append(tmp);
			}
			return sb.toString();
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		}
		return null;
	}
}
