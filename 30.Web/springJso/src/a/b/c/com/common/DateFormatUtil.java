package a.b.c.com.common;

import java.text.SimpleDateFormat;
import java.util.Date;

public abstract class DateFormatUtil {

	public static String ymdFormat() {
		Date d = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyymmdd");	// ?
		String sd = sdf.format(d);
		// SimpleDateFormat 클래스의 SimpleDateFormat(String pattern) 함수
		// format() : Formats a Date into a date/time string (리턴 타입 : String)
		// > 오늘의 Date가 format(Date) 함수에 들어가서 SimpleDateFormat(pattern)에 정의된 pattern에 맞춰 String으로 리턴됌
		
		return sd;
	} // end of ymdFormat() 함수
	
	public static String ymFormat() {
		Date d = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMM");
		String sd = sdf.format(d);
		
		return sd;
	} // end of ymFormat() 함수
	
	public static String yFormat() {
		Date d = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy");
		String sd = sdf.format(d);
		
		return sd;
	} // end of yFormat() 함수
	
	public static String ymdFormats(String ymdFlag) {
		
		String sd = "";
		Date d = new Date();
		// 입력되는 값에 따라 
		if ("D".equals(ymdFlag.toUpperCase())) {
			sd = new SimpleDateFormat("yyyyMMdd").format(d);
		}
		if ("M".equals(ymdFlag.toUpperCase())) {
			sd = new SimpleDateFormat("yyyyMM").format(d);
		}
		if ("D".equals(ymdFlag.toUpperCase())) {
			sd = new SimpleDateFormat("yyyy").format(d);
		}
		if ("N".equals(ymdFlag.toUpperCase())) {
			sd = "";
		}
		return sd;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
	}
}
