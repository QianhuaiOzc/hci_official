package org.scauhci.official.bean;

import org.nutz.dao.entity.annotation.*;

@Table("report_member")
public class ReportMember {

	@Id
	@Column("id")
	private int id;
	@Column("member_id")
	private int memberId;
	@Column("report_id")
	private int reportId;

	@One(target = Member.class, field = "memberId")
	private Member member;

	@One(target = Report.class, field = "reportId")
	private Report report;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getMemberId() {
		return memberId;
	}

	public void setMemberId(int memberId) {
		this.memberId = memberId;
	}

	public int getReportId() {
		return reportId;
	}

	public void setReportId(int reportId) {
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

	@Override
	public String toString() {
		return "ReportMember [id=" + id + ", memberId=" + memberId
				+ ", reportId=" + reportId + ", member=" + member + ", report="
				+ report + "]";
	}

}