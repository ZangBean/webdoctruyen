package bo;

import java.util.ArrayList;

import bean.TheLoaiBean;
import dao.TheLoaiDao;


public class TheLoaiBo {
	TheLoaiDao tldao = new TheLoaiDao();
	ArrayList<TheLoaiBean> tlb;
	public ArrayList<TheLoaiBean> getTheLoai(){
		tlb =tldao.getTheLoai();
		return tlb;
	}
	public ArrayList<TheLoaiBean> TimTheLoai(String Key) {
		return tldao.TimTheLoai(Key);
	}
	public TheLoaiBean ThemTheLoai(String MaTheLoai, String TenTheLoai){
		return tldao.ThemTheLoai(MaTheLoai, TenTheLoai);
	}
	public void SuaTheLoai(String TenTheLoai, String MaTheLoai) {
		tldao.SuaTheLoai(TenTheLoai, MaTheLoai);
	}
	public void XoaTheLoai(String MaTheLoai) {
		tldao.XoaTheLoai(MaTheLoai);
	}
}
