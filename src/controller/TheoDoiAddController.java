package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import bo.KhachHangBo;
import bo.TheoDoiBo;

/**
 * Servlet implementation class ThemTheoDoiConTroller
 */
@WebServlet("/TheoDoiAddController")
public class TheoDoiAddController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public TheoDoiAddController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		KhachHangBo khbo = new KhachHangBo();
		TheoDoiBo tdbo = new TheoDoiBo();
		
		String MaTruyen = request.getParameter("MaTruyen");
		String HoTen = (String)session.getAttribute("un");
		if(HoTen==null) {
			RequestDispatcher rd = request.getRequestDispatcher("KTDNController");
			rd.forward(request, response);
		}else {
			long MaKhachHang = khbo.searchMaKhachHang(HoTen);
			tdbo.TheoDoi(MaTruyen, MaKhachHang);
			response.sendRedirect("ChiTietTruyenController?mt="+MaTruyen);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
