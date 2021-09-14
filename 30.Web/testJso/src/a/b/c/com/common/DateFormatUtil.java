package a.b.c.com.common;

import java.text.SimpleDateFormat;
import java.util.Date;

public abstract class DateFormatUtil {
	
	public static String ymdFormat(){
		return new SimpleDateFormat("yyyyMMDD").format(new Date());
	}
	
	public static String ymFormat(){
		return new SimpleDateFormat("yyyyMM").format(new Date());
	}
	
	public static String yFormat(){
		return new SimpleDateFormat("yyyy").format(new Date());
	}
	
	public static String ymdFormats(String ymdFlag){
		String y = "";
		if("D".equals(ymdFlag.toUpperCase())){
			y = DateFormatUtil.ymdFormat();
		}
		if ("M".equals(ymdFlag.toUpperCase())){
			y = DateFormatUtil.ymFormat();
		}
		if ("Y".equals(ymdFlag.toUpperCase())){
			y = DateFormatUtil.yFormat();
		}
		if ("N".equals(ymdFlag.toUpperCase())){
			y = "";
		}
		return y;
	}
}
