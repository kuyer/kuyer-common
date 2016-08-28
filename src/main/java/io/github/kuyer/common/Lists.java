package io.github.kuyer.common;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

/**
 * 容器工具类
 * @author rory.zhang
 */
public class Lists {
	
	/** 判断list是否为空 **/
	public static <T> boolean isEmpty(List<T> list) {
		if(null==list || list.size()<=0) {
			return true;
		}
		return false;
	}
	
	/** 判断list是否为空 **/
	public static <T> boolean isNotEmpty(List<T> list) {
		return !isEmpty(list);
	}
	
	/** String转数组 **/
	public static List<String> toStringArray(String strs) {
		return toStringArray(strs, ",");
	}
	
	/** 根据符号String转数组 **/
	public static List<String> toStringArray(String strs, String symbol) {
		if(null==strs || Strings.isEmpty(strs)) {
			return new ArrayList<String>();
		}
		List<String> list = new ArrayList<String>();
		String[] strx = strs.split(symbol);
		for(String str : strx) {
			if(Strings.isNotEmpty(str)) {
				list.add(str.trim());
			}
		}
		return list;
	}
	
	/** List转Array **/
	@SuppressWarnings("unchecked")
	public static <T> T[] toArray(List<T> list, Class<T> type) {
		int size = 0;
		if(null!=list && list.size()>=1) {
			size = list.size();
		}
		T[] arr = (T[]) Array.newInstance(type, size);
		if(size>=1) {
			for(int i=0; i<size; i++) {
				arr[i] = list.get(i);
			}
		}
		return arr;
	}

}
