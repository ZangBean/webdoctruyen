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
import bo.TheLoaiBo;

/**
 * Servlet implementation class Admin_QLTheLoaiController
 */
@WebServlet("/Admin_QLTheLoaiController")
public class Admin_QLTheLoaiController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Admin_QLTheLoaiController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		if(session.getAttribute("admin")==null) {
			response.sendRedirect("Admin_DangNhapController");
		}else {
			String TenTheLoai = request.getParameter("TenTheLoai");
			ArrayList<TheLoaiBean> dsTheLoai = new ArrayList<TheLoaiBean>();
			TheLoaiBo tlbo =new TheLoaiBo();
		 	if(TenTheLoai!=null && TenTheLoai !="") {
		 		dsTheLoai = tlbo.TimTheLoai(TenTheLoai);
		 	}else {
		 		dsTheLoai = tlbo.getTheLoai();
		 	}
			request.setAttribute("dsTheLoai", dsTheLoai);
			RequestDispatcher rd= request.getRequestDispatcher("Admin_QLTheLoai.jsp");
			rd.forward(request, response);
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
