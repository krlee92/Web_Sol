package com.lee.db.coffee;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;

import com.lee.db.main.DBManager;

public class CoffeeDAO {
	
	
	public static void coffeeReg(HttpServletRequest request) {
		
		Connection con = null; // 연결
		PreparedStatement pstmt = null; // DB관련작업 총괄 담당자
		try {
			// 연결
			con = DBManager.connect();
			
			// 값 받아오기
			request.setCharacterEncoding("euc-kr");
			String n = request.getParameter("c_name");
			int p = Integer.parseInt(request.getParameter("c_price"));
			
			// sql(미완성)
			String sql = "insert into jul15_coffee values(?, ?)";
			
			// DB작업 총괄 담당자
			pstmt = con.prepareStatement(sql);
			
			// sql완성 - 담당자를 써서
			pstmt.setString(1, n);
			pstmt.setInt(2, p);
			
			// DB서버로 전송 & 실행 & 결과받기 : insert, update , delete
			//	pstmt.executeUpdate()는 return값이 int, DB반영되면 1줄 영향받으므로
			//	이 작업으로 영향 받은 데이터 수가 1이면
			if (pstmt.executeUpdate() == 1) {
				request.setAttribute("r", "커피 등록 성공");
			} else {
				request.setAttribute("r", "커피 등록 실패");	
			}
			
			
		} catch (Exception e) {
			request.setAttribute("r", "커피 등록 실패");
		}
		// 닫기(지금 접속한 id 다른 사람도 쓸 수 있게)
		DBManager.close(con, pstmt, null);
	}
	
	public static void getCoffee(HttpServletRequest request) {
		
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null; // select문 수행 결과
		
		try {
			// 연결
			con = DBManager.connect();
			
			// 값 받기 - 받아올거는 없네
			// sql(미완성)
			String sql = "select * from jul15_coffee order by c_name";
			// pstmt
			pstmt = con.prepareStatement(sql);
			// sql 완성
			// 전송 & 실행 & 결과받기 : select
			rs = pstmt.executeQuery();
			
			ArrayList<Coffee> coffees = new ArrayList<Coffee>();
			Coffee c = null;
			// rs.next() : 다음 데이터로
			//				다음 데이터가 없으면 false
			while (rs.next()) {
				c = new Coffee();
				// rs.getxxx("필드명");
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

