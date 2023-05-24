package controller;

import java.io.File;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bean.ChuongBean;
import bo.ChuongBo;

/**
 * Servlet implementation class Admin_DeleteChuongController
 */
@WebServlet("/Admin_DeleteChuongController")
public class Admin_DeleteChuongController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public Admin_DeleteChuongController() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");

		String MaTruyen = request.getParameter("MaTruyen");
		long MaChuong = Long.parseLong(request.getParameter("MaChuong"));

		ChuongBo cbo = new ChuongBo();
		if (MaTruyen != null && !MaTruyen.isEmpty()) {
			ChuongBean Chuong = cbo.searchTenChuong(MaChuong);
			String TenChuong = Chuong.getTenChuong();
			cbo.XoaChuong(MaChuong);

			String folderPath = "C:\\Users\\ACER\\Documents\\HK1-Nam4\\javanangcao\\WebTruyenTranh\\WebContent\\Truyen\\"
					+ MaTruyen + "\\" + TenChuong;
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
		response.sendRedirect("Admin_EditTruyenController?MaTruyen=" + MaTruyen);
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
