package bo;

import java.util.ArrayList;

import bean.ChuongBean;
import dao.ChuongDao;

public class ChuongBo {
	ChuongDao cdao= new ChuongDao();
	ArrayList<ChuongBean> ds;
	public ArrayList<ChuongBean> getChuong(String MaTruyen){
		ds =cdao.getChuong(MaTruyen);
		return ds;
	}
	public void ThemChuong(String TenChuong, String MaTruyen) {
		cdao.ThemChuong(TenChuong, MaTruyen);
	}
	public int searchMaChuong(String TenChuong, String MaTruyen) {
		return cdao.searchMaChuong(TenChuong, MaTruyen);
	}
	public void XoaChuong(long MaChuong) {
		cdao.XoaChuong(MaChuong);
	}
	public void XoaChuongTruyen(String MaTruyen) {
		cdao.XoaChuongTruyen(MaTruyen);
	}
	public ChuongBean searchTenChuong(long MaChuong) {
		return cdao.searchTenChuong(MaChuong);
	}
	public int DemSoChuong(String MaTruyen) {
		return cdao.DemSoChuong(MaTruyen);
	}
	public ArrayList<Integer>CountAllChuong() {
		return cdao.CountAllChuong();
	}
	public ArrayList<Integer> DemAllChuong(int index) {
		return cdao.DemAllChuong(index);
	}
	public ArrayList<Integer> DemAllChuongByTenTruyen(String TenTruyen,int index) {
		return cdao.DemAllChuongByTenTruyen(TenTruyen, index);
	}
	public ArrayList<Integer> DemAllChuongByTheLoai(String MaTheLoai,int index) {
		return cdao.DemAllChuongByTheLoai(MaTheLoai, index);
	}
}
