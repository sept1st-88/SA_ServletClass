package spms.servlets;

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
import javax.servlet.annotation.WebServlet;

//어노테이션
@WebServlet("/member/list")
public class MemberListServlet extends GenericServlet{

	@Override
	public void service(ServletRequest request, ServletResponse response) 
			throws ServletException, IOException {
		
//		데이터베이스 관련 객체 변수 선언(순서 중요)
		Connection conn = null;//연결
		Statement stmt = null;//상태
		ResultSet rs = null;//결과
		
//		사용할 jdbc 드라이버:드라이버타입:서버주소와 포트:db서비스 아이디
		String url = "jdbc:oracle:thin:@localhost:1521:xe";
		String user = "jsp";
		String password = "jsp12";
		
		try {
//			클래스 로드
//			1 jcbc드라이버 등록
			Class.forName("oracle.jdbc.driver.OracleDriver");

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
			
			out.println("<html><head><title>회원목록</title></head>");
			out.println("<body><h1>회원목록</h1>");
			
			String htmlStr = "";
			
			htmlStr += "<p>";
			htmlStr += "<a href='./add'>신규 회원";
			htmlStr += "</a>";
			htmlStr += "</p>";
			
			out.println(htmlStr);
			
//			5 출력
			out.println("<table>");
			while(rs.next()) {
				out.println("<tr>");
				out.println(
					"<td>" +
					rs.getInt("mno") +
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
		
	}//service end

}
