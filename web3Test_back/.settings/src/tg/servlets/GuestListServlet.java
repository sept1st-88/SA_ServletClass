package tg.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.GenericServlet;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

public class GuestListServlet extends GenericServlet {
	
	@Override
	public void service(ServletRequest request, ServletResponse response) throws ServletException, IOException {

		// 데이터베이스 객체 변수 선언
		Connection conn = null; // 연결
		Statement stmt = null; // 상태
		ResultSet rs = null; // 결과

		// 사용할 jdbc 드라이버:드라이버 타입:서버주소와 포트:db서비스 아이디
		String driver = this.getInitParameter("driver");
		String url = this.getInitParameter("url");
		String user = this.getInitParameter("user");
		String password = this.getInitParameter("password");
		
		try {
			Class.forName(driver);
			conn = DriverManager.getConnection(url, user, password);

			// 3. sql 실행 객체 준비
			stmt = conn.createStatement();

			String sql = "SELECT MNO, MNAME, EMAIL, CRE_DATE, MOD_DATE, USER_ID, SAL" 
					+ " FROM GUEST" 
					+ " ORDER BY MNO DESC";

			// sql 실행문
			// 4. 결과 가져오기
			rs = stmt.executeQuery(sql);

			response.setContentType("text/html");
			response.setCharacterEncoding("UTF-8");

			PrintWriter out = response.getWriter();

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
			while (rs.next()) {
				out.println(rs.getInt("mno") + ", " + 
						"<a href='./update?mNo=" +
							rs.getInt("mNo") +
							"'>" +
						rs.getString("mname") + ", " + 
						"</a>" +
						rs.getString("email") + ", " +
						rs.getDate("cre_date") + ", " +
						rs.getDate("mod_date") + ", " +
						rs.getString("user_id") + ", " +
						rs.getInt("sal") + "<br/>");
			}
			out.println("</body></html>");
			
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
//			자원해제

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

	} // service end
}