package com.lee.db.main;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

import oracle.jdbc.driver.OracleDriver;

// DB작업할때 공통적으로 쓰는거

// OracleDriver
//	Java :url이 Oracle형태면 알아서 OracleDriver를 사용함
//	JSP : 알아서 못함
public class DBManager {
	
	// 톰캣이 제공하는 ConnectionPool : 톰캣 설정파일(META-INF/context.xml) 필요
	//		context.xml
	//			name(수정) : 나주에 부를 때 사용(leePool)
	//			type : DataSource(튜브대여소)
//				dCN  : DB연결때 쓰는 클래스
//				factory : DataSource가 팩토리패턴
//				username(수정): 자기거
//				password(수정):자기거
//				url(수정)	:자기거
//				maxTotal:최대 동시 접속자 수
//				maxIdle: Connection객체 만들어 놓을 갯수
//				localhost자리 : ip주소
	// 미리 Connection객체를 몇 개 만들어 놓고
	// DB서버에 연결을 시도하면 만들어 져 있는거 제공 => 빠름
	public static Connection connect() throws Exception{
		// context.xml
		Context ctx = new InitialContext(); // javax.namaing
		
		
		// 튜브대여소
		DataSource ds 
			= (DataSource) ctx.lookup("java:comp/env/leePool"); // javax.sql, (DataSource) 형변환
		
		return ds.getConnection();
	}
	
	
	// DB서버에 연결을 시도하면 그 때 부터 연결설정,...=> 느림 => 잘안씀
	public static Connection connectOld() throws Exception { // 연결
		
		Class.forName("oracle.jdbc.driver.OracleDriver");
		String url = "jdbc:oracle:thin:@192.168.0.88:1521:xe";
		return DriverManager.getConnection(url, "krlee92", "1111");
	}

	public static void close(Connection con, PreparedStatement pstmt, ResultSet rs) { // 닫기

		// 역순으로 닫는 이유
		//		rs -> pstmt -> con
		//		con을 먼저 닫으면 pstmt를 닫지 못함
		try { // 닫는순서 중요함
			rs.close();

		} catch (Exception e) {

		}
		try {
			pstmt.close();
		} catch (Exception e) {
		}
		try {
			con.close();
		} catch (Exception e) {
		}

	}
}
