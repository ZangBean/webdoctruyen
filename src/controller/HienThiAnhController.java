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

import bean.AnhTruyenBean;
import bean.ChuongBean;
import bean.TruyenBean;
import bo.AnhTruyenBo;
import bo.ChuongBo;
import bo.KhachHangBo;
import bo.LichSuBo;
import bo.TheLoaiBo;
import bo.TruyenBo;

/**
 * Servlet implementation class HienThiAnhController
 */
@WebServlet("/HienThiAnhController")
public class HienThiAnhController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public HienThiAnhController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		TheLoaiBo tlbo = new TheLoaiBo();
		TruyenBo tbo = new TruyenBo();
		ChuongBo cbo = new ChuongBo();
		LichSuBo lsbo = new LichSuBo();
		AnhTruyenBo atbo = new AnhTruyenBo();
		KhachHangBo khbo= new KhachHangBo();
		String MaTruyen = request.getParameter("mt");
		
		TruyenBean Truyen = tbo.getChiTietTruyen(MaTruyen);
		ArrayList<ChuongBean> ls = cbo.getChuong(MaTruyen);
		
		String MaChuongStr = request.getParameter("mc");
		long MaChuong = Long.parseLong(MaChuongStr);
		System.out.println("Machuong:"+MaChuong);
		String HoTen = (String)session.getAttribute("un");
		long MaKhachHang = khbo.searchMaKhachHang(HoTen);
		ArrayList<AnhTruyenBean> dsAnh = atbo.getAnhTruyen(MaChuong);
		
		if(MaTruyen != null && MaChuong != 0) {
			tbo.TangLuotXem(MaTruyen);
			lsbo.ThemLichSu(MaKhachHang, MaTruyen, MaChuong);
		}
		request.setAttribute("KhachHang", khbo.SearchUserName(HoTen));
		request.setAttribute("Truyen", Truyen);
		request.setAttribute("dsChuong", ls);
		request.setAttribute("dsAnh", dsAnh);
		request.setAttribute("dsTheLoai", tlbo.getTheLoai());

		RequestDispatcher rd = request.getRequestDispatcher("AnhTruyen.jsp");
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
