package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import javax.mail.*;
import javax.mail.internet.*;
import java.util.*;

import bean.KhachHangBean;
import bo.TheLoaiBo;
import dao.KhachHangDao;

/**
 * Servlet implementation class DangKyController
 */
@WebServlet("/DangKyController")
public class DangKyController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DangKyController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		HttpSession ss = request.getSession();
		TheLoaiBo tlbo= new TheLoaiBo();
		RequestDispatcher rd;
		
		String HoTen = request.getParameter("HoTen");
 		String Email = request.getParameter("Email");
 		String MatKhau = request.getParameter("MatKhau");
 		String Avatar = request.getParameter("Avatar");
		
		if(	HoTen != null && Email != null && MatKhau != null){
		 		KhachHangDao khdao = new KhachHangDao();
		 		KhachHangBean khbean = khdao.RegisterAccount(HoTen, Email, MatKhau, Avatar);
		 		
		 	    if(khbean != null) {
		 	    	final String username = "zangbin2521@gmail.com";
			 		final String password = "geabnjfrhfocgsro";
			 	    String host = "smtp.gmail.com";	
			 	    
			 	    Properties props = new Properties();
			 	    props.put("mail.smtp.auth", "true");
			 	    props.put("mail.smtp.starttls.enable", "true");
			 	    props.put("mail.smtp.host", host);
			 	    props.put("mail.smtp.port", "587");
			 	    Session session = Session.getInstance(props, new Authenticator() {
			 	        protected PasswordAuthentication getPasswordAuthentication() {
			 	            return new PasswordAuthentication(username, password);
			 	        }
			 	    });
			 	    try {
			 	        // Tạo đối tượng Message
			 	    	if (Email != null && !Email.isEmpty()) {
				 	        Message message = new MimeMessage(session);
				 	        message.setFrom(new InternetAddress(username));
				 	        message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(Email));
				 	        message.setSubject("Sign Up Success");
				 	        message.setContent(
				 	        		  "<html>"
				 	        		+ "<body style='font-family: Arial, sans-serif;background-color: #f2f2f2;padding: 20px;color: #333;'>"
				 	        		+ "<h1 style='color: #0099cc;margin-bottom: 20px;'>Thông báo đăng ký thành công</h1>"
				 	        		+ "<p style='margin-bottom: 10px;'>Xin chào <h2 style='color:#00d170'>" + HoTen + "</h2></p>"
				 	        		+ "<p style='margin-bottom: 10px;'>Cảm ơn bạn đã đăng ký trên trang đọc truyện của chúng tôi.</p>"
				 	        		+ "<p style='margin-bottom: 10px;'>Bây giờ bạn đã trở thành thành viên của cộng đồng đọc truyện.</p>"
				 	        		+ "<p style='margin-bottom: 10px;'>Bạn có thể quay lại và bắt đầu đọc truyện ngay bây giờ bằng cách truy cập vào trang chủ của chúng tôi.</p>"
				 	        		+ "<a href=\'http://localhost:8080/WebTruyenTranh/HienThiTruyenController\' style='display: inline-block;padding: 8px 16px;background-color: #0099cc;color: #fff;text-decoration: none;border-radius: 4px;margin-top: 20px;'>Trang chủ</a>"
				 	        		+ "<p style='margin-bottom: 10px;'>Xin cảm ơn !</p>"
				 	        		+ "</body>"
				 	        		+ "</html>", 
				 	        		"text/html; charset=utf-8");
				 	        // Gửi email
				 	        Transport.send(message);
			 	    	}
			 	    } catch (MessagingException e) {
			 	        e.printStackTrace();
			 	    }
		 			ss.setAttribute("un", HoTen);
		 			rd = request.getRequestDispatcher("HienThiTruyenController");
		 		}
		 		else {
		 			rd = request.getRequestDispatcher("DangKy.jsp?kt=1");
		 		}	 		
		 	}
		 	else {
		 		rd = request.getRequestDispatcher("DangKy.jsp");
		 	}
 		
		
			request.setAttribute("dsTheLoai", tlbo.getTheLoai());
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
