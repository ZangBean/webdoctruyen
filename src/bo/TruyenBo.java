package bo;

import java.util.ArrayList;

import bean.TruyenBean;
import dao.TruyenDao;

public class TruyenBo {
	TruyenDao tdao = new TruyenDao();
	ArrayList<TruyenBean> ds;
	public ArrayList<TruyenBean> getTruyen(){
		ds = tdao.getTruyen();
		return ds;
	}
	public ArrayList<TruyenBean> getTruyenByUpDown(){
		ds = tdao.getTruyenByUpDown();
		return ds;
	}
	public int CountTruyen(String TenTruyen) {
		return tdao.CountTruyen(TenTruyen);
	}
	public int CountTruyenByTheLoai(String MaTheLoai) {
		return tdao.CountTruyenByTheLoai(MaTheLoai);
	}
	public TruyenBean getChiTietTruyen(String mt){
		return tdao.getChiTietTruyen(mt);
	}
	public void TangLuotXem(String matruyen) {
		tdao.TangLuotXem(matruyen);
	}
	public void SuaTruyen(String TenTruyen, String TacGia, String GioiThieu, String MaTheLoai, String MaTruyen ) {
		tdao.SuaTruyen(TenTruyen, TacGia, GioiThieu, MaTheLoai, MaTruyen);
	}
	public void SuaAnh(String AnhNen, String AnhTruyen, String MaTruyen ) {
		tdao.SuaAnh(AnhNen, AnhTruyen, MaTruyen);
	}
	public void TruyenDone(String MaTruyen ) {
		tdao.TruyenDone(MaTruyen);
	}
	public void TruyenUpdate(String MaTruyen ) {
		tdao.TruyenUpdate(MaTruyen);
	}
	public int ThemTruyen(String MaTruyen, String TenTruyen, String TacGia, String GioiThieu, String AnhTruyen,
			long LuotXem, boolean HoanThanh, String MaTheLoai, String AnhNen) {
		return tdao.ThemTruyen(MaTruyen, TenTruyen, TacGia, GioiThieu, AnhTruyen, LuotXem, HoanThanh, MaTheLoai, AnhNen);
	}
	public void XoaTruyen(String MaTruyen) {
		tdao.XoaTruyen(MaTruyen);
	}
	public ArrayList<TruyenBean> getPhanTrang(int index) {
		return tdao.getPhanTrang(index);
	}
	public ArrayList<TruyenBean> getPhanTrangByTenTruyen(String TenTruyen,int index) {
		return tdao.getPhanTrangByTenTruyen(TenTruyen, index);
	}
	public ArrayList<TruyenBean> getPhanTrangByTheLoai(String MaTheLoai,int index) {
		return tdao.getPhanTrangByTheLoai(MaTheLoai, index);
	}
	public ArrayList<TruyenBean> TimTruyen(String Key) {
		return tdao.TimTruyen(Key);
	}
}
