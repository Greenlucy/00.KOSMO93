package a.b.c.com.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import a.b.c.com.vo.FormDataVO;

@Controller
public class FormDataController {

	@RequestMapping(value="formdata_find", method=RequestMethod.GET)
	public String formdata() {		
		
		// mvc/formdata_return
		// <property name="prefix" value="/WEB-INF/view/" />
		// /WEB-INF/view/mvc/formdata_return.jsp
		return "mvc/formdata_return";
	}
	
	// Servlet 방식으로 데이터를 웹브라우저에서 데이터를 받아오고 : request.getParameter()
	// Servlet 방식으로 데이터를 콘트롤러에서 jsp로 보낼 수 있다  : request.setAttribute()
	@RequestMapping(value="formdata_get_servlet", method=RequestMethod.GET)
	public String formdata_get(HttpServletRequest req, Model m) {
		
		String datanum = req.getParameter("datanum");
		String dataid = req.getParameter("dataid");
		String datapw = req.getParameter("datapw");
		String dataname = req.getParameter("dataname");
		System.out.println("FormDataController.formdata_get() :::: datanum >>> : " + datanum);
		System.out.println("FormDataController.formdata_get() :::: dataid >>> : " + dataid);
		System.out.println("FormDataController.formdata_get() :::: datapw >>> : " + datapw);
		System.out.println("FormDataController.formdata_get() :::: dataname >>> : " + dataname);
		
		req.setAttribute("request_datanum", datanum);
		req.setAttribute("request_dataid", dataid);
		req.setAttribute("request_datapw", datapw);
		req.setAttribute("request_dataname", dataname);
		
		m.addAttribute("el_datanum", datanum);
		m.addAttribute("el_dataid", dataid);
		m.addAttribute("el_datapw", datapw);
		m.addAttribute("el_dataname", dataname);
		
//		FormDataVO fvo = new FormDataVO();		
//		m.addAttribute("fvo_data", fvo);
		
		return "mvc/formdata_get_servlet";
	}
	
	// Spring Web MVC 방식으로 
	@RequestMapping(value="formdata_get_spring", method=RequestMethod.GET)
	public String formdata_get_spring(FormDataVO fvo, Model m) {
		System.out.println("FormDataController formdata_get_spring() 함수 진입");
		
		System.out.println("formdata_get_spring >>> : fvo ::: " + fvo);
		System.out.println("formdata_get_spring >>> : fvo.getDatanum() ::: " + fvo.getDatanum());
		System.out.println("formdata_get_spring >>> : fvo.getDataid() ::: " + fvo.getDataid());
		System.out.println("formdata_get_spring >>> : fvo.getDatapw() ::: " + fvo.getDatapw());
		System.out.println("formdata_get_spring >>> : fvo.getDataname() ::: " + fvo.getDataname());
		
		m.addAttribute("m_fvo", fvo);
		
		return "mvc/formdata_get_spring_return";
	}
	
	// Spring @ModelAttribute
	@RequestMapping(value="formdata_post_spring", method=RequestMethod.POST)
	public String formdata_post_modelattribute(@ModelAttribute("ma_fdvo") FormDataVO fdvo) {
		System.out.println("FormDataController formdata_post_modelattribute() 함수 진입");
		
		/*
			name="datanum"  ---> private String datanum
			name="dataid"   ---> private String dataid
			name="datapw"   ---> private String datapw
			name="dataname" ---> private String datapw
		*/				
		System.out.println("formdata_post_modelattribute >>> : fdvo ::: " + fdvo);
		System.out.println("formdata_post_modelattribute >>> : fdvo.getDatanum() ::: " + fdvo.getDatanum());
		System.out.println("formdata_post_modelattribute >>> : fdvo.getDataid() ::: " + fdvo.getDataid());
		System.out.println("formdata_post_modelattribute >>> : fdvo.getDatapw() ::: " + fdvo.getDatapw());
		System.out.println("formdata_post_modelattribute >>> : fdvo.getDataname() ::: " + fdvo.getDataname());
		
		return "mvc/formdata_post_spring_modelattribute_return";
	}
	
	@RequestMapping(value="formdata_post_valueobject", method=RequestMethod.POST)
	public String formdata_post_valueobject(FormDataVO fdvo) {
		
		System.out.println("formdata_post_valueobject >>> : fdvo ::: " + fdvo);
		System.out.println("formdata_post_valueobject >>> : fdvo.getDatanum() ::: " + fdvo.getDatanum());
		System.out.println("formdata_post_valueobject >>> : fdvo.getDataid() ::: " + fdvo.getDataid());
		System.out.println("formdata_post_valueobject >>> : fdvo.getDatapw() ::: " + fdvo.getDatapw());
		System.out.println("formdata_post_valueobject >>> : fdvo.getDataname() ::: " + fdvo.getDataname());
		
		return "mvc/formdata_post_valueobject_return";
	}
}
















