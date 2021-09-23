package a.b.c.com.common;

public abstract class CodeUtil {
	
		
	// ���� ��
	public static final String[] gender_value = {"����","����"};
	
	// �ڵ��� ��
	public static final String[] hp_value = {"010", "011", "016", "017"};
		
	// ��ȭ��ȣ ��
	public static final String[] tel_value = {"02", "031", "041", "051", "061"};
	
	// ��� ��
	public static final String[] hobby_lavel = {"�˰���", "�ڵ�", "�м�����", "�����ͺ��̽�", "��ũ��Ʈ"};
	public static final String[] hobby_value = {"01", "02", "03", "04", "05"};
	
	// ������� 
	public static String birth(String s) {

		String s0 = "";
		String s1 = "";
		String s2 = "";
		String ss = "";
		
		if (s !=null && s.length() > 0){			
			int sLen = s.length();			
			if (8 == sLen) {
				s0 = s.substring(0, 4);
				s1 = s.substring(4, 6);
				s2 = s.substring(6);				
				ss = s0 + "-" + s1 + "-" + s2;
			}
		}		
		return ss;
	}
	
	// ����
	public static String gender(String s) {
		return "01".equals(s.toUpperCase()) ? "����" : "����";
	}
	
	// ��ȭ��ȣ 
	public static String tel(String s) {

		String s0 = "";
		String s1 = "";
		String s2 = "";
		String ss = "";
		
		if (s !=null && s.length() > 0){			
			int sLen = s.length();			
			if (10 == sLen) {
				s0 = s.substring(0, 2);
				s1 = s.substring(2, 6);
				s2 = s.substring(6);
				ss = s0 + "-" + s1 + "-" + s2;
			}		
			if (11 == sLen) {
				s0 = s.substring(0, 3);
				s1 = s.substring(3, 7);
				s2 = s.substring(7);
				ss = s0 + "-" + s1 + "-" + s2;
			}
		}
		return ss;
	}
	
	// ��ȭ��ȣ 
	public static String hp(String s) {

		String s0 = "";
		String s1 = "";
		String s2 = "";
		String ss = "";
		
		if (s !=null && s.length() > 0){			
			int sLen = s.length();			
			if (11 == sLen) {
				s0 = s.substring(0, 3);
				s1 = s.substring(3, 7);
				s2 = s.substring(7);
				ss = s0 + "-" + s1 + "-" + s2;
			}
		}		
		return ss;
	}

	// ��̵� 
	public static String hobbys(String s){
		System.out.println(s);
		String h = "";
		String ss[] = s.split(",");
		for (int i=0; i < ss.length; i++){			
			System.out.println(hobby(ss[i]));
			h += hobby(ss[i]) + " ";
		}		
		return h;
	}
	
	// ���
	public static String hobby(String s) {
		
		String h = "";				
		if (s !=null && s.length() > 0){							
			for (int i=1; i < hobby_lavel.length; i++) {	
				if (("0" + i).equals(s)) {
					h = CodeUtil.hobby_lavel[i-1];
				}
			}			
		}		
		return h;
	}
	
	// ��� value(�ڵ�) ����
	public static String setHobby(String s) {
		
		String h = "";						
		for (int i=0; i < CodeUtil.hobby_lavel.length; i++) {			
			if (CodeUtil.hobby_lavel[i].equals(s)) {
				h = CodeUtil.hobby_value[i];
			}			
		}		
		return h;
	}
	
	// ���, ���� value(�ڵ�) ����
	public static int getComboIndex(String s) {		
		int c = 0;			
		if ("01".equals(s)) { c = 0; }		
		if ("02".equals(s)) { c = 1; }		
		if ("03".equals(s)) { c = 2; }
		if ("04".equals(s)) { c = 3; }		
		if ("05".equals(s)) { c = 4; }		
		if ("06".equals(s)) { c = 5; }
		return c;
	}	
		
	public static void main(String args[]) {
		
		// �������
		String b = CodeUtil.birth("20210801");		
		System.out.println("b >>> : " + b);
		
		// ��ȭ��ȣ
		String t = CodeUtil.tel("03212341234");		
		System.out.println("t >>> : " + t);
		
		// �ڵ���
		String hp = CodeUtil.tel("01012341234");		
		System.out.println("hp >>> : " + hp);		
		
		// ����
		String g = CodeUtil.gender("02");
		System.out.println("g >>> : " + g);
		// ���
		String h = CodeUtil.hobby("02");
		System.out.println("h >>> : " + h);
		// ��̵�
		String hs = CodeUtil.hobbys("01,02,03,");
		System.out.println("hs >>> : " + hs);
	}
}
