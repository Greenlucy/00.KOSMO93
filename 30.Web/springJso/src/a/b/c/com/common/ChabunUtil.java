package a.b.c.com.common;

public abstract class ChabunUtil {

	public static final String BIZ_GUBUN_M = "M";
	public static final String BIZ_GUBUN_B = "B";
	public static final String BIZ_GUBUN_RB = "RB";
	public static final String BIZ_GUBUN_N = "NB";
	
	// type : D : 20210001, M : YYYYMM, Y : YYYY, N : 
	public static String numPad(String t, String c) {
		
		for(int i=c.length(); i < 4; i++) {
			c = "0" + c;
		}
		String ymd = DateFormatUtil.ymdFormats(t);
		
		return ymd.concat(c);
	} // end of numPad() 함수
	
	// 회원
	
	// 게시판
	public static String getBoardChabun(String type, String memNum) {
		return BIZ_GUBUN_B.concat(ChabunUtil.numPad(type, memNum));
	}
	// R게시판
	
	// 공지글
	
	public static void main(String[] args) {
		
		String c = "1";
		System.out.println(">>> : " + ChabunUtil.getBoardChabun("N", c));
	}
}
