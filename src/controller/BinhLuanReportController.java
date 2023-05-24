package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bo.BinhLuanBo;

/**
 * Servlet implementation class BinhLuanReportController
 */
@WebServlet("/BinhLuanReportController")
public class BinhLuanReportController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BinhLuanReportController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		BinhLuanBo blbo = new BinhLuanBo(); 
		String MaBinhLuanStr= request.getParameter("MaBL");
		String MaTruyen = request.getParameter("MaTruyen");
		long MaBinhLuan = Long.parseLong(MaBinhLuanStr);
		
		blbo.BaoCaoBinhLuan(MaBinhLuan);
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
