package a.b.c.com.kosmo.board.service;

import java.util.ArrayList;

import a.b.c.com.kosmo.board.dao.BoardDAO;
import a.b.c.com.kosmo.board.dao.BoardDAOImpl;
import a.b.c.com.kosmo.board.vo.BoardVO;

public class BoardServiceImpl implements BoardService {

	@Override
	public ArrayList<BoardVO> boardSelectAll() {
		// TODO Auto-generated method stub
		System.out.println("BoardServiceImpl boardSelectAll() �Լ� ���� >>> : ");
		
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
		System.out.println("BoardServiceImpl boardInsert() �Լ� ���� >>> : ");
		
		BoardDAO bdao = new BoardDAOImpl();
		return bdao.boardInsert(bvo);
	}

	@Override
	public boolean boardUpdate(BoardVO bvo) {
		// TODO Auto-generated method stub
		System.out.println("BoardServiceImpl boardUpdate() �Լ� ���� >>> : ");
		
		BoardDAO bdao = new BoardDAOImpl();
		return bdao.boardUpdate(bvo);
	}

	@Override
	public boolean boardDelete(BoardVO bvo) {
		// TODO Auto-generated method stub
		System.out.println("BoardServiceImpl boardDelete() �Լ� ���� >>> : ");
		
		BoardDAO bdao = new BoardDAOImpl();
		return bdao.boardDelete(bvo);
	}
}
