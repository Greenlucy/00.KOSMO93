package a.b.c.com.board.service;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import a.b.c.com.board.dao.SpringBoardDAO;
import a.b.c.com.board.vo.SpringBoardVO;

@Service
@Transactional
public class SpringBoardServiceImpl implements SpringBoardService {
	private Logger logger = Logger.getLogger(SpringBoardServiceImpl.class);
	
	// dao랑 연결
	private SpringBoardDAO springBoardDAO;
	
	// 생성자 Autowired
	@Autowired(required=false)
	public SpringBoardServiceImpl(SpringBoardDAO springBoardDAO) {
		this.springBoardDAO = springBoardDAO;
	}
	
	@Override
	public List<SpringBoardVO> boardSelect(SpringBoardVO bvo) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<SpringBoardVO> boardSelectAll(SpringBoardVO bvo) {
		// TODO Auto-generated method stub
		logger.info("SpringServiceImpl boardSelectAll() 함수 진입 >>> : ");
		logger.info("bvo >>> : " + bvo);
		return springBoardDAO.boardSelectAll(bvo);
	}

	@Override
	public int boardInsert(SpringBoardVO bvo) {
		// TODO Auto-generated method stub
		logger.info("SpringBoardServiceImpl boardInsert() 함수 진입 >>> : ");
		logger.info("bvo >>> : " + bvo);
		return springBoardDAO.boardInsert(bvo);
	}

	@Override
	public int boardUpdate(SpringBoardVO bvo) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int boardDelete(SpringBoardVO bvo) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public List<SpringBoardVO> boardIdCheck(SpringBoardVO bvo) {
		// TODO Auto-generated method stub
		return null;
	}

}
