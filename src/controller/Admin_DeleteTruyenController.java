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
 * Servlet implementation class Admin_DeleteTruyenController
 */
@WebServlet("/Admin_DeleteTruyenController")
public class Admin_DeleteTruyenController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Admin_DeleteTruyenController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String MaTruyen = request.getParameter("MaTruyen");
		TruyenBo tbo = new TruyenBo();
		if(MaTruyen != null && !MaTruyen.isEmpty()) {
			tbo.XoaTruyen(MaTruyen);
			
			String folderPath = "C:\\Users\\ACER\\Documents\\HK1-Nam4\\javanangcao\\WebTruyenTranh\\WebContent\\Truyen\\"+MaTruyen;
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
