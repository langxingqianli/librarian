package com.zhaolongefu.librarian.util;


import java.text.SimpleDateFormat;
import java.util.Date;

public class DateUtil {

	public static Date getbrithday(String str) throws Exception {
	
		SimpleDateFormat format = new SimpleDateFormat("yyyy/MM/dd");
		return format.parse(str);
	}
	
}
