package a.b.c.com.jso.service;

import java.util.ArrayList;

import a.b.c.com.jso.dao.BoardDAO;
import a.b.c.com.jso.dao.BoardDAOImpl;
import a.b.c.com.jso.vo.BoardVO;

public class BoardServiceImpl implements BoardService {

	@Override
	public ArrayList<BoardVO> boardSelectAll() {
		// TODO Auto-generated method stub
		// [56] ���
		System.out.println("BoardServiceImpl boardSelectAll() �Լ� ���� >>> : ");
		
		// [57]
		BoardDAO bdao = new BoardDAOImpl();
		return bdao.boardSelectAll();
	}

	@Override
	public ArrayList<BoardVO> boardSelect(BoardVO bvo) {
		// TODO Auto-generated method stub
		System.out.println("BoardServiceImpl boardSelect() �Լ� ���� >>> : ");
		
		BoardDAO bdao = new BoardDAOImpl();
		return bdao.boardSelect(bvo);
	}

	@Override
	public boolean boardInsert(BoardVO bvo) {
		// TODO Auto-generated method stub
		// [12] �ܼ� ���
		System.out.println("BoardServiceImpl boardInsert() ���� >>> : ");
		// [13] BoardDAOImpl Ŭ���� �ν��Ͻ�
		BoardDAO bdao = new BoardDAOImpl();
		// [14] BoardDAO Ŭ������ �Լ� boardInsert() �Լ� ȣ���Ͽ� BoardDAOImpl Ŭ������ �������̵� �� boardInsert() �Լ��� �ƱԸ�Ʈ �Է��ؼ� ȣ��
		return bdao.boardInsert(bvo);
	}

	@Override
	public boolean boardDelete(BoardVO bvo) {
		// TODO Auto-generated method stub
		System.out.println("BoardServiceImpl boardDelete() �Լ� ����  >>> : ");
		
		BoardDAO bdao = new BoardDAOImpl();
		return bdao.boardDelete(bvo);
	}

	@Override
	public boolean boardUpdate(BoardVO bvo) {
		// TODO Auto-generated method stub
		System.out.println("BoardServiceImpl boardUpdate() �Լ� ���� >>> : ");
		
		BoardDAO bdao = new BoardDAOImpl();
		return bdao.boardUpdate(bvo);
	}

}
