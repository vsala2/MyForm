package springmvcsearch.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import springmvcsearch.entities.Student;

@Controller
public class FormController {
	
	@RequestMapping("/complex")
	public String showForm() {
		return "complex_form";
	}
	
	//using ModelAttribute for auto binding
	@RequestMapping(path="/handleform", method = RequestMethod.POST)
	public String formHandler(@ModelAttribute("student") Student student) {
		System.out.println(student);
		return "success";
	}
}
