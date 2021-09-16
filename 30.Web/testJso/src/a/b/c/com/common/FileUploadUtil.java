package a.b.c.com.common;

import java.util.ArrayList;
import java.util.Enumeration;

import javax.servlet.http.HttpServletRequest;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

public class FileUploadUtil {

	// ���ڵ� Ÿ�� ���
	public static final String ENCODE_TYPE = "EUC-KR";
	public static final int SIZE_LIMIT = 5240880;
	private MultipartRequest m;
	
	// ������
	public FileUploadUtil(){
		
	}
	
	// �Ű����� :: request ��û, filePaths ���
	public boolean fileUpload(HttpServletRequest hReq, String filePaths){
		
		boolean fb = false;
		try{
			m = new MultipartRequest( hReq
									,filePaths
									,FileUploadUtil.SIZE_LIMIT
									,FileUploadUtil.ENCODE_TYPE
									,new DefaultFileRenamePolicy());
//			if (m != null ){
//				return fb = true;
//			}
			return fb = true;
		}catch(Exception e){
			System.out.println("FileUploadUtil.fileUpload() >>> : " + e);
		}
		return fb;
	}
	
	public boolean fileUpload3(HttpServletRequest hReq, String filePaths, int size_limit, String encode_type){
		
		boolean fb = false;
		try{
			// �ƱԸ�Ʈ �޾Ƽ� �� �Է� : ��� �Ű������� ���� �Է��� �ް�, 3��° �Ű������� �ٸ�
			m = new MultipartRequest( hReq
									,filePaths
									,size_limit
									,encode_type	
									,new DefaultFileRenamePolicy());
			return fb = true;
		}catch(Exception e){
			System.out.println("FileUploadUtil.fileUpload3() >>> : " + e);
		}
		return fb;
	}
	
	// private MultipartRequest m; ���� �Ķ���� �ҷ����� 
	public String getParameter(String s){
		return m.getParameter(s);
	}
	
	// MultipartRequest.getParameterValues() �Լ� ȣ��
	public String[] getParameterValues(String s){
		return m.getParameterValues(s);
	}
	
	// MultipartRequest.getFilesystemName() �Լ� ȣ��
	public String getFileName(String f){
		return m.getFilesystemName(f);
	}
	
	public ArrayList<String> getFileNames(){
		@SuppressWarnings("unchecked")
		// java.util.Enumeration : public interface Enumeration<E>
		Enumeration<String> en = m.getFileNames();
		ArrayList<String> a = new ArrayList<String>();
		
		// �ݺ��� > ArrayList�� ����
		// boolean hasMoreElements() : Tests if this enumeration contains more elements.
		while (en.hasMoreElements()){
			// E nextElement() : Returns the next element of this enumeration (if this enumeration object has at least one more element to provide.)
			String f = en.nextElement().toString();
			// ArrayList�� ����
			// ArrayList<String>.add(MultipartRequest(
			// 						MultipartRequest.getFileNames.nextElement().toString()))
			a.add(m.getFilesystemName(f));
		}
		return a;
	}
}
