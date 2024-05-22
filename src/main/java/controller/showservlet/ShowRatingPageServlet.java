package controller.showservlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import model.MangaDt;

import java.io.IOException;

import dao.MangaDAOImpl;
import database.DBConnect;

@WebServlet("/rating")
public class ShowRatingPageServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		try {
			int iduser = Integer.parseInt(request.getParameter("iduser"));
			int idmg = Integer.parseInt(request.getParameter("idmg"));
			MangaDAOImpl dao = new MangaDAOImpl(DBConnect.getConn());
			MangaDt mg = dao.getMgById(idmg);
			HttpSession session = request.getSession();
			session.setAttribute("mgName", mg.getMgName());
			session.setAttribute("iduser", iduser);
			session.setAttribute("idmg", idmg);
			response.sendRedirect("rating.jsp");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
