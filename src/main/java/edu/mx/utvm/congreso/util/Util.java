package edu.mx.utvm.congreso.util;

import org.apache.commons.codec.binary.Base64;

public class Util {	
		
	public static String generateToken(String md5) {
		try {
			java.security.MessageDigest md = java.security.MessageDigest
					.getInstance("MD5");
			byte[] array = md.digest(md5.getBytes());
			StringBuffer sb = new StringBuffer();
			for (int i = 0; i < array.length; ++i) {
				sb.append(Integer.toHexString((array[i] & 0xFF) | 0x100)
						.substring(1, 3));
			}
			return sb.toString();
		} catch (java.security.NoSuchAlgorithmException e) {
		}
		return null;
	}
	
	public static String encodeNumber(Integer number){
		number = number * 1234567890; 
		byte[] encoded = Base64.encodeBase64(String.valueOf(number).getBytes());
		return new String(encoded);
	}
	
	public static Integer decodeNumber(String str){
		byte[] decoded = Base64.decodeBase64(str.getBytes());
		return Integer.parseInt(new String(decoded)) / 1234567890;
	}
}
