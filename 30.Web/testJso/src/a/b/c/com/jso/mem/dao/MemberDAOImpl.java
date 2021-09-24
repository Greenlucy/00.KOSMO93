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
		System.out.println("MemberDAOImpl memberSelectAll() �Լ� ���� >>> : ");
//		MemberVO _mvo = new MemberVO();
//		MemberVO.printlnMemberVO(_mvo);
//		[6] printlnMemberVO mvo >>> : a.b.c.com.jso.mem.vo.MemberVO@718d3b5a
//		System.out.println("MemberDAOImpl memberSelectAll() :: _mvo >>> : " + _mvo);
//		[7] MemberDAOImpl memberSelectAll() :: _mvo >>> : a.b.c.com.jso.mem.vo.MemberVO@718d3b5a
		
		// ����� ��ü �����ϰ� �ʱ�ȭ�ϱ�
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rsRs = null;
		ArrayList<MemberVO> aList = null;
		try{
			conn = ConnProperty.getConnection();
			pstmt = conn.prepareStatement(MemberSqlMap.getMemberSelectAllQuery());
			System.out.println("��ü��ȸ ���� Ȯ�� >>> : " + MemberSqlMap.getMemberSelectAllQuery());
			rsRs = pstmt.executeQuery();
			
			if (rsRs != null){
				// ArrayList<MemberVO> �޸𸮿� �ν��Ͻ�
				aList = new ArrayList<MemberVO>();
				while(rsRs.next()){
					// vo ���뿡 set �ʱ�ȭ ���ֱ�
					MemberVO mvo = new MemberVO();
					// mvo �ּҰ��� ������ �ֿܼ� �� Ȯ���غ���
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
			System.out.println("��ü��ȸ DB ���� >>> : " + sq.getMessage());
			System.out.println("���� >>> : " + sq);
		}finally{
			ConnProperty.conClose(conn, pstmt, rsRs);
		}
		return aList;
	}

	@Override
	public ArrayList<MemberVO> memberSelect(MemberVO mvo) {
		// TODO Auto-generated method stub
		System.out.println("MemberDAOImpl memberSelect() �Լ� ���� >>> : ");
		MemberVO.printMemberVO(mvo);
		
		// ����� ��ü �����ϰ� �ʱ�ȭ�ϱ�
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rsRs = null;
		ArrayList<MemberVO> aList = null;
		
		try{
			conn = ConnProperty.getConnection();
			pstmt = conn.prepareStatement(MemberSqlMap.getMemberSelectQuery());
			System.out.println("������ȸ(ȸ����ȣ) ���� Ȯ�� >>> : " + MemberSqlMap.getMemberSelectQuery());
			pstmt.clearParameters();
			// �������κ��� �Է¹޾� ��Ʈ�ѷ��� ��ģ placeholder�� pstmt�� set�ϱ�
			pstmt.setString(1, mvo.getMnum());
			System.out.println("MemberDAOImpl memSelect() �Լ� : pstmt.setString(1, mvo.getMnum()) ���� :: print >>> : ");
			MemberVO.printMemberVO(mvo);
			
			rsRs = pstmt.executeQuery();
			if (rsRs != null) {
				aList = new ArrayList<MemberVO>();
				// ȸ����ȣ �κ���ġ�ϴ� �͵��� ���� �� �����ϱ�, ��ȸ�� �ݺ��� ����Ͽ���..
				while(rsRs.next()){
					// ���� �÷��� ���� �޾Ƽ�, (�ʿ��� �͵鸸 ���� �ҷ���) ������ ���ο� �ּҰ��� �����ϱ� > �� aList�� ���
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
					System.out.println("MemberDAOImpl memSelect()�Լ� : while() :: print >>> : ");
					MemberVO.printMemberVO(_mvo);
				}
			}
			
			ConnProperty.conClose(conn, pstmt, rsRs);
		}catch(Exception sq){
			System.out.println("ȸ������ ������ȸ DB ���� >>> : " + sq.getMessage());
			System.out.println("���� >>> : " + sq);
		}finally{
			ConnProperty.conClose(conn, pstmt, rsRs);
		}
		
		return aList;
	}

	@Override
	public boolean memberInsert(MemberVO mvo) {
		// TODO Auto-generated method stub
		System.out.println("MemberDAOImpl memberInsert() �Լ� ���� >>> : ");
		// mvo �ּҰ��� ������ �ֿܼ� Ȯ���ϱ� 
		System.out.println("MemberDAOImpl memberInsert() :: mvo >>> : " + mvo);
//		[2] MemberDAOImpl memberInsert() :: mvo >>> : a.b.c.com.jso.mem.vo.MemberVO@8db09ae
		MemberVO.printlnMemberVO(mvo);
//		[3] printlnMemberVO mvo >>> : a.b.c.com.jso.mem.vo.MemberVO@8db09ae
		
		// ����� ��ü �����ϰ� �ʱ�ȭ�ϱ�
		Connection conn = null;
		PreparedStatement pstmt = null;
		int nCnt = 0;
		boolean bool = false;
		
		try{
			conn = ConnProperty.getConnection();
			pstmt = conn.prepareStatement(MemberSqlMap.getMemberInsertQuery());
			// placeholder�� vo���� �̿��ؼ� ���� pstmt�� ���ε� ���ֱ�
			// �� ��, mvo�� �̹� set�Լ��� �ʱ�ȭ�� ������ get�Լ��� �������� �ȴ�.
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
				System.out.println("nCnt >>> : " + nCnt + " �� ��ϵǾ���");
				bool = true;
			}else{
				System.out.println("ȸ������ ��� ���� nCnt >>> : " + nCnt + " ��");
			}
			
			ConnProperty.conClose(conn, pstmt);
		}catch(Exception sq){
			System.out.println("ȸ��������� DB ���� >>> : " + sq.getMessage());
			System.out.println("���� >>> : " + sq);
		}
		return bool;
	}

	@Override
	public boolean memberUpdate(MemberVO mvo) {
		// TODO Auto-generated method stub
		System.out.println("MemberDAOImpl memberUpdate() �Լ� ���� >>> : ");
		
		// ����� ��ü �����ϰ� �ʱ�ȭ
		Connection conn = null;
		PreparedStatement pstmt = null;
		boolean bool = false;
		int nCnt = 0; 
		
		try {
			conn = ConnProperty.getConnection();
			pstmt = conn.prepareStatement(MemberSqlMap.getMemberUpdateQuery());
			System.out.println("���� ���� Ȯ�� >>> : " + MemberSqlMap.getMemberUpdateQuery());
			pstmt.clearParameters();
			// placeholder set�ϱ�
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
				System.out.println("nCnt �� ������ϴ�. >>> : ");
			}
			
			ConnProperty.conClose(conn, pstmt);
		}catch(Exception sq){
			System.out.println("���� DB ���� >>> : " + sq.getMessage());
			System.out.println("���� >>> : " + sq);
		}finally{
			ConnProperty.conClose(conn, pstmt);
		}
		
		return bool;
	}

	@Override
	public boolean memberDelete(MemberVO mvo) {
		// TODO Auto-generated method stub
		System.out.println("MemberDAOImpl memberDelete() �Լ� ���� >>> : ");
		
		// ����� ��ü �����ϰ� �ʱ�ȭ
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
		return bool;
	}

}
