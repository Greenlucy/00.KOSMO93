package a.b.c.com.jso.board.service;

import java.util.ArrayList;

import a.b.c.com.jso.board.vo.BoardVO;

public interface BoardService {
	
	// [55]
	public ArrayList<BoardVO> boardSelectAll();
	public ArrayList<BoardVO> boardSelect(BoardVO bvo);	
	// [11]
	public boolean boardInsert(BoardVO bvo);
	public boolean boardDelete(BoardVO bvo);
	public boolean boardUpdate(BoardVO bvo);
	
}
