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
import dao.Admin_DangKyDao;

/**
 * Servlet implementation class Admin_DangKyController
 */
@WebServlet("/Admin_DangKyController")
public class Admin_DangKyController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Admin_DangKyController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		RequestDispatcher rd;
		if(		request.getParameter("TaiKhoan") != null &&
		 		request.getParameter("MatKhau") != null)
		{
		 		String TaiKhoan = request.getParameter("TaiKhoan");
		 		String MatKhau = request.getParameter("MatKhau");
		 		Admin_DangKyDao Adao = new Admin_DangKyDao();
		 		AdminBean Abean = Adao.registerAdminAccount(TaiKhoan, MatKhau);
		 		
		 		if(Abean != null) {
		 			HttpSession  session = request.getSession();
		 			session.setAttribute("admin", TaiKhoan);
		 			rd = request.getRequestDispatcher("Admin_QLTheLoaiController");
		 		}
		 		else {
		 			rd = request.getRequestDispatcher("Admin_DangKy.jsp?kt=1");
		 		}	 		
		 	}
		 	else {
		 		rd = request.getRequestDispatcher("Admin_DangKy.jsp");
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
