package a.b.c.com.common;

import java.util.ArrayList;

public class TestClass {
	public void test() {
		System.out.println("a.b.c.com.xml.TestClass클래스에 있는 test() 메소드입니다.");
		System.out.println("Hello >>>>>>>>>");
		
		ArrayList<String> aList = new ArrayList<String>();
		aList.add("최세라");
		aList.add("오재영");
		aList.add("윤종서");
		aList.add("김찬기");
		aList.add("김상진");
		aList.add("용태호");
		aList.add("김형우");
		aList.add("이희진");
		aList.add("정예지");
		aList.add("신욱진");
		aList.add("이근희");
		for (int i=0; i < aList.size(); i++){
			System.out.println(">>> : " + aList.get(i));
		}
	} // end of test()
	
	public static void main(String args[]){
		TestClass tc = new TestClass();
		tc.test();
	}
}
