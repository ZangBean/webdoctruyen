package bean;

public class AnhTruyenBean {
	private long MaAnh;
	private String TenAnh;
	private long MaChuong;
	public AnhTruyenBean() {
		super();
		// TODO Auto-generated constructor stub
	}
	public AnhTruyenBean(long maAnh, String tenAnh, long maChuong) {
		super();
		MaAnh = maAnh;
		TenAnh = tenAnh;
		MaChuong = maChuong;
	}
	public long getMaAnh() {
		return MaAnh;
	}
	public void setMaAnh(long maAnh) {
		MaAnh = maAnh;
	}
	public String getTenAnh() {
		return TenAnh;
	}
	public void setTenAnh(String tenAnh) {
		TenAnh = tenAnh;
	}
	public long getMaChuong() {
		return MaChuong;
	}
	public void setMaChuong(long maChuong) {
		MaChuong = maChuong;
	}
	
}
