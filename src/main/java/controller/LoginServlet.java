package controller;

import java.io.IOException;

import dao.UserDAOImpl;
import database.DBConnect;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import model.User;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
	    response.setCharacterEncoding("UTF-8");
		try {
			UserDAOImpl dao = new UserDAOImpl(DBConnect.getConn());
			HttpSession session = request.getSession();
			
			String username = request.getParameter("username");
			String password = request.getParameter("password");
			
			User us = dao.login(username, password);
			if(us!=null) {
				session.setAttribute("users", us);
				response.sendRedirect("default.jsp");
			} else {
				session.setAttribute("failedMsg", "Nhập sai Username hoặc Password");
				response.sendRedirect("login.jsp");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
