package a.b.c.com.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class HelloWorldController {

	@RequestMapping("helloWorld_Controller_find")
	public String helloWorld(Model model) {
		System.out.println("HelloWorldController helloWorld() 함수 진입");
		
		model.addAttribute("msg", "Hello World Spring !!!! again >>> : ");
		
		System.out.println("model >>> : " + model);
		
		// /testStpring/WebContent/WEB-INF/view/helloWorld_return_jspfile_name.jsp
		return "helloWorld_return_jspfile_name";
	}
	
	@RequestMapping(value="helloWorld_get", method=RequestMethod.GET)
	public String helloWorld_get(Model model) {
		System.out.println("HelloWorldController helloWorld_get() 함수 진입");
		
		model.addAttribute("get_msg", "RequestMethod GET 방식 >>> : ");
		
		// /testStpring/WebContent/WEB-INF/view/helloWorld_get.jsp
		return "helloWorld_get";
	}
	
	@RequestMapping(value="helloWorld_post", method=RequestMethod.POST)
	public String helloWorld_post(Model model) {
		System.out.println("HelloWorldController helloWorld_post() 함수 진입");
		
		model.addAttribute("post_msg", "RequestMethod POST 방식 >>> : ");
		
		// /testStpring/WebContent/WEB-INF/view/helloWorld_post.jsp
		return "helloWorld_post";
	}
}
