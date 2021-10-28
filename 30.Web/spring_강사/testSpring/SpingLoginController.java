package a.b.c.com.login.controller;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import a.b.c.com.login.service.SpringLoginService;
import a.b.c.com.mem.vo.SpringMemberVO;

@Controller
public class SpingLoginController {
	Logger logger = Logger.getLogger(SpingLoginController.class);
	
	private SpringLoginService springLoginService;
	
	// 생성자 오토와이어드 
	@Autowired(required=false)	
	public SpingLoginController(SpringLoginService springLoginService) {
		this.springLoginService = springLoginService;	
	}	
		
	// 로그인 입력  폼	
	@GetMapping("loginForm")
	public String loginForm() {	
		logger.info("SpingLoginController loginForm() 함수 진입 >>> : ");
		return "login/springLoginFome";
	}
	
	@PostMapping("login")
	public String login(SpringMemberVO mvo, Model model) {	
		logger.info("SpingLoginController login() 함수 진입 >>> : ");
		
		SpringMemberVO.printVO(mvo);
		
		List<SpringMemberVO> listLogin = springLoginService.loginCheck(mvo);
		logger.info("SpingLoginController login listLogin.size() >>> : " + listLogin.size());
		
		if (listLogin.size() == 1) { 
			model.addAttribute("listLogin", listLogin);
			return "login/springLogin";
		}		

		return "login/springLoginFome";
	}
}
