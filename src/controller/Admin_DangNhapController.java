package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import bean.AdminBean;
import dao.Admin_DangNhapDao;

/**
 * Servlet implementation class Admin_DangNhapController
 */
@WebServlet("/Admin_DangNhapController")
public class Admin_DangNhapController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Admin_DangNhapController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String TaiKhoan = request.getParameter("TaiKhoan");
		String MatKhau = request.getParameter("MatKhau");
		RequestDispatcher rd;
		
		if(TaiKhoan != null && MatKhau !=null) {
			Admin_DangNhapDao dndao= new Admin_DangNhapDao();
			AdminBean dn= dndao.checkAdminAccount(TaiKhoan, MatKhau);
			if(dn!=null) {
				HttpSession session = request.getSession();
				session.setAttribute("admin", TaiKhoan);
				response.sendRedirect("Admin_QLTheLoaiController");
				return; 
			}
			else
				rd= request.getRequestDispatcher("Admin_DangNhap.jsp?kt=1");	
		}else
			
			rd= request.getRequestDispatcher("Admin_DangNhap.jsp");
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
