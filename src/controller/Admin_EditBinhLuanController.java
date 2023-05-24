package controller;

import java.io.File;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bo.BinhLuanBo;
import bo.KhachHangBo;

/**
 * Servlet implementation class Admin_EditBinhLuanController
 */
@WebServlet("/Admin_EditBinhLuanController")
public class Admin_EditBinhLuanController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Admin_EditBinhLuanController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		BinhLuanBo blbo = new BinhLuanBo();
		KhachHangBo khbo = new KhachHangBo();
		String MaBinhLuanStr = request.getParameter("skip");
		String MaKhachHangStr = request.getParameter("delete");
		if(MaBinhLuanStr!=null) {
			long MaBinhLuan = Long.parseLong(MaBinhLuanStr);
			blbo.BaoCaoSkip(MaBinhLuan);
		}
		if(MaKhachHangStr!=null) {
			long MaKhachHang = Long.parseLong(MaKhachHangStr);
			khbo.DeleteKhachHang(MaKhachHang);
			String HoTen= khbo.getTenKH(MaKhachHang);
			String folderPath = "C:\\Users\\ACER\\Documents\\HK1-Nam4\\javanangcao\\WebTruyenTranh\\WebContent\\Avatar\\"+ HoTen;
			File folder = new File(folderPath);

			for (File file : folder.listFiles()) {
				if (file.isDirectory()) {

					for (File subFile : file.listFiles()) {
						subFile.delete();
					}
				}
				file.delete();
			}
			folder.delete();
		}
		response.sendRedirect("Admin_QTVienController");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
