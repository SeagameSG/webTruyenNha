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

@WebServlet("/updateUser")
public class UpdateUserServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		try {
			int id = Integer.parseInt(request.getParameter("id"));
			String name = request.getParameter("username");
			String newpassword = request.getParameter("newpassword");
			String email = request.getParameter("email"); 
			String prepassword = request.getParameter("prepassword");
			
			if (newpassword.equals("")) newpassword = prepassword;
			HttpSession session = request.getSession();
			UserDAOImpl dao = new UserDAOImpl(DBConnect.getConn());
			if(dao.checkPass(id, prepassword)) {
				User us= new User();
				us.setId(id);
				us.setUsername(name);
				us.setPassword(newpassword);
				us.setEmail(email);
				boolean checkrs = dao.updateUser(us);
				if (checkrs) {
					session.setAttribute("successMsg", "Đổi thành công");
					session.setAttribute("users", us);
					response.sendRedirect("showsavedlist?id=" + id);
				} else {
					session.setAttribute("failedMsg", "Đổi thất bại do lỗi trên server");
					response.sendRedirect("showsavedlist?id=" + id);
				}
			} else {
				session.setAttribute("failedMsg", "Mật khẩu cũ không đúng");
				response.sendRedirect("showsavedlist?id=" + id);
				
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
