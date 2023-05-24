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

import bean.ChuongBean;
import bean.TheLoaiBean;
import bean.TruyenBean;
import bo.ChuongBo;
import bo.TheLoaiBo;
import bo.TruyenBo;

/**
 * Servlet implementation class Admin_EditTruyenController
 */
@WebServlet("/Admin_EditTruyenController")
public class Admin_EditTruyenController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public Admin_EditTruyenController() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession session = request.getSession();
		if (session.getAttribute("admin") == null) {
			response.sendRedirect("Admin_DangNhapController");
		} else {
			String MaTruyen = request.getParameter("MaTruyen");
			TruyenBo tbo = new TruyenBo();
			TheLoaiBo tlbo = new TheLoaiBo();
			ChuongBo cbo = new ChuongBo();
			ArrayList<TheLoaiBean> tlbean = tlbo.getTheLoai();
			TruyenBean tbean = tbo.getChiTietTruyen(MaTruyen);
			ArrayList<ChuongBean> cbean = cbo.getChuong(MaTruyen);
			long SoChuong = cbo.DemSoChuong(MaTruyen);
			request.setAttribute("SoChuong", SoChuong);
			request.setAttribute("ctTruyen", tbean);
			request.setAttribute("dsTheLoai", tlbean);
			request.setAttribute("dsChuong", cbean);
			RequestDispatcher rd = request.getRequestDispatcher("Admin_EditTruyen.jsp");
			rd.forward(request, response);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
