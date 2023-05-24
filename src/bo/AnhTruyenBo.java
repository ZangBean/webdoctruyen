package bo;

import java.util.ArrayList;

import bean.AnhTruyenBean;
import dao.AnhTruyenDao;


public class AnhTruyenBo {
	AnhTruyenDao atdao= new AnhTruyenDao();
	ArrayList<AnhTruyenBean> ds;
	public ArrayList<AnhTruyenBean> getAnhTruyen(long MaChuong){
		ds =atdao.getAnhTruyen(MaChuong);
		return ds;
	}
	public void ThemAnh(String TenAnh, int MaChuong, String MaTruyen) {
		atdao.ThemAnh(TenAnh, MaChuong, MaTruyen);
	}
	public void XoaAnhTruyen(String MaTruyen) {
		atdao.XoaAnhTruyen(MaTruyen);
	}
}
