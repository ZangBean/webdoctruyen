package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import bo.KhachHangBo;
import bo.TheoDoiBo;

/**
 * Servlet implementation class XoaTheoDoiController
 */
@WebServlet("/TheoDoiDeleteController")
public class TheoDoiDeleteController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public TheoDoiDeleteController() {
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
		System.out.println("MaTruyen:"+MaTruyen);
		long MaKhachHang = khbo.searchMaKhachHang(HoTen);
		tdbo.TheoDoi(MaTruyen, MaKhachHang);
		response.sendRedirect("TheoDoiController");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
