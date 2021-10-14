package a.b.c.com.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class HelloWorldController {
 
	// Ŭ���̾�Ʈ �����͸� �޾ƿ��� ������̼� ����
	@RequestMapping("helloWorld_Controller_find")		
	// Interface Model : model�� ������ �����ϴ� �뵵
	public String helloWorld(Model model) {
		System.out.println("HelloWorldController helloWorld() �Լ� ���� ");
		// setAttribute() �� ���� ���
		model.addAttribute("msg", "Hello World Spring !!!! again >>> : ");
		
		// /testSpring/WeblContent/WEB-INF/view/helloWorld_return_jspfile_name.jsp
		// �� ã�ư���� �ǹ� 
		// �� ��δ� spring-servlet.xml�� ������ ��.
		// /WEB-INF/view/*.jsp�� �����ϴ� jsp �����̸��� ���ϸ� ����ϸ� �ȴ�.
		// ( ȯ�漳������ spring-servlet.xml�� prefix�� suffix�� �����صξ��� ���� )
		return "helloWorld_return_jspfile_name";
	}
	
	/*
	 	MODEL2 + MVC ���ϰ� ����� ����� �ٸ��� ������,
	 	�Լ� ������ �����δ�.
	 	@RequestMapping("helloWorld_Controller_find")�� �����͸� �޴� ������ �Ѵ�.
	 	�Լ��� ������ �޴� ������ �ƴ� ������ �Ѵ�.
	*/

	/*
	  	< API >
	  	org.springframework.web.bind.annotation.RequestMethod
	  	
	  	Enum : ��� �迭
	  	Enum Constant Detail
		  	public static final RequestMethod GET
		  	public static final RequestMethod POST
	 
	 */
	@RequestMapping(value="helloWorld_get", method=RequestMethod.GET)
	public String helloWorld_get(Model model) {
		System.out.println("HelloWorldController helloWorld_get() �Լ� ����");
		
		// ��ü�� ����
		model.addAttribute("get_msg", "RequestMethod GET ��� >>> : ");
		System.out.println("model >>> : " + model);
		
		// /testSpring/WEB-INF/view/helloWorld_get.jsp
		// jsp ���ϸ� ������ ���ؼ� String return ��
		return "helloWorld_get";
	}
	
	@RequestMapping(value="helloWorld_post", method=RequestMethod.POST)
	public String helloWorld_post(Model model) {
		System.out.println("HelloWorldController helloWorld_post() �Լ� ���� >>> : ");
		
		model.addAttribute("post_msg", "RequestMethod POST ��� >>> : ");
		System.out.println("model >>> : " + model);
		
		// /testSpring/WEB-INF/view/helloWorld_post.jsp
		return "helloWorld_post";
	}
}
