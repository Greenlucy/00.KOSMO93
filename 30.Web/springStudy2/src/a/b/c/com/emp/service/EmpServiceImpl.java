package a.b.c.com.emp.service;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import a.b.c.com.emp.dao.EmpDAO;
import a.b.c.com.emp.vo.EmpVO;

@Service
@Transactional
public class EmpServiceImpl implements EmpService {
	private Logger logger = Logger.getLogger(EmpServiceImpl.class);
	
	// 서비스에서 DAO 연결하기 
	private EmpDAO empDAO;
	
	// 생성자에 @Autowired 어노테이션으로  DI (의존성 주입하기)
	@Autowired(required=false)
	public EmpServiceImpl(EmpDAO empDAO){
		this.empDAO = empDAO;
	}
		
	@Override
	public List empSelectAll() {
		// TODO Auto-generated method stub
		logger.info("EmpServiceImpl empSelectAll 함수 진입 >>> : ");
		
		return empDAO.empSelectAll();
	}

	@Override
	public List empSelect(EmpVO evo) {
		// TODO Auto-generated method stub
		logger.info("EmpServiceImpl empSelect 함수 진입 >>> : ");
		
		return empDAO.empSelect(evo);
	}
}
