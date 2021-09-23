package a.b.c.com.kosmo.mem.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import a.b.c.com.common.ConnProperty;
import a.b.c.com.kosmo.mem.sql.MemberSqlMap;
import a.b.c.com.kosmo.mem.vo.MemberVO;

public class MemberDAOImpl implements MemberDAO {

	// 전체 조회
	@Override
	public ArrayList<MemberVO> memberSelectAll() {
		// TODO Auto-generated method stub
		System.out.println("MemberDAOImpl.memberSelectAll() 함수 진입 ");
				
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rsRs = null;
		
		ArrayList<MemberVO> aList = null;
		
		try {
			
			conn = ConnProperty.getConnection();
			pstmt = conn.prepareStatement(MemberSqlMap.getMemberSelectAllQuery());
			
			System.out.println("전체조회 \n" + MemberSqlMap.getMemberSelectAllQuery());			
			
			rsRs = pstmt.executeQuery();			
			
			if (rsRs !=null) {
				
				aList = new ArrayList<MemberVO>();
				
				while (rsRs.next()) {
					
					MemberVO _mvo = new MemberVO();
					
					_mvo.setMnum(rsRs.getString(1)); 
					_mvo.setMname(rsRs.getString(2)); 
					_mvo.setMid(rsRs.getString(3));
					_mvo.setMpw(rsRs.getString(4));
					_mvo.setMgender(rsRs.getString(5));
					_mvo.setMbirth(rsRs.getString(6));
					_mvo.setMhp(rsRs.getString(7));					
					_mvo.setMtel(rsRs.getString(8));
					_mvo.setMemail(rsRs.getString(9));					
					_mvo.setMzonecode(rsRs.getString(10));
					_mvo.setMroadaddress(rsRs.getString(11));
					_mvo.setMjibunaddress(rsRs.getString(12));					
					_mvo.setMhobby(rsRs.getString(13));
					_mvo.setMinfo(rsRs.getString(14));
					_mvo.setMphoto(rsRs.getString(15));					
					_mvo.setMadmin(rsRs.getString(16));
					_mvo.setDeleteyn(rsRs.getString(17));
					_mvo.setInsertdate(rsRs.getString(18));
					_mvo.setUpdatedate(rsRs.getString(19));
					
					aList.add(_mvo);
					MemberVO.printlnMemberVO(_mvo);
				}				
			}
			ConnProperty.conClose(conn, pstmt, rsRs);
		}catch(Exception e) {
			System.out.println("memberSelectAll() 함수에서 디비연결 또는 쿼리에서 문제가 생겼네요 >>> : " + e.getMessage());
		}finally {
			ConnProperty.conClose(conn, pstmt, rsRs);
		}
		
		return aList;	
	}

	@Override
	public ArrayList<MemberVO> memberSelect(MemberVO mvo) {
		// TODO Auto-generated method stub
		System.out.println("MemberDAOImpl.memberSelect() 함수 진입 ");
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rsRs = null;
		
		ArrayList<MemberVO> aList = null;
		
		try {
			
			conn = ConnProperty.getConnection();
			pstmt = conn.prepareStatement(MemberSqlMap.getMemberSelectQuery());			
			System.out.println("조건조회 \n" + MemberSqlMap.getMemberSelectQuery());			
			
			pstmt.clearParameters();
			// 플레이스홀더에 바인딩한 변수를 세팅한다. 
			pstmt.setString(1, mvo.getMnum());
			rsRs = pstmt.executeQuery();			
			
			if (rsRs !=null) {
				
				aList = new ArrayList<MemberVO>();
				
				while (rsRs.next()) {
					
					MemberVO _mvo = new MemberVO();
					
					_mvo.setMnum(rsRs.getString(1)); 
					_mvo.setMname(rsRs.getString(2)); 
					_mvo.setMid(rsRs.getString(3));
					_mvo.setMpw(rsRs.getString(4));
					_mvo.setMgender(rsRs.getString(5));
					_mvo.setMbirth(rsRs.getString(6));
					_mvo.setMhp(rsRs.getString(7));					
					_mvo.setMtel(rsRs.getString(8));
					_mvo.setMemail(rsRs.getString(9));					
					_mvo.setMzonecode(rsRs.getString(10));
					_mvo.setMroadaddress(rsRs.getString(11));
					_mvo.setMjibunaddress(rsRs.getString(12));					
					_mvo.setMhobby(rsRs.getString(13));
					_mvo.setMinfo(rsRs.getString(14));
					_mvo.setMphoto(rsRs.getString(15));					
					_mvo.setMadmin(rsRs.getString(16));
					_mvo.setDeleteyn(rsRs.getString(17));
					_mvo.setInsertdate(rsRs.getString(18));
					_mvo.setUpdatedate(rsRs.getString(19));
					
					aList.add(_mvo);
				}				
			}
			ConnProperty.conClose(conn, pstmt, rsRs);
		}catch(Exception e) {
			System.out.println("memberSelect() 함수에서 디비연결 또는 쿼리에서 문제가 생겼네요 >>> : " + e.getMessage());
		}finally {
			ConnProperty.conClose(conn, pstmt, rsRs);
		}
		
		return aList;	
	}

	@Override
	public boolean memberInsert(MemberVO mvo) {
		// TODO Auto-generated method stub
		System.out.println("MemberDAOImpl memberInsert() 함수 진입 >>> : ");
		MemberVO.printlnMemberVO(mvo);
		
		// 사용할 객체를 지역변수로 선언하고 초기화 하기 
		Connection conn = null;
		PreparedStatement pstmt = null;
		int nCnt = 0;
		boolean bool = false;
		
		try {			
			conn = ConnProperty.getConnection();
			System.out.println("conn.getAutoCommit() >>> : " + conn.getAutoCommit());
			
			pstmt = conn.prepareStatement(MemberSqlMap.getMemberInsertQuery());
			System.out.println("입력하기 >>> : \n"+ MemberSqlMap.getMemberInsertQuery());
  			
			// 파라미터 클리어 꼭 하기 
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
			pstmt.setString(12, mvo.getMjibunaddress());
			pstmt.setString(13, mvo.getMhobby());
			pstmt.setString(14, mvo.getMinfo());
			pstmt.setString(15, mvo.getMphoto());
			pstmt.setString(16, mvo.getMadmin());
			/*
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
			*/
			nCnt = pstmt.executeUpdate();						
			if (!conn.getAutoCommit()) conn.commit();			
			
			System.out.println("nCnt >>> : " + nCnt + " 건 등록 되었음 ");
			
			if (nCnt > 0) { bool = true;}
			
			ConnProperty.conClose(conn, pstmt);
		}catch(Exception e) {
			System.out.println("입력 디비연동에 문제가 생겼습니다. >>> : " + e);
		}finally {
			try {
				ConnProperty.conClose(conn, pstmt);				
			}catch(Exception e2) {}
		}
				
		return bool;
	}

	@Override
	public boolean memberUpdate(MemberVO mvo) {
		// TODO Auto-generated method stub
		System.out.println("MemberDAOImpl memberUpdate() 함수 진입 >>> : ");
		
		// 사용할 객체를 지역변수로 선언하고 초기화 하기 
		Connection conn = null;
		PreparedStatement pstmt = null;
		int nCnt = 0;
		boolean bool = false;
		
		try {			
			conn = ConnProperty.getConnection();
			System.out.println("conn.getAutoCommit() >>> : " + conn.getAutoCommit());
			
			pstmt = conn.prepareStatement(MemberSqlMap.getMemberUpdateQuery());
			System.out.println("수정하기 >>> : \n"+ MemberSqlMap.getMemberUpdateQuery());
  			
			// 파라미터 클리어 꼭 하기 
			pstmt.clearParameters();			
			pstmt.setString(1, mvo.getMemail());
			pstmt.setString(2, mvo.getMzonecode());
			pstmt.setString(3, mvo.getMroadaddress());
			pstmt.setString(4, mvo.getMjibunaddress());
			pstmt.setString(5, mvo.getMhobby());			
			pstmt.setString(6, mvo.getMnum()); 
			
			nCnt = pstmt.executeUpdate();						
			if (!conn.getAutoCommit()) conn.commit();			
			
			System.out.println("nCnt >>> : " + nCnt + " 건 수정 되었음 ");
			
			if (nCnt > 0) { bool = true;}
			
			ConnProperty.conClose(conn, pstmt);
		}catch(Exception e) {
			System.out.println("입력 디비연동에 문제가 생겼습니다. >>> : " + e);
		}finally {
			try {
				ConnProperty.conClose(conn, pstmt);				
			}catch(Exception e2) {}
		}
				
		return bool;
	}

	@Override
	public boolean memberDelete(MemberVO mvo) {
		// TODO Auto-generated method stub
		System.out.println("MemberDAOImpl memberUpdate() 함수 진입 >>> : ");
		
		// 사용할 객체를 지역변수로 선언하고 초기화 하기 
		Connection conn = null;
		PreparedStatement pstmt = null;
		int nCnt = 0;
		boolean bool = false;
		
		try {			
			conn = ConnProperty.getConnection();
			System.out.println("conn.getAutoCommit() >>> : " + conn.getAutoCommit());
			
			pstmt = conn.prepareStatement(MemberSqlMap.getMemberDeleteQuery());
			System.out.println("삭제하기 >>> : \n"+ MemberSqlMap.getMemberDeleteQuery());
  			
			// 파라미터 클리어 꼭 하기 
			pstmt.clearParameters();			
			pstmt.setString(1, mvo.getMnum()); 
			
			nCnt = pstmt.executeUpdate();						
			if (!conn.getAutoCommit()) conn.commit();			
			
			System.out.println("nCnt >>> : " + nCnt + " 건 삭제 되었음 ");
			
			if (nCnt > 0) { bool = true;}
			
			ConnProperty.conClose(conn, pstmt);
		}catch(Exception e) {
			System.out.println("입력 디비연동에 문제가 생겼습니다. >>> : " + e);
		}finally {
			try {
				ConnProperty.conClose(conn, pstmt);				
			}catch(Exception e2) {}
		}
				
		return bool;
	}
}
