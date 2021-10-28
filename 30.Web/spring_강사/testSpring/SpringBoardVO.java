package a.b.c.com.board.vo;

import org.apache.log4j.Logger;

import a.b.c.com.mem.vo.SpringMemberVO;

public class SpringBoardVO {
	private static Logger logger = Logger.getLogger(SpringBoardVO.class);
	
	private String sbnum; 
	private String sbsubject;
	private String sbname;
	private String sbcontent;
	private String sbfile;
	private String sbpw;
	private String sbdelyn;	
	private String sbinsertdate;
	private String sbupdatedate;
	
	// 검색 구분자 및 검색어 
	private String keyfilter;
	private String keyword;
	private String startdate;
	private String enddate;
	
	// 페이징 이동 필드
	private String pageSize;
	private String groupSize;
	private String curPage;
	private String totalCount;
	
	public SpringBoardVO() {
		
	}
	
	public SpringBoardVO(	String sbnum, String sbsubject, String sbname, 
							String sbcontent, String sbfile, String sbpw,
							String sbdelyn, String sbinsertdate, String sbupdatedate) {
		
		this.sbnum = sbnum;
		this.sbsubject = sbsubject;
		this.sbname = sbname;
		this.sbcontent = sbcontent;
		this.sbfile = sbfile;
		this.sbpw = sbpw;
		this.sbdelyn = sbdelyn;
		this.sbinsertdate = sbinsertdate;
		this.sbupdatedate = sbupdatedate;
	}
	
	public SpringBoardVO(	String sbnum, String sbsubject, String sbname, 
							String sbcontent, String sbfile, String sbpw,
							String sbdelyn, String sbinsertdate, String sbupdatedate, 
							String keyfilter, String keyword, String startdate, 
							String enddate) {
		super();
		this.sbnum = sbnum;
		this.sbsubject = sbsubject;
		this.sbname = sbname;
		this.sbcontent = sbcontent;
		this.sbfile = sbfile;
		this.sbpw = sbpw;
		this.sbdelyn = sbdelyn;
		this.sbinsertdate = sbinsertdate;
		this.sbupdatedate = sbupdatedate;
		this.keyfilter = keyfilter;
		this.keyword = keyword;
		this.startdate = startdate;
		this.enddate = enddate;
	}

	public SpringBoardVO(	String sbnum, String sbsubject, String sbname, 
							String sbcontent, String sbfile, String sbpw,
							String sbdelyn, String sbinsertdate, String sbupdatedate, 
							String keyfilter, String keyword, String startdate, 
							String enddate, String pageSize, String groupSize, 
							String curPage, String totalCount) {
		
		this.sbnum = sbnum;
		this.sbsubject = sbsubject;
		this.sbname = sbname;
		this.sbcontent = sbcontent;
		this.sbfile = sbfile;
		this.sbpw = sbpw;
		this.sbdelyn = sbdelyn;
		this.sbinsertdate = sbinsertdate;
		this.sbupdatedate = sbupdatedate;
		this.keyfilter = keyfilter;
		this.keyword = keyword;
		this.startdate = startdate;
		this.enddate = enddate;
		this.pageSize = pageSize;
		this.groupSize = groupSize;
		this.curPage = curPage;
		this.totalCount = totalCount;
	}

	public String getSbnum() {
		return sbnum;
	}
	public void setSbnum(String sbnum) {
		this.sbnum = sbnum;
	}
	public String getSbsubject() {
		return sbsubject;
	}
	public void setSbsubject(String sbsubject) {
		this.sbsubject = sbsubject;
	}
	public String getSbname() {
		return sbname;
	}
	public void setSbname(String sbname) {
		this.sbname = sbname;
	}
	public String getSbfile() {
		return sbfile;
	}
	public void setSbfile(String sbfile) {
		this.sbfile = sbfile;
	}
	public String getSbpw() {
		return sbpw;
	}
	public void setSbpw(String sbpw) {
		this.sbpw = sbpw;
	}
	public String getSbdelyn() {
		return sbdelyn;
	}
	public void setSbdelyn(String sbdelyn) {
		this.sbdelyn = sbdelyn;
	}
	public String getSbinsertdate() {
		return sbinsertdate;
	}
	public void setSbinsertdate(String sbinsertdate) {
		this.sbinsertdate = sbinsertdate;
	}
	public String getSbupdatedate() {
		return sbupdatedate;
	}
	public void setSbupdatedate(String sbupdatedate) {
		this.sbupdatedate = sbupdatedate;
	}
	public String getStartdate() {
		return startdate;
	}
	public void setStartdate(String startdate) {
		this.startdate = startdate;
	}
	
	// 검색
	public String getSbcontent() {
		return sbcontent;
	}
	public void setSbcontent(String sbcontent) {
		this.sbcontent = sbcontent;
	}
	public String getKeyfilter() {
		return keyfilter;
	}
	public void setKeyfilter(String keyfilter) {
		this.keyfilter = keyfilter;
	}
	public String getKeyword() {
		return keyword;
	}
	public void setKeyword(String keyword) {
		this.keyword = keyword;
	}
	public String getEnddate() {
		return enddate;
	}
	public void setEnddate(String enddate) {
		this.enddate = enddate;
	}

	// 페이징 
	public String getPageSize() {
		return pageSize;
	}

	public void setPageSize(String pageSize) {
		this.pageSize = pageSize;
	}

	public String getGroupSize() {
		return groupSize;
	}

	public void setGroupSize(String groupSize) {
		this.groupSize = groupSize;
	}

	public String getCurPage() {
		return curPage;
	}

	public void setCurPage(String curPage) {
		this.curPage = curPage;
	}

	public String getTotalCount() {
		return totalCount;
	}

	public void setTotalCount(String totalCount) {
		this.totalCount = totalCount;
	}

	// 매개변수 확인
	public static void printVO(SpringBoardVO bvo){
		logger.info("SpringBoardVO 데이터 확인 시작  >>> : ");
		
		logger.info("글번호 >>> : " + bvo.getSbnum());
		logger.info("글제목 >>> : " + bvo.getSbsubject());
		logger.info("작성자 >>> : " + bvo.getSbname());
		logger.info("글내용 >>> : " + bvo.getSbcontent());
		logger.info("첨부파일명 >>> : " + bvo.getSbfile());
		logger.info("패스워드 >>> : " + bvo.getSbpw());
		logger.info("삭제여부 >>> : " + bvo.getSbdelyn());
		logger.info("입력일 >>> : " + bvo.getSbinsertdate());
		logger.info("수정일 >>> : " + bvo.getSbupdatedate());
		logger.info("페이징 데이터 확인 >>>");
		logger.info("페이지 >>> : " + bvo.getPageSize());
		logger.info("그룹사이즈 >>> : " + bvo.getGroupSize());
		logger.info("현재페이지 >>> : " + bvo.getCurPage());
		logger.info("전체건수 >>> : " + bvo.getTotalCount());
		logger.info("조건검색 데이터 확인 >>>");
		logger.info("검색 필터 >>> : " + bvo.getKeyfilter());
		logger.info("검색 키워드 >>> : " + bvo.getKeyword());
		logger.info("검색 시작일 >>> : " + bvo.getStartdate());
		logger.info("검색 종료일 : " + bvo.getEnddate());
		
		logger.info("SpringBoardVO 데이터 확인 끝  >>> : ");
	}
}
