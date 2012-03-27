package org.scauhci.official.bean;

import org.nutz.dao.entity.annotation.*;


/**
* 
*/

@Table("report_member")
public class ReportMember {

	/**
	 * 
	 */
	@Id
	@Column("id")
	private Integer id;
	/**
	 * 
	 */
	@Column("member_id")
	private Integer memberId;
	/**
	 * 
	 */
	@Column("report_id")
	private Integer reportId;
	
	@One(target = Member.class, field = "memberId")
    private Member member;
	
	@One(target = Report.class, field = "reportId")
    private Report report;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getMemberId() {
		return memberId;
	}

	public void setMemberId(Integer memberId) {
		this.memberId = memberId;
	}

	public Integer getReportId() {
		return reportId;
	}

	public void setReportId(Integer reportId) {
		this.reportId = reportId;
	}

	public Member getMember() {
		return member;
	}

	public void setMember(Member member) {
		this.member = member;
	}

	public Report getReport() {
		return report;
	}

	public void setReport(Report report) {
		this.report = report;
	}
	
	
	
}