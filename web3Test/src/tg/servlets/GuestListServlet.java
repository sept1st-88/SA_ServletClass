package tg.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class GuestListServlet extends HttpServlet {
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse res) 
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		// 데이터베이스 객체 변수 선언
		Connection conn = null; // 연결
		Statement stmt = null; // 상태
		ResultSet rs = null; // 결과
		
		ServletContext sc = this.getServletContext();

		String driver = sc.getInitParameter("driver");
		String url = sc.getInitParameter("url");
		String user = sc.getInitParameter("user");
		String password = sc.getInitParameter("password");
		
		try {
			Class.forName(driver);
			conn = DriverManager.getConnection(url, user, password);

			// 3. sql 실행 객체 준비
			stmt = conn.createStatement();
			
			String sql = "SELECT MNO, MNAME, EMAIL, CRE_DATE, MOD_DATE, USER_ID, SAL" 
					+ " FROM GUEST" 
					+ " ORDER BY MNO ASC";

			// sql 실행문
			// 4. 결과 가져오기
			rs = stmt.executeQuery(sql);

			res.setContentType("text/html");
			res.setCharacterEncoding("UTF-8");

			PrintWriter out = res.getWriter();

			String htmlStr = "";
			
			//추가
			htmlStr += "<p>";
			htmlStr += "<a href='./add'>신규 회원";
			htmlStr += "</a>";
			htmlStr += "</p>";
			
			out.println("<html><head><title>회원목록</title></head>");
			out.println("<body><h1>회원목록</h1>");

			out.println(htmlStr);
			
			// 5. 출력
			out.println("<table style='border-collapse: collapse; font-size: 13px;'>");
			out.println("<thead>");
			out.println("<tr>");
			out.println("<th style='border: 1px solid #000; padding: 5px 10px;'>회원번호</th>");
			out.println("<th style='border: 1px solid #000; padding: 5px 10px;'>이름</th>");
			out.println("<th style='border: 1px solid #000; padding: 5px 10px;'>이메일</th>");
			out.println("<th style='border: 1px solid #000; padding: 5px 10px;'>가입날짜</th>");
			out.println("<th style='border: 1px solid #000; padding: 5px 10px;'>마지막수정날짜</th>");
			out.println("<th style='border: 1px solid #000; padding: 5px 10px;'>아이디</th>");
			out.println("<th style='border: 1px solid #000; padding: 5px 10px;'>급여</th>");
			out.println("<th style='border: 1px solid #000; padding: 5px 10px;'>삭제</th>");
			out.println("</tr>");
			out.println("</thead>");
			while (rs.next()) {
				out.println("<tr>");
				out.println(
					"<td style='border: 1px solid #000; padding: 5px 10px;'>" +
					rs.getInt("mno") + 
					"</td>" +
					"<td style='border: 1px solid #000; padding: 5px 10px;'>" +
					"<a href='./update?mNo=" + rs.getInt("MNO") + "'>" +
					rs.getString("MNAME") +
					"</a>" +
					"</td>" +
					"<td style='border: 1px solid #000; padding: 5px 10px;'>" +
					rs.getString("email") +
					"</td>" +
					"<td style='border: 1px solid #000; padding: 5px 10px;'>" +
					rs.getDate("cre_date") +
					"</td>" +
					"<td style='border: 1px solid #000; padding: 5px 10px;'>" +
					rs.getDate("mod_date") +
					"</td>" +
					"<td style='border: 1px solid #000; padding: 5px 10px;'>" +
					rs.getString("user_id") +
					"</td>" +
					"<td style='border: 1px solid #000; padding: 5px 10px;'>" +
					rs.getInt("sal") +
					"</td>" +
					"<td style='border: 1px solid #000; padding: 5px 10px;'>" +
					"<a href='./delete?mNo="+ rs.getInt("MNO") +"'>삭제</a>" +
					"</td>"
				);
				out.println("</tr>");
			}
			out.println("</table>");
			out.println("</body></html>");
			
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
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
			if (stmt != null) {
				try {
					stmt.close();
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

		} // finally 종료
	}
}