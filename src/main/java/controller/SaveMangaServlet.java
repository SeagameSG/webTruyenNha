package controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

import dao.SavedListDAOImpl;
import database.DBConnect;

/**
 * Servlet implementation class SaveMangaServlet
 */
@WebServlet("/save")
public class SaveMangaServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		try {
			int iduser = Integer.parseInt(request.getParameter("iduser"));
			int idmg = Integer.parseInt(request.getParameter("idmg"));
			HttpSession session = request.getSession();
			SavedListDAOImpl sldao = new SavedListDAOImpl(DBConnect.getConn());
			if (sldao.checkDuplicate(iduser, idmg)) {
				session.setAttribute("failedMsg", "Bạn đã lưu truyện này rồi");
				response.sendRedirect("showManga?id="+ idmg);
			}
			boolean check = sldao.saveManga(iduser, idmg);
			if(check) {
				session.setAttribute("successMsg", "Lưu thành công");	
				response.sendRedirect("showManga?id="+ idmg);
			}else {
				session.setAttribute("failedMsg", "Lưu thất bại");
				response.sendRedirect("showManga?id="+ idmg);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
