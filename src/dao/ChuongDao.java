package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Date;

import bean.ChuongBean;

public class ChuongDao {
	public ArrayList<ChuongBean> getChuong(String MaTruyen){
		ArrayList<ChuongBean> ds = new ArrayList<ChuongBean>();
		try {
			KetNoiDao kn = new KetNoiDao();
			kn.KetNoi();
			String sql="select * from Chuong where MaTruyen =? order by TenChuong";
			PreparedStatement cmd=kn.cn.prepareStatement(sql);
			cmd.setString(1, MaTruyen);
			ResultSet rs=cmd.executeQuery();
			while(rs.next()) {
				 long MaChuong=rs.getLong("MaChuong");
				 String TenChuong =rs.getString("TenChuong");
				 Date NgayThem = rs.getDate("NgayThem");
				ds.add(new ChuongBean(MaChuong, TenChuong, MaTruyen, NgayThem));
			}
			rs.close();
			kn.cn.close();
			return ds;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	public void ThemChuong(String TenChuong, String MaTruyen) {
		try {
			TruyenDao tdao = new TruyenDao();
			KetNoiDao kn = new KetNoiDao();
			kn.KetNoi();
			String sql = "insert into Chuong(TenChuong, MaTruyen, NgayThem) values (?, ?, ?)";
			PreparedStatement cmd = kn.cn.prepareStatement(sql);
			cmd.setString(1, TenChuong);
			cmd.setString(2, MaTruyen);
			cmd.setTimestamp(3, new java.sql.Timestamp(new Date().getTime()));
			cmd.executeUpdate();
			cmd.close();
			kn.cn.close();
			tdao.UpdateNgayThemChuong(MaTruyen);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}
	public int searchMaChuong(String TenChuong, String MaTruyen) {
	    try {
	        KetNoiDao kn = new KetNoiDao();
	        kn.KetNoi();
	        String sql = "SELECT MaChuong FROM Chuong WHERE TenChuong = ? AND MaTruyen = ?";
	        PreparedStatement cmd = kn.cn.prepareStatement(sql);
	        cmd.setString(1, TenChuong);
	        cmd.setString(2, MaTruyen);
	        ResultSet rs = cmd.executeQuery();    
	        if (rs.next()) {
	            return rs.getInt("MaChuong");
	        }
	    } catch (Exception e) {
	        e.printStackTrace();
	    }
	    return -1;
	}
	public void XoaChuong(long MaChuong) {
		try {
			KetNoiDao kn = new KetNoiDao();
			kn.KetNoi();
			String sql="DELETE FROM Chuong WHERE MaChuong = ?";
			PreparedStatement cmd=kn.cn.prepareStatement(sql);
			cmd.setLong(1, MaChuong);
			cmd.executeUpdate();
			kn.cn.close();
			cmd.close();
		} catch (Exception e) {
			e.printStackTrace();
		}	
	}
	public void XoaChuongTruyen(String MaTruyen) {
		try {
			KetNoiDao kn = new KetNoiDao();
			kn.KetNoi();
			String sql="DELETE FROM Chuong WHERE MaTruyen = ?";
			PreparedStatement cmd=kn.cn.prepareStatement(sql);
			cmd.setString(1, MaTruyen);
			cmd.executeUpdate();
			kn.cn.close();
			cmd.close();
		} catch (Exception e) {
			e.printStackTrace();
		}	
	}
	public ChuongBean searchTenChuong(long MaChuong) {
	    try {
	        KetNoiDao kn = new KetNoiDao();
	        kn.KetNoi();
	        String sql = "SELECT * FROM Chuong WHERE MaChuong = ?";
	        PreparedStatement cmd = kn.cn.prepareStatement(sql);
	        cmd.setLong(1, MaChuong);
	        ResultSet rs = cmd.executeQuery();    
	        if (rs.next()) {
	        	String MaTruyen = rs.getString("Matruyen");
				String TenChuong =rs.getString("TenChuong");
				Date NgayThem = rs.getDate("NgayThem");
				return new ChuongBean(MaChuong, TenChuong, MaTruyen, NgayThem);
	        }
	    } catch (Exception e) {
	        e.printStackTrace();
	    }
	    return null;
	}
	public int DemSoChuong(String MaTruyen) {
	    try {
	        KetNoiDao kn = new KetNoiDao();
	        kn.KetNoi();
	        String sql = "SELECT COUNT(*) as SoChuong FROM Chuong where MaTruyen=?";
	        PreparedStatement cmd = kn.cn.prepareStatement(sql);
	        cmd.setString(1, MaTruyen);
	        ResultSet rs = cmd.executeQuery();    
	        if (rs.next()) {
	            return rs.getInt("SoChuong");
	        }
	    } catch (Exception e) {
	        e.printStackTrace();
	    }
	    return -1;
	}
	public ArrayList<Integer> CountAllChuong() {
	    try {
	        KetNoiDao kn = new KetNoiDao();
	        kn.KetNoi();
	        String sql = "SELECT Truyen.MaTruyen, COUNT(Chuong.MaChuong) AS SoLuongChuong, Truyen.NgayThem\r\n"
	        		+ "	        		FROM Truyen\r\n"
	        		+ "	        		LEFT JOIN Chuong ON Truyen.MaTruyen = Chuong.MaTruyen \r\n"
	        		+ "	        		GROUP BY Truyen.MaTruyen, Truyen.NgayThem \r\n"
	        		+ "	        		ORDER BY Truyen.NgayThem";
	        PreparedStatement cmd = kn.cn.prepareStatement(sql);
	        ResultSet rs = cmd.executeQuery();
	        ArrayList<Integer> result = new ArrayList<>();
	        while (rs.next()) {
	            Integer SoLuongChuong = rs.getInt("SoLuongChuong");
	            if (rs.wasNull()) {
	            	SoLuongChuong = 0;
	            }
	            result.add(SoLuongChuong);
	        }
	        rs.close();
	        return result;
	    } catch (Exception e) {
	        return null;
	    }
	}
	public ArrayList<Integer> DemAllChuong(int index) {
	    try {
	        KetNoiDao kn = new KetNoiDao();
	        kn.KetNoi();
	        String sql = "SELECT Truyen.MaTruyen, COUNT(Chuong.MaChuong) AS SoLuongChuong, Truyen.NgayThemChuong \r\n"
	        		+ "FROM Truyen \r\n"
	        		+ "LEFT JOIN Chuong ON Truyen.MaTruyen = Chuong.MaTruyen \r\n"
	        		+ "GROUP BY Truyen.MaTruyen, Truyen.NgayThemChuong \r\n"
	        		+ "ORDER BY Truyen.NgayThemChuong DESC OFFSET ? ROWS FETCH FIRST 8 ROWS ONLY";
	        PreparedStatement cmd = kn.cn.prepareStatement(sql);
	        cmd.setInt(1, (index-1)*8);
	        ResultSet rs = cmd.executeQuery();

	        ArrayList<Integer> result = new ArrayList<>();
	        while (rs.next()) {
	            Integer SoLuongChuong = rs.getInt("SoLuongChuong");
	            if (rs.wasNull()) {
	            	SoLuongChuong = 0;
	            }
	            result.add(SoLuongChuong);
	        }
	        rs.close();
	        return result;
	    } catch (Exception e) {
	        return null;
	    }
	}
	public ArrayList<Integer> DemAllChuongByTenTruyen(String TenTruyen,int index) {
	    try {
	        KetNoiDao kn = new KetNoiDao();
	        kn.KetNoi();
	        String sql = "SELECT Truyen.MaTruyen, COUNT(Chuong.MaChuong) AS SoLuongChuong, Truyen.NgayThemChuong \r\n"
	        		+ "FROM Truyen \r\n"
	        		+ "LEFT JOIN Chuong ON Truyen.MaTruyen = Chuong.MaTruyen WHERE Truyen.TenTruyen LIKE ? \r\n"
	        		+ "GROUP BY Truyen.MaTruyen, Truyen.NgayThemChuong \r\n"
	        		+ "ORDER BY Truyen.NgayThemChuong DESC OFFSET ? ROWS FETCH FIRST 8 ROWS ONLY";
	        PreparedStatement cmd = kn.cn.prepareStatement(sql);
	        cmd.setString(1, "%" + TenTruyen + "%");
	        cmd.setInt(2, (index-1)*8);
	        ResultSet rs = cmd.executeQuery();

	        ArrayList<Integer> result = new ArrayList<>();
	        while (rs.next()) {
	            Integer SoLuongChuong = rs.getInt("SoLuongChuong");
	            if (rs.wasNull()) {
	            	SoLuongChuong = 0;
	            }
	            result.add(SoLuongChuong);
	        }
	        rs.close();
	        return result;
	    } catch (Exception e) {
	        return null;
	    }
	}
	public ArrayList<Integer> DemAllChuongByTheLoai(String MaTheLoai,int index) {
	    try {
	        KetNoiDao kn = new KetNoiDao();
	        kn.KetNoi();
	        String sql = "SELECT Truyen.MaTruyen, COUNT(Chuong.MaChuong) AS SoLuongChuong, Truyen.NgayThemChuong \r\n"
	        		+ "FROM Truyen \r\n"
	        		+ "LEFT JOIN Chuong ON Truyen.MaTruyen = Chuong.MaTruyen WHERE Truyen.MaTheLoai =? \r\n"
	        		+ "GROUP BY Truyen.MaTruyen, Truyen.NgayThemChuong \r\n"
	        		+ "ORDER BY Truyen.NgayThemChuong DESC OFFSET ? ROWS FETCH FIRST 8 ROWS ONLY";
	        PreparedStatement cmd = kn.cn.prepareStatement(sql);
	        cmd.setString(1, MaTheLoai);
	        cmd.setInt(2, (index-1)*8);
	        ResultSet rs = cmd.executeQuery();

	        ArrayList<Integer> result = new ArrayList<>();
	        while (rs.next()) {
	            Integer SoLuongChuong = rs.getInt("SoLuongChuong");
	            if (rs.wasNull()) {
	            	SoLuongChuong = 0;
	            }
	            result.add(SoLuongChuong);
	        }
	        rs.close();
	        return result;
	    } catch (Exception e) {
	        return null;
	    }
	}
}
