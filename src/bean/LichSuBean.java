package bean;

import java.util.Date;

public class LichSuBean {
	private long MaLichSu;
	private String MaTruyen;
	private long MaKhachHang;
	private Date NgayXem;
	private long MaChuong;
	private TruyenBean Truyen;
	private ChuongBean Chuong;
	public LichSuBean() {
		super();
		// TODO Auto-generated constructor stub
	}
	public LichSuBean(long maLichSu, String maTruyen, long maKhachHang, Date ngayXem, long maChuong) {
		super();
		MaLichSu = maLichSu;
		MaTruyen = maTruyen;
		MaKhachHang = maKhachHang;
		NgayXem = ngayXem;
		MaChuong = maChuong;
	}

	public LichSuBean(long maLichSu, String maTruyen, long maKhachHang, Date ngayXem, long maChuong, TruyenBean truyen,
			ChuongBean chuong) {
		super();
		MaLichSu = maLichSu;
		MaTruyen = maTruyen;
		MaKhachHang = maKhachHang;
		NgayXem = ngayXem;
		MaChuong = maChuong;
		Truyen = truyen;
		Chuong = chuong;
	}
	
	public ChuongBean getChuong() {
		return Chuong;
	}
	public void setChuong(ChuongBean chuong) {
		Chuong = chuong;
	}
	public TruyenBean getTruyen() {
		return Truyen;
	}
	public void setTruyen(TruyenBean truyen) {
		Truyen = truyen;
	}
	public long getMaLichSu() {
		return MaLichSu;
	}
	public void setMaLichSu(long maLichSu) {
		MaLichSu = maLichSu;
	}
	public String getMaTruyen() {
		return MaTruyen;
	}
	public void setMaTruyen(String maTruyen) {
		MaTruyen = maTruyen;
	}
	public long getMaKhachHang() {
		return MaKhachHang;
	}
	public void setMaKhachHang(long maKhachHang) {
		MaKhachHang = maKhachHang;
	}
	public Date getNgayXem() {
		return NgayXem;
	}
	public void setNgayXem(Date ngayXem) {
		NgayXem = ngayXem;
	}
	public long getMaChuong() {
		return MaChuong;
	}
	public void setMaChuong(long maChuong) {
		MaChuong = maChuong;
	}
	
}
