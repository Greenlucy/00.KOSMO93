package a.b.c.com.common.service;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import a.b.c.com.board.vo.SpringBoardVO;
import a.b.c.com.common.dao.ChabunDAO;

@Service
@Transactional
public class ChabunServiceImpl implements ChabunService {
	private Logger logger = Logger.getLogger(ChabunServiceImpl.class);

	// 채번 DAO와 연결
	private ChabunDAO chabunDAO;
	
	// 생성자 Autowired
	@Autowired(required=false)
	public ChabunServiceImpl(ChabunDAO chabunDAO) {
		this.chabunDAO = chabunDAO;
	}
	
	@Override
	public SpringBoardVO getBoardChabun() {
		// TODO Auto-generated method stub
		logger.info("ChabunServiceImpl getBoardChabun() 함수 진입 >>> : ");
		return chabunDAO.getBoardChabun();
	}

}
