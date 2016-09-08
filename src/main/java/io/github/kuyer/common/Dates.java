package io.github.kuyer.common;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Period;
import java.time.ZoneId;
import java.time.temporal.ChronoUnit;
import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 日期工具类
 * @author rory.zhang
 */
public class Dates {
	
	private static final Logger logger = LoggerFactory.getLogger(Dates.class);
	
	/** 日期&时间格式 **/
	public static final String FORMAT_DATE_TIME = "yyyy-MM-dd HH:mm:ss";
	/** 日期&T时间格式 **/
	public static final String FORMAT_DATE_TIME_T = "yyyy-MM-dd'T'HH:mm:ss";
	/** 日期&T时间格式Z **/
	public static final String FORMAT_DATE_TIME_TZ = "yyyy-MM-dd'T'HH:mm:ss'Z'";
	/** 日期时间格式 **/
	public static final String FORMAT_DATETIME = "yyyyMMddHHmmss";
	/** 日期T时间格式 **/
	public static final String FORMAT_DATETIME_T = "yyyyMMdd'T'HHmmss";
	/** 日期T时间格式Z **/
	public static final String FORMAT_DATETIME_TZ = "yyyyMMdd'T'HHmmss'Z'";
	/** 日期格式 **/
	public static final String FORMAT_DATE = "yyyy-MM-dd";
	/** 日期格式 **/
	public static final String FORMAT_DATE_X = "yyyyMMdd";
	/** 时间格式 **/
	public static final String FORMAT_TIME = "HH:mm:ss";
	/** 时间格式 **/
	public static final String FORMAT_TIME_X = "HHmmss";
	/** 年格式 **/
	public static final String FORMAT_YEAR = "yyyy";
	/** 年月格式 **/
	public static final String FORMAT_YEAR_MONTH = "yyyy-MM";
	/** 年月格式 **/
	public static final String FORMAT_MONTH_DAY = "MM-dd";
	/** 小时格式 **/
	public static final String FORMAT_HOUR = "HH";
	/** 小时分钟格式 **/
	public static final String FORMAT_HOUR_MINUTE = "HH:mm";
	
	/** 获取当前时间戳 **/
	public static Long getCurrent() {
		return System.currentTimeMillis();
	}
	
	/** 当期时间转为字符串 yyyy-MM-dd HH:mm:ss格式 **/
	public static String getString() {
		return getString(new Date(), FORMAT_DATE_TIME);
	}
	
	/** 当期时间转为字符串 **/
	public static String getString(String format) {
		return getString(new Date(), format);
	}
	
	/** 时间转为字符串 **/
	public static String getString(Date date, String format) {
		if(null==date || Strings.isEmpty(format)) {
			return "";
		}
		try {
			SimpleDateFormat sdf = new SimpleDateFormat(format);
			return sdf.format(date);
		} catch (Exception e) {
			logger.error(String.format("getString error. date: %s; format: %s.", date.toString(), format), e);
		}
		return "";
	}
	
	/** 字符串转为时间 yyyy-MM-dd HH:mm:ss格式 **/
	public static Date getDate(String str) {
		return getDate(str, FORMAT_DATE_TIME);
	}
	
	/** 字符串转为时间 **/
	public static Date getDate(String str, String format) {
		if(null==str || Strings.isEmpty(format)) {
			return null;
		}
		try {
			SimpleDateFormat sdf = new SimpleDateFormat(format);
			return sdf.parse(str);
		} catch (Exception e) {
			logger.error(String.format("getString error. string: %s; format: %s.", str, format), e);
		}
		return null;
	}
	
	/**
	 * datetime转为date 没有时分秒
	 * @param date
	 * @return
	 */
	public static Date getDate(Date date) {//TODO
		LocalDate datetime = LocalDateTime.ofInstant(date.toInstant(), ZoneId.systemDefault()).toLocalDate();
		return Date.from(datetime.atStartOfDay(ZoneId.systemDefault()).toInstant());
	}
	
	/**
	 * 获取两个时间的秒数
	 * @param date1
	 * @param date2
	 * @return
	 */
	public static long getSeconds(Date date1, Date date2) {
		return toLocalDateTime(date1).until(toLocalDateTime(date2), ChronoUnit.SECONDS);
	}
	
	/**
	 * 获取两个时间的分钟数
	 * @param date1
	 * @param date2
	 * @return
	 */
	public static long getMinutes(Date date1, Date date2) {
		return toLocalDateTime(date1).until(toLocalDateTime(date2), ChronoUnit.MINUTES);
	}
	
	/**
	 * 获取两个时间的小时数
	 * @param date1
	 * @param date2
	 * @return
	 */
	public static long getHours(Date date1, Date date2) {
		return toLocalDateTime(date1).until(toLocalDateTime(date2), ChronoUnit.HOURS);
	}
	
	/**
	 * 获取两个日期之间的天数
	 * @param date1
	 * @param date2
	 * @return
	 */
	public static int getDays(Date date1, Date date2) {
		Period period = Period.between(toLocalDate(date1), toLocalDate(date2));
		return period.getDays();
	}
	
	/**
	 * 获取两个日期的周数
	 * @param date1
	 * @param date2
	 * @return
	 */
	public static long getWeeks(Date date1, Date date2) {
		return toLocalDate(date1).until(toLocalDate(date2), ChronoUnit.WEEKS);
	}
	
	/**
	 * 获取两个日期之间的月数
	 * @param date1
	 * @param date2
	 * @return
	 */
	public static int getMonths(Date date1, Date date2) {
		Period period = Period.between(toLocalDate(date1), toLocalDate(date2));
		return period.getMonths();
	}
	
	/**
	 * 获取两个日期之间的年数
	 * @param date1
	 * @param date2
	 * @return
	 */
	public static int getYears(Date date1, Date date2) {
		Period period = Period.between(toLocalDate(date1), toLocalDate(date2));
		return period.getYears();
	}
	
	/**
	 * 转date类型为localdate类型
	 * @param date
	 * @return
	 */
	private static LocalDate toLocalDate(Date date) {
		return toLocalDateTime(date).toLocalDate();
	}
	
	/**
	 * 转date类型为localdatetime类型
	 * @param date
	 * @return
	 */
	private static LocalDateTime toLocalDateTime(Date date) {
		return LocalDateTime.ofInstant(date.toInstant(), ZoneId.systemDefault());
	}
	
}
