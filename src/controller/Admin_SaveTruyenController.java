package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import bo.TruyenBo;

/**
 * Servlet implementation class Admin_SaveTruyenController
 */
@WebServlet("/Admin_SaveTruyenController")
public class Admin_SaveTruyenController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Admin_SaveTruyenController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8"); 
	 	response.setCharacterEncoding("utf-8");
		
		String TenTruyen = request.getParameter("TenTruyen");
		String TacGia = request.getParameter("TacGia");
		String GioiThieu = request.getParameter("GioiThieu").trim();
		String MaTheLoai = request.getParameter("MaTheLoai");
		String MaTruyen = request.getParameter("MaTruyen");
		
		TruyenBo tbo = new TruyenBo();
		tbo.SuaTruyen(TenTruyen, TacGia, GioiThieu, MaTheLoai, MaTruyen);
		
		RequestDispatcher rd = request.getRequestDispatcher("Admin_EditTruyenController");
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
