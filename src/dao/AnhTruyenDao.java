package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import bean.AnhTruyenBean;

public class AnhTruyenDao {
	public ArrayList<AnhTruyenBean> ds= new ArrayList<AnhTruyenBean>();
	public ArrayList<AnhTruyenBean> getAnhTruyen(long MaChuong){
		ArrayList<AnhTruyenBean> ds = new ArrayList<AnhTruyenBean>();
		try {
			KetNoiDao kn = new KetNoiDao();
			kn.KetNoi();
			String sql="SELECT *, CAST(SUBSTRING(TenAnh, CHARINDEX('/', TenAnh, CHARINDEX('/', TenAnh, CHARINDEX('/', TenAnh, 1) + 1) + 1) + 1, CHARINDEX('.', TenAnh) - CHARINDEX('/', TenAnh, CHARINDEX('/', TenAnh, CHARINDEX('/', TenAnh, 1) + 1) + 1) - 1) AS INT) AS SoThuTu\r\n"
					+ "FROM AnhTruyen\r\n"
					+ "WHERE MaChuong = ?\r\n"
					+ "ORDER BY SoThuTu ASC";
			PreparedStatement cmd=kn.cn.prepareStatement(sql);
			cmd.setLong(1, MaChuong);
			ResultSet rs=cmd.executeQuery();
			while(rs.next()) {
				 String TenAnh =rs.getString("TenAnh");
				 long MaAnh =rs.getLong("MaAnh");
				ds.add(new AnhTruyenBean(MaAnh, TenAnh, MaChuong));
			}
			rs.close();
			kn.cn.close();
			return ds;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	public void ThemAnh(String TenAnh, int MaChuong, String MaTruyen) {
		try {
			KetNoiDao kn = new KetNoiDao();
			kn.KetNoi();
			String sql = "insert into AnhTruyen(TenAnh, MaChuong, MaTruyen) values (?,?,?)";
			PreparedStatement cmd = kn.cn.prepareStatement(sql);
			cmd.setString(1, TenAnh);
			cmd.setInt(2, MaChuong);
			cmd.setString(3, MaTruyen);
			cmd.executeUpdate();
			cmd.close();
			kn.cn.close();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}
	public void XoaAnhTruyen(String MaTruyen) {
		try {
			KetNoiDao kn = new KetNoiDao();
			kn.KetNoi();
			String sql="DELETE FROM AnhTruyen WHERE MaTruyen = ?";
			PreparedStatement cmd=kn.cn.prepareStatement(sql);
			cmd.setString(1, MaTruyen);
			cmd.executeUpdate();
			kn.cn.close();
			cmd.close();
		} catch (Exception e) {
			e.printStackTrace();
		}	
	}
}
