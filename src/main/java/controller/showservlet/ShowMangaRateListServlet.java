package controller.showservlet;

import java.io.IOException;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import dao.MangaDAOImpl;
import dao.RateDAOImpl;
import dao.UserDAOImpl;
import database.DBConnect;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.MangaDt;
import model.MgRateDt;

@WebServlet("/showmangarate")
public class ShowMangaRateListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		try {
			int id = Integer.parseInt(request.getParameter("id"));
			RateDAOImpl dao = new RateDAOImpl(DBConnect.getConn());
			HashMap<Integer, MgRateDt> map  = dao.getAllRateInMg(id);
			UserDAOImpl usdao = new UserDAOImpl(DBConnect.getConn());
			HashMap<String, MgRateDt> resultMap = new HashMap<>();
			for(Map.Entry<Integer, MgRateDt> entry : map.entrySet()) {
				String usname = usdao.getUserNameById(entry.getKey());
				if(usname != null) {
					resultMap.put(usname, entry.getValue());
				}
			}
			request.setAttribute("rateList", resultMap);
			MangaDAOImpl mgdao = new MangaDAOImpl(DBConnect.getConn());
			List<MangaDt> topmg = mgdao.getAllManga();
			for (MangaDt mg : topmg) {
				mg.setMgPoint(dao.getAvgPointMg(mg.getId()));
			}
			Collections.sort(topmg, new Comparator<>() {
			    @Override
			    public int compare(MangaDt m1,MangaDt m2) {
			        return (int)(m2.getMgPoint() - m1.getMgPoint());
			    }
			});
			request.setAttribute("toprt", topmg);
			RequestDispatcher rd = request.getRequestDispatcher("/manga.jsp");
			rd.forward(request, response);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
