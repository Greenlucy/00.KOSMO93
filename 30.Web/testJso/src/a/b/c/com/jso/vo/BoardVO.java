package a.b.c.com.jso.vo;

public class BoardVO {

//	BoardVO property 이름은
//	클라이언트 사이드 스크립트의 form 태그 이름, 데이터베이스 테이블 컬럼명과 동일해야 함 (매핑이 되기 때문)
//		단, property는 소문자, 컬럼명은 대문자로 한다.
	private String bnum;
	private String bsubject;
	private String bwriter;
	private String bpw;
	private String bmemo;
	private String bphoto;
	private String deleteyn;
	private String insertdate;
	private String updatedate;
	
	// 생성자 : 매개변수 없는
	public BoardVO(){
		
	}
	
	// 생성자 : 매개변수 있는
	public BoardVO( String bnum, String bsubject, String bwriter, 
					String bpw, String bmemo, String bphoto,
					String deleteyn, String insertdate, String updatedate) {
		
		this.bnum = bnum;
		this.bsubject = bsubject;
		this.bwriter = bwriter;
		this.bpw = bpw;
		this.bmemo = bmemo;
		this.bphoto = bphoto;
		this.deleteyn = deleteyn;
		this.insertdate = insertdate;
		this.updatedate = updatedate;
	}


	// getter() setter() 함수
	public String getBnum() {
		return bnum;
	}

	public void setBnum(String bnum) {
		this.bnum = bnum;
	}

	public String getBsubject() {
		return bsubject;
	}

	public void setBsubject(String bsubject) {
		this.bsubject = bsubject;
	}

	public String getBwriter() {
		return bwriter;
	}

	public void setBwriter(String bwriter) {
		this.bwriter = bwriter;
	}

	public String getBpw() {
		return bpw;
	}

	public void setBpw(String bpw) {
		this.bpw = bpw;
	}

	public String getBmemo() {
		return bmemo;
	}

	public void setBmemo(String bmemo) {
		this.bmemo = bmemo;
	}

	public String getBphoto() {
		return bphoto;
	}

	public void setBphoto(String bphoto) {
		this.bphoto = bphoto;
	}

	public String getDeleteyn() {
		return deleteyn;
	}

	public void setDeleteyn(String deleteyn) {
		this.deleteyn = deleteyn;
	}

	public String getInsertdate() {
		return insertdate;
	}

	public void setInsertdate(String insertdate) {
		this.insertdate = insertdate;
	}

	public String getUpdatedate() {
		return updatedate;
	}

	public void setUpdatedate(String updatedate) {
		this.updatedate = updatedate;
	}
	
	// 프린트 함수
	public static void printBoardVO(BoardVO bvo){
		System.out.println(bvo.getBnum() + " : ");
		System.out.println(bvo.getBsubject() + " : ");
		System.out.println(bvo.getBwriter() + " : ");
		System.out.println(bvo.getBnum() + " : ");
	}
}
