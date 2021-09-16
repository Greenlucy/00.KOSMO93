package a.b.c.com.jso.board.controller;

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

import a.b.c.com.common.CommonUtils;
import a.b.c.com.common.GetChabun;
import a.b.c.com.jso.board.service.BoardService;
import a.b.c.com.jso.board.service.BoardServiceImpl;
import a.b.c.com.jso.board.vo.BoardVO;


@WebServlet("/board")
public class BoardController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	// [1]
	// public interface HttpServletRequest extends ServletRequest :: to provide request information for HTTP servlets.
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		// [1-1]
		System.out.println("BoardController doGet() 함수 진입 >>> : ");
		
		request.setCharacterEncoding("EUC-KR");
		response.setCharacterEncoding("EUC-KR");
		response.setContentType("text/html; charset=EUC-KR");
		PrintWriter out = response.getWriter();
		// [1-2] board.html로부터 name=ISUD_TYPE, value 받아서 변수 isudType에 저장
		String isudType = request.getParameter("ISUD_TYPE");
		
		if (isudType != null && isudType.length() > 0){
			isudType = isudType.toUpperCase();
			
			// [2]
			// 글등록------------------------------------------------------------
			if ("I".equals(isudType)){
				// [3]
				System.out.println("게시판 글 등록 isudType >>> : " + isudType);
				// [4] CommonUtils 클래스 다녀옴
				String saveDirectory = CommonUtils.BOARD_IMG_UPLOAD_PATH;
				int maxPostSize = CommonUtils.BOARD_IMG_FILE_SIZE;
				String encoding = CommonUtils.BOARD_IMG_ENCODE;
				
				// [6]
				// 파일 잘 넘어오는지 확인하는 코드 : 요청할 때 사용한 컨텐트의 타입 시작이 "multipart/form-data"로 시작하는지 확인하는 함수
				/* String javax.servlet.SerlvletRequest.getContentType()
					java.lang.String getContentType()
				 	: request의 MIME 타입의 name을 포함한 String을 return함. 또는 타입이 알려지지 않은 것일 때, null을 return함.
					: 클라이언트가 요청한 정보를 전송할 때 사용한 컨텐트의 타입을 구한다. */ 
				// public boolean startsWith(String prefix)
				//	: startsWith() 함수는 대상 문자열이 특정 문자 또는 문자열로 시작하는지 체크하는 함수이다.
				// reqeust : 들어온 스트림.. 중에 ~
				boolean bool = request.getContentType().toLowerCase().startsWith("multipart/form-data");
				if (bool){
					System.out.println("게시판 글 등록 파일업로드 루틴 :: bool >>> : " + bool);
				}
				// [7] MultipartReuqest 클래스 인스턴스
				MultipartRequest mr = new MultipartRequest( request
															,saveDirectory
															,maxPostSize
															,encoding
															,new DefaultFileRenamePolicy());
				// [8] 브라우저에서 입력한 값 받아서 지역변수에 저장
				// 지역변수 선언, 초기화 (placeholder만큼)
				
				// form태그의  input태그의 name을 전송한 거
				String bsubject = mr.getParameter("bsubject");
				String bwriter = mr.getParameter("bwriter");
				String bpw = mr.getParameter("bpw");
				String bmemo = mr.getParameter("bmemo");
				// 사진
				// String bphoto = mr.getParameter("bphoto");
				Enumeration<String> e = mr.getFileNames();
				String imgName = e.nextElement();
				String bphoto = mr.getFilesystemName(imgName);
				
				// [9] 이클립스 콘솔에 출력 (지역변수에 저장 잘 되었는지 확인 용도)
				System.out.println("bsubject >>> : " + bsubject);
				System.out.println("bwriter >>> : " + bwriter);
				System.out.println("bpw >>> : " + bpw);
				System.out.println("bmemo >>> : " + bmemo);
				System.out.println("bphoto >>> : " + bphoto);
				
				try{
					// [10] BoardServiceImpl 클래스 인스턴스
					// 서비스 호출하기
					
					BoardService bs = new BoardServiceImpl();
					
					// [40] BoardVO 초기화하고 클래스 인스턴스
					BoardVO bvo = null;
					bvo = new BoardVO();
					
					// [41] 깡통클래스의 setter()설정자 함수 호출, 아규먼트 입력하여 bvo에 저장
					// SqlMap에 내가 설정한 placeholder들에 대해 setter()함수 사용  
					bvo.setBnum(GetChabun.getBoardChabun("n"));
					bvo.setBsubject(bsubject);
					bvo.setBwriter(bwriter);
					bvo.setBpw(bpw);
					bvo.setBmemo(bmemo);
					bvo.setBphoto(bphoto);
					
					// [42]
					// boolean 데이터형 bInsert 참조변수에
					// 호출한 서비스로부터 부른 boardInsert()함수의 아규먼트로 bvo를 입력하여 return값을 저장  
					boolean bInsert = bs.boardInsert(bvo);
					
					//boolean bInsert = this.boardService.boardInsert(bvo);
					
					// [43]
					// bInsert = true (리턴받은 값이 true)
					if (bInsert){
						// [44]
						// HttpServletRequest request > void setAttribute(java.lang.String name, java.lang.Object o) : Stores an "attribute" in this request. 
						// :: 데이터 저장시 사용
						request.setAttribute("bInsert", new Boolean(bInsert));
						
						// [45] ServletReqeust.getRequestDispatcher(경로)
						// RequestDispatcher 인터페이스에서 사용하는 getRequestDispatcher 함수에서는   // context 경로를 사용하지 않음
						/* public Interface RequestDispatcher 
						   :: 클라이언트로부터 request들을 받고 서버에 있는 any resource(servlet, HTML file, JSP file)에 request들을 보내는 객체를 정의한다. */ 
						/* RequestDispatcher getRequestDispatcher(java.lang.String path) : 리턴값이 RequestDispatcher 객체. 
							:: 주어진 경로에 위치한 resource에 대해 wrapper처럼 행동하는 RequestDispatcher 객체를 return한다. RequestDispatcher 리턴하지 못 하면 null값 리턴. */
						RequestDispatcher rd = request.getRequestDispatcher("/jso/board/boardInsert.jsp");
						
						// [46] RequestDispathcer forward()함수 호출  / forward : 보내다, 전달하다(사전적 의미)
						// void forward(ServletRequest request, ServletResponse response) throws ServletException, java.io.IOException
						// 매개변수 : request - a ServletRequest object that represents the request the client makes of the servlet
						// 			response - a ServletResponse object that represents the response the servlet returns to the client
						rd.forward(request, response);
					}else{
						// 서블릿에서 <script> 안에 써야하기 때문에 out.println("")형태로 써줘야 함
						// jsp에서 <% %> 안에 쓰는거랑 똑같음
						out.println("<script>");
						out.println("location.href='/testJso/jso/board/board.html'");
						out.println("</script>");
					}
				}catch(Exception e1){
					System.out.println("게시글 등록 중 에러가 >>> :" + e1);
				}
			}
			// [51]
			// 글전체조회---------------------------------------------------------
			if ("SALL".equals(isudType)){
				// [52] 출력
				System.out.println("게시판 글전체조회 isudType >>> : " + isudType);
				
				// [53]
				// 서비스 호출
				BoardService bs = new BoardServiceImpl();
				
				// [54]
				ArrayList<BoardVO> aListAll = bs.boardSelectAll();
				
				// [71]
				if (aListAll != null && aListAll.size() > 0){
					// [72] (제대로 돌아간다면) 전체 등록 건 수 출력
					System.out.println("aListAll.size >>> : " + aListAll.size());
					try{
						// [73]
						// key & value 설정 : setAttribute >> boardSelectAll.jsp와 연결될 부분
						// (이렇게 중요한 부분을 빼먹어서 boardSelectAll.jsp의 <% %>부터 코드가 막혀서 html요소가 화면에 출력이 안 됌.)
						request.setAttribute("aListAll", aListAll);	
						// [74] 경로 설정
						RequestDispatcher rd = request.getRequestDispatcher("/jso/board/boardSelectAll.jsp");
						// [75] 경로로 이동
						rd.forward(request, response);
					}catch(Exception e){
						System.out.println("boardSelectAll.jsp로 안 넘어가집니다." + e);
					}
				}else{
					out.println("<script>");
					out.println("location.href='/testJso/jso/board/board.html'");
					out.println("</script>");
				}
			}
			// 글조건조회 : S U D ------------------------------------------------
			if ("S".equals(isudType) || "U".equals(isudType) || "D".equals(isudType)){
				System.out.println("글 조건조회 isudType >>> : " + isudType);
				
				String bnum = request.getParameter("bnumCheck");
				if (bnum != null && bnum.length() > 0){
					System.out.println("글 번호 >>> : " + bnum);
					
					// 서비스 호출
					BoardService bs = new BoardServiceImpl();  //클래스를 인터페이스로 캐스팅 한다. 상속 개념.
					BoardVO bvo = null;
					bvo = new BoardVO();
					// placeholder set함수로 초기화해주기
					bvo.setBnum(bnum);
					ArrayList<BoardVO> aListS = bs.boardSelect(bvo);
					
					if (aListS != null && aListS.size() > 0){
						System.out.println("aListS.size() >>> : " + aListS.size());
						// 변수에 담는 것이 아니라 key, value 설정하는 것
						request.setAttribute("aListS", aListS);
						RequestDispatcher rd = request.getRequestDispatcher("/jso/board/boardSelect.jsp");
						rd.forward(request, response);
					}
				}else{
					System.out.println("실패 >>> : bnum이 null입니다.");
				}
				
			}
			// 글수정 : UOK -----------------------------------------------------
			if ("UOK".equals(isudType)){
				System.out.println("글 수정 isudType >>> : " + isudType);
				
				// 사용할 객체 지역변수로 선언, 초기화
				String bnum = request.getParameter("bnum");
				String bmemo = request.getParameter("bsubject");
				String bsubject = request.getParameter("bmemo");
				System.out.println("bnum >>> : " + bnum);
				System.out.println("bsubject >>> : " + bsubject);
				System.out.println("bmemo >>> : " + bmemo);
				
				// 서비스 호출
				BoardService bs = new BoardServiceImpl();
				BoardVO bvo = null;
				bvo = new BoardVO();
				
				bvo.setBnum(bnum);
				bvo.setBsubject(bsubject);
				bvo.setBmemo(bmemo);
				
				boolean bUpdate = bs.boardUpdate(bvo);
				if (bUpdate){	
					request.setAttribute("bUpdate", new Boolean(bUpdate));
					RequestDispatcher rd = request.getRequestDispatcher("/jso/board/boardUpdate.jsp");
					rd.forward(request, response);
				}else{
					System.out.println("글 수정 실패 !!!");
					out.println("<script>");
					out.println("alert('글 수정 실패')");
					out.println("location.href='/testJso/board?isudtype=SALL'");
					out.println("</script>");
				}
			}
			// 글삭제 : DOK -----------------------------------------------------
			if ("D".equals(isudType)){
				System.out.println("글 삭제 isduType >>> : " + isudType);
				
				String bnum = request.getParameter("bnum");
				
				// 서비스 호출
				BoardService bs = new BoardServiceImpl();
				BoardVO bvo = null;
				bvo = new BoardVO();
				
				bvo.setBnum(bnum);
				
				boolean boolD = bs.boardDelete(bvo);
				
				if (boolD) {
					request.setAttribute("boolD", boolD);
					RequestDispatcher rd = request.getRequestDispatcher("");
					rd.forward(request, response);					
				}
			}
		}else{
			System.out.println("form 태그에서 hidden 타입의 ISUD_TYPE 잘 넘기세요 !!! ");
		}
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		// [0-5]
		System.out.println("BoardController doPost() 함수 진입 >>> : ");
		doGet(request, response);
	}

}
