package a.b.c.com.jso.login.service;

import a.b.c.com.jso.login.dao.LoginDAO;
import a.b.c.com.jso.login.dao.LoginDAOImpl;
import a.b.c.com.jso.mem.vo.MemberVO;

public class LoginServiceImpl implements LoginService {

	@Override
	public int loginCheckCnt(MemberVO mvo) {
		// TODO Auto-generated method stub
		System.out.println("LoginServiceImpl loginCheckCnt() �Լ� ���� >>> : ");
		
		LoginDAO ldao = new LoginDAOImpl();
		return ldao.loginCheckCnt(mvo);
	}

}
