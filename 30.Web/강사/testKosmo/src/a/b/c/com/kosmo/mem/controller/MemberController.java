package a.b.c.com.kosmo.mem.controller;

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
import a.b.c.com.common.FileUploadUtil;
import a.b.c.com.common.GetChabun;
import a.b.c.com.kosmo.board.service.BoardService;
import a.b.c.com.kosmo.board.service.BoardServiceImpl;
import a.b.c.com.kosmo.board.vo.BoardVO;
import a.b.c.com.kosmo.mem.service.MemberService;
import a.b.c.com.kosmo.mem.service.MemberServiceImpl;
import a.b.c.com.kosmo.mem.vo.MemberVO;

@WebServlet("/mem")
public class MemberController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
		throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("EUC-KR");
		response.setCharacterEncoding("EUC-KR");
		response.setContentType("text/html; charset=EUC-KR");
		PrintWriter out = response.getWriter();
		
		String isudType = request.getParameter("ISUD_TYPE");	
		
		/*
		1. form 에서 요청된 데이터 아이체킹하기 
				
			String mnum = request.getParameter("mnum");
			System.out.println("mnum >>> : " + mnum);			
			String mname = request.getParameter("mname");
			System.out.println("mname >>> : " + mname);
		2. 채번로직 하기 
			String mnum = GetChabun.getMemberChabun("d");
		3. 파일 업로드 확인하기 
			FileUploadUtil fu = new FileUploadUtil();					
	//		boolean bFile = fu.fileUpldad3(request, filePaths, size_limit, encode_type);
		4. MemberVO.printlnMemberVO(mvo); 으로  깡통에 초기화 된 데이터 확인하기
			MemberVO.printlnMemberVO(mvo);
		5. Service 에서 memberInsert() 함수 호출하기 
		
		5-1. MemberDAOImpl.memberInsert() 함수에서 로그 확인하기 	
			System.out.println("MemberDAOImpl memberInsert() 함수 진입 >>> : ");
			MemberVO.printlnMemberVO(mvo);
			
		5-2. MemberSqlMap.getMemberInsertQuery()
		
			pstmt.setString(1, mvo.getMnum()); 
			pstmt.setString(2, mvo.getMname()); 
			pstmt.setString(3, mvo.getMid());   
			pstmt.setString(4, mvo.getMpw());
			pstmt.setString(5, mvo.getMgender());
			pstmt.setString(6, mvo.getMbirth());
			pstmt.setString(7, mvo.getMhp());
			pstmt.setString(8, mvo.getMtel());						
			pstmt.setString(9, mvo.getMemail());
			pstmt.setString(10, mvo.getMzonecode());
			pstmt.setString(11, mvo.getMroadaddress());
			pstmt.setString(12, mvo.getMjibunaddress());
			pstmt.setString(13, mvo.getMhobby());
			pstmt.setString(14, mvo.getMinfo());
			pstmt.setString(15, mvo.getMphoto());
			pstmt.setString(16, mvo.getMadmin());
		
			sb.append("      			 MNUM 				\n"); // COLUMN 1
			sb.append("					,MNAME 				\n"); // COLUMN 2
			sb.append("					,MID 				\n"); // COLUMN 3
		    sb.append("					,MPW   				\n"); // COLUMN 4
		    sb.append("					,MGENDER 			\n"); // COLUMN 5
		    sb.append("					,MBIRTH 			\n"); // COLUMN 6
		    sb.append("					,MHP 				\n"); // COLUMN 7
		    sb.append("					,MTEL   			\n"); // COLUMN 8	   
			sb.append("					,MEMAIL 			\n"); // COLUMN 9		
		    sb.append("					,MZONECODE   		\n"); // COLUMN 10
		    sb.append("					,MROADADDRESS 		\n"); // COLUMN 11
		    sb.append("					,MGIBUNADDRESS 		\n"); // COLUMN 12
			sb.append("					,MHOBBY 			\n"); // COLUMN 13
		    sb.append("					,MINFO   			\n"); // COLUMN 14
			sb.append("					,MPHOTO 			\n"); // COLUMN 15
		    sb.append("					,MADMIN   			\n"); // COLUMN 16
		    sb.append("					,DELETEYN			\n"); // COLUMN 17
		    sb.append("					,INSERTDATE			\n"); // COLUMN 18
		    sb.append("					,UPDATEDATE			\n"); // COLUMN 19	 	  
			sb.append("			      )						\n");
			sb.append("	       VALUES   					\n");
			sb.append("	       		 (  					\n");
			sb.append("     				 ? 				\n"); // placeholder 1
			sb.append("						,? 				\n"); // placeholder 2
		    sb.append("						,?   			\n"); // placeholder 3
		    sb.append("						,?   			\n"); // placeholder 4
		    sb.append("						,? 				\n"); // placeholder 5
		    sb.append("						,? 				\n"); // placeholder 6
		    sb.append("						,?				\n"); // placeholder 7
		    sb.append("						,?				\n"); // placeholder 8
		    sb.append("						,?				\n"); // placeholder 9
		    sb.append("						,?   			\n"); // placeholder 10
		    sb.append("						,? 				\n"); // placeholder 11
		    sb.append("						,? 				\n"); // placeholder 12
		    sb.append("						,?				\n"); // placeholder 13
		    sb.append("						,?				\n"); // placeholder 14
		    sb.append("						,?				\n"); // placeholder 14
		    sb.append("						,?				\n"); // placeholder 15
		    sb.append("						,'Y'			\n"); // placeholder 16
		    sb.append("						,SYSDATE 		\n"); // placeholder 18
		    sb.append("						,SYSDATE 		\n"); // placeholder 19	

		6. 리턴 결과 가 true
			request.setAttribute("bInsert", new Boolean(bInsert)); 초기화 하고 		
			"/kosmo/mem/memInsert.jsp" 으로 포워딩 하기 
		*/		
		
//		if (isudType !=null && isudType.length() > 0){
//			isudType = isudType.toUpperCase();
//			
//			// 회원 등록 ------------------------------------------------------------------------------
//			if ("I".equals(isudType)){
//				System.out.println("회원등록isudType >>> : " + isudType);
//				
//                boolean bool = request.getContentType().toLowerCase().startsWith("multipart/form-data");				
//				if (bool){
//					System.out.println("회원등록 파일업로드 루틴 :: bool >>> : " + bool);
//					
//					String filePaths = CommonUtils.MEMBER_IMG_UPLOAD_PATH;
//	                int size_limit = CommonUtils.MEMBER_IMG_FILE_SIZE;
//	                String  encode_type = CommonUtils.MEMBER_IMG_ENCODE;
//					
//					FileUploadUtil fu = new FileUploadUtil();					
//					boolean bFile = fu.fileUpldad3(request, filePaths, size_limit, encode_type);
//					
//					if (bFile){
//						
//						// 서비스 호출하기 
//						MemberService ms = new MemberServiceImpl();
//						MemberVO mvo = null;
//						mvo = new MemberVO();
//						
//						String mnum = GetChabun.getMemberChabun("d");
//						System.out.println("mnum >>> : " + mnum);
//						
//						// 회원번호
//						mvo.setMnum(mnum);
//						// 회원이름
//						mvo.setMname(fu.getParameter("mname"));
//						// 아이디
//						mvo.setMid(fu.getParameter("mid"));
//						// 패스워드
//						mvo.setMpw(fu.getParameter("mpw"));
//						
//						// 성별
//						mvo.setMgender(fu.getParameter("mgender"));
//						
//						// 생년월일
//						String mbirth = fu.getParameter("mbirth");
//						String mbirth1 = fu.getParameter("mbirth1");
//						String mbirth2 = fu.getParameter("mbirth2");
//						mbirth = mbirth + mbirth1 + mbirth2;
//						mvo.setMbirth(mbirth);
//						
//						// 핸드폰
//						String mhp = fu.getParameter("mhp");
//						String mhp1 = fu.getParameter("mhp1");
//						String mhp2 = fu.getParameter("mhp2");
//						mhp = mhp + mhp1 + mhp2;
//						mvo.setMhp(mhp);
//						
//						// 전화번호
//						String mtel = fu.getParameter("mtel");
//						String mtel1 = fu.getParameter("mtel1");
//						String mtel2 = fu.getParameter("mtel2");
//						mtel = mtel + mtel1 + mtel2;
//						mvo.setMtel(mtel);
//						
//						// 이메일
//						String memail = fu.getParameter("memail");
//						String memail1 = fu.getParameter("memail1");						
//						memail = memail.concat("@").concat(memail1);
//						mvo.setMemail(memail);
//						
//						// 주소 : 우편번호
//						mvo.setMzonecode(fu.getParameter("mzonecode"));
//						
//						// 주소 : 도로명 주소						
//						String mroadaddress = fu.getParameter("mroadaddress");
//						String mroadaddressdetail = fu.getParameter("mroadaddressdetail");						
//						mroadaddress = mroadaddress.concat("@").concat(mroadaddressdetail);
//						mvo.setMroadaddress(mroadaddress);
//						
//						// 주소 : 지번 주소 
//						mvo.setMjibunaddress(fu.getParameter("mjibunaddress"));
//						
//						// 취미
//						String[] hobby = fu.getParameterValues("mhobby");
//						String mhobby = "";
//						for (int i=0; i < hobby.length; i++){
//							mhobby += hobby[i] + ",";
//						}
//						mvo.setMhobby(mhobby);
//						
//						// 내소개
//						mvo.setMinfo(fu.getParameter("minfo"));
//						
//						// 사진
//						ArrayList<String> aFileName = fu.getFileNames();
//						String mphoto = aFileName.get(0);				
//						mvo.setMphoto(mphoto);
//						// 관리자
//						mvo.setMadmin("00"); // 관리자
//						System.out.println("MemberController 회원등록 >>> I ");
//						MemberVO.printlnMemberVO(mvo);
//					
//						boolean bInsert = ms.memberInsert(mvo);						
//						if (bInsert){						
//							request.setAttribute("bInsert", new Boolean(bInsert));				
//							RequestDispatcher rd = request.getRequestDispatcher("/kosmo/mem/memInsert.jsp");
//							rd.forward(request, response);						
//						}else{
//							out.println("<script>");				
//							out.println("location.href='/testKosmo/kosmo/mem/mem.html'");
//							out.println("</script>");
//						}
//					
//					}else{
//						System.out.println("회원 등록 및 파일 업로드 실패 ");
//					}	
//				}				
//			} // 회원 등록 end
//			
//			// 전체 회원정보 조회 ------------------------------------------------------------------------
//			if ("SALL".equals(isudType)){
//				System.out.println("회원정보 전체조회 isudType >>> : " + isudType);
//				
//				// 서비스 호출하기 
//				MemberService ms = new MemberServiceImpl();
//				ArrayList<MemberVO> aListAll = ms.memberSelectAll();
//				
//				if (aListAll !=null && aListAll.size() > 0) {
//					
//					request.setAttribute("aListAll", aListAll);					
//					RequestDispatcher rd= request.getRequestDispatcher("/kosmo/mem/memSelectAll.jsp");
//					rd.forward(request, response);
//					
//				}else {
//					out.println("<script>");					
//					out.println("location.href='/testKosmo/mem?ISUD_TYPE=SALL'");
//					out.println("</script>");
//				}		
//			} // 전체 회원정보 조회 end
//			
//			// 회원정보 조회 : S U D ---------------------------------------------------------------------
//			if ("S".equals(isudType) || "U".equals(isudType) || "D".equals(isudType)){
//				System.out.println("회원 조건조회 : S U D isudType >>> : " + isudType);
//
//				String mnum = request.getParameter("mnumCheck");				
//				if (mnum !=null && mnum.length() > 0){
//					System.out.println("회원 번호 >>> :  " + mnum);
//					
//					// 서비스 호출하기 
//					MemberService ms = new MemberServiceImpl();		
//					MemberVO mvo = null;
//					mvo = new MemberVO();
//					
//					mvo.setMnum(mnum);					
//					ArrayList<MemberVO> aListS = ms.memberSelect(mvo);
//					
//					if (aListS !=null && aListS.size() > 0) {
//						System.out.println("aListS.size() >>> : " + aListS.size());						
//						request.setAttribute("aListS", aListS);					
//						RequestDispatcher rd= request.getRequestDispatcher("/kosmo/mem/memSelect.jsp");
//						rd.forward(request, response);
//						
//					}else {
//						out.println("<script>");
//						out.println("alert('글 조회 실패')");
//						out.println("location.href='/testKosmo/mem?ISUD_TYPE=SALL'");
//						out.println("</script>");
//					}									
//				}else{
//					System.out.println("글번호가  없습니다. ");
//				}		
//			}
//			
//			
//			// 회원 수정 ------------------------------------------------------------------------------
//			
//			// 회원 삭제 ------------------------------------------------------------------------------
//		}else{
//			System.out.println("form 태그에서 hidden 타입의 ISUD_TYPE 잘 넘기세요 >>> : ");
//		}
	
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
