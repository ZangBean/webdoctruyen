package bean;

import java.util.Date;


public class BinhLuanBean {
	private long MaBinhLuan;
	private long MaKhachHang;
	private String BinhLuan;
	private Date ThoiGian;
	private String MaTruyen;
	private boolean BaoCao;
	private TruyenBean Truyen;
	private KhachHangBean KhachHang;
	public BinhLuanBean() {
		super();
		// TODO Auto-generated constructor stub
	}
	public BinhLuanBean(long maBinhLuan, long maKhachHang, String binhLuan, Date thoiGian, String maTruyen) {
		super();
		this.MaBinhLuan = maBinhLuan;
		this.MaKhachHang = maKhachHang;
		this.BinhLuan = binhLuan;
		this.ThoiGian = thoiGian;
		this.MaTruyen = maTruyen;
	}
	
	public BinhLuanBean(long maBinhLuan, long maKhachHang, String binhLuan, Date thoiGian, String maTruyen,
			boolean baoCao, TruyenBean truyen, KhachHangBean khachHang) {
		super();
		MaBinhLuan = maBinhLuan;
		MaKhachHang = maKhachHang;
		BinhLuan = binhLuan;
		ThoiGian = thoiGian;
		MaTruyen = maTruyen;
		BaoCao = baoCao;
		Truyen = truyen;
		KhachHang = khachHang;
	}
	public TruyenBean getTruyen() {
		return Truyen;
	}
	public void setTruyen(TruyenBean truyen) {
		Truyen = truyen;
	}
	public boolean isBaoCao() {
		return BaoCao;
	}
	public void setBaoCao(boolean baoCao) {
		BaoCao = baoCao;
	}
	public KhachHangBean getKhachHang() {
		return KhachHang;
	}
	public void setKhachHang(KhachHangBean khachHang) {
		KhachHang = khachHang;
	}
	public long getMaBinhLuan() {
		return MaBinhLuan;
	}
	public void setMaBinhLuan(long maBinhLuan) {
		this.MaBinhLuan = maBinhLuan;
	}
	public long getMaKhachHang() {
		return MaKhachHang;
	}
	public void setMaKhachHang(long maKhachHang) {
		this.MaKhachHang = maKhachHang;
	}
	public String getBinhLuan() {
		return BinhLuan;
	}
	public void setBinhLuan(String binhLuan) {
		this.BinhLuan = binhLuan;
	}
	public Date getThoiGian() {
		return ThoiGian;
	}
	public void setThoiGian(Date thoiGian) {
		this.ThoiGian = thoiGian;
	}
	public String getMaTruyen() {
		return MaTruyen;
	}
	public void setMaTruyen(String maTruyen) {
		this.MaTruyen = maTruyen;
	}
	
}
