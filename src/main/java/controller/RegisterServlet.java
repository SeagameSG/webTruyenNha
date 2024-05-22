package controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import model.User;

import java.io.IOException;

import dao.UserDAOImpl;
import database.DBConnect;

/**
 * Servlet implementation class RegisterServlet
 */
@WebServlet("/register")
public class RegisterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		try {
			String name = request.getParameter("username");
			String password = request.getParameter("password");
			String email = request.getParameter("email");

			User us = new User();
			us.setUsername(name);
			us.setPassword(password);
			us.setEmail(email);

			UserDAOImpl dao = new UserDAOImpl(DBConnect.getConn());
			boolean result = dao.userRegister(us);
			HttpSession session = request.getSession();
			if (result) {
				session.setAttribute("successMsg", "Đăng ký thành công");
				response.sendRedirect("registration.jsp");
			} else {
				session.setAttribute("failedMsg", "Đăng ký thất bại");
				response.sendRedirect("registration.jsp");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
