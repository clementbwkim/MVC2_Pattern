package com.mvc2.member.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import com.mvc2.member.common.ConnProperty;
import com.mvc2.member.common.MemberChaebun;
import com.mvc2.member.sql.MemberSqlQueryMap;
import com.mvc2.member.vo.MemberVO;


public class MemberDaoImpl implements MemberDao{

	@Override
	public int insertMember(MemberVO _mvo) {
		// TODO Auto-generated method stub
		System.out.println("insertMember >>> ");
		Connection con = null;
		PreparedStatement pstmt = null;
		int cnt = 0;
		try {
			con = ConnProperty.getConnection();
			System.out.println("(log)con >>> " + con);
			System.out.println("(log)autoCommit >>> " + con.getAutoCommit());
			con.getAutoCommit();
			pstmt = con.prepareStatement(MemberSqlQueryMap.getInsertQuery());
			System.out.println("(log)pstmt >>> " + pstmt);
			System.out.println("(log)" + MemberSqlQueryMap.getInsertQuery());
			
			pstmt.setString(1, MemberChaebun.commonNo());
			pstmt.setString(2, _mvo.getKname());
			pstmt.setString(3, _mvo.getKid());
			pstmt.setString(4, _mvo.getKpw());
			pstmt.setString(5, _mvo.getKbirth());
			pstmt.setString(6, _mvo.getKgender());
			pstmt.setString(7, _mvo.getKemail());
			pstmt.setString(8, _mvo.getKmobile());
			pstmt.setString(9, _mvo.getKpostnum());
			pstmt.setString(10, _mvo.getKaddr());
			pstmt.setString(11, _mvo.getKimg());
			
			cnt = pstmt.executeUpdate();
			System.out.println("cnt >>> " + cnt);
			if(!con.getAutoCommit()) con.getAutoCommit();
			ConnProperty.connectionClose(con, pstmt);
			
		} catch (Exception e) {
			System.out.println("error DaoImpl>>> " + e.getMessage());
		}
		System.out.println("insertMember <<< ");
		return cnt;
	}

	@Override
	public int updateMmber(MemberVO _mvo) {
		// TODO Auto-generated method stub
		System.out.println(" updateMmber>>> ");
		Connection con = null;
		PreparedStatement pstmt = null;
		int cnt = 0;
		
		try {
			con = ConnProperty.getConnection();
			System.out.println("(log)con >>>" + con);
			System.out.println("(log)con.getAutoCommit() >>>" + con.getAutoCommit());	
			pstmt = con.prepareStatement(MemberSqlQueryMap.getUpdateQuery());
			System.out.println("MemberSqlQueryMap.getUpdateQuery() >>>" + MemberSqlQueryMap.getUpdateQuery());
			
			pstmt.setString(1, _mvo.getKname());
			pstmt.setString(2, _mvo.getKid());
			pstmt.setString(3, _mvo.getKpw());
			pstmt.setString(4, _mvo.getKbirth());
			pstmt.setString(5, _mvo.getKgender());
			pstmt.setString(6, _mvo.getKemail());
			pstmt.setString(7, _mvo.getKmobile());
			pstmt.setString(8, _mvo.getKpostnum());
			pstmt.setString(9, _mvo.getKaddr());
			pstmt.setString(10, _mvo.getKimg());
			pstmt.setString(11, _mvo.getKnum());
			
			cnt = pstmt.executeUpdate();
			System.out.println("cnt >>>" + cnt);
			if(!con.getAutoCommit()){} con.getAutoCommit();
			
			ConnProperty.connectionClose(con, pstmt);
			
		} catch (Exception e) {
				System.out.println("error >>>" + e.getMessage());
		}finally {
			ConnProperty.connectionClose(con, pstmt);
		}
		System.out.println(" updateMmber<<< ");
		return cnt;
	}

	@Override
	public int deleteMember(MemberVO _mvo) {
		// TODO Auto-generated method stub
		System.out.println(" deleteMember>>> ");
		Connection con = null;
		PreparedStatement pstmt = null;
		int cnt = 0;
		
		try {
			con = ConnProperty.getConnection();
			con.getAutoCommit();
			System.out.println("(log)con >>>" + con);
			System.out.println("(log)con.getAutoCommit() >>>" + con.getAutoCommit());	
			pstmt = con.prepareStatement(MemberSqlQueryMap.getDeleteQuery());
			System.out.println("MemberSqlQueryMap.getDeleteQuery() >>>" + MemberSqlQueryMap.getDeleteQuery());
			
			pstmt.setString(1, _mvo.getKnum());
			System.out.println("_mvo.getKnum() >>>" + _mvo.getKnum());
			
			cnt = pstmt.executeUpdate();
			System.out.println("cnt daoImpl >>>" + cnt);
			boolean b = !con.getAutoCommit(); con.commit();
			ConnProperty.connectionClose(con, pstmt);
		} catch (Exception e) {
			System.out.println("error >>>" + e.getMessage());
		}
		ConnProperty.connectionClose(con, pstmt);
		System.out.println(" deleteMember<<< ");
		return cnt;
	}

	@Override
	public ArrayList<MemberVO> selectMember() {
		// TODO Auto-generated method stub
		System.out.println(" selectMember>>> ");
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rss = null;
		ArrayList<MemberVO> alist = null;
		MemberVO mvo = null;
		try {
			con = ConnProperty.getConnection();
			con.getAutoCommit();
			System.out.println("(log)con >>>" + con);
			System.out.println("(log)con.getAutoCommit() >>>" + con.getAutoCommit());
			pstmt = con.prepareStatement(MemberSqlQueryMap.getSelectQuery());
			System.out.println("pstmt >>>" + pstmt);
			System.out.println("MemberSqlQueryMap.getSelectQuery() >>>" + MemberSqlQueryMap.getSelectQuery());
			rss = pstmt.executeQuery();
			System.out.println("rss >>>" + rss);
			
			if(rss != null) {
				alist = new ArrayList<MemberVO>();
				while(rss.next()) {
					mvo = new MemberVO();
					mvo.setKnum(rss.getString("KNUM"));
					mvo.setKname(rss.getString("KNAME"));
					mvo.setKid(rss.getString("KID"));
					mvo.setKpw(rss.getString("KPW"));
					mvo.setKbirth(rss.getString("KBIRTH"));
					mvo.setKgender(rss.getString("KGENDER"));
					mvo.setKemail(rss.getString("KEMAIL"));
					mvo.setKmobile(rss.getString("KMOBILE"));
					mvo.setKpostnum(rss.getString("KPOSTNUM"));
					mvo.setKaddr(rss.getString("KADDR"));
					mvo.setKimg(rss.getString("KIMG"));
					mvo.setKdeleteyn(rss.getString("KDELETEYN"));
					mvo.setKinsertdate(rss.getString("KINSERTDATE"));
					mvo.setKupdatedate(rss.getString("KUPDATEDATE"));
					alist.add(mvo);
				}
				System.out.println("alist.size >>>" + alist.size());
			}
			ConnProperty.connectionClose(con, pstmt, rss);
		} catch (Exception e) {
				System.out.println("error >>>" + e.getMessage());
		}finally {
			ConnProperty.connectionClose(con, pstmt, rss);
		}
		System.out.println(" selectMember<<< ");
		return alist;
	}

	@Override
	public ArrayList<MemberVO> searchMember(MemberVO _mvo) {
		// TODO Auto-generated method stub
		System.out.println(" searchMember>>> ");
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rss = null;
		MemberVO mvo = null;
		ArrayList<MemberVO> alist = null;
		try {
			con = ConnProperty.getConnection();
			con.getAutoCommit();
			System.out.println("(log)con >>>" + con);
			System.out.println("(log)con.getAutoCommit() >>>" + con.getAutoCommit());
			
			pstmt = con.prepareStatement(MemberSqlQueryMap.getSearchQuery());
			System.out.println("(log)pstmt >>>" + pstmt);
			System.out.println("MemberSqlQueryMap.getSearchQuery()>>>" + MemberSqlQueryMap.getSearchQuery());

			pstmt.setString(1, _mvo.getKnum());
			rss = pstmt.executeQuery();
			System.out.println("rss >>>" + rss);
			
			if(rss != null) {
				alist = new ArrayList<MemberVO>();
				while(rss.next()){
					mvo = new MemberVO();
					mvo.setKnum(rss.getString("KNUM"));
					mvo.setKname(rss.getString("KNAME"));
					mvo.setKid(rss.getString("KID"));
					mvo.setKpw(rss.getString("KPW"));
					mvo.setKbirth(rss.getString("KBIRTH"));
					mvo.setKgender(rss.getString("KGENDER"));
					mvo.setKemail(rss.getString("KEMAIL"));
					mvo.setKpostnum(rss.getString("KPOSTNUM"));
					mvo.setKaddr(rss.getString("KADDR"));
					mvo.setKimg(rss.getString("KIMG"));
					mvo.setKdeleteyn(rss.getString("KDELETEYN"));
					mvo.setKinsertdate(rss.getString("KINSERTDATE"));
					mvo.setKupdatedate(rss.getString("KUPDATEDATE"));
					alist.add(mvo);
				}
			}
			ConnProperty.connectionClose(con, pstmt, rss);
		} catch (Exception e) {
			System.out.println("error >>>" + e.getMessage());
		}finally {
			ConnProperty.connectionClose(con, pstmt, rss);
		}
		System.out.println(" searchMember<<< ");
		return alist;
	}

	@Override
	public ArrayList<MemberVO> loginMember(MemberVO _mvo) {
		// TODO Auto-generated method stub
		System.out.println(" loginMember>>> ");
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rss = null;
		ArrayList<MemberVO> alist = null;
		MemberVO mvo = null;
		
		try {
			con = ConnProperty.getConnection();
			con.getAutoCommit();
			System.out.println("(log)con >>>" + con);
			System.out.println("(log)con.getAutoCommit() >>>" + con.getAutoCommit());
			pstmt = con.prepareStatement(MemberSqlQueryMap.getLoginQuery());
			System.out.println("MemberSqlQueryMap.getLoginQuery() >>>" + MemberSqlQueryMap.getLoginQuery());
			pstmt.setString(1, _mvo.getKid());
			pstmt.setString(2, _mvo.getKpw());
			rss = pstmt.executeQuery();
			System.out.println("rss >>>" + rss);
			if(rss != null) {
				alist = new ArrayList<MemberVO>();
				while(rss.next()) {
					mvo = new MemberVO();
					mvo.setKnum(rss.getString("KNUM"));
					mvo.setKname(rss.getString("KNAME"));
					mvo.setKid(rss.getString("KID"));
					mvo.setKpw(rss.getString("KPW"));
					mvo.setKbirth(rss.getString("KBIRTH"));
					mvo.setKgender(rss.getString("KGENDER"));
					mvo.setKemail(rss.getString("KEMAIL"));
					mvo.setKmobile(rss.getString("KMOBILE"));
					mvo.setKpostnum(rss.getString("KPOSTNUM"));
					mvo.setKaddr(rss.getString("KADDR"));
					mvo.setKimg(rss.getString("KIMG"));
					mvo.setKdeleteyn(rss.getString("KDELETEYN"));
					mvo.setKinsertdate(rss.getString("KINSERTDATE"));
					mvo.setKupdatedate(rss.getString("KUPDATEDATE"));
					alist.add(mvo);
				}
			}
		} catch (Exception e) {
			System.out.println("error >>>" + e.getMessage());
		}finally {
			ConnProperty.connectionClose(con, pstmt, rss);
		}
		ConnProperty.connectionClose(con, pstmt, rss);
		System.out.println(" loginMember<<< ");
		return alist;
	}

	@Override
	public int idCheck(MemberVO _mvo) {
		System.out.println("(log)idCheck() >>>");
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rss = null;
		int cnt = 0;
		ArrayList<MemberVO> alist = null;
		MemberVO mvo = null;
		
		try {
			con = ConnProperty.getConnection();
			con.getAutoCommit();
			System.out.println("(log)con >>>" + con);
			System.out.println("(log)con.getAutoCommit() >>>" + con.getAutoCommit());
			
			pstmt = con.prepareStatement(MemberSqlQueryMap.getIdcheck());
			System.out.println("MemberSqlQueryMap.getIdcheck() >>>" + MemberSqlQueryMap.getIdcheck());
			pstmt.setString(1, _mvo.getKid());
		
			rss = pstmt.executeQuery();
			System.out.println("rss >>>" + rss);
			
			if(rss != null) {
				alist = new ArrayList<MemberVO>();
					while(rss.next()) {
						mvo = new MemberVO();
						mvo.setKid(rss.getString("KID"));
						alist.add(mvo);
					}
					cnt = alist.size();
					System.out.println("cnt >>>" + cnt);
			}
			
		
			ConnProperty.connectionClose(con, pstmt, rss);
		} catch (Exception e) {
			System.out.println("error >>>" + e.getMessage());
		}finally {
			ConnProperty.connectionClose(con, pstmt, rss);
		}
		System.out.println("(log)idCheck() <<<");
		return cnt;
	}
}
