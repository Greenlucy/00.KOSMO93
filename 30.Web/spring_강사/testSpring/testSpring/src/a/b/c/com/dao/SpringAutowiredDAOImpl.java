package a.b.c.com.dao;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Repository;

import a.b.c.com.vo.FormDataVO;

@Repository
public class SpringAutowiredDAOImpl implements SpringAutowiredDAO {
	private Logger logger = Logger.getLogger(SpringAutowiredDAOImpl.class);
	
	@Override
	public List<FormDataVO> autowiredTest(FormDataVO fvo) {
		// TODO Auto-generated method stub
		logger.info("SpringAutowiredDAOImpl.autowiredTest_Get() 함수 진입");
		
		List<FormDataVO> list = new ArrayList<FormDataVO>();
		list.add(fvo);
		
		return list;
	}
}
