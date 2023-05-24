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

import bean.KhachHangBean;
import bean.TheLoaiBean;
import bean.TruyenBean;
import bo.BinhLuanBo;
import bo.ChuongBo;
import bo.KhachHangBo;
import bo.TheLoaiBo;
import bo.TruyenBo;

/**
 * Servlet implementation class HienThiTruyenController
 */
@WebServlet("/HienThiTruyenController")
public class HienThiTruyenController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public HienThiTruyenController() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		HttpSession session = request.getSession();
		String HoTen = (String) session.getAttribute("un");

		TheLoaiBo tlbo = new TheLoaiBo();
		TruyenBo tbo = new TruyenBo();
		BinhLuanBo blbo = new BinhLuanBo();
		KhachHangBo khbo = new KhachHangBo();
		ChuongBo cbo = new ChuongBo();

		ArrayList<TruyenBean> ds = tbo.getTruyen();
		ArrayList<TruyenBean> dsUpDown = tbo.getTruyenByUpDown();
		ArrayList<TheLoaiBean> dsTheLoai = tlbo.getTheLoai();
		//Truyen ve ds random
		ArrayList<Integer> countAllChuong = cbo.CountAllChuong();
		ArrayList<Integer> countAllCmt = blbo.CountAllBinhLuan();
		
		KhachHangBean KhachHang = khbo.SearchUserName(HoTen);

		String MaTheLoai = "";
		String TenTruyen = "";
		if (request.getParameter("MaTheLoai") != null)
			MaTheLoai = request.getParameter("MaTheLoai");
		if (request.getParameter("TenTruyen") != null)
			TenTruyen = request.getParameter("TenTruyen");
		//Kiem tra tong so truyen
		int CountTruyen = 0;
		if(MaTheLoai != null && MaTheLoai != "") {			
			CountTruyen = tbo.CountTruyenByTheLoai(MaTheLoai);
		}else {
			CountTruyen = tbo.CountTruyen(TenTruyen);
		}
		//Tinh so trang
		int numberPage = 0;
		numberPage = CountTruyen / 8;
		if (CountTruyen % 8 != 0) {
			numberPage++;
		}
		int index = 1;
		if (request.getParameter("index") != null) {
			String indexStr = request.getParameter("index");
			index = Integer.parseInt(indexStr);
		}
		
		//Phan trang
		ArrayList<Integer> countChuong = new ArrayList<Integer>();
		ArrayList<Integer> countCmt = new ArrayList<Integer>();
		
		ArrayList<TruyenBean> dsPhanTrang = new ArrayList<TruyenBean>();
		if (MaTheLoai != null && MaTheLoai != "") {
			dsPhanTrang = tbo.getPhanTrangByTheLoai(MaTheLoai, index);	
			countChuong =cbo.DemAllChuongByTheLoai(MaTheLoai, index);
			countCmt = blbo.DemAllBinhLuanByTheLoai(MaTheLoai, index);
		}else if (TenTruyen != null && TenTruyen != "") {
			dsPhanTrang = tbo.getPhanTrangByTenTruyen(TenTruyen, index);
			countChuong =cbo.DemAllChuongByTenTruyen(TenTruyen, index);
			countCmt = blbo.DemAllBinhLuanByTenTruyen(TenTruyen, index);
		}else {
			dsPhanTrang = tbo.getPhanTrang(index);
			countChuong = cbo.DemAllChuong(index);
			countCmt = blbo.DemAllBinhLuan(index);
		}

		request.setAttribute("KhachHang", KhachHang);
		request.setAttribute("countChuong", countChuong);
		request.setAttribute("countCmt", countCmt);
		request.setAttribute("countAllChuong", countAllChuong);
		request.setAttribute("countAllCmt", countAllCmt);
		request.setAttribute("MaTheLoai", MaTheLoai);
		request.setAttribute("TenTruyen", TenTruyen);
		request.setAttribute("soTrang", numberPage);
		request.setAttribute("dsUpDown", dsUpDown);
		request.setAttribute("dsPhanTrang", dsPhanTrang);
		request.setAttribute("dsTruyen", ds);
		request.setAttribute("dsTheLoai", dsTheLoai);
		RequestDispatcher rd = request.getRequestDispatcher("HienThiTruyen.jsp");
		rd.forward(request, response);
		System.out.println("Dung lai!!!!!");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
