package bean;

public class KhachHangBean {
	private String HoTen;
	private String Email;
	private String MatKhau;
	private String Avatar;
	public KhachHangBean() {
		super();
		// TODO Auto-generated constructor stub
	}
	public KhachHangBean(String hoTen, String email, String matKhau, String avatar) {
		super();
		HoTen = hoTen;
		Email = email;
		MatKhau = matKhau;
		Avatar = avatar;
	}
	public String getHoTen() {
		return HoTen;
	}
	public void setHoTen(String hoTen) {
		HoTen = hoTen;
	}
	public String getEmail() {
		return Email;
	}
	public void setEmail(String email) {
		Email = email;
	}
	public String getMatKhau() {
		return MatKhau;
	}
	public void setMatKhau(String matKhau) {
		MatKhau = matKhau;
	}
	public String getAvatar() {
		return Avatar;
	}
	public void setAvatar(String avatar) {
		Avatar = avatar;
	}
}
