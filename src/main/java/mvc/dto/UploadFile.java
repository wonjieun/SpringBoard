package mvc.dto;

import java.util.Date;

/**
 *
 * <pre>
 * mvc.dto
 * UploadFile.java
 * </pre>
 * 
 * 파일첨부가 없을 경우 Board테이블의 속성이 null인 것이 많다. = 별로다
 * 따라서, 파일첨부용 테이블을 따로 생성하여 만들어준다
 * 
 * @title  : 
 * @since  : 2018. 5. 22.
 * @author : jieun
 *
 */
public class UploadFile {
	private int boardno;
	private int fileno;
	private String original_filename;
	private String stored_filename;
	private long file_size;
	private Date upload_date;

	public int getBoardno() {
		return boardno;
	}
	public void setBoardno(int boardno) {
		this.boardno = boardno;
	}
	public int getFileno() {
		return fileno;
	}
	public void setFileno(int fileno) {
		this.fileno = fileno;
	}
	public String getOriginal_filename() {
		return original_filename;
	}
	public void setOriginal_filename(String original_filename) {
		this.original_filename = original_filename;
	}
	public String getStored_filename() {
		return stored_filename;
	}
	public void setStored_filename(String stored_filename) {
		this.stored_filename = stored_filename;
	}
	public long getFile_size() {
		return file_size;
	}
	public void setFile_size(long file_size) {
		this.file_size = file_size;
	}
	public Date getUpload_date() {
		return upload_date;
	}
	public void setUpload_date(Date upload_date) {
		this.upload_date = upload_date;
	}
	@Override
	public String toString() {
		return "UploadFile [fileno="+fileno
				+ ", original_filename=" + original_filename
				+ ", stored_filename=" + stored_filename
				+ ", file_size=" + file_size
				+ ", upload_date=" + upload_date;
	}
}
