package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import model.User;

public class UserDAOImpl implements UserDAO {
	private Connection conn;
	
	public UserDAOImpl(Connection conn) {
		super();
		this.conn = conn;
	}

	public boolean userRegister(User us) {
		boolean result = false;
		try {
			PreparedStatement pst = conn.prepareStatement("insert into users(username,password,email) values(?,?,?)");
			pst.setString(1, us.getUsername());
			pst.setString(2, us.getPassword());
			pst.setString(3, us.getEmail());
			int rowCount = pst.executeUpdate();
			if (rowCount == 1) {
				result = true;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}
	public User login(String username,String password) {
		User us = null;
		try {
			PreparedStatement pst = conn.prepareStatement("select * from users where username = ? and password = ?");
			pst.setString(1, username);
			pst.setString(2, password);
			ResultSet rs = pst.executeQuery();
			
			while(rs.next()){
				us = new User();
				us.setId(rs.getInt(1));
				us.setUsername(rs.getString(2));
				us.setPassword(rs.getString(3));
				us.setEmail(rs.getString(4));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return us;
	}
	public boolean checkPass(int id,String password) {
		boolean result = false;
		try {
			PreparedStatement pst = conn.prepareStatement("select * from users where id = ? and password = ?");
			pst.setInt(1, id);
			pst.setString(2, password);
			ResultSet rs = pst.executeQuery();
			while (rs.next()) {
				result = true;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}
	public boolean updateUser(User us) {
		boolean result = false;
		try {
			PreparedStatement pst = conn.prepareStatement("update users set username = ? , password = ?, email = ? where id=?");
			pst.setString(1, us.getUsername());
			pst.setString(2, us.getPassword());
			pst.setString(3, us.getEmail());
			pst.setInt(4, us.getId());
			
			int i = pst.executeUpdate();
			if(i==1) result = true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}
	public String getUserNameById(int id) {
		String result = "";
		try {
			PreparedStatement pst = conn.prepareStatement("select username from users where id = ?");
			pst.setInt(1, id);
			ResultSet rs = pst.executeQuery();
			while (rs.next()) {
				result = rs.getString(1);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result; 
	}
}
