package a.b.c.com.common;

import java.io.File;

import com.oreilly.servlet.multipart.FileRenamePolicy;

public class FileRename implements FileRenamePolicy{

	// 생성자
	public FileRename() {
		
	}

	@Override
	public File rename(File sf) {
		// TODO Auto-generated method stub
		System.out.println("FileRename rename() 함수 진입 >>> : ");
		String f = sf.getName();
		System.out.println("fileName >>> : " + f);
		
		try {
			String s = f;
			// 입력받은 파일의 존재하는 갯수만큼 반복하는 for문
			for (int i=1; sf.exists(); i++) {			// 잘 할 수 있게..
				int lt = s.lastIndexOf(".");
				String s1 = s.substring(0, lt);
				String s2 = s.substring(lt);
				String st = "_" + i + "_";
				f = s1.concat(st).concat(s2);
				// File(String parent, String child)
				sf = new File(sf.getParent(), f);			// ?
			}
		}catch(Exception e) {
			System.out.println("FileRename.reName() >>> : " + e.getMessage());
		}
		
		return sf;
	} // end of rename() 함수
	
	public static void main(String[] args) {
		// 파일명 rename을 해보자
		File f = new File("C:\\msdia80.dll");
		File ss = new FileRename().rename(f);
		System.out.println("ss >>> : " + ss.getName());
		
		/*  정상 실행 됌
		 	FileRename rename() 함수 진입 >>> : 
			fileName >>> : msdia80.dll
			ss >>> : msdia80_1_.dll		 
		*/
	}
}
