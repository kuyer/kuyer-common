package io.github.kuyer.common;

/**
 * 字符串工具类
 * @author rory.zhang
 */
public class Strings {
	
	/**
	 * 判断字符串是否为空
	 * @param str
	 * @return
	 */
	public static boolean isEmpty(String str) {
		if(null == str) {
			return true;
		}
		if("".equals(str.trim())) {
			return true;
		}
		return false;
	}
	
	/**
	 * 判断字符串是否不为空
	 * @param str
	 * @return
	 */
	public static boolean isNotEmpty(String str) {
		return !isEmpty(str);
	}
	
	/**
	 * 获取字符串
	 * @param str
	 * @return
	 */
	public static String getString(String str) {
		if(null == str) {
			return "";
		}
		return str.trim();
	}

}
