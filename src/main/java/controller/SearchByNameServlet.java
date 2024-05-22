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

@WebServlet("/searchByName")
public class SearchByNameServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		try {
			String text = request.getParameter("keyWord");
			MangaDAOImpl dao = new MangaDAOImpl(DBConnect.getConn());
			List<MangaDt> mglist =  dao.findByName(text);
			request.setAttribute("name", text);
			request.setAttribute("mangaObj", mglist);
			RequestDispatcher rd = request.getRequestDispatcher("/findresult.jsp");
			rd.forward(request, response);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
