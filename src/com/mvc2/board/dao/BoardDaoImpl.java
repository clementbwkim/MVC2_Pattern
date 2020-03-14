package com.mvc2.board.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import com.mvc2.board.common.BoardChaebun;
import com.mvc2.board.sql.BoardSqlQueryMap;
import com.mvc2.board.vo.BoardVO;
import com.mvc2.member.common.ConnProperty;

public class BoardDaoImpl implements BoardDao{

	@Override
	public int insertBoard(BoardVO _bvo) {
		// TODO Auto-generated method stub
		System.out.println("(log)insertBoard(BoardVO _bvo) >>>");
		Connection con = null;
		PreparedStatement pstmt = null;
		int cnt = 0;
		try {
			con = ConnProperty.getConnection();
			con.getAutoCommit();
			System.out.println("(log) con >>>" + con);
			System.out.println("(log)con.getAutoCommit() >>>" + con.getAutoCommit());
			pstmt = con.prepareStatement(BoardSqlQueryMap.getInsertQuery());
			System.out.println("BoardSqlQueryMap.getInsertQuery() >>>" + BoardSqlQueryMap.getInsertQuery());
			
			pstmt.setString(1, BoardChaebun.commonNo());
			pstmt.setString(2, _bvo.getKtitle());
			pstmt.setString(3, _bvo.getKname());
			pstmt.setString(4, _bvo.getKpw());
			pstmt.setString(5, _bvo.getKcontent());
			pstmt.setString(6, _bvo.getKimg());
			
			cnt = pstmt.executeUpdate();
			System.out.println("cnt >>>" + cnt);
			if(!con.getAutoCommit()) con.commit();
			ConnProperty.connectionClose(con, pstmt);
			
		} catch (Exception e) {
			System.out.println("error dao>>>" + e.getMessage());
		}finally {
			ConnProperty.connectionClose(con, pstmt);
		}
		System.out.println("(log)insertBoard(BoardVO _bvo) <<<");
		return cnt;
	}

	@Override
	public ArrayList<BoardVO> selectBoard() {
		// TODO Auto-generated method stub
		System.out.println("(log)selectBoard() >>>");
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rss = null;
		BoardVO bvo = null;
		ArrayList<BoardVO> alist = null;
		try {
			con = ConnProperty.getConnection();
			con.getAutoCommit();
			System.out.println("(log) con >>>" + con);
			System.out.println("(log)con.getAutoCommit() >>>" + con.getAutoCommit());
			pstmt = con.prepareStatement(BoardSqlQueryMap.getSelectQuery());
			System.out.println("BoardSqlQueryMap.getSelectQuery() >>>" + BoardSqlQueryMap.getSelectQuery());
			rss = pstmt.executeQuery();
			System.out.println("rss >>>" + rss);
			
			if(rss != null) {
				alist = new ArrayList<BoardVO>();
				while(rss.next()) {
					bvo = new BoardVO();
					bvo.setKno(rss.getString("KNO"));
					bvo.setKtitle(rss.getString("KTITLE"));
					bvo.setKname(rss.getString("KNAME"));
					bvo.setKpw(rss.getString("KPW"));
					bvo.setKcontent(rss.getString("KCONTENT"));
					bvo.setKimg(rss.getString("KIMG"));
					bvo.setKdeleteyn(rss.getString("KDELETEYN"));
					bvo.setKinsertdate(rss.getString("KINSERTDATE"));
					bvo.setKupdatedate(rss.getString("KUPDATEDATE"));
					alist.add(bvo);
				}
				System.out.println("alist.size >>>" + alist.size());
			}
			ConnProperty.connectionClose(con, pstmt, rss);
		} catch (Exception e) {
			System.out.println("error dao>>>" + e.getMessage());
		}finally {
			ConnProperty.connectionClose(con, pstmt, rss);
		}
		System.out.println("(log)selectBoard() <<<");
		return alist;
	}

	@Override
	public int updateBoard(BoardVO _bvo) {
		// TODO Auto-generated method stub
		System.out.println("(log)updateBoard(BoardVO _bvo) >>>");
		Connection con = null;
		PreparedStatement pstmt = null;
		int cnt = 0;
		try {
			con = ConnProperty.getConnection();
			con.getAutoCommit();
			System.out.println("(log) con >>>" + con);
			System.out.println("(log)con.getAutoCommit() >>>" + con.getAutoCommit());
			pstmt = con.prepareStatement(BoardSqlQueryMap.getUpdateQuery());
			System.out.println("BoardSqlQueryMap.getUpdateQuery() >>>" + BoardSqlQueryMap.getUpdateQuery());
			
			pstmt.setString(1, _bvo.getKtitle());
			pstmt.setString(2, _bvo.getKname());
			pstmt.setString(3, _bvo.getKcontent());
			pstmt.setString(4, _bvo.getKimg());
			pstmt.setString(5, _bvo.getKno());

			cnt = pstmt.executeUpdate();
			System.out.println("boardDaoImpl cnt >>>" + cnt);
			if(!con.getAutoCommit()){} con.getAutoCommit();
			
			ConnProperty.connectionClose(con, pstmt);
			
		} catch (Exception e) {
			System.out.println("error dao>>>" + e.getMessage());
		}finally {
			ConnProperty.connectionClose(con, pstmt);
		}
		System.out.println("(log)updateBoard(BoardVO _bvo) <<<");
		return cnt;
	}

	@Override
	public ArrayList<BoardVO> searchBoard(BoardVO _bvo) {
		// TODO Auto-generated method stub
		System.out.println("(log)searchBoard(BoardVO _bvo) >>>");
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rss = null;
		BoardVO bvo = null;
		ArrayList<BoardVO> alist = null;
		try {
			con = ConnProperty.getConnection();
			con.getAutoCommit();
			System.out.println("(log) con >>>" + con);
			System.out.println("(log)con.getAutoCommit() >>>" + con.getAutoCommit());
			pstmt = con.prepareStatement(BoardSqlQueryMap.getSearchQuery());
			System.out.println("BoardSqlQueryMap.getUpdateQuery() >>>" + BoardSqlQueryMap.getSearchQuery());
			
			pstmt.setString(1, _bvo.getKno());
			rss = pstmt.executeQuery();
			System.out.println("rss >>>" + rss);
			
			if(rss != null) {
				alist = new ArrayList<>();
				while(rss.next()) {
					bvo = new BoardVO();
					bvo.setKno(rss.getString("KNO"));
					bvo.setKtitle(rss.getString("KTITLE"));
					bvo.setKname(rss.getString("KNAME"));
					bvo.setKpw(rss.getString("KPW"));
					bvo.setKcontent(rss.getString("KCONTENT"));
					bvo.setKimg(rss.getString("KIMG"));
					bvo.setKdeleteyn(rss.getString("KDELETEYN"));
					bvo.setKinsertdate(rss.getString("KINSERTDATE"));
					bvo.setKupdatedate(rss.getString("KUPDATEDATE"));
					alist.add(bvo);
				}
			}
			ConnProperty.connectionClose(con, pstmt, rss);
		} catch (Exception e) {
			System.out.println("error dao>>>" + e.getMessage());
		}finally {
			ConnProperty.connectionClose(con, pstmt, rss);
		}
		System.out.println("(log)searchBoard(BoardVO _bvo) <<<");
		return alist;
	}

	@Override
	public int deleteBoard(BoardVO _bvo) {
		// TODO Auto-generated method stub
		System.out.println("(log)deleteBoard(BoardVO _bvo) >>>");
		Connection con = null;
		PreparedStatement pstmt = null;
		int cnt = 0;
		try {
			con = ConnProperty.getConnection();
			con.getAutoCommit();
			System.out.println("(log) con >>>" + con);
			System.out.println("(log)con.getAutoCommit() >>>" + con.getAutoCommit());
			pstmt = con.prepareStatement(BoardSqlQueryMap.getDeleteQuery());
			System.out.println("BoardSqlQueryMap.getDeleteQuery() >>>" + BoardSqlQueryMap.getDeleteQuery());
			
			pstmt.setString(1, _bvo.getKno());
			System.out.println("_bvo.getKno() >>>" + _bvo.getKno());
			
			cnt = pstmt.executeUpdate();
			System.out.println("cnt >>>" + cnt);
			boolean b = !con.getAutoCommit(); con.commit();
			ConnProperty.connectionClose(con, pstmt);
		} catch (Exception e) {
			System.out.println("error dao>>>" + e.getMessage());
		}
			ConnProperty.connectionClose(con, pstmt);
			System.out.println("(log)deleteBoard(BoardVO _bvo) <<<");
		return cnt;
	}
	
	
	
	
}
