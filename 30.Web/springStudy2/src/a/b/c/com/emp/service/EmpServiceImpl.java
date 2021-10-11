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
	
	// ���񽺿��� DAO �����ϱ� 
	private EmpDAO empDAO;
	
	// �����ڿ� @Autowired ������̼�����  DI (������ �����ϱ�)
	@Autowired(required=false)
	public EmpServiceImpl(EmpDAO empDAO){
		this.empDAO = empDAO;
	}
		
	@Override
	public List empSelectAll() {
		// TODO Auto-generated method stub
		logger.info("EmpServiceImpl empSelectAll �Լ� ���� >>> : ");
		
		return empDAO.empSelectAll();
	}

	@Override
	public List empSelect(EmpVO evo) {
		// TODO Auto-generated method stub
		logger.info("EmpServiceImpl empSelect �Լ� ���� >>> : ");
		
		return empDAO.empSelect(evo);
	}
}
