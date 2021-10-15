package a.b.c.com.service;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import a.b.c.com.dao.SpringAutowiredFiledDAO;
import a.b.c.com.vo.FormDataVO;

@Service
@Transactional
public class SpringAutowiredFieldServiceImpl implements SpringAutowiredFieldService {
	private Logger logger = Logger.getLogger(SpringAutowiredFieldServiceImpl.class);
	
	@Autowired
	private SpringAutowiredFiledDAO springAutowiredFiledDAO;
	
	
	@Override
	public List<FormDataVO> autowiredTest(FormDataVO fvo) {
		// TODO Auto-generated method stub
		logger.info("SpringAutowiredFieldServiceImpl.autowiredTest_Get() 함수 진입");
		
		List<FormDataVO> list = springAutowiredFiledDAO.autowiredTest(fvo);
		return list;
	}

}
