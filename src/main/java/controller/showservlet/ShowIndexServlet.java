package controller.showservlet;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;

import dao.MangaDAOImpl;
import database.DBConnect;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import model.MangaDt;
import model.MgChapterDt;

@WebServlet("/index")
public class ShowIndexServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		try {
			MangaDAOImpl dao = new MangaDAOImpl(DBConnect.getConn());
			HttpSession session = request.getSession();
			List<MangaDt> newMg = dao.getMgByStatus("NEW");
			HashMap<MangaDt, MgChapterDt> map = new HashMap<>();
			for (MangaDt mg : newMg) {
				map.put(mg, dao.getLatestChapterById(mg.getId()));
			}
			session.setAttribute("hotmgObj", dao.getMgByStatus("HOT"));
			session.setAttribute("fullmgObj", dao.getMgByStatus("FULL"));
			session.setAttribute("newmgMap", map);
			response.sendRedirect("index.jsp");
		} catch (Exception e) {
			e.printStackTrace();
		}

	}
}
