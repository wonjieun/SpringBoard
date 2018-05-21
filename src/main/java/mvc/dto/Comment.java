package mvc.dto;

import java.util.Date;

public class Comment {
	private int rnum;
	private int commentNo;
	private int boardNo;
	private String userid;
	private String commentWriter;
	private String pw;
	private String content;
	private Date writtenDate;
	
	public int getRnum() {
		return rnum;
	}

	public void setRnum(int rnum) {
		this.rnum = rnum;
	}

	public int getCommentNo() {
		return commentNo;
	}
	
	public void setCommentNo(int commentNo) {
		this.commentNo = commentNo;
	}

	public int getBoardNo() {
		return boardNo;
	}
	
	public void setBoardNo(int boardNo) {
		this.boardNo = boardNo;
	}

	public String getUserid() {
		return userid;
	}


	public void setUserid(String userid) {
		this.userid = userid;
	}

	public String getCommentWriter() {
		return commentWriter;
	}

	public void setCommentWriter(String commentWriter) {
		this.commentWriter = commentWriter;
	}

	public String getPw() {
		return pw;
	}

	public void setPw(String pw) {
		this.pw = pw;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public Date getWrittenDate() {
		return writtenDate;
	}

	public void setWrittenDate(Date writtenDate) {
		this.writtenDate = writtenDate;
	}

	@Override
	public String toString() {
		return "Comment [commentNo=" + commentNo
				+ ", boardNo=" + boardNo
				+ ", userid=" + userid
				+ ", commentWriter=" + commentWriter
				+ ", pw=" + pw
				+ ", content=" + content
				+ ", writtenDate=" + writtenDate + "]";
	}
}












