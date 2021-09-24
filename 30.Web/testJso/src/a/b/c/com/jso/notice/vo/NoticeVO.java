package a.b.c.com.jso.notice.vo;

public class NoticeVO {
	
	private String nnum;
	private String nsubject;
	private String nmemo;
	private String nphoto;
	private String deleteyn;
	private String insertdate;
	private String updatedate;
	
	public NoticeVO () {
		
	}

	public NoticeVO(String nnum, String nsubject, String nmemo, String nphoto, 
					String deleteyn, String insertdate,	String updatedate) {
		
		this.nnum = nnum;
		this.nsubject = nsubject;
		this.nmemo = nmemo;
		this.nphoto = nphoto;
		this.deleteyn = deleteyn;
		this.insertdate = insertdate;
		this.updatedate = updatedate;
	}

	// setter, getter 함수
	public String getNnum() {
		return nnum;
	}

	public void setNnum(String nnum) {
		this.nnum = nnum;
	}

	public String getNsubject() {
		return nsubject;
	}

	public void setNsubject(String nsubject) {
		this.nsubject = nsubject;
	}

	public String getNmemo() {
		return nmemo;
	}

	public void setNmemo(String nmemo) {
		this.nmemo = nmemo;
	}

	public String getNphoto() {
		return nphoto;
	}

	public void setNphoto(String nphoto) {
		this.nphoto = nphoto;
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
	public static void printNoticeVO(NoticeVO nvo) {
		System.out.println("NoticeVO : printNoticeVO() 함수 진입  >>> : " + nvo);
		System.out.print(nvo.getNnum() + " : ");
		System.out.print(nvo.getNsubject() + " : ");
		System.out.print(nvo.getNmemo() + " : ");
		System.out.print(nvo.getNphoto() + " : ");
		System.out.print(nvo.getDeleteyn() + " : ");
		System.out.print(nvo.getInsertdate() + " : ");
		System.out.println(nvo.getUpdatedate());
	}
	
	public static void printlnNoticeVO(NoticeVO nvo) {
		System.out.println("NoticeVO : printNoticeVO() 함수 진입 >>> : " + nvo);
		System.out.println("nnum >>> : " + nvo.getNnum());
		System.out.println("nsubject >>> : " + nvo.getNsubject());
		System.out.println("nmemo >>> : " + nvo.getNmemo());
		System.out.println("nphoto >>> : " + nvo.getNphoto());
		System.out.println("deleteyn >>> : " + nvo.getDeleteyn());
		System.out.println("insertdate >>> : " + nvo.getInsertdate());
		System.out.println("updatedate >>> : " + nvo.getUpdatedate());
	}
}
