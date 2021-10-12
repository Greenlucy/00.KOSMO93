package a.b.c.com.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HelloWorldController {

	@RequestMapping("helloWorld_Controller_find")
	public String helloWorld(Model model) {
		
		model.addAttribute("message", "Hello World Spring!!!! again >>>> : ");
		
		return "helloWorld_return_jspfile_name";
	}
}
