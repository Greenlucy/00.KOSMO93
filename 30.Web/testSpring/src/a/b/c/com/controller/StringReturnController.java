package a.b.c.com.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class StringReturnController {
	
	// return �� String
	@RequestMapping("veiwJsp_1_stringTest_find")
	public String returnStringTest(Model m) {
		System.out.println("StringReturnController returnStrintTest() �Լ� ���� >>> : ");
		
		// �����ʹ� m.addAttribute(key, value); �� ������
		m.addAttribute("mdata", "view�� �����͸� ������ ���� �����ϸ� Model �������̽��� �������");
		
		// view �������� �Լ� �������� String���� �ؼ� jsp���ϸ��� String return value�� ������.
		return "viewJsp_1_stringTest_return_file";
	}
	
	// return �� ModelAndView
	/*  < API >
	 	public class ModelAndView extends Object	(Ŭ����, ��ü)
	   : Holder for both Model and View in the web MVC framework */
	@RequestMapping("viewJsp_2_modelandview_find")
	public ModelAndView returnModelAndViewTest() {
		
		// ModelAndView.addObject(String attributeName, Object attributeValue)
		// mav.addObject(key, value); �� ������ ������
		// mav.setViewName("View ������ �̸�");
		ModelAndView mav = new ModelAndView();
		mav.addObject("mavdata", "ModelAndView Return Data");
		mav.setViewName("viewJsp_2_modelandview_return_file");
		
		return mav;
	}
	
	/*
	 * ������ ������ �����Ϳ� ������ �޾Ƽ� ������ String, ModelAndView�� ���� 
	 * �����긦 �˾Ƽ� ���ش�. 
	 */
	
	@RequestMapping("viewJsp_3_voidTest_find")
	public void voidTest(Model md) {
		md.addAttribute("mmmm", "������������ void ��������"
								+ " ������ �ǳ׿� �ű��մϴ�. !!"
								+ " �� ������ �ֽ��ϴ�."
								+ " ��û url �̸��� "
								+ " view �̸��� ���ƾ� �մϴ�. !!!");
	}
}
