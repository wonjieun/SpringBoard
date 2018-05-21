package mvc.controller;

import java.io.File;
import java.io.IOException;
import java.util.UUID;

import javax.servlet.ServletContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;

import mvc.dao.FileDao;
import mvc.dto.UploadFile;

@Controller
public class FileController {
	
	@Autowired ServletContext context;
	@Autowired FileDao fileDao;
	
	@RequestMapping(value="/file/fileForm.do", method=RequestMethod.GET)
	public void fileForm() { }
	
	@RequestMapping(value="/file/fileup.do", method=RequestMethod.POST)
	public String fileupload(MultipartFile file) {
//		System.out.println(file.getName());
		
		// 고유 식별자
		String uID = UUID.randomUUID().toString().split("-")[0];
		
		// 파일이 저장될 경로
		String realpath = context.getRealPath("upload");
		
		// 파일이 저장될 이름
		String stored = file.getOriginalFilename() + "_" + uID;
		
//		1. File dest = new File("경로+파일");
//		2. File dest = new File("경로", "파일");
		File dest = new File(realpath, stored);
//		System.out.println(dest);
		
		// 실제 파일 업로드
		try {
			file.transferTo(dest);
		} catch (IllegalStateException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		// DB에 기록
		UploadFile uploadFile = new UploadFile();
		uploadFile.setOriginal_filename(file.getOriginalFilename());
		uploadFile.setStored_filename(stored);
		uploadFile.setFile_size(file.getSize());
		
		fileDao.insert(uploadFile);
		
		return null;
	}

}
