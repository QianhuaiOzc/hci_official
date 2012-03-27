package org.scauhci.official.bean;

import org.nutz.dao.entity.annotation.*;



/**
* 
*/

@Table("project_member")
public class ProjectMember {

	/**
	 * 
	 */
	@Id
	@Column("id")
	private Integer id;
	/**
	 * 
	 */
	@Column("project_id")
	private Integer projectId;
	/**
	 * 
	 */
	@Column("member_id")
	private Integer memberId;
	/**
	 * ְ
	 */
	@Column("job")
	private String job;
	/**
	 * 
	 */
	@Column("type")
	private Integer type;
	
	@One(target = Project.class, field = "projectId")
    private Project project;
	
	@One(target = Member.class, field = "projectId")
    private Member member;

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

	public Integer getMemberId() {
		return memberId;
	}

	public void setMemberId(Integer memberId) {
		this.memberId = memberId;
	}

	public String getJob() {
		return job;
	}

	public void setJob(String job) {
		this.job = job;
	}

	public Integer getType() {
		return type;
	}

	public void setType(Integer type) {
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