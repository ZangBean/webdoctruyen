package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;

import bean.AdminBean;

public class Admin_DangNhapDao {
	public AdminBean checkAdminAccount(String TaiKhoan, String MatKhau){
		try {
			KetNoiDao kn = new KetNoiDao();
			kn.KetNoi();
			String sql="select * from Admin where TaiKhoan=? and MatKhau=?";
			PreparedStatement cmd=kn.cn.prepareStatement(sql);
			cmd.setString(1, TaiKhoan);
			cmd.setString(2, MatKhau);
			AdminBean dn = null;
			ResultSet rs=cmd.executeQuery();
			if(rs.next()) {
				 dn = new AdminBean(TaiKhoan, MatKhau);
			}
			rs.close();
			kn.cn.close();
			return dn;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
}
