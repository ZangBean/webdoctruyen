package bo;

import java.util.ArrayList;

import bean.BinhLuanBean;
import dao.BinhLuanDao;

public class BinhLuanBo {
	BinhLuanDao bldao = new BinhLuanDao();
	ArrayList<BinhLuanBean> btbean;
	public ArrayList<BinhLuanBean> getBinhLuan(String MaTruyen){
		btbean = bldao.getBinhLuan(MaTruyen);
		return btbean;
	}
	public void XoaBinhLuan(long MaBinhLuan) {
		bldao.XoaBinhLuan(MaBinhLuan);
	}
	public int DemBinhLuan(String MaTruyen) {
		return bldao.DemBinhLuan(MaTruyen);
	}
	public ArrayList<Integer> CountAllBinhLuan() {
		return bldao.CountAllBinhLuan();
	}
	public ArrayList<Integer> DemAllBinhLuan(int index) {
		return bldao.DemAllBinhLuan(index);
	}
	public int ThemBinhLuan(long MaKhachHang, String BinhLuan, String MaTruyen){
		return bldao.ThemBinhLuan(MaKhachHang, BinhLuan, MaTruyen);
	}
	public ArrayList<Integer> DemAllBinhLuanByTenTruyen(String TenTruyen,int index) {
		return bldao.DemAllBinhLuanByTenTruyen(TenTruyen, index);
	}
	public ArrayList<Integer> DemAllBinhLuanByTheLoai(String MaTheLoai,int index) {
		return bldao.DemAllBinhLuanByTheLoai(MaTheLoai, index);
	}
	public ArrayList<BinhLuanBean> getBinhLuanByBaoCao(){
		return bldao.getBinhLuanByBaoCao();
	}
	public void BaoCaoBinhLuan(long MaBinhLuan) {
		bldao.BaoCaoBinhLuan(MaBinhLuan);
	}
	public void BaoCaoSkip(long MaBinhLuan) {
		bldao.BaoCaoSkip(MaBinhLuan);
	}
}
