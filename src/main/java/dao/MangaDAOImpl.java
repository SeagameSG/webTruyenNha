package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import model.MangaDt;
import model.MgChapterDt;

public class MangaDAOImpl implements MangaDAO {
	private Connection conn;

	public MangaDAOImpl(Connection conn) {
		super();
		this.conn = conn;
	}
	
	public List<MangaDt> getAllManga() {
		List<MangaDt> list = new ArrayList<MangaDt>();
		MangaDt data = null;
		try {
			PreparedStatement ps = conn.prepareStatement("select * from mangas");
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				data = new MangaDt();
				data.setId(rs.getInt(1));
				data.setMgName(rs.getString(2));
				data.setMgCategory(rs.getString(3));
				data.setMgStatus(rs.getString(4));
				data.setMgImg(rs.getString(5));
				data.setMgDetail(rs.getString(6));
				list.add(data);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return list;
		
	}
	public MangaDt getMgById(int id) {
		MangaDt data = null;
		try {
			PreparedStatement ps = conn.prepareStatement("select * from mangas where id=?");
			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				data = new MangaDt();
				data.setId(rs.getInt(1));
				data.setMgName(rs.getString(2));
				data.setMgCategory(rs.getString(3));
				data.setMgStatus(rs.getString(4));
				data.setMgImg(rs.getString(5));
				data.setMgDetail(rs.getString(6));
			}
			data.setMgChapter(getMgChapterById(id));
		} catch (Exception e) {
			e.printStackTrace();
		}
		return data;
	}
	public List<MgChapterDt> getMgChapterById(int id) {
		List<MgChapterDt> list = new ArrayList<MgChapterDt>();
		MgChapterDt data= null;
		try {
			PreparedStatement ps = conn.prepareStatement("select * from mgchapters where idmg=? order by ordnumber desc");
			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {			
				data = new MgChapterDt();
				data.setCtId(rs.getInt(1));
				data.setCtName(rs.getString(3));
				data.setCtImgPack(rs.getString(4));
				data.setCtOrdN(rs.getInt(5));
				data.setCtImgN(rs.getInt(6));
				list.add(data);
			}			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}
	public MgChapterDt getLatestChapterById(int id) {
		MgChapterDt data= null;
		try {
			PreparedStatement ps = conn.prepareStatement("select * from mgchapters where idmg=? order by ordnumber desc limit 1");
			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();
			if (rs.next()) {			
				data = new MgChapterDt();
				data.setCtId(rs.getInt(1));
				data.setCtName(rs.getString(3));
				data.setCtImgPack(rs.getString(4));
				data.setCtOrdN(rs.getInt(5));
				data.setCtImgN(rs.getInt(6));
			}			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return data;
	}
	
	public List<MangaDt> getMgByCategory(String ct){
		List<MangaDt> list = new ArrayList<MangaDt>();
		MangaDt data = null;
		try {
			PreparedStatement ps = conn.prepareStatement("select * from mangas where mgcategory like ?");
			ps.setString(1, "%"+ct+"%");
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				data = new MangaDt();
				data.setId(rs.getInt(1));
				data.setMgName(rs.getString(2));
				data.setMgCategory(rs.getString(3));
				data.setMgStatus(rs.getString(4));
				data.setMgImg(rs.getString(5));
				data.setMgDetail(rs.getString(6));
				list.add(data);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}
	public List<MangaDt> getMgByStatus(String st){
		List<MangaDt> list = new ArrayList<MangaDt>();
		MangaDt data = null;
		try {
			PreparedStatement ps = conn.prepareStatement("select * from mangas where mgstatus like ?");
			ps.setString(1, "%"+st+"%");
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				data = new MangaDt();
				data.setId(rs.getInt(1));
				data.setMgName(rs.getString(2));
				data.setMgCategory(rs.getString(3));
				data.setMgStatus(rs.getString(4));
				data.setMgImg(rs.getString(5));
				data.setMgDetail(rs.getString(6));
				list.add(data);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}
	public List<MangaDt> findByName(String name){
		List<MangaDt> list = new ArrayList<MangaDt>();
		MangaDt data = null;
		try {
			PreparedStatement ps = conn.prepareStatement("select * from mangas where mgname like ?");
			ps.setString(1, "%"+name+"%");
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				data = new MangaDt();
				data.setId(rs.getInt(1));
				data.setMgName(rs.getString(2));
				data.setMgCategory(rs.getString(3));
				data.setMgStatus(rs.getString(4));
				data.setMgImg(rs.getString(5));
				data.setMgDetail(rs.getString(6));
				list.add(data);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}
	public MgChapterDt getChapterByOrdnumber(int id,int stt) {
		MgChapterDt data = null;
		try {
			PreparedStatement ps = conn.prepareStatement("select * from mgchapters where idmg=? and ordnumber=?");
			ps.setInt(1, id);
			ps.setInt(2, stt);
			ResultSet rs = ps.executeQuery();
			if(rs.next()) {
				data = new MgChapterDt();
				data.setCtId(rs.getInt(1));
				data.setCtName(rs.getString(3));
				data.setCtImgPack(rs.getString(4));
				data.setCtOrdN(rs.getInt(5));
				data.setCtImgN(rs.getInt(6));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return data;
	}
	public boolean checkChapterExist(int id,int stt) {
		boolean result=false;
		try {
			PreparedStatement ps = conn.prepareStatement("select * from mgchapters where idmg=? and ordnumber=?");
			ps.setInt(1, id);
			ps.setInt(2, stt);
			ResultSet rs = ps.executeQuery();
			if(rs.next()) {
				result = true;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}
}
