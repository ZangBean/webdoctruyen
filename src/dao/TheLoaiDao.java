package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import bean.TheLoaiBean;

public class TheLoaiDao {
	public ArrayList<TheLoaiBean> ds= new ArrayList<TheLoaiBean>();
	public ArrayList<TheLoaiBean> getTheLoai(){
		try {
			ArrayList<TheLoaiBean> ds = new ArrayList<TheLoaiBean>();
			KetNoiDao kn = new KetNoiDao();
			kn.KetNoi();
			String sql="select * from TheLoai";
			PreparedStatement cmd=kn.cn.prepareStatement(sql);
			ResultSet rs=cmd.executeQuery();
			while(rs.next()) {
				 String MaTheLoai=rs.getString("MaTheLoai");
				 String TenTheLoai=rs.getString("TenTheLoai");
				ds.add(new TheLoaiBean(MaTheLoai, TenTheLoai));
			}
			rs.close();
			kn.cn.close();
			return ds;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	public TheLoaiBean ThemTheLoai(String MaTheLoai, String TenTheLoai){
		try {
			KetNoiDao kn = new KetNoiDao();
			kn.KetNoi();
			String sql="insert into TheLoai(MaTheLoai, TenTheLoai) values(?,?)";
			PreparedStatement cmd=kn.cn.prepareStatement(sql);
			cmd.setString(1, MaTheLoai);
			cmd.setString(2, TenTheLoai);
			cmd.executeUpdate();
			kn.cn.close();
			return new TheLoaiBean(MaTheLoai, TenTheLoai);
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}	
	}
	public void SuaTheLoai(String TenTheLoai, String MaTheLoai) {
		try {
			KetNoiDao kn = new KetNoiDao();
			kn.KetNoi();
			String sql="update TheLoai set TenTheLoai = ? where MaTheLoai = ?";
			PreparedStatement cmd=kn.cn.prepareStatement(sql);
			cmd.setString(1, TenTheLoai);
			cmd.setString(2, MaTheLoai);
			cmd.executeUpdate();
			kn.cn.close();
			cmd.close();
		} catch (Exception e) {
			e.printStackTrace();
		}	
	}
	public void XoaTheLoai(String MaTheLoai) {
		try {
			KetNoiDao kn = new KetNoiDao();
			kn.KetNoi();
			String sql="DELETE FROM TheLoai WHERE MaTheLoai = ?";
			PreparedStatement cmd=kn.cn.prepareStatement(sql);
			cmd.setString(1, MaTheLoai);
			cmd.executeUpdate();
			kn.cn.close();
			cmd.close();
		} catch (Exception e) {
			e.printStackTrace();
		}	
	}
	public ArrayList<TheLoaiBean> TimTheLoai(String Key) {
		try {
			ArrayList<TheLoaiBean> ds = new ArrayList<TheLoaiBean>();
			KetNoiDao kn = new KetNoiDao();
			kn.KetNoi();
			String sql="SELECT * FROM TheLoai WHERE TenTheLoai LIKE ?";
			PreparedStatement cmd=kn.cn.prepareStatement(sql);
			cmd.setString(1, "%" + Key + "%");
			ResultSet rs=cmd.executeQuery();
			while(rs.next()) {
				 String MaTheLoai=rs.getString("MaTheLoai");
				 String TenTheLoai=rs.getString("TenTheLoai");
				ds.add(new TheLoaiBean(MaTheLoai, TenTheLoai));
			}
			rs.close();
			kn.cn.close();
			return ds;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
}
