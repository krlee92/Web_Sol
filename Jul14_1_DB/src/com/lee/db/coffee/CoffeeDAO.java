package com.lee.db.coffee;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;

import com.lee.db.main.DBManager;

public class CoffeeDAO {
	
	
	public static void coffeeReg(HttpServletRequest request) {
		
		Connection con = null; // ����
		PreparedStatement pstmt = null; // DB�����۾� �Ѱ� �����
		try {
			// ����
			con = DBManager.connect();
			
			// �� �޾ƿ���
			request.setCharacterEncoding("euc-kr");
			String n = request.getParameter("c_name");
			int p = Integer.parseInt(request.getParameter("c_price"));
			
			// sql(�̿ϼ�)
			String sql = "insert into jul15_coffee values(?, ?)";
			
			// DB�۾� �Ѱ� �����
			pstmt = con.prepareStatement(sql);
			
			// sql�ϼ� - ����ڸ� �Ἥ
			pstmt.setString(1, n);
			pstmt.setInt(2, p);
			
			// DB������ ���� & ���� & ����ޱ� : insert, update , delete
			//	pstmt.executeUpdate()�� return���� int, DB�ݿ��Ǹ� 1�� ��������Ƿ�
			//	�� �۾����� ���� ���� ������ ���� 1�̸�
			if (pstmt.executeUpdate() == 1) {
				request.setAttribute("r", "Ŀ�� ��� ����");
			} else {
				request.setAttribute("r", "Ŀ�� ��� ����");	
			}
			
			
		} catch (Exception e) {
			request.setAttribute("r", "Ŀ�� ��� ����");
		}
		// �ݱ�(���� ������ id �ٸ� ����� �� �� �ְ�)
		DBManager.close(con, pstmt, null);
	}
	
	public static void getCoffee(HttpServletRequest request) {
		
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null; // select�� ���� ���
		
		try {
			// ����
			con = DBManager.connect();
			
			// �� �ޱ� - �޾ƿðŴ� ����
			// sql(�̿ϼ�)
			String sql = "select * from jul15_coffee order by c_name";
			// pstmt
			pstmt = con.prepareStatement(sql);
			// sql �ϼ�
			// ���� & ���� & ����ޱ� : select
			rs = pstmt.executeQuery();
			
			ArrayList<Coffee> coffees = new ArrayList<Coffee>();
			Coffee c = null;
			// rs.next() : ���� �����ͷ�
			//				���� �����Ͱ� ������ false
			while (rs.next()) {
				c = new Coffee();
				// rs.getxxx("�ʵ��");
				c.setName(rs.getString("c_name"));
				c.setPrice(rs.getInt("c_price"));
				coffees.add(c);
			}
			
			request.setAttribute("coffees", coffees);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		DBManager.close(con, pstmt, rs);
	}
	
}

