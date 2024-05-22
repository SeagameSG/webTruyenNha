package dao;

import java.util.List;

public interface SavedListDAO {
	public List<Integer> getAllList(int iduser);
	public boolean saveManga(int iduser,int idmg);
	public boolean checkDuplicate(int iduser,int idmg);
	public boolean deleteFromList(int iduser, int idmg);
}
