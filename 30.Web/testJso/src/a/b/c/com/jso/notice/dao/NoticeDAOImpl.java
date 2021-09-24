package a.b.c.com.jso.notice.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import a.b.c.com.common.ConnProperty;
import a.b.c.com.jso.notice.dao.NoticeDAO;
import a.b.c.com.jso.notice.sql.NoticeSqlMap;
import a.b.c.com.jso.notice.vo.NoticeVO;

public class NoticeDAOImpl implements NoticeDAO {

	@Override
	public ArrayList<NoticeVO> noticeSelectAll() {
		// TODO Auto-generated method stub
		System.out.println("NoticeDAOImpl noticeSelectAll() 함수 진입 >>> : ");
		
		// 사용할 객체 선언하고 초기화
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rsRs = null;
		ArrayList<NoticeVO> aList = null;
		
		try{
			conn = ConnProperty.getConnection();
			pstmt = conn.prepareStatement(NoticeSqlMap.getNoticeSelectAllQuery());
			rsRs = pstmt.executeQuery();
			
			if (rsRs != null){
				aList = new ArrayList<NoticeVO>();
				while(rsRs.next()){
					
					NoticeVO nvo = new NoticeVO();
					nvo.setNnum(rsRs.getString("NNUM"));
					nvo.setNsubject(rsRs.getString("NSUBJECT"));
					nvo.setNmemo(rsRs.getString("NMEMO"));
					nvo.setNphoto(rsRs.getString("NPHOTO"));
					nvo.setDeleteyn(rsRs.getString("DELETEYN"));
					nvo.setInsertdate(rsRs.getString("INSERTDATE"));
					nvo.setUpdatedate(rsRs.getString("UPDATEDATE"));
					
					NoticeVO.printNoticeVO(nvo);
					aList.add(nvo);
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
	public ArrayList<NoticeVO> noticeSelect(NoticeVO nvo) {
		// TODO Auto-generated method stub
		System.out.println("NoticeDAOImpl noticeSelect() 함수 진입 >>> : ");
		NoticeVO.printlnNoticeVO(nvo);
		
		// 사용할 객체 선언하고 초기화
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rsRs = null;
		ArrayList<NoticeVO> aList = null;
		
		try{
			conn = ConnProperty.getConnection();
			pstmt = conn.prepareStatement(NoticeSqlMap.getNoticeSelectQuery());
			System.out.println("조건조회 쿼리 확인 >>> : " + NoticeSqlMap.getNoticeSelectQuery());
			// 컨틀로러로부터 넘어온 데이터 set함수 사용하여 바인딩해주기
			pstmt.clearParameters();
			pstmt.setString(1, nvo.getNnum());
			
			rsRs = pstmt.executeQuery();
			if (rsRs != null){
				aList = new ArrayList<NoticeVO>();
				while(rsRs.next()){
					
					NoticeVO _nvo = new NoticeVO();
					_nvo.setNnum(rsRs.getString("NNUM"));
					_nvo.setNsubject(rsRs.getString("NSUBJECT"));
					_nvo.setNmemo(rsRs.getString("NMEMO"));
					_nvo.setNphoto(rsRs.getString("NPHOTO"));
					_nvo.setDeleteyn(rsRs.getString("DELETEYN"));
					_nvo.setInsertdate(rsRs.getString("INSERTDATE"));
					_nvo.setUpdatedate(rsRs.getString("UPDATEDATE"));
					
					aList.add(_nvo);
				}
			}
			
			ConnProperty.conClose(conn, pstmt, rsRs);
		}catch(Exception sq){
			System.out.println("조건조회 DB 에러 >>> : " + sq.getMessage());
			System.out.println("에러 >>> : " + sq);
		}finally{
			ConnProperty.conClose(conn, pstmt, rsRs);
		}
		return aList;
	}

	@Override
	public int noticeInsert(NoticeVO nvo) {
		// TODO Auto-generated method stub
		System.out.println("NoticeDAOImpl noticeInsert() 함수 진입 >>> : ");
		NoticeVO.printNoticeVO(nvo);
		
		// 사용할 객체 선언하고 초기화
		Connection conn = null;
		PreparedStatement pstmt = null;
		int nCnt = 0;
		
		try{
			conn = ConnProperty.getConnection();
			pstmt = conn.prepareStatement(NoticeSqlMap.getNoticeInsertQuery());
			System.out.println("등록 쿼리 확인 >>> : " + NoticeSqlMap.getNoticeInsertQuery());
			// placeholder에 컨트롤러로부터 넘어온 데이터 바인딩해주기
			pstmt.clearParameters();
			pstmt.setString(1, nvo.getNnum());
			pstmt.setString(2, nvo.getNsubject());
			pstmt.setString(3, nvo.getNmemo());
			pstmt.setString(4, nvo.getNphoto());
			
			nCnt = pstmt.executeUpdate();
			
			if (!conn.getAutoCommit()){
				conn.commit();
			}
			
			if (nCnt > 0){ 
				System.out.println("NoticeDAOImpl : nCnt >>> : " + nCnt + " 건 등록 되었음");
			}else{
				System.out.println("등록 실패 !!");
			}
			
			ConnProperty.conClose(conn, pstmt);
		}catch(Exception sq){
			System.out.println("등록 DB 에러 >>> : " + sq.getMessage());
			System.out.println("에러 >>> : " + sq);
		}finally{
			ConnProperty.conClose(conn, pstmt);
		}
		
		return nCnt;
	}

	@Override
	public int noticeUpdate(NoticeVO nvo) {
		// TODO Auto-generated method stub
		System.out.println("NoticeDAOImpl noticeUpdate() 함수 진입 >>> : ");
		NoticeVO.printlnNoticeVO(nvo);
		
		// 사용할 객체 선언하고 초기화
		Connection conn = null;
		PreparedStatement pstmt = null;
		int nCnt = 0;
		
		try{
			conn = ConnProperty.getConnection();
			pstmt = conn.prepareStatement(NoticeSqlMap.getNoticeUpdateQuery());
			System.out.println("수정 쿼리 확인 >>> : " + NoticeSqlMap.getNoticeUpdateQuery());
			// 웹브라우저에서 받은 placeholder 바인딩하기
			pstmt.clearParameters();
			pstmt.setString(1, nvo.getNsubject());
			pstmt.setString(2, nvo.getNmemo());
			pstmt.setString(3, nvo.getNnum());
			
			nCnt = pstmt.executeUpdate();
			if (!conn.getAutoCommit()){
				conn.commit();
			}
			if (nCnt > 0){
				System.out.println("nCnt >>> : " + nCnt + " 건 수정 되었음 ");
			}else{
				System.out.println("nCnt가 비었습니다.");
			}
			
			ConnProperty.conClose(conn, pstmt);
		}catch(Exception sq){
			System.out.println("수정 DB 에러 >>> : " + sq.getMessage());
			System.out.println("에러 >>> : " + sq);
		}finally{
			ConnProperty.conClose(conn, pstmt);
		}
		return nCnt;
	}

	@Override
	public int noticeDelete(NoticeVO nvo) {
		// TODO Auto-generated method stub
		System.out.println("NoticeDAOImpl noticeDelete() 함수 진입 >>> : ");
		NoticeVO.printlnNoticeVO(nvo);
		
		// 사용할 객체 선언하고 초기화
		Connection conn = null;
		PreparedStatement pstmt = null;
		int nCnt = 0;
		
		try{
			conn =ConnProperty.getConnection();
			pstmt = conn.prepareStatement(NoticeSqlMap.getNoticeDeleteQuery());
			System.out.println("삭제 쿼리 확인 >>> : " + NoticeSqlMap.getNoticeDeleteQuery());
			pstmt.clearParameters();
			pstmt.setString(1, nvo.getNnum());
			
			nCnt = pstmt.executeUpdate();
			
			if (!conn.getAutoCommit()){
				conn.commit();
			}
			
			if (nCnt > 0){
				System.out.println("nCnt >>> : " + nCnt + " 건 삭제 되었음");
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
		
		return nCnt;
	}

}
