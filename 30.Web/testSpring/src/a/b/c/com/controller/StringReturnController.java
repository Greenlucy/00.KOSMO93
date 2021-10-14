package a.b.c.com.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class StringReturnController {
	
	// return 형 String
	@RequestMapping("veiwJsp_1_stringTest_find")
	public String returnStringTest(Model m) {
		System.out.println("StringReturnController returnStrintTest() 함수 진입 >>> : ");
		
		// 데이터는 m.addAttribute(key, value); 로 보내고
		m.addAttribute("mdata", "view에 데이터를 전달할 때는 가능하면 Model 인터페이스를 사용하자");
		
		// view 페이지는 함수 리턴형을 String으로 해서 jsp파일명을 String return value로 보낸다.
		return "viewJsp_1_stringTest_return_file";
	}
	
	// return 형 ModelAndView
	/*  < API >
	 	public class ModelAndView extends Object	(클래스, 객체)
	   : Holder for both Model and View in the web MVC framework */
	@RequestMapping("viewJsp_2_modelandview_find")
	public ModelAndView returnModelAndViewTest() {
		
		// ModelAndView.addObject(String attributeName, Object attributeValue)
		// mav.addObject(key, value); 로 데이터 보내기
		// mav.setViewName("View 페이지 이름");
		ModelAndView mav = new ModelAndView();
		mav.addObject("mavdata", "ModelAndView Return Data");
		mav.setViewName("viewJsp_2_modelandview_return_file");
		
		return mav;
	}
	
	/*
	 * 디스패쳐 서블릿이 데이터와 정보를 받아서 리턴형 String, ModelAndView에 따라 
	 * 리졸브를 알아서 해준다. 
	 */
	
	@RequestMapping("viewJsp_3_voidTest_find")
	public void voidTest(Model md) {
		md.addAttribute("mmmm", "스프링에서는 void 리턴형도"
								+ " 리턴이 되네요 신기합니다. !!"
								+ " 단 조건이 있습니다."
								+ " 요청 url 이름과 "
								+ " view 이름이 같아야 합니다. !!!");
	}
}
