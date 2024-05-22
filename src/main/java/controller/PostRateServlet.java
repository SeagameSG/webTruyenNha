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

@WebServlet("/postRate")
public class PostRateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		try {
			int iduser = Integer.parseInt(request.getParameter("iduser"));
			int idmg = Integer.parseInt(request.getParameter("idmg"));
			String cmt = request.getParameter("comment");
			double point = Double.parseDouble(request.getParameter("point"));
			HttpSession session = request.getSession();
			RateDAOImpl rdao = new RateDAOImpl(DBConnect.getConn());
			boolean check = rdao.postRate(iduser, idmg, cmt, point);
			if (check) {
				session.setAttribute("successMsg", "Lưu thành công");
				response.sendRedirect("showManga?id=" + idmg);
			} else {
				session.setAttribute("failedMsg", "Lưu thất bại");
				response.sendRedirect("showManga?id=" + idmg);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
