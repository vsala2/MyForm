package springmvcsearch.controller;

import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
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
	//For handling any inappropriate error we are using BindingResult  
	@RequestMapping(path="/handleform", method = RequestMethod.POST)
	public String formHandler(@ModelAttribute("student") Student student, BindingResult result) {
		
		//checking if any error in form
		if(result.hasErrors()) {
			//this will redirect to the form page
			return "complex_form";
			//to show the error on the page we need srpingframework taglib lib in the complex_form.jsp page
		}
		
		System.out.println(student);
		return "success";
	}
}
