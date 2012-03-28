package org.scauhci.official.bean;

import java.util.List;

import org.nutz.dao.entity.annotation.*;

@Table("member")
public class Member {

	// 在职
	public static final int STATE_ON_THE_JOB = 1;
	// 毕业
	public static final int STATE_GRADUATE = 0;
	// 退出
	public static final int STATE_LEAVE = -1;

	public static final int TYPE_TEACHER = 1;

	public static final int TYPE_STUDENT = 2;

	@Id
	@Column("id")
	private Integer id;
	@Column("student_id")
	private String studentId;
	@Column("name")
	private String name;
	@Column("password")
	private String password;
	@Column("state")
	private Integer state;
	@Column("role")
	private Integer role;
	@Column("type")
	private Integer type;
	@Column("is_public")
	private Integer isPublic;

	@ManyMany(target = Project.class, relation = "project_member", from = "memberId", to = "projectId")
	private List<Project> projects;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getStudentId() {
		return studentId;
	}

	public void setStudentId(String studentId) {
		this.studentId = studentId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Integer getState() {
		return state;
	}

	public void setState(Integer state) {
		this.state = state;
	}

	public Integer getRole() {
		return role;
	}

	public void setRole(Integer role) {
		this.role = role;
	}

	public Integer getType() {
		return type;
	}

	public void setType(Integer type) {
		this.type = type;
	}

	public Integer getIsPublic() {
		return isPublic;
	}

	public void setIsPublic(Integer isPublic) {
		this.isPublic = isPublic;
	}

	public List<Project> getProjects() {
		return projects;
	}

	public void setProjects(List<Project> projects) {
		this.projects = projects;
	}

}