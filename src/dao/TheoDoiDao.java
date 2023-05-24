package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import bean.TheoDoiBean;
import bean.TruyenBean;

public class TheoDoiDao {
	public ArrayList<TheoDoiBean> ds= new ArrayList<TheoDoiBean>();
	public ArrayList<TheoDoiBean> dsTheoDoi(long MaKhachHang){
		try {
			ArrayList<TheoDoiBean> ds = new ArrayList<TheoDoiBean>();
			TruyenDao tdao = new TruyenDao();
			ChuongDao cdao = new ChuongDao();
			BinhLuanDao bldao = new BinhLuanDao();
			KetNoiDao kn = new KetNoiDao();
			kn.KetNoi();
			String sql="select * from Truyen inner join TheoDoi on Truyen.MaTruyen = TheoDoi.MaTruyen where MaKhachHang=? order by NgayThemChuong desc ";
			PreparedStatement cmd=kn.cn.prepareStatement(sql);
			cmd.setLong(1, MaKhachHang);
			ResultSet rs=cmd.executeQuery();
			while(rs.next()) {
				long MaTheoDoi = rs.getLong("MaTheoDoi");
				String MaTruyen=rs.getString("MaTruyen");
				TruyenBean Truyen = tdao.getChiTietTruyen(MaTruyen);
				int Chuong = cdao.DemSoChuong(MaTruyen);
				int BinhLuan = bldao.DemBinhLuan(MaTruyen);
				ds.add(new TheoDoiBean(MaTheoDoi, MaTruyen, MaKhachHang, Truyen, Chuong, BinhLuan));
			}
			rs.close();
			kn.cn.close();
			return ds;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	public void TheoDoi(String MaTruyen, long MaKhachHang) {
		try {
			KetNoiDao kn = new KetNoiDao();
			kn.KetNoi();
			PreparedStatement cmd;
			if(CheckTheoDoi(MaTruyen, MaKhachHang)) {				
				String sql="delete TheoDoi where MaTruyen =? and MaKhachHang=?";
				cmd=kn.cn.prepareStatement(sql);
				cmd.setString(1, MaTruyen);
				cmd.setLong(2, MaKhachHang);
			}else {
				String sql="insert into TheoDoi(MaTruyen,MaKhachHang) values(?,?)";
				cmd=kn.cn.prepareStatement(sql);
				cmd.setString(1, MaTruyen);
				cmd.setLong(2, MaKhachHang);
			}
			cmd.execute();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	public Boolean CheckTheoDoi(String MaTruyen, long MaKhachHang) {
		try {
			KetNoiDao kn = new KetNoiDao();
			kn.KetNoi();
			String sql="select * from theodoi where Matruyen=? and MakhachHang = ?";
			PreparedStatement cmd=kn.cn.prepareStatement(sql);
			cmd.setString(1, MaTruyen);
			cmd.setLong(2, MaKhachHang);
			ResultSet rs=cmd.executeQuery();
			return rs.next();
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}
	public int DemSoTheoDoi(String MaTruyen) {
	    try {
	        KetNoiDao kn = new KetNoiDao();
	        kn.KetNoi();
	        String sql = "select count(*) as SoTheoDoi from TheoDoi where MaTruyen = ?";
	        PreparedStatement cmd = kn.cn.prepareStatement(sql);
	        cmd.setString(1, MaTruyen);
	        ResultSet rs = cmd.executeQuery();    
	        if (rs.next()) {
	            return rs.getInt("SoTheoDoi");
	        }
	    } catch (Exception e) {
	        e.printStackTrace();
	    }
	    return -1;
	}
}
