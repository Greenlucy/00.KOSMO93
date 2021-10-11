package a.b.c.com.emp.dao;

import java.util.List;

import a.b.c.com.emp.vo.EmpVO;

public interface EmpDAO {

	public List empSelectAll();
	public List empSelect(EmpVO evo);
}
