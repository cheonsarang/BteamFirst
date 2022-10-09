package chotamember;

import java.sql.Date;

public class MemberVO {
	private String userid, name, userpw, phone, parent_phone, gender, profile, nickname, social, member_grp, grade_class_code, school_id, teacher, school_name, office_name, office_code; 
	private Date birth;
	
	public MemberVO() {}
	
	
	public MemberVO(String userid, String name, String userpw, String phone, String gender, String social,
			String member_grp, String grade_class_code, String school_id, String school_name, String office_name,
			String office_code, Date birth) {
		super();
		this.userid = userid;
		this.name = name;
		this.userpw = userpw;
		this.phone = phone;
		this.gender = gender;
		this.social = social;
		this.member_grp = member_grp;
		this.grade_class_code = grade_class_code;
		this.school_id = school_id;
		this.school_name = school_name;
		this.office_name = office_name;
		this.office_code = office_code;
		this.birth = birth;
	}

	public String getUserid() {
		return userid;
	}
	public void setUserid(String userid) {
		this.userid = userid;
	}
	public String getName() {
		return name;
	}
	public String getTeacher() {
		return teacher;
	}
	public void setTeacher(String teacher) {
		this.teacher = teacher;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getUserpw() {
		return userpw;
	}
	public void setUserpw(String userpw) {
		this.userpw = userpw;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getParent_phone() {
		return parent_phone;
	}
	public void setParent_phone(String parent_phone) {
		this.parent_phone = parent_phone;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getProfile() {
		return profile;
	}
	public void setProfile(String profile) {
		this.profile = profile;
	}
	public String getNickname() {
		return nickname;
	}
	public void setNickname(String nickname) {
		this.nickname = nickname;
	}
	public String getSocial() {
		return social;
	}
	public void setSocial(String social) {
		this.social = social;
	}
	public String getMember_grp() {
		return member_grp;
	}
	public void setMember_grp(String member_grp) {
		this.member_grp = member_grp;
	}
	public String getGrade_class_code() {
		return grade_class_code;
	}
	public void setGrade_class_code(String grade_class_code) {
		this.grade_class_code = grade_class_code;
	}
	public String getSchool_id() {
		return school_id;
	}
	public void setSchool_id(String school_id) {
		this.school_id = school_id;
	}
	
	public String getSchool_name() {
		return school_name;
	}
	public void setSchool_name(String school_name) {
		this.school_name = school_name;
	}
	public String getOffice_name() {
		return office_name;
	}
	public void setOffice_name(String office_name) {
		this.office_name = office_name;
	}
	public String getOffice_code() {
		return office_code;
	}
	public void setOffice_code(String office_code) {
		this.office_code = office_code;
	}
	public Date getBirth() {
		return birth;
	}
	public void setBirth(Date birth) {
		this.birth = birth;
	}
	
	

	
	
	
	
}
