package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;

import bean.AdminBean;

public class Admin_DangKyDao {
	public AdminBean searchAdminUserName(String TaiKhoan) {
		try {
			KetNoiDao kn = new KetNoiDao();
			kn.KetNoi();
			String sql = "select * from Admin where TaiKhoan=?";
			PreparedStatement cmd = kn.cn.prepareStatement(sql);
			cmd.setString(1, TaiKhoan);
			ResultSet rs = cmd.executeQuery();
			if(rs.next()) {
				String MatKhau = rs.getString("TaiKhoan");
				return new AdminBean(TaiKhoan, MatKhau);
			}
			return null;
		} catch (Exception e) {
			// TODO: handle exception
			return null;
		}
	}
	public AdminBean registerAdminAccount(String TaiKhoan, String MatKhau){
		AdminBean Abean = searchAdminUserName(TaiKhoan);
		if(Abean == null) {	
			try {
				KetNoiDao kn = new KetNoiDao();
				kn.KetNoi();
				String sql="insert into Admin(TaiKhoan,MatKhau) values(?,?)";
				PreparedStatement cmd=kn.cn.prepareStatement(sql);
				cmd.setString(1, TaiKhoan);
				cmd.setString(2, MatKhau);
				cmd.executeUpdate();
				kn.cn.close();
				return new AdminBean(TaiKhoan, MatKhau);
			} catch (Exception e) {
				e.printStackTrace();
				return null;
			}	
		}
		else{
			return null;
		}
	}
}
