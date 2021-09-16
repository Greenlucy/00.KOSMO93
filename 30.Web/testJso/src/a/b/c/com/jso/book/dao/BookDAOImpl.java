package a.b.c.com.jso.book.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import a.b.c.com.common.ConnProperty;
import a.b.c.com.jso.book.sql.BookSqlMap;
import a.b.c.com.jso.book.vo.BookVO;

public class BookDAOImpl implements BookDAO {

	@Override
	public ArrayList<BookVO> bookSelectAll() {
		// TODO Auto-generated method stub
		System.out.println("BookDAOImpl bookSelectAll() 함수 진입 >>> : ");
		
		// 사용할 객체 선언하고 초기화하기
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rsRs = null;
		ArrayList<BookVO> aList = null;
		int nCnt = 0;
		
		try{
			conn = ConnProperty.getConnection();
			pstmt = conn.prepareStatement(BookSqlMap.getSelectAllQuery());
			System.out.println("도서정보_전체조회 쿼리 확인 >>> : " + BookSqlMap.getSelectAllQuery());
			rsRs = pstmt.executeQuery();
			
			if (rsRs != null){
				// ArrayList<BookVO> 메모리에 인스턴스 >> 담을 수 있는 공간 확보
				aList = new ArrayList<BookVO>();
				
				// db 테이블에 저장된 데이터들을 "행의 수만큼" 모두 출력하기 위해 while 반복문 사용
				// 커서함수 ResultSet.next() 사용하여 boolean 리턴
				while (rsRs.next()){
					// BookVO 인스턴스
					BookVO bvo = new BookVO();
					// 가져온 쿼리가 저장된 rsRs객체변수에서 컬럼 String을(key) setter()함수의 아규먼트로 리턴하여
					// bvo 참조변수에 초기화하기
					bvo.setBnum(rsRs.getString("BNUM"));
					bvo.setBtitle(rsRs.getString("BTITLE"));
					bvo.setBauth(rsRs.getString("BAUTH"));
					bvo.setIsbn(rsRs.getString("ISBN"));
					bvo.setBcomp(rsRs.getString("BCOMP"));
					bvo.setBprice(rsRs.getString("BPRICE"));
					bvo.setBqty(rsRs.getString("BQTY"));
					bvo.setBcover(rsRs.getString("BCOVER"));
					bvo.setDeleteyn(rsRs.getString("DELETEYN"));
					bvo.setInsertdate(rsRs.getString("INSERTDATE"));
					bvo.setUpdatedate(rsRs.getString("UPDATEDATE"));
					
					// aList에 bvo의 저장된 데이터들을 "행 별로" 구분하여 담기 
					aList.add(bvo);
					System.out.println("BookVO.printBookVO(bvo) >>> : ");
					BookVO.printBookVO(bvo);
				}
			}
			
			if (aList != null && aList.size() > 0){
				System.out.println("전체조회 >>> : " + aList.size() + " 건 있음");
			}else{
				System.out.println("aList가 비었습니다.");
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
	public ArrayList<BookVO> bookSelect(BookVO bvo) {
		// TODO Auto-generated method stub
		System.out.println("BookDAOImpl bookSelect() 함수 진입 >>> : ");
		
		// 사용할 객체 선언하고 초기화
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rsRs = null;
		ArrayList<BookVO> aList = null;
		
		try{
			conn = ConnProperty.getConnection();
			pstmt = conn.prepareStatement(BookSqlMap.getSelectQuery());
			System.out.println("조건조회 쿼리 확인 >>> : " + BookSqlMap.getSelectQuery());
			// placeholder 바인딩 해주기
			pstmt.clearParameters();
			pstmt.setString(1, bvo.getBnum());
			
			rsRs = pstmt.executeQuery();
			
			if (rsRs != null){
				aList = new ArrayList<BookVO>();
				while(rsRs.next()){
					BookVO _bvo = new BookVO();
					_bvo.setBnum(rsRs.getString("BNUM"));
					_bvo.setBtitle(rsRs.getString(2));
					_bvo.setBauth(rsRs.getString(3));
					_bvo.setIsbn(rsRs.getString(4));
					_bvo.setBcomp(rsRs.getString(5));
					_bvo.setBprice(rsRs.getString(6));
					_bvo.setBqty(rsRs.getString(7));
					_bvo.setBcover(rsRs.getString(8));
					_bvo.setDeleteyn(rsRs.getString(9));
					_bvo.setInsertdate(rsRs.getString(10));
					_bvo.setUpdatedate(rsRs.getString(11));
					
					aList.add(_bvo);
				}
				System.out.println("aList.size() >>> : " + aList.size() + " 건 조회 되었음");
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
	public int bookInsert(BookVO bvo) {
		// TODO Auto-generated method stub
		System.out.println("BookDAOImpl bookInsert() 함수 진입 >>> : ");
		
		// 사용할 객체 선언하고 초기화하기
		Connection conn = null;
		PreparedStatement pstmt = null;
		int nCnt = 0; 
		
		try{
			conn = ConnProperty.getConnection();
			pstmt = conn.prepareStatement(BookSqlMap.getInsertQuery());
			System.out.println("책등록 쿼리 확인 >>> : " + BookSqlMap.getInsertQuery());
			
			pstmt.clearParameters();
			// setString(int parameterIndex, String x)
			pstmt.setString(1, bvo.getBnum());
			pstmt.setString(2, bvo.getBtitle());
			pstmt.setString(3, bvo.getBauth());
			pstmt.setString(4, bvo.getIsbn());
			pstmt.setString(5, bvo.getBcomp());
			pstmt.setString(6, bvo.getBprice());
			pstmt.setString(7, bvo.getBqty());
			pstmt.setString(8, bvo.getBcover());
			
			nCnt = pstmt.executeUpdate();
			
			if (!conn.getAutoCommit()){
				conn.commit();
			}
			if (nCnt > 0){
				System.out.println("nCnt >>> : " + nCnt + " 건 등록 되었음");
			}else{
				System.out.println("nCnt가 비었습니다.");
			}
			
			ConnProperty.conClose(conn, pstmt);
		}catch(Exception sq){
			System.out.println("책등록 DB 에러 >>> : " + sq.getMessage());
			System.out.println("에러 >>> : " + sq);
		}finally{
			ConnProperty.conClose(conn, pstmt);
		}
		
		return nCnt;
	}

	@Override
	public int bookUpdate(BookVO bvo) {
		// TODO Auto-generated method stub
		System.out.println("BookDAOImpl bookUpdate() 함수 진입 >>> : ");
		
		// 사용할 객채 선언하고 초기화
		Connection conn = null;
		PreparedStatement pstmt = null;
		int nCnt = 0;
		
		try{
			conn = ConnProperty.getConnection();
			pstmt = conn.prepareStatement(BookSqlMap.getUpdateQuery());
			System.out.println("도서정보수정 쿼리 확인 >>> : " + BookSqlMap.getUpdateQuery());
			// placeholder 바인딩하기
			pstmt.clearParameters();
			pstmt.setString(1, bvo.getBprice());
			pstmt.setString(2, bvo.getBqty());
			pstmt.setString(3, bvo.getBcover());
			pstmt.setString(4, bvo.getBnum());
			
			nCnt = pstmt.executeUpdate();
			
			if (!conn.getAutoCommit()){
				conn.commit();
			}
			
			if (nCnt > 0){
				System.out.println("nCnt >>> : " + nCnt + " 건 수정 되었음");
			}else{
				System.out.println("nCnt가 비었습니다.");
			}
			
			ConnProperty.conClose(conn, pstmt);
		}catch(Exception sq){
			System.out.println("도서정보수정 DB 에러 >>> : " + sq.getMessage());
			System.out.println("에러 >>> : " + sq);
		}finally{
			ConnProperty.conClose(conn, pstmt);
		}
		
		return nCnt;
	}

	@Override
	public int bookDelete(BookVO bvo) {
		// TODO Auto-generated method stub
		System.out.println("BookDAOImpl bookDelete() 함수 진입 >>> : ");
		
		// 사용할 객체 선언하고 초기화하기
		Connection conn = null;
		PreparedStatement pstmt = null;
		int nCnt = 0;
		
		try{
			conn = ConnProperty.getConnection();
			pstmt = conn.prepareStatement(BookSqlMap.getDeleteQuery());
			// placeholder 바인딩하기
			pstmt.clearParameters();
			pstmt.setString(1, bvo.getBnum());
			
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
			System.out.println("도서정보 삭제 DB 에러 >>> : " + sq.getMessage());
			System.out.println("에러 >>> : " + sq);
		}finally{
			ConnProperty.conClose(conn, pstmt);
		}
		
		return nCnt;
	}

}
