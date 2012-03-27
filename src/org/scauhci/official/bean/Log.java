/**
 * 
 */
package org.scauhci.official.bean;

import org.nutz.mongo.annotation.Co;
import org.nutz.mongo.annotation.CoField;
import org.nutz.mongo.annotation.CoId;

/**
 * @author clarenceau
 * 
 */
@Co
public class Log {
	@CoId
	private String id;
	@CoField
	private String memberId;
	@CoField
	private String agent;
	@CoField
	private java.util.Date time;
	@CoField
	private String content;
	@CoField
	private Long responseTime;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getMemberId() {
		return memberId;
	}

	public void setMemberId(String memberId) {
		this.memberId = memberId;
	}

	public String getAgent() {
		return agent;
	}

	public void setAgent(String agent) {
		this.agent = agent;
	}

	public java.util.Date getTime() {
		return time;
	}

	public void setTime(java.util.Date time) {
		this.time = time;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public Long getResponseTime() {
		return responseTime;
	}

	public void setResponseTime(Long responseTime) {
		this.responseTime = responseTime;
	}

	@Override
	public String toString() {
		return "Log [id=" + id + ", memberId=" + memberId + ", agent=" + agent
				+ ", time=" + time + ", content=" + content + ", responseTime="
				+ responseTime + "]";
	}
}
