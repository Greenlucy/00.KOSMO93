package a.b.c.com.service;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import a.b.c.com.dao.SpringAutowiredDAO;
import a.b.c.com.vo.FormDataVO;

@Service
@Transactional
public class SpringAutowiredServiceImpl implements SpringAutowiredService {
	private Logger logger = Logger.getLogger(SpringAutowiredServiceImpl.class);

	final private SpringAutowiredDAO springAutowiredDAO;	
	// SpringAutowiredDAO springAutowiredDAO = new SpringAutowiredServiceImpl();
	
	@Autowired(required=false)
	public SpringAutowiredServiceImpl(SpringAutowiredDAO springAutowiredDAO) {
		this.springAutowiredDAO = springAutowiredDAO;
	}
	
	@Override
	public List<FormDataVO> autowiredTest(FormDataVO fvo) {
		// TODO Auto-generated method stub
		logger.info("SpringAutowiredServiceImpl.autowiredTest_Get() 함수 진입");
		
		List<FormDataVO> list = springAutowiredDAO.autowiredTest(fvo);
		return list;
	}
}
