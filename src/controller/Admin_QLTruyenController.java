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
import bean.TruyenBean;
import bo.TheLoaiBo;
import bo.TruyenBo;

/**
 * Servlet implementation class Admin_QLTruyenController
 */
@WebServlet("/Admin_QLTruyenController")
public class Admin_QLTruyenController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Admin_QLTruyenController() {
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
			TruyenBo tbo = new TruyenBo();
			TheLoaiBo tlbo = new TheLoaiBo();
			String TenTruyen = request.getParameter("TenTruyen");
			ArrayList<TruyenBean> dsTruyen = new ArrayList<TruyenBean>();
			ArrayList<TheLoaiBean> dsTheLoai = tlbo.getTheLoai();
			if(TenTruyen !=null && TenTruyen!="") {
				dsTruyen = tbo.TimTruyen(TenTruyen);
			}else {
				dsTruyen = tbo.getTruyen();
			}
			request.setAttribute("dsTruyen", dsTruyen);
			request.setAttribute("dsTheLoai", dsTheLoai);
			RequestDispatcher rd = request.getRequestDispatcher("Admin_QLTruyen.jsp");
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
