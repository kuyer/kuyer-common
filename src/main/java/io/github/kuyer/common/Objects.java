package io.github.kuyer.common;

/**
 * 对象工具类
 * @author rory.zhang
 */
public class Objects {
	
	/**
	 * 判断对象是否为空
	 * @param obj
	 * @return
	 */
	public static boolean isBlank(Object obj) {
		if(null == obj) {
			return true;
		}
		return false;
	}
	
	/**
	 * 判断对象是否不为空
	 * @param obj
	 * @return
	 */
	public static boolean isNotBlank(Object obj) {
		return !isBlank(obj);
	}
	
	/**
	 * 根据对象获取String信息
	 * @param obj
	 * @return
	 */
	public static String getString(Object obj) {
		if(null == obj) {
			return null;
		}
		return obj.toString().trim();
	}
	
	/**
	 * 根据对象获取String信息
	 * @param obj
	 * @return
	 */
	public static String getStringx(Object obj) {
		if(null == obj) {
			return "";
		}
		return obj.toString().trim();
	}

}
