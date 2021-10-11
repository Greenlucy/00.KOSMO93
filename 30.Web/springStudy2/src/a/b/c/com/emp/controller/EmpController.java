package a.b.c.com.emp.controller;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import a.b.c.com.emp.service.EmpService;
import a.b.c.com.emp.vo.EmpVO;

@Controller
public class EmpController {
	private Logger logger = Logger.getLogger(EmpController.class);
	
	// ��Ʈ�ѷ����� ���� ���� 
	private EmpService empService;
		
	// �����ڿ� @Autowired ������̼�����  DI (������ �����ϱ�)
	@Autowired(required=false)
	public EmpController(EmpService empService) {
		this.empService = empService;		
	}
	
	@RequestMapping(value="empSelectAll", method=RequestMethod.GET)
	public String empSelectAll(Model model) {
		logger.info("EmpController memSelectAll �Լ� ���� >>> : ");
	

		List<EmpVO> listAll = empService.empSelectAll();
		int nCnt = listAll.size();
		logger.info("EmpController empSelectAll nCnt >>> : " + nCnt);
		
		if (nCnt > 0) {
			model.addAttribute("listAll", listAll);		
			return "emp/empSelectAll";	
		}
		
		return "emp/empForm";		
	}
	
	@RequestMapping(value="empSelectForm", method=RequestMethod.GET)
	public String empSelectForm(@ModelAttribute EmpVO evo, Model model) {
		logger.info("EmpController empSelectForm �Լ� ���� >>> : ");
			
		return "emp/empSelectForm";		
	}
	
	@RequestMapping(value="empSelect", method=RequestMethod.GET)
	public String empSelect(@ModelAttribute EmpVO evo, Model model) {
		logger.info("EmpController empSelect �Լ� ���� >>> : ");
		logger.info("EmpController evo.getSearchFilter() >>> : " + evo.getSearchFilter());
		logger.info("EmpController evo.getKeyword() >>> : " + evo.getKeyword());
		logger.info("EmpController evo.getStartDate() >>> : " + evo.getStartDate());
		logger.info("EmpController evo.getEndDate() >>> : " + evo.getEndDate());

		List<EmpVO> searchList = empService.empSelect(evo);
		int nCnt = searchList.size();
		logger.info("EmpController empSelect nCnt >>> : " + nCnt);
		
		if (nCnt > 0) {
			model.addAttribute("searchList", searchList);		
			return "emp/empSelect";	
		}
		
		return "emp/empForm";		
	}
}
