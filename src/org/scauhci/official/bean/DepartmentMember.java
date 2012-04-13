package org.scauhci.official.bean;

import org.nutz.dao.entity.annotation.*;

@Table("department_member")
public class DepartmentMember {
	
	public static int TYPE_MEMBER=1;
	
	public static int TYPE_CHIEF=2;

	@Id
	@Column("id")
	private int id;
	@Column("department_id")
	private int departmentId;
	@Column("member_id")
	private int memberId;
	@Column("type")
	private int type;

	@One(target = Member.class, field = "memberId")
	private Member member;

	@One(target = Department.class, field = "departmentId")
	private Department deparment;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getDepartmentId() {
		return departmentId;
	}

	public void setDepartmentId(int departmentId) {
		this.departmentId = departmentId;
	}

	public int getMemberId() {
		return memberId;
	}

	public void setMemberId(int memberId) {
		this.memberId = memberId;
	}

	public int getType() {
		return type;
	}

	public void setType(int type) {
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