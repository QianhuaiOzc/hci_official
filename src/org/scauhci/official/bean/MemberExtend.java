package org.scauhci.official.bean;

import java.sql.Date;

import org.nutz.dao.entity.annotation.*;

@Table("member_extend")
public class MemberExtend implements java.io.Serializable{

	@Id
	@Column("id")
	private int id;
	@Column("sex")
	private int sex;
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
	private int grade;
	@Column("academy")
	private String academy;
	@Column("major")
	private String major;



	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getSex() {
		return sex;
	}

	public void setSex(int sex) {
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

	public Date getBirthday() {
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

	public int getGrade() {
		return grade;
	}

	public void setGrade(int grade) {
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