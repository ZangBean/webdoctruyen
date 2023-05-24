package controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import bean.BinhLuanBean;
import bean.ChuongBean;
import bean.TheLoaiBean;
import bean.TruyenBean;
import bo.BinhLuanBo;
import bo.ChuongBo;
import bo.KhachHangBo;
import bo.TheLoaiBo;
import bo.TheoDoiBo;
import bo.TruyenBo;

/**
 * Servlet implementation class ChiTietTruyenController
 */
@WebServlet("/ChiTietTruyenController")
public class ChiTietTruyenController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ChiTietTruyenController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		RequestDispatcher rd;
		
		TruyenBo tbo = new TruyenBo();
		TheLoaiBo tlbo = new TheLoaiBo();
		ChuongBo cbo = new ChuongBo();
		BinhLuanBo blbo = new BinhLuanBo();
		KhachHangBo khbo = new KhachHangBo();
		TheoDoiBo tdbo = new TheoDoiBo();
		Boolean CheckTheoDoi = false;
		String MaTruyen = request.getParameter("mt");
		
		int DemSoTheoDoi = tdbo.DemSoTheoDoi(MaTruyen);
		
		TruyenBean Truyen = tbo.getChiTietTruyen(MaTruyen);
		ArrayList<ChuongBean> dsChuong = cbo.getChuong(MaTruyen);
		ArrayList<TheLoaiBean> dsTheLoai = tlbo.getTheLoai();
		
		String HoTen = (String)session.getAttribute("un");
		
		if(HoTen==null) {
			rd = request.getRequestDispatcher("KTDNController");
		}else {
			long MaKhachHang = khbo.searchMaKhachHang(HoTen);
			CheckTheoDoi = tdbo.CheckTheoDoi(MaTruyen, MaKhachHang);
		}
		
		int dembl = blbo.DemBinhLuan(MaTruyen);
		ArrayList<BinhLuanBean> dsBinhLuan = blbo.getBinhLuan(MaTruyen);

		request.setAttribute("DemSoTheoDoi", DemSoTheoDoi);
		request.setAttribute("CheckTheoDoi", CheckTheoDoi);
		request.setAttribute("KhachHang", khbo.SearchUserName(HoTen));
		request.setAttribute("dembl", dembl);
		request.setAttribute("dsBinhLuan", dsBinhLuan);
		request.setAttribute("Truyen", Truyen);
		request.setAttribute("dsChuong", dsChuong);
		request.setAttribute("dsTheLoai", dsTheLoai);
		
		rd = request.getRequestDispatcher("ChiTietTruyen.jsp");
		rd.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
