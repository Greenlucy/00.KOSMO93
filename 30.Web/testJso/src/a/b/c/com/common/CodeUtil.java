package a.b.c.com.common;

import java.util.ArrayList;

import a.b.c.com.jso.mem.vo.MemberVO;

public class CodeUtil {

	public static final String[] HOBBY_LABEL = {"�˰���", "�ڵ�", "�м�����", "�����ͺ��̽�", "��ũ��Ʈ"};
	public static final String[] HOBBY_ = {"01", "02", "03", "04", "05"};
	
	// ����
	public static String gender(String s){
//		System.out.println("CodeUtil gender() �Լ� ���� >>> : ");
		
		String gen = "";
		if (s.equals("01")) {
			gen = "����";
		}else{
			gen = "����";
		}
		return gen;
	}
	
	// �������
	public static String birth(String s){
//		System.out.println("CodeUtil birth() �Լ� ���� >>> : ");
		
		String s0 = "";
		String s1 = "";
		String s2 = "";
		String ss = "";
		
		if (s != null && s.length() > 0){
			int sLen = s.length();
			if(8 == sLen){
				s0 = s.substring(0, 4);
				s1 = s.substring(4, 6);
				s2 = s.substring(6);
				ss = s0 + "��" + s1 + "��" + s2 + "��";
			}
		}
		
		return ss;
	}
	
	// �ڵ���
	public static String hp(String s){
//		System.out.println("CodeUtil hp() �Լ� ���� >>> : ");
		
		
		String s0 = "";
		String s1 = "";
		String s2 = "";
		String ss = "";
		
		if (s != null && s.length() > 0){	
			if (11 == s.length()){
				s0 = s.substring(0, 3);
				s1 = s.substring(3, 7);
				s2 = s.substring(7);
				
				ss = s0 + "-" + s1 + "-" + s2;
			}
		}
		return ss;
	}
	
	// ��ȭ��ȣ
	public static String tel(String s){
//		System.out.println("CodeUtil tel() �Լ� ���� >>> : ");
		
		String s0 = "";
		String s1 = "";
		String s2 = "";
		String ss = "";
		
		if (11 == s.length()){
			s0 = s.substring(0, 3);
			s1 = s.substring(3, 7);
			s2 = s.substring(7);
			ss = s0 + "-" + s1 + "-" + s2;
		}
		
		if (10 == s.length()){
			s0 = s.substring(0, 2);
			s1 = s.substring(2, 6);
			s2 = s.substring(6);
			ss = s0 + "-" + s1 + "-" + s2;
		}
		return ss;
	}
	
	// �ּ�
	public static String addr(String s0, String s1, String s2){
//		System.out.println("CodeUtil addr() �Լ� ���� >>> : ");
		
		String addr = s0 + "\n" + s1 + "\n" + s2;
		
		return addr;
	}
	
	// ���
	public static String hobby(String s){
//		System.out.println("CodeUtil hobby() �Լ� ���� >>> : ");
		
		String ss = "";
		
//		if (s != null && s.length() > 0){
//			if (s.contains("01")){
//				ss += CodeUtil.HOBBY_LABEL[0] + ", ";
//			}
//			if (s.contains("02")){
//				ss += CodeUtil.HOBBY_LABEL[1] + ", ";
//			}
//			if (s.contains("03")){
//				ss += CodeUtil.HOBBY_LABEL[2] + ", ";
//			}
//			if (s.contains("04")){
//				ss += CodeUtil.HOBBY_LABEL[3] + ", ";
//			}
//			if (s.contains("05")){
//				ss += CodeUtil.HOBBY_LABEL[4] + ", ";
//			}
//		}
		for (int i=0; i < HOBBY_.length; i++){
			if (s.equals(HOBBY_[i])){
				ss += CodeUtil.HOBBY_LABEL[i] + ", \n";
			}
		}
		
		return ss;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
