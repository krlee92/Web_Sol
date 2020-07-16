package com.lee.db.coffee;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;

import com.lee.db.main.DBManager;

// ��ȸ�Ҷ����� �� ������ �� ���� - x
// �� ����Ʈ�� ó�� ���� ���۵� �� �ѹ� �������
//		��ϼ����ϸ� ++
//		���������ϸ� --

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
		ResultSet rs = null; // select�� ���� ���
		
		try {
			// ����
			con = DBManager.connect();
			
			// �� �ޱ� - �޾ƿðŴ� ����
			// sql(�̿ϼ�)
			String sql = "select count(*) from JUL15_COFFEE"; // ȸ�簡�� �����Ͱ� ���Ƽ� ��ü�����ϸ� �ȴ�
			// pstmt
			pstmt = con.prepareStatement(sql);
			// sql �ϼ�
			// ���� & ���� & ����ޱ� : select
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
		
		Connection con = null; // ����
		PreparedStatement pstmt = null; // DB�����۾� �Ѱ� �����
		try {
			// ����
			con = DBManager.connect();
			
			// �� �޾ƿ���
			request.setCharacterEncoding("euc-kr");
			String n = request.getParameter("c_name");
			int p = Integer.parseInt(request.getParameter("c_price"));
			
			System.out.println(n);
			System.out.println(p);
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
				allCoffeeCount++;
			} else {
				request.setAttribute("r", "Ŀ�� ��� ����");	
			}
			
			
		} catch (Exception e) {
			request.setAttribute("r", "Ŀ�� ��� ����d");
			e.printStackTrace();
		}
		// �ݱ�(���� ������ id �ٸ� ����� �� �� �ְ�)
		DBManager.close(con, pstmt, null);
	}
	
public void deleteCoffee(HttpServletRequest request) {
		
		Connection con = null; // ����
		PreparedStatement pstmt = null; // DB�����۾� �Ѱ� �����
		try {
			// ����
			con = DBManager.connect();
			request.setCharacterEncoding("euc-kr");
			// �� �޾ƿ���
			String n = request.getParameter("name");
										// DB�ʵ��x
										// CoffeeŬ���� �������x
										// name = ��û �Ķ���͸� - go.js - deleteCoffee�Լ� ?name
			System.out.println(n);
			// sql(�̿ϼ�)
			String sql = "delete from jul15_coffee where c_name = ?";
			
//			// DB�۾� �Ѱ� �����
			pstmt = con.prepareStatement(sql);
			
			// sql�ϼ� - ����ڸ� �Ἥ
			pstmt.setString(1, n);
//			
//			// DB������ ���� & ���� & ����ޱ� : insert, update , delete
//			//	pstmt.executeUpdate()�� return���� int, DB�ݿ��Ǹ� 1�� ��������Ƿ�
//			//	�� �۾����� ���� ���� ������ ���� 1�̸�
			if (pstmt.executeUpdate() == 1) {
				request.setAttribute("r", "Ŀ�� ���� ����");
				allCoffeeCount--;
			} else {
				request.setAttribute("r", "Ŀ�� ���� ����");	
			}
			
			
		} catch (Exception e) {
			request.setAttribute("r", "Ŀ�� ���� ����");
			e.printStackTrace();
		}
		// �ݱ�(���� ������ id �ٸ� ����� �� �� �ְ�)
		DBManager.close(con, pstmt, null);
	}
	
	public void getCoffee(int page, HttpServletRequest request) {
		
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null; // select�� ���� ���
		
		try {
			// ����
			con = DBManager.connect();
			
			int coffeePerPage = 7;
			int pageCount = (int) Math.ceil(allCoffeeCount / (double) coffeePerPage);
			request.setAttribute("pageCount", pageCount);
			
			int start = coffeePerPage *(page -1) + 1;
			int end = (page == pageCount) ? allCoffeeCount :
						start + coffeePerPage -1;
			
			// �� �ޱ�
			// sql(�̿ϼ�)
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
			// sql �ϼ�
			pstmt.setInt(1, start);
			pstmt.setInt(2, end);
			
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
		ResultSet rs = null; // select�� ���� ���
		
		try {
			// ����
			con = DBManager.connect();
			
			
			// �� �ޱ�
			String n = request.getParameter("name");
			System.out.println(n);
			
			// sql(�̿ϼ�)
			String sql = "select * from jul15_coffee " 
					+ "where c_name = ?"; 
//			// pstmt
			pstmt = con.prepareStatement(sql);
			// sql �ϼ�
			pstmt.setString(1, n);
			
			// ���� & ���� & ����ޱ� : select
			rs = pstmt.executeQuery();
//			
			Coffee c = null;
			
			if (rs.next()) {
				c = new Coffee();
				// rs.getxxx("�ʵ��");
				c.setName(rs.getString("c_name"));
				c.setPrice(rs.getInt("c_price"));
				request.setAttribute("c", c);
				return true;
			}
			else { // �̹� ���� ��������
				return false;
			}
			// rs.next() : ���� �����ͷ�
			//				���� �����Ͱ� ������ false
			
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		} finally { //return���� ���� DBManager ó���ǰ�
			DBManager.close(con, pstmt, rs);
		}
	}

public void UpdateCoffee(HttpServletRequest request) {
	
	Connection con = null; // ����
	PreparedStatement pstmt = null; // DB�����۾� �Ѱ� �����
	try {
		// ����
		con = DBManager.connect();
		
		// �� �޾ƿ���
		request.setCharacterEncoding("euc-kr");
		String n = request.getParameter("name");
		int p = Integer.parseInt(request.getParameter("price"));
		
		System.out.println(n);
		System.out.println(p);
		// sql(�̿ϼ�)
		String sql = "update jul15_coffee set c_price = ? where c_name = ?";
		
		// DB�۾� �Ѱ� �����
		pstmt = con.prepareStatement(sql);
		
		// sql�ϼ� - ����ڸ� �Ἥ
		pstmt.setInt(1, p);
		pstmt.setString(2, n);
		
		// DB������ ���� & ���� & ����ޱ� : insert, update , delete
		//	pstmt.executeUpdate()�� return���� int, DB�ݿ��Ǹ� 1�� ��������Ƿ�
		//	�� �۾����� ���� ���� ������ ���� 1�̸�
		if (pstmt.executeUpdate() == 1) {
			request.setAttribute("r", "Ŀ�� ���� ����");
		} else {
			request.setAttribute("r", "Ŀ�� ���� ����");	
		}
		
	} catch (Exception e) {
		request.setAttribute("r", "Ŀ�� ���� ����");
		e.printStackTrace();
	}
	// �ݱ�(���� ������ id �ٸ� ����� �� �� �ְ�)
	DBManager.close(con, pstmt, null);

}
	
}
