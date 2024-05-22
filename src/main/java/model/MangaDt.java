package model;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.StringTokenizer;


public class MangaDt {
	private int id;
	private String mgName;
	private String mgCategory;
	private String mgStatus;
	private String mgImg;
	private String mgDetail;
	private double mgPoint;
	private int mgRateNum;
	private List<MgChapterDt> mgChapter;
	public MangaDt(int id, String mgName, String mgCategory, String mgStatus, String mgImg, String mgDetail) {
		super();
		this.id = id;
		this.mgName = mgName;
		this.mgCategory = mgCategory;
		this.mgStatus = mgStatus;
		this.mgImg = mgImg;
		this.mgDetail = mgDetail;
	}
	
	public MangaDt() {
		super();
	}

	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getMgName() {
		return mgName;
	}
	public void setMgName(String mgName) {
		this.mgName = mgName;
	}
	public String getMgCategory() {
		return mgCategory;
	}
	public void setMgCategory(String mgCategory) {
		this.mgCategory = mgCategory;
	}
	public String getMgStatus() {
		return mgStatus;
	}
	public void setMgStatus(String mgStatus) {
		this.mgStatus = mgStatus;
	}
	public String getMgImg() {
		return mgImg;
	}
	public void setMgImg(String mgImg) {
		this.mgImg = mgImg;
	}
	public String getMgDetail() {
		return mgDetail;
	}
	public void setMgDetail(String mgDetail) {
		this.mgDetail = mgDetail;
	}
	public double getMgPoint() {
		return mgPoint;
	}

	public void setMgPoint(double mgPoint) {
		this.mgPoint = mgPoint;
	}

	public int getMgRateNum() {
		return mgRateNum;
	}

	public void setMgRateNum(int mgRateNum) {
		this.mgRateNum = mgRateNum;
	}

	public List<MgChapterDt> getMgChapter() {
		return mgChapter;
	}

	public void setMgChapter(List<MgChapterDt> mgChapter) {
		this.mgChapter = mgChapter;
	}

	private List<String> stringTokenizer(String str) {
	    StringTokenizer st = new StringTokenizer(str, "/");
	    List<String> list = new ArrayList<String>();
	    while (st.hasMoreTokens()) {
	        String token = st.nextToken();
	        list.add(token);
	    }
	    return list;
	}
	public List<String> getEachCategory(){
		return this.stringTokenizer(mgCategory);
	}
	public List<String> getEachStatus() {
		return this.stringTokenizer(mgStatus);
	}

	@Override
	public int hashCode() {
		return Objects.hash(id, mgCategory, mgChapter, mgDetail, mgImg, mgName, mgPoint, mgRateNum, mgStatus);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		MangaDt other = (MangaDt) obj;
		return id == other.id && Objects.equals(mgCategory, other.mgCategory)
				&& Objects.equals(mgChapter, other.mgChapter) && Objects.equals(mgDetail, other.mgDetail)
				&& Objects.equals(mgImg, other.mgImg) && Objects.equals(mgName, other.mgName)
				&& Double.doubleToLongBits(mgPoint) == Double.doubleToLongBits(other.mgPoint)
				&& mgRateNum == other.mgRateNum && Objects.equals(mgStatus, other.mgStatus);
	}
	
}

