package a.b.c.com.jso.book.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import a.b.c.com.common.CommonUtils;
import a.b.c.com.common.FileUploadUtil;
import a.b.c.com.common.GetChabun;
import a.b.c.com.jso.board.vo.BoardVO;
import a.b.c.com.jso.book.service.BookService;
import a.b.c.com.jso.book.service.BookServiceImpl;
import a.b.c.com.jso.book.vo.BookVO;

@WebServlet("/book")
public class BookController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		System.out.println("BookController doGet() �Լ� ���� >>> : ");
		
		// request, response ��� ���ڵ� ��� �ʱ�ȭ(set)���ֱ�
		request.setCharacterEncoding("EUC-KR");
		response.setCharacterEncoding("EUC-KR");
		response.setContentType("text/html; charset=EUC-KR");
		PrintWriter out = response.getWriter();
		
		// book.html�κ��� ���� ��
		String isudtype = request.getParameter("isudtype");
		
		if (isudtype != null && isudtype.length() > 0){
			isudtype.toUpperCase();
			
			System.out.println("isudtype >>> : " + isudtype);
			System.out.println("remoteIP >>> : " + request.getRemoteAddr());
			System.out.println("method >>> : " + request.getMethod());
			
			// ���� ���� ��ü ��ȸ
			if ("SALL".equals(isudtype)){
				System.out.println("���� ���� ��ü ��ȸ isudtype >>> : " + isudtype);
				
				// ���� ȣ��
				BookService bs = new BookServiceImpl();
				BookVO bvo = null;
				bvo = new BookVO();
				// bvo�� ���������κ��� �Է¹޾Ƽ� setter()�Լ��� �ʱ�ȭ���� ���� ����.
				// bookSelectAll() �Լ��� : ArrayList<BookVO> �� ���� �����ϹǷ�
				ArrayList<BookVO> aListSA = bs.bookSelectAll();
				
				// aList�� null�� üũ���� ���ֱ�
				if (aListSA != null && aListSA.size() > 0){
					// ������� �ʴٸ�, ������ �޾Ƽ� jsp ���Ϸ� �Ѱ���� ��
					// key & value ���·� ���尴ü request�� set(�ʱ�ȭ) ����
					System.out.println("��ü��ȸ ���� !!!");
					request.setAttribute("aListSA", aListSA);
					RequestDispatcher rd = request.getRequestDispatcher("/jso/book/bookSelectAll.jsp");
					rd.forward(request, response);
				}else{
					System.out.println("��ü��ȸ ���� !!!");
					System.out.println("aListSA�� ������ϴ�. >>> : " + aListSA.size());
				}
			}
			
			// ���� ���� ���� ��ȸ : S U D
			if ("S".equals(isudtype) || "U".equals(isudtype) || "D".equals(isudtype)){
				System.out.println("�������� ������ȸ >>> : ");
				
				String bnum = request.getParameter("bnumCheck");
				// ���� ȣ��
				BookService bs = new BookServiceImpl();
				BookVO bvo = null;
				bvo = new BookVO();
				bvo.setBnum(bnum);
				
				ArrayList<BookVO> aListS = bs.bookSelect(bvo);
				
				if (aListS != null && aListS.size() > 0){
					
					request.setAttribute("aListS", aListS);
					RequestDispatcher rd = request.getRequestDispatcher("/jso/book/bookSelect.jsp");
					rd.forward(request, response);
				}else{
					out.println("<script>");
					out.println("location.href='/testJso/book?isudtype=SALL'");
					out.println("</script>");
				}
			}
			
			// ���� ����
			if ("UOK".equals(isudtype)){
				System.out.println("���� ���� >>> : ");
				
				// getParameter() �� �ϸ� �����Ͱ� �Ѿ�� ���� 
				String bprice = "";
				String bqty = "";
				String bnum = "";
				String bcover = "";
				// name = bcover_old, name = bcover_new
				// public boolean fileUpload3(HttpServletRequest hReq, String filePaths, int size_limit, String encode_type)
				FileUploadUtil fu = new FileUploadUtil();
				String filePaths = CommonUtils.BOOK_IMG_UPLOAD_PATH;
				int size_limit = CommonUtils.BOOK_IMG_FILE_SIZE;
				String encode_type = CommonUtils.BOOK_IMG_ENCODE;
				
				boolean bool = fu.fileUpload3(request, filePaths, size_limit, encode_type);
				
				if (bool){
					System.out.println("���� ���ε� ���� !!");
					bnum = fu.getParameter("bnum");
					bprice = fu.getParameter("bprice");
					bqty = fu.getParameter("bqty");
					
					ArrayList<String> aFileName = fu.getFileNames();
					String bcover_new = aFileName.get(0);
					
					// if ("String" != "String"), if("null" != null) ��� ��� true ��
					// if (String ��ü != null ��ü) �񱳰� �ǹ� ���� :: ����� �� null�� üũ
					// �� ������ �ҷ��� ���ε��ؾ� �� ��, FileUpload �������� �����ؾ� ���� ���� �� �ҷ��� �� ����� �����ϴ�.
					if (bcover_new != null && bcover_new.length() > 0){
						System.out.println("�� ǥ�� ���� ���� ���� !!");
						bcover = bcover_new;
						
					}else{
						System.out.println("ǥ�� ���� ���� ����!!");
						bcover = fu.getParameter("bcover_old");
					}
				}else{
					System.out.println("���� ���ε� ���� !!");
				}
				System.out.println("bnum >>> : " + bnum);
				System.out.println("bprice >>> : " + bprice);
				System.out.println("bqty >>> : " + bqty);
				System.out.println("bcover >>> : " + bcover);
				
				// ���� ȣ��
				BookService bs = new BookServiceImpl();
				BookVO bvo = null;
				bvo = new BookVO();
				// placeholder ���ε� 
				bvo.setBprice(bprice);
				bvo.setBqty(bqty);
				bvo.setBnum(bnum);
				bvo.setBcover(bcover);
				
				int nCntU = bs.bookUpdate(bvo);
				
				if (nCntU > 0){
					System.out.println("���� ���� !!!");
					
					request.setAttribute("nCntU", nCntU);
					RequestDispatcher rd = request.getRequestDispatcher("/jso/book/bookUpdate.jsp");
					rd.forward(request, response);
				}else{
					System.out.println("���� ���� !!!");
					out.println("<script>");
					out.println("location.href='/testJso/jso/book?isudtype=SALL'");
					out.println("</script>");
				}
			}
			
			// ���� ����
			if ("DOK".equals(isudtype)){
				System.out.println("���� ���� ���� >>> : ");
				
				String bnum = request.getParameter("bnum");
				// ���� ȣ��
				BookService bs = new BookServiceImpl();
				BookVO bvo = null;
				bvo = new BookVO();
				// placeholder �ʱ�ȭ�ϱ�
				bvo.setBnum(bnum);
				
				int nCntD = bs.bookDelete(bvo);
				if (nCntD > 0){
					System.out.println("���� ���� !!!");
					// jsp�� ����
					request.setAttribute("nCntD", nCntD);
					RequestDispatcher rd = request.getRequestDispatcher("/jso/book/bookDelete.jsp");
					rd.forward(request, response);
					
				}else{
					System.out.println("���� ���� !!!");
					out.println("<script>");
					out.println("location.href='/testJso/book?isudtype=SALL'");
					out.println("</script>");
				}
			}
			
			// ���� ���
			if ("I".equals(isudtype)){
				System.out.println("���� ���� ��� isudtype >>> : " + isudtype);
				
				// ����� (�÷���)���� �����ϰ� �ʱ�ȭ
				String bnum = "";
				String btitle = "";
				String bauth = "";
				String isbn = "";
				String bcomp = "";
				String bprice = "";
				String bqty = "";
				String bcover = "";
				
				// ���� ���ε� Ȯ�� : ��û�� ������ enctype = multipart/form-data �� �� Ȯ��
				boolean fileUploadBool = request.getContentType().toLowerCase().startsWith("multipart/form-data");
				System.out.println("fileUploadBool >>> : " + fileUploadBool);
				
				if (fileUploadBool){
					System.out.println("���� ���ε� ��ƾ >>> : ");
					
					// ����� �������� �����ϰ� �ʱ�ȭ
					String filePaths = CommonUtils.BOOK_IMG_UPLOAD_PATH;
					int size_limit = CommonUtils.BOOK_IMG_FILE_SIZE;
					String encode_type = CommonUtils.BOOK_IMG_ENCODE;
					
					// �޸𸮿� �ν��Ͻ�
					FileUploadUtil fu = new FileUploadUtil();
					// request + �ʱ�ȭ�� ���������� �� ����
					boolean bool = fu.fileUpload3(request, filePaths, size_limit, encode_type);
					// ������ ���������� ���ٸ� bool = true;
					
					if (bool){
						System.out.println("������ ���� ���� ���� >>> : ");
						// (�÷���)������ ���ε� �� ������ ���� ���
						btitle = fu.getParameter("btitle");
						bauth = fu.getParameter("bauth");
						isbn = fu.getParameter("isbn");
						bcomp = fu.getParameter("bcomp");
						bprice = fu.getParameter("bprice");
						bqty = fu.getParameter("bqty");
						// ǥ��
						// FileUploadUtil.getFileNames()�� ArrayList<String>�� ���
						ArrayList<String> aFileName = fu.getFileNames();
						// ù��° ��� ����ؼ� ���� bcover�� ����
						bcover = aFileName.get(0);
					}else{
						System.out.println("���� ���ε� ����");
					}
				}
				bnum = GetChabun.getBookChabun("d");
//				btitle = request.getParameter("btitle");
//				bauth = request.getParameter("bauth");
//				isbn = request.getParameter("isbn");
//				bcomp = request.getParameter("bcomp");
//				bprice = request.getParameter("bprice");
//				bqty = request.getParameter("bqty");
//				bcover = request.getParameter("bcover");

				// ���� ȣ��
				BookService bs = new BookServiceImpl();				
				BookVO bvo = null;
				bvo = new BookVO();
				// placeholder��ŭ ���ε�
				bvo.setBnum(bnum);
				bvo.setBtitle(btitle);
				bvo.setBauth(bauth);
				bvo.setIsbn(isbn);
				bvo.setBcomp(bcomp);
				bvo.setBprice(bprice);
				bvo.setBqty(bqty);
				bvo.setBcover(bcover);
				
				int nCnt = bs.bookInsert(bvo);
				
				if (nCnt > 0){
					System.out.println("���� ���� " + " �� ��ϵǾ����ϴ�.");
					
					request.setAttribute("nCnt", new Integer(nCnt));
					RequestDispatcher rd = request.getRequestDispatcher("/jso/book/bookInsert.jsp");
					rd.forward(request, response);
				}else{
					System.out.println("���� ���� ��� ���� !!!!");
					out.println("<script>");
					out.println("location.href='/testJso/jso/book/book.html'");
					out.println("</script>");
				}
			}
		}else{
			System.out.println("isudtype�� �� �����ÿ� !!!");
		}
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		System.out.println("BookController doPost() �Լ� ���� >>> : ");
		doGet(request, response);
	}

}
