package controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

import dao.RateDAOImpl;
import database.DBConnect;

@WebServlet("/delRating")
public class DeleteRatingServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
  
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		try {
			int iduser = Integer.parseInt(request.getParameter("iduser"));
			int idmg = Integer.parseInt(request.getParameter("idmg"));
			HttpSession session = request.getSession();
			RateDAOImpl rtdao = new RateDAOImpl(DBConnect.getConn());
			boolean check = rtdao.deleteRate(iduser, idmg);
			if(check) {
				session.setAttribute("successMsg", "Xóa thành công");	
				response.sendRedirect("showsavedlist?id=" + iduser);
			}else {
				session.setAttribute("failedMsg", "Xóa thất bại");
				response.sendRedirect("showsavedlist?id=" + iduser);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
