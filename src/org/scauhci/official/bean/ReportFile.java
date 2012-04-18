package org.scauhci.official.bean;

import org.nutz.dao.entity.annotation.*;

@Table("report_file")
public class ReportFile {

	@Id
	@Column("id")
	private int id;
	@Column("report_id")
	private int reportId;
	@Column("file_id")
	private int fileId;

	@One(target = Report.class, field = "reportId")
	private Report report;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getReportId() {
		return reportId;
	}

	public void setReportId(int reportId) {
		this.reportId = reportId;
	}

	public int getFileId() {
		return fileId;
	}

	public void setFileId(int fileId) {
		this.fileId = fileId;
	}

	public Report getReport() {
		return report;
	}

	public void setReport(Report report) {
		this.report = report;
	}

	@Override
	public String toString() {
		return "ReportFile [id=" + id + ", reportId=" + reportId + ", fileId="
				+ fileId + ", report=" + report + "]";
	}

}