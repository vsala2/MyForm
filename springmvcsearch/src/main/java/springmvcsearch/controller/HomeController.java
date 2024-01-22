package springmvcsearch.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class HomeController {
	
	@RequestMapping("/display")
	public String display() {
		return "display";
	}

	@RequestMapping("/welcome")
	public String welcome(@RequestParam("name") String name, Model m) {
		m.addAttribute("name", name);
		return "welcome";
	}
}
 