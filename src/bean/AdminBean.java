package bean;

public class AdminBean {
	private String TaiKhoan;
	private String MatKhau;
	public String getTaiKhoan() {
		return TaiKhoan;
	}
	public void setTaiKhoan(String taiKhoan) {
		this.TaiKhoan = taiKhoan;
	}
	public String getMatKhau() {
		return MatKhau;
	}
	public void setMatKhau(String matKhau) {
		this.MatKhau = matKhau;
	}
	public AdminBean(String taiKhoan, String matKhau) {
		super();
		this.TaiKhoan = taiKhoan;
		this.MatKhau = matKhau;
	}
	public AdminBean() {
		super();
		// TODO Auto-generated constructor stub
	}
}
