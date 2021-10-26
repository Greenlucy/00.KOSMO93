package a.b.c.com.common;

import java.util.ArrayList;
import java.util.Enumeration;

import javax.servlet.http.HttpServletRequest;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.FileRenamePolicy;

public class FileUploadUtil {

	// 상수
	private String imgfilePaths;
	private int imgfileSize;
	private String encodeType;
	private MultipartRequest mr;		// 
	
	// 생성자
	public FileUploadUtil(String imgfilePaths, int imgfileSize, String encodeType) {
		this.imgfilePaths = imgfilePaths;
		this.imgfileSize = imgfileSize;
		this.encodeType = encodeType;
	}

	// 이게 필요한가..? 왜 이렇게 되지
	public FileUploadUtil() {
		// TODO Auto-generated constructor stub
	}
	
	public boolean imgfileUpload(HttpServletRequest req) {
		
		boolean bool = imgfileUpload(req, imgfilePaths);
		return bool;
	}
	
	public boolean imgfileUploadSize(HttpServletRequest req) {
		boolean bool = imgfileUploadSize(req, imgfilePaths);
		return bool;
	}
	
	public boolean imgfileUpload(HttpServletRequest req, String filePath) {
		boolean bool = false;
		try {
			mr = new MultipartRequest(req, filePath, imgfileSize, encodeType, new FileRename());
			System.out.println("mr >>> : " + mr);
			bool = true;
		}catch(Exception e) {
			System.out.println("imgfileUploadUtil.imgfileUpload() >>> : ");
		}
		return bool;
	}
	
	public boolean imgfileUploadSize(HttpServletRequest req, String filePath) {
		boolean bool = false;
		try {
			mr = new MultipartRequest(req, filePath, imgfileSize, encodeType, (FileRenamePolicy) new FileRename());
			System.out.println("mr >>> : " + mr);
			System.out.println("mr.getOriginalFileName(\"sbfile\") >>> : " + mr.getOriginalFileName("sbfile"));
			System.out.println("mr.getFilesystemName(\"sbfile\") >>> : " + mr.getFilesystemName("sbfile"));
			
			ThumnailImg.thumnailFun(filePath, mr.getFilesystemName("sbfile"));
			bool = true;
		}catch(Exception e) {
			System.out.println("imgfileUploadUtil.imgfileUpload() >>> : " + mr);
		}
		return bool;
	} // end of imgfileUploadSize()
	
	public String getParameter(String s) {
		return mr.getParameter(s);
	}
	
	public String getFileName(String f) {
		return mr.getFilesystemName(f);
	}
	
	public ArrayList<String> getFileNames(){
		@SuppressWarnings("unchecked")				// ?이제 이것도 좀 보자
		Enumeration<String> en = mr.getFileNames();
		ArrayList<String> a = new ArrayList<String>();
		
		while(en.hasMoreElements()) {
			String f = en.nextElement().toString();
			a.add(mr.getFilesystemName(f));
		}
		return a;
	}
}
