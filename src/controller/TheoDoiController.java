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

import bean.TheLoaiBean;
import bean.TheoDoiBean;
import bo.KhachHangBo;
import bo.TheLoaiBo;
import bo.TheoDoiBo;

/**
 * Servlet implementation class TheoDoiController
 */
@WebServlet("/TheoDoiController")
public class TheoDoiController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public TheoDoiController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		RequestDispatcher rd;
		TheLoaiBo tlbo = new TheLoaiBo();
		KhachHangBo khbo =new KhachHangBo();
		TheoDoiBo tdbo = new TheoDoiBo();
		String HoTen = (String)session.getAttribute("un");
		long MaKhachHang = khbo.searchMaKhachHang(HoTen);
		ArrayList<TheLoaiBean> dsTheLoai = tlbo.getTheLoai();
		ArrayList<TheoDoiBean> dsTheoDoi = tdbo.dsTheoDoi(MaKhachHang);
		
		request.setAttribute("KhachHang", khbo.SearchUserName(HoTen));
		request.setAttribute("dsTheoDoi", dsTheoDoi);
		request.setAttribute("dsTheLoai", dsTheLoai);
		rd = request.getRequestDispatcher("TheoDoiTruyen.jsp");
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
