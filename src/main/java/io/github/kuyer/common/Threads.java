package io.github.kuyer.common;

import java.util.Random;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 线程工具类
 * @author rory.zhang
 */
public class Threads {
	
	private static final Logger logger = LoggerFactory.getLogger(Dates.class);
	
	/** sleep **/
	public static void sleep(Long millis) {
		if(null == millis) {
			return;
		}
		try {
			logger.info("sleep "+millis+" ms");
			Thread.sleep(millis);
		} catch (Exception e) {
			logger.error("sleep "+millis+" ms error.", e);
		}
	}
	
	/** sleep 时间随机 **/
	public static void sleep() {
		long millis = new Random().nextInt(10)*500;
		sleep(millis);
	}
	
	/** sleep 时间随机 时间相对长 **/
	public static void sleepLong() {
		long millis = new Random().nextInt(60)*1000;
		sleep(millis);
	}
	
	/** sleep 时间随机 时间相对短 **/
	public static void sleepLittle() {
		long millis = new Random().nextInt(10)*50;
		sleep(millis);
	}

}
