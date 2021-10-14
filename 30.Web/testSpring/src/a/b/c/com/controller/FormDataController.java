package a.b.c.com.controller;

import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import a.b.c.com.vo.FormDataVO;

@Controller
public class FormDataController {

	@RequestMapping(value="formdata_find", method=RequestMethod.GET)
	public String formdata() {
		
		/* "/mvc/formdata_return"이 아닌 이유
			spring-servlet.xml의 환경설정할 때 value 설정을 다음과 같이 했기 때문이다.
			<property name="prefix" value="/WEB-INF/view/"/>
			
			환경설정파일과 return을 연결하면 (prefix와 suffix 모두 연결)
			/WEB-INF/view/mvc/formdata_return.jsp
			주소가 완성된다.
		*/
		return "mvc/formdata_return";
	}
	
	@RequestMapping(value="formdata_get", method=RequestMethod.GET)
	public String formdata_get(HttpServletRequest req, Model m) {
		System.out.println("FormDataController : formdata_get() 함수 진입 >>> : ");
		
		String datanum = req.getParameter("datanum");
		String dataid = req.getParameter("dataid");
		String datapw = req.getParameter("datapw");
		String dataname = req.getParameter("dataname");
		System.out.println("datanum >>> : " + datanum);
		System.out.println("dataid >>> : " + dataid);
		System.out.println("datapw >>> : " + datapw);
		System.out.println("dataname >>> : " + dataname);
		
	//	System.out.println("datanum set 한 상태");
		req.setAttribute("request_datanum", datanum);
		req.setAttribute("request_dataid", dataid);
		req.setAttribute("request_datapw", datapw);
		req.setAttribute("request_dataname", dataname);
		
		m.addAttribute("el_datanum", datanum);
		m.addAttribute("el_dataid", dataid);
		m.addAttribute("el_datapw", datapw);
		m.addAttribute("el_dataname", dataname);
		
		return "/mvc/formdata_get";
	}
	
	@RequestMapping(value="formdata_get_spring", method=RequestMethod.GET)
	public String formdata_get_spring(FormDataVO fvo, Model m) {
		System.out.println("FormDataController : formdata_get_spring() 함수 진입 >>> : ");
		
		String fDatanum = fvo.getDatanum();
		String fDataid = fvo.getDataid();
		String fDatapw = fvo.getDatapw();
		String fDataname = fvo.getDataname();
		
		// 주소값
		System.out.println("formDataController.formdata_get_spring : fvo >>> : " + fvo);
		System.out.println("formDataController.formdata_get_spring : fDatanum >>> : " + fDatanum);
		System.out.println("formDataController.formdata_get_spring : fDatapw >>> : " + fDatapw);
		System.out.println("formDataController.formdata_get_spring : fDataname >>> : " + fDataname);
		
		m.addAttribute("m_fvo", fvo);
		
		return "/mvc/formdata_get_spring_return";
	}
	
}
