package org.scauhci.official.bean;

import org.nutz.dao.entity.annotation.*;

@Table("member_message")
public class MemberMessage {

	@Id
	@Column("id")
	private Integer id;
	@Column("member_id")
	private Integer memberId;
	@Column("message_id")
	private Integer messageId;
	@Column("state")
	private Integer state;
	@Column("read_time")
	private java.util.Date readTime;
	@Column("reply")
	private String reply;
	@Column("type")
	private Integer type;

	@One(target = Member.class, field = "memberId")
	private Member member;

	@One(target = Message.class, field = "messageId")
	private Message message;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getMemberId() {
		return memberId;
	}

	public void setMemberId(Integer memberId) {
		this.memberId = memberId;
	}

	public Integer getMessageId() {
		return messageId;
	}

	public void setMessageId(Integer messageId) {
		this.messageId = messageId;
	}

	public Integer getState() {
		return state;
	}

	public void setState(Integer state) {
		this.state = state;
	}

	public java.util.Date getReadTime() {
		return readTime;
	}

	public void setReadTime(java.util.Date readTime) {
		this.readTime = readTime;
	}

	public String getReply() {
		return reply;
	}

	public void setReply(String reply) {
		this.reply = reply;
	}

	public Integer getType() {
		return type;
	}

	public void setType(Integer type) {
		this.type = type;
	}

	public Member getMember() {
		return member;
	}

	public void setMember(Member member) {
		this.member = member;
	}

	public Message getMessage() {
		return message;
	}

	public void setMessage(Message message) {
		this.message = message;
	}

}