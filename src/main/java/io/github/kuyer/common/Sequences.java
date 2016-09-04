package io.github.kuyer.common;

import java.util.UUID;

/**
 * 序列工具类
 * @author rory.zhang
 */
public class Sequences {
	
	/**
	 * 获取ID
	 * @return
	 */
	public static String getId() {
		return UUID.randomUUID().toString().replaceAll("-", "");
	}

}
