package org.fofo.board.vo;

import java.io.Serializable;

public class FreeComment implements Serializable {

	private static final long serialVersionUID = -4022161635202540887L;
	
	private int fCommentId;
	private int fPostId;
	private int UserId;
	private String uProfileImg;
	private String fcommentDate;
	private String fCommentContent;
	private int fCommentNum;

	public FreeComment() {
		// TODO Auto-generated constructor stub
	}

	public int getfCommentId() {
		return fCommentId;
	}

	public void setfCommentId(int fCommentId) {
		this.fCommentId = fCommentId;
	}

	public int getfPostId() {
		return fPostId;
	}

	public void setfPostId(int fPostId) {
		this.fPostId = fPostId;
	}

	public int getUserId() {
		return UserId;
	}

	public void setUserId(int userId) {
		UserId = userId;
	}

	public String getuProfileImg() {
		return uProfileImg;
	}

	public void setuProfileImg(String uProfileImg) {
		this.uProfileImg = uProfileImg;
	}

	public String getFcommentDate() {
		return fcommentDate;
	}

	public void setFcommentDate(String fcommentDate) {
		this.fcommentDate = fcommentDate;
	}

	public String getfCommentContent() {
		return fCommentContent;
	}

	public void setfCommentContent(String fCommentContent) {
		this.fCommentContent = fCommentContent;
	}

	public int getfCommentNum() {
		return fCommentNum;
	}

	public void setfCommentNum(int fCommentNum) {
		this.fCommentNum = fCommentNum;
	}

	@Override
	public String toString() {
		return "FreeComment [fCommentId=" + fCommentId + ", fPostId=" + fPostId + ", UserId=" + UserId
				+ ", uProfileImg=" + uProfileImg + ", fcommentDate=" + fcommentDate + ", fCommentContent="
				+ fCommentContent + ", fCommentNum=" + fCommentNum + "]";
	}

}
