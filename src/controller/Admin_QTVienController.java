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

import bean.BinhLuanBean;
import bo.BinhLuanBo;

/**
 * Servlet implementation class Admin_QTVienController
 */
@WebServlet("/Admin_QTVienController")
public class Admin_QTVienController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Admin_QTVienController() {
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
			BinhLuanBo blbo = new BinhLuanBo();
			ArrayList<BinhLuanBean> dsBaoCao = blbo.getBinhLuanByBaoCao();
			request.setAttribute("dsBaoCao", dsBaoCao);
			RequestDispatcher rd = request.getRequestDispatcher("Admin_QuanTriVien.jsp");
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
