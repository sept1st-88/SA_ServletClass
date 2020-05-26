package spms.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Date;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@SuppressWarnings("serial")
@WebServlet(urlPatterns = {"/member/update"})
public class MemberUpdateServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse res) 
			throws ServletException, IOException {

		// 데이터베이스 관련 객체 변수 선언
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		ServletContext sc = this.getServletContext();
		
		String noStr = req.getParameter("no");
		
		int mNo = Integer.parseInt(noStr);
		System.out.println(mNo);
		
		try {

			// 2 데이터베이스 연결
			conn = (Connection)sc.getAttribute("conn");

//          3 sql 실행 객체 준비
			String sql = "SELECT MNO, EMAIL, MNAME, CRE_DATE" 
					+ " FROM MEMBER" 
					+ " WHERE MNO = ?";

			// sql 실행문
			// 4 결과 가져오기
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setInt(1, mNo);

			rs = pstmt.executeQuery();
			
			String mName = "";
			String email = "";
			Date creDate = null;
			
			if(rs.next()) {
				mName = rs.getString("MNAME");
				email = rs.getString("EMAIL");
				creDate = rs.getDate("CRE_DATE");
			}

			res.setContentType("text/html");
			res.setCharacterEncoding("UTF-8");
			
			req.setAttribute("mNo", mNo);
			req.setAttribute("mName", mName);
			req.setAttribute("email", email);
			req.setAttribute("creDate", creDate);
			
			RequestDispatcher dispatcher = 
					req.getRequestDispatcher("/member/MemberUpdateView.jsp");
			
			dispatcher.forward(req, res);

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			// 자원해제

			// 결과셋 해제
			if (rs != null) {
				try {
					rs.close();
				} catch (SQLException e) {
					// TODO: handle exception
					e.printStackTrace();
				}
			}

			// 상태 해제
			if (pstmt != null) {
				try {
					pstmt.close();
				} catch (SQLException e) {
					// TODO: handle exception
					e.printStackTrace();
				}
			}

		} // finally 종료

	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse res) 
			throws ServletException, IOException {
		// TODO Auto-generated method stub

//		req.setCharacterEncoding("UTF-8");
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		
		ServletContext sc = this.getServletContext();
		
		String driver = sc.getInitParameter("driver");
		String url = sc.getInitParameter("url");
		String user = sc.getInitParameter("user");
		String password = sc.getInitParameter("password");
		
		String email = req.getParameter("email");
		String name = req.getParameter("name");
		int mNo = Integer.parseInt(req.getParameter("no"));
				
		String sql = "";
		
		try {
			Class.forName(driver);
			
			System.out.println("오라클 드라이버 로드");
			conn = DriverManager.getConnection(url, user, password);

			sql = "UPDATE MEMBER";
			sql += " SET MNAME = ?," + 
					" EMAIL = ?," +
					" MOD_DATE = SYSDATE";
			sql += " WHERE MNO = ?";
			
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, name);
			pstmt.setString(2, email);
			pstmt.setInt(3, mNo);
			
			pstmt.executeUpdate();
			
			res.sendRedirect("./list");
			
//			res.setContentType("text/html");
//			res.setCharacterEncoding("UTF-8");
//			
//			PrintWriter out = res.getWriter();
//			
//			String htmlStr = "";
//			
//			htmlStr += "<html><head><title>회원정보수정결과</title>";
//			htmlStr += "</head>";
//			
//			htmlStr += "<body>";
//			htmlStr += "<p>수정 성공입니다!</p>";
//			htmlStr += "</body></html>";
//			
//			out.println(htmlStr);
			
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
//			상태 해제
			if(pstmt != null) {
				try {
					pstmt.close();
				} catch (SQLException e) {
					// TODO: handle exception
					e.printStackTrace();
				}
			}
			
//			연결 해제
			if(conn != null) {
				try {
					conn.close();
				} catch (SQLException e) {
					// TODO: handle exception
					e.printStackTrace();
				}
			}
		}
	}//doGet end

}