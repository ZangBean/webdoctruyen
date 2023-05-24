package controller;

import java.io.File;
import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import bean.TruyenBean;
import bo.TruyenBo;

/**
 * Servlet implementation class Admin_SaveAnhController
 */
@WebServlet("/Admin_SaveAnhController")
public class Admin_SaveAnhController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public Admin_SaveAnhController() {
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
		String MaTruyen = "";
		String AnhNen = "";
		String AnhTruyen = "";

		DiskFileItemFactory fileItemFactory = new DiskFileItemFactory();
		ServletFileUpload upload = new ServletFileUpload(fileItemFactory);
		try {
			List<FileItem> fileItems = upload.parseRequest(request);
			int i = 0;
			for (FileItem fileItem : fileItems) {
				if (!fileItem.isFormField()) {
					String nameimg = fileItem.getName();
					if (!nameimg.equals("")) {
						String dirUrl = "C:\\Users\\ACER\\Documents\\HK1-Nam4\\javanangcao\\WebTruyenTranh\\WebContent\\Truyen\\"
								+ MaTruyen;
						File dir = new File(dirUrl);
						if (!dir.exists()) {
							dir.mkdir();
						}

						String fileImg = "";
						if (fileItem.getFieldName().equals("AnhNen")) {
							if (i == 0) {
								fileImg = dirUrl + File.separator + "AnhNen_" + nameimg;
								i++;
							} else {
								continue;
							}
						} else if (fileItem.getFieldName().equals("AnhTruyen")) {
							fileImg = dirUrl + File.separator + "AnhTruyen_" + nameimg;
						}

						File file = new File(fileImg);
						if (fileItem.getFieldName().equals("AnhNen")) {
							AnhNen = "Truyen/" + MaTruyen + "/" + "AnhNen_" + nameimg;
						} else if (fileItem.getFieldName().equals("AnhTruyen")) {
							AnhTruyen = "Truyen/" + MaTruyen + "/" + "AnhTruyen_" + nameimg;
						}

						try {
							fileItem.write(file);
						} catch (Exception e) {
							e.printStackTrace();
						}
					}
				} else {
					String tentk = fileItem.getFieldName();
					if (tentk.equals("MaTruyen")) {
						MaTruyen = fileItem.getString();
					}
				}
			}
		} catch (FileUploadException e) {
			e.printStackTrace();
		}
		TruyenBo tbo = new TruyenBo();
		TruyenBean ctTruyen = tbo.getChiTietTruyen(MaTruyen);
		String currentAnhNen = ctTruyen.getAnhNen();
		String currentAnhTruyen = ctTruyen.getAnhTruyen();
		
		if (currentAnhNen != null && AnhNen != "" && !currentAnhNen.equals(AnhNen) && !currentAnhNen.equals("")) {
			File oldImgNen = new File(
					"C:\\Users\\ACER\\Documents\\HK1-Nam4\\javanangcao\\WebTruyenTranh\\WebContent\\" + currentAnhNen);
			oldImgNen.delete();
		}
		if (currentAnhTruyen != null && AnhTruyen != "" && !currentAnhTruyen.equals(AnhTruyen)
				&& !currentAnhTruyen.equals("")) {
			File oldImgTruyen = new File(
					"C:\\Users\\ACER\\Documents\\HK1-Nam4\\javanangcao\\WebTruyenTranh\\WebContent\\"
							+ currentAnhTruyen);
			oldImgTruyen.delete();
		}
		tbo.SuaAnh(AnhNen, AnhTruyen, MaTruyen);
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
