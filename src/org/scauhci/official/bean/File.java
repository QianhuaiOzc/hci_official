package org.scauhci.official.bean;

import org.nutz.dao.entity.annotation.*;

@Table("file")
public class File {
	@Id
	@Column("id")
	private int id;
	@Column("path")
	private String path;
	@Column("name")
	private String name;
	@Column("suffix")
	private String suffix;
	@Column("time")
	private java.util.Date time;
	@Column("is_public")
	private int isPublic;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getPath() {
		return path;
	}

	public void setPath(String path) {
		this.path = path;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSuffix() {
		return suffix;
	}

	public void setSuffix(String suffix) {
		this.suffix = suffix;
	}

	public java.util.Date getTime() {
		return time;
	}

	public void setTime(java.util.Date time) {
		this.time = time;
	}

	public int getIsPublic() {
		return isPublic;
	}

	public void setIsPublic(int isPublic) {
		this.isPublic = isPublic;
	}

}