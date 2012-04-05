package org.scauhci.official.bean;

import java.sql.Date;

import org.nutz.dao.entity.annotation.*;

@Table("member_extend")
public class MemberExtend {

	@Id
	@Column("id")
	private Integer id;
	@Column("sex")
	private Integer sex;
	@Column("familyaddress")
	private String familyaddress;
	@Column("nativeplace")
	private String nativeplace;
	@Column("folk")
	private String folk;
	@Column("card_id")
	private String cardId;
	@Column("homepage")
	private String homepage;
	@Column("birthday")
	private Date birthday;
	@Column("email")
	private String email;
	@Column("mobile")
	private String mobile;
	@Column("mobileshort")
	private String mobileshort;
	@Column("grade")
	private Integer grade;
	@Column("academy")
	private String academy;
	@Column("major")
	private String major;



	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getSex() {
		return sex;
	}

	public void setSex(Integer sex) {
		this.sex = sex;
	}

	public String getFamilyaddress() {
		return familyaddress;
	}

	public void setFamilyaddress(String familyaddress) {
		this.familyaddress = familyaddress;
	}

	public String getNativeplace() {
		return nativeplace;
	}

	public void setNativeplace(String nativeplace) {
		this.nativeplace = nativeplace;
	}

	public String getFolk() {
		return folk;
	}

	public void setFolk(String folk) {
		this.folk = folk;
	}

	public String getCardId() {
		return cardId;
	}

	public void setCardId(String cardId) {
		this.cardId = cardId;
	}

	public String getHomepage() {
		return homepage;
	}

	public void setHomepage(String homepage) {
		this.homepage = homepage;
	}

	public java.util.Date getBirthday() {
		return birthday;
	}

	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public String getMobileshort() {
		return mobileshort;
	}

	public void setMobileshort(String mobileshort) {
		this.mobileshort = mobileshort;
	}

	public Integer getGrade() {
		return grade;
	}

	public void setGrade(Integer grade) {
		this.grade = grade;
	}

	public String getAcademy() {
		return academy;
	}

	public void setAcademy(String academy) {
		this.academy = academy;
	}

	public String getMajor() {
		return major;
	}

	public void setMajor(String major) {
		this.major = major;
	}


}