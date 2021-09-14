package a.b.c.com.jso.service;

import java.util.ArrayList;

import a.b.c.com.jso.dao.BoardDAO;
import a.b.c.com.jso.dao.BoardDAOImpl;
import a.b.c.com.jso.vo.BoardVO;

public class BoardServiceImpl implements BoardService {

	@Override
	public ArrayList<BoardVO> boardSelectAll() {
		// TODO Auto-generated method stub
		// [56] 출력
		System.out.println("BoardServiceImpl boardSelectAll() 함수 진입 >>> : ");
		
		// [57]
		BoardDAO bdao = new BoardDAOImpl();
		return bdao.boardSelectAll();
	}

	@Override
	public ArrayList<BoardVO> boardSelect(BoardVO bvo) {
		// TODO Auto-generated method stub
		System.out.println("BoardServiceImpl boardSelect() 함수 진입 >>> : ");
		
		BoardDAO bdao = new BoardDAOImpl();
		return bdao.boardSelect(bvo);
	}

	@Override
	public boolean boardInsert(BoardVO bvo) {
		// TODO Auto-generated method stub
		// [12] 콘솔 출력
		System.out.println("BoardServiceImpl boardInsert() 진입 >>> : ");
		// [13] BoardDAOImpl 클래스 인스턴스
		BoardDAO bdao = new BoardDAOImpl();
		// [14] BoardDAO 클래스의 함수 boardInsert() 함수 호출하여 BoardDAOImpl 클래스에 오버라이딩 된 boardInsert() 함수에 아규먼트 입력해서 호출
		return bdao.boardInsert(bvo);
	}

	@Override
	public boolean boardDelete(BoardVO bvo) {
		// TODO Auto-generated method stub
		System.out.println("BoardServiceImpl boardDelete() 함수 진입  >>> : ");
		
		BoardDAO bdao = new BoardDAOImpl();
		return bdao.boardDelete(bvo);
	}

	@Override
	public boolean boardUpdate(BoardVO bvo) {
		// TODO Auto-generated method stub
		System.out.println("BoardServiceImpl boardUpdate() 함수 진입 >>> : ");
		
		BoardDAO bdao = new BoardDAOImpl();
		return bdao.boardUpdate(bvo);
	}

}
