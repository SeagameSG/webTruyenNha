package dao;

import model.User;

public interface UserDAO {
	public boolean userRegister(User us);
	public User login(String username, String password);
	public boolean checkPass(int id,String password);
	public boolean updateUser(User us);
	public String getUserNameById(int id);
}
