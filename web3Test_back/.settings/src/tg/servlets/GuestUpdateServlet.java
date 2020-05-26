package tg.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class GuestUpdateServlet extends HttpServlet {
	
	@Override
	protected void doGet(HttpServletRequest req, 
			HttpServletResponse res) 
					throws ServletException, IOException {

		// 데이터베이스 객체 변수 선언
		Connection conn = null; // 연결
		PreparedStatement pstmt = null; // 상태
		ResultSet rs = null; // 결과

		// 사용할 jdbc 드라이버:드라이버 타입:서버주소와 포트:db서비스 아이디
		String driver = this.getInitParameter("driver");
		String url = this.getInitParameter("url");
		String user = this.getInitParameter("user");
		String password = this.getInitParameter("password");
		
		int mNo = Integer.parseInt(req.getParameter("mNo"));

		try {
//			클래스 로드
//			1. jdbc 드라이버 등록
			Class.forName(driver);

			// 2. 데이터베이스 연결
			conn = DriverManager.getConnection(url, user, password);

//		    3 sql 실행 객체 준비
			String sql = "SELECT MNO, EMAIL, MNAME, CRE_DATE, USER_ID, SAL" + 
						" FROM GUEST" + 
						" WHERE MNO = ?";

			// sql 실행문
			// 4. 결과 가져오기
			pstmt = conn.prepareStatement(sql);

			pstmt.setInt(1, mNo);

			rs = pstmt.executeQuery();

			String mName = "";
			String email = "";
			Date creDate = null;
			String userId = "";
			int sal = 0;

			if (rs.next()) {
				mName = rs.getString("MNAME");
				email = rs.getString("EMAIL");
				creDate = rs.getDate("CRE_DATE");
				userId = rs.getString("USER_ID");
				sal = rs.getInt("SAL");
			}

			res.setContentType("text/html");
			res.setCharacterEncoding("UTF-8");

			PrintWriter out = res.getWriter();

			String htmlStr = "";

			htmlStr += "<!DOCTYPE html>";
			htmlStr += "<html>";
			htmlStr += "<head>";
			htmlStr += "<meta charset='UTF-8'>";
			htmlStr += "<title>회원정보</title>";
			htmlStr += "</head>";
			htmlStr += "<body>";
			htmlStr += "<h1>회원정보</h1>";
			htmlStr += "<form action='update' method='post'>";
			htmlStr += "번호 : <input type='text' name='mNo' value='" + mNo + "'";
			htmlStr += "	readonly='readonly'><br>";
			htmlStr += "이름 : <input type='text' name='name' value='" + mName + "'><br>";
			htmlStr += "이메일 : <input type='text' name='email' value='" + email + "'><br>";
			htmlStr += "유저ID : <input type='text' name='userId' value='" + userId + "'><br>";
			htmlStr += "급여 : <input type='text' name='sal' value='" + sal + "'><br>";
			htmlStr += "가입일 : " + creDate + "<br>";
			htmlStr += "<input type='submit' value='저장'>";
			htmlStr += "<input type='button' value='취소'";
			htmlStr += "	onclick='location.href=\"./list\"'>";
			htmlStr += "</form>";
			htmlStr += "</body>";
			htmlStr += "</html>";

			out.println(htmlStr);

		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
//					자원해제

			// 결과셋 해제
			if (rs != null) {
				try {
					rs.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}

			// 상태 해제
			if (pstmt != null) {
				try {
					pstmt.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}

			// 연결 해제
			if (conn != null) {
				try {
					conn.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}

		} // finally end
	} // doget end
	
	@Override
	protected void doPost(HttpServletRequest req, 
			HttpServletResponse res) 
					throws ServletException, IOException {

		Connection conn = null;
		PreparedStatement pstmt = null;

//		 사용자의 입력을 받는다		
		String emailStr = req.getParameter("email");
		String nameStr = req.getParameter("name");
		String userIdStr = req.getParameter("userId");
		int salStr = Integer.parseInt(req.getParameter("sal"));	
		int mNo = Integer.parseInt(req.getParameter("mNo"));
		
		// 사용할 jdbc 드라이버:드라이버 타입:서버주소와 포트:db서비스 아이디
		String driver = this.getInitParameter("driver");
		String url = this.getInitParameter("url");
		String user = this.getInitParameter("user");
		String password = this.getInitParameter("password");
		
		try {
			Class.forName(driver);
			conn = DriverManager.getConnection(url, user, password);
						
			// 이쪽 업데이트 하기 추가
			String sql = "UPDATE GUEST SET"
					+ " MNAME = ?,"
					+ " EMAIL = ?,"
					+ " USER_ID = ?,"
					+ " SAL = ?"
					+ " WHERE MNO = ?";
			
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, nameStr);
			pstmt.setString(2, emailStr);
			pstmt.setString(3, userIdStr);
			pstmt.setInt(4, salStr);
			pstmt.setInt(5, mNo);
			
			pstmt.executeUpdate();
			
			res.setContentType("text/html");
			res.setCharacterEncoding("UTF-8");
			
			PrintWriter out = res.getWriter();
			
			String htmlStr = "";
			
			htmlStr += "<html><head><title>회원정보수정결과</title>";
			htmlStr += "<meta http-equiv='Refresh' ";
			htmlStr += "content='3; url=./list'>";
			htmlStr += "</head>";
			htmlStr += "<body>";
			htmlStr += "<p>수정 성공입니다.!</p>";
			htmlStr += "</body></html>";
			
			out.println(htmlStr);

		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("jdbc 오라클 드라이버 로드 실패");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("insert into member 실패");
		}finally {
			if(pstmt != null) {
				try {
					pstmt.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
					System.out.println("pstmt 종료 실패");
				}
			}
			
			if(conn != null) {
				try {
					conn.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
					System.out.println("db연결 해제 실패");
				}
			}

		} // finally end
		
	}

}
