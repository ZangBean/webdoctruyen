package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Date;

import bean.TruyenBean;

public class TruyenDao {
	public ArrayList<TruyenBean> ds= new ArrayList<TruyenBean>();
	public ArrayList<TruyenBean> getTruyen(){
		try {
			ArrayList<TruyenBean> ds = new ArrayList<TruyenBean>();
			KetNoiDao kn = new KetNoiDao();
			kn.KetNoi();
			String sql="select * from truyen order by NgayThem";
			PreparedStatement cmd=kn.cn.prepareStatement(sql);
			ResultSet rs=cmd.executeQuery();
			while(rs.next()) {
				 String MaTruyen=rs.getString("MaTruyen");
				 String TenTruyen=rs.getString("TenTruyen");
				 String TacGia =rs.getString("TacGia");
				 String GioiThieu =rs.getString("GioiThieu");
				 String AnhTruyen=rs.getString("AnhTruyen");
				 long LuotXem=rs.getLong("LuotXem");
				 boolean HoanThanh=rs.getBoolean("HoanThanh");
				 String MaTheLoai = rs.getString("MaTheLoai");
				 String AnhNen = rs.getString("AnhNen");
				 Date NgayThem = rs.getTimestamp("NgayThem");
				 Date NgayThemChuong = rs.getTimestamp("NgayThemChuong");
				ds.add(new TruyenBean(MaTruyen, TenTruyen, TacGia, GioiThieu, AnhTruyen, LuotXem, HoanThanh, MaTheLoai, AnhNen, NgayThem, NgayThemChuong));
			}
			rs.close();
			kn.cn.close();
			return ds;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	public ArrayList<TruyenBean> getPhanTrang(int index) {
		try {
			ArrayList<TruyenBean> ds = new ArrayList<TruyenBean>();
			KetNoiDao kn = new KetNoiDao();
			kn.KetNoi();
			String sql="select * from truyen order by NgayThemChuong desc offset ? row fetch first 8 row only";
			PreparedStatement cmd=kn.cn.prepareStatement(sql);
			cmd.setInt(1, (index-1)*8);
			ResultSet rs=cmd.executeQuery();
			while(rs.next()) {
				 String MaTruyen=rs.getString("MaTruyen");
				 String TenTruyen=rs.getString("TenTruyen");
				 String TacGia =rs.getString("TacGia");
				 String GioiThieu =rs.getString("GioiThieu");
				 String AnhTruyen=rs.getString("AnhTruyen");
				 long LuotXem=rs.getLong("LuotXem");
				 boolean HoanThanh=rs.getBoolean("HoanThanh");
				 String MaTheLoai = rs.getString("MaTheLoai");
				 String AnhNen = rs.getString("AnhNen");
				 Date NgayThem = rs.getTimestamp("NgayThem");
				 Date NgayThemChuong = rs.getTimestamp("NgayThemChuong");
				ds.add(new TruyenBean(MaTruyen, TenTruyen, TacGia, GioiThieu, AnhTruyen, LuotXem, HoanThanh, MaTheLoai, AnhNen, NgayThem, NgayThemChuong));
			}
			rs.close();
			kn.cn.close();
			return ds;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	public ArrayList<TruyenBean> getPhanTrangByTenTruyen(String Key,int index) {
		try {
			ArrayList<TruyenBean> ds = new ArrayList<TruyenBean>();
			KetNoiDao kn = new KetNoiDao();
			kn.KetNoi();
			String sql="SELECT * FROM truyen WHERE TenTruyen LIKE ? ORDER BY NgayThemChuong DESC OFFSET ? ROWS FETCH FIRST 8 ROWS ONLY";
			PreparedStatement cmd=kn.cn.prepareStatement(sql);
			cmd.setString(1, "%" + Key + "%");
			cmd.setInt(2, (index-1)*8);
			ResultSet rs=cmd.executeQuery();
			while(rs.next()) {
				 String MaTruyen=rs.getString("MaTruyen");
				 String TenTruyen=rs.getString("TenTruyen");
				 String TacGia =rs.getString("TacGia");
				 String GioiThieu =rs.getString("GioiThieu");
				 String AnhTruyen=rs.getString("AnhTruyen");
				 long LuotXem=rs.getLong("LuotXem");
				 boolean HoanThanh=rs.getBoolean("HoanThanh");
				 String MaTheLoai = rs.getString("MaTheLoai");
				 String AnhNen = rs.getString("AnhNen");
				 Date NgayThem = rs.getTimestamp("NgayThem");
				 Date NgayThemChuong = rs.getTimestamp("NgayThemChuong");
				ds.add(new TruyenBean(MaTruyen, TenTruyen, TacGia, GioiThieu, AnhTruyen, LuotXem, HoanThanh, MaTheLoai, AnhNen, NgayThem, NgayThemChuong));
			}
			rs.close();
			kn.cn.close();
			return ds;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	public ArrayList<TruyenBean> getPhanTrangByTheLoai(String MaTheLoai,int index) {
		try {
			ArrayList<TruyenBean> ds = new ArrayList<TruyenBean>();
			KetNoiDao kn = new KetNoiDao();
			kn.KetNoi();
			String sql="SELECT * FROM truyen WHERE MaTheLoai = ? ORDER BY NgayThemChuong DESC OFFSET ? ROWS FETCH FIRST 8 ROWS ONLY";
			PreparedStatement cmd=kn.cn.prepareStatement(sql);
			cmd.setString(1, MaTheLoai);
			cmd.setInt(2, (index-1)*8);
			ResultSet rs=cmd.executeQuery();
			while(rs.next()) {
				 String MaTruyen=rs.getString("MaTruyen");
				 String TenTruyen=rs.getString("TenTruyen");
				 String TacGia =rs.getString("TacGia");
				 String GioiThieu =rs.getString("GioiThieu");
				 String AnhTruyen=rs.getString("AnhTruyen");
				 long LuotXem=rs.getLong("LuotXem");
				 boolean HoanThanh=rs.getBoolean("HoanThanh");
				 String AnhNen = rs.getString("AnhNen");
				 Date NgayThem = rs.getTimestamp("NgayThem");
				 Date NgayThemChuong = rs.getTimestamp("NgayThemChuong");
				ds.add(new TruyenBean(MaTruyen, TenTruyen, TacGia, GioiThieu, AnhTruyen, LuotXem, HoanThanh, MaTheLoai, AnhNen, NgayThem, NgayThemChuong));
			}
			rs.close();
			kn.cn.close();
			return ds;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	public int CountTruyen(String TenTruyen) {
		try {
			KetNoiDao kn = new KetNoiDao();
			kn.KetNoi();
			String sql = "select count(*) from Truyen where TenTruyen like ?";
			PreparedStatement cmd = kn.cn.prepareStatement(sql);
			cmd.setString(1,"%" + TenTruyen + "%" );
			ResultSet rs = cmd.executeQuery();
			while(rs.next()) {
				return rs.getInt(1);
			}	
		} catch (Exception e) {
			e.printStackTrace();
		}
		return 0;
	}
	public int CountTruyenByTheLoai(String MaTheLoai) {
		try {
			KetNoiDao kn = new KetNoiDao();
			kn.KetNoi();
			String sql = "select count(*) from Truyen where MaTheLoai =?";
			PreparedStatement cmd = kn.cn.prepareStatement(sql);
			cmd.setString(1,MaTheLoai );
			ResultSet rs = cmd.executeQuery();
			while(rs.next()) {
				return rs.getInt(1);
			}	
		} catch (Exception e) {
			e.printStackTrace();
		}
		return 0;
	}
	public ArrayList<TruyenBean> getTruyenByUpDown(){
		try {
			ArrayList<TruyenBean> ds = new ArrayList<TruyenBean>();
			KetNoiDao kn = new KetNoiDao();
			kn.KetNoi();
			String sql="select * from Truyen order by LuotXem DESC";
			PreparedStatement cmd=kn.cn.prepareStatement(sql);
			ResultSet rs=cmd.executeQuery();
			while(rs.next()) {
				 String MaTruyen=rs.getString("MaTruyen");
				 String TenTruyen=rs.getString("TenTruyen");
				 String TacGia =rs.getString("TacGia");
				 String GioiThieu =rs.getString("GioiThieu");
				 String AnhTruyen=rs.getString("AnhTruyen");
				 long LuotXem=rs.getLong("LuotXem");
				 boolean HoanThanh=rs.getBoolean("HoanThanh");
				 String MaTheLoai = rs.getString("MaTheLoai");
				 String AnhNen = rs.getString("AnhNen");
				 Date NgayThem = rs.getTimestamp("NgayThem");
				 Date NgayThemChuong = rs.getTimestamp("NgayThemChuong");
				ds.add(new TruyenBean(MaTruyen, TenTruyen, TacGia, GioiThieu, AnhTruyen, LuotXem, HoanThanh, MaTheLoai, AnhNen, NgayThem, NgayThemChuong));
			}
			rs.close();
			kn.cn.close();
			return ds;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	public TruyenBean getChiTietTruyen(String MaTruyen){
		try {
			KetNoiDao kn = new KetNoiDao();
			kn.KetNoi();
			String sql="select * from Truyen where MaTruyen = ?";
			PreparedStatement cmd=kn.cn.prepareStatement(sql);
			cmd.setString(1, MaTruyen);
			ResultSet rs=cmd.executeQuery();
			while(rs.next()) {
				 String TenTruyen=rs.getString("TenTruyen");
				 String TacGia =rs.getString("TacGia");
				 String GioiThieu =rs.getString("GioiThieu");
				 String AnhTruyen=rs.getString("AnhTruyen");
				 long LuotXem=rs.getLong("LuotXem");
				 boolean HoanThanh=rs.getBoolean("HoanThanh");
				 String MaTheLoai = rs.getString("MaTheLoai");
				 String AnhNen = rs.getString("AnhNen");
				 Date NgayThem = rs.getTimestamp("NgayThem");
				 Date NgayThemChuong = rs.getTimestamp("NgayThemChuong");
				 return new TruyenBean(MaTruyen, TenTruyen, TacGia, GioiThieu, AnhTruyen, LuotXem, HoanThanh, MaTheLoai, AnhNen, NgayThem, NgayThemChuong);
			}
			rs.close();
			kn.cn.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	public void TangLuotXem(String MaTruyen){
		try {
			KetNoiDao kn = new KetNoiDao();
			kn.KetNoi();
			String sql="UPDATE Truyen SET LuotXem = LuotXem + 1 WHERE MaTruyen = ?";
			PreparedStatement cmd=kn.cn.prepareStatement(sql);
			cmd.setString(1, MaTruyen);
			cmd.executeUpdate();
			kn.cn.close();
			cmd.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	public String TimTenTruyen(String MaTruyen) {
		try {
			KetNoiDao kn = new KetNoiDao();
			kn.KetNoi();
			String sql = "select TenTruyen from Truyen where MaTruyen=?";
			PreparedStatement cmd = kn.cn.prepareStatement(sql);
			cmd.setString(1, MaTruyen);
			ResultSet rs = cmd.executeQuery();
			if(rs.next()) {
				String TenTruyen = rs.getString("TenTruyen");
			    return TenTruyen;
			}
			return null;
		} catch (Exception e) {
			return null;
		}
	}
	public String TimTenChuong(long MaChuong) {
		try {
			KetNoiDao kn = new KetNoiDao();
			kn.KetNoi();
			String sql = "select TenChuong from Chuong where MaChuong=?";
			PreparedStatement cmd = kn.cn.prepareStatement(sql);
			cmd.setLong(1, MaChuong);
			ResultSet rs = cmd.executeQuery();
			if(rs.next()) {
				String TenChuong = rs.getString("TenChuong");
			    return TenChuong;
			}
			return null;
		} catch (Exception e) {
			return null;
		}
	}
	public void SuaTruyen(String TenTruyen, String TacGia, String GioiThieu, String MaTheLoai, String MaTruyen) {
		try {
			KetNoiDao kn = new KetNoiDao();
			kn.KetNoi();
				String sql="update Truyen set TenTruyen =?, TacGia=?, GioiThieu=?, MaTheLoai=?, NgayThem=? where MaTruyen = ?";
				PreparedStatement cmd=kn.cn.prepareStatement(sql);
				cmd.setString(1, TenTruyen);
				cmd.setString(2, TacGia);
				cmd.setString(3, GioiThieu);
				cmd.setString(4, MaTheLoai);
				cmd.setTimestamp(5, new java.sql.Timestamp(new Date().getTime()));
				cmd.setString(6, MaTruyen);
				cmd.executeUpdate();
				kn.cn.close();
				cmd.close();
		} catch (Exception e) {
			e.printStackTrace();
		}	
	}
	public void SuaAnh(String AnhNen, String AnhTruyen, String MaTruyen) {
		try {
			KetNoiDao kn = new KetNoiDao();
			kn.KetNoi();
			if((AnhNen == null || AnhNen.isEmpty()) && (AnhTruyen == null || AnhTruyen.isEmpty())) {
				kn.cn.close();
				return;
			}
			if(AnhNen == null || AnhNen.isEmpty()) {
				String sql="update Truyen set AnhTruyen = ? where MaTruyen = ?";
				PreparedStatement cmd=kn.cn.prepareStatement(sql);
				cmd.setString(1, AnhTruyen);
				cmd.setString(2, MaTruyen);
				cmd.executeUpdate();
				kn.cn.close();
				cmd.close();
			}
			else if(AnhTruyen == null || AnhTruyen.isEmpty()) {
				String sql="update Truyen set AnhNen = ? where MaTruyen = ?";
				PreparedStatement cmd=kn.cn.prepareStatement(sql);
				cmd.setString(1, AnhNen);
				cmd.setString(2, MaTruyen);
				cmd.executeUpdate();
				kn.cn.close();
				cmd.close();
			}
			else {
				String sql="update Truyen set AnhTruyen = ?, AnhNen = ? where MaTruyen = ?";
				PreparedStatement cmd=kn.cn.prepareStatement(sql);
				cmd.setString(1, AnhTruyen);
				cmd.setString(2, AnhNen);
				cmd.setString(3, MaTruyen);
				cmd.executeUpdate();
				kn.cn.close();
				cmd.close();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	public void UpdateNgayThemChuong(String MaTruyen) {
		try {
			KetNoiDao kn = new KetNoiDao();
			kn.KetNoi();
			String sql="update Truyen set NgayThemChuong = ? where MaTruyen = ?";
			PreparedStatement cmd=kn.cn.prepareStatement(sql);
			cmd.setTimestamp(1, new java.sql.Timestamp(new Date().getTime()));
			cmd.setString(2, MaTruyen);
			cmd.executeUpdate();
			kn.cn.close();
			cmd.close();
		} catch (Exception e) {
			e.printStackTrace();
		}	
	}
	public void TruyenDone(String MaTruyen) {
		try {
			KetNoiDao kn = new KetNoiDao();
			kn.KetNoi();
			String sql="update Truyen set HoanThanh = 1 where MaTruyen = ?";
			PreparedStatement cmd=kn.cn.prepareStatement(sql);
			cmd.setString(1, MaTruyen);
			cmd.executeUpdate();
			kn.cn.close();
			cmd.close();
		} catch (Exception e) {
			e.printStackTrace();
		}	
	}
	public void TruyenUpdate(String MaTruyen) {
		try {
			KetNoiDao kn = new KetNoiDao();
			kn.KetNoi();
			String sql="update Truyen set HoanThanh = 0 where MaTruyen = ?";
			PreparedStatement cmd=kn.cn.prepareStatement(sql);
			cmd.setString(1, MaTruyen);
			cmd.executeUpdate();
			kn.cn.close();
			cmd.close();
		} catch (Exception e) {
			e.printStackTrace();
		}	
	}
	public int ThemTruyen(String MaTruyen, String TenTruyen, String TacGia, String GioiThieu, String AnhTruyen,
			long LuotXem, boolean HoanThanh, String MaTheLoai, String AnhNen) {
		try {
			KetNoiDao kn = new KetNoiDao();
			kn.KetNoi();
			String sql="insert into Truyen(MaTruyen, TenTruyen, TacGia, GioiThieu, AnhTruyen, LuotXem, HoanThanh, MaTheLoai, AnhNen, NgayThem) values(?,?,?,?,?,?,?,?,?,?)";
			PreparedStatement cmd=kn.cn.prepareStatement(sql);
			cmd.setString(1, MaTruyen);
			cmd.setString(2, TenTruyen);
			cmd.setString(3, TacGia);
			cmd.setString(4, GioiThieu);
			cmd.setString(5, AnhTruyen);
			cmd.setLong(6, LuotXem);
			cmd.setBoolean(7, HoanThanh);
			cmd.setString(8, MaTheLoai);
			cmd.setString(9, AnhNen);
			cmd.setTimestamp(10, new java.sql.Timestamp(new Date().getTime()));
			return cmd.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
			return -1;
		}
	}
	public void XoaTruyen(String MaTruyen) {
		try {
			KetNoiDao kn = new KetNoiDao();
			kn.KetNoi();
			String sql="DELETE FROM Truyen WHERE MaTruyen = ?";
			PreparedStatement cmd=kn.cn.prepareStatement(sql);
			cmd.setString(1, MaTruyen);
			cmd.executeUpdate();
			kn.cn.close();
			cmd.close();
		} catch (Exception e) {
			e.printStackTrace();
		}	
	}
	public ArrayList<TruyenBean> TimTruyen(String Key) {
		try {
			ArrayList<TruyenBean> ds = new ArrayList<TruyenBean>();
			KetNoiDao kn = new KetNoiDao();
			kn.KetNoi();
			String sql="SELECT * FROM Truyen WHERE TenTruyen LIKE ?";
			PreparedStatement cmd=kn.cn.prepareStatement(sql);
			cmd.setString(1, "%" + Key + "%");
			ResultSet rs=cmd.executeQuery();
			while(rs.next()) {
				 String MaTruyen=rs.getString("MaTruyen");
				 String TenTruyen=rs.getString("TenTruyen");
				 String TacGia =rs.getString("TacGia");
				 String GioiThieu =rs.getString("GioiThieu");
				 String AnhTruyen=rs.getString("AnhTruyen");
				 long LuotXem=rs.getLong("LuotXem");
				 boolean HoanThanh=rs.getBoolean("HoanThanh");
				 String MaTheLoai = rs.getString("MaTheLoai");
				 String AnhNen = rs.getString("AnhNen");
				 Date NgayThem = rs.getTimestamp("NgayThem");
				ds.add(new TruyenBean(MaTruyen, TenTruyen, TacGia, GioiThieu, AnhTruyen, LuotXem, HoanThanh, MaTheLoai, AnhNen, NgayThem, NgayThem));
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
