package com.mvc2.board.common;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public abstract class ConnProperty {
	
	public static final String ORACLE11G_JDBCDRIVER = "oracle.jdbc.driver.OracleDriver";
	public static final String ORACLE11G_URL = "jdbc:oracle:thin:@127.0.0.1:1521:orclKBW";
	public static final String ORACLE11G_USER = "CLEMENT";
	public static final String ORACLE11G_PASSWORD = "205301";
	
	public static Connection getConnection() throws Exception{
		System.out.println("getConnection() >>> ");
		Connection con = null;
		Class.forName(ORACLE11G_JDBCDRIVER);
		con = DriverManager.getConnection(ORACLE11G_URL, ORACLE11G_USER, ORACLE11G_PASSWORD);
		System.out.println("getConnection() <<< ");
		
		return con;
	}
	
	public static void connectionClose(Connection con, PreparedStatement pstmt, ResultSet rss){
		System.out.println("connectionClose >>> ");
		try {
			if(rss!=null)try {
				rss.close(); rss = null;
				} catch (Exception e) {}
			if(pstmt!=null)try {
				pstmt.close(); pstmt = null;
				} catch (Exception e) {}
			if(con!=null)try {
				con.close(); con = null;
				} catch (Exception e) {}
			
		} catch (Exception e) {
			// TODO: handle exception
		}
		System.out.println("connectionClose <<< ");
	}
	
	public static void connectionClose(Connection con, PreparedStatement pstmt){
		System.out.println("connectionClose >>> ");
		try {
			if(pstmt!=null)try {
				pstmt.close(); pstmt = null;
				} catch (Exception e) {}
			if(con!=null)try {
				con.close(); con = null;
				} catch (Exception e) {}
			
		} catch (Exception e) {
			// TODO: handle exception
		}
		System.out.println("connectionClose <<< ");
	}
}
