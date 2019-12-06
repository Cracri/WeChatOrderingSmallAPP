package com.wx.pojo;

public class Comment {
	private int id;
	private String userName;
	private String userPic;
	private String userComment;
	private String isGave;
	private int Likes;
	private int judge;
	private String commentTime;
	
	
	
	public int getJudge() {
		return judge;
	}
	public void setJudge(int judge) {
		this.judge = judge;
	}
	public String getIsGave() {
		return isGave;
	}
	public void setIsGave(String isGave) {
		this.isGave = isGave;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getUserPic() {
		return userPic;
	}
	public void setUserPic(String userPic) {
		this.userPic = userPic;
	}
	public String getUserComment() {
		return userComment;
	}
	public void setUserComment(String userComment) {
		this.userComment = userComment;
	}
//
	public int getLikes() {
		return Likes;
	}
	public void setLikes(int likes) {
		Likes = likes;
	}
	public String getCommentTime() {
		return commentTime;
	}
	public void setCommentTime(String commentTime) {
		this.commentTime = commentTime;
	}
	@Override
	public String toString() {
		return "Comment [id=" + id + ", userName=" + userName + ", userPic=" + userPic + ", userComment=" + userComment
				+ ", isGave=" + isGave + ", Likes=" + Likes + ", judge=" + judge + ", commentTime=" + commentTime + "]";
	}
	
	
	
}
