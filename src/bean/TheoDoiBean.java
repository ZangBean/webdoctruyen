package bean;

public class TheoDoiBean {
	private long MaTheoDoi;
	private String MaTruyen;
	private long MaKhachHang;
	private TruyenBean Truyen;
	private Integer Chuong;
	private Integer BinhLuan;
	public TheoDoiBean() {
		super();
		// TODO Auto-generated constructor stub
	}
	public TheoDoiBean(long maTheoDoi, String maTruyen, long maKhachHang) {
		super();
		MaTheoDoi = maTheoDoi;
		MaTruyen = maTruyen;
		MaKhachHang = maKhachHang;
	}
	public TheoDoiBean(long maTheoDoi, String maTruyen, long maKhachHang, TruyenBean truyen, Integer chuong,
			Integer binhLuan) {
		super();
		MaTheoDoi = maTheoDoi;
		MaTruyen = maTruyen;
		MaKhachHang = maKhachHang;
		Truyen = truyen;
		Chuong = chuong;
		BinhLuan = binhLuan;
	}
	public Integer getChuong() {
		return Chuong;
	}
	public void setChuong(Integer chuong) {
		Chuong = chuong;
	}
	public Integer getBinhLuan() {
		return BinhLuan;
	}
	public void setBinhLuan(Integer binhLuan) {
		BinhLuan = binhLuan;
	}
	public TruyenBean getTruyen() {
		return Truyen;
	}
	public void setTruyen(TruyenBean truyen) {
		Truyen = truyen;
	}
	public long getMaTheoDoi() {
		return MaTheoDoi;
	}
	public void setMaTheoDoi(long maTheoDoi) {
		MaTheoDoi = maTheoDoi;
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
	
}
