package a.b.c.com.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class HelloWorldController {
 
	// 클라이언트 데이터를 받아오는 어노테이션 역할
	@RequestMapping("helloWorld_Controller_find")		
	// Interface Model : model은 데이터 전달하는 용도
	public String helloWorld(Model model) {
		System.out.println("HelloWorldController helloWorld() 함수 진입 ");
		// setAttribute() 과 같은 기능
		model.addAttribute("msg", "Hello World Spring !!!! again >>> : ");
		
		// /testSpring/WeblContent/WEB-INF/view/helloWorld_return_jspfile_name.jsp
		// 를 찾아가라는 의미 
		// 요 경로는 spring-servlet.xml에 세팅해 둠.
		// /WEB-INF/view/*.jsp로 리턴하는 jsp 파일이름을 파일명만 기술하면 된다.
		// ( 환경설정파일 spring-servlet.xml에 prefix와 suffix로 설정해두었기 때문 )
		return "helloWorld_return_jspfile_name";
	}
	
	/*
	 	MODEL2 + MVC 패턴과 실행된 결과는 다르지 않지만,
	 	함수 단위로 움직인다.
	 	@RequestMapping("helloWorld_Controller_find")가 데이터를 받는 역할을 한다.
	 	함수는 정보를 받는 역할이 아닌 구현만 한다.
	*/

	/*
	  	< API >
	  	org.springframework.web.bind.annotation.RequestMethod
	  	
	  	Enum : 상수 배열
	  	Enum Constant Detail
		  	public static final RequestMethod GET
		  	public static final RequestMethod POST
	 
	 */
	@RequestMapping(value="helloWorld_get", method=RequestMethod.GET)
	public String helloWorld_get(Model model) {
		System.out.println("HelloWorldController helloWorld_get() 함수 진입");
		
		// 객체를 보냄
		model.addAttribute("get_msg", "RequestMethod GET 방식 >>> : ");
		System.out.println("model >>> : " + model);
		
		// /testSpring/WEB-INF/view/helloWorld_get.jsp
		// jsp 파일명 보내기 위해서 String return 함
		return "helloWorld_get";
	}
	
	@RequestMapping(value="helloWorld_post", method=RequestMethod.POST)
	public String helloWorld_post(Model model) {
		System.out.println("HelloWorldController helloWorld_post() 함수 진입 >>> : ");
		
		model.addAttribute("post_msg", "RequestMethod POST 방식 >>> : ");
		System.out.println("model >>> : " + model);
		
		// /testSpring/WEB-INF/view/helloWorld_post.jsp
		return "helloWorld_post";
	}
}
