package a.b.c.com.jso.mem.service;

import java.util.ArrayList;

import a.b.c.com.jso.mem.dao.MemberDAO;
import a.b.c.com.jso.mem.dao.MemberDAOImpl;
import a.b.c.com.jso.mem.vo.MemberVO;

public class MemberServiceImpl implements MemberService {

	@Override
	public ArrayList<MemberVO> memberSelectAll() {
		// TODO Auto-generated method stub
		System.out.println("MemberServiceImpl memberSelectAll() 함수 진입 >>> : ");
		
		MemberDAO mdao = new MemberDAOImpl();
		return mdao.memberSelectAll();
	}

	@Override
	public ArrayList<MemberVO> memberSelect(MemberVO mvo) {
		// TODO Auto-generated method stub
		System.out.println("MemberServiceImpl memberSelect() 함수 진입 >>> : ");
		
		MemberDAO mdao = new MemberDAOImpl();
		return mdao.memberSelect(mvo);
	}

	@Override
	public boolean memberInsert(MemberVO mvo) {
		// TODO Auto-generated method stub
		System.out.println("MemberServiceImpl memberInsert() 함수 진입 >>> : ");
		
		MemberDAO mdao = new MemberDAOImpl();
		return mdao.memberInsert(mvo);
	}

	@Override
	public boolean memberUpdate(MemberVO mvo) {
		// TODO Auto-generated method stub
		System.out.println("MemberService memberUpdate() 함수 진입 >>> : ");
		
		MemberDAO ms = new MemberDAOImpl();
		return ms.memberUpdate(mvo);
	}

	@Override
	public boolean memberDelete(MemberVO mvo) {
		// TODO Auto-generated method stub
		System.out.println("MemberServiceImpl memberDelete() 함수 진입 >>> : ");
		
		MemberDAO mdao = new MemberDAOImpl();
		return mdao.memberDelete(mvo);
	}

}
