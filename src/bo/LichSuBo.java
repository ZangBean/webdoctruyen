package bo;

import java.util.ArrayList;

import bean.LichSuBean;
import dao.LichSuDao;

public class LichSuBo {
	LichSuDao lsdao= new LichSuDao();
	ArrayList<LichSuBean> ds;
	public ArrayList<LichSuBean> getLichSu(long MaKhachHang){
		ds = lsdao.getLichSu(MaKhachHang);
		return ds;
	}
	public void XoaLichSuTruyen(String MaTruyen) {
		lsdao.XoaLichSuTruyen(MaTruyen);
	}
	public int ThemLichSu(long MaKhachHang, String MaTruyen, long MaChuong) {
		return lsdao.ThemLichSu(MaKhachHang, MaTruyen, MaChuong);
	}
}
