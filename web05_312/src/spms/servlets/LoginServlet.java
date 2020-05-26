package spms.servlets;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import spms.dto.MemberDto;

@WebServlet("/auth/login")
public class LoginServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse res) 
			throws ServletException, IOException {

		RequestDispatcher dispacher = req.getRequestDispatcher("/auth/LoginForm.jsp");
		dispacher.forward(req, res);

	} // doGet end

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse res) 
			throws ServletException, IOException {

		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		String sql = "";
		int colIndex = 1;

		try {
			ServletContext sc = this.getServletContext();
			conn = (Connection) sc.getAttribute("conn");

			String email = req.getParameter("email");
			String pwd = req.getParameter("password");
			String name = "";

			sql += "SELECT MNAME, EMAIL";
			sql += " FROM MEMBER";
			sql += " WHERE EMAIL = ?";
			sql += " AND PWD = ?";

			pstmt = conn.prepareStatement(sql);

			pstmt.setString(colIndex++, email);
			pstmt.setString(colIndex, pwd);

			rs = pstmt.executeQuery();

			// 회원이다
			if (rs.next()) {
				email = rs.getString("EMAIL");
				name = rs.getString("MNAME");

				MemberDto memberDto = new MemberDto();

				memberDto.setEmail(email);
				memberDto.setName(name);

				HttpSession session = req.getSession();
				session.setAttribute("memberDto", memberDto);

				res.sendRedirect("../member/list");
			} else { // 회원이 아니다
				RequestDispatcher rd = req.getRequestDispatcher("./LoginFail.jsp");
				rd.forward(req, res);
			}

		} catch (SQLException e) {
			throw new ServletException(e);
		} finally {
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
		}

	} // doPost end
}