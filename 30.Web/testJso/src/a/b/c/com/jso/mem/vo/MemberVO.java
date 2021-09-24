package a.b.c.com.jso.mem.vo;

public class MemberVO {
	String mnum;	// 1
	String mname;	// 2
	String mid;		// 3
	String mpw;		// 4
	String mgender;	// 5
	String mbirth;	// 6
	String mhp;		// 7
	String mtel;	// 8
	String memail;	// 9
	String mzonecode;		// 10
	String mroadaddress;	// 11
	String mgibunaddress;	// 12
	String mhobby;		// 13
	String minfo;		// 14
	String mphoto;		// 15
	String madmin;		// 16
	String deleteyn;	// 17
	String insertdate;	// 18
	String updatedate;	// 19

	// 생성자 : 매개변수 없는
	public MemberVO() {
		
	}

	// 생성자 : 매개변수 있는
	public MemberVO(String mnum, String mname, String mid, String mpw, String mgender, 
					String mbirth, String mhp, String mtel, String memail, String mzonecode, 
					String mroadaddress, String mgibunaddress, String mhobby, String minfo, String mphoto,
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
		this.mgibunaddress = mgibunaddress;
		this.mhobby = mhobby;
		this.minfo = minfo;
		this.mphoto = mphoto;
		this.madmin = madmin;
		this.deleteyn = deleteyn;
		this.insertdate = insertdate;
		this.updatedate = updatedate;
	}

	// setter() getter() 함수
	public String getMnum() {
		return mnum;
	}

	public void setMnum(String mnum) {
		this.mnum = mnum;
	}

	public String getMname() {
		return mname;
	}

	public void setMname(String mname) {
		this.mname = mname;
	}

	public String getMid() {
		return mid;
	}

	public void setMid(String mid) {
		this.mid = mid;
	}

	public String getMpw() {
		return mpw;
	}

	public void setMpw(String mpw) {
		this.mpw = mpw;
	}

	public String getMgender() {
		return mgender;
	}

	public void setMgender(String mgender) {
		this.mgender = mgender;
	}

	public String getMbirth() {
		return mbirth;
	}

	public void setMbirth(String mbirth) {
		this.mbirth = mbirth;
	}

	public String getMhp() {
		return mhp;
	}

	public void setMhp(String mhp) {
		this.mhp = mhp;
	}

	public String getMtel() {
		return mtel;
	}

	public void setMtel(String mtel) {
		this.mtel = mtel;
	}

	public String getMemail() {
		return memail;
	}

	public void setMemail(String memail) {
		this.memail = memail;
	}

	public String getMzonecode() {
		return mzonecode;
	}

	public void setMzonecode(String mzonecode) {
		this.mzonecode = mzonecode;
	}

	public String getMroadaddress() {
		return mroadaddress;
	}

	public void setMroadaddress(String mroadaddress) {
		this.mroadaddress = mroadaddress;
	}

	public String getMgibunaddress() {
		return mgibunaddress;
	}

	public void setMgibunaddress(String mgibunaddress) {
		this.mgibunaddress = mgibunaddress;
	}

	public String getMhobby() {
		return mhobby;
	}

	public void setMhobby(String mhobby) {
		this.mhobby = mhobby;
	}

	public String getMinfo() {
		return minfo;
	}

	public void setMinfo(String minfo) {
		this.minfo = minfo;
	}

	public String getMphoto() {
		return mphoto;
	}

	public void setMphoto(String mphoto) {
		this.mphoto = mphoto;
	}

	public String getMadmin() {
		return madmin;
	}

	public void setMadmin(String madmin) {
		this.madmin = madmin;
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
	public static void printMemberVO(MemberVO mvo){
		
		System.out.print(mvo.getMnum() 			+ " : ");	// 1
		System.out.print(mvo.getMname() 		+ " : ");	// 2
		System.out.print(mvo.getMid() 			+ " : ");	// 3
		System.out.print(mvo.getMpw() 			+ " : ");	// 4
		System.out.print(mvo.getMgender() 		+ " : ");	// 5
		System.out.print(mvo.getMbirth() 		+ " : ");	// 6
		System.out.print(mvo.getMhp() 			+ " : ");	// 7
		System.out.print(mvo.getMtel() 			+ " : ");	// 8
		System.out.print(mvo.getMemail() 		+ " : ");	// 9
		System.out.print(mvo.getMzonecode() 	+ " : ");	// 10
		System.out.print(mvo.getMroadaddress() 	+ " : ");	// 11
		System.out.print(mvo.getMgibunaddress() + " : ");	// 12
		System.out.print(mvo.getMhobby() 		+ " : ");	// 13
		System.out.print(mvo.getMinfo() 		+ " : ");	// 14
		System.out.print(mvo.getMphoto() 		+ " : ");	// 15
		System.out.print(mvo.getMadmin() 		+ " : ");	// 16
		System.out.print(mvo.getDeleteyn() 		+ " : ");	// 17
		System.out.print(mvo.getInsertdate() 	+ " : ");	// 18
		System.out.println(mvo.getUpdatedate());	// 19
	}
	
	public static void printlnMemberVO(MemberVO mvo){
		System.out.println("printlnMemberVO mvo >>> : " + mvo);
		System.out.println(mvo.getMnum() 			+ " : ");	// 1
		System.out.println(mvo.getMname() 			+ " : ");	// 2
		System.out.println(mvo.getMid() 			+ " : ");	// 3
		System.out.println(mvo.getMpw() 			+ " : ");	// 4
		System.out.println(mvo.getMgender() 		+ " : ");	// 5
		System.out.println(mvo.getMbirth() 			+ " : ");	// 6
		System.out.println(mvo.getMhp() 			+ " : ");	// 7
		System.out.println(mvo.getMtel() 			+ " : ");	// 8
		System.out.println(mvo.getMemail() 			+ " : ");	// 9
		System.out.println(mvo.getMzonecode() 		+ " : ");	// 10
		System.out.println(mvo.getMroadaddress() 	+ " : ");	// 11
		System.out.println(mvo.getMgibunaddress()	+ " : ");	// 12
		System.out.println(mvo.getMhobby() 			+ " : ");	// 13
		System.out.println(mvo.getMinfo() 			+ " : ");	// 14
		System.out.println(mvo.getMphoto() 			+ " : ");	// 15
		System.out.println(mvo.getMadmin() 			+ " : ");	// 16
		System.out.println(mvo.getDeleteyn() 		+ " : ");	// 17
		System.out.println(mvo.getInsertdate() 		+ " : ");	// 18
		System.out.println(mvo.getUpdatedate());	// 19
	}
}
