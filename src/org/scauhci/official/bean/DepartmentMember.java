package org.scauhci.official.bean;

import org.nutz.dao.entity.annotation.*;


/**
* 
*/

@Table("department_member")
public class DepartmentMember {

	/**
	 * 
	 */
	@Id
	@Column("id")
	private Integer id;
	/**
	 * 
	 */
	@Column("department_id")
	private Integer departmentId;
	/**
	 * 
	 */
	@Column("member_id")
	private Integer memberId;
	/**
	 * 
	 */
	@Column("type")
	private Integer type;
	
	@One(target = Member.class, field = "memberId")
    private Member member;
	
	@One(target = Department.class, field = "meetingId")
    private Department deparment;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getDepartmentId() {
		return departmentId;
	}

	public void setDepartmentId(Integer departmentId) {
		this.departmentId = departmentId;
	}

	public Integer getMemberId() {
		return memberId;
	}

	public void setMemberId(Integer memberId) {
		this.memberId = memberId;
	}

	public Integer getType() {
		return type;
	}

	public void setType(Integer type) {
		this.type = type;
	}

	public Member getMember() {
		return member;
	}

	public void setMember(Member member) {
		this.member = member;
	}

	public Department getDeparment() {
		return deparment;
	}

	public void setDeparment(Department deparment) {
		this.deparment = deparment;
	}
	
	
	
	
}