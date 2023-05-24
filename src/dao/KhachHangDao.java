package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import bean.KhachHangBean;

public class KhachHangDao {
	public ArrayList<KhachHangBean> getKhachHang(){
		try {
			ArrayList<KhachHangBean> ds=new ArrayList<KhachHangBean>();
			KetNoiDao kn = new KetNoiDao();
			kn.KetNoi();
			String sql="select * from KhachHang";
			PreparedStatement cmd=kn.cn.prepareStatement(sql);
			ResultSet rs=cmd.executeQuery();
			while(rs.next()) {
				String HoTen= rs.getString("HoTen");
				String Email= rs.getString("Email");
				String MatKhau= rs.getString("MatKhau");
				String Avatar= rs.getString("Avatar");
				ds.add(new KhachHangBean(HoTen, Email, MatKhau, Avatar));
			}
			rs.close();
			kn.cn.close();
			return ds;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	public KhachHangBean CheckAccount(String HoTen, String MatKhau){
		try {
			KetNoiDao kn = new KetNoiDao();
			kn.KetNoi();
			String sql="select * from KhachHang where HoTen=? and MatKhau=?";
			PreparedStatement cmd=kn.cn.prepareStatement(sql);
			cmd.setString(1, HoTen);
			cmd.setString(2, MatKhau);
			ResultSet rs=cmd.executeQuery();
			if(rs.next()) {
				String Email= rs.getString("Email");
				String Avatar= rs.getString("Avatar");
				return new KhachHangBean(HoTen, Email, MatKhau, Avatar);
			}
			rs.close();
			kn.cn.close();
			return null;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	public KhachHangBean SearchUserName(String HoTen) {
		try {
			KetNoiDao kn = new KetNoiDao();
			kn.KetNoi();
			String sql = "select * from KhachHang where HoTen=?";
			PreparedStatement cmd = kn.cn.prepareStatement(sql);
			cmd.setString(1, HoTen);
			ResultSet rs = cmd.executeQuery();
			if(rs.next()) {
				String Email = rs.getString("Email");
				String MatKhau = rs.getString("MatKhau");
				String Avatar= rs.getString("Avatar");
				return new KhachHangBean(HoTen, Email, MatKhau, Avatar);
			}
			return null;
		} catch (Exception e) {
			// TODO: handle exception
			return null;
		}
	}
	public KhachHangBean SearchKhachHang(long MaKhachHang) {
		try {
			KetNoiDao kn = new KetNoiDao();
			kn.KetNoi();
			String sql = "select * from KhachHang where MaKhachHang=?";
			PreparedStatement cmd = kn.cn.prepareStatement(sql);
			cmd.setLong(1, MaKhachHang);
			ResultSet rs = cmd.executeQuery();
			if(rs.next()) {
				String HoTen = rs.getString("HoTen");
				String Email = rs.getString("Email");
				String MatKhau = rs.getString("MatKhau");
				String Avatar= rs.getString("Avatar");
				return new KhachHangBean(HoTen, Email, MatKhau, Avatar);
			}
			return null;
		} catch (Exception e) {
			// TODO: handle exception
			return null;
		}
	}
	public String getTenKH(long MaKhachHang) {
		try {
			KetNoiDao kn = new KetNoiDao();
			kn.KetNoi();
			String sql = "select HoTen from KhachHang where MaKhachHang=?";
			PreparedStatement cmd = kn.cn.prepareStatement(sql);
			cmd.setLong(1, MaKhachHang);
			ResultSet rs = cmd.executeQuery();
			if(rs.next()) {
				String HoTen = rs.getString("HoTen");
			    return HoTen;
			}
			return null;
		} catch (Exception e) {
			return null;
		}
	}
	public long searchMaKhachHang(String HoTen) {
		try {
			KetNoiDao kn = new KetNoiDao();
			kn.KetNoi();
			String sql = "select * from KhachHang where HoTen=?";
			PreparedStatement cmd = kn.cn.prepareStatement(sql);
			cmd.setString(1, HoTen);
			ResultSet rs = cmd.executeQuery();		
			if(rs.next()) 
				return rs.getLong("MaKhachHang");
			return -1;
		} catch (Exception e) {
			// TODO: handle exception
			return -1;
		}
	}
	public KhachHangBean RegisterAccount(String HoTen, String Email, String MatKhau, String Avatar){
		KhachHangBean khbean = SearchUserName(HoTen);
		if(khbean == null) {
			try {
				KetNoiDao kn = new KetNoiDao();
				kn.KetNoi();
				String sql="insert into KhachHang(HoTen, Email, MatKhau, Avatar) values(?,?,?,?)";
				PreparedStatement cmd=kn.cn.prepareStatement(sql);
				cmd.setString(1, HoTen);
				cmd.setString(2, Email);
				cmd.setString(3, MatKhau);
				cmd.setString(4, Avatar);
				cmd.executeUpdate();
				kn.cn.close();
				return new KhachHangBean(HoTen, Email, MatKhau, Avatar);
			} catch (Exception e) {
				e.printStackTrace();
				return null;
			}	
		}
		else{
			return null;
		}
	}
	public void UpdateKhachHang(long MaKhachHang, String MatKhau, String Avatar) {
		try {
			KetNoiDao kn = new KetNoiDao();
			kn.KetNoi();
			if(Avatar!=null && Avatar!="") {
				String sql="update KhachHang set MatKhau=?, Avatar=? where MakhachHang = ?";
				PreparedStatement cmd=kn.cn.prepareStatement(sql);
				cmd.setString(1, MatKhau);
				cmd.setString(2, Avatar);
				cmd.setLong(3, MaKhachHang);
				cmd.executeUpdate();
				kn.cn.close();
				cmd.close();
			}else {
				String sql="update KhachHang set MatKhau=? where MakhachHang = ?";
				PreparedStatement cmd=kn.cn.prepareStatement(sql);
				cmd.setString(1, MatKhau);
				cmd.setLong(2, MaKhachHang);
				cmd.executeUpdate();
				kn.cn.close();
				cmd.close();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}	
	}
	public void DeleteKhachHang(long MaKhachHang) {
		try {
			KetNoiDao kn = new KetNoiDao();
			kn.KetNoi();
			String sql="delete KhachHang where MaKhachHang=?";
			PreparedStatement cmd=kn.cn.prepareStatement(sql);
			cmd.setLong(1, MaKhachHang);
			cmd.executeUpdate();
			kn.cn.close();
			cmd.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
