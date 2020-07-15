package com.lee.db.db;

import java.sql.Connection;

import javax.servlet.http.HttpServletRequest;

import com.lee.db.main.DBManager;

// MVC
// DAO/DTO - DB관련작업 DAO 그결과 DTO
// AOP - 공통적인거 정리 - 학교가기 학원가기 씻기

public class DAO {
	public static void connectTest(HttpServletRequest request) {
		Connection con = null; //java.sql
		try {
			con = DBManager.connect();
			System.out.println("성공");
		} catch (Exception e) {
			e.printStackTrace();
		}
		DBManager.close(con, null, null);
		// 연결
		// ..
		// 닫기

	}
}
