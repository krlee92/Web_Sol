package com.lee.db.db;

import java.sql.Connection;

import javax.servlet.http.HttpServletRequest;

import com.lee.db.main.DBManager;

// MVC
// DAO/DTO - DB�����۾� DAO �װ�� DTO
// AOP - �������ΰ� ���� - �б����� �п����� �ı�

public class DAO {
	public static void connectTest(HttpServletRequest request) {
		Connection con = null; //java.sql
		try {
			con = DBManager.connect();
			System.out.println("����");
		} catch (Exception e) {
			e.printStackTrace();
		}
		DBManager.close(con, null, null);
		// ����
		// ..
		// �ݱ�

	}
}
