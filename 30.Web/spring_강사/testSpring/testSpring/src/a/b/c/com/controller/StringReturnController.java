package a.b.c.com.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class StringReturnController {
	
	// return 형 String
	@RequestMapping("viewJsp_1_stringTest_find")
	public String returnStringTest(Model m) {
		System.out.println("StringReturnController returnStringTest() 함수 진입 >>> :");
		
		// 데이터는 m.addAttribute(key, value);
		m.addAttribute("mdata", "view에 데이터를 전달 할 때는 가능하면 Model 인터페이스를 사용하자 >>> : ");
		
		// view 페이지는 함수 리턴형을 String으로 해서 String return value 로 보낸다.
		return "viewJsp_1_stringTest_return_file";
	}
	
	// return 형 ModelAndView
	@RequestMapping("viewJsp_2_modelandview_find")
	public ModelAndView returnModelAndViewTest() {
		System.out.println("StringReturnController returnModelAndViewTest() 함수 진입 >>> :");
		
		// mav.addObject(key, value); 데이터 보내기
		// mav.setViewName("View 페이지 이름");
		ModelAndView mav = new ModelAndView();
		mav.addObject("mavdata", "ModelAndView Return Data");
		mav.setViewName("viewJsp_2_modelandview_return_file");
		
		return mav;
	}
	
	@RequestMapping("viewJsp_3_voidTest_find")
	public void voidTest(Model md) {
		md.addAttribute("mmmm",   "스프링에서는 void 리턴형도 " 
	                            + " 리턴이 되네요 신기합니다. !!"
	                            + " 단 조건이 있습니다."
	                            + " 요청 url 이름과 "
	                            + " view 이름이 같아야 합니다. !!! ");
	}
}
