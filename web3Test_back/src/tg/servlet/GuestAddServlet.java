package tg.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class GuestAddServlet extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse res) 
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		res.setContentType("text/html");
		res.setCharacterEncoding("UTF-8");
		
		PrintWriter out = res.getWriter();
		
		String htmlStr = "";
		
		htmlStr += "<html><head><title>회원 등록</title></head>";
		htmlStr += "<body>";
		htmlStr += "<h1>회원등록</h1>";
		htmlStr += "<form action='add' method='post'>";
		htmlStr += "이름: <input type='text' name='name'><br>";
		htmlStr += "이메일: <input type='text' name='email'><br>";
		htmlStr += "암호: <input type='password' name='pwd'><br>";
		htmlStr += "아이디: <input type='text' name='userId'><br>";
		htmlStr += "급여: <input type='text' name='sal'><br>";
		htmlStr += "<input type='submit' value='추가'>";
		htmlStr += "<input type='reset' value='취소'>";
		htmlStr += "</form>";
		htmlStr += "</body></html>";
		
		out.println(htmlStr);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse res) 
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		
		String url = "jdbc:oracle:thin:@localhost:1521:xe";
		String user = "jsp";
		String password = "jsp12";
		String driverUrl = "oracle.jdbc.driver.OracleDriver";
		
		req.setCharacterEncoding("UTF-8");
		
		String nameStr = req.getParameter("name");
		String emailStr = req.getParameter("email");
		String pwdStr = req.getParameter("password");
		String userIdStr = req.getParameter("userId");
		int salInt = Integer.parseInt(req.getParameter("sal"));
		
		try {
			Class.forName(driverUrl);
			conn = DriverManager.getConnection(url, user, password);
			
			String sql = "INSERT INTO GUEST "
				+ "VALUE(MNO, EMAIL, PWD, MNAME, CRE_DATE, MOD_DATE, USER_ID, SAL) "
				+ "VALUES(GUEST_MNO_SEQ.NEXTVAL, ?, ?, ?, SYSDATE, SYSDATE, ?, ?)";
			
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, emailStr);
			pstmt.setString(2, pwdStr);
			pstmt.setString(3, nameStr);
			pstmt.setString(4, userIdStr);
			pstmt.setInt(5, salInt);
			
			pstmt.executeUpdate();
			
			res.setContentType("text/html");
			res.setCharacterEncoding("UTF-8");
			
			PrintWriter out = res.getWriter();
			
			String htmlStr = "";
			
			htmlStr += "<html><head><title>회원등록결과</title>";
			htmlStr += "<meta http-equiv='Refresh' ";
			htmlStr += "content='2; url=./list'>";
			htmlStr += "</head>";
			
			htmlStr += "<body>";
			htmlStr += "<p>등록 성공입니다!</p>";
			htmlStr += "</body></html>";
			
			out.println(htmlStr);
			
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("jdbc 오라클 드라이버 로드 실패");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("insert into memeber 수행 실패");
		} finally {
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
		}
	}
}
