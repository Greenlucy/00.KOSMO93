package a.b.c.com.kosmo.board.controller;

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
import a.b.c.com.kosmo.board.service.BoardService;
import a.b.c.com.kosmo.board.service.BoardServiceImpl;
import a.b.c.com.kosmo.board.vo.BoardVO;
import a.b.c.com.kosmo.book.service.BookService;
import a.b.c.com.kosmo.book.service.BookServiceImpl;
import a.b.c.com.kosmo.book.vo.BookVO;

@WebServlet("/board")
public class BoardController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@SuppressWarnings("unchecked")
	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
		throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		request.setCharacterEncoding("EUC-KR");
		response.setCharacterEncoding("EUC-KR");
		response.setContentType("text/html; charset=EUC-KR");
		PrintWriter out = response.getWriter();
		
		String isudType = request.getParameter("ISUD_TYPE");
		
		if (isudType !=null && isudType.length() > 0){
			isudType = isudType.toUpperCase();
			
			// 글등록 ------------------------------------------------------------------------
			if ("I".equals(isudType)){
				System.out.println("게시판 글 등록 isudType >>> : " + isudType);
				
				 String saveDirectory = CommonUtils.BOARD_IMG_UPLOAD_PATH;
                 int maxPostSize = CommonUtils.BOARD_IMG_FILE_SIZE;
                 String  encoding = CommonUtils.BOOK_IMG_ENCODE;
				
				
				boolean bool = request.getContentType().toLowerCase().startsWith("multipart/form-data");				
				if (bool){
					System.out.println("게시판 글 등록 파일업로드 루틴 :: bool >>> : " + bool);
					
					try {
						MultipartRequest mr = new MultipartRequest(  request  
													                ,saveDirectory
													                ,maxPostSize
													                ,encoding
													                ,new DefaultFileRenamePolicy());
						
						String bsubject = mr.getParameter("bsubject");
						String bwriter = mr.getParameter("bwriter");
						String bpw = mr.getParameter("bpw");
						String bmemo = mr.getParameter("bmemo");
						// 사진
						// String bphoto = mr.getParameter("bsubject");
						Enumeration<String> e = mr.getFileNames();
						String imgName = e.nextElement();
						String bphoto = mr.getFilesystemName(imgName);
						
						System.out.println("bsubject >>> : " + bsubject);
						System.out.println("bwriter >>> : " + bwriter);
						System.out.println("bpw >>> : " + bpw);
						System.out.println("bmemo >>> : " + bmemo);					
						System.out.println("bphoto >>> : " + bphoto);
						
						// 서비스 호출하기 
						BoardService bs = new BoardServiceImpl();
						BoardVO bvo = null;
						bvo = new BoardVO();
						
						String bnum = GetChabun.getBoardChabun("N");
						System.out.println("bnum >>> : " + bnum);
						bvo.setBnum(bnum);
						bvo.setBsubject(bsubject);
						bvo.setBwriter(bwriter);
						bvo.setBpw(bpw);
						bvo.setBmemo(bmemo);
						bvo.setBphoto(bphoto);
						
						boolean bInsert = bs.boardInsert(bvo);
						
						if (bInsert){						
							request.setAttribute("bInsert", new Boolean(bInsert));				
							// RequestDispatcher 인터페이스 에서 사용하는 getRequestDispatcher 함수에서는 
							// Context 경로를 사용하지  않음								
							RequestDispatcher rd = request.getRequestDispatcher("/kosmo/board/boardInsert.jsp");
							rd.forward(request, response);						
						}else{
							out.println("<script>");				
							out.println("location.href='/testKosmo/kosmo/board/board.html'");
							out.println("</script>");
						}
						
					}catch(Exception e){
						System.out.println("게시글 등록 중 에러가 >>> :" + e.getMessage());
					}
					
				}				
			} // 글등록 end 
			
			// 글 전체조회 ---------------------------------------------------------------------
			if ("SALL".equals(isudType)){
				System.out.println("게시판 글 전체조회 isudType >>> : " + isudType);
				
				// 서비스 호출하기 
				BoardService bs = new BoardServiceImpl();
				ArrayList<BoardVO> aListAll = bs.boardSelectAll();
				
				if (aListAll !=null && aListAll.size() > 0) {
					
					request.setAttribute("aListAll", aListAll);					
					RequestDispatcher rd= request.getRequestDispatcher("/kosmo/board/boardSelectAll.jsp");
					rd.forward(request, response);
					
				}else {
					out.println("<script>");					
					out.println("location.href='/testKosmo/board?ISUD_TYPE=SALL'");
					out.println("</script>");
				}		
			}
			
			// 글 조건조회 : S U D --------------------------------------------------------------------- 
			if ("S".equals(isudType) || "U".equals(isudType) || "D".equals(isudType)){
				System.out.println("글 조건조회 : S U D isudType >>> : " + isudType);

				String bnum = request.getParameter("bnumCheck");				
				if (bnum !=null && bnum.length() > 0){
					System.out.println("글 번호 >>> :  " + bnum);
					
					BoardService bs = new BoardServiceImpl();				
					BoardVO bvo = null;
					bvo = new BoardVO();
					
					bvo.setBnum(bnum);					
					ArrayList<BoardVO> aListS = bs.boardSelect(bvo);
					
					if (aListS !=null && aListS.size() > 0) {
						System.out.println("aListS.size() >>> : " + aListS.size());						
						request.setAttribute("aListS", aListS);					
						RequestDispatcher rd= request.getRequestDispatcher("/kosmo/board/boardSelect.jsp");
						rd.forward(request, response);
						
					}else {
						out.println("<script>");
						out.println("alert('글 조회 실패')");
						out.println("location.href='/testKosmo/board?ISUD_TYPE=SALL'");
						out.println("</script>");
					}									
				}else{
					System.out.println("글번호가  없습니다. ");
				}		
			}
			
			// 글 수정 ------------------------------------------------------------------------
			if ("UOK".equals(isudType)){
				System.out.println("글 수정 isudType >>> : " + isudType);
				
				String bnum = request.getParameter("bnum");
				String bsubject = request.getParameter("bsubject");
				String bmemo = request.getParameter("bmemo");				
				System.out.println("bnum >>> : " + bnum);
				System.out.println("bsubject >>> : " + bsubject);
				System.out.println("bmemo >>> : " + bmemo);
				
				BoardService bs = new BoardServiceImpl();				
				BoardVO bvo = null;
				bvo = new BoardVO();
				
				bvo.setBnum(bnum);
				bvo.setBsubject(bsubject);
				bvo.setBmemo(bmemo);
				
				boolean bUpdate = bs.boardUpdate(bvo);
				
				if (bUpdate) {
					System.out.println("글 정보가  수정 되었습니다." + bUpdate);					
					request.setAttribute("bUpdate", new Boolean(bUpdate));										
					RequestDispatcher rd= request.getRequestDispatcher("/kosmo/board/boardUpdate.jsp");
					rd.forward(request, response);
					
				}else {
					System.out.println("글 수정 실패 !!!!");
					out.println("<script>");	
					out.println("alert('글 수정 실패')");
					out.println("location.href='/testKosmo/board?isudtype=SALL'");
					out.println("</script>");
				}
			}
			
			// 글 삭제 ------------------------------------------------------------------------
			if ("DOK".equals(isudType)){
				System.out.println("글 삭제 isudType >>> : " + isudType);
				
				String bnum = request.getParameter("bnum");
				System.out.println("bnum >>> : " + bnum);
				
				BoardService bs = new BoardServiceImpl();				
				BoardVO bvo = null;
				bvo = new BoardVO();
				
				bvo.setBnum(bnum);

				boolean bDelete = bs.boardDelete(bvo);
				
				if (bDelete) {
					System.out.println("글 정보가  삭제 되었습니다." + bDelete);					
					request.setAttribute("bDelete", new Boolean(bDelete));										
					RequestDispatcher rd= request.getRequestDispatcher("/kosmo/board/boardDelete.jsp");
					rd.forward(request, response);
					
				}else {
					System.out.println("글 삭제 실패 !!!!");
					out.println("<script>");			
					out.println("alert('글 수정 실패')");
					out.println("location.href='/testKosmo/board?isudtype=SALL'");
					out.println("</script>");
				}
			}
		}else{
			System.out.println("form 태그에서 hidden 타입의 ISUD_TYPE 잘 넘기세요 >>> : ");
		}		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}
}
