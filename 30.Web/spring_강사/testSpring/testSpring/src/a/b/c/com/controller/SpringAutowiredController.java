package a.b.c.com.controller;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import a.b.c.com.service.SpringAutowiredService;
import a.b.c.com.vo.FormDataVO;

/*
�������� ���� 
���߼���(���߷α׸� �ֿܼ� ��´�.) -> ������¡����(���󼭹��� ������ ȯ��) -> ���󼭹�(�α׸� �α����Ͽ� ����.) 

���߼������� �����ؼ� ���� �׽�Ʈ�� �Ϸ� �ϰ� ���� �׽�Ʈ(�����׽�Ʈ)�� �Ϸ�Ǹ�
����� ����� �� �ϰ� (������) 
������¡�������� �׽�Ʈ�� �Ѵ�.
������¡ �������� �׽�Ʈ�� ��� �Ǹ�
����� ����� �� �ϰ� (������)
���󼭹��� �����Ѵ�. 
*/


// @Controller -> @Service -> @Repository
// �������̽����� ������̼� ����� ���� �ڹٿ��� ������� �ʴ´�.
// ������̼��� �������̽��� ����� Ŭ�������� �����ؾ� �Ѵ�.
@Controller
public class SpringAutowiredController {
	private Logger logger = Logger.getLogger(SpringAutowiredController.class);
	
	
	// SpringAutowiredController ���� Ŭ������ ������ �����ӿ�ũ���� �ν��Ͻ� �� ��
	// SpringAutowiredController ���� Ŭ���� �̸��� ù��° �̴ϼ��� �ҹ��ڷ� �����ؼ� �ν��Ͻ� �Ѵ�. 
	// SpringAutowiredController springAutowiredService = new SpringAutowiredServiceImpl();
	final private SpringAutowiredService springAutowiredService;	
	// SpringAutowiredService springAutowiredService = new SpringAutowiredServiceImpl();
	
	/*	
		Autowired DI (Dependency Injection) : VO (DTO) �� �����͸� �ʱ�ȭ �ϴ� ���� 
			1. �ʵ� ����
				: @Autowired
				  final private SpringAutowiredService springAutowiredService;	 
			 
			2. setter ���� (�Լ��� ����)
				: @Autowired(required=false)
				  public String autowiredTest_Get(FormDataVO fvo, Model model) {}
			 
			3. ������ ���� 
				: @Autowired(required=false)
				  public SpringAutowiredService(SpringAutowiredService springAutowiredService) {
					 this.springAutowiredService = springAutowiredService; 
				  }
			 
			required=ture : ����Ʈ : Autowired �Ϸ��� bean(������Ʈ : Service Ŭ����, DAO Ŭ����)�� null �̸� ���� �߻� 
			required=false : Autowired �Ϸ��� bean(������Ʈ : Service Ŭ����, DAO Ŭ����)�� null �̾ ���� �߻����� �ʴ´�. 
	*/
	
	
	// ������̾�� ������̼� ������ ���� 
	@Autowired(required=false)
	public SpringAutowiredController(SpringAutowiredService springAutowiredService) {
		this.springAutowiredService = springAutowiredService;
	}
	
	
	@RequestMapping(value="autowired_test", method=RequestMethod.GET)
	public String autowired_test() {
		logger.info("SpringAutowiredController.autowired_test() �Լ� ����");
		
		return "autowired/autowired_test_return";
	}
	
	@RequestMapping(value="autowired_test_get", method=RequestMethod.GET)
	public String autowiredTest_Get(FormDataVO fvo, Model model) {
		logger.info("SpringAutowiredController.autowiredTest_Get() �Լ� ����");
		
		List<FormDataVO> list = springAutowiredService.autowiredTest(fvo);
		int listSize = list.size();
		
		logger.info("listSize >>> : " + listSize);
		model.addAttribute("list", list);
		
		return "autowired/autowired_test_get_return";
	}
}
