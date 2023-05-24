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

import bo.KhachHangBo;

/**
 * Servlet implementation class TaiKhoanUpdateController
 */
@WebServlet("/TaiKhoanUpdateController")
public class TaiKhoanUpdateController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public TaiKhoanUpdateController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		long MaKhachHang = 0;
		String HoTen = "";
		String MatKhau = "";
		String Avatar = "";
		
		DiskFileItemFactory fileItemFactory = new DiskFileItemFactory();
		ServletFileUpload upload = new ServletFileUpload(fileItemFactory);
		try {
		    List<FileItem> fileItems = upload.parseRequest(request);
		    for (FileItem fileItem : fileItems) {
		        if (!fileItem.isFormField()) {
		            String nameimg = fileItem.getName();
		            if (!nameimg.equals("")) {
		                String dirUrl = "C:\\Users\\ACER\\Documents\\HK1-Nam4\\javanangcao\\WebTruyenTranh\\WebContent\\Avatar\\"+ HoTen;
		                File dir = new File(dirUrl);
		                if (!dir.exists()) {
		                    dir.mkdir();
		                }
		                //Them anh vao folder
		                String fileImg = "";
		                if(fileItem.getFieldName().equals("Avatar")) {
		                     fileImg = dirUrl + File.separator + "Avatar_" + nameimg;
		                } 
		                // Them anh vao db
		                File file = new File(fileImg);
		                if (fileItem.getFieldName().equals("Avatar")) {
		                    Avatar = "Avatar/" + HoTen + "/" + "Avatar_" + nameimg;
		                }
		            try {
		                fileItem.write(file);
		            } catch (Exception e) {
		                e.printStackTrace();
		            }
		           }
		        } else {
		            String tentk = fileItem.getFieldName();
		            if (tentk.equals("HoTen")) {
		                HoTen = fileItem.getString();
		                System.out.println("Ten:"+HoTen);
		            }else if(tentk.equals("MatKhau")) {
		            	MatKhau = fileItem.getString();
		            	System.out.println("MatKhau:"+MatKhau);
		            }
		        }
		    }
		} catch (FileUploadException e) {
		    e.printStackTrace();
		}
		KhachHangBo khbo = new KhachHangBo();
		String currentAvatar = khbo.SearchUserName(HoTen).getAvatar();
		// Xoa anh cu
			if (currentAvatar!=null && Avatar!="" && !currentAvatar.equals(Avatar) && !currentAvatar.equals("")) {
				File oldImgAvatar = new File("C:\\Users\\ACER\\Documents\\HK1-Nam4\\javanangcao\\WebTruyenTranh\\WebContent\\"+ currentAvatar); 
				oldImgAvatar.delete(); 
			}
		MaKhachHang = khbo.searchMaKhachHang(HoTen);
		System.out.println("Ma:"+MaKhachHang);
		khbo.UpdateKhachHang(MaKhachHang, MatKhau, Avatar);
		response.sendRedirect("TaiKhoanController");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
