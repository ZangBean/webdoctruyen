package bean;

import java.util.Date;

public class ChuongBean {
	private long MaChuong;
	private String TenChuong;
	private String MaTruyen;
	private Date NgayThem;
	public ChuongBean() {
		super();
		// TODO Auto-generated constructor stub
	}
	public ChuongBean(long maChuong, String tenChuong, String maTruyen, Date ngayThem) {
		super();
		this.MaChuong = maChuong;
		this.TenChuong = tenChuong;
		this.MaTruyen = maTruyen;
		this.NgayThem = ngayThem;
	}
	public long getMaChuong() {
		return MaChuong;
	}
	public void setMaChuong(long maChuong) {
		this.MaChuong = maChuong;
	}
	public String getTenChuong() {
		return TenChuong;
	}
	public void setTenChuong(String tenChuong) {
		this.TenChuong = tenChuong;
	}
	public String getMaTruyen() {
		return MaTruyen;
	}
	public void setMaTruyen(String maTruyen) {
		this.MaTruyen = maTruyen;
	}
	public Date getNgayThem() {
		return NgayThem;
	}
	public void setNgayThem(Date ngayThem) {
		this.NgayThem = ngayThem;
	}
	
}
