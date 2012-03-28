package org.scauhci.official.bean;

import java.util.List;

import org.nutz.dao.entity.annotation.*;

@Table("report")
public class Report {
	@Id
	@Column("id")
	private Integer id;
	@Column("project_id")
	private Integer projectId;
	@Column("meeting_id")
	private Integer meetingId;
	@Column("comment")
	private String comment;
	@Column("is_report")
	private Integer isReport;

	@One(target = Project.class, field = "projectId")
	private Project project;

	@One(target = Meeting.class, field = "meetingId")
	private Meeting meeting;

	@ManyMany(target = File.class, relation = "report_file", from = "reportId", to = "fileId")
	private List<File> files;

	@ManyMany(target = Member.class, relation = "report_member", from = "reportId", to = "memberId")
	private List<Member> members;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getProjectId() {
		return projectId;
	}

	public void setProjectId(Integer projectId) {
		this.projectId = projectId;
	}

	public Integer getMeetingId() {
		return meetingId;
	}

	public void setMeetingId(Integer meetingId) {
		this.meetingId = meetingId;
	}

	public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}

	public Integer getIsReport() {
		return isReport;
	}

	public void setIsReport(Integer isReport) {
		this.isReport = isReport;
	}

	public Project getProject() {
		return project;
	}

	public void setProject(Project project) {
		this.project = project;
	}

	public Meeting getMeeting() {
		return meeting;
	}

	public void setMeeting(Meeting meeting) {
		this.meeting = meeting;
	}

	public List<File> getFiles() {
		return files;
	}

	public void setFiles(List<File> files) {
		this.files = files;
	}

	public List<Member> getMembers() {
		return members;
	}

	public void setMembers(List<Member> members) {
		this.members = members;
	}

}