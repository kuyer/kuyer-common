package io.github.kuyer.common.exception;

import java.io.Serializable;

/**
 * 基础异常类
 * @author rory.zhang
 */
public class Exceptions extends Exception implements Serializable {

	private static final long serialVersionUID = -506508746320477631L;
	
	/** 异常Code **/
	private String code;
	/** 异常描述 **/
	private String desc;
	
	public Exceptions() {}
	
	public Exceptions(String code, String desc) {
		super();
		this.code = code;
		this.desc = desc;
	}
	
	public Exceptions(String code, String desc, Throwable cause) {
		super(cause);
		this.code = code;
		this.desc = desc;
	}
	
	public Exceptions(String code, String desc, String message, Throwable cause) {
		super(message, cause);
		this.code = code;
		this.desc = desc;
	}
	
	public Exceptions(String message) {
		super(message);
	}
	
	public Exceptions(String message, Throwable cause) {
		super(message, cause);
	}

	public Exceptions(Throwable cause) {
		super(cause);
	}

	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public String getDesc() {
		return desc;
	}
	public void setDesc(String desc) {
		this.desc = desc;
	}

	@Override
	public String toString() {
		return "{\"code\":\"" + code + "\",\"desc\":\"" + desc + "\"}";
	}

}
