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
		
		/* "/mvc/formdata_return"�� �ƴ� ����
			spring-servlet.xml�� ȯ�漳���� �� value ������ ������ ���� �߱� �����̴�.
			<property name="prefix" value="/WEB-INF/view/"/>
			
			ȯ�漳�����ϰ� return�� �����ϸ� (prefix�� suffix ��� ����)
			/WEB-INF/view/mvc/formdata_return.jsp
			�ּҰ� �ϼ��ȴ�.
		*/
		return "mvc/formdata_return";
	}
	
	@RequestMapping(value="formdata_get", method=RequestMethod.GET)
	public String formdata_get(HttpServletRequest req, Model m) {
		System.out.println("FormDataController : formdata_get() �Լ� ���� >>> : ");
		
		String datanum = req.getParameter("datanum");
		String dataid = req.getParameter("dataid");
		String datapw = req.getParameter("datapw");
		String dataname = req.getParameter("dataname");
		System.out.println("datanum >>> : " + datanum);
		System.out.println("dataid >>> : " + dataid);
		System.out.println("datapw >>> : " + datapw);
		System.out.println("dataname >>> : " + dataname);
		
	//	System.out.println("datanum set �� ����");
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
		System.out.println("FormDataController : formdata_get_spring() �Լ� ���� >>> : ");
		
		String fDatanum = fvo.getDatanum();
		String fDataid = fvo.getDataid();
		String fDatapw = fvo.getDatapw();
		String fDataname = fvo.getDataname();
		
		// �ּҰ�
		System.out.println("formDataController.formdata_get_spring : fvo >>> : " + fvo);
		System.out.println("formDataController.formdata_get_spring : fDatanum >>> : " + fDatanum);
		System.out.println("formDataController.formdata_get_spring : fDatapw >>> : " + fDatapw);
		System.out.println("formDataController.formdata_get_spring : fDataname >>> : " + fDataname);
		
		m.addAttribute("m_fvo", fvo);
		
		return "/mvc/formdata_get_spring_return";
	}
	
}
