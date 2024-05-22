package dao;

import java.util.HashMap;

import model.MgRateDt;

public interface RateDAO {
	public HashMap<Integer, MgRateDt> getAllRateInMg(int idmg);
	public HashMap<Integer, MgRateDt> getRateByUser(int iduser);
	public boolean postRate(int iduser, int idmg, String cmt, double point);
	public boolean checkExist(int iduser, int idmg);
	public boolean deleteRate(int iduser, int idmg);
	public double getAvgPointMg(int idmg);
	public int getRateTotal(int idmg);
}