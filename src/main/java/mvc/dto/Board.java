package mvc.dto;

import java.util.Date;

import org.springframework.web.multipart.MultipartFile;

public class Board {
	private int boardno;
	private String title;
	private String writerid;
	private String writer;
	private String content;
	private int hit;
	private int recommend;
	private Date writtendate;
	
	private MultipartFile multipartFile;
		
	public MultipartFile getMultipartFile() {
		return multipartFile;
	}
	public void setMultipartFile(MultipartFile multipartFile) {
		this.multipartFile = multipartFile;
	}
	public int getBoardno() {
		return boardno;
	}
	public void setBoardno(int boardno) {
		this.boardno = boardno;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getWriterid() {
		return writerid;
	}
	public void setWriterid(String writerid) {
		this.writerid = writerid;
	}
	public String getWriter() {
		return writer;
	}
	public void setWriter(String writer) {
		this.writer = writer;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public int getHit() {
		return hit;
	}
	public void setHit(int hit) {
		this.hit = hit;
	}
	public int getRecommend() {
		return recommend;
	}
	public void setRecommend(int recommend) {
		this.recommend = recommend;
	}
	public Date getWrittendate() {
		return writtendate;
	}
	public void setWrittendate(Date writtendate) {
		this.writtendate = writtendate;
	}

	@Override
	public String toString() {
		return "Board [boardno="+boardno
				+", title="+title
				+", writerid="+writerid
				+", writer="+writer
				+", content="+content
				+", hit="+hit
				+", recommend="+recommend
				+", writtendate="+writtendate+"]";
	}
}
