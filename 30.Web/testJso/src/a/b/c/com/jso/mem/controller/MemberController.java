package a.b.c.com.jso.mem.controller;

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
import a.b.c.com.jso.mem.service.MemberService;
import a.b.c.com.jso.mem.service.MemberServiceImpl;
import a.b.c.com.jso.mem.vo.MemberVO;

@WebServlet("/member")
public class MemberController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		System.out.println("MemberController doGet() �Լ� ���� >>> : ");
		
		request.setCharacterEncoding("EUC-KR");
		response.setCharacterEncoding("EUC-KR");
		response.setContentType("text/html; charset=EUC-KR");
		PrintWriter out = response.getWriter();
		
		String isudType = request.getParameter("ISUD_TYPE");

		if (isudType != null && isudType.length() > 0){
			isudType = isudType.toUpperCase();
			
			if ("I".equals(isudType)){
				System.out.println("ȸ������ ��� isudType>>> : " + isudType);
				
				// ���� bool���� : enctype �� multipart/form-data���� Ȯ���ϴ� ����
				boolean bool = request.getContentType().toLowerCase().startsWith("multipart/form-data");
				
				// enctype�� multipart/form-data�� ������.. ����Ǵ� if��
				if (bool){
					System.out.println("ȸ����� ���Ͼ��ε� ��ƾ :: bool >>> : " + bool);
					// ���� ���ε�
					// public boolean fileUpload3(HttpServletRequest hReq, String filePaths, int size_limit, String encode_type){
					String filePaths = CommonUtils.MEMBER_IMG_UPLOAD_PATH;
					int size_limit = CommonUtils.MEMBER_IMG_FILE_SIZE;
					String encode_type = CommonUtils.MEMBER_IMG_ENCODE;
					
					FileUploadUtil fu = new FileUploadUtil();
					boolean bFile = fu.fileUpload3(request, filePaths, size_limit, encode_type);
					
					// �����͸� request�ϰ�, filePaths�� Ȯ���ϰ�, size_limit�� �����ϰ�, encode_type�� ������ �Լ��� return = true�� �Ǹ�,
					if (bFile){
						// 1. form���� ��û�� ������ ����üŷ�ϱ� : ������������.
						// 3. ���� ���ε� Ȯ���ϱ�
						
						//ȸ����ȣ
						String mnum = GetChabun.getMemberChabun("d");
						out.println("mnum >>> : " + mnum + "<br>");
						
						// ȸ���̸�
						String mname = fu.getParameter("mname");
						out.println("mname >>> : " + mname + "<br>");
						
						// ���̵�
						String mid = fu.getParameter("mid");
						out.println("mid >>> : " + mid + "<br>");
						
						// �н�����
						String mpw = fu.getParameter("mpw");
						out.println("mpw >>> : " + mpw + "<br>");
						
						// ����
						String mgender = fu.getParameter("mgender");
						out.println("mgender >>> : " + mgender + "<br>");
						
						// ����
						String mbirth = fu.getParameter("mbirth");
						String mbirth1 = fu.getParameter("mbirth1");
						String mbirth2 = fu.getParameter("mbirth2");
						mbirth = mbirth + mbirth1 + mbirth2;
						out.println("mbirth >>> : " + mbirth + "<br>");
						
						// �ڵ���
						String mhp = fu.getParameter("mhp");
						String mhp1 = fu.getParameter("mhp1");
						String mhp2 = fu.getParameter("mhp2");
						mhp = mhp + mhp1 + mhp2;
						out.println("mhp >>> : " + mhp + "<br>");
						
						// ��ȭ��ȣ
						String mtel = fu.getParameter("mtel");
						String mtel1 = fu.getParameter("mtel1");
						String mtel2 = fu.getParameter("mtel2");
						mtel = mtel + mtel1 + mtel2;
						out.println("mtel >>> : " + mtel + "<br>");
						
						// �̸���
						String memail = fu.getParameter("memail");
						String memail1 = fu.getParameter("memail1");
						memail = memail.concat("@").concat(memail1);
						out.println("memail >>> : " + memail + "<br>");
						
						// �ּ� : �����ȣ
						String mzonecode = fu.getParameter("mzonecode");
						out.println("mzonecode >>> : " + mzonecode + "<br>");
						
						// �ּ� : ���θ� �ּ�
						String mroadaddress = fu.getParameter("mroadaddress");
						String mroadaddressdetail = fu.getParameter("mroadaddressdetail");
						mroadaddress = mroadaddress.concat("@").concat(mroadaddressdetail);
						out.println("mroadaddress >>> : " + mroadaddress + "<br>");
						
						// �ּ� : ���� �ּ�
						String mgibunaddress = fu.getParameter("mgibunaddress");
						out.println("mgibunaddress >>> : " + mgibunaddress + "<br>");
						
						// ���
						// �迭�� �����ϰ� name="mhobby"�� ��ҵ��� �����Ѵ�.
						String[] hobby = fu.getParameterValues("mhobby");
						// mhobby �������� ����, �ʱ�ȭ
						String mhobby = "";
						// hobby �迭 ���̸�ŭ �ݺ��Ͽ�, String�� mhobby�� += �����ڸ� ����Ͽ� �߰��Ѵ�.
						for (int i=0; i < hobby.length; i++){
							mhobby += hobby[i] + ", ";
						}
						out.println("mhobby >>> : " + mhobby + "<br>");
						
						// ���Ұ�
						String minfo = fu.getParameter("minfo");
						out.println("minfo >>> : " + minfo + "<br>");
						
						// ����
						// ���� �̸��� ArrayList<String> ������ ��´�.
						// FileUploadUtil Ŭ���� : public ArrayList<String> getFileNames() �Լ� ��� : return ArrayList<String>
						ArrayList<String> aFileName = fu.getFileNames();
						String mphoto = aFileName.get(0);
						out.println("mphoto >>> : " + mphoto + "<br>");
						
						// ������
						String madmin = "00";
						
						MemberVO mvo = null;
						mvo = new MemberVO();
						System.out.println("MemberController isudType=I :: mvo >>> : " + mvo);
//						[1] MemberController isudType=I :: mvo >>> : a.b.c.com.jso.mem.vo.MemberVO@8db09ae
						
						// ������������ �Էµ� placeholder�� �����͵��� mvo�� �ʱ�ȭ �� ���ε� ���ֱ�
						mvo.setMnum(mnum);			// 1
						mvo.setMname(mname);		// 2
						mvo.setMid(mid);			// 3
						mvo.setMpw(mpw);			// 4
						mvo.setMgender(mgender);	// 5
						mvo.setMbirth(mbirth);		// 6
						mvo.setMhp(mhp);			// 7
						mvo.setMtel(mtel); 			// 8
						mvo.setMemail(memail);				// 9
						mvo.setMzonecode(mzonecode);		// 10
						mvo.setMroadaddress(mroadaddress);	// 11
						mvo.setMgibunaddress(mgibunaddress);// 12
						mvo.setMhobby(mhobby);				// 13
						mvo.setMinfo(minfo);		// 14
						mvo.setMphoto(mphoto);		// 15
						mvo.setMadmin(madmin);		// 16
						
						// 4. MemberVO.����Ʈ() �Լ��� ���뿡 �ʱ�ȭ �� ������ Ȯ���ϱ�
						MemberVO.printMemberVO(mvo);
						
						// ���� ȣ���ϱ�
						MemberService ms = new MemberServiceImpl();
						boolean boolI = ms.memberInsert(mvo);
						
						// jsp�� �����ؼ� ������ �ѱ��
						if (boolI){
							// null���� ���͵� �����͸� �ѱ� �� �ֵ��� newBoolean()�� boolI �Է��ϴ� ��. boolean�� true �Ǵ� false���� ��ȯ��
							request.setAttribute("boolI", new Boolean(boolI));
							RequestDispatcher rd = request.getRequestDispatcher("/jso/mem/memInsert.jsp");
							rd.forward(request, response);
						}else{
							out.println("<script>");
							out.println("location.href='/testJso/jso/mem/mem.html'");
							out.println("</script>");
						}
					}else{
						System.out.println("ȸ�� ��� �� ���� ���ε� ���� "); 
					} // if(bFile)
				} // if(bool) : enctype Ȯ��
			} // end of ȸ�� ���� ���
			
			// ��ü��ȸ
			if ("SALL".equals(isudType)){
				System.out.println("��ü��ȸ isudType >>> : " + isudType);
				
				// ���� ȣ��
				MemberService ms = new MemberServiceImpl();
//				MemberVO _mvo = new MemberVO();
//				MemberVO.printMemberVO(_mvo);		// null ��� ��
//				System.out.println("MemberController if(SALL) :: null�� _mvo >>> : " + _mvo);
//				[4] MemberController if(SALL) :: null�� _mvo >>> : a.b.c.com.jso.mem.vo.MemberVO@7b75502a
				
//				MemberVO mvo = null;				// null �ϸ� ������ ����� ����
//				mvo = new MemberVO();
//				System.out.println("MemberController if(SALL) :: null�� mvo >>> : " + mvo);
//				[5] MemberController if(SALL) :: null�� mvo >>> : a.b.c.com.jso.mem.vo.MemberVO@75b2a134
				
				// placeholder �����Ƿ� vo�� ���ε��� ���� ����.
				
				ArrayList<MemberVO> aListSA = ms.memberSelectAll();
				System.out.println("aListSA >>> : " + aListSA);
				if (aListSA != null && aListSA.size() > 0){
					System.out.println("��ü��ȸ ���� !!");
					// ArrayList�� null�� ���� �� �����Ƿ� new ArrayList(aLIstSA) �� �ص� ��
					request.setAttribute("aListSA", aListSA);
					RequestDispatcher rd = request.getRequestDispatcher("/jso/mem/memSelectAll.jsp");
					rd.forward(request, response);
				}else{
					System.out.println("��ü��ȸ ���� !!");
					out.println("<script>");
					out.println("location.href='/testJso/jso/mem/mem.html'");
					out.println("</script>");
				}
			}
			
			// ������ȸ (S || U || D)
			if ("S".equals(isudType) || "U".equals(isudType) || "D".equals(isudType)){
				System.out.println("ȸ����ȣ ������ȸ : S U D isudType >>> : " + isudType);
				
				String mnum = request.getParameter("mnumCheck");
				
				System.out.println("ȸ�� ��ȣ >>> : " + mnum);
				
				// ���� ȣ��
				MemberService ms = new MemberServiceImpl();
				MemberVO mvo = null; 
				mvo = new MemberVO();
				// placeholder set�ϱ�
				mvo.setMnum(mnum);
				
				ArrayList<MemberVO> aListS = ms.memberSelect(mvo);
				
				if (aListS != null && aListS.size() > 0){
					System.out.println("MemberController ȸ��������ȸ ���� !!");
					request.setAttribute("aListS", aListS);
					RequestDispatcher rd = request.getRequestDispatcher("/jso/mem/memSelect.jsp");
					rd.forward(request, response);
				}else{
					System.out.println("MemberController ȸ��������ȸ ���� !!");
					out.println("<script>");
					out.println("location.href='/testJso/mem?ISUD_TYPE=SALL'");
					out.println("</script>");
				}
			}
			
			// ����
			if ("UOK".equals(isudType)){
				System.out.println("���� isudType >>> : " + isudType);
				
				String memail = "";
				String memail_ = request.getParameter("memail");
				String memail1 = request.getParameter("memail1");
				String memail2 = request.getParameter("memail2");
				memail = memail1.concat("@").concat(memail2);
				
				String mzonecode = request.getParameter("mzonecode");
				String mroadaddress = request.getParameter("mroadaddress");
				String mgibunaddress = request.getParameter("mgibunaddress");
				String mhobby = request.getParameter("mhobby");
				String mnum = request.getParameter("mnum");
				
				// ���� ȣ��
				MemberService ms = new MemberServiceImpl();
				MemberVO mvo = null;
				mvo = new MemberVO();
				// ���������κ��� ���� ������ placeholder set �ϱ�
				mvo.setMemail(memail);
				mvo.setMzonecode(mzonecode);
				mvo.setMroadaddress(mroadaddress);
				mvo.setMgibunaddress(mgibunaddress);
				mvo.setMhobby(mhobby);
				mvo.setMnum(mnum);
				
				boolean boolU = ms.memberUpdate(mvo);
				
				if (boolU) {
					System.out.println("���� ���� !!");
					request.setAttribute("boolU", new Boolean(boolU));
					RequestDispatcher rd = request.getRequestDispatcher("/jso/mem/memUpdate.jsp");
					rd.forward(request, response);
				}else{
					System.out.println("���� ���� !!");
					out.println("<script>");
					out.println("location.href='/testJso/member?ISUD_TYPE=SALL'");
					out.println("</script>");
				}
			}
			
			// ����
			if ("DOK".equals(isudType)){
				System.out.println("���� isudType >>> : " + isudType);
				
				String mnum = request.getParameter("mnum");
				// ���� ȣ��
				MemberService ms = new MemberServiceImpl();
				MemberVO mvo = null;
				mvo = new MemberVO();
				mvo.setMnum(mnum);
				
				boolean boolD = ms.memberDelete(mvo);
				if (boolD){
					request.setAttribute("boolD", new Boolean(boolD));
					RequestDispatcher rd = request.getRequestDispatcher("/jso/mem/memDelete.jsp");
					rd.forward(request, response);
				}else{
					System.out.println("���� ���� !!");
					out.println("<script>");
					out.println("location.href='/testJso/member?ISUD_TYPE=SALL'");
					out.println("</script>");
				}
			}
			
		}else{
			System.out.println("isudtype�� �� ��������!!");
		}
		/*
		 1. form���� ��û�� ������ ����üŷ�ϱ�
		 2. ä������ �ϱ�
		 3. ���� ���ε� Ȯ���ϱ�
		 4. MmeberVO.����Ʈ() �Լ��� ���뿡 �ʱ�ȭ �� ������ Ȯ���ϱ�
		 5. Service ���� memberInsert() �Լ� ȣ���ϱ�
		 5-1. MemberDAOImpl.memberInsert() �Լ����� �α� Ȯ���ϱ�
		 5-2. MemberSqlMap.getMemberInsertQuery()
		 	  MemeberDAOImpl memberInsert() �Լ��� placeholder Ȯ���ϱ�
		 */
	}

	
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		System.out.println("MemberController doPost() �Լ� ���� >>> : ");
		doGet(request, response);
	}

}
