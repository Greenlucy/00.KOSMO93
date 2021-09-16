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
		System.out.println("BookController doGet() 함수 진입 >>> : ");
		
		// request, response 모두 인코딩 언어 초기화(set)해주기
		request.setCharacterEncoding("EUC-KR");
		response.setCharacterEncoding("EUC-KR");
		response.setContentType("text/html; charset=EUC-KR");
		PrintWriter out = response.getWriter();
		
		// book.html로부터 받을 값
		String isudtype = request.getParameter("isudtype");
		
		if (isudtype != null && isudtype.length() > 0){
			isudtype.toUpperCase();
			
			System.out.println("isudtype >>> : " + isudtype);
			System.out.println("remoteIP >>> : " + request.getRemoteAddr());
			System.out.println("method >>> : " + request.getMethod());
			
			// 도서 정보 전체 조회
			if ("SALL".equals(isudtype)){
				System.out.println("도서 정보 전체 조회 isudtype >>> : " + isudtype);
				
				// 서비스 호출
				BookService bs = new BookServiceImpl();
				BookVO bvo = null;
				bvo = new BookVO();
				// bvo에 웹브라우저로부터 입력받아서 setter()함수에 초기화해줄 값이 없음.
				// bookSelectAll() 함수가 : ArrayList<BookVO> 의 값을 리턴하므로
				ArrayList<BookVO> aListSA = bs.bookSelectAll();
				
				// aList가 null값 체크부터 해주기
				if (aListSA != null && aListSA.size() > 0){
					// 비어있지 않다면, 정보를 받아서 jsp 파일로 넘겨줘야 함
					// key & value 형태로 내장객체 request에 set(초기화) 해줌
					System.out.println("전체조회 성공 !!!");
					request.setAttribute("aListSA", aListSA);
					RequestDispatcher rd = request.getRequestDispatcher("/jso/book/bookSelectAll.jsp");
					rd.forward(request, response);
				}else{
					System.out.println("전체조회 실패 !!!");
					System.out.println("aListSA가 비었습니다. >>> : " + aListSA.size());
				}
			}
			
			// 도서 정보 조건 조회 : S U D
			if ("S".equals(isudtype) || "U".equals(isudtype) || "D".equals(isudtype)){
				System.out.println("도서정보 조건조회 >>> : ");
				
				String bnum = request.getParameter("bnumCheck");
				// 서비스 호출
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
			
			// 도서 수정
			if ("UOK".equals(isudtype)){
				System.out.println("도서 수정 >>> : ");
				
				// getParameter() 안 하면 데이터가 넘어가지 않음 
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
					System.out.println("파일 업로드 성공 !!");
					bnum = fu.getParameter("bnum");
					bprice = fu.getParameter("bprice");
					bqty = fu.getParameter("bqty");
					
					ArrayList<String> aFileName = fu.getFileNames();
					String bcover_new = aFileName.get(0);
					
					// if ("String" != "String"), if("null" != null) 모두 계속 true 뜸
					// if (String 객체 != null 객체) 비교가 의미 있음 :: 제대로 된 null값 체크
					// 새 파일을 불러서 업로드해야 할 때, FileUpload 형식으로 진행해야 파일 저장 및 불러온 후 출력이 가능하다.
					if (bcover_new != null && bcover_new.length() > 0){
						System.out.println("새 표지 파일 변경 있음 !!");
						bcover = bcover_new;
						
					}else{
						System.out.println("표지 파일 변경 없음!!");
						bcover = fu.getParameter("bcover_old");
					}
				}else{
					System.out.println("파일 업로드 실패 !!");
				}
				System.out.println("bnum >>> : " + bnum);
				System.out.println("bprice >>> : " + bprice);
				System.out.println("bqty >>> : " + bqty);
				System.out.println("bcover >>> : " + bcover);
				
				// 서비스 호출
				BookService bs = new BookServiceImpl();
				BookVO bvo = null;
				bvo = new BookVO();
				// placeholder 바인딩 
				bvo.setBprice(bprice);
				bvo.setBqty(bqty);
				bvo.setBnum(bnum);
				bvo.setBcover(bcover);
				
				int nCntU = bs.bookUpdate(bvo);
				
				if (nCntU > 0){
					System.out.println("수정 성공 !!!");
					
					request.setAttribute("nCntU", nCntU);
					RequestDispatcher rd = request.getRequestDispatcher("/jso/book/bookUpdate.jsp");
					rd.forward(request, response);
				}else{
					System.out.println("수정 실패 !!!");
					out.println("<script>");
					out.println("location.href='/testJso/jso/book?isudtype=SALL'");
					out.println("</script>");
				}
			}
			
			// 도서 삭제
			if ("DOK".equals(isudtype)){
				System.out.println("도서 정보 삭제 >>> : ");
				
				String bnum = request.getParameter("bnum");
				// 서비스 호출
				BookService bs = new BookServiceImpl();
				BookVO bvo = null;
				bvo = new BookVO();
				// placeholder 초기화하기
				bvo.setBnum(bnum);
				
				int nCntD = bs.bookDelete(bvo);
				if (nCntD > 0){
					System.out.println("삭제 성공 !!!");
					// jsp와 연결
					request.setAttribute("nCntD", nCntD);
					RequestDispatcher rd = request.getRequestDispatcher("/jso/book/bookDelete.jsp");
					rd.forward(request, response);
					
				}else{
					System.out.println("삭제 실패 !!!");
					out.println("<script>");
					out.println("location.href='/testJso/book?isudtype=SALL'");
					out.println("</script>");
				}
			}
			
			// 도서 등록
			if ("I".equals(isudtype)){
				System.out.println("도서 정보 등록 isudtype >>> : " + isudtype);
				
				// 사용할 (컬럼명)변수 선언하고 초기화
				String bnum = "";
				String btitle = "";
				String bauth = "";
				String isbn = "";
				String bcomp = "";
				String bprice = "";
				String bqty = "";
				String bcover = "";
				
				// 파일 업로드 확인 : 요청한 정보의 enctype = multipart/form-data 인 지 확인
				boolean fileUploadBool = request.getContentType().toLowerCase().startsWith("multipart/form-data");
				System.out.println("fileUploadBool >>> : " + fileUploadBool);
				
				if (fileUploadBool){
					System.out.println("파일 업로드 루틴 >>> : ");
					
					// 사용할 지역변수 선언하고 초기화
					String filePaths = CommonUtils.BOOK_IMG_UPLOAD_PATH;
					int size_limit = CommonUtils.BOOK_IMG_FILE_SIZE;
					String encode_type = CommonUtils.BOOK_IMG_ENCODE;
					
					// 메모리에 인스턴스
					FileUploadUtil fu = new FileUploadUtil();
					// request + 초기화한 지역변수들 값 대입
					boolean bool = fu.fileUpload3(request, filePaths, size_limit, encode_type);
					// 파일이 정상적으로 들어갔다면 bool = true;
					
					if (bool){
						System.out.println("변수에 파일 정보 저장 >>> : ");
						// (컬럼명)변수에 업로드 된 파일의 정보 담기
						btitle = fu.getParameter("btitle");
						bauth = fu.getParameter("bauth");
						isbn = fu.getParameter("isbn");
						bcomp = fu.getParameter("bcomp");
						bprice = fu.getParameter("bprice");
						bqty = fu.getParameter("bqty");
						// 표지
						// FileUploadUtil.getFileNames()를 ArrayList<String>에 담기
						ArrayList<String> aFileName = fu.getFileNames();
						// 첫번째 요소 출력해서 변수 bcover에 저장
						bcover = aFileName.get(0);
					}else{
						System.out.println("파일 업로드 실패");
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

				// 서비스 호출
				BookService bs = new BookServiceImpl();				
				BookVO bvo = null;
				bvo = new BookVO();
				// placeholder만큼 바인딩
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
					System.out.println("도서 정보 " + " 건 등록되었습니다.");
					
					request.setAttribute("nCnt", new Integer(nCnt));
					RequestDispatcher rd = request.getRequestDispatcher("/jso/book/bookInsert.jsp");
					rd.forward(request, response);
				}else{
					System.out.println("도서 정보 등록 실패 !!!!");
					out.println("<script>");
					out.println("location.href='/testJso/jso/book/book.html'");
					out.println("</script>");
				}
			}
		}else{
			System.out.println("isudtype을 잘 보내시오 !!!");
		}
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		System.out.println("BookController doPost() 함수 진입 >>> : ");
		doGet(request, response);
	}

}
