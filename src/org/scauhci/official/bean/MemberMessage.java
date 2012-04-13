package org.scauhci.official.bean;

import org.nutz.dao.entity.annotation.*;

@Table("member_message")
public class MemberMessage {

	@Id
	@Column("id")
	private int id;
	@Column("member_id")
	private int memberId;
	@Column("message_id")
	private int messageId;
	@Column("state")
	private int state;
	@Column("read_time")
	private java.util.Date readTime;
	@Column("reply")
	private String reply;
	@Column("type")
	private int type;

	@One(target = Member.class, field = "memberId")
	private Member member;

	@One(target = Message.class, field = "messageId")
	private Message message;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getMemberId() {
		return memberId;
	}

	public void setMemberId(int memberId) {
		this.memberId = memberId;
	}

	public int getMessageId() {
		return messageId;
	}

	public void setMessageId(int messageId) {
		this.messageId = messageId;
	}

	public int getState() {
		return state;
	}

	public void setState(int state) {
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

	public int getType() {
		return type;
	}

	public void setType(int type) {
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