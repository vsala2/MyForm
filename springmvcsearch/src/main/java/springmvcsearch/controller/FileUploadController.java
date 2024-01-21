package springmvcsearch.controller;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

@Controller
public class FileUploadController {
	
	@RequestMapping("/fileupload")
	public String showUploadForm() {
		return "fileform";
	}
	
	@RequestMapping(value= "/uploadimage", method = RequestMethod.POST )
	public String fileupload(@RequestParam("profile") CommonsMultipartFile file, HttpSession s, Model m) {
		System.out.println("file upload");
		System.out.println(file.getSize());
		System.out.println(file.getContentType());
		System.out.println(file.getName());
		System.out.println(file.getOriginalFilename());
		System.out.println(file.getStorageDescription());
		
		//in byte format
		byte[] data = file.getBytes();
		
//		C:\Users\Vaishnavi Salaskar\eclipse-workspace\.metadata\.plugins\org.eclipse.wst.server.core\tmp0\wtpwebapps\springmvcsearch\ 
//		String path = s.getServletContext().getRealPath("/");
//		System.out.println(path);
		
		String path = s.getServletContext().getRealPath("/") + "WEB-INF" + File.separator + "resources" + File.separator + "image" + File.separator + file.getOriginalFilename();
		System.out.println(path);
		
		try {
			FileOutputStream fos = new FileOutputStream(path);
			fos.write(data);
			fos.close();
			System.out.println("File uploaded");
			
			m.addAttribute("msg", "Uploaded!!");
			m.addAttribute("fileName",file.getOriginalFilename()); 
		}catch(IOException e) {
			e.printStackTrace();
			System.out.println("Error");
			m.addAttribute("msg", "Errorrr!!");
		}
		
		return "filesuccess";
	}

}
