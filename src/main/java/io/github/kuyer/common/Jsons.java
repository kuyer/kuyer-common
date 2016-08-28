package io.github.kuyer.common;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.alibaba.fastjson.JSON;

/**
 * JSON工具类
 * @author rory.zhang
 */
public class Jsons {
	
	private static final Logger logger = LoggerFactory.getLogger(Jsons.class);
	
	/**
	 * 对象转json
	 * @param obj
	 * @return
	 */
	public static String toJson(Object obj) {
		if(null == obj) {
			return null;
		}
		try {
			return JSON.toJSONString(obj);
		} catch (Exception e) {
			logger.error(String.format("toJson error. param: %s", obj.toString()), e);
		}
		return null;
	}
	
	/** 转换为JSON对象 **/
	public static <T> T toJsonObject(String str, Class<T> clazz) {
		if(Strings.isEmpty(str)) {
			return null;
		}
		try {
			return JSON.parseObject(str.trim(), clazz);
		} catch (Exception e) {
			logger.error(String.format("toJsonObject error. param: %s", str), e);
		}
		return null;
		
	}
	
	/** 转换JSON数组 **/
	public static <T> List<T> toJsonArray(String str, Class<T> clazz) {
		if(Strings.isEmpty(str)) {
			return new ArrayList<T>();
		}
		try {
			return JSON.parseArray(str.trim(), clazz);
		} catch (Exception e) {
			logger.error(String.format("toJsonObject error. param: %s", str), e);
		}
		return new ArrayList<T>();
	}
	
}
