package a.b.c.cgitest;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Enumeration;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;


@WebServlet("/fileupload")
public class FileUploadServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
		throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		request.setCharacterEncoding("EUC-KR");
		response.setContentType("text/html; charset=EUC-KR"); 
		PrintWriter out = response.getWriter();
		
		String saveDirectory = "C:\\00.KOSMO93\\30.Web\\el_web_neon _work\\.metadata\\.plugins\\org.eclipse.wst.server.core\\tmp0\\wtpwebapps\\testKosmo\\fileupload";
		int maxPostSize = 10*10*1024; // 10MB
		String encoding = "EUC-KR";
		String fileName1 = "";
		String fileName2 = "";
		
		try {
			MultipartRequest mr = new MultipartRequest(  request  
										                ,saveDirectory
										                ,maxPostSize
										                ,encoding
										                ,new DefaultFileRenamePolicy());
			System.out.println("mr >>> : " + mr);
			// 파일 업로드에서 MultipartRequest 클래스를 인스턴스 한 이후에는 
			// MultipartReqeust 클래스의 참조 변수를 이용해야 한다.
			
			// String name = request.getParameter("name");
			// String subject = request.getParameter("subject");
			
			String name = mr.getParameter("name");
			String subject = mr.getParameter("subject");
			
			Enumeration files = mr.getFileNames();
			String file1 = String.valueOf(files.nextElement());
			fileName1 = mr.getFilesystemName(file1);
			String file2 = String.valueOf(files.nextElement());
			fileName2 = mr.getFilesystemName(file2);
			
			System.out.println("name >>> : " + name);
			System.out.println("subject >>> : " + subject);
			System.out.println("fileName1 >>> : " + fileName1);
			System.out.println("fileName2 >>> : " + fileName2);
			
			ArrayList<String> aList = new ArrayList<String>();
			aList.add(name);
			aList.add(subject);
			aList.add(fileName1);
			aList.add(fileName2);
			
			if (aList !=null && aList.size() > 0){
				// fileUpload.jsp 로 보내는 ArrayList 객체 세팅
				request.setAttribute("aList", aList);				
				// RequestDispatcher 인터페이스 에서 사용하는 getRequestDispatcher 함수에서는 
				// Context 경로를 사용하지  않음			
				RequestDispatcher rd = request.getRequestDispatcher("/cgiTest/fileUpload.jsp");
				rd.forward(request, response);						
			}else{
				out.println("<script>");				
				out.println("location.href='/testKosmo/cgiTest/fileUpload.html'");
				out.println("</script>");
			}
			
		}catch(Exception e){
			System.out.println("에러가  >>> : "+ e);
		}				
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) 
		throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
