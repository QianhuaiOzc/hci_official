package org.scauhci.official.bean;

import java.util.List;

import org.nutz.dao.entity.annotation.*;

@Table("meeting")
public class Meeting {
	@Id
	@Column("id")
	private int id;
	@Column("title")
	private String title;
	@Column("date")
	private java.util.Date date;
	@Column("state")
	private int state;

	@Many(target = Attendance.class, field = "meetingId")
	private List<Attendance> attendances;

	@Many(target = Report.class, field = "meetingId")
	private List<Report> reports;

	@ManyMany(target = Member.class, relation = "atendance", from = "meetingId", to = "memberId")
	private List<Member> members;

	@ManyMany(target = Project.class, relation = "report", from = "meetingId", to = "projectId")
	private List<Project> projects;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public java.util.Date getDate() {
		return date;
	}

	public void setDate(java.util.Date date) {
		this.date = date;
	}

	public int getState() {
		return state;
	}

	public void setState(int state) {
		this.state = state;
	}

	public List<Attendance> getAttendances() {
		return attendances;
	}

	public void setAttendances(List<Attendance> attendances) {
		this.attendances = attendances;
	}

	public List<Report> getReports() {
		return reports;
	}

	public void setReports(List<Report> reports) {
		this.reports = reports;
	}

	public List<Member> getMembers() {
		return members;
	}

	public void setMembers(List<Member> members) {
		this.members = members;
	}

	public List<Project> getProjects() {
		return projects;
	}

	public void setProjects(List<Project> projects) {
		this.projects = projects;
	}

	@Override
	public String toString() {
		return "Meeting [id=" + id + ", title=" + title + ", date=" + date
				+ ", state=" + state + ", attendances=" + attendances
				+ ", reports=" + reports + ", members=" + members
				+ ", projects=" + projects + "]";
	}

}