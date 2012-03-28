package org.scauhci.official.bean;

import org.nutz.dao.entity.annotation.*;

@Table("attendance")
public class Attendance {

	@Id
	@Column("id")
	private Integer id;
	@Column("meeting_id")
	private Integer meetingId;
	@Column("member_id")
	private Integer memberId;
	@Column("state")
	private Integer state;
	@Column("reason")
	private String reason;
	@Column("is_attend")
	private Integer isAttend;

	@One(target = Member.class, field = "memberId")
	private Member member;

	@One(target = Meeting.class, field = "meetingId")
	private Meeting meeting;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getMeetingId() {
		return meetingId;
	}

	public void setMeetingId(Integer meetingId) {
		this.meetingId = meetingId;
	}

	public Integer getMemberId() {
		return memberId;
	}

	public void setMemberId(Integer memberId) {
		this.memberId = memberId;
	}

	public Integer getState() {
		return state;
	}

	public void setState(Integer state) {
		this.state = state;
	}

	public String getReason() {
		return reason;
	}

	public void setReason(String reason) {
		this.reason = reason;
	}

	public Integer getIsAttend() {
		return isAttend;
	}

	public void setIsAttend(Integer isAttend) {
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