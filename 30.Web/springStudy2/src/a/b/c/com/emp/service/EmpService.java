package a.b.c.com.emp.service;

import java.util.List;

import a.b.c.com.emp.vo.EmpVO;

public interface EmpService {

	public List empSelectAll();
	public List empSelect(EmpVO evo);
}
