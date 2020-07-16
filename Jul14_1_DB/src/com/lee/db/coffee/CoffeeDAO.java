package com.lee.db.coffee;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;

import com.lee.db.main.DBManager;

// 조회할때마다 총 데이터 수 세기 - x
// 이 사이트가 처음 서비스 시작될 때 한번 세어놓고
//		등록성공하면 ++
//		삭제성공하면 --

public class CoffeeDAO {
	private int allCoffeeCount;
	
	private static final CoffeeDAO CDAO = new CoffeeDAO();
	
	private CoffeeDAO() {
		// TODO Auto-generated constructor stub
	}
	
	public static CoffeeDAO getCdao() {
		return CDAO;
	}

	public void setAllCoffeeCount() {
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null; // select문 수행 결과
		
		try {
			// 연결
			con = DBManager.connect();
			
			// 값 받기 - 받아올거는 없네
			// sql(미완성)
			String sql = "select count(*) from JUL15_COFFEE"; // 회사가면 데이터가 많아서 전체선택하면 안대
			// pstmt
			pstmt = con.prepareStatement(sql);
			// sql 완성
			// 전송 & 실행 & 결과받기 : select
			rs = pstmt.executeQuery();
			rs.next();
			allCoffeeCount = rs.getInt("count(*)");
			System.out.println(allCoffeeCount);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		DBManager.close(con, pstmt, rs);
	}
		
		
	

	public void coffeeReg(HttpServletRequest request) {
		
		Connection con = null; // 연결
		PreparedStatement pstmt = null; // DB관련작업 총괄 담당자
		try {
			// 연결
			con = DBManager.connect();
			
			// 값 받아오기
			request.setCharacterEncoding("euc-kr");
			String n = request.getParameter("c_name");
			int p = Integer.parseInt(request.getParameter("c_price"));
			
			System.out.println(n);
			System.out.println(p);
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
				allCoffeeCount++;
			} else {
				request.setAttribute("r", "커피 등록 실패");	
			}
			
			
		} catch (Exception e) {
			request.setAttribute("r", "커피 등록 실패d");
			e.printStackTrace();
		}
		// 닫기(지금 접속한 id 다른 사람도 쓸 수 있게)
		DBManager.close(con, pstmt, null);
	}
	
public void deleteCoffee(HttpServletRequest request) {
		
		Connection con = null; // 연결
		PreparedStatement pstmt = null; // DB관련작업 총괄 담당자
		try {
			// 연결
			con = DBManager.connect();
			request.setCharacterEncoding("euc-kr");
			// 값 받아오기
			String n = request.getParameter("name");
										// DB필드명x
										// Coffee클래스 멤버변수x
										// name = 요청 파라메터명 - go.js - deleteCoffee함수 ?name
			System.out.println(n);
			// sql(미완성)
			String sql = "delete from jul15_coffee where c_name = ?";
			
//			// DB작업 총괄 담당자
			pstmt = con.prepareStatement(sql);
			
			// sql완성 - 담당자를 써서
			pstmt.setString(1, n);
//			
//			// DB서버로 전송 & 실행 & 결과받기 : insert, update , delete
//			//	pstmt.executeUpdate()는 return값이 int, DB반영되면 1줄 영향받으므로
//			//	이 작업으로 영향 받은 데이터 수가 1이면
			if (pstmt.executeUpdate() == 1) {
				request.setAttribute("r", "커피 삭제 성공");
				allCoffeeCount--;
			} else {
				request.setAttribute("r", "커피 삭제 실패");	
			}
			
			
		} catch (Exception e) {
			request.setAttribute("r", "커피 삭제 실패");
			e.printStackTrace();
		}
		// 닫기(지금 접속한 id 다른 사람도 쓸 수 있게)
		DBManager.close(con, pstmt, null);
	}
	
	public void getCoffee(int page, HttpServletRequest request) {
		
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null; // select문 수행 결과
		
		try {
			// 연결
			con = DBManager.connect();
			
			int coffeePerPage = 7;
			int pageCount = (int) Math.ceil(allCoffeeCount / (double) coffeePerPage);
			request.setAttribute("pageCount", pageCount);
			
			int start = coffeePerPage *(page -1) + 1;
			int end = (page == pageCount) ? allCoffeeCount :
						start + coffeePerPage -1;
			
			// 값 받기
			// sql(미완성)
			String sql = "select rownum, rn, c_name, c_price" + 
					" from(" + 
					"	select rownum as rn, c_name, c_price" + 
					"	from (" + 
					"		select *" + 
					"		from JUL15_COFFEE" + 
					"		order by c_name" + 
					"	)" + 
					")" + 
					"where rn >= ? and rn <= ?"; 
			// pstmt
			pstmt = con.prepareStatement(sql);
			// sql 완성
			pstmt.setInt(1, start);
			pstmt.setInt(2, end);
			
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
//				coffees.add(new Coffee(rs.getString("c_name"), rs.getInt("c_price")));
				
			}
			
			request.setAttribute("coffees", coffees);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		DBManager.close(con, pstmt, rs);
	}
	
public boolean getCoffeeInfo(HttpServletRequest request) {
		
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null; // select문 수행 결과
		
		try {
			// 연결
			con = DBManager.connect();
			
			
			// 값 받기
			String n = request.getParameter("name");
			System.out.println(n);
			
			// sql(미완성)
			String sql = "select * from jul15_coffee " 
					+ "where c_name = ?"; 
//			// pstmt
			pstmt = con.prepareStatement(sql);
			// sql 완성
			pstmt.setString(1, n);
			
			// 전송 & 실행 & 결과받기 : select
			rs = pstmt.executeQuery();
//			
			Coffee c = null;
			
			if (rs.next()) {
				c = new Coffee();
				// rs.getxxx("필드명");
				c.setName(rs.getString("c_name"));
				c.setPrice(rs.getInt("c_price"));
				request.setAttribute("c", c);
				return true;
			}
			else { // 이미 누가 지웠으면
				return false;
			}
			// rs.next() : 다음 데이터로
			//				다음 데이터가 없으면 false
			
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		} finally { //return보다 먼저 DBManager 처리되게
			DBManager.close(con, pstmt, rs);
		}
	}

public void UpdateCoffee(HttpServletRequest request) {
	
	Connection con = null; // 연결
	PreparedStatement pstmt = null; // DB관련작업 총괄 담당자
	try {
		// 연결
		con = DBManager.connect();
		
		// 값 받아오기
		request.setCharacterEncoding("euc-kr");
		String n = request.getParameter("name");
		int p = Integer.parseInt(request.getParameter("price"));
		
		System.out.println(n);
		System.out.println(p);
		// sql(미완성)
		String sql = "update jul15_coffee set c_price = ? where c_name = ?";
		
		// DB작업 총괄 담당자
		pstmt = con.prepareStatement(sql);
		
		// sql완성 - 담당자를 써서
		pstmt.setInt(1, p);
		pstmt.setString(2, n);
		
		// DB서버로 전송 & 실행 & 결과받기 : insert, update , delete
		//	pstmt.executeUpdate()는 return값이 int, DB반영되면 1줄 영향받으므로
		//	이 작업으로 영향 받은 데이터 수가 1이면
		if (pstmt.executeUpdate() == 1) {
			request.setAttribute("r", "커피 수정 성공");
		} else {
			request.setAttribute("r", "커피 수정 실패");	
		}
		
	} catch (Exception e) {
		request.setAttribute("r", "커피 수정 실패");
		e.printStackTrace();
	}
	// 닫기(지금 접속한 id 다른 사람도 쓸 수 있게)
	DBManager.close(con, pstmt, null);

}
	
}
