package controller.showservlet;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import model.MangaDt;
import model.MgChapterDt;

import java.io.IOException;

import dao.MangaDAOImpl;
import database.DBConnect;

@WebServlet("/showchapter")
public class ShowChapterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		int idmg = Integer.parseInt(request.getParameter("idmg"));
		try {
			int stt = Integer.parseInt(request.getParameter("stt"));
			MangaDAOImpl dao = new MangaDAOImpl(DBConnect.getConn());
			MangaDt manga = dao.getMgById(idmg);
			HttpSession session = request.getSession();
			if(dao.checkChapterExist(idmg, stt)) {
				MgChapterDt chapter = dao.getChapterByOrdnumber(idmg, stt);
				session.setAttribute("chapter", chapter);
			} else {
				session.setAttribute("failedMsg", "Chương không tồn tại");
				response.sendRedirect("showManga?id=" + idmg);
			}
			boolean hasNext = dao.checkChapterExist(idmg, stt + 1);
			boolean hasPrev = dao.checkChapterExist(idmg, stt - 1);
			if(hasNext) {
				session.setAttribute("hasNextChapter", "Next");		
			}
			if(hasPrev) {
				session.setAttribute("hasPrevChapter", "Prev");
			}
			
			request.setAttribute("mangaObj", manga);
			RequestDispatcher rd = request.getRequestDispatcher("/chapter.jsp");
			rd.forward(request, response);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}