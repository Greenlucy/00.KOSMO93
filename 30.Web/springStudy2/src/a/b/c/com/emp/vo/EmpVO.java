package a.b.c.com.emp.vo;

public class EmpVO {
	
	private String empno;
	private String ename;
	private String hiredate;
	
	// search ����
	private String keyword;			// �˻���
	private String searchFilter;	// �˻�����
	private String startDate;		// �˻��Ⱓ ������
	private String endDate;			// �˻��Ⱓ ������
		
	public EmpVO() {
		
	}
	public EmpVO(	String empno, String ename, String hiredate) {
		this.empno = empno;
		this.ename = ename;
		this.hiredate = hiredate;
	}

	public EmpVO(	String empno, String ename, 
					String hiredate, String keyword, 
					String searchFilter, String startDate,
					String endDate) {
		
		this.empno = empno;
		this.ename = ename;
		this.hiredate = hiredate;
		this.keyword = keyword;
		this.searchFilter = searchFilter;
		this.startDate = startDate;
		this.endDate = endDate;
	}

	public String getEmpno() {
		return empno;
	}

	public String getEname() {
		return ename;
	}

	public String getHiredate() {
		return hiredate;
	}

	public String getKeyword() {
		return keyword;
	}

	public String getSearchFilter() {
		return searchFilter;
	}

	public String getStartDate() {
		return startDate;
	}

	public String getEndDate() {
		return endDate;
	}

	public void setEmpno(String empno) {
		this.empno = empno;
	}

	public void setEname(String ename) {
		this.ename = ename;
	}

	public void setHiredate(String hiredate) {
		this.hiredate = hiredate;
	}

	public void setKeyword(String keyword) {
		this.keyword = keyword;
	}

	public void setSearchFilter(String searchFilter) {
		this.searchFilter = searchFilter;
	}

	public void setStartDate(String startDate) {
		this.startDate = startDate;
	}

	public void setEndDate(String endDate) {
		this.endDate = endDate;
	}	
}
