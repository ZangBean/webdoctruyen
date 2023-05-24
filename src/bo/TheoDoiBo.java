package bo;

import java.util.ArrayList;

import bean.TheoDoiBean;
import dao.TheoDoiDao;

public class TheoDoiBo {
	TheoDoiDao tddao= new TheoDoiDao(); 
	public ArrayList<TheoDoiBean> dsTheoDoi(long MaKhachHang){
		return tddao.dsTheoDoi(MaKhachHang);
	}
	public void TheoDoi(String MaTruyen, long MaKhachHang) {
		tddao.TheoDoi(MaTruyen, MaKhachHang);
	}
	public Boolean CheckTheoDoi(String MaTruyen, long MaKhachHang) {
		return tddao.CheckTheoDoi(MaTruyen, MaKhachHang);
	}
	public int DemSoTheoDoi(String MaTruyen) {
		return tddao.DemSoTheoDoi(MaTruyen);
	}
}
