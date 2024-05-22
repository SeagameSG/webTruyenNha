package controller.showservlet;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.MangaDt;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import dao.MangaDAOImpl;
import dao.SavedListDAOImpl;
import database.DBConnect;

@WebServlet("/showsavedlist")
public class ShowSavedListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		try {
			int id = Integer.parseInt(request.getParameter("id"));
			SavedListDAOImpl sldao = new SavedListDAOImpl(DBConnect.getConn());
			List<Integer> idlist = sldao.getAllList(id);
			MangaDAOImpl dao = new MangaDAOImpl(DBConnect.getConn());
			List<MangaDt> mglist = new ArrayList<MangaDt>();
			for (Integer i : idlist) {
				MangaDt manga = dao.getMgById(i);
				mglist.add(manga);
			}
			request.setAttribute("mgsavedObj", mglist);
			RequestDispatcher rd = request.getRequestDispatcher("/showratelist");
			rd.forward(request, response);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
