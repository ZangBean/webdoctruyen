package controller;

import java.io.File;
import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bo.TruyenBo;

/**
 * Servlet implementation class Admin_AddTruyenController
 */
@WebServlet("/Admin_AddTruyenController")
public class Admin_AddTruyenController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Admin_AddTruyenController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8"); 
	 	response.setCharacterEncoding("utf-8");
	 	
	 	String MaTruyen = request.getParameter("MaTruyen");
	 	String TenTruyen = request.getParameter("TenTruyen");
	 	String TacGia = request.getParameter("TacGia");
	 	String GioiThieu = request.getParameter("GioiThieu");
	 	String AnhTruyen = "";
		long LuotXem = 0;
		boolean HoanThanh = false;
		String MaTheLoai = request.getParameter("MaTheLoai"); 
		String AnhNen = "";
		
		TruyenBo tbo = new TruyenBo();
		if(MaTruyen!=null && !MaTruyen.isEmpty() && TenTruyen!=null && !TenTruyen.isEmpty()) {
			tbo.ThemTruyen(MaTruyen, TenTruyen, TacGia, GioiThieu, AnhTruyen, LuotXem, HoanThanh, MaTheLoai, AnhNen);
			String folderPath = "C:\\Users\\ACER\\Documents\\HK1-Nam4\\javanangcao\\WebTruyenTranh\\WebContent\\Truyen\\" + MaTruyen;
		    File folder = new File(folderPath);
		    if (!folder.exists()) {
		        folder.mkdir();
		    }
		}
		response.sendRedirect("Admin_QLTruyenController");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
