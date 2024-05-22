package dao;

import java.util.List;

import model.MangaDt;
import model.MgChapterDt;

public interface MangaDAO {
	public List<MangaDt> getAllManga();
	public MangaDt getMgById(int id);
	public List<MgChapterDt> getMgChapterById(int id);
	public List<MangaDt> getMgByCategory(String ct);
	public MgChapterDt getLatestChapterById(int id);
	public List<MangaDt> getMgByStatus(String st);
	public List<MangaDt> findByName(String name);
	public MgChapterDt getChapterByOrdnumber(int id,int stt);
	public boolean checkChapterExist(int id,int stt);
}
