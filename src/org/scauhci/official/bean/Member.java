package org.scauhci.official.bean;

import java.util.List;

import org.nutz.dao.entity.annotation.*;

@Table("member")
public class Member implements java.io.Serializable{

	// 在职
	public static final int STATE_ON_THE_JOB = 1;
	// 毕业
	public static final int STATE_GRADUATE = 2;
	//实习
	public static final int STATE_PROBATIONER=3;
	// 退出
	public static final int STATE_LEAVE = 4;
	

	//老师
	public static final int TYPE_TEACHER = 1;
	//研究生
	public static final int TYPE_GRADUATE_STUDENT=2;
	//学生
	public static final int TYPE_STUDENT = 3;
	
	
	//管理员
	public static final int ROLE_ADMIN=1;
	//普通
	public static final int ROLE_COMMON=0;	
	

	
	@Id
	@Column("id")
	private int id;
	@Column("student_id")
	private String studentId;
	@Column("name")
	private String name;
	@Column("state")
	private int state;
	@Column("role")
	private int role;
	@Column("type")
	private int type;
	@Column("is_public")
	private boolean isPublic;
	@Column("extend_id")
	private int extendId;
	

	@ManyMany(target = Project.class, relation = "project_member", from = "member_id", to = "project_id")
	private transient List<Project> projects;
	@One(target = MemberExtend.class, field = "extendId")
	private MemberExtend extend;

	public int getId() {
		return id;
	}

	public void setId(int id) {
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


	public int getState() {
		return state;
	}

	public void setState(int state) {
		this.state = state;
	}

	public int getRole() {
		return role;
	}

	public void setRole(int role) {
		this.role = role;
	}

	public int getType() {
		return type;
	}

	public void setType(int type) {
		this.type = type;
	}

	public boolean getIsPublic() {
		return isPublic;
	}

	public void setIsPublic(boolean isPublic) {
		this.isPublic = isPublic;
	}

	public List<Project> getProjects() {
		return projects;
	}

	public void setProjects(List<Project> projects) {
		this.projects = projects;
	}

	public int getExtendId() {
		return extendId;
	}

	public void setExtendId(int extendId) {
		this.extendId = extendId;
	}

	public MemberExtend getExtend() {
		return extend;
	}

	public void setExtend(MemberExtend extend) {
		this.extend = extend;
	}

}