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

import bo.AnhTruyenBo;
import bo.ChuongBo;
import bo.TruyenBo;

/**
 * Servlet implementation class Admin_SaveChuongController
 */
@WebServlet("/Admin_SaveChuongController")
public class Admin_SaveChuongController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Admin_SaveChuongController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8"); 
	 	response.setCharacterEncoding("utf-8");
	 	AnhTruyenBo atbo = new AnhTruyenBo();
	 	ChuongBo cbo = new ChuongBo();
	 	TruyenBo tbo = new TruyenBo();
	 	
		String TenChuong = "";
		String MaTruyen = "";
		int MaChuong = 0;
		String TenAnh = "";
		String HoanThanh = "";
		
		DiskFileItemFactory fileItemFactory = new DiskFileItemFactory();
		ServletFileUpload upload = new ServletFileUpload(fileItemFactory);
		try {
		    List<FileItem> fileItems = upload.parseRequest(request);
		    for (FileItem fileItem : fileItems) {
		        if (!fileItem.isFormField()) {
		            String nameimg = fileItem.getName();
		            if (!nameimg.equals("")) { // Dang co van de chua nhap ten chuong van luu anh vao thu muc truyen !!!
		                String dirUrl = "C:\\Users\\ACER\\Documents\\HK1-Nam4\\javanangcao\\WebTruyenTranh\\WebContent\\Truyen\\" + MaTruyen + "\\" + TenChuong;
		                File dir = new File(dirUrl);
		                if (!dir.exists()) {
		                    dir.mkdir();
		                }
		                String fileImg = dirUrl + File.separator + nameimg;
		                File file = new File(fileImg);
		                TenAnh = "Truyen/" + MaTruyen + "/" + TenChuong + "/" + nameimg;
		    		    atbo.ThemAnh(TenAnh, MaChuong, MaTruyen);
		                System.out.println(TenAnh);
		                try {
		                    fileItem.write(file);
		                } catch (Exception e) {
		                    e.printStackTrace();
		                }
		            }
		        } else {
		            String Items = fileItem.getFieldName();
		            if (Items.equals("TenChuong")) {
		                TenChuong = fileItem.getString("utf-8");
		            } else if (Items.equals("MaTruyen")) {
		                MaTruyen = fileItem.getString();
		            } else if (Items.equals("HoanThanh")) {
		                HoanThanh = fileItem.getString();
		                if (HoanThanh != null && HoanThanh.equals("Done")) {
		                    tbo.TruyenDone(MaTruyen);
		                } else {
		                    tbo.TruyenUpdate(MaTruyen);
		                }
		            }
		            System.out.println("TenChuong:"+TenChuong);
		            System.out.println("MaTruyen:"+MaTruyen);
		            System.out.println("HoanThanh:"+HoanThanh);
		            if (TenChuong != null && MaTruyen != null && !TenChuong.isEmpty() && !MaTruyen.isEmpty() && MaChuong==0) {
		    		    cbo.ThemChuong(TenChuong, MaTruyen);
		    		    MaChuong = cbo.searchMaChuong(TenChuong, MaTruyen);
		    		}
		        }
		    }
		} catch (FileUploadException e) {
		    e.printStackTrace();
		}
		response.sendRedirect("Admin_EditTruyenController?MaTruyen=" + MaTruyen);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
