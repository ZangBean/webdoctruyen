package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import bean.KhachHangBean;
import bo.TheLoaiBo;
import dao.KhachHangDao;


/**
 * Servlet implementation class KTDNController
 */
@WebServlet("/KTDNController")
public class KTDNController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public KTDNController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		TheLoaiBo tlbo= new TheLoaiBo();
		request.setAttribute("dsTheLoai", tlbo.getTheLoai());
		RequestDispatcher rd;
		if(request.getParameter("HoTen") != null && request.getParameter("MatKhau") != null) {
			String HoTen=request.getParameter("HoTen");
		 	String MatKhau=request.getParameter("MatKhau");
		 	KhachHangDao khdao = new KhachHangDao();
		 	KhachHangBean khbean = khdao.CheckAccount(HoTen, MatKhau);
		 	if(khbean != null){
	 			HttpSession  session = request.getSession();
	 			session.setAttribute("un",HoTen);
	 			rd = request.getRequestDispatcher("HienThiTruyenController");
	 		}else 
	 			rd = request.getRequestDispatcher("DangNhap.jsp?kt=1");
	 		
	 	}
	 	else {
	 		rd = request.getRequestDispatcher("DangNhap.jsp");
	 	}
	 	
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
