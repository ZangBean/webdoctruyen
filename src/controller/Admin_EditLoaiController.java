package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bo.TheLoaiBo;

/**
 * Servlet implementation class Admin_EditLoaiController
 */
@WebServlet("/Admin_EditLoaiController")
public class Admin_EditLoaiController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Admin_EditLoaiController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8"); 
	 	response.setCharacterEncoding("utf-8");
		TheLoaiBo tlbo =new TheLoaiBo();
		
		if(request.getParameter("nhap")!=null){
			 String MaTheLoai = request.getParameter("butsua");
			 String TenTheLoai = request.getParameter("nhap");
			 if(!request.getParameter("nhap").isBlank()){				 
				 tlbo.SuaTheLoai(TenTheLoai, MaTheLoai);
			 }
		}
		if(request.getParameter("maloai")!=null && request.getParameter("tenloai")!=null) {
			String MaTheLoai = request.getParameter("maloai");
			String TenTheLoai = request.getParameter("tenloai");
			if(!MaTheLoai.isBlank() && !TenTheLoai.isBlank()){				 
				tlbo.ThemTheLoai(MaTheLoai, TenTheLoai);
			 }
		}
		if(request.getParameter("butxoa")!=null){
			String MaTheLoai = request.getParameter("butxoa");
			tlbo.XoaTheLoai(MaTheLoai);		
		}
		response.sendRedirect("Admin_QLTheLoaiController");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
