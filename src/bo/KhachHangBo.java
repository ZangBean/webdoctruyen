package bo;

import bean.KhachHangBean;
import dao.KhachHangDao;

public class KhachHangBo {
	KhachHangDao khdao = new KhachHangDao();
	public KhachHangBean SearchUserName(String HoTen) {
		return khdao.SearchUserName(HoTen);
	}
	public void UpdateKhachHang(long MaKhachHang, String MatKhau, String Avatar) {
		khdao.UpdateKhachHang(MaKhachHang, MatKhau, Avatar);
	}
	public long searchMaKhachHang(String HoTen) {
		return khdao.searchMaKhachHang(HoTen);
	}
	public String getTenKH(long MaKhachHang) {
		return khdao.getTenKH(MaKhachHang);
	}
	public void DeleteKhachHang(long MaKhachHang) {
		khdao.DeleteKhachHang(MaKhachHang);
	}
}
