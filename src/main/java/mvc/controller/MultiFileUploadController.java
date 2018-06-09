package mvc.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;

import mvc.dto.FileDto;

@Controller
public class MultiFileUploadController {
	@RequestMapping(value="/file/multiupload1.do", method=RequestMethod.GET)
	public String multiFileuploadForm() {
		return "file/multiuploadForm1";
	}
	@RequestMapping(value="/file/multiupload1.do", method=RequestMethod.POST)
	public String multiFileupload(FileDto f) {
		
		System.out.println(f);
		System.out.println(f.getUpload());
		
		List<MultipartFile> list = f.getUpload();
		
		System.out.println(list.get(0).getOriginalFilename());
		System.out.println(list.get(1).getOriginalFilename());
		System.out.println(list.get(2).getOriginalFilename());
		
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
