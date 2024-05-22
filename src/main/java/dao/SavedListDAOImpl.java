package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class SavedListDAOImpl implements SavedListDAO {
	private Connection conn;

	public SavedListDAOImpl(Connection conn) {
		super();
		this.conn = conn;
	}

	public List<Integer> getAllList(int iduser) {
		List<Integer> list = new ArrayList<Integer>();
		int data = 0;
		try {
			PreparedStatement ps = conn.prepareStatement("select idmg from mgsavedlist where iduser = ?");
			ps.setInt(1, iduser);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				data = rs.getInt(1);
				list.add(data);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}

	public boolean saveManga(int iduser, int idmg) {
		boolean result = false;
		try {
			if (!checkDuplicate(iduser, idmg)) {
				PreparedStatement ps = conn.prepareStatement("insert into mgsavedlist(iduser,idmg) values(?,?)");
				ps.setInt(1, iduser);
				ps.setInt(2, idmg);
				int rowCount = ps.executeUpdate();
				if (rowCount == 1) {
					result = true;
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}

	public boolean checkDuplicate(int iduser, int idmg) {
		boolean result = false;
		try {
			PreparedStatement ps = conn.prepareStatement("select * from mgsavedlist where iduser = ? and idmg = ?");
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

	public boolean deleteFromList(int iduser, int idmg) {
		boolean result = false;
		try {
			PreparedStatement ps = conn.prepareStatement("delete from mgsavedlist where iduser = ? and idmg = ?");
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
}
