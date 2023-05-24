package bean;

import java.util.Date;

public class TruyenBean {
	private String MaTruyen;
	private String TenTruyen;
	private String TacGia;
	private String GioiThieu;
	private String AnhTruyen;
	private long LuotXem;
	private boolean HoanThanh;
	private String MaTheLoai;
	private String AnhNen;
	private Date NgayThem;
	private Date NgayThemChuong;
	public TruyenBean() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public TruyenBean(String maTruyen, String tenTruyen, String tacGia, String gioiThieu, String anhTruyen,
			long luotXem, boolean hoanThanh, String maTheLoai, String anhNen, Date ngayThem, Date ngayThemChuong) {
		super();
		MaTruyen = maTruyen;
		TenTruyen = tenTruyen;
		TacGia = tacGia;
		GioiThieu = gioiThieu;
		AnhTruyen = anhTruyen;
		LuotXem = luotXem;
		HoanThanh = hoanThanh;
		MaTheLoai = maTheLoai;
		AnhNen = anhNen;
		NgayThem = ngayThem;
		NgayThemChuong = ngayThemChuong;
	}

	public Date getNgayThemChuong() {
		return NgayThemChuong;
	}

	public void setNgayThemChuong(Date ngayThemChuong) {
		NgayThemChuong = ngayThemChuong;
	}

	public String getMaTruyen() {
		return MaTruyen;
	}
	public void setMaTruyen(String maTruyen) {
		this.MaTruyen = maTruyen;
	}
	public String getTenTruyen() {
		return TenTruyen;
	}
	public void setTenTruyen(String tenTruyen) {
		this.TenTruyen = tenTruyen;
	}
	public String getTacGia() {
		return TacGia;
	}
	public void setTacGia(String tacGia) {
		this.TacGia = tacGia;
	}
	public String getGioiThieu() {
		return GioiThieu;
	}
	public void setGioiThieu(String gioiThieu) {
		this.GioiThieu = gioiThieu;
	}
	public String getAnhTruyen() {
		return AnhTruyen;
	}
	public void setAnhTruyen(String anhTruyen) {
		this.AnhTruyen = anhTruyen;
	}
	public long getLuotXem() {
		return LuotXem;
	}
	public void setLuotXem(long luotXem) {
		this.LuotXem = luotXem;
	}
	public boolean isHoanThanh() {
		return HoanThanh;
	}
	public void setHoanThanh(boolean hoanThanh) {
		this.HoanThanh = hoanThanh;
	}
	public String getMaTheLoai() {
		return MaTheLoai;
	}
	public void setMaTheLoai(String maTheLoai) {
		this.MaTheLoai = maTheLoai;
	}
	public String getAnhNen() {
		return AnhNen;
	}
	public void setAnhNen(String anhNen) {
		this.AnhNen = anhNen;
	}
	public Date getNgayThem() {
		return NgayThem;
	}
	public void setNgayThem(Date ngayThem) {
		this.NgayThem = ngayThem;
	}
	
}
