package org.fofo.member.vo;

import java.util.Date;

public class Member {
	
	private Integer uId;
	private String uEmail;
	private String uPw;
	
	private String uNickname;
	private String uName;
	private String uBirth;
	
	private Date uJoinDate;
	private String uProfileImg;
	
		
	private Integer uPostNum;
	private Integer uCommentNum;
	private Integer uPoint;
	
	public Integer getUserId() {
		return uId;
	}
	public void setUserId(Integer uId) {
		this.uId = uId;
	}
	public String getuEmail() {
		return uEmail;
	}
	public void setuEmail(String uEmail) {
		this.uEmail = uEmail;
	}
	public String getuPw() {
		return uPw;
	}
	public void setuPw(String uPw) {
		this.uPw = uPw;
	}
	public String getuNickname() {
		return uNickname;
	}
	public void setuNickname(String uNickname) {
		this.uNickname = uNickname;
	}
	public String getuName() {
		return uName;
	}
	public void setuName(String uName) {
		this.uName = uName;
	}
	public String getuBirth() {
		return uBirth;
	}
	public void setuBirth(String uBirth) {
		this.uBirth = uBirth;
	}
	public Date getuJoinDate() {
		return uJoinDate;
	}
	public void setuJoinDate(Date uJoinDate) {
		this.uJoinDate = uJoinDate;
	}
	public String getuProfileImg() {
		return uProfileImg;
	}
	public void setuProfileImg(String uProfileImg) {
		this.uProfileImg = uProfileImg;
	}
	
	public Integer getuPostNum() {
		return uPostNum;
	}
	public void setuPostNum(Integer uPostNum) {
		this.uPostNum = uPostNum;
	}
	public Integer getuCommentNum() {
		return uCommentNum;
	}
	public void setuCommentNum(Integer uCommentNum) {
		this.uCommentNum = uCommentNum;
	}
	public Integer getuPoint() {
		return uPoint;
	}
	public void setuPoint(Integer uPoint) {
		this.uPoint = uPoint;
	}
	
	

}