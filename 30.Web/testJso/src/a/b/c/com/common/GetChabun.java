package a.b.c.com.common;

import a.b.c.com.jso.board.sql.BoardSqlMap;

public abstract class GetChabun {

	public static final String BIZ_GUBUN_M	= "M"; // 회원 : MEMBER
	public static final String BIZ_GUBUN_BD = "BD";	// 게시판 : BOARD
	public static final String BIZ_GUBUN_RB = "RB"; // 게시판 댓글 : REPLY BOARD
	public static final String BIZ_GUBUN_N	= "N";	// 공지사항 : NOTICE BOARD
	public static final String BIZ_GUBUN_BK = "BK";	// 책 : BOOK
	
	// type : d D : YYYYMMDD0001, m M : YYYYMM0001, y Y : YYYY0001, n N : 0001
	public static String numPad(String t, String c){
		for (int i=c.length(); i < 4; i++){
			c = "0" + c;
		}
		return DateFormatUtil.ymdFormats(t).concat(c);
	}
	
	// 회원 번호
	public static String getMemberChabun(String type){
		return BIZ_GUBUN_M.concat(numPad(type, GetMemberMaxNum.getMaxNum()));
	}
	
	// 게시판 글 번호
	public static String getBoardChabun(String type){
		return BIZ_GUBUN_BD.concat(numPad(type, GetBoardMaxNum.getMaxNum()));
	}
	
	// 게시판 댓글  글 번호
	
	// 공지사항 번호
	public static String getNoticeChabun(String type){
		return BIZ_GUBUN_N.concat(numPad(type, GetNoticeMaxNum.getMaxNum()));
	}
	
	// 책 번호
	public static String getBookChabun(String type){
		return BIZ_GUBUN_BK.concat(numPad(type, GetBookMaxNum.getMaxNum()));
	}
	
	// main()
	public static void main(String[] args){
//		System.out.println("getMemberChabun >>> : " + GetChabun.getMemberChabun("d"));
//		System.out.println("getBoardChabun >>> : " + GetChabun.getBoardChabun("n"));
//		System.out.println("getBookChabun >>> : " + GetChabun.getBookChabun("d"));
		System.out.println(GetChabun.getNoticeChabun("d"));
	}
}
