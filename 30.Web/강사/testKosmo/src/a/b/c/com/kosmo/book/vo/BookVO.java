package a.b.c.com.kosmo.book.vo;

public class BookVO {

	private String bnum;
	private String btitle;
	private String bauth;
	private String isbn;
	private String bcomp;
	private String bprice;
	private String bqty;
	private String bcover;
	private String deleteyn;
	private String insertdate;
	private String updatedate;
	
	// 생성자 
	public BookVO(){
		
	}
	
	public BookVO(	String bnum, String btitle, String bauth, 
			     	String isbn, String bcomp, String bprice, 
			     	String bqty, String bcover, String deleteyn, 
			     	String insertdate, String updatedate) {
		this.bnum = bnum;
		this.btitle = btitle;
		this.bauth = bauth;
		this.isbn = isbn;
		this.bcomp = bcomp;
		this.bprice = bprice;
		this.bqty = bqty;
		this.bcover = bcover;
		this.deleteyn = deleteyn;
		this.insertdate = insertdate;
		this.updatedate = updatedate;
	}
	// getter()
	public String getBnum() {
		return bnum;
	}
	public String getBtitle() {
		return btitle;
	}
	public String getBauth() {
		return bauth;
	}
	public String getIsbn() {
		return isbn;
	}
	public String getBcomp() {
		return bcomp;
	}
	public String getBprice() {
		return bprice;
	}
	public String getBqty() {
		return bqty;
	}
	public String getBcover() {
		return bcover;
	}
	public String getDeleteyn() {
		return deleteyn;
	}
	public String getInsertdate() {
		return insertdate;
	}
	public String getUpdatedate() {
		return updatedate;
	}
	
	// setter()
	public void setBnum(String bnum) {
		this.bnum = bnum;
	}
	public void setBtitle(String btitle) {
		this.btitle = btitle;
	}
	public void setBauth(String bauth) {
		this.bauth = bauth;
	}
	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}
	public void setBcomp(String bcomp) {
		this.bcomp = bcomp;
	}
	public void setBprice(String bprice) {
		this.bprice = bprice;
	}
	public void setBqty(String bqty) {
		this.bqty = bqty;
	}
	public void setBcover(String bcover) {
		this.bcover = bcover;
	}
	public void setDeleteyn(String deleteyn) {
		this.deleteyn = deleteyn;
	}
	public void setInsertdate(String insertdate) {
		this.insertdate = insertdate;
	}
	public void setUpdatedate(String updatedate) {
		this.updatedate = updatedate;
	}	
	
	// 프린트
	public static void printBookVO (BookVO bvo){
		System.out.print(bvo.getBnum() + " : ");
		System.out.print(bvo.getBtitle() + " : ");
		System.out.print(bvo.getBauth() + " : ");
		System.out.print(bvo.getIsbn() + " : ");
		System.out.print(bvo.getBcomp() + " : ");
		System.out.print(bvo.getBprice() + " : ");;
		System.out.print(bvo.getBqty() + " : ");;
		System.out.print(bvo.getBcover() + " : ");
		System.out.print(bvo.getDeleteyn() + " : ");
		System.out.print(bvo.getInsertdate() + " : ");
		System.out.println(bvo.getUpdatedate());
	}
	
	public static void printlnBookVO (BookVO bvo){
		System.out.println("bvo.getBnum()			>>> : " + bvo.getBnum());
		System.out.println("bvo.getBtitle()			>>> : " + bvo.getBtitle());
		System.out.println("bvo.getBauth() 			>>> : " + bvo.getBauth());
		System.out.println("bvo.getIsbn()			>>> : " + bvo.getIsbn());
		System.out.println("bvo.getBcomp()			>>> : " + bvo.getBcomp());
		System.out.println("bvo.getBprice()			>>> : " + bvo.getBprice());
		System.out.println("bvo.getBqty()			>>> : " + bvo.getBqty());
		System.out.println("bvo.getBcover()			>>> : " + bvo.getBcover());
		System.out.println("bvo.getDeleteyn()		>>> : " + bvo.getDeleteyn());
		System.out.println("bvo.getInsertdate()		>>> : " + bvo.getInsertdate());
		System.out.println("bvo.getUpdatedate()		>>> : " + bvo.getUpdatedate());
	}	
}
