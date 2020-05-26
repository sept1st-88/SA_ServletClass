package spms.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//어노테이션
@WebServlet("/member/list")
//@WebServlet(
//	urlPatterns = {"/member/list"},
//	initParams = {
//		@WebInitParam(name="driver", value="oracle.jdbc.driver.OracleDriver"),
//		@WebInitParam(name="url", value="jdbc:oracle:thin:@localhost:1521:xe"),
//		@WebInitParam(name="user", value="jsp"),
//		@WebInitParam(name="password", value="jsp12"),
//	}
//)
public class MemberListServlet extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		// TODO Auto-generated method stub
//		데이터베이스 관련 객체 변수 선언(순서 중요)
		Connection conn = null;//연결
		Statement stmt = null;//상태
		ResultSet rs = null;//결과
		
		ServletContext sc = this.getServletContext();
		
		String driver = sc.getInitParameter("driver");
		String url = sc.getInitParameter("url");
		String user = sc.getInitParameter("user");
		String password = sc.getInitParameter("password");
		
		try {
//			클래스 로드
//			1 jcbc드라이버 등록
			Class.forName(driver);

//			2 데이터베이스 연결
			conn = DriverManager.getConnection(url, user, password);
			
//			3 sql 실행 객체 준비
			stmt = conn.createStatement();
			
			String sql = "SELECT MNO, MNAME, EMAIL, CRE_DATE"
					+ " FROM MEMBER"
					+ " ORDER BY MNO ASC";
			
//			sql 실행문
//			4 결과 가져오기
			rs = stmt.executeQuery(sql);
			
			response.setContentType("text/html");
			response.setCharacterEncoding("UTF-8");//한글표현
			
			PrintWriter out = response.getWriter();
			
			String htmlStr = "";
			
			htmlStr += "<html>";
			htmlStr += "<head>";
			htmlStr += "<title>회원목록</title>";
			htmlStr += "</head>";
			htmlStr += "<body>";
			htmlStr += "<h1>회원목록</h1>";
			htmlStr += "<p>";
			htmlStr += "<a href='./add'>신규 회원</a>";
			htmlStr += "</p>";
			htmlStr += "<table style='border-collapse: collapse; font-size: 14px'>";
			
			htmlStr += "<thead>";
			htmlStr += "<tr>";
			htmlStr += "<th style='border: 1px solid #000; padding: 5px 10px;'>회원번호</th>";
			htmlStr += "<th style='border: 1px solid #000; padding: 5px 10px;'>이름</th>";
			htmlStr += "<th style='border: 1px solid #000; padding: 5px 10px;'>이메일</th>";
			htmlStr += "<th style='border: 1px solid #000; padding: 5px 10px;'>가입날짜</th>";
			htmlStr += "<th style='border: 1px solid #000; padding: 5px 10px;'>삭제</th>";
			htmlStr += "</tr>";
			htmlStr += "</thead>";
			
			while (rs.next()) {
				htmlStr += "<tr>";
				htmlStr += "<td style='border: 1px solid #000; padding: 5px 10px;'>" 
						+ rs.getInt("MNO") 
						+ "</td>";
				htmlStr += "<td style='border: 1px solid #000; padding: 5px 10px;'>" 
						+ "<a href='./update?mNo=" + rs.getInt("mNo") + "'>"
						+ rs.getString("MNAME")
						+ "</a>" 
						+ "</td>";
				htmlStr += "<td style='border: 1px solid #000; padding: 5px 10px;'>"
						+ rs.getString("EMAIL") 
						+ "</td>";
				htmlStr += "<td style='border: 1px solid #000; padding: 5px 10px;'>" 
						+ rs.getDate("CRE_DATE") 
						+ "</td>";
				htmlStr += "<td style='border: 1px solid #000; padding: 5px 10px;'>" 
						+ "<a href='./delete?mNo=" + rs.getInt("MNO") + "'>삭제</a>" 
						+ "</td>";
				htmlStr += "</tr>";			
			}
			
			htmlStr += "</table>";
			htmlStr += "</body>";
			htmlStr += "</html>";
			
			out.println(htmlStr);
			
//			response.sendRedirect("./list");
			
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
//			자원해제 (순서중요-자식먼저)
			
//			결과셋 해제
			if (rs != null) {
				try {
					rs.close();
				} catch (SQLException e) {
					// TODO: handle exception
					e.printStackTrace();
				}
			}
			
//			상태 해제
			if(stmt != null) {
				try {
					stmt.close();
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
		}//finally종료
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) 
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		
	}
}
