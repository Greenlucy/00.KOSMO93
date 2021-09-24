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
		System.out.println("MemberController doGet() 함수 진입 >>> : ");
		
		request.setCharacterEncoding("EUC-KR");
		response.setCharacterEncoding("EUC-KR");
		response.setContentType("text/html; charset=EUC-KR");
		PrintWriter out = response.getWriter();
		
		String isudType = request.getParameter("ISUD_TYPE");

		if (isudType != null && isudType.length() > 0){
			isudType = isudType.toUpperCase();
			
			if ("I".equals(isudType)){
				System.out.println("회원정보 등록 isudType>>> : " + isudType);
				
				// 변수 bool선언 : enctype 이 multipart/form-data인지 확인하는 변수
				boolean bool = request.getContentType().toLowerCase().startsWith("multipart/form-data");
				
				// enctype이 multipart/form-data가 맞으면.. 실행되는 if문
				if (bool){
					System.out.println("회원등록 파일업로드 루틴 :: bool >>> : " + bool);
					// 파일 업로드
					// public boolean fileUpload3(HttpServletRequest hReq, String filePaths, int size_limit, String encode_type){
					String filePaths = CommonUtils.MEMBER_IMG_UPLOAD_PATH;
					int size_limit = CommonUtils.MEMBER_IMG_FILE_SIZE;
					String encode_type = CommonUtils.MEMBER_IMG_ENCODE;
					
					FileUploadUtil fu = new FileUploadUtil();
					boolean bFile = fu.fileUpload3(request, filePaths, size_limit, encode_type);
					
					// 데이터를 request하고, filePaths를 확인하고, size_limit을 제한하고, encode_type을 설정한 함수가 return = true가 되면,
					if (bFile){
						// 1. form에서 요청된 데이터 아이체킹하기 : 웹브라우저에서.
						// 3. 파일 업로드 확인하기
						
						//회원번호
						String mnum = GetChabun.getMemberChabun("d");
						out.println("mnum >>> : " + mnum + "<br>");
						
						// 회원이름
						String mname = fu.getParameter("mname");
						out.println("mname >>> : " + mname + "<br>");
						
						// 아이디
						String mid = fu.getParameter("mid");
						out.println("mid >>> : " + mid + "<br>");
						
						// 패스워드
						String mpw = fu.getParameter("mpw");
						out.println("mpw >>> : " + mpw + "<br>");
						
						// 성별
						String mgender = fu.getParameter("mgender");
						out.println("mgender >>> : " + mgender + "<br>");
						
						// 생일
						String mbirth = fu.getParameter("mbirth");
						String mbirth1 = fu.getParameter("mbirth1");
						String mbirth2 = fu.getParameter("mbirth2");
						mbirth = mbirth + mbirth1 + mbirth2;
						out.println("mbirth >>> : " + mbirth + "<br>");
						
						// 핸드폰
						String mhp = fu.getParameter("mhp");
						String mhp1 = fu.getParameter("mhp1");
						String mhp2 = fu.getParameter("mhp2");
						mhp = mhp + mhp1 + mhp2;
						out.println("mhp >>> : " + mhp + "<br>");
						
						// 전화번호
						String mtel = fu.getParameter("mtel");
						String mtel1 = fu.getParameter("mtel1");
						String mtel2 = fu.getParameter("mtel2");
						mtel = mtel + mtel1 + mtel2;
						out.println("mtel >>> : " + mtel + "<br>");
						
						// 이메일
						String memail = fu.getParameter("memail");
						String memail1 = fu.getParameter("memail1");
						memail = memail.concat("@").concat(memail1);
						out.println("memail >>> : " + memail + "<br>");
						
						// 주소 : 우편번호
						String mzonecode = fu.getParameter("mzonecode");
						out.println("mzonecode >>> : " + mzonecode + "<br>");
						
						// 주소 : 도로명 주소
						String mroadaddress = fu.getParameter("mroadaddress");
						String mroadaddressdetail = fu.getParameter("mroadaddressdetail");
						mroadaddress = mroadaddress.concat("@").concat(mroadaddressdetail);
						out.println("mroadaddress >>> : " + mroadaddress + "<br>");
						
						// 주소 : 지번 주소
						String mgibunaddress = fu.getParameter("mgibunaddress");
						out.println("mgibunaddress >>> : " + mgibunaddress + "<br>");
						
						// 취미
						// 배열을 선언하고 name="mhobby"인 요소들을 저장한다.
						String[] hobby = fu.getParameterValues("mhobby");
						// mhobby 지역변수 선언, 초기화
						String mhobby = "";
						// hobby 배열 길이만큼 반복하여, String형 mhobby에 += 연산자를 사용하여 추가한다.
						for (int i=0; i < hobby.length; i++){
							mhobby += hobby[i] + ", ";
						}
						out.println("mhobby >>> : " + mhobby + "<br>");
						
						// 내소개
						String minfo = fu.getParameter("minfo");
						out.println("minfo >>> : " + minfo + "<br>");
						
						// 사진
						// 파일 이름을 ArrayList<String> 변수에 담는다.
						// FileUploadUtil 클래스 : public ArrayList<String> getFileNames() 함수 사용 : return ArrayList<String>
						ArrayList<String> aFileName = fu.getFileNames();
						String mphoto = aFileName.get(0);
						out.println("mphoto >>> : " + mphoto + "<br>");
						
						// 관리자
						String madmin = "00";
						
						MemberVO mvo = null;
						mvo = new MemberVO();
						System.out.println("MemberController isudType=I :: mvo >>> : " + mvo);
//						[1] MemberController isudType=I :: mvo >>> : a.b.c.com.jso.mem.vo.MemberVO@8db09ae
						
						// 웹브라우저에서 입력된 placeholder의 데이터들을 mvo에 초기화 및 바인딩 해주기
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
						
						// 4. MemberVO.프린트() 함수로 깡통에 초기화 된 데이터 확인하기
						MemberVO.printMemberVO(mvo);
						
						// 서비스 호출하기
						MemberService ms = new MemberServiceImpl();
						boolean boolI = ms.memberInsert(mvo);
						
						// jsp와 연결해서 데이터 넘기기
						if (boolI){
							// null값이 들어와도 데이터를 넘길 수 있도록 newBoolean()에 boolI 입력하는 것. boolean은 true 또는 false값만 반환함
							request.setAttribute("boolI", new Boolean(boolI));
							RequestDispatcher rd = request.getRequestDispatcher("/jso/mem/memInsert.jsp");
							rd.forward(request, response);
						}else{
							out.println("<script>");
							out.println("location.href='/testJso/jso/mem/mem.html'");
							out.println("</script>");
						}
					}else{
						System.out.println("회원 등록 및 파일 업로드 실패 "); 
					} // if(bFile)
				} // if(bool) : enctype 확인
			} // end of 회원 정보 등록
			
			// 전체조회
			if ("SALL".equals(isudType)){
				System.out.println("전체조회 isudType >>> : " + isudType);
				
				// 서비스 호출
				MemberService ms = new MemberServiceImpl();
//				MemberVO _mvo = new MemberVO();
//				MemberVO.printMemberVO(_mvo);		// null 출력 됌
//				System.out.println("MemberController if(SALL) :: null전 _mvo >>> : " + _mvo);
//				[4] MemberController if(SALL) :: null전 _mvo >>> : a.b.c.com.jso.mem.vo.MemberVO@7b75502a
				
//				MemberVO mvo = null;				// null 하면 정보가 담기지 않음
//				mvo = new MemberVO();
//				System.out.println("MemberController if(SALL) :: null후 mvo >>> : " + mvo);
//				[5] MemberController if(SALL) :: null후 mvo >>> : a.b.c.com.jso.mem.vo.MemberVO@75b2a134
				
				// placeholder 없으므로 vo에 바인딩할 값이 없음.
				
				ArrayList<MemberVO> aListSA = ms.memberSelectAll();
				System.out.println("aListSA >>> : " + aListSA);
				if (aListSA != null && aListSA.size() > 0){
					System.out.println("전체조회 성공 !!");
					// ArrayList는 null값 받을 수 있으므로 new ArrayList(aLIstSA) 안 해도 됌
					request.setAttribute("aListSA", aListSA);
					RequestDispatcher rd = request.getRequestDispatcher("/jso/mem/memSelectAll.jsp");
					rd.forward(request, response);
				}else{
					System.out.println("전체조회 실패 !!");
					out.println("<script>");
					out.println("location.href='/testJso/jso/mem/mem.html'");
					out.println("</script>");
				}
			}
			
			// 조건조회 (S || U || D)
			if ("S".equals(isudType) || "U".equals(isudType) || "D".equals(isudType)){
				System.out.println("회원번호 조건조회 : S U D isudType >>> : " + isudType);
				
				String mnum = request.getParameter("mnumCheck");
				
				System.out.println("회원 번호 >>> : " + mnum);
				
				// 서비스 호출
				MemberService ms = new MemberServiceImpl();
				MemberVO mvo = null; 
				mvo = new MemberVO();
				// placeholder set하기
				mvo.setMnum(mnum);
				
				ArrayList<MemberVO> aListS = ms.memberSelect(mvo);
				
				if (aListS != null && aListS.size() > 0){
					System.out.println("MemberController 회원정보조회 성공 !!");
					request.setAttribute("aListS", aListS);
					RequestDispatcher rd = request.getRequestDispatcher("/jso/mem/memSelect.jsp");
					rd.forward(request, response);
				}else{
					System.out.println("MemberController 회원정보조회 실패 !!");
					out.println("<script>");
					out.println("location.href='/testJso/mem?ISUD_TYPE=SALL'");
					out.println("</script>");
				}
			}
			
			// 수정
			if ("UOK".equals(isudType)){
				System.out.println("수정 isudType >>> : " + isudType);
				
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
				
				// 서비스 호출
				MemberService ms = new MemberServiceImpl();
				MemberVO mvo = null;
				mvo = new MemberVO();
				// 웹브라우저로부터 받은 데이터 placeholder set 하기
				mvo.setMemail(memail);
				mvo.setMzonecode(mzonecode);
				mvo.setMroadaddress(mroadaddress);
				mvo.setMgibunaddress(mgibunaddress);
				mvo.setMhobby(mhobby);
				mvo.setMnum(mnum);
				
				boolean boolU = ms.memberUpdate(mvo);
				
				if (boolU) {
					System.out.println("수정 성공 !!");
					request.setAttribute("boolU", new Boolean(boolU));
					RequestDispatcher rd = request.getRequestDispatcher("/jso/mem/memUpdate.jsp");
					rd.forward(request, response);
				}else{
					System.out.println("수정 실패 !!");
					out.println("<script>");
					out.println("location.href='/testJso/member?ISUD_TYPE=SALL'");
					out.println("</script>");
				}
			}
			
			// 삭제
			if ("DOK".equals(isudType)){
				System.out.println("삭제 isudType >>> : " + isudType);
				
				String mnum = request.getParameter("mnum");
				// 서비스 호출
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
					System.out.println("삭제 실패 !!");
					out.println("<script>");
					out.println("location.href='/testJso/member?ISUD_TYPE=SALL'");
					out.println("</script>");
				}
			}
			
		}else{
			System.out.println("isudtype을 잘 보내세요!!");
		}
		/*
		 1. form에서 요청된 데이터 아이체킹하기
		 2. 채번로직 하기
		 3. 파일 업로드 확인하기
		 4. MmeberVO.프린트() 함수로 깡통에 초기화 된 데이터 확인하기
		 5. Service 에서 memberInsert() 함수 호출하기
		 5-1. MemberDAOImpl.memberInsert() 함수에서 로그 확인하기
		 5-2. MemberSqlMap.getMemberInsertQuery()
		 	  MemeberDAOImpl memberInsert() 함수와 placeholder 확인하기
		 */
	}

	
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		System.out.println("MemberController doPost() 함수 진입 >>> : ");
		doGet(request, response);
	}

}
