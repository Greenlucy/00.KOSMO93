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
현업에서 서버 
개발서버(개발로그를 콘솔에 찍는다.) -> 스테이징서버(리얼서버와 동일한 환경) -> 리얼서버(로그를 로그파일에 쓴다.) 

개발서버에서 개발해서 단위 테스트를 완료 하고 연계 테스트(통합테스트)가 완료되면
운영팀의 허락을 득 하고 (문서로) 
스테이징서버에서 테스트를 한다.
스테이징 서버에서 테스트가 통과 되면
운영팀의 허락을 득 하고 (문서로)
리얼서버에 포팅한다. 
*/


// @Controller -> @Service -> @Repository
// 인터페이스에서 어노테이션 사용은 아직 자바에서 허락하지 않는다.
// 어노테이션은 인터페이스를 상속한 클래스에서 적용해야 한다.
@Controller
public class SpringAutowiredController {
	private Logger logger = Logger.getLogger(SpringAutowiredController.class);
	
	
	// SpringAutowiredController 서비스 클래스를 스프링 프레임워크에서 인스턴스 할 때
	// SpringAutowiredController 서비스 클래스 이름의 첫번째 이니셜을 소문자로 변경해서 인스턴스 한다. 
	// SpringAutowiredController springAutowiredService = new SpringAutowiredServiceImpl();
	final private SpringAutowiredService springAutowiredService;	
	// SpringAutowiredService springAutowiredService = new SpringAutowiredServiceImpl();
	
	/*	
		Autowired DI (Dependency Injection) : VO (DTO) 에 데이터를 초기화 하는 행위 
			1. 필드 주입
				: @Autowired
				  final private SpringAutowiredService springAutowiredService;	 
			 
			2. setter 주입 (함수에 주입)
				: @Autowired(required=false)
				  public String autowiredTest_Get(FormDataVO fvo, Model model) {}
			 
			3. 생성자 주입 
				: @Autowired(required=false)
				  public SpringAutowiredService(SpringAutowiredService springAutowiredService) {
					 this.springAutowiredService = springAutowiredService; 
				  }
			 
			required=ture : 디폴트 : Autowired 하려는 bean(컴포넌트 : Service 클래스, DAO 클래스)이 null 이면 에러 발생 
			required=false : Autowired 하려는 bean(컴포넌트 : Service 클래스, DAO 클래스)이 null 이어도 에러 발생하지 않는다. 
	*/
	
	
	// 오토와이어드 어노테이션 생성자 주입 
	@Autowired(required=false)
	public SpringAutowiredController(SpringAutowiredService springAutowiredService) {
		this.springAutowiredService = springAutowiredService;
	}
	
	
	@RequestMapping(value="autowired_test", method=RequestMethod.GET)
	public String autowired_test() {
		logger.info("SpringAutowiredController.autowired_test() 함수 진입");
		
		return "autowired/autowired_test_return";
	}
	
	@RequestMapping(value="autowired_test_get", method=RequestMethod.GET)
	public String autowiredTest_Get(FormDataVO fvo, Model model) {
		logger.info("SpringAutowiredController.autowiredTest_Get() 함수 진입");
		
		List<FormDataVO> list = springAutowiredService.autowiredTest(fvo);
		int listSize = list.size();
		
		logger.info("listSize >>> : " + listSize);
		model.addAttribute("list", list);
		
		return "autowired/autowired_test_get_return";
	}
}
