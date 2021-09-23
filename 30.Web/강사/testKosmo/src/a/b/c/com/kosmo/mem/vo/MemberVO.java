package a.b.c.com.kosmo.mem.vo;

public class MemberVO {

	private String mnum;
	private String mname;
	private String mid;
	private String mpw;
	private String mgender;
	private String mbirth;
	private String mhp;
	private String mtel;
	private String memail;
	private String mzonecode;
	private String mroadaddress;
	private String mjibunaddress;
	private String mhobby;				
	private String minfo;
	private String mphoto;		
	private String madmin;		
	private String deleteyn;
	private String insertdate;
	private String updatedate;
	
	// 생성자 
	public MemberVO(){}
	
	
	// 생성자 추가 
	public MemberVO(String mid, String mpw) {		
		this.mid = mid;
		this.mpw = mpw;
	}


	public MemberVO(String mnum, String mname, String mid, String mpw, String mgender, 
			    	String mbirth, String mhp,String mtel, String memail, String mzonecode, 
			    	String mroadaddress, String mjibunaddress, String mhobby, String minfo, String mphoto, 
			    	String madmin, String deleteyn, String insertdate, String updatedate) {
		this.mnum = mnum;
		this.mname = mname;
		this.mid = mid;
		this.mpw = mpw;
		this.mgender = mgender;
		this.mbirth = mbirth;
		this.mhp = mhp;
		this.mtel = mtel;
		this.memail = memail;
		this.mzonecode = mzonecode;
		this.mroadaddress = mroadaddress;
		this.mjibunaddress = mjibunaddress;
		this.mhobby = mhobby;
		this.minfo = minfo;
		this.mphoto = mphoto;
		this.madmin = madmin;
		this.deleteyn = deleteyn;
		this.insertdate = insertdate;
		this.updatedate = updatedate;
	}
	
	// getter()
	public String getMnum() {
		return mnum;
	}
	public String getMname() {
		return mname;
	}
	public String getMid() {
		return mid;
	}
	public String getMpw() {
		return mpw;
	}
	public String getMgender() {
		return mgender;
	}
	public String getMbirth() {
		return mbirth;
	}
	public String getMhp() {
		return mhp;
	}
	public String getMtel() {
		return mtel;
	}
	public String getMemail() {
		return memail;
	}
	public String getMzonecode() {
		return mzonecode;
	}
	public String getMroadaddress() {
		return mroadaddress;
	}
	public String getMjibunaddress() {
		return mjibunaddress;
	}
	public String getMhobby() {
		return mhobby;
	}
	public String getMinfo() {
		return minfo;
	}
	public String getMphoto() {
		return mphoto;
	}
	public String getMadmin() {
		return madmin;
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
	
	// getter()	
	public void setMnum(String mnum) {
		this.mnum = mnum;
	}
	public void setMname(String mname) {
		this.mname = mname;
	}
	public void setMid(String mid) {
		this.mid = mid;
	}
	public void setMpw(String mpw) {
		this.mpw = mpw;
	}
	public void setMgender(String mgender) {
		this.mgender = mgender;
	}
	public void setMbirth(String mbirth) {
		this.mbirth = mbirth;
	}
	public void setMhp(String mhp) {
		this.mhp = mhp;
	}
	public void setMtel(String mtel) {
		this.mtel = mtel;
	}
	public void setMemail(String memail) {
		this.memail = memail;
	}
	public void setMzonecode(String mzonecode) {
		this.mzonecode = mzonecode;
	}
	public void setMroadaddress(String mroadaddress) {
		this.mroadaddress = mroadaddress;
	}
	public void setMjibunaddress(String mjibunaddress) {
		this.mjibunaddress = mjibunaddress;
	}
	public void setMhobby(String mhobby) {
		this.mhobby = mhobby;
	}
	public void setMinfo(String minfo) {
		this.minfo = minfo;
	}
	public void setMphoto(String mphoto) {
		this.mphoto = mphoto;
	}
	public void setMadmin(String madmin) {
		this.madmin = madmin;
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
	
	// MemberVO 프린트 함수 
	public static void printMemberVO(MemberVO mvo) {
		
		System.out.print(mvo.getMnum() 			+ ", ");
		System.out.print(mvo.getMname() 		+ ", ");
		System.out.print(mvo.getMid()			+ ", ");
		System.out.print(mvo.getMpw() 			+ ", ");
		System.out.print(mvo.getMgender()  		+ ", ");
		System.out.print(mvo.getMbirth() 		+ ", ");	
		System.out.print(mvo.getMhp() 			+ ", ");
		System.out.print(mvo.getMtel()			+ ", ");			
		System.out.print(mvo.getMemail()		+ ", ");
		System.out.print(mvo.getMzonecode() 	+ ", ");
		System.out.print(mvo.getMroadaddress() 	+ ", ");
		System.out.print(mvo.getMjibunaddress() + ", ");
		System.out.print(mvo.getMhobby()    	+ ", ");
		System.out.print(mvo.getMinfo()			+ ", ");
		System.out.print(mvo.getMphoto() 		+ ", ");
		System.out.print(mvo.getMadmin()		+ ", ");			
		System.out.print(mvo.getDeleteyn() 		+ ", ");
		System.out.print(mvo.getInsertdate() 	+ ", ");
		System.out.println(mvo.getUpdatedate());
	}
	
	public static void printlnMemberVO(MemberVO mvo) {
		
		System.out.println("mvo.getMnum() 				>>> : " + mvo.getMnum());
		System.out.println("mvo.getMname() 				>>> : " + mvo.getMname());
		System.out.println("mvo.getMid() 				>>> : " + mvo.getMid());
		System.out.println("mvo.getMpw() 				>>> : " + mvo.getMpw());
		System.out.println("mvo.getMgender() 			>>> : " + mvo.getMgender());
		System.out.println("mvo.getMbirth() 			>>> : " + mvo.getMbirth());
		System.out.println("mvo.getMhp() 				>>> : " + mvo.getMhp());
		System.out.println("mvo.getMtel() 				>>> : " + mvo.getMtel());			
		System.out.println("mvo.getMemail() 			>>> : " + mvo.getMemail());
		System.out.println("mvo.getMzonecode() 			>>> : " + mvo.getMzonecode());
		System.out.println("mvo.getMroadaddress() 		>>> : " + mvo.getMroadaddress());
		System.out.println("mvo.getMjibunaddress() 		>>> : " + mvo.getMjibunaddress());
		System.out.println("mvo.getMhobby() 			>>> : " + mvo.getMhobby());
		System.out.println("mvo.getMinfo() 				>>> : " + mvo.getMinfo());
		System.out.println("mvo.getMphoto() 			>>> : " + mvo.getMphoto());
		System.out.println("mvo.getMadmin() 			>>> : " + mvo.getMadmin());			
		System.out.println("mvo.getDeleteyn() 			>>> : " + mvo.getDeleteyn());
		System.out.println("mvo.getInsertdate() 		>>> : " + mvo.getInsertdate());
		System.out.println("mvo.getUpdatedate() 		>>> : " + mvo.getUpdatedate());
	}	
}
