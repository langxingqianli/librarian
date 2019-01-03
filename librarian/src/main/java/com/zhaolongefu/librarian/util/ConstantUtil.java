package com.zhaolongefu.librarian.util;

import java.util.Properties;


public class ConstantUtil {
private static Properties props = new Properties();
	
	static {
		try {
			props.load(ConstantUtil.class.getClassLoader()
					.getResourceAsStream("system.properties"));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	public static final Integer PAGE_NUM = Integer.parseInt(props.getProperty("system.page.num"));
	public static final Integer PAGE_SIZE = Integer.parseInt(props.getProperty("system.page.size"));
	public static final Integer USERTYPE_ORDIN = Integer.parseInt(props.getProperty("system.usertype.ordinary"));
	public static final Integer USERTYPE_ADIME = Integer.parseInt(props.getProperty("system.usertype.admin"));
	public static final String SEX_MALE = props.getProperty("system.sex.male");
	public static final String SEX_FEMALE = props.getProperty("system.sex.female");
}
