package org.scauhci.official.bean;

import org.nutz.dao.entity.annotation.*;

@Table("attendance")
public class Attendance {

	@Id
	@Column("id")
	private int id;
	@Column("meeting_id")
	private int meetingId;
	@Column("member_id")
	private int memberId;
	@Column("state")
	private int state;
	@Column("reason")
	private String reason;
	@Column("is_attend")
	private int isAttend;

	@One(target = Member.class, field = "memberId")
	private Member member;

	@One(target = Meeting.class, field = "meetingId")
	private Meeting meeting;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getMeetingId() {
		return meetingId;
	}

	public void setMeetingId(int meetingId) {
		this.meetingId = meetingId;
	}

	public int getMemberId() {
		return memberId;
	}

	public void setMemberId(int memberId) {
		this.memberId = memberId;
	}

	public int getState() {
		return state;
	}

	public void setState(int state) {
		this.state = state;
	}

	public String getReason() {
		return reason;
	}

	public void setReason(String reason) {
		this.reason = reason;
	}

	public int getIsAttend() {
		return isAttend;
	}

	public void setIsAttend(int isAttend) {
		this.isAttend = isAttend;
	}

	public Member getMember() {
		return member;
	}

	public void setMember(Member member) {
		this.member = member;
	}

	public Meeting getMeeting() {
		return meeting;
	}

	public void setMeeting(Meeting meeting) {
		this.meeting = meeting;
	}

}