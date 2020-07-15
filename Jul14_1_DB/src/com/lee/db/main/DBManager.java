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

// DB�۾��Ҷ� ���������� ���°�

// OracleDriver
//	Java :url�� Oracle���¸� �˾Ƽ� OracleDriver�� �����
//	JSP : �˾Ƽ� ����
public class DBManager {
	
	// ��Ĺ�� �����ϴ� ConnectionPool : ��Ĺ ��������(META-INF/context.xml) �ʿ�
	//		context.xml
	//			name(����) : ���ֿ� �θ� �� ���(leePool)
	//			type : DataSource(Ʃ��뿩��)
//				dCN  : DB���ᶧ ���� Ŭ����
//				factory : DataSource�� ���丮����
//				username(����): �ڱ��
//				password(����):�ڱ��
//				url(����)	:�ڱ��
//				maxTotal:�ִ� ���� ������ ��
//				maxIdle: Connection��ü ����� ���� ����
//				localhost�ڸ� : ip�ּ�
	// �̸� Connection��ü�� �� �� ����� ����
	// DB������ ������ �õ��ϸ� ����� �� �ִ°� ���� => ����
	public static Connection connect() throws Exception{
		// context.xml
		Context ctx = new InitialContext(); // javax.namaing
		
		
		// Ʃ��뿩��
		DataSource ds 
			= (DataSource) ctx.lookup("java:comp/env/leePool"); // javax.sql, (DataSource) ����ȯ
		
		return ds.getConnection();
	}
	
	
	// DB������ ������ �õ��ϸ� �� �� ���� ���ἳ��,...=> ���� => �߾Ⱦ�
	public static Connection connectOld() throws Exception { // ����
		
		Class.forName("oracle.jdbc.driver.OracleDriver");
		String url = "jdbc:oracle:thin:@192.168.0.88:1521:xe";
		return DriverManager.getConnection(url, "krlee92", "1111");
	}

	public static void close(Connection con, PreparedStatement pstmt, ResultSet rs) { // �ݱ�

		// �������� �ݴ� ����
		//		rs -> pstmt -> con
		//		con�� ���� ������ pstmt�� ���� ����
		try { // �ݴ¼��� �߿���
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
