package org.scauhci.official.bean;

import java.util.List;

import org.nutz.dao.entity.annotation.*;



/**
* 
*/

@Table("project")
public class Project {

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
	/**
	 * 
	 */
	@Column("state_date")
	private java.util.Date stateDate;
	/**
	 * 
	 */
	@Column("end_date")
	private java.util.Date endDate;
	/**
	 * 
	 */
	@Column("state")
	private Integer state;
	/**
	 * 
	 */
	@Column("is_public")
	private Integer isPublic;
	/**
	 * 
	 */
	@Column("department_id")
	private Integer departmentId;
	
	
	@Many(target = Report.class, field = "projectId")
    private List<Report> reports;
	
	@Many(target = ProjectMember.class, field = "projectId")
    private List<ProjectMember> projectMembers;
	
	@ManyMany(target = Member.class, relation = "project_member", from = "projectId", to = "memberId")
    private List<Member> members;
	
	@One(target = Department.class, field = "departmentId")
    private Department department;

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

	public java.util.Date getStateDate() {
		return stateDate;
	}

	public void setStateDate(java.util.Date stateDate) {
		this.stateDate = stateDate;
	}

	public java.util.Date getEndDate() {
		return endDate;
	}

	public void setEndDate(java.util.Date endDate) {
		this.endDate = endDate;
	}

	public Integer getState() {
		return state;
	}

	public void setState(Integer state) {
		this.state = state;
	}

	public Integer getIsPublic() {
		return isPublic;
	}

	public void setIsPublic(Integer isPublic) {
		this.isPublic = isPublic;
	}

	public Integer getDepartmentId() {
		return departmentId;
	}

	public void setDepartmentId(Integer departmentId) {
		this.departmentId = departmentId;
	}

	public List<Report> getReports() {
		return reports;
	}

	public void setReports(List<Report> reports) {
		this.reports = reports;
	}

	public List<ProjectMember> getProjectMembers() {
		return projectMembers;
	}

	public void setProjectMembers(List<ProjectMember> projectMembers) {
		this.projectMembers = projectMembers;
	}

	public List<Member> getMembers() {
		return members;
	}

	public void setMembers(List<Member> members) {
		this.members = members;
	}

	public Department getDepartment() {
		return department;
	}

	public void setDepartment(Department department) {
		this.department = department;
	}
	
	
}