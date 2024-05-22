package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.HashMap;

import model.MgRateDt;

public class RateDAOImpl implements RateDAO{
	private Connection conn;

	public RateDAOImpl(Connection conn) {
		super();
		this.conn = conn;
	}
	public HashMap<Integer, MgRateDt> getAllRateInMg(int idmg) {
		HashMap<Integer, MgRateDt> map = new HashMap<>();
		MgRateDt data = null;
		int i = 0;
		try {
			PreparedStatement ps = conn.prepareStatement("select iduser, idrate, comment, point from mgrates where idmg = ? order by idrate DESC");
			ps.setInt(1, idmg);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				data = new MgRateDt();
				i = rs.getInt(1);
				data.setrId(rs.getInt(2));
				data.setrCmt(rs.getString(3));
				data.setrPoint(rs.getDouble(4));
				map.put(i,data);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return map;
	}
	
	public HashMap<Integer, MgRateDt> getRateByUser(int iduser) {
		HashMap<Integer, MgRateDt> map = new HashMap<>();
		MgRateDt data = null;
		int i = 0;
		try {
			PreparedStatement ps = conn.prepareStatement("select idmg, idrate, comment, point from mgrates where iduser = ? order by idrate DESC");
			ps.setInt(1, iduser);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				data = new MgRateDt();
				i = rs.getInt(1);
				data.setrId(rs.getInt(2));
				data.setrCmt(rs.getString(3));
				data.setrPoint(rs.getDouble(4));
				map.put(i,data);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return map;
	}
	
	public boolean postRate(int iduser, int idmg, String cmt, double point) {
		boolean result = false;
		int rowCount = 0;
		try {
			if (checkExist(iduser, idmg)) {
				PreparedStatement ps = conn.prepareStatement("update mgrates set comment = ? , point = ? where iduser=? and idmg=?");
				ps.setString(1, cmt);
				ps.setDouble(2, point);
				ps.setInt(3, iduser);
				ps.setInt(4, idmg);
				rowCount = ps.executeUpdate();	
			}else {
				PreparedStatement ps = conn.prepareStatement("insert into mgrates(iduser,idmg,comment,point) values(?,?,?,?)");
				ps.setInt(1, iduser);
				ps.setInt(2, idmg);
				ps.setString(3, cmt);
				ps.setDouble(4, point);
				rowCount = ps.executeUpdate();				
			}
			if (rowCount == 1) {
				result = true;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}

	public boolean checkExist(int iduser, int idmg) {
		boolean result = false;
		try {
			PreparedStatement ps = conn.prepareStatement("select * from mgrates where iduser = ? and idmg = ?");
			ps.setInt(1, iduser);
			ps.setInt(2, idmg);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				result = true;
				break;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}
	
	public boolean deleteRate(int iduser, int idmg) {
		boolean result = false;
		try {
			PreparedStatement ps = conn.prepareStatement("delete from mgrates where iduser = ? and idmg = ?");
			ps.setInt(1, iduser);
			ps.setInt(2, idmg);
			int rowCount = ps.executeUpdate();
			if (rowCount == 1) {
				result = true;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}
	
	public double getAvgPointMg(int idmg) {
		double result = 0;
		try {
			PreparedStatement ps = conn.prepareStatement("select AVG(point) from mgrates where idmg = ?");
			ps.setInt(1, idmg);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				result = rs.getDouble(1);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}
	
	public int getRateTotal(int idmg) {
		int result = 0;
		try {
			PreparedStatement ps = conn.prepareStatement("select COUNT(*) from mgrates where idmg = ?");
			ps.setInt(1, idmg);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				result = rs.getInt(1);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}
}
