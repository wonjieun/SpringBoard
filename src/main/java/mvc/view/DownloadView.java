package mvc.view;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.OutputStream;
import java.net.URLEncoder;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.util.FileCopyUtils;
import org.springframework.web.servlet.view.AbstractView;

public class DownloadView extends AbstractView {

	@Override
	protected void renderMergedOutputModel(
			Map<String, Object> model,
			HttpServletRequest req,
			HttpServletResponse resp)
			throws Exception {

		File file = (File)model.get("downFile");
//		System.out.println("DownView - path : " + file.getPath());
		System.out.println("DownView - file : " + file.getName());
//		System.out.println("DownView - exist : " + file.exists() );
		
		resp.setContentType("application/octet-stream");
		resp.setContentLength((int)file.length());

		String[] splitted = file.getName().split("_");
		
		System.out.println(splitted);
		
		String filename =
			URLEncoder.encode(file.getName().split("_")[splitted.length-2], "utf-8" );
		
		filename = filename.replace("+", "%20");

		filename = filename.replace("%5B", "[");
		filename = filename.replace("%5D", "]");
		
		filename = filename.replace("%21", "!");
		filename = filename.replace("%23", "#");
		filename = filename.replace("%24", "$");
		filename = filename.replace("%25", "%");
		filename = filename.replace("%26", "&");
		filename = filename.replace("%27", "'");
		filename = filename.replace("%28", "(");
		filename = filename.replace("%29", ")");
		filename = filename.replace("%2B", "+");
		filename = filename.replace("%2C", ",");
		
		filename = filename.replace("%40", "@");
		filename = filename.replace("%5E", "^");
		
		System.out.println(filename);

		// "Content-Disposition": "attachment; filename=\"파일명\"";
		resp.setCharacterEncoding("utf-8");
		resp.setHeader("Content-Disposition",
			"attachment; filename=\"" + filename + "\";");
		resp.setHeader("Content-Transfer-Encoding", "binary");
		
		// File ---FileInputStream--> out(OutputStream)
		OutputStream out = resp.getOutputStream();
		FileInputStream fis = null;

		try {
			fis = new FileInputStream(file);
			FileCopyUtils.copy(fis, out);
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				if(fis != null)	fis.close();
			} catch (IOException e) { }
		}
		
		out.flush();
	}
}





