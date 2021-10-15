package a.b.c.com.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class StringReturnController {
	
	// return �� String
	@RequestMapping("viewJsp_1_stringTest_find")
	public String returnStringTest(Model m) {
		System.out.println("StringReturnController returnStringTest() �Լ� ���� >>> :");
		
		// �����ʹ� m.addAttribute(key, value);
		m.addAttribute("mdata", "view�� �����͸� ���� �� ���� �����ϸ� Model �������̽��� ������� >>> : ");
		
		// view �������� �Լ� �������� String���� �ؼ� String return value �� ������.
		return "viewJsp_1_stringTest_return_file";
	}
	
	// return �� ModelAndView
	@RequestMapping("viewJsp_2_modelandview_find")
	public ModelAndView returnModelAndViewTest() {
		System.out.println("StringReturnController returnModelAndViewTest() �Լ� ���� >>> :");
		
		// mav.addObject(key, value); ������ ������
		// mav.setViewName("View ������ �̸�");
		ModelAndView mav = new ModelAndView();
		mav.addObject("mavdata", "ModelAndView Return Data");
		mav.setViewName("viewJsp_2_modelandview_return_file");
		
		return mav;
	}
	
	@RequestMapping("viewJsp_3_voidTest_find")
	public void voidTest(Model md) {
		md.addAttribute("mmmm",   "������������ void �������� " 
	                            + " ������ �ǳ׿� �ű��մϴ�. !!"
	                            + " �� ������ �ֽ��ϴ�."
	                            + " ��û url �̸��� "
	                            + " view �̸��� ���ƾ� �մϴ�. !!! ");
	}
}
