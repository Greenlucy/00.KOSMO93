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
		System.out.println("NoticeController doGet() �Լ� ���� >>> : ");
		
		request.setCharacterEncoding("EUC-KR");
		response.setCharacterEncoding("EUC-KR");
		response.setContentType("text/html; charset=EUC-KR;"); 
		PrintWriter out = response.getWriter();
		String isudType = request.getParameter("ISUD_TYPE");
		
		if (isudType != null && isudType.length() > 0){
			// �Է�
			if ("I".equals(isudType)) {
				System.out.println("�Է� isudType >>> : " + isudType);
				
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
					
					// ���� ȣ��
					NoticeService ns = new NoticeServiceImpl();
					// ���������κ��� �Է¹��� ������ set ������ �� �ְ� ���۾�
					NoticeVO nvo = null;
					nvo = new NoticeVO();
					nvo.setNnum(nnum);
					nvo.setNsubject(nsubject);
					nvo.setNmemo(nmemo);
					nvo.setNphoto(nphoto);
					NoticeVO.printlnNoticeVO(nvo);
					
					int nCntI = ns.noticeInsert(nvo);
					if (nCntI > 0){
						System.out.println("��� ���� !!");
						request.setAttribute("nCntI", new Integer(nCntI));
						RequestDispatcher rd = request.getRequestDispatcher("/jso/notice/noticeInsert.jsp");
						rd.forward(request, response);
					}else{
						System.out.println("��� ���� !!");
						out.println("<script>");
						out.println("location.href='/testJso/jso/notice/notice.html'");
						out.println("</script>");
					}
				}
				
			}
			
			// ��ü��ȸ
			if ("SALL".equals(isudType)){
				System.out.println("��ü��ȸ isudType >>> : " + isudType);
				
				// ���� ȣ��
				NoticeService ns = new NoticeServiceImpl();
				// placeholder �����Ƿ� setter�Լ� �̿��� ���ε� ����
				
				ArrayList<NoticeVO> aListSA = ns.noticeSelectAll();
				if (aListSA != null && aListSA.size() > 0){
					System.out.println("��ü��ȸ ���� !!");
					request.setAttribute("aListSA", aListSA);
					RequestDispatcher rd = request.getRequestDispatcher("/jso/notice/noticeSelectAll.jsp");
					rd.forward(request, response);
				}else{
					System.out.println("��ü��ȸ ���� !!");
					out.println("<script>");
					out.println("location.href='/testJso/jso/notice/notice.html'");
					out.println("</script>");
				}
			}
			
			// ������ȸ : S U D
			if ("S".equals(isudType) || "U".equals(isudType)){
				System.out.println("�������� ������ȸ isudType >>> : " + isudType);
				
				String nnum = request.getParameter("chknum");
				// ���� ȣ��
				NoticeService ns = new NoticeServiceImpl();
				// ���������κ��� �Է¹��� ������ ����Ŭ���� vo�� placeholder�� �����ϱ�
				NoticeVO nvo = null;
				nvo = new NoticeVO();				
				nvo.setNnum(nnum);
				
				ArrayList<NoticeVO> aListS = ns.noticeSelect(nvo);
				if (aListS != null && aListS.size() > 0){
					System.out.println("������ȸ ���� !!");
					
					request.setAttribute("aListS", aListS);
					RequestDispatcher rd = request.getRequestDispatcher("/jso/notice/noticeSelect.jsp");
					rd.forward(request, response);
				}else{
					System.out.println("������ȸ ���� !!");
					out.println("<script>");
					out.println("location.href='/testJso/notice?ISUD_TYPE=SALL'");
					out.println("</script>");
				}
			}
			
			// ����
			if ("UOK".equals(isudType)){
				System.out.println("���� isudType >>> : " + isudType);
				
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
					
					// ���� ȣ��
					NoticeService ns = new NoticeServiceImpl();
					// placeholder ���ε�
					NoticeVO nvo = null;
					nvo = new NoticeVO();
					
					nvo.setNsubject(nsubject);
					nvo.setNmemo(nmemo);
					nvo.setNnum(nnum);
					NoticeVO.printlnNoticeVO(nvo);
					
					int nCntU = ns.noticeUpdate(nvo);
					if (nCntU > 0){
						System.out.println("���� ���� !!");
						
						request.setAttribute("nCntU", new Integer(nCntU));
						RequestDispatcher rd = request.getRequestDispatcher("/jso/notice/noticeUpdate.jsp");
						rd.forward(request, response);
					}else{
						System.out.println("���� ���� !!");
						out.println("<script>");
						out.println("location.href='/testJso/notice?ISUD_TYPE=SALL'");
						out.println("</script>");
					}
//				}
			}
			
			// ����
			if ("DOK".equals(isudType)){
				System.out.println("���� isudType >>> : " + isudType);
				
				String nnum = request.getParameter("chknum");
				// ���� ȣ��
				NoticeService ns = new NoticeServiceImpl();
				NoticeVO nvo = null;
				nvo = new NoticeVO();
				nvo.setNnum(nnum);
				NoticeVO.printlnNoticeVO(nvo);
				
				int nCntD = ns.noticeDelete(nvo);
				if (nCntD > 0){
					System.out.println("���� ���� !!");
					request.setAttribute("nCntD", new Integer(nCntD));
					RequestDispatcher rd = request.getRequestDispatcher("/jso/notice/noticeDelete.jsp");
					rd.forward(request, response);
				}else{
					System.out.println("���� ���� !!");
					out.println("<script>");
					out.println("location.href='/testJso/notice?ISUD_TYPE=SALL'");
					out.println("</script>");
				}
			}
			
		}else{
			System.out.println("isudType�� �� �������� !!");
		}
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		System.out.println("NoticeController doPost() �Լ� ���� >>> : ");
		doGet(request, response);
	}

}
