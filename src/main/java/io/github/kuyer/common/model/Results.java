package io.github.kuyer.common.model;

import java.io.Serializable;
import java.util.List;

import io.github.kuyer.common.Constants;

/**
 * 结果类
 * @author rory.zhang
 */
public class Results<T> extends Bases implements Serializable {

	private static final long serialVersionUID = -4168943982406858903L;
	
	/** 单记录 **/
	private T data;
	/** 多个记录 **/
	private List<T> datas;
	/** 页数 **/
	private Integer psize;
	/** 记录数 **/
	private Integer total;
	
	public Results() {}
	
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
