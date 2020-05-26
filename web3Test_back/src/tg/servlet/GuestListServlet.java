package tg.servlet;

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

public class GuestListServlet extends GenericServlet{

	@Override
	public void service(ServletRequest request, ServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		
		String driver = this.getInitParameter("driver");
		String url = this.getInitParameter("url");
		String user = this.getInitParameter("user");
		String password = this.getInitParameter("password");
		
		try {
			Class.forName(driver);
			
			conn = DriverManager.getConnection(url, user, password);
			
			stmt = conn.createStatement();
			
			String sql = "SELECT MNO, MNAME, EMAIL, PWD, CRE_DATE, MOD_DATE, USER_ID, SAL"
					+ " FROM GUEST"
					+ " ORDER BY MNO ASC";
			
			rs = stmt.executeQuery(sql);
			
			response.setContentType("text/html");
			response.setCharacterEncoding("UTF-8");
			
			PrintWriter out = response.getWriter();
			
			out.println("<html><head><title>회원목록</title></head>");
			out.println("<body><h1>회원목록</h1>");
			
			String htmlStr = "";
			
			htmlStr += "<p>";
			htmlStr += "<a href='./add'>신규 회원";
			htmlStr += "</a>";
			htmlStr += "</p>";
			
			out.println(htmlStr);
			
			out.println("<table>");
			while (rs.next()) {
				out.println("<tr>");
				out.println(
					"<td>" +
					rs.getInt("MNO") +
					"</td>" +	
					"<td>" +
					"<a href='./update?mNo=" + rs.getInt("MNO") + "'>" +
					rs.getString("MNAME") +
					"</a>" +
					"</td>" +
					"<td>" +
					rs.getString("EMAIL") +
					"</td>" +
					"<td>" +
					rs.getDate("CRE_DATE") +
					"</td>" +
					"<td>" +
					rs.getDate("MOD_DATE") +
					"</td>" +
					"<td>" +
					rs.getString("USER_ID") +
					"</td>" +
					"<td>" +
					rs.getInt("SAL") +
					"</td>"
				);
				out.println("</tr>");
			}
			out.println("</table>");
			out.println("</body></html>");
		} catch (ClassNotFoundException e) {
			// TODO: handle exception
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			if (rs != null) {
				try {
					rs.close();
				} catch (SQLException e) {
					// TODO: handle exception
					e.printStackTrace();
				}
			}
			
			if(stmt != null) {
				try {
					stmt.close();
				} catch (SQLException e) {
					// TODO: handle exception
					e.printStackTrace();
				}
			}
			
			if(conn != null) {
				try {
					conn.close();
				} catch (SQLException e) {
					// TODO: handle exception
					e.printStackTrace();
				}
			}
		}
	}

}
