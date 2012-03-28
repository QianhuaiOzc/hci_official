package org.scauhci.official.bean;

import java.util.List;

import org.nutz.dao.entity.annotation.*;

@Table("message")
public class Message {

	@Id
	@Column("id")
	private Integer id;
	@Column("type")
	private Integer type;
	@Column("content")
	private String content;
	@Column("date")
	private java.util.Date date;
	@Column("member_id")
	private Integer memberId;

	@One(target = Member.class, field = "memberId")
	private Member member;

	@ManyMany(target = Member.class, relation = "member_message", from = "messageId", to = "memberId")
	private List<Member> members;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getType() {
		return type;
	}

	public void setType(Integer type) {
		this.type = type;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public java.util.Date getDate() {
		return date;
	}

	public void setDate(java.util.Date date) {
		this.date = date;
	}

	public Integer getMemberId() {
		return memberId;
	}

	public void setMemberId(Integer memberId) {
		this.memberId = memberId;
	}

	public Member getMember() {
		return member;
	}

	public void setMember(Member member) {
		this.member = member;
	}

	public List<Member> getMembers() {
		return members;
	}

	public void setMembers(List<Member> members) {
		this.members = members;
	}

}