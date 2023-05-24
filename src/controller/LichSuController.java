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

import bean.LichSuBean;
import bo.KhachHangBo;
import bo.LichSuBo;
import bo.TheLoaiBo;


/**
 * Servlet implementation class LichSuController
 */
@WebServlet("/LichSuController")
public class LichSuController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LichSuController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		
		LichSuBo lsbo = new LichSuBo();
		
		TheLoaiBo tlbo = new TheLoaiBo();
		KhachHangBo khbo= new KhachHangBo();
		RequestDispatcher rd;
		
		if(session.getAttribute("un") == null) {
			rd= request.getRequestDispatcher("KTDNController");
		}
		else {
				String HoTen = (String)session.getAttribute("un");	
				long MaKhachHang = khbo.searchMaKhachHang(HoTen);
				ArrayList<LichSuBean> ds = new ArrayList<LichSuBean>();
				if(MaKhachHang >= 0) {	
					ds =lsbo.getLichSu(MaKhachHang);
				}
			request.setAttribute("KhachHang", khbo.SearchUserName(HoTen));
			request.setAttribute("lichsu", ds);
			request.setAttribute("dsTheLoai", tlbo.getTheLoai());
			rd = request.getRequestDispatcher("LichSu.jsp");
		}
		rd.forward(request, response);
		System.out.println("Stoppp!!!!");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
