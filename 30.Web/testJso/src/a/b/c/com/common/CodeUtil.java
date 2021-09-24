package a.b.c.com.common;

import java.util.ArrayList;

import a.b.c.com.jso.mem.vo.MemberVO;

public class CodeUtil {

	public static final String[] HOBBY_LABEL = {"알고리즘", "코딩", "분석설계", "데이터베이스", "스크립트"};
	public static final String[] HOBBY_ = {"01", "02", "03", "04", "05"};
	
	// 성별
	public static String gender(String s){
//		System.out.println("CodeUtil gender() 함수 진입 >>> : ");
		
		String gen = "";
		if (s.equals("01")) {
			gen = "여성";
		}else{
			gen = "남성";
		}
		return gen;
	}
	
	// 생년월일
	public static String birth(String s){
//		System.out.println("CodeUtil birth() 함수 진입 >>> : ");
		
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
				ss = s0 + "년" + s1 + "월" + s2 + "일";
			}
		}
		
		return ss;
	}
	
	// 핸드폰
	public static String hp(String s){
//		System.out.println("CodeUtil hp() 함수 진입 >>> : ");
		
		
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
	
	// 전화번호
	public static String tel(String s){
//		System.out.println("CodeUtil tel() 함수 진입 >>> : ");
		
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
	
	// 주소
	public static String addr(String s0, String s1, String s2){
//		System.out.println("CodeUtil addr() 함수 진입 >>> : ");
		
		String addr = s0 + "\n" + s1 + "\n" + s2;
		
		return addr;
	}
	
	// 취미
	public static String hobby(String s){
//		System.out.println("CodeUtil hobby() 함수 진입 >>> : ");
		
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
