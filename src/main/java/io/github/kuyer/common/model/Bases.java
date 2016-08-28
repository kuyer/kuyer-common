package io.github.kuyer.common.model;

import java.io.Serializable;
import java.util.LinkedHashMap;
import java.util.Map;

import io.github.kuyer.common.Jsons;

/**
 * 基础类
 * @author rory.zhang
 */
public class Bases implements Serializable {

	private static final long serialVersionUID = -8395838491173367640L;
	/** 响应码 **/
	private String code;
	/** 响应描述 **/
	private String desc;
	/** 起始页 **/
	private Integer page;
	/** 起始数 **/
	private Integer start;
	/** 每页数 **/
	private Integer limit;
	/** 排序信息 **/
	private Map<String, String> orders;
	
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
	public Integer getPage() {
		return page;
	}
	public void setPage(Integer page) {
		this.page = page;
	}
	public Integer getStart() {
		return start;
	}
	public void setStart(Integer start) {
		this.start = start;
	}
	public Integer getLimit() {
		return limit;
	}
	public void setLimit(Integer limit) {
		this.limit = limit;
	}
	public Map<String, String> getOrders() {
		return orders;
	}
	public void setOrders(Map<String, String> orders) {
		this.orders = orders;
	}
	
	/** 添加排序 **/
	public void addOrder(String column, String direction) {
		if(null == orders) {
			orders = new LinkedHashMap<String, String>();
		}
		orders.put(column, direction);
	}
	
	@Override
	public String toString() {
		return "{\"code\":\"" + code + "\",\"desc\":\"" + desc + "\",\"page\":\"" + page + "\",\"start\":\"" + start
				+ "\",\"limit\":\"" + limit + "\",\"orders\":\"" + orders + "\"}";
	}
	
	public String toJson() {
		return Jsons.toJson(this);
	}

}
