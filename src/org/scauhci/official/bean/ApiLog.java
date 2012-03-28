package org.scauhci.official.bean;

import org.nutz.mongo.annotation.Co;
import org.nutz.mongo.annotation.CoField;
import org.nutz.mongo.annotation.CoId;


@Co
public class ApiLog {
	@CoId
	private int id;
	@CoField
	private int apiId;
	@CoField
	private java.util.Date time;
	@CoField
	private int responseTime;
	@CoField
	private int content;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getApiId() {
		return apiId;
	}

	public void setApiId(int apiId) {
		this.apiId = apiId;
	}

	public java.util.Date getTime() {
		return time;
	}

	public void setTime(java.util.Date time) {
		this.time = time;
	}

	public int getResponseTime() {
		return responseTime;
	}

	public void setResponseTime(int responseTime) {
		this.responseTime = responseTime;
	}

	public int getContent() {
		return content;
	}

	public void setContent(int content) {
		this.content = content;
	}
}