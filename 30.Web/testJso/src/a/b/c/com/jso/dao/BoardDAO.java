package a.b.c.com.jso.dao;

import java.util.ArrayList;

import a.b.c.com.jso.vo.BoardVO;

public interface BoardDAO {
	
	// [58]
	public ArrayList<BoardVO> boardSelectAll();
	public ArrayList<BoardVO> boardSelect(BoardVO bvo);
	// [15]
	public boolean boardInsert(BoardVO bvo);
	public boolean boardDelete(BoardVO bvo);
	public boolean boardUpdate(BoardVO bvo);
}
