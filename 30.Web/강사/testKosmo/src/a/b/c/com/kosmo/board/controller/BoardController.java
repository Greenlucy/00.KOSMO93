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
			
			// �۵�� ------------------------------------------------------------------------
			if ("I".equals(isudType)){
				System.out.println("�Խ��� �� ��� isudType >>> : " + isudType);
				
				 String saveDirectory = CommonUtils.BOARD_IMG_UPLOAD_PATH;
                 int maxPostSize = CommonUtils.BOARD_IMG_FILE_SIZE;
                 String  encoding = CommonUtils.BOOK_IMG_ENCODE;
				
				
				boolean bool = request.getContentType().toLowerCase().startsWith("multipart/form-data");				
				if (bool){
					System.out.println("�Խ��� �� ��� ���Ͼ��ε� ��ƾ :: bool >>> : " + bool);
					
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
						// ����
						// String bphoto = mr.getParameter("bsubject");
						Enumeration<String> e = mr.getFileNames();
						String imgName = e.nextElement();
						String bphoto = mr.getFilesystemName(imgName);
						
						System.out.println("bsubject >>> : " + bsubject);
						System.out.println("bwriter >>> : " + bwriter);
						System.out.println("bpw >>> : " + bpw);
						System.out.println("bmemo >>> : " + bmemo);					
						System.out.println("bphoto >>> : " + bphoto);
						
						// ���� ȣ���ϱ� 
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
							// RequestDispatcher �������̽� ���� ����ϴ� getRequestDispatcher �Լ������� 
							// Context ��θ� �������  ����								
							RequestDispatcher rd = request.getRequestDispatcher("/kosmo/board/boardInsert.jsp");
							rd.forward(request, response);						
						}else{
							out.println("<script>");				
							out.println("location.href='/testKosmo/kosmo/board/board.html'");
							out.println("</script>");
						}
						
					}catch(Exception e){
						System.out.println("�Խñ� ��� �� ������ >>> :" + e.getMessage());
					}
					
				}				
			} // �۵�� end 
			
			// �� ��ü��ȸ ---------------------------------------------------------------------
			if ("SALL".equals(isudType)){
				System.out.println("�Խ��� �� ��ü��ȸ isudType >>> : " + isudType);
				
				// ���� ȣ���ϱ� 
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
			
			// �� ������ȸ : S U D --------------------------------------------------------------------- 
			if ("S".equals(isudType) || "U".equals(isudType) || "D".equals(isudType)){
				System.out.println("�� ������ȸ : S U D isudType >>> : " + isudType);

				String bnum = request.getParameter("bnumCheck");				
				if (bnum !=null && bnum.length() > 0){
					System.out.println("�� ��ȣ >>> :  " + bnum);
					
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
						out.println("alert('�� ��ȸ ����')");
						out.println("location.href='/testKosmo/board?ISUD_TYPE=SALL'");
						out.println("</script>");
					}									
				}else{
					System.out.println("�۹�ȣ��  �����ϴ�. ");
				}		
			}
			
			// �� ���� ------------------------------------------------------------------------
			if ("UOK".equals(isudType)){
				System.out.println("�� ���� isudType >>> : " + isudType);
				
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
					System.out.println("�� ������  ���� �Ǿ����ϴ�." + bUpdate);					
					request.setAttribute("bUpdate", new Boolean(bUpdate));										
					RequestDispatcher rd= request.getRequestDispatcher("/kosmo/board/boardUpdate.jsp");
					rd.forward(request, response);
					
				}else {
					System.out.println("�� ���� ���� !!!!");
					out.println("<script>");	
					out.println("alert('�� ���� ����')");
					out.println("location.href='/testKosmo/board?isudtype=SALL'");
					out.println("</script>");
				}
			}
			
			// �� ���� ------------------------------------------------------------------------
			if ("DOK".equals(isudType)){
				System.out.println("�� ���� isudType >>> : " + isudType);
				
				String bnum = request.getParameter("bnum");
				System.out.println("bnum >>> : " + bnum);
				
				BoardService bs = new BoardServiceImpl();				
				BoardVO bvo = null;
				bvo = new BoardVO();
				
				bvo.setBnum(bnum);

				boolean bDelete = bs.boardDelete(bvo);
				
				if (bDelete) {
					System.out.println("�� ������  ���� �Ǿ����ϴ�." + bDelete);					
					request.setAttribute("bDelete", new Boolean(bDelete));										
					RequestDispatcher rd= request.getRequestDispatcher("/kosmo/board/boardDelete.jsp");
					rd.forward(request, response);
					
				}else {
					System.out.println("�� ���� ���� !!!!");
					out.println("<script>");			
					out.println("alert('�� ���� ����')");
					out.println("location.href='/testKosmo/board?isudtype=SALL'");
					out.println("</script>");
				}
			}
		}else{
			System.out.println("form �±׿��� hidden Ÿ���� ISUD_TYPE �� �ѱ⼼�� >>> : ");
		}		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}
}
