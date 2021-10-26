package a.b.c.com.board.dao;

import java.util.List;

import org.apache.log4j.Logger;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import a.b.c.com.board.vo.SpringBoardVO;

@Repository
public class SpringBoardDAOImpl implements SpringBoardDAO {
	Logger logger = Logger.getLogger(SpringBoardDAOImpl.class);
	
	// sqlSession과 연결
	@Autowired(required=false)
	private SqlSessionTemplate sqlSession;		// ?
	
	@Override
	public List<SpringBoardVO> boardSelect(SpringBoardVO bvo) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<SpringBoardVO> boardSelectAll(SpringBoardVO bvo) {
		// TODO Auto-generated method stub
		logger.info("SpringBoardDAOImpl boardSelectAll() 함수 진입 >>> : ");
		logger.info("bvo >>> : " + bvo);
		return sqlSession.selectList("boardSelectAll", bvo);
	}

	@Override
	public int boardInsert(SpringBoardVO bvo) {
		// TODO Auto-generated method stub
		logger.info("SpringBoardDAOImpl boardInsert() 함수 진입 >>> : ");
		logger.info("bvo >>> : " + bvo);
		return (Integer)sqlSession.insert("boardInsert", bvo);
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
