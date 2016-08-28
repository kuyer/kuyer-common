package io.github.kuyer.common;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 工具类
 * @author rory.zhang
 */
public class Tools {
	
	private static final Logger logger = LoggerFactory.getLogger(Tools.class);
	
	/** 
	 * 验证是否手机号
	 * 要更加准确的匹配手机号码只匹配11位数字是不够的，比如说就没有以144开始的号码段，
	 * 故先要整清楚现在已经开放了多少个号码段，国家号码段分配如下：
	 * 移动：134、135、136、137、138、139、150、151、157(TD)、158、159、187、188
	 * 联通：130、131、132、152、155、156、185、186
	 * 电信：133、153、180、189、（1349卫通）
	 * 中国电信发布中国3G号码段:
	 * 中国联通185,186;
	 * 中国移动188,187;
	 * 中国电信189,180共6个号段。
	 * 3G业务专属的180-189号段已基本分配给各运营商使用, 其中180、189分配给中国电信,187、188归中国移动使用,185、186属于新联通。
	 * 中国移动拥有号码段：139、138、137、136、135、134、159、158、157（3G）、152、151、150、188（3G）、187（3G）;14个号段
	 * 中国联通拥有号码段：130、131、132、155、156（3G）、186（3G）、185（3G）;6个号段
	 * 中国电信拥有号码段：133、153、189（3G）、180（3G）;4个号码段
	 * 移动:
	 * 2G号段(GSM网络)有139,138,137,136,135,134(0-8),159,158,152,151,150
	 * 3G号段(TD-SCDMA网络)有157,188,187
	 * 147是移动TD上网卡专用号段.
	 * 联通:
	 * 2G号段(GSM网络)有130,131,132,155,156
	 * 3G号段(WCDMA网络)有186,185
	 * 电信:
	 * 2G号段(CDMA网络)有133,153
	 * 3G号段(CDMA网络)有189,180
	 */
	public static boolean isMobile(String mobile) {
		if(Strings.isEmpty(mobile)) {
			return false;
		}
		try {
			Pattern p = Pattern.compile("^((13[0-9])|(15[^4,\\D])|(18[0,5-9]))\\d{8}$");
			Matcher m = p.matcher(mobile.trim());
			return m.matches();
		} catch (Exception e) {
			logger.error(String.format("check isMobile error. mobile: %s.", mobile), e);
		}
		return false;
	}
	
	/**
	 * 验证是否邮箱
	 * @param str
	 * @return
	 */
	public static boolean isEmail(String email) {
		if(Strings.isEmpty(email)) {
			return false;
		}
		try {
			Pattern p = Pattern.compile("^([a-zA-Z0-9]*[-_]?[a-zA-Z0-9]+)*@([a-zA-Z0-9]*[-_]?[a-zA-Z0-9]+)+[\\.][A-Za-z]{2,3}([\\.][A-Za-z]{2})?$");
			Matcher m = p.matcher(email.trim());
	        return m.matches();
		} catch (Exception e) {
			logger.error(String.format("check isEmail error. email: %s.", email), e);
		}
		return false;
	}

}
