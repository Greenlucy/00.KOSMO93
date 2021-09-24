package a.b.c.com.jso.mem.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import a.b.c.com.common.ConnProperty;
import a.b.c.com.jso.mem.sql.MemberSqlMap;
import a.b.c.com.jso.mem.vo.MemberVO;

public class MemberDAOImpl implements MemberDAO {

	@Override
	public ArrayList<MemberVO> memberSelectAll() {
		// TODO Auto-generated method stub
		System.out.println("MemberDAOImpl memberSelectAll() 함수 진입 >>> : ");
//		MemberVO _mvo = new MemberVO();
//		MemberVO.printlnMemberVO(_mvo);
//		[6] printlnMemberVO mvo >>> : a.b.c.com.jso.mem.vo.MemberVO@718d3b5a
//		System.out.println("MemberDAOImpl memberSelectAll() :: _mvo >>> : " + _mvo);
//		[7] MemberDAOImpl memberSelectAll() :: _mvo >>> : a.b.c.com.jso.mem.vo.MemberVO@718d3b5a
		
		// 사용할 객체 선언하고 초기화하기
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rsRs = null;
		ArrayList<MemberVO> aList = null;
		try{
			conn = ConnProperty.getConnection();
			pstmt = conn.prepareStatement(MemberSqlMap.getMemberSelectAllQuery());
			System.out.println("전체조회 쿼리 확인 >>> : " + MemberSqlMap.getMemberSelectAllQuery());
			rsRs = pstmt.executeQuery();
			
			if (rsRs != null){
				// ArrayList<MemberVO> 메모리에 인스턴스
				aList = new ArrayList<MemberVO>();
				while(rsRs.next()){
					// vo 깡통에 set 초기화 해주기
					MemberVO mvo = new MemberVO();
					// mvo 주소값이 같은지 콘솔에 찍어서 확인해보기
					System.out.println("MemberDAOImpl memberSelectAll() :: mvo >>> : " + mvo);
//					[8] MemberDAOImpl memberSelectAll() :: mvo >>> : a.b.c.com.jso.mem.vo.MemberVO@4837c782
					
					mvo.setMnum(rsRs.getString("MNUM"));
					mvo.setMname(rsRs.getString("MNAME"));
					mvo.setMid(rsRs.getString("MID"));
					mvo.setMpw(rsRs.getString("MPW"));
					mvo.setMgender(rsRs.getString("MGENDER"));
					mvo.setMbirth(rsRs.getString("MBIRTH"));
					mvo.setMhp(rsRs.getString("MHP"));
					mvo.setMtel(rsRs.getString("MTEL"));
					mvo.setMemail(rsRs.getString("MEMAIL"));
					mvo.setMzonecode(rsRs.getString("MZONECODE"));
					mvo.setMroadaddress(rsRs.getString("MROADADDRESS"));
					mvo.setMgibunaddress(rsRs.getString("MGIBUNADDRESS"));
					mvo.setMhobby(rsRs.getString("MHOBBY"));
					mvo.setMinfo(rsRs.getString("MINFO"));
					mvo.setMphoto(rsRs.getString("MPHOTO"));
					mvo.setMadmin(rsRs.getString("MADMIN"));
					mvo.setDeleteyn(rsRs.getString("DELETEYN"));
					mvo.setInsertdate(rsRs.getString("INSERTDATE"));
					mvo.setUpdatedate(rsRs.getString("UPDATEDATE"));
					
					aList.add(mvo);
					MemberVO.printMemberVO(mvo);
					System.out.println("MemberDAOImpl memberSelectAll() : if(true) :: mvo >>> : " + mvo);
					System.out.println("MemberDAOImpl memberSelectAll() : if(true) :: aList >>> : " + aList + "\n");
				}
			}
			
			ConnProperty.conClose(conn, pstmt, rsRs);
		}catch(Exception sq){
			System.out.println("전체조회 DB 에러 >>> : " + sq.getMessage());
			System.out.println("에러 >>> : " + sq);
		}finally{
			ConnProperty.conClose(conn, pstmt, rsRs);
		}
		return aList;
	}

	@Override
	public ArrayList<MemberVO> memberSelect(MemberVO mvo) {
		// TODO Auto-generated method stub
		System.out.println("MemberDAOImpl memberSelect() 함수 진입 >>> : ");
		MemberVO.printMemberVO(mvo);
		
		// 사용할 객체 선언하고 초기화하기
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rsRs = null;
		ArrayList<MemberVO> aList = null;
		
		try{
			conn = ConnProperty.getConnection();
			pstmt = conn.prepareStatement(MemberSqlMap.getMemberSelectQuery());
			System.out.println("조건조회(회원번호) 쿼리 확인 >>> : " + MemberSqlMap.getMemberSelectQuery());
			pstmt.clearParameters();
			// 브라우저로부터 입력받아 컨트롤러를 거친 placeholder를 pstmt에 set하기
			pstmt.setString(1, mvo.getMnum());
			System.out.println("MemberDAOImpl memSelect() 함수 : pstmt.setString(1, mvo.getMnum()) 직후 :: print >>> : ");
			MemberVO.printMemberVO(mvo);
			
			rsRs = pstmt.executeQuery();
			if (rsRs != null) {
				aList = new ArrayList<MemberVO>();
				// 회원번호 부분일치하는 것들이 있을 수 있으니까, 조회는 반복문 사용하여서..
				while(rsRs.next()){
					// 쿼리 컬럼명 값을 받아서, (필요한 것들만 따로 불러서) 깡통의 새로운 주소값에 저장하기 > 새 aList에 담기
					MemberVO _mvo = new MemberVO();
					_mvo.setMnum(rsRs.getString("MNUM"));
					_mvo.setMname(rsRs.getString("MNAME"));
					_mvo.setMid(rsRs.getString("MID"));
					_mvo.setMpw(rsRs.getString("MPW"));
					_mvo.setMgender(rsRs.getString("MGENDER"));
					_mvo.setMbirth(rsRs.getString("MBIRTH"));
					_mvo.setMhp(rsRs.getString("MHP"));
					_mvo.setMtel(rsRs.getString("MTEL"));
					_mvo.setMemail(rsRs.getString("MEMAIL"));
					_mvo.setMzonecode(rsRs.getString("MZONECODE"));
					_mvo.setMroadaddress(rsRs.getString("MROADADDRESS"));
					_mvo.setMgibunaddress(rsRs.getString("MGIBUNADDRESS"));
					_mvo.setMhobby(rsRs.getString("MHOBBY"));
					_mvo.setMinfo(rsRs.getString("MINFO"));
					_mvo.setMphoto(rsRs.getString("MPHOTO"));
					_mvo.setMadmin(rsRs.getString("MADMIN"));
					_mvo.setDeleteyn(rsRs.getString("DELETEYN"));
					_mvo.setInsertdate(rsRs.getString("INSERTDATE"));
					_mvo.setUpdatedate(rsRs.getString("UPDATEDATE"));
					
					aList.add(_mvo);
					System.out.println("MemberDAOImpl memSelect()함수 : while() :: print >>> : ");
					MemberVO.printMemberVO(_mvo);
				}
			}
			
			ConnProperty.conClose(conn, pstmt, rsRs);
		}catch(Exception sq){
			System.out.println("회원정보 조건조회 DB 에러 >>> : " + sq.getMessage());
			System.out.println("에러 >>> : " + sq);
		}finally{
			ConnProperty.conClose(conn, pstmt, rsRs);
		}
		
		return aList;
	}

	@Override
	public boolean memberInsert(MemberVO mvo) {
		// TODO Auto-generated method stub
		System.out.println("MemberDAOImpl memberInsert() 함수 진입 >>> : ");
		// mvo 주소값이 같은지 콘솔에 확인하기 
		System.out.println("MemberDAOImpl memberInsert() :: mvo >>> : " + mvo);
//		[2] MemberDAOImpl memberInsert() :: mvo >>> : a.b.c.com.jso.mem.vo.MemberVO@8db09ae
		MemberVO.printlnMemberVO(mvo);
//		[3] printlnMemberVO mvo >>> : a.b.c.com.jso.mem.vo.MemberVO@8db09ae
		
		// 사용할 객체 선언하고 초기화하기
		Connection conn = null;
		PreparedStatement pstmt = null;
		int nCnt = 0;
		boolean bool = false;
		
		try{
			conn = ConnProperty.getConnection();
			pstmt = conn.prepareStatement(MemberSqlMap.getMemberInsertQuery());
			// placeholder들 vo깡통 이용해서 변수 pstmt에 바인딩 해주기
			// 이 때, mvo에 이미 set함수로 초기화된 값들을 get함수로 가져오게 된다.
			pstmt.clearParameters();
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
			pstmt.setString(12, mvo.getMgibunaddress());
			pstmt.setString(13, mvo.getMhobby());
			pstmt.setString(14, mvo.getMinfo());
			pstmt.setString(15, mvo.getMphoto());
			pstmt.setString(16, mvo.getMadmin());
			
			nCnt = pstmt.executeUpdate();
			
			if (!conn.getAutoCommit()){
				conn.commit();
			}
			
			if (nCnt > 0){
				System.out.println("nCnt >>> : " + nCnt + " 건 등록되었음");
				bool = true;
			}else{
				System.out.println("회원정보 등록 실패 nCnt >>> : " + nCnt + " 건");
			}
			
			ConnProperty.conClose(conn, pstmt);
		}catch(Exception sq){
			System.out.println("회원정보등록 DB 에러 >>> : " + sq.getMessage());
			System.out.println("에러 >>> : " + sq);
		}
		return bool;
	}

	@Override
	public boolean memberUpdate(MemberVO mvo) {
		// TODO Auto-generated method stub
		System.out.println("MemberDAOImpl memberUpdate() 함수 진입 >>> : ");
		
		// 사용할 객체 선언하고 초기화
		Connection conn = null;
		PreparedStatement pstmt = null;
		boolean bool = false;
		int nCnt = 0; 
		
		try {
			conn = ConnProperty.getConnection();
			pstmt = conn.prepareStatement(MemberSqlMap.getMemberUpdateQuery());
			System.out.println("수정 쿼리 확인 >>> : " + MemberSqlMap.getMemberUpdateQuery());
			pstmt.clearParameters();
			// placeholder set하기
			pstmt.setString(1, mvo.getMemail());
			pstmt.setString(2, mvo.getMzonecode());
			pstmt.setString(3, mvo.getMroadaddress());
			pstmt.setString(4, mvo.getMgibunaddress());
			pstmt.setString(5, mvo.getMhobby());
			pstmt.setString(6, mvo.getMnum());
			
			nCnt = pstmt.executeUpdate();
			
			if (!conn.getAutoCommit()){
				conn.commit();
			}
			
			if (nCnt > 0){
				bool = true;
			}else{
				System.out.println("nCnt 가 비었습니다. >>> : ");
			}
			
			ConnProperty.conClose(conn, pstmt);
		}catch(Exception sq){
			System.out.println("수정 DB 에러 >>> : " + sq.getMessage());
			System.out.println("에러 >>> : " + sq);
		}finally{
			ConnProperty.conClose(conn, pstmt);
		}
		
		return bool;
	}

	@Override
	public boolean memberDelete(MemberVO mvo) {
		// TODO Auto-generated method stub
		System.out.println("MemberDAOImpl memberDelete() 함수 진입 >>> : ");
		
		// 사용할 객체 선언하고 초기화
		Connection conn = null;
		PreparedStatement pstmt = null;
		boolean bool = false;
		int nCnt = 0;
		
		try{
			conn = ConnProperty.getConnection();
			pstmt = conn.prepareStatement(MemberSqlMap.getMemberDeleteQuery());
			pstmt.clearParameters();
			pstmt.setString(1, mvo.getMnum());
			
			nCnt = pstmt.executeUpdate();
			if (!conn.getAutoCommit()){
				conn.commit();
			}
			if (nCnt > 0){
				System.out.println("nCnt >>> : " + nCnt + " 건 삭제 되었읍");
			}else{
				System.out.println("nCnt가 비었습니다.");
			}
			
			ConnProperty.conClose(conn, pstmt);
		}catch(Exception sq){
			System.out.println("삭제 DB 에러 >>> : " + sq.getMessage());
			System.out.println("에러 >>> : " + sq);
		}finally{
			ConnProperty.conClose(conn, pstmt);
		}
		return bool;
	}

}
