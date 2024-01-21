package springmvcsearch.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class FileUploadController {
	
	@RequestMapping("/fileupload")
	public String showUploadForm() {
		return "fileform";
	}
	

}
