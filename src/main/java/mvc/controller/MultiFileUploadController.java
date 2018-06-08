package mvc.controller;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.UUID;

import javax.servlet.ServletContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;

import mvc.dto.FileDto;

@Controller
public class MultiFileUploadController {
	
	@Autowired ServletContext context;
	
	@RequestMapping(value="/file/multiupload1.do", method=RequestMethod.GET)
	public String multiFileuploadForm() {
		return "file/multiuploadForm1";
	}
	@RequestMapping(value="/file/multiupload1.do", method=RequestMethod.POST)
	public String multiFileupload(FileDto f) {
		
		System.out.println(f);
		System.out.println(f.getUpload());
		System.out.println(f.getTitle());
		
		List<MultipartFile> list = f.getUpload();
		
		System.out.println("list1: " + list.get(0).getOriginalFilename());
		System.out.println("list2: " + list.get(1).getOriginalFilename());
		System.out.println("list3: " + list.get(2).getOriginalFilename());
		
		// 고유 식별자
		String uID = UUID.randomUUID().toString().split("-")[0];
		
		// 파일이 저장될 경로
		String realpath = context.getRealPath("upload");
		
		// 파일이 저장될 이름
		String stored = list.get(0).getOriginalFilename() + "_" + uID;
		
		File dest = new File(realpath, stored);
		System.out.println(dest);
		
		// 실제 파일 업로드
		try {
			list.get(0).transferTo(dest);
		} catch (IllegalStateException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		return "file/multiuploadResult";
	}


	@RequestMapping(value="/file/multiupload2.do", method=RequestMethod.GET)
	public String multiFileuploadForm2() {
		return "file/multiuploadForm2";
	}
	@RequestMapping(value="/file/multiupload2.do", method=RequestMethod.POST)
	public String multiFileupload2(FileDto f) {
		
		System.out.println(f);
		System.out.println(f.getUpload());
		
		List<MultipartFile> list = f.getUpload();
		
		System.out.println(list.get(0).getOriginalFilename());
		System.out.println(list.get(1).getOriginalFilename());
		System.out.println(list.get(2).getOriginalFilename());
		
		return "file/multiuploadResult";
	}

}
