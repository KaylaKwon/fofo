package org.fofo.member.vo;

public class School {

	private Integer MySchoolId;
	private Integer userId;
	private Integer schoolId;
	private String degree;
	private String major;
	private Integer entrance;
	private Integer graduation;
	private boolean graduateCheck;
	public Integer getMySchoolId() {
		return MySchoolId;
	}
	public void setMySchoolId(Integer mySchoolId) {
		MySchoolId = mySchoolId;
	}
	public Integer getUserId() {
		return userId;
	}
	public void setUserId(Integer userId) {
		this.userId = userId;
	}
	public Integer getSchoolId() {
		return schoolId;
	}
	public void setSchoolId(Integer schoolId) {
		this.schoolId = schoolId;
	}
	public String getDegree() {
		return degree;
	}
	public void setDegree(String degree) {
		this.degree = degree;
	}
	public String getMajor() {
		return major;
	}
	public void setMajor(String major) {
		this.major = major;
	}
	public Integer getEntrance() {
		return entrance;
	}
	public void setEntrance(Integer entrance) {
		this.entrance = entrance;
	}
	public Integer getGraduation() {
		return graduation;
	}
	public void setGraduation(Integer graduation) {
		this.graduation = graduation;
	}
	public boolean isGraduateCheck() {
		return graduateCheck;
	}
	public void setGraduateCheck(boolean graduateCheck) {
		this.graduateCheck = graduateCheck;
	}
	
	
}
