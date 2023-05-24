<!DOCTYPE html>
<%@page import="bean.ChuongBean"%>
<%@page import="bean.TruyenBean"%>
<%@page import="bean.AnhTruyenBean"%>
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
<link rel="stylesheet" href="css/fontawesome-free-6.2.1-web/css/all.min.css">
<link rel="stylesheet" href="css/elegant-icons.css" type="text/css">
<link rel="stylesheet" href="css/plyr.css" type="text/css">
<link rel="stylesheet" href="css/nice-select.css" type="text/css">
<link rel="stylesheet" href="css/owl.carousel.min.css" type="text/css">
<link rel="stylesheet" href="css/slicknav.min.css" type="text/css">
<link rel="stylesheet" href="css/style.css" type="text/css">

</head>

<style>
.fa {
	font-size: 20px;
	padding-right: 4px;
	padding-top: 1px;
}
.footer {
    padding-bottom: 60px;
}
.page-up {
    position: fixed;
    left: 96%;
    top: 80%;
}
.page-up a {
	background: #7d7d7d;
}
.chapter-control {
	position: fixed;
	bottom: 0;
	width: 100%;
	background-color: #242526;
	color: white;
	display: flex;
	justify-content: center;
	z-index: 10;
	padding: 6px 0
	;align-items: center;
}
.chapter-control .*{
	margin: 2px;
}
.dropup .select2-container {
  margin-top: -100px; /* Điều chỉnh giá trị này để đáp ứng với yêu cầu cụ thể của bạn */
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

	<!-- Normal Breadcrumb Begin -->
	<section class="normal-breadcrumb set-bg"
		data-setbg="img/normal-breadcrumb.jpg">
		<div class="container">
			<div class="row">
				<div class="col-lg-12 text-center">
					<div class="normal__breadcrumb__text">
						<h2>Manga</h2>
						<p>Chúc các bạn đọc truyện vui vẻ <i class="fa-solid fa-face-kiss-wink-heart"></i></p>
					</div>
				</div>
			</div>
		</div>
	</section>
	<!-- Normal Breadcrumb End -->
	<div class="breadcrumb-option">
		<div class="container">
			<div class="row">
				<div class="col-lg-12">
					<div>
					<%TruyenBean Truyen = (TruyenBean) request.getAttribute("Truyen"); %>
                        <a style="color: white;" href="HienThiTruyenController">
	                        <i style="color: red;" class="fa fa-home"></i> 
	                        	Trang chủ 
	                        <i style="color: white;" class="fa-solid fa-angle-right"></i>
                        </a> 
                        <a style="color: white;" href="ChiTietTruyenController?mt=<%=Truyen.getMaTruyen()%>">
	                        	<%=Truyen.getTenTruyen() %>
	                        <i style="color: white;" class="fa-solid fa-angle-right"></i>
                        </a>
                    </div>
						<div style="display: flex; align-items: center; justify-content: center;">
							<span> <select onchange="location=this.value;">
									<%
									ArrayList<ChuongBean> dsChuong = (ArrayList<ChuongBean>) request.getAttribute("dsChuong");
									int a = dsChuong.size();
									for (int i = 0; i < a; i++) {
										ChuongBean s = dsChuong.get(i);
										String selected = "";
										if (s.getMaChuong() == Long.parseLong(request.getParameter("mc"))) {
											selected = "selected";
										}
									%>
									<option value="HienThiAnhController?mc=<%=s.getMaChuong()%>&mt=<%=s.getMaTruyen()%>" <%=selected%>>
										<%=s.getTenChuong()%></option>
									<%} %>
							</select>
							</span>
						</div>
				</div>
			</div>
		</div>
	</div>
	<section class="blog-details spad" style="padding-top: 10px;">
		<div class="container">
			<div class="row d-flex justify-content-center">
				<div class="col-lg-8">
					<%
					ArrayList<AnhTruyenBean> dsAnh = (ArrayList<AnhTruyenBean>) request.getAttribute("dsAnh");
					int m = dsAnh.size();
					for (int i = 0; i < m; i++) {
						AnhTruyenBean Anh = dsAnh.get(i);
					%>
					<div class="blog__details__content">
						<img src="<%=Anh.getTenAnh()%>" alt="">
					</div>
					<%
					}
					%>
				</div>
			</div>
		</div>
	</section>
	<div>
		
		<div class="chapter-control">
			<a href="#" class="control-home"><i class="fa-solid fa-house"></i></a>
			<a href="#" class="control-next"><i class="fa-solid fa-angle-left"></i></a>
			<select class="custom-select">
			  <option value="option1">Option 1</option>
			  <option value="option2">Option 2</option>
			  <option value="option3">Option 3</option>
			</select>
			<a href="#" class="control-back"><i class="fa-solid fa-angle-right"></i></a>
			<input class="follow-btn" type="button" id="follow-btn" value="Theo Dõi"/> 
		</div>
		<script type="text/javascript">
		$(document).ready(function() {
			  $(".custom-select").select2({
			    dropdownCssClass: "dropup"
			  });
			});
		</script>
	</div>
	<div class="page-up">
			<a href="#" id="scrollToTopButton"><span class="arrow_carrot-up"></span></a>
		</div>

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