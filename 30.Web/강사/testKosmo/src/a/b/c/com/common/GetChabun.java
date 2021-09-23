package a.b.c.com.common;

public abstract class GetChabun {
	
	public static final String BIZ_GUBUN_M 	= "M"; // 회원 : MEMBER
	public static final String BIZ_GUBUN_BD = "BD"; // 게시판 : BOARD
	public static final String BIZ_GUBUN_RB = "RB"; // 게시판 댓글: REPLY BOARD
	public static final String BIZ_GUBUN_N 	= "NB"; // 공지사항 : NOTICE BOARD
	public static final String BIZ_GUBUN_BK = "BK"; // 책 : BOOK
	
	// type : d D : YYYYMMDD0001, m M : YYYYMM0001, y Y : YYYY0001, n N : 0001 
	public static String numPad(String t, String c){
	
		for (int i=c.length(); i < 4; i++) {
			c = "0" + c;
		}				
		return DateFormatUtil.ymdFormats(t).concat(c);
	}	
	
	// 회원 번호 
	public static String getMemberChabun(String type) {		
		
		return BIZ_GUBUN_M.concat(numPad(type, GetMemberMaxNum.getMaxNum()));
	}
	
	// 게시판 글 번호  
	public static String getBoardChabun(String type) {
		
		return BIZ_GUBUN_BD.concat(numPad(type, GetBoardMaxNum.getMaxNum()));
	}
	
	// 게시판 댓글 글 번호  
	public static String getRboardChabun(String type) {	
		
		return BIZ_GUBUN_M.concat(numPad(type, ""));
	}
	
	// 공지사항  번호  
	public static String getNoticeChabun(String type) {
		
		return BIZ_GUBUN_M.concat(numPad(type, ""));
	}
	
	// 책  번호  
	public static String getBookChabun(String type) {
		
		return BIZ_GUBUN_BK.concat(numPad(type, GetBookMaxNum.getMaxNum()));
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		System.out.println("GetChabun >>> : " + GetChabun.getMemberChabun("d"));
		System.out.println("GetChabun >>> : " + GetChabun.getBoardChabun("N"));
		System.out.println("GetChabun >>> : " + GetChabun.getRboardChabun("N"));
		System.out.println("GetChabun >>> : " + GetChabun.getNoticeChabun("N"));
		System.out.println("GetChabun >>> : " + GetChabun.getBookChabun("d"));	
	}
}
