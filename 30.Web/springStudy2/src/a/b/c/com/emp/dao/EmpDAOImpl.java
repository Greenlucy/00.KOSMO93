package a.b.c.com.emp.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import a.b.c.com.emp.vo.EmpVO;

@Repository
public abstract class EmpDAOImpl  implements EmpDAO {
	private Logger logger = Logger.getLogger(EmpDAOImpl.class);
	
	@Autowired(required=false)
	private SqlSession sqlSession;
	
	@Override
	public List empSelectAll() {
		// TODO Auto-generated method stub
		logger.info("EmpDAOImpl empSelectAll 함수 진입 >>> : ");		
		
		return sqlSession.selectList("empSelectAll");
	}
	
	@Override
	public List empSelect(EmpVO evo) {
		// TODO Auto-generated method stub
		logger.info("EmpDAOImpl empSelect 함수 진입 >>> : ");
		
		return sqlSession.selectList("empSelect", evo);
	}
}
