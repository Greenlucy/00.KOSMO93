package a.b.c.com.kosmo.login.service;

import a.b.c.com.kosmo.login.dao.LoginDAO;
import a.b.c.com.kosmo.login.dao.LoginDAOImpl;
import a.b.c.com.kosmo.mem.vo.MemberVO;

public class LoginServiceImpl implements LoginService {

	@Override
	public int loginCheckCnt(MemberVO mvo) {
		// TODO Auto-generated method stub
		System.out.println("LoginServiceImpl loginCheckCnt() 함수 진입 >>> : ");		
		
		LoginDAO ldao = new LoginDAOImpl();
		return ldao.loginCheckCnt(mvo);

	}
}
