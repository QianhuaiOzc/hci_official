package org.scauhci.official.bean;

import org.nutz.dao.entity.annotation.*;



/**
* 
*/

@Table("report_file")
public class ReportFile {

	/**
	 * 
	 */
	@Id
	@Column("id")
	private Integer id;
	/**
	 * 
	 */
	@Column("report_id")
	private Integer reportId;
	/**
	 * 
	 */
	@Column("file_id")
	private Integer fileId;
	
	@One(target = Report.class, field = "reportId")
    private Report report;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getReportId() {
		return reportId;
	}

	public void setReportId(Integer reportId) {
		this.reportId = reportId;
	}

	public Integer getFileId() {
		return fileId;
	}

	public void setFileId(Integer fileId) {
		this.fileId = fileId;
	}

	public Report getReport() {
		return report;
	}

	public void setReport(Report report) {
		this.report = report;
	}
	
	
}