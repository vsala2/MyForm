package springmvcsearch.controller;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.servlet.view.RedirectView;

@Controller
public class SearchController {
	
	@RequestMapping("/user/{userId}/{userName}")
	public String getUserDetail(@PathVariable("userId") int userId, @PathVariable("userName") String userName) {
		System.out.println(userId);
		System.out.println(userName);
		Integer.parseInt(userName);
		return "home";
	}
	
	@RequestMapping("/home")
	public String home() {
		System.out.println("Home View");
		String str = null;
		System.out.println(str.length());
		return "home";
	}
	
	@RequestMapping("/search")
	public RedirectView search(@RequestParam("querybox") String query) {
		
		RedirectView redirectView = new RedirectView();
		
		if(query.isBlank()) {
			redirectView.setUrl("home");
		}else {
			String url = "https://www.google.com/search?q=" + query;
			
			redirectView.setUrl(url);
		}
		
		return redirectView;
	}
	
	@ResponseStatus(value = HttpStatus.INTERNAL_SERVER_ERROR)
	@ExceptionHandler(value = NullPointerException.class)
	public String exceptionHandlerNull(Model m) {
		m.addAttribute("msg", "Null Pointer Exception!");
		return "error_page";
	}
	
	@ResponseStatus(value = HttpStatus.INTERNAL_SERVER_ERROR)
	@ExceptionHandler(value = NumberFormatException.class)
	public String exceptionHandlerNumber(Model m) {
		m.addAttribute("msg", "Number Format Exception!");
		return "error_page";
	}

	@ResponseStatus(value = HttpStatus.INTERNAL_SERVER_ERROR)
	@ExceptionHandler(value = Exception.class)
	public String exceptionHandlerGeneric(Model m) {
		m.addAttribute("msg", "Generic Exception!");
		return "error_page";
	}
}
