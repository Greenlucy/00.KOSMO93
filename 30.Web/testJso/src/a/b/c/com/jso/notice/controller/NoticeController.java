package a.b.c.com.jso.notice.controller;

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
import a.b.c.com.jso.mem.vo.MemberVO;
import a.b.c.com.jso.notice.service.NoticeService;
import a.b.c.com.jso.notice.service.NoticeServiceImpl;
import a.b.c.com.jso.notice.vo.NoticeVO;

@WebServlet("/notice")
public class NoticeController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		System.out.println("NoticeController doGet() 함수 진입 >>> : ");
		
		request.setCharacterEncoding("EUC-KR");
		response.setCharacterEncoding("EUC-KR");
		response.setContentType("text/html; charset=EUC-KR;"); 
		PrintWriter out = response.getWriter();
		String isudType = request.getParameter("ISUD_TYPE");
		
		if (isudType != null && isudType.length() > 0){
			// 입력
			if ("I".equals(isudType)) {
				System.out.println("입력 isudType >>> : " + isudType);
				
				FileUploadUtil fu = new FileUploadUtil();
//				public boolean fileUpload3(HttpServletRequest hReq, String filePaths, int size_limit, String encode_type){
				String filePaths = CommonUtils.NOTICE_IMG_UPLOAD_PATH;
				int size_limit = CommonUtils.NOTICE_IMG_SIZE_LIMIT;
				String encode_type = CommonUtils.NOTICE_IMG_ENCODE;
				boolean boolF = fu.fileUpload3(request, filePaths, size_limit, encode_type);
				
				if (boolF){
					String nnum = GetChabun.getNoticeChabun("d");
					String nsubject = fu.getParameter("nsubject");
					String nmemo = fu.getParameter("nmemo");
					String nphoto = fu.getFileName("nphoto");
					
					// 서비스 호출
					NoticeService ns = new NoticeServiceImpl();
					// 웹브라우저로부터 입력받은 데이터 set 저장할 수 있게 밑작업
					NoticeVO nvo = null;
					nvo = new NoticeVO();
					nvo.setNnum(nnum);
					nvo.setNsubject(nsubject);
					nvo.setNmemo(nmemo);
					nvo.setNphoto(nphoto);
					NoticeVO.printlnNoticeVO(nvo);
					
					int nCntI = ns.noticeInsert(nvo);
					if (nCntI > 0){
						System.out.println("등록 성공 !!");
						request.setAttribute("nCntI", new Integer(nCntI));
						RequestDispatcher rd = request.getRequestDispatcher("/jso/notice/noticeInsert.jsp");
						rd.forward(request, response);
					}else{
						System.out.println("등록 실패 !!");
						out.println("<script>");
						out.println("location.href='/testJso/jso/notice/notice.html'");
						out.println("</script>");
					}
				}
				
			}
			
			// 전체조회
			if ("SALL".equals(isudType)){
				System.out.println("전체조회 isudType >>> : " + isudType);
				
				// 서비스 호출
				NoticeService ns = new NoticeServiceImpl();
				// placeholder 없으므로 setter함수 이용한 바인딩 없음
				
				ArrayList<NoticeVO> aListSA = ns.noticeSelectAll();
				if (aListSA != null && aListSA.size() > 0){
					System.out.println("전체조회 성공 !!");
					request.setAttribute("aListSA", aListSA);
					RequestDispatcher rd = request.getRequestDispatcher("/jso/notice/noticeSelectAll.jsp");
					rd.forward(request, response);
				}else{
					System.out.println("전체조회 실패 !!");
					out.println("<script>");
					out.println("location.href='/testJso/jso/notice/notice.html'");
					out.println("</script>");
				}
			}
			
			// 조건조회 : S U D
			if ("S".equals(isudType) || "U".equals(isudType)){
				System.out.println("공지사항 조건조회 isudType >>> : " + isudType);
				
				String nnum = request.getParameter("chknum");
				// 서비스 호출
				NoticeService ns = new NoticeServiceImpl();
				// 웹브라우저로부터 입력받은 데이터 깡통클래스 vo의 placeholder에 저장하기
				NoticeVO nvo = null;
				nvo = new NoticeVO();				
				nvo.setNnum(nnum);
				
				ArrayList<NoticeVO> aListS = ns.noticeSelect(nvo);
				if (aListS != null && aListS.size() > 0){
					System.out.println("조건조회 성공 !!");
					
					request.setAttribute("aListS", aListS);
					RequestDispatcher rd = request.getRequestDispatcher("/jso/notice/noticeSelect.jsp");
					rd.forward(request, response);
				}else{
					System.out.println("조건조회 실패 !!");
					out.println("<script>");
					out.println("location.href='/testJso/notice?ISUD_TYPE=SALL'");
					out.println("</script>");
				}
			}
			
			// 수정
			if ("UOK".equals(isudType)){
				System.out.println("수정 isudType >>> : " + isudType);
				
//				FileUploadUtil fu = new FileUploadUtil();
////				public boolean fileUpload3(HttpServletRequest hReq, String filePaths, int size_limit, String encode_type){
//				String filePaths = CommonUtils.NOTICE_IMG_UPLOAD_PATH;
//				int size_limit = CommonUtils.NOTICE_IMG_SIZE_LIMIT;
//				String encode_type = CommonUtils.NOTICE_IMG_ENCODE;
//				
//				boolean boolF = fu.fileUpload3(request, filePaths, size_limit, encode_type);
//				if (boolF){
					
					String nsubject = request.getParameter("nsubject");
					String nmemo = request.getParameter("nmemo");
					String nnum = request.getParameter("nnum");
					
					// 서비스 호출
					NoticeService ns = new NoticeServiceImpl();
					// placeholder 바인딩
					NoticeVO nvo = null;
					nvo = new NoticeVO();
					
					nvo.setNsubject(nsubject);
					nvo.setNmemo(nmemo);
					nvo.setNnum(nnum);
					NoticeVO.printlnNoticeVO(nvo);
					
					int nCntU = ns.noticeUpdate(nvo);
					if (nCntU > 0){
						System.out.println("수정 성공 !!");
						
						request.setAttribute("nCntU", new Integer(nCntU));
						RequestDispatcher rd = request.getRequestDispatcher("/jso/notice/noticeUpdate.jsp");
						rd.forward(request, response);
					}else{
						System.out.println("수정 실패 !!");
						out.println("<script>");
						out.println("location.href='/testJso/notice?ISUD_TYPE=SALL'");
						out.println("</script>");
					}
//				}
			}
			
			// 삭제
			if ("DOK".equals(isudType)){
				System.out.println("삭제 isudType >>> : " + isudType);
				
				String nnum = request.getParameter("chknum");
				// 서비스 호출
				NoticeService ns = new NoticeServiceImpl();
				NoticeVO nvo = null;
				nvo = new NoticeVO();
				nvo.setNnum(nnum);
				NoticeVO.printlnNoticeVO(nvo);
				
				int nCntD = ns.noticeDelete(nvo);
				if (nCntD > 0){
					System.out.println("삭제 성공 !!");
					request.setAttribute("nCntD", new Integer(nCntD));
					RequestDispatcher rd = request.getRequestDispatcher("/jso/notice/noticeDelete.jsp");
					rd.forward(request, response);
				}else{
					System.out.println("삭제 실패 !!");
					out.println("<script>");
					out.println("location.href='/testJso/notice?ISUD_TYPE=SALL'");
					out.println("</script>");
				}
			}
			
		}else{
			System.out.println("isudType을 잘 보내세요 !!");
		}
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		System.out.println("NoticeController doPost() 함수 진입 >>> : ");
		doGet(request, response);
	}

}
