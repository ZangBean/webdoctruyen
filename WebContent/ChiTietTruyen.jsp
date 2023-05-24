<!DOCTYPE html>
<%@page import="bean.KhachHangBean"%>
<%@page import="java.util.Date"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="bean.BinhLuanBean"%>
<%@page import="bean.ChuongBean"%>
<%@page import="bean.TruyenBean"%>
<%@page import="java.util.ArrayList"%>
<html lang="zxx">
<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<head>
<meta charset="UTF-8">
<meta name="description" content="Anime Template">
<meta name="keywords" content="Anime, unica, creative, html">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<meta http-equiv="X-UA-Compatible" content="ie=edge">
<title>Manga | Đọc truyện</title>

<!-- Google Font -->
<link
	href="https://fonts.googleapis.com/css2?family=Oswald:wght@300;400;500;600;700&display=swap"
	rel="stylesheet">
<link
	href="https://fonts.googleapis.com/css2?family=Mulish:wght@300;400;500;600;700;800;900&display=swap"
	rel="stylesheet">

<!-- Css Styles -->
<link rel="stylesheet" href="css/bootstrap.min.css" type="text/css">
<link rel="stylesheet" href="css/font-awesome.min.css" type="text/css">
<link rel="stylesheet" href="css/elegant-icons.css" type="text/css">
<link rel="stylesheet" href="css/plyr.css" type="text/css">
<link rel="stylesheet" href="css/nice-select.css" type="text/css">
<link rel="stylesheet" href="css/owl.carousel.min.css" type="text/css">
<link rel="stylesheet" href="css/slicknav.min.css" type="text/css">
<link rel="stylesheet" href="css/style.css" type="text/css">
<link rel="stylesheet" href="css/fontawesome-free-6.2.1-web/css/all.min.css">
 <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
</head>

<style>
.fa {
	padding-right: 4px;
	padding-top: 1px;
}
.options {
  position: relative;
  cursor: pointer;
}

.options .option-list {
  position: absolute;
  display: none;
  z-index: 1;
  top: 20%;
  right: 20px;
  width: 100px;
  padding: 6px 0px 6px 10px;
  background-color: #fff;
  border: 1px solid #ccc;
  list-style: none;
  border-radius: 4px;
  font-weight: 700;
}

.options.active .option-list {
  display: block;
}
.option-list a{
	color: #0066ca;
}
.options.active .option-list:hover a{
  opacity: 0.8;
  color: #1d1e39;
}
.follow-btn {
	border: none;
    width: 150px;
}
</style>
<body>
	<!-- Page Preloder -->
	<div id="preloder">
		<div class="loader"></div>
	</div>

	<!-- Header Section Begin -->
	<jsp:include page="Header.jsp"></jsp:include>
	<!-- Header End -->
	
	<!-- Breadcrumb Begin -->
	<%
	request.setCharacterEncoding("utf-8");
	response.setCharacterEncoding("utf-8");
	TruyenBean Truyen = (TruyenBean) request.getAttribute("Truyen");
	int dembl = (int) request.getAttribute("dembl");
	%>
	<div class="breadcrumb-option" style="padding-top: 100px"> 
        <div class="container">
            <div class="row">
                <div class="col-lg-12">
                    <div>
                        <a style="color: white;" href="HienThiTruyenController">
	                        <i style="color: red;" class="fa fa-home"></i> 
	                        	Trang chủ 
	                        <i style="color: white;" class="fa-solid fa-angle-right"></i>
                        </a> 
                        <span style="color: #b7b7b7;"><%=Truyen.getTenTruyen() %></span>
                    </div>
                </div>
            </div>
        </div>
    </div>
	<!-- Breadcrumb End -->
	<!-- Anime Section Begin -->
	<section class="anime-details spad" style="padding-top: 50px">
		<div class="container">
			<div class="anime__details__content">
				<div class="row">
					<div class="col-lg-3">
						<div class="anime__details__pic set-bg"
							data-setbg="<%=Truyen.getAnhTruyen()%>">
							<div class="comment">
								<i class="fa fa-comments"></i>
								<%=dembl%></div>
							<div class="view">
								<i class="fa fa-eye"></i>
								<%=Truyen.getLuotXem()%></div>
						</div>
					</div>
					<div class="col-lg-9">
						<div class="anime__details__text" style="min-height: 440px;">
							<div class="anime__details__title">
								<h3><%=Truyen.getTenTruyen()%></h3>
								<span>Tác giả: <%=Truyen.getTacGia()%></span>
							</div>
							<div class="anime__details__rating">
								<%int Dem = (int)request.getAttribute("DemSoTheoDoi");
								boolean CheckTheoDoi = (boolean) request.getAttribute("CheckTheoDoi");
								if(CheckTheoDoi){%>
									<div class="rating">
										<i style="color: red;" class="fa-solid fa-heart"></i>
									</div>
									<span><%=Dem %> Theo dõi</span>
								<%}else{ %>
									<div class="rating">
										<i style="color: #00deff" class="fa-solid fa-heart"></i>
									</div>
									<span><%=Dem %> Theo dõi</span>
								<%} %>
							</div>
							<p><%=Truyen.getGioiThieu()%></p>
							<div class="anime__details__widget">
								<div class="row">
									<div class="col-lg-6 col-md-6">
										<ul>
											<li><span>Thể loại:</span><%=Truyen.getMaTheLoai()%></li>
										</ul>
									</div>
									<div class="col-lg-6 col-md-6">
										<ul>
											<li><span>Lượt xem:</span> <%=Truyen.getLuotXem()%></li>
										</ul>
									</div>
									<div class="col-lg-6 col-md-6">
									<%SimpleDateFormat simdf = new SimpleDateFormat("dd / MM / yyyy"); 
										Date ThoiGian = Truyen.getNgayThem();
										String NgayDang = simdf.format(ThoiGian);
									%>
										<ul>
											<li><span>Ngày đăng:</span> <%=NgayDang%></li>
										</ul>
									</div>
									<div class="col-lg-6 col-md-6">
										<ul>
											<%
											if (Truyen.isHoanThanh() == true) {
											%>
											<li><span>Tình trạng:</span>Đã hoàn thành</li>
											<%
											} else {
											%>
											<li><span>Tình trạng:</span>Đang cập nhật</li>
											<%
											}
											%>
										</ul>
									</div>
								</div>
							</div>
							<div class="anime__details__btn" style="display: flex;">
								<form action="TheoDoiAddController" method="POST" id="follow-form">
								      <input type="hidden" name="MaTruyen" value="<%=Truyen.getMaTruyen() %>">
								   <%if(CheckTheoDoi){%>
									    <input class="follow-btn" type="button" id="follow-btn" value="Bỏ Theo Dõi"/>
								   <%}else{%>
								      	<input class="follow-btn" type="button" id="follow-btn" value="Theo Dõi"/> 
								   <%} %>           
								</form>
								
								<script type="text/javascript">
								   $(document).ready(function() {
								      $('#follow-btn').click(function(e) {
								         e.preventDefault();
								         var formdata = $('#follow-form').serialize();
								         var btnValue = $('#follow-btn').val();
								         $.ajax({
								            url: "TheoDoiAddController",
								            type: "POST",
								            data: formdata,
								            success: function(data) {
								               if (btnValue == 'Theo Dõi') {
								                  $('#follow-btn').val('Bỏ Theo Dõi');
								               } else {
								                  $('#follow-btn').val('Theo Dõi');
								               }
								            }
								         });
								      });
								   });
								</script>
								<%
								ArrayList<ChuongBean> dsChuong = (ArrayList<ChuongBean>) request.getAttribute("dsChuong");
								%>
								<a style="display: flex;" href="HienThiAnhController?mc=<%=dsChuong.get(0).getMaChuong()%>&mt=<%=Truyen.getMaTruyen()%>"class="watch-btn"> 
									<span style="margin-right: 4px;">Đọc Ngay</span> 
									<i class="fa fa-angle-right"></i>
								</a>
							</div>

						</div>
					</div>
				</div>
			</div>

			<div class="row">
				<div class="col-lg-8 col-md-8">
					<div class="anime__details__review">
						<div class="section-title">
							<h5>Bình luận</h5>
						</div>
						<%
						request.setCharacterEncoding("utf-8");
						response.setCharacterEncoding("utf-8");
						ArrayList<BinhLuanBean> dsBinhLuan = (ArrayList<BinhLuanBean>) request.getAttribute("dsBinhLuan");
						int dsBl = dsBinhLuan.size();
						SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm");
						for (int i = 0; i < dsBl; i++) {
							BinhLuanBean blb = dsBinhLuan.get(i);
							Date thoiGian = blb.getThoiGian();
							String thoiGianStr = sdf.format(thoiGian);
						%>
						<div class="anime__review__item">
							<div class="anime__review__item__pic">
								<img alt="" src="<%=blb.getKhachHang().getAvatar()%>" onerror="this.onerror=null; this.src='Avatar/user.png';">
							</div>
							<div class="anime__review__item__text">
								<div style="display: flex; justify-content: space-between;">
									<h6><%=blb.getKhachHang().getHoTen()%> - <span><%=thoiGianStr%></span></h6>
									<div class="options">
										<i class="fa-solid fa-ellipsis" style="color: white;"></i>
										
										<%KhachHangBean khbean = (KhachHangBean) request.getAttribute("KhachHang");
										if(khbean!=null){
											if(khbean.getHoTen().equals(blb.getKhachHang().getHoTen()) ){%>
												<ul class="option-list" style="width: 70px">
												    <li>
												     	<a href="BinhLuanDeleteController?MaBL=<%=blb.getMaBinhLuan() %>&MaTruyen=<%=blb.getMaTruyen() %>">
												     		<i class="fa-solid fa-circle-xmark"></i> Xóa
												     	</a>
												     </li>
												</ul>
											<%}else{ %>
												<ul class="option-list">
												    <li>
												    	<a href="BinhLuanReportController?MaBL=<%=blb.getMaBinhLuan()%>&MaTruyen=<%=blb.getMaTruyen() %>">
												    		<i class="fa-solid fa-circle-exclamation"></i> Báo cáo
												    	</a>												    
												    </li>
											    </ul>
											<%}
											}else{%>
												<ul class="option-list">
												    <li>
												    	<a href="BinhLuanReportController?MaBL=<%=blb.getMaBinhLuan()%>&MaTruyen=<%=blb.getMaTruyen() %>">
												    		<i class="fa-solid fa-circle-exclamation"></i> Báo cáo
												    	</a>												    
												    </li>
											    </ul>
											<%} %>
									</div>
								</div>
								<p><%=blb.getBinhLuan()%></p>
							</div>
						</div>
						<%
						}
						%>
					</div>
					<script type="text/javascript">
							const options = document.querySelectorAll('.options');
							for (var i = 0; i < options.length; i++) {
								options[i].onclick = function() {
									const allOptions = Array.from(document.querySelectorAll('.options')); // Lưu trữ tất cả các phần tử .options vào một mảng
								// Lặp qua mảng và xóa class "active" khỏi tất cả các phần tử ngoại trừ phần tử được nhấp vào
									allOptions.forEach(function(option) {
										if (option !== this) {
											 option.classList.remove('active');
											}
										}, this);										   
									this.classList.toggle('active'); // Thêm hoặc xóa class "active" trên phần tử được nhấp vào
									}
							}
					</script>
					<div class="anime__details__form">
						<form action="BinhLuanController?mt=<%=Truyen.getMaTruyen()%>" method="post">
							<textarea name="BinhLuan" placeholder="Bình luận..."></textarea>
							<div style="justify-content: end; display: flex;">
								<button type="submit" style="margin-right: 20px;">
									<i class="fa fa-location-arrow"></i> Gửi
								</button>
							</div>
						</form>
						
					</div>
				</div>
				<div class="col-lg-4 col-md-4">
					<div class="anime__details__sidebar">
						<div class="section-title">
							<h5>Danh sách chương</h5>
						</div>
						<%
						SimpleDateFormat timeStr = new SimpleDateFormat("dd/MM/yyyy");
						int m = dsChuong.size();
						for (int i = 0; i < m; i++) {
							ChuongBean Chuong = dsChuong.get(i);
							Date times = Chuong.getNgayThem();
							String timeString = timeStr.format(times);
						%>
						<div>
							<table>
								<tr>
									<td style="color: white;"><a
										href="HienThiAnhController?mc=<%=Chuong.getMaChuong()%>&mt=<%=Chuong.getMaTruyen()%>"><%=Chuong.getTenChuong()%></a></td>
									<td>______________________</td>
									<td style="color: white;"><%=timeString%></td>
								</tr>
							</table>
						</div>
						<%
						}
						%>
					</div>
				</div>
			</div>
		</div>
	</section>
	<!-- Anime Section End -->
	
	<!-- Footer Section Begin -->
	<jsp:include page="Footer.jsp"></jsp:include>
	<!-- Footer Section End -->

	<!-- Js Plugins -->
	<script src="js/jquery-3.3.1.min.js"></script>
	<script src="js/bootstrap.min.js"></script>
	<script src="js/player.js"></script>
	<script src="js/jquery.nice-select.min.js"></script>
	<script src="js/mixitup.min.js"></script>
	<script src="js/jquery.slicknav.js"></script>
	<script src="js/owl.carousel.min.js"></script>
	<script src="js/main.js"></script>


</body>

</html>