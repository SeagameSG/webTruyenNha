package controller;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.MangaDt;

import java.io.IOException;
import java.util.List;

import dao.MangaDAOImpl;
import database.DBConnect;

@WebServlet("/category")
public class SortCategoryServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		try {
			String ct = request.getParameter("ct");
			MangaDAOImpl dao = new MangaDAOImpl(DBConnect.getConn());
			List<MangaDt> list = dao.getMgByCategory(ct);
			request.setAttribute("category", ct);
			request.setAttribute("mangaObj", list);
			RequestDispatcher rd = request.getRequestDispatcher("/category.jsp");
			rd.forward(request, response);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	

}
