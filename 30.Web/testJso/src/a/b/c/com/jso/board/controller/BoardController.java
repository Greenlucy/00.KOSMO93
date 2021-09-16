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
		System.out.println("BoardController doGet() �Լ� ���� >>> : ");
		
		request.setCharacterEncoding("EUC-KR");
		response.setCharacterEncoding("EUC-KR");
		response.setContentType("text/html; charset=EUC-KR");
		PrintWriter out = response.getWriter();
		// [1-2] board.html�κ��� name=ISUD_TYPE, value �޾Ƽ� ���� isudType�� ����
		String isudType = request.getParameter("ISUD_TYPE");
		
		if (isudType != null && isudType.length() > 0){
			isudType = isudType.toUpperCase();
			
			// [2]
			// �۵��------------------------------------------------------------
			if ("I".equals(isudType)){
				// [3]
				System.out.println("�Խ��� �� ��� isudType >>> : " + isudType);
				// [4] CommonUtils Ŭ���� �ٳ��
				String saveDirectory = CommonUtils.BOARD_IMG_UPLOAD_PATH;
				int maxPostSize = CommonUtils.BOARD_IMG_FILE_SIZE;
				String encoding = CommonUtils.BOARD_IMG_ENCODE;
				
				// [6]
				// ���� �� �Ѿ������ Ȯ���ϴ� �ڵ� : ��û�� �� ����� ����Ʈ�� Ÿ�� ������ "multipart/form-data"�� �����ϴ��� Ȯ���ϴ� �Լ�
				/* String javax.servlet.SerlvletRequest.getContentType()
					java.lang.String getContentType()
				 	: request�� MIME Ÿ���� name�� ������ String�� return��. �Ǵ� Ÿ���� �˷����� ���� ���� ��, null�� return��.
					: Ŭ���̾�Ʈ�� ��û�� ������ ������ �� ����� ����Ʈ�� Ÿ���� ���Ѵ�. */ 
				// public boolean startsWith(String prefix)
				//	: startsWith() �Լ��� ��� ���ڿ��� Ư�� ���� �Ǵ� ���ڿ��� �����ϴ��� üũ�ϴ� �Լ��̴�.
				// reqeust : ���� ��Ʈ��.. �߿� ~
				boolean bool = request.getContentType().toLowerCase().startsWith("multipart/form-data");
				if (bool){
					System.out.println("�Խ��� �� ��� ���Ͼ��ε� ��ƾ :: bool >>> : " + bool);
				}
				// [7] MultipartReuqest Ŭ���� �ν��Ͻ�
				MultipartRequest mr = new MultipartRequest( request
															,saveDirectory
															,maxPostSize
															,encoding
															,new DefaultFileRenamePolicy());
				// [8] ���������� �Է��� �� �޾Ƽ� ���������� ����
				// �������� ����, �ʱ�ȭ (placeholder��ŭ)
				
				// form�±���  input�±��� name�� ������ ��
				String bsubject = mr.getParameter("bsubject");
				String bwriter = mr.getParameter("bwriter");
				String bpw = mr.getParameter("bpw");
				String bmemo = mr.getParameter("bmemo");
				// ����
				// String bphoto = mr.getParameter("bphoto");
				Enumeration<String> e = mr.getFileNames();
				String imgName = e.nextElement();
				String bphoto = mr.getFilesystemName(imgName);
				
				// [9] ��Ŭ���� �ֿܼ� ��� (���������� ���� �� �Ǿ����� Ȯ�� �뵵)
				System.out.println("bsubject >>> : " + bsubject);
				System.out.println("bwriter >>> : " + bwriter);
				System.out.println("bpw >>> : " + bpw);
				System.out.println("bmemo >>> : " + bmemo);
				System.out.println("bphoto >>> : " + bphoto);
				
				try{
					// [10] BoardServiceImpl Ŭ���� �ν��Ͻ�
					// ���� ȣ���ϱ�
					
					BoardService bs = new BoardServiceImpl();
					
					// [40] BoardVO �ʱ�ȭ�ϰ� Ŭ���� �ν��Ͻ�
					BoardVO bvo = null;
					bvo = new BoardVO();
					
					// [41] ����Ŭ������ setter()������ �Լ� ȣ��, �ƱԸ�Ʈ �Է��Ͽ� bvo�� ����
					// SqlMap�� ���� ������ placeholder�鿡 ���� setter()�Լ� ���  
					bvo.setBnum(GetChabun.getBoardChabun("n"));
					bvo.setBsubject(bsubject);
					bvo.setBwriter(bwriter);
					bvo.setBpw(bpw);
					bvo.setBmemo(bmemo);
					bvo.setBphoto(bphoto);
					
					// [42]
					// boolean �������� bInsert ����������
					// ȣ���� ���񽺷κ��� �θ� boardInsert()�Լ��� �ƱԸ�Ʈ�� bvo�� �Է��Ͽ� return���� ����  
					boolean bInsert = bs.boardInsert(bvo);
					
					//boolean bInsert = this.boardService.boardInsert(bvo);
					
					// [43]
					// bInsert = true (���Ϲ��� ���� true)
					if (bInsert){
						// [44]
						// HttpServletRequest request > void setAttribute(java.lang.String name, java.lang.Object o) : Stores an "attribute" in this request. 
						// :: ������ ����� ���
						request.setAttribute("bInsert", new Boolean(bInsert));
						
						// [45] ServletReqeust.getRequestDispatcher(���)
						// RequestDispatcher �������̽����� ����ϴ� getRequestDispatcher �Լ�������   // context ��θ� ������� ����
						/* public Interface RequestDispatcher 
						   :: Ŭ���̾�Ʈ�κ��� request���� �ް� ������ �ִ� any resource(servlet, HTML file, JSP file)�� request���� ������ ��ü�� �����Ѵ�. */ 
						/* RequestDispatcher getRequestDispatcher(java.lang.String path) : ���ϰ��� RequestDispatcher ��ü. 
							:: �־��� ��ο� ��ġ�� resource�� ���� wrapperó�� �ൿ�ϴ� RequestDispatcher ��ü�� return�Ѵ�. RequestDispatcher �������� �� �ϸ� null�� ����. */
						RequestDispatcher rd = request.getRequestDispatcher("/jso/board/boardInsert.jsp");
						
						// [46] RequestDispathcer forward()�Լ� ȣ��  / forward : ������, �����ϴ�(������ �ǹ�)
						// void forward(ServletRequest request, ServletResponse response) throws ServletException, java.io.IOException
						// �Ű����� : request - a ServletRequest object that represents the request the client makes of the servlet
						// 			response - a ServletResponse object that represents the response the servlet returns to the client
						rd.forward(request, response);
					}else{
						// �������� <script> �ȿ� ����ϱ� ������ out.println("")���·� ����� ��
						// jsp���� <% %> �ȿ� ���°Ŷ� �Ȱ���
						out.println("<script>");
						out.println("location.href='/testJso/jso/board/board.html'");
						out.println("</script>");
					}
				}catch(Exception e1){
					System.out.println("�Խñ� ��� �� ������ >>> :" + e1);
				}
			}
			// [51]
			// ����ü��ȸ---------------------------------------------------------
			if ("SALL".equals(isudType)){
				// [52] ���
				System.out.println("�Խ��� ����ü��ȸ isudType >>> : " + isudType);
				
				// [53]
				// ���� ȣ��
				BoardService bs = new BoardServiceImpl();
				
				// [54]
				ArrayList<BoardVO> aListAll = bs.boardSelectAll();
				
				// [71]
				if (aListAll != null && aListAll.size() > 0){
					// [72] (����� ���ư��ٸ�) ��ü ��� �� �� ���
					System.out.println("aListAll.size >>> : " + aListAll.size());
					try{
						// [73]
						// key & value ���� : setAttribute >> boardSelectAll.jsp�� ����� �κ�
						// (�̷��� �߿��� �κ��� ���Ծ boardSelectAll.jsp�� <% %>���� �ڵ尡 ������ html��Ұ� ȭ�鿡 ����� �� ��.)
						request.setAttribute("aListAll", aListAll);	
						// [74] ��� ����
						RequestDispatcher rd = request.getRequestDispatcher("/jso/board/boardSelectAll.jsp");
						// [75] ��η� �̵�
						rd.forward(request, response);
					}catch(Exception e){
						System.out.println("boardSelectAll.jsp�� �� �Ѿ���ϴ�." + e);
					}
				}else{
					out.println("<script>");
					out.println("location.href='/testJso/jso/board/board.html'");
					out.println("</script>");
				}
			}
			// ��������ȸ : S U D ------------------------------------------------
			if ("S".equals(isudType) || "U".equals(isudType) || "D".equals(isudType)){
				System.out.println("�� ������ȸ isudType >>> : " + isudType);
				
				String bnum = request.getParameter("bnumCheck");
				if (bnum != null && bnum.length() > 0){
					System.out.println("�� ��ȣ >>> : " + bnum);
					
					// ���� ȣ��
					BoardService bs = new BoardServiceImpl();  //Ŭ������ �������̽��� ĳ���� �Ѵ�. ��� ����.
					BoardVO bvo = null;
					bvo = new BoardVO();
					// placeholder set�Լ��� �ʱ�ȭ���ֱ�
					bvo.setBnum(bnum);
					ArrayList<BoardVO> aListS = bs.boardSelect(bvo);
					
					if (aListS != null && aListS.size() > 0){
						System.out.println("aListS.size() >>> : " + aListS.size());
						// ������ ��� ���� �ƴ϶� key, value �����ϴ� ��
						request.setAttribute("aListS", aListS);
						RequestDispatcher rd = request.getRequestDispatcher("/jso/board/boardSelect.jsp");
						rd.forward(request, response);
					}
				}else{
					System.out.println("���� >>> : bnum�� null�Դϴ�.");
				}
				
			}
			// �ۼ��� : UOK -----------------------------------------------------
			if ("UOK".equals(isudType)){
				System.out.println("�� ���� isudType >>> : " + isudType);
				
				// ����� ��ü ���������� ����, �ʱ�ȭ
				String bnum = request.getParameter("bnum");
				String bmemo = request.getParameter("bsubject");
				String bsubject = request.getParameter("bmemo");
				System.out.println("bnum >>> : " + bnum);
				System.out.println("bsubject >>> : " + bsubject);
				System.out.println("bmemo >>> : " + bmemo);
				
				// ���� ȣ��
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
					System.out.println("�� ���� ���� !!!");
					out.println("<script>");
					out.println("alert('�� ���� ����')");
					out.println("location.href='/testJso/board?isudtype=SALL'");
					out.println("</script>");
				}
			}
			// �ۻ��� : DOK -----------------------------------------------------
			if ("D".equals(isudType)){
				System.out.println("�� ���� isduType >>> : " + isudType);
				
				String bnum = request.getParameter("bnum");
				
				// ���� ȣ��
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
			System.out.println("form �±׿��� hidden Ÿ���� ISUD_TYPE �� �ѱ⼼�� !!! ");
		}
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		// [0-5]
		System.out.println("BoardController doPost() �Լ� ���� >>> : ");
		doGet(request, response);
	}

}
