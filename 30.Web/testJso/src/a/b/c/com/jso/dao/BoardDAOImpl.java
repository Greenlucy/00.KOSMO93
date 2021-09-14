package a.b.c.com.jso.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import a.b.c.com.common.ConnProperty;
import a.b.c.com.jso.sql.BoardSqlMap;
import a.b.c.com.jso.vo.BoardVO;

public class BoardDAOImpl implements BoardDAO {

	@Override
	public ArrayList<BoardVO> boardSelectAll() {
		// TODO Auto-generated method stub
		// [58]
		System.out.println("BoardDAOImpl boardSelectAll() 진입 >>> : ");
		
		// [59]
		// 사용할 객체 선언, 초기화
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rsRs = null;
		ArrayList<BoardVO> aList = null;
		
		try{
			// [60]
			conn = ConnProperty.getConnection();
			pstmt = conn.prepareStatement(BoardSqlMap.getBoardSelectAllQuery());
			System.out.println("전체조회 쿼리문 확인 >>> : " + BoardSqlMap.getBoardSelectAllQuery());
			rsRs = pstmt.executeQuery();
			
			// [61]
			if (rsRs != null){
				// ArrayList new 클래스 인스턴스 안 해줘서 java.lang.NullPointerException 오류 발생
				// while()문 안에 쓰면 첫번째 값만 출력됌..!
				aList = new ArrayList<BoardVO>();		
				while(rsRs.next()){
					// while()문 안에 쓰면 첫번째 값만 출력됌..! : 아래처럼 쓰면 클 남 ㅋㅋ
//					aList = new ArrayList<BoardVO>();
					
					BoardVO bvo = new BoardVO();
					bvo.setBnum(rsRs.getString("BNUM"));
					bvo.setBsubject(rsRs.getString("BSUBJECT"));
					bvo.setBwriter(rsRs.getString("BWRITER"));
					bvo.setBpw(rsRs.getString("BPW"));
					bvo.setBmemo(rsRs.getString("BMEMO"));
					bvo.setBphoto(rsRs.getString("BPHOTO"));
					bvo.setDeleteyn(rsRs.getString("DELETEYN"));
					bvo.setInsertdate(rsRs.getString("INSERTDATE"));
					bvo.setUpdatedate(rsRs.getString("UPDATEDATE"));
					
					aList.add(bvo);
				}
			}
			// [67]
			if (aList != null && aList.size() > 0){
				System.out.println("전체조회 aList에 정보 담기 완료");
			}else{
				System.out.println("aList가 비었습니다.");
			}
			
			// [68]
			ConnProperty.conClose(conn, pstmt, rsRs);
		}catch(Exception sq){
			System.out.println("전체조회 DB 에러 >>> : " + sq.getMessage());
			System.out.println("에러 >>> : " + sq);
		}finally{
			// [69]
			ConnProperty.conClose(conn, pstmt, rsRs);
		}
		
		// [70]
		return aList;
	}

	@Override
	public ArrayList<BoardVO> boardSelect(BoardVO bvo) {
		// TODO Auto-generated method stub
		System.out.println("BoardDAOImpl boardSelect() 함수 진입 >>> : ");
		
		// 사용할 객체 선언하고 초기화
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rsRs = null;
		ArrayList<BoardVO> aList = null;
		
		try{
			conn = ConnProperty.getConnection();
			pstmt = conn.prepareStatement(BoardSqlMap.getBoardSelectQuery());
			System.out.println("조건조회 쿼리문 확인 >>> : " + BoardSqlMap.getBoardSelectQuery());
			
			pstmt.clearParameters();
			pstmt.setString(1, bvo.getBnum());
			rsRs = pstmt.executeQuery();
			
			if (rsRs != null){
				aList = new ArrayList<BoardVO>();
				while(rsRs.next()){
					BoardVO _bvo = new BoardVO();
					_bvo.setBnum(rsRs.getString("BNUM"));
					_bvo.setBsubject(rsRs.getString("BSUBJECT"));
					_bvo.setBwriter(rsRs.getString("BWRITER"));
					_bvo.setBpw(rsRs.getString("BPW"));
					_bvo.setBmemo(rsRs.getString("BMEMO"));
					_bvo.setBphoto(rsRs.getString("BPHOTO"));
					_bvo.setDeleteyn(rsRs.getString("DELETEYN"));
					_bvo.setInsertdate(rsRs.getString("INSERTDATE"));
					_bvo.setUpdatedate(rsRs.getString("UPDATEDATE"));
					
					aList.add(_bvo);
				}
			}
		}catch(Exception e){
			System.out.println("조건조회 DB 에러 >>> : " + e.getMessage());
			System.out.println("에러 >>> : " + e);
		}
		
		return aList;
	}

	// [16]
	@Override
	public boolean boardInsert(BoardVO bvo) {
		// TODO Auto-generated method stub
		// [17]
		System.out.println("BoardDAOImpl boardInsert() 진입 >>> : ");
		
		// [18]
		// 사용할 객체 지역변수로 선언, 초기화
		Connection conn = null;
		PreparedStatement pstmt = null;
		boolean bool = false;
		int nCnt = 0;
		
		try{
			// [19] 데이터베이스와 연결 > ConnProperty 클래스 다녀옴
			conn = ConnProperty.getConnection();
			// [27] 데이터베이스와 연결 후 SqlMap의 Insert쿼리와 연결
			pstmt = conn.prepareStatement(BoardSqlMap.getBoardInsertQuery());
			// [32] 파라미터 클리어
			pstmt.clearParameters();
			// [33] 
			// void setString(int parameterIndex, String x) throws SQLException
			// 주어진 자바 스트링 value에 디자인된 파라미터를 세팅한다. 드라이버가 데이터베이스로 이 값을 보낼 때 드라이버는 이것을 SQL VARCHAR 또는 LONGVARCHAR value로 변환한다.
			// (아규먼트의 사이즈에 따라. 드라이버의 VARCHAR values의 한계와 비교하여) 
			pstmt.setString(1, bvo.getBnum());
			pstmt.setString(2, bvo.getBsubject());
			pstmt.setString(3, bvo.getBwriter());
			pstmt.setString(4, bvo.getBpw());
			pstmt.setString(5, bvo.getBmemo());
			pstmt.setString(6, bvo.getBphoto());
			// [34] execute : 실행[수행]하다 (사전적 의미)
			nCnt = pstmt.executeUpdate();
			
			// [35] 커밋 안 됐을 경우 대비
			if (!conn.getAutoCommit()){
				conn.commit();
			}
			
			// [36] 리턴형 bool에 맞게 자료가 들어오면 true로 변경해주기
			if (nCnt > 0) {
				System.out.println("BoardDAOImpl boardInsert() : nCnt >>> : " + nCnt + " 건 등록 되었음");
				bool = true;
			}else{
				System.out.println("nCnt가 비었습니다.");
			}
			
			// [37] io 닫아주기 
			ConnProperty.conClose(conn, pstmt);
		}catch(Exception sq){
			System.out.println("인서트 에러 >>> : " + sq.getMessage());
			System.out.println("에러 >>> : " + sq);
		}finally{
			// [38-1] finally (추가)
			ConnProperty.conClose(conn, pstmt);
		}
		
		// [39] 리턴 bool 
		return bool;
	}

	@Override
	public boolean boardDelete(BoardVO bvo) {
		// TODO Auto-generated method stub
		System.out.println("BoardDAOImpl boardDelete() 함수 진입 >>> : ");
		
		// 사용할 객체 선언하고 초기화
		Connection conn = null;
		PreparedStatement pstmt = null;
		int nCnt = 0; 
		boolean bool = false;
		
		try{
			conn = ConnProperty.getConnection();
			pstmt = conn.prepareStatement(BoardSqlMap.getBoardDeleteQuery());
			System.out.println("글 삭제 쿼리 확인 >>> : " + BoardSqlMap.getBoardDeleteQuery());
			
			pstmt.clearParameters();
			pstmt.setString(1, bvo.getBnum());
			nCnt = pstmt.executeUpdate();
			
			if (!conn.getAutoCommit()){
				conn.commit();
			}
			if (nCnt > 0){
				System.out.println("nCnt >>> : " + nCnt + " 건 삭제 되었음");
				bool = true;
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

	@Override
	public boolean boardUpdate(BoardVO bvo) {
		// TODO Auto-generated method stub
		System.out.println("BoardDAOImpl boardUpdate() 함수 진입 >>> : ");
		
		// 사용할 객체 선언하고 초기화
		Connection conn = null;
		PreparedStatement pstmt = null;
		int nCnt = 0;
		boolean bool = false;
		
		try{
			conn = ConnProperty.getConnection();
			pstmt = conn.prepareStatement(BoardSqlMap.getBoardUpdateQuery());
			System.out.println("글수정 쿼리문 확인 >>> : " + BoardSqlMap.getBoardUpdateQuery());
			
			// placeholder 바인딩하기
			// 이제보니 key & value라서 getString()함수에서 1,2,3 입력할 수 있는거구나..
			// setString(int, String) : key가 무조건 int
			pstmt.clearParameters();
			pstmt.setString(1, bvo.getBsubject());
			pstmt.setString(2, bvo.getBmemo());
			pstmt.setString(3, bvo.getBnum());
			
			// executeUpdate() 함수의 리턴형은 int >> 받을 수 있는 int변수 만들어줘야 함
			nCnt = pstmt.executeUpdate();
			
			if (!conn.getAutoCommit()){
				conn.commit();
			}
			if (nCnt > 0) {
				System.out.println("nCnt >>> : " + nCnt + " 건 수정 되었음");
				bool = true;
			}else{
				System.out.println("수정 실패 !!!");
				System.out.println("nCnt >>> : " + nCnt + " 건 수정 되었음");
			}
			
			ConnProperty.conClose(conn, pstmt);
		}catch(Exception sq){
			System.out.println("글 수정 DB 에러 >>> : " + sq.getMessage());
			System.out.println("에러 >>> : " + sq);
		}finally{
			ConnProperty.conClose(conn, pstmt);
		}
		return bool;
	}
}
