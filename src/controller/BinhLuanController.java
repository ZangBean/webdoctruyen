package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import bo.BinhLuanBo;
import bo.KhachHangBo;

/**
 * Servlet implementation class BinhLuanController
 */
@WebServlet("/BinhLuanController")
public class BinhLuanController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BinhLuanController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
	 	response.setCharacterEncoding("utf-8");
	 	HttpSession session = request.getSession();
	 	RequestDispatcher rd;
	 	
	 	String BinhLuan = request.getParameter("BinhLuan");
	 	String HoTen = (String)session.getAttribute("un");
	 	String MaTruyen = request.getParameter("mt");
		KhachHangBo khbo = new KhachHangBo();
		BinhLuanBo blbo = new BinhLuanBo();
		
	 	if(BinhLuan != null && BinhLuan!=""){
			if(HoTen == null) {
				rd = request.getRequestDispatcher("KTDNController");
				rd.forward(request, response);
				return;
			}else {
				long MaKhachHang = khbo.searchMaKhachHang(HoTen);
				blbo.ThemBinhLuan(MaKhachHang, BinhLuan, MaTruyen);
			}
		}
	 	response.sendRedirect("ChiTietTruyenController?mt="+MaTruyen);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
