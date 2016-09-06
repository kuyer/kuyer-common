package io.github.kuyer.common.model;

import java.util.List;

import io.github.kuyer.common.Constants;

/**
 * 结果类
 * @author rory.zhang
 */
public class Results<T> extends Bases {

	private static final long serialVersionUID = -9213993970295101796L;
	
	/** 失败码 **/
	public static final String RESULT_FAIL = "0";
	/** 成功码 **/
	public static final String RESULT_SUCCESS = "1";
	/** 未登录码 **/
	public static final String RESULT_NOLOG = "3";
	/** 未授权码 **/
	public static final String RESULT_UNAUTH = "4";
	/** 不存在码 **/
	public static final String RESULT_NOEXIST = "5";
	
	/** 单记录 **/
	private T data;
	/** 多个记录 **/
	private List<T> datas;
	/** 页数 **/
	private Integer psize;
	/** 记录数 **/
	private Integer total;
	
	public Results() {}
	
	public Results(String code, String desc) {
		super(code, desc);
	}
	
	public Results(T data) {
		this.data = data;
	}
	
	public Results(List<T> datas) {
		this.datas = datas;
	}
	
	public Results(List<T> datas, Integer limit, Integer total) {
		this.datas = datas;
		if(total<=-1) {
			total = 0;
		}
		this.total = total;
		if(limit<=0) {
			limit = Constants.PAGE_LIMIT;
		}
		if(total%limit>=1) {
			this.psize = total/limit + 1;
		} else {
			this.psize = total/limit;
		}
	}
	
	public T getData() {
		return data;
	}
	public void setData(T data) {
		this.data = data;
	}
	public List<T> getDatas() {
		return datas;
	}
	public void setDatas(List<T> datas) {
		this.datas = datas;
	}
	public Integer getPsize() {
		return psize;
	}
	public void setPsize(Integer psize) {
		this.psize = psize;
	}
	public Integer getTotal() {
		return total;
	}
	public void setTotal(Integer total) {
		this.total = total;
	}
	
	@Override
	public String toString() {
		return "{\"data\":\"" + data + "\",\"datas\":\"" + datas + "\",\"psize\":\"" + psize + "\",\"total\":\"" + total
				+ "\"}";
	}

}
