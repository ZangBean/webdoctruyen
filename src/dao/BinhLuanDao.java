package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Date;

import bean.BinhLuanBean;
import bean.KhachHangBean;
import bean.TruyenBean;

public class BinhLuanDao {
	public ArrayList<BinhLuanBean> getBinhLuan(String MaTruyen){
		try {
			ArrayList<BinhLuanBean> ds =new ArrayList<BinhLuanBean>();
			KhachHangDao khdao = new KhachHangDao();
			TruyenDao tdao = new TruyenDao();
			KetNoiDao kn = new KetNoiDao();
			kn.KetNoi();
			String sql="select * from BinhLuan where MaTruyen = ?";
			PreparedStatement cmd=kn.cn.prepareStatement(sql);
			cmd.setString(1, MaTruyen);
			ResultSet rs=cmd.executeQuery();
			while(rs.next()) {
				long MaBinhLuan = rs.getLong("MaBinhLuan");
				long MaKhachHang = rs.getLong("MaKhachHang");
				String BinhLuan = rs.getString("BinhLuan");
				Date ThoiGian = rs.getTimestamp("ThoiGian");
				boolean BaoCao = rs.getBoolean("BaoCao");
				TruyenBean Truyen = tdao.getChiTietTruyen(MaTruyen);
				KhachHangBean KhachHang = khdao.SearchKhachHang(MaKhachHang);
				ds.add(new BinhLuanBean(MaBinhLuan, MaKhachHang, BinhLuan, ThoiGian, MaTruyen, BaoCao, Truyen, KhachHang));
			}
			rs.close();
			kn.cn.close();
			return ds;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	public ArrayList<BinhLuanBean> getBinhLuanByBaoCao(){
		try {
			ArrayList<BinhLuanBean> ds =new ArrayList<BinhLuanBean>();
			KhachHangDao khdao = new KhachHangDao();
			TruyenDao tdao = new TruyenDao();
			KetNoiDao kn = new KetNoiDao();
			kn.KetNoi();
			String sql="select * from BinhLuan where BaoCao = 1 order by MaKhachHang";
			PreparedStatement cmd=kn.cn.prepareStatement(sql);
			ResultSet rs=cmd.executeQuery();
			while(rs.next()) {
				long MaBinhLuan = rs.getLong("MaBinhLuan");
				String MaTruyen = rs.getString("MaTruyen");
				String BinhLuan = rs.getString("BinhLuan");
				Date ThoiGian = rs.getTimestamp("ThoiGian");
				long MaKhachHang = rs.getLong("MaKhachHang");
				boolean BaoCao = rs.getBoolean("BaoCao");
				TruyenBean Truyen = tdao.getChiTietTruyen(MaTruyen);
				KhachHangBean KhachHang = khdao.SearchKhachHang(MaKhachHang);
				ds.add(new BinhLuanBean(MaBinhLuan, MaKhachHang, BinhLuan, ThoiGian, MaTruyen, BaoCao, Truyen, KhachHang));
			}
			rs.close();
			kn.cn.close();
			return ds;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	public int ThemBinhLuan(long MaKhachHang, String BinhLuan, String MaTruyen){
		try {
			KetNoiDao kn = new KetNoiDao();
			kn.KetNoi();
			String sql="insert into BinhLuan(MaKhachHang, BinhLuan, ThoiGian, MaTruyen, BaoCao) values(?,?,?,?,?)";
			PreparedStatement cmd=kn.cn.prepareStatement(sql);
			cmd.setLong(1, MaKhachHang);
			cmd.setString(2, BinhLuan);
			cmd.setTimestamp(3, new java.sql.Timestamp(new Date().getTime()));
			cmd.setString(4, MaTruyen);
			cmd.setBoolean(5, false);
			return cmd.executeUpdate();
		} catch (Exception e) {
			return -1;
		}
	}
	public int DemBinhLuan(String MaTruyen) {
		try {
			KetNoiDao kn = new KetNoiDao();
			kn.KetNoi();
			String sql="select count(BinhLuan) from BinhLuan where MaTruyen = ?";
			PreparedStatement cmd=kn.cn.prepareStatement(sql);
			cmd.setString(1, MaTruyen);
			ResultSet rs = cmd.executeQuery();
			if(rs.next()) {
				int count = rs.getInt(1);
				rs.close();
				return count;
			}
			rs.close();
			return 0;
		} catch (Exception e) {
			return -1;
		}
	}
	public ArrayList<Integer> CountAllBinhLuan() {
	    try {
	        KetNoiDao kn = new KetNoiDao();
	        kn.KetNoi();
	        String sql = "SELECT Truyen.MaTruyen, COUNT(BinhLuan) as SoLuongBinhLuan, Truyen.NgayThem \r\n"
	        		+ "FROM Truyen \r\n"
	        		+ "LEFT JOIN BinhLuan ON Truyen.MaTruyen = BinhLuan.MaTruyen \r\n"
	        		+ "GROUP BY Truyen.MaTruyen, Truyen.NgayThem \r\n"
	        		+ "ORDER BY Truyen.NgayThem";
	        PreparedStatement cmd = kn.cn.prepareStatement(sql);
	        ResultSet rs = cmd.executeQuery();
	        ArrayList<Integer> result = new ArrayList<>();
	        while (rs.next()) {
	            Integer soLuongBinhLuan = rs.getInt("SoLuongBinhLuan");
	            if (rs.wasNull()) {
	                soLuongBinhLuan = 0;
	            }
	            result.add(soLuongBinhLuan);
	        }
	        rs.close();
	        return result;
	    } catch (Exception e) {
	        return null;
	    }
	}
	public ArrayList<Integer> DemAllBinhLuan(int index) {
	    try {
	        KetNoiDao kn = new KetNoiDao();
	        kn.KetNoi();
	        String sql = "SELECT Truyen.MaTruyen, COUNT(BinhLuan) as SoLuongBinhLuan, Truyen.NgayThemChuong \r\n"
	        		+ "FROM Truyen \r\n"
	        		+ "LEFT JOIN BinhLuan ON Truyen.MaTruyen = BinhLuan.MaTruyen \r\n"
	        		+ "GROUP BY Truyen.MaTruyen, Truyen.NgayThemChuong \r\n"
	        		+ "ORDER BY Truyen.NgayThemChuong DESC OFFSET ? ROWS FETCH FIRST 8 ROWS ONLY";
	        PreparedStatement cmd = kn.cn.prepareStatement(sql);
	        cmd.setInt(1, (index-1)*8);
	        ResultSet rs = cmd.executeQuery();

	        ArrayList<Integer> result = new ArrayList<>();
	        while (rs.next()) {
	            Integer soLuongBinhLuan = rs.getInt("SoLuongBinhLuan");
	            if (rs.wasNull()) {
	                soLuongBinhLuan = 0;
	            }
	            result.add(soLuongBinhLuan);
	        }
	        rs.close();
	        return result;
	    } catch (Exception e) {
	        return null;
	    }
	}
	public ArrayList<Integer> DemAllBinhLuanByTenTruyen(String TenTruyen,int index) {
	    try {
	        KetNoiDao kn = new KetNoiDao();
	        kn.KetNoi();
	        String sql = "SELECT Truyen.MaTruyen, COUNT(BinhLuan) as SoLuongBinhLuan, Truyen.NgayThemChuong \r\n"
	        		+ "FROM Truyen \r\n"
	        		+ "LEFT JOIN BinhLuan ON Truyen.MaTruyen = BinhLuan.MaTruyen WHERE Truyen.TenTruyen LIKE ? \r\n"
	        		+ "GROUP BY Truyen.MaTruyen, Truyen.NgayThemChuong \r\n"
	        		+ "ORDER BY Truyen.NgayThemChuong DESC OFFSET ? ROWS FETCH FIRST 8 ROWS ONLY";
	        PreparedStatement cmd = kn.cn.prepareStatement(sql);
	        cmd.setString(1, "%" + TenTruyen + "%");
	        cmd.setInt(2, (index-1)*8);
	        ResultSet rs = cmd.executeQuery();

	        ArrayList<Integer> result = new ArrayList<>();
	        while (rs.next()) {
	            Integer soLuongBinhLuan = rs.getInt("SoLuongBinhLuan");
	            if (rs.wasNull()) {
	                soLuongBinhLuan = 0;
	            }
	            result.add(soLuongBinhLuan);
	        }
	        rs.close();
	        return result;
	    } catch (Exception e) {
	        return null;
	    }
	}
	public ArrayList<Integer> DemAllBinhLuanByTheLoai(String MaTheLoai,int index) {
	    try {
	        KetNoiDao kn = new KetNoiDao();
	        kn.KetNoi();
	        String sql = "SELECT Truyen.MaTruyen, COUNT(BinhLuan) as SoLuongBinhLuan, Truyen.NgayThemChuong \r\n"
	        		+ "FROM Truyen \r\n"
	        		+ "LEFT JOIN BinhLuan ON Truyen.MaTruyen = BinhLuan.MaTruyen WHERE Truyen.MaTheLoai = ? \r\n"
	        		+ "GROUP BY Truyen.MaTruyen, Truyen.NgayThemChuong \r\n"
	        		+ "ORDER BY Truyen.NgayThemChuong DESC OFFSET ? ROWS FETCH FIRST 8 ROWS ONLY";
	        PreparedStatement cmd = kn.cn.prepareStatement(sql);
	        cmd.setString(1, MaTheLoai);
	        cmd.setInt(2, (index-1)*8);
	        ResultSet rs = cmd.executeQuery();

	        ArrayList<Integer> result = new ArrayList<>();
	        while (rs.next()) {
	            Integer soLuongBinhLuan = rs.getInt("SoLuongBinhLuan");
	            if (rs.wasNull()) {
	                soLuongBinhLuan = 0;
	            }
	            result.add(soLuongBinhLuan);
	        }
	        rs.close();
	        return result;
	    } catch (Exception e) {
	        return null;
	    }
	}
	public void XoaBinhLuan(long MaBinhLuan) {
		try {
			KetNoiDao kn = new KetNoiDao();
			kn.KetNoi();
			String sql="Delete BinhLuan Where MaBinhLuan=?";
			PreparedStatement cmd=kn.cn.prepareStatement(sql);
			cmd.setLong(1, MaBinhLuan);
			cmd.executeUpdate();
			kn.cn.close();
			cmd.close();
		} catch (Exception e) {
			e.printStackTrace();
		}	
	}
	public void BaoCaoBinhLuan(long MaBinhLuan) {
		try {
			KetNoiDao kn = new KetNoiDao();
			kn.KetNoi();
			String sql="update binhluan set BaoCao = 1 where MaBinhLuan=?";
			PreparedStatement cmd=kn.cn.prepareStatement(sql);
			cmd.setLong(1, MaBinhLuan);
			cmd.executeUpdate();
			kn.cn.close();
			cmd.close();
		} catch (Exception e) {
			e.printStackTrace();
		}	
	}
	public void BaoCaoSkip(long MaBinhLuan) {
		try {
			KetNoiDao kn = new KetNoiDao();
			kn.KetNoi();
			String sql="update binhluan set BaoCao = 0 where MaBinhLuan=?";
			PreparedStatement cmd=kn.cn.prepareStatement(sql);
			cmd.setLong(1, MaBinhLuan);
			cmd.executeUpdate();
			kn.cn.close();
			cmd.close();
		} catch (Exception e) {
			e.printStackTrace();
		}	
	}
}