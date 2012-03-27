package org.scauhci.official.bean;

import java.util.List;

import org.nutz.dao.entity.annotation.*;




/**
* 
*/

@Table("department")
public class Department {

	/**
	 * 
	 */
	@Id
	@Column("id")
	private Integer id;
	/**
	 * 
	 */
	@Column("name")
	private String name;
	/**
	 * 
	 */
	@Column("detail")
	private String detail;
	
	
	
	@ManyMany(target = Member.class, relation = "department_member", from = "departmentId", to = "memberId")
    private List<Member> members;
	
	@Many(target = Project.class, field = "departmentId")
    private List<Project> projects;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
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
	
	
}