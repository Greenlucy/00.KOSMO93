package a.b.c.com.common;

import java.util.ArrayList;

public class TestClass {
	public void test() {
		System.out.println("a.b.c.com.xml.TestClassŬ������ �ִ� test() �޼ҵ��Դϴ�.");
		System.out.println("Hello >>>>>>>>>");
		
		ArrayList<String> aList = new ArrayList<String>();
		aList.add("�ּ���");
		aList.add("���翵");
		aList.add("������");
		aList.add("������");
		aList.add("�����");
		aList.add("����ȣ");
		aList.add("������");
		aList.add("������");
		aList.add("������");
		aList.add("�ſ���");
		aList.add("�̱���");
		for (int i=0; i < aList.size(); i++){
			System.out.println(">>> : " + aList.get(i));
		}
	} // end of test()
	
	public static void main(String args[]){
		TestClass tc = new TestClass();
		tc.test();
	}
}
