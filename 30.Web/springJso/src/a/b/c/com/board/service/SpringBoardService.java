package a.b.c.com.board.service;

import java.util.List;

import a.b.c.com.board.vo.SpringBoardVO;

public interface SpringBoardService {

	public List<SpringBoardVO> boardSelect(SpringBoardVO bvo);
	public List<SpringBoardVO> boardSelectAll(SpringBoardVO bvo);
	public int boardInsert(SpringBoardVO bvo);
	public int boardUpdate(SpringBoardVO bvo);
	public int boardDelete(SpringBoardVO bvo);
	
	// 비밀번호 체크
	public List<SpringBoardVO> boardIdCheck(SpringBoardVO bvo);
}
