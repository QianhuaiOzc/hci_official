package org.scauhci.official.bean;

import java.util.List;

import org.nutz.dao.entity.annotation.*;

@Table("department")
public class Department implements java.io.Serializable{

	//存在的部门
	public static int STATE_ON=1;
	//不存在的部门
	public static int STATE_FAIL=2;
	
	@Id
	@Column("id")
	private int id;
	@Column("name")
	private String name;
	@Column("detail")
	private String detail;
	@Column("state")
	private int state;

	@ManyMany(target = Member.class, relation = "department_member", from = "departmentId", to = "memberId")
	private transient List<Member> members;

	@Many(target = Project.class, field = "departmentId")
	private transient List<Project> projects;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDetail() {
		return detail;
	}

	public void setDetail(String detail) {
		this.detail = detail;
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

	public int getState() {
		return state;
	}

	public void setState(int state) {
		this.state = state;
	}

}