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
		System.out.println("NoticeDAOImpl noticeSelectAll() �Լ� ���� >>> : ");
		
		// ����� ��ü �����ϰ� �ʱ�ȭ
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
			System.out.println("��ü��ȸ DB ���� >>> : " + sq.getMessage());
			System.out.println("���� >>> : " + sq);
		}finally{
			ConnProperty.conClose(conn, pstmt, rsRs);
		}
		
		return aList;
	}

	@Override
	public ArrayList<NoticeVO> noticeSelect(NoticeVO nvo) {
		// TODO Auto-generated method stub
		System.out.println("NoticeDAOImpl noticeSelect() �Լ� ���� >>> : ");
		NoticeVO.printlnNoticeVO(nvo);
		
		// ����� ��ü �����ϰ� �ʱ�ȭ
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rsRs = null;
		ArrayList<NoticeVO> aList = null;
		
		try{
			conn = ConnProperty.getConnection();
			pstmt = conn.prepareStatement(NoticeSqlMap.getNoticeSelectQuery());
			System.out.println("������ȸ ���� Ȯ�� >>> : " + NoticeSqlMap.getNoticeSelectQuery());
			// ��Ʋ�η��κ��� �Ѿ�� ������ set�Լ� ����Ͽ� ���ε����ֱ�
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
			System.out.println("������ȸ DB ���� >>> : " + sq.getMessage());
			System.out.println("���� >>> : " + sq);
		}finally{
			ConnProperty.conClose(conn, pstmt, rsRs);
		}
		return aList;
	}

	@Override
	public int noticeInsert(NoticeVO nvo) {
		// TODO Auto-generated method stub
		System.out.println("NoticeDAOImpl noticeInsert() �Լ� ���� >>> : ");
		NoticeVO.printNoticeVO(nvo);
		
		// ����� ��ü �����ϰ� �ʱ�ȭ
		Connection conn = null;
		PreparedStatement pstmt = null;
		int nCnt = 0;
		
		try{
			conn = ConnProperty.getConnection();
			pstmt = conn.prepareStatement(NoticeSqlMap.getNoticeInsertQuery());
			System.out.println("��� ���� Ȯ�� >>> : " + NoticeSqlMap.getNoticeInsertQuery());
			// placeholder�� ��Ʈ�ѷ��κ��� �Ѿ�� ������ ���ε����ֱ�
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
				System.out.println("NoticeDAOImpl : nCnt >>> : " + nCnt + " �� ��� �Ǿ���");
			}else{
				System.out.println("��� ���� !!");
			}
			
			ConnProperty.conClose(conn, pstmt);
		}catch(Exception sq){
			System.out.println("��� DB ���� >>> : " + sq.getMessage());
			System.out.println("���� >>> : " + sq);
		}finally{
			ConnProperty.conClose(conn, pstmt);
		}
		
		return nCnt;
	}

	@Override
	public int noticeUpdate(NoticeVO nvo) {
		// TODO Auto-generated method stub
		System.out.println("NoticeDAOImpl noticeUpdate() �Լ� ���� >>> : ");
		NoticeVO.printlnNoticeVO(nvo);
		
		// ����� ��ü �����ϰ� �ʱ�ȭ
		Connection conn = null;
		PreparedStatement pstmt = null;
		int nCnt = 0;
		
		try{
			conn = ConnProperty.getConnection();
			pstmt = conn.prepareStatement(NoticeSqlMap.getNoticeUpdateQuery());
			System.out.println("���� ���� Ȯ�� >>> : " + NoticeSqlMap.getNoticeUpdateQuery());
			// ������������ ���� placeholder ���ε��ϱ�
			pstmt.clearParameters();
			pstmt.setString(1, nvo.getNsubject());
			pstmt.setString(2, nvo.getNmemo());
			pstmt.setString(3, nvo.getNnum());
			
			nCnt = pstmt.executeUpdate();
			if (!conn.getAutoCommit()){
				conn.commit();
			}
			if (nCnt > 0){
				System.out.println("nCnt >>> : " + nCnt + " �� ���� �Ǿ��� ");
			}else{
				System.out.println("nCnt�� ������ϴ�.");
			}
			
			ConnProperty.conClose(conn, pstmt);
		}catch(Exception sq){
			System.out.println("���� DB ���� >>> : " + sq.getMessage());
			System.out.println("���� >>> : " + sq);
		}finally{
			ConnProperty.conClose(conn, pstmt);
		}
		return nCnt;
	}

	@Override
	public int noticeDelete(NoticeVO nvo) {
		// TODO Auto-generated method stub
		System.out.println("NoticeDAOImpl noticeDelete() �Լ� ���� >>> : ");
		NoticeVO.printlnNoticeVO(nvo);
		
		// ����� ��ü �����ϰ� �ʱ�ȭ
		Connection conn = null;
		PreparedStatement pstmt = null;
		int nCnt = 0;
		
		try{
			conn =ConnProperty.getConnection();
			pstmt = conn.prepareStatement(NoticeSqlMap.getNoticeDeleteQuery());
			System.out.println("���� ���� Ȯ�� >>> : " + NoticeSqlMap.getNoticeDeleteQuery());
			pstmt.clearParameters();
			pstmt.setString(1, nvo.getNnum());
			
			nCnt = pstmt.executeUpdate();
			
			if (!conn.getAutoCommit()){
				conn.commit();
			}
			
			if (nCnt > 0){
				System.out.println("nCnt >>> : " + nCnt + " �� ���� �Ǿ���");
			}else{
				System.out.println("nCnt�� ������ϴ�.");
			}
			
			ConnProperty.conClose(conn, pstmt);
		}catch(Exception sq){
			System.out.println("���� DB ���� >>> : " + sq.getMessage());
			System.out.println("���� >>> : " + sq);
		}finally{
			ConnProperty.conClose(conn, pstmt);
		}
		
		return nCnt;
	}

}
