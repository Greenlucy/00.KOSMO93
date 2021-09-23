package a.b.c.com.common;

public abstract class GetChabun {
	
	public static final String BIZ_GUBUN_M 	= "M"; // ȸ�� : MEMBER
	public static final String BIZ_GUBUN_BD = "BD"; // �Խ��� : BOARD
	public static final String BIZ_GUBUN_RB = "RB"; // �Խ��� ���: REPLY BOARD
	public static final String BIZ_GUBUN_N 	= "NB"; // �������� : NOTICE BOARD
	public static final String BIZ_GUBUN_BK = "BK"; // å : BOOK
	
	// type : d D : YYYYMMDD0001, m M : YYYYMM0001, y Y : YYYY0001, n N : 0001 
	public static String numPad(String t, String c){
	
		for (int i=c.length(); i < 4; i++) {
			c = "0" + c;
		}				
		return DateFormatUtil.ymdFormats(t).concat(c);
	}	
	
	// ȸ�� ��ȣ 
	public static String getMemberChabun(String type) {		
		
		return BIZ_GUBUN_M.concat(numPad(type, GetMemberMaxNum.getMaxNum()));
	}
	
	// �Խ��� �� ��ȣ  
	public static String getBoardChabun(String type) {
		
		return BIZ_GUBUN_BD.concat(numPad(type, GetBoardMaxNum.getMaxNum()));
	}
	
	// �Խ��� ��� �� ��ȣ  
	public static String getRboardChabun(String type) {	
		
		return BIZ_GUBUN_M.concat(numPad(type, ""));
	}
	
	// ��������  ��ȣ  
	public static String getNoticeChabun(String type) {
		
		return BIZ_GUBUN_M.concat(numPad(type, ""));
	}
	
	// å  ��ȣ  
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
