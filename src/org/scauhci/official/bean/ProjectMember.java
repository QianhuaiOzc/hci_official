package org.scauhci.official.bean;

import org.nutz.dao.entity.annotation.*;

@Table("project_member")
public class ProjectMember {
	
	//项目成员
	public static int TYPE_MEMBER=1;
	//项目组长
	public static int TYPE_LEADER=2;
	
	
	@Id
	@Column("id")
	private int id;
	@Column("project_id")
	private int projectId;
	@Column("member_id")
	private int memberId;
	@Column("job")
	private String job;
	@Column("type")
	private int type=ProjectMember.TYPE_MEMBER;

	@One(target = Project.class, field = "projectId")
	private Project project;

	@One(target = Member.class, field = "memberId")
	private Member member;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getProjectId() {
		return projectId;
	}

	public void setProjectId(int projectId) {
		this.projectId = projectId;
	}

	public int getMemberId() {
		return memberId;
	}

	public void setMemberId(int memberId) {
		this.memberId = memberId;
	}

	public String getJob() {
		return job;
	}

	public void setJob(String job) {
		this.job = job;
	}

	public int getType() {
		return type;
	}

	public void setType(int type) {
		this.type = type;
	}

	public Project getProject() {
		return project;
	}

	public void setProject(Project project) {
		this.project = project;
	}

	public Member getMember() {
		return member;
	}

	public void setMember(Member member) {
		this.member = member;
	}

}