<<<<<<< HEAD
package mvc.dto;

import java.util.List;

import org.springframework.web.multipart.MultipartFile;

public class FileDto {
	private String title;
	private List<MultipartFile> upload;
	
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public List<MultipartFile> getUpload() {
		return upload;
	}
	public void setUpload(List<MultipartFile> upload) {
		this.upload = upload;
	}
	
	
}
=======
package mvc.dto;

import java.util.List;

import org.springframework.web.multipart.MultipartFile;

public class FileDto {
	private String title;
	private List<MultipartFile> upload;
	
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public List<MultipartFile> getUpload() {
		return upload;
	}
	public void setUpload(List<MultipartFile> upload) {
		this.upload = upload;
	}
	
	
}
>>>>>>> 30ebd69548b3f1fe135993308031ec9150345305
