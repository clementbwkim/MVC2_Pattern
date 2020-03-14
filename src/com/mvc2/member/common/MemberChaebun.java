package com.mvc2.member.common;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.util.Date;

import com.mvc2.board.sql.BoardSqlQueryMap;
import com.mvc2.member.sql.MemberSqlQueryMap;

public abstract class MemberChaebun {
	
	public static String commonNo() {
		System.out.println("commonNo() >>> ");
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rss = null;
		
		String comNo = "";
		
		try {
			con = ConnProperty.getConnection();
			System.out.println("connected >>>");
			pstmt = con.prepareStatement(MemberSqlQueryMap.MEMBER_KNUM_CHAEBUN);
			System.out.println("pstmt >>> " + pstmt);
			
			rss = pstmt.executeQuery();
			System.out.println(" chaebun >>> " + MemberSqlQueryMap.MEMBER_KNUM_CHAEBUN);
			System.out.println("rss >>> " + rss);
			
			if(rss != null) {
				while(rss.next()) {
					comNo = rss.getString("comNo");
				}
			}
			System.out.println("comNo >>>" + comNo);
			System.out.println("comNo.length >>> " + comNo.length());
			
			if(1 == comNo.length()) {
				comNo = "00" + comNo;
			}
			if(2 == comNo.length()) {
				comNo = "0" + comNo;
			}
			System.out.println("comNo >>> " + comNo);
			
			Date d = new Date();
			SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
			String date = sdf.format(d);
			
			comNo = "M" + date + comNo;
			
			System.out.println("comNo >>>" + comNo);
			
			ConnProperty.connectionClose(con, pstmt);
	
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("error chaebunClass>>> " + e.getStackTrace());
		}finally {
			try {
				ConnProperty.connectionClose(con, pstmt);
			} catch (Exception e2) {
				// TODO: handle exception
				e2.getMessage();
			}
		}
		System.out.println("commonNo() <<< ");
		return comNo;
		
	}
}
