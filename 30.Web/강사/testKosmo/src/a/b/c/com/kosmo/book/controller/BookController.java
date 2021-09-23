package a.b.c.com.kosmo.book.controller;

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

import a.b.c.com.kosmo.book.service.BookService;
import a.b.c.com.kosmo.book.service.BookServiceImpl;
import a.b.c.com.kosmo.book.vo.BookVO;
import a.b.c.com.common.CommonUtils;
import a.b.c.com.common.FileUploadUtil;
import a.b.c.com.common.GetChabun;

@WebServlet("/book")
public class BookController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
		throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		request.setCharacterEncoding("EUC-KR");
		response.setCharacterEncoding("EUC-KR");
		response.setContentType("text/html; charset=EUC-KR");
		PrintWriter out = response.getWriter();
		
		String isudtype = request.getParameter("isudtype");
		if (isudtype !=null) isudtype.toUpperCase();
		
		if (isudtype !=null && isudtype.length() > 0){
			System.out.println("isudtype >>> : " + isudtype);
			System.out.println("remoteIP >>> : " + request.getRemoteAddr());
			System.out.println("method >>> : " + request.getMethod());	
			
			// ���� ���� ��ü ��ȸ
			if ("SALL".equals(isudtype)){
				System.out.println("���� ���� ��ü ��ȸ isudtype >>> : " + isudtype);
				
				BookService bs = new BookServiceImpl();			
				ArrayList<BookVO> aListAll = bs.bookSelectAll();
				
				if (aListAll !=null && aListAll.size() > 0) {
					
					request.setAttribute("aListAll", aListAll);					
					RequestDispatcher rd= request.getRequestDispatcher("/kosmo/book/bookSelectAll.jsp");
					rd.forward(request, response);
					
				}else {
					out.println("<script>");					
					out.println("location.href='/testKosmo/book?isudtype=SALL'");
					out.println("</script>");
				}		
			}
			
			// ���� ���� ���� ��ȸ : S U D 
			if ("S".equals(isudtype) || "U".equals(isudtype) || "D".equals(isudtype)){
				System.out.println("���� ���� ���� ��ȸ : S U D isudtype >>> : " + isudtype);

				String bnum = request.getParameter("bnumCheck");				
				if (bnum !=null && bnum.length() > 0){
					System.out.println("������ȣ >>> :  " + bnum);
					
					BookService bs = new BookServiceImpl();
					BookVO bvo = null;
					bvo = new BookVO();
					bvo.setBnum(bnum);
					
					ArrayList<BookVO> aList = bs.bookSelect(bvo);

					if (aList !=null && aList.size() > 0) {
						
						request.setAttribute("aList", aList);					
						RequestDispatcher rd= request.getRequestDispatcher("/kosmo/book/bookSelect.jsp");
						rd.forward(request, response);
						
					}else {
						out.println("<script>");					
						out.println("location.href='/testKosmo/book?isudtype=SALL'");
						out.println("</script>");
					}									
				}else{
					System.out.println("������ȣ�� �����ϴ�. ");
				}		
			}
			
			// ���� ����
			if ("UOK".equals(isudtype)){
				System.out.println("���� ���� ���� isudtype >>> : " + isudtype);
				
				String bnum = request.getParameter("bnum");
				String bprice = request.getParameter("bprice");
				String bqty = request.getParameter("bqty");				
				System.out.println("bnum >>> : " + bnum);
				System.out.println("bprice >>> : " + bprice);
				System.out.println("bqty >>> : " + bqty);
				
				BookService bs = new BookServiceImpl();
				BookVO bvo = null;
				bvo = new BookVO();
				
				bvo.setBnum(bnum);
				bvo.setBprice(bprice);
				bvo.setBqty(bqty);
				
				int nCnt = bs.bookUpdate(bvo);
				
				if (nCnt >  0) {
					System.out.println("���� ���� " + nCnt + " �� ���� �Ǿ����ϴ�.");		
					request.setAttribute("nCnt", new Integer(nCnt));										
					RequestDispatcher rd= request.getRequestDispatcher("/kosmo/book/bookUpdate.jsp");
					rd.forward(request, response);
					
				}else {
					System.out.println("���� ���� ��� ���� !!!!");
					out.println("<script>");					
					out.println("location.href='/testKosmo/book?isudtype=SALL'");
					out.println("</script>");
				}
			}
			
			// ���� ����
			if ("DOK".equals(isudtype)){
				System.out.println("���� ���� ���� isudtype >>> : " + isudtype);
				
				String bnum = request.getParameter("bnum");				
				System.out.println("bnum >>> : " + bnum);
				
				BookService bs = new BookServiceImpl();
				BookVO bvo = null;
				bvo = new BookVO();
				
				bvo.setBnum(bnum);				
				int nCnt = bs.bookDelete(bvo);
				
				if (nCnt >  0) {
					System.out.println("���� ���� " + nCnt + " �� ���� �Ǿ����ϴ�.");		
					request.setAttribute("nCnt", new Integer(nCnt));										
					RequestDispatcher rd= request.getRequestDispatcher("/kosmo/book/bookDelete.jsp");
					rd.forward(request, response);
					
				}else {
					System.out.println("���� ���� ��� ���� !!!!");
					out.println("<script>");					
					out.println("location.href='/testKosmo/book?isudtype=SALL'");
					out.println("</script>");
				}
			}			
			
			// ���� ��� 
			if ("I".equals(isudtype)){
				System.out.println("���� ���� ��� isudtype >>> : " + isudtype);
				
				String bnum = "";
				String btitle = "";
				String bauth = "";
				String isbn = "";
				String bcomp = "";
				String bprice = "";
				String bqty = "";
				String bcover = "";
				
				boolean fileUploadBool = request.getContentType().toLowerCase().startsWith("multipart/form-data");				
				System.out.println("fileUploadBool >>> : " + fileUploadBool);
				
				if (fileUploadBool){
					System.out.println("���� ���ε� ��ƾ >>> : ");
					
					
					String filePaths = CommonUtils.BOOK_IMG_UPLOAD_PATH;
					int size_limit = CommonUtils.BOOK_IMG_FILE_SIZE;
					String encode_type = CommonUtils.BOOK_IMG_ENCODE;
					
					FileUploadUtil fu = new FileUploadUtil();					
					boolean bool = fu.fileUpldad3(request, filePaths, size_limit, encode_type);
					
					if (bool){
						
						btitle = fu.getParameter("btitle");
						bauth = fu.getParameter("bauth");
						isbn = fu.getParameter("isbn");
						bcomp = fu.getParameter("bcomp");
						bprice = fu.getParameter("bprice");
						bqty = fu.getParameter("bqty");						
						// ǥ��
						ArrayList<String> aFileName = fu.getFileNames();
						bcover = aFileName.get(0);				
					}else{
						System.out.println("���� ���ε� ���� ");
					}				
				}
				
				// ä��
				bnum = GetChabun.getBookChabun("d");
				System.out.println("bnum >>> : " + bnum);
				System.out.println("btitle >>> : " + btitle);
				System.out.println("bauth >>> : " + bauth);
				System.out.println("isbn >>> : " + isbn);
				System.out.println("bcomp >>> : " + bcomp);
				System.out.println("bprice >>> : " + bprice);
				System.out.println("bqty >>> : " + bqty);
				System.out.println("bcover >>> : " + bcover);
				
				BookService bs = new BookServiceImpl();
				BookVO bvo = null;
				bvo = new BookVO();
				
				bvo.setBnum(bnum);
				bvo.setBtitle(btitle);
				bvo.setBauth(bauth);
				bvo.setIsbn(isbn);
				bvo.setBcomp(bcomp);
				bvo.setBprice(bprice);
				bvo.setBqty(bqty);
				bvo.setBcover(bcover);
				
				BookVO.printlnBookVO(bvo);
				int nCnt = bs.bookInsert(bvo);
				
				if (nCnt >  0) {
					System.out.println("���� ���� " + nCnt + " �� ��� �Ǿ����ϴ�.");		
					
					request.setAttribute("nCnt", new Integer(nCnt));										
					
					RequestDispatcher rd= request.getRequestDispatcher("/kosmo/book/bookInsert.jsp");
					rd.forward(request, response);
					
				}else {
					System.out.println("���� ���� ��� ���� !!!!");
					out.println("<script>");					
					out.println("location.href='/testKosmo/book/book.html'");
					out.println("</script>");
				}
			}
		}else{			
			System.out.println("isudtype �� �� �����ÿ� !!!");
		}		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) 
		throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}
}
