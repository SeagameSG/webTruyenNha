package controller.showservlet;

import java.io.IOException;
import java.util.List;

import dao.MangaDAOImpl;
import dao.RateDAOImpl;
import database.DBConnect;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.MangaDt;
import model.MgChapterDt;

@WebServlet("/showManga")
public class ShowMangaServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		try {
			int id = Integer.parseInt(request.getParameter("id"));
			MangaDAOImpl dao = new MangaDAOImpl(DBConnect.getConn());
			MangaDt manga = dao.getMgById(id);
			List<MgChapterDt> chapterls = dao.getMgChapterById(id);
			RateDAOImpl rtdao = new RateDAOImpl(DBConnect.getConn());
			manga.setMgChapter(chapterls);
			manga.setMgPoint(rtdao.getAvgPointMg(id));
			manga.setMgRateNum(rtdao.getRateTotal(id));
			request.setAttribute("mangaObj", manga);
			RequestDispatcher rd = request.getRequestDispatcher("/showmangarate");
			rd.forward(request, response);
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
