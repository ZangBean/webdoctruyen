package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Date;

import bean.ChuongBean;
import bean.LichSuBean;
import bean.TruyenBean;


public class LichSuDao {
	public ArrayList<LichSuBean> getLichSu(long MaKhachHang){
		try {
			ArrayList<LichSuBean> ds=new ArrayList<LichSuBean>();
			TruyenDao tdao =new TruyenDao();
			ChuongDao cdao = new ChuongDao();
			KetNoiDao kn = new KetNoiDao();
			kn.KetNoi();
			String sql="select top 10 * from LichSu where MaKhachHang=? order by NgayXem desc";
			PreparedStatement cmd=kn.cn.prepareStatement(sql);
			cmd.setLong(1, MaKhachHang);
			ResultSet rs=cmd.executeQuery();
			while(rs.next()) {
				String MaTruyen = rs.getString("MaTruyen");
				TruyenBean Truyen = tdao.getChiTietTruyen(MaTruyen);
				long MaLichSu = rs.getLong("MaLichSu");
				Date NgayXem = rs.getDate("NgayXem");
				long MaChuong = rs.getLong("MaChuong");
				ChuongBean Chuong = cdao.searchTenChuong(MaChuong);
				ds.add(new LichSuBean(MaLichSu, MaTruyen, MaKhachHang, NgayXem, MaChuong, Truyen, Chuong));
			}
			rs.close();
			kn.cn.close();
			return ds;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	public int ThemLichSu(long MaKhachHang, String MaTruyen, long MaChuong) {
		try {
			KetNoiDao kn = new KetNoiDao();
			kn.KetNoi();
			String sql="INSERT INTO LichSu(MaKhachHang, MaTruyen, NgayXem, MaChuong) values(?,?,?,?)";
	        PreparedStatement cmd=kn.cn.prepareStatement(sql);
	        cmd.setLong(1, MaKhachHang);
	        cmd.setString(2, MaTruyen);
	        cmd.setTimestamp(3, new java.sql.Timestamp(new Date().getTime()));
	        cmd.setLong(4, MaChuong);
	        return cmd.executeUpdate();
		} catch (Exception e) {
			return -1;
		}
	}
	public void XoaLichSuTruyen(String MaTruyen) {
		try {
			KetNoiDao kn = new KetNoiDao();
			kn.KetNoi();
			String sql="DELETE FROM LichSu WHERE MaTruyen = ?";
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
