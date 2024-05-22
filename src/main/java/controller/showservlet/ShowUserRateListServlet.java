package controller.showservlet;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

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
import model.MgRateDt;

@WebServlet("/showratelist")
public class ShowUserRateListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		try {
			int id = Integer.parseInt(request.getParameter("id"));
			RateDAOImpl dao = new RateDAOImpl(DBConnect.getConn());
			HashMap<Integer, MgRateDt> map = dao.getRateByUser(id);
			MangaDAOImpl mgdao = new MangaDAOImpl(DBConnect.getConn());
			HashMap<MangaDt, MgRateDt> resultMap = new HashMap<>();
			for(Map.Entry<Integer, MgRateDt> entry : map.entrySet()) {
				MangaDt mg = mgdao.getMgById(entry.getKey());
				if (mg != null) {
					resultMap.put(mg,entry.getValue());
				}
			}
			request.setAttribute("rateMap", resultMap);
			RequestDispatcher rd = request.getRequestDispatcher("/users.jsp");
			rd.forward(request, response);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
