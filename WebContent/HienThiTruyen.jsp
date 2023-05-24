<!DOCTYPE html>
<%@page import="java.util.Random"%>
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
<link rel="stylesheet" href="css/fontawesome-free-6.2.1-web/css/all.min.css">
<link rel="stylesheet" href="css/elegant-icons.css" type="text/css">
<link rel="stylesheet" href="css/plyr.css" type="text/css">
<link rel="stylesheet" href="css/nice-select.css" type="text/css">
<link rel="stylesheet" href="css/owl.carousel.min.css" type="text/css">
<link rel="stylesheet" href="css/slicknav.min.css" type="text/css">
<link rel="stylesheet" href="css/style.css" type="text/css">

</head>
<style>
.pagination {
	display: inline-block;
}

.pagination a {
	color: white;
	float: left;
	padding: 8px 16px;
	text-decoration: none;
	transition: background-color .3s;
	border: 1px solid #ddd;
	border-radius: 6px;
	margin: 0 4px;
}

.pagination a.active {
	background-color: #4CAF50;
	color: white;
	border: 1px solid #4CAF50;
}

.pagination a:hover:not(.active) {
	background-color: #ddd;
}

.product__item {
	transition: transform ease-in 0.1s;
	will-change: transform;
}

.product__item:hover {
	opacity: 0.9;
	transform: translateY(-4px);
}

.text-name {
	color: while;
	text-shadow: 1px 1px 0.7px black;
}

.fa {
	font-size: 20px;
	padding-right: 4px;
	padding-top: 1px;
}
.hero__text a i {
    font-size: 20px;
    display: inline-block;
    background-image: linear-gradient(0, #fd6232, #49a0f8);
    padding: 11px 5px 16px 8px;
    color: #ffffff;
    border-radius: 0 4px 4px 0;
}
</style>
<body>
	<!-- Page Preloder -->
	<div id="preloder">
		<div class="loader"></div>
	</div>

	<jsp:include page="Header.jsp"></jsp:include>

	<!-- Hero Section Begin -->
	<section class="hero" style="padding-top: 100px">
		<div class="container">
			<div class="hero__slider owl-carousel">
				<%
				ArrayList<TruyenBean> dsUpDown = (ArrayList<TruyenBean>) request.getAttribute("dsUpDown");
				int k = dsUpDown.size();
				for (int i = 0; i < 5; i++) {
					TruyenBean s = dsUpDown.get(i);
				%>
				<div class="hero__items set-bg" data-setbg="<%=s.getAnhNen()%>">
					<div class="row">
						<div class="col-lg-6">
							<div class="hero__text">
								<div class="label" style="border-radius: 5px; background-image: linear-gradient(0, #d8cbc7, #49a0f8); color: white;"><%=s.getMaTheLoai()%></div>
								<h2 class="text-name"><%=s.getTenTruyen()%></h2>
								<p style="color: #FFF8DC; text-shadow: 1px 1px 0.7px black;">Truyện Hot !!!</p>
								<a href="ChiTietTruyenController?mt=<%=s.getMaTruyen()%>">
									<span style="background-image: linear-gradient(0, #fd6232, #49a0f8);">Đọc ngay</span> <i class="fa fa-angle-right"></i></a>
							</div>
						</div>
					</div>
				</div>
				<%
				}
				%>
			</div>
		</div>
	</section>
	<!-- Hero Section End -->
	<section class="product spad" style="padding-top: 60px">
		<div class="container">
			<div class="row">
				<div class="col-lg-12">
					<div class="trending__product">
						<div class="row">
							<div class="col-lg-8 col-md-8 col-sm-8">
								<div class="section-title" style="display: flex; align-items: center;margin-bottom: 20px;">
									<h4>Truyện mới</h4>
									<div style="color: wheat;font-size: 30px;margin: 0px 0px 5px 10px;">
										<i class="fa-solid fa-book-open-reader"></i>
									</div>
								</div>
							</div>
						</div>
						<div class="row">
							<%
							request.setCharacterEncoding("utf-8");
							response.setCharacterEncoding("utf-8");
							ArrayList<TruyenBean> dsPhanTrang = (ArrayList<TruyenBean>) request.getAttribute("dsPhanTrang");
							ArrayList<Integer> dsSoCmt = (ArrayList<Integer>) request.getAttribute("countCmt");
							ArrayList<Integer> dsSoChuong = (ArrayList<Integer>) request.getAttribute("countChuong");
							int n = dsPhanTrang.size();
							for (int i = 0; i < n; i++) {
								int countCmt = dsSoCmt.get(i);
								int countChapter = dsSoChuong.get(i);
								TruyenBean s = dsPhanTrang.get(i);
							%>

							<div class="col-lg-3 col-md-4 col-sm-6">
								<div class="product__item">
									<div class="product__item__pic set-bg" data-setbg="">
										<a href="ChiTietTruyenController?mt=<%=s.getMaTruyen()%>">
											<img alt="" src="<%=s.getAnhTruyen()%>"
											style="width: 300px; height: 335px; border-radius: 10px"
											onerror="this.onerror=null; this.src='Avatar/default-image.jpg';">
										</a>
										<%
										if (s.isHoanThanh() == false) {
										%>
										<div class="ep"><%=countChapter%> / ?</div>
										<%
										} else {
										%>
										<div class="ep"><%=countChapter%> / <%=countChapter%></div>
										<%
										}
										%>
										<div class="comment"><i class="fa fa-comments"></i><%=countCmt%></div>
										<div class="view"><i class="fa fa-eye"></i><%=s.getLuotXem()%></div>
									</div>
									<div class="product__item__text">
										<ul>
											<li><%=s.getMaTheLoai()%></li>
										</ul>
										<h5>
											<a href="ChiTietTruyenController?mt=<%=s.getMaTruyen()%>"><%=s.getTenTruyen()%></a>
										</h5>
									</div>
								</div>
							</div>
							<%
							}
							%>
						</div>
						<div class="row">
							<div class="col-lg-8 col-md-8 col-sm-8">
								<div class="section-title" style="display: flex; align-items: center;margin-bottom: 20px;">
									<h4>Truyện ngẫu nhiên </h4>
									<div style="color: wheat;font-size: 30px;margin: 0px 0px 10px 10px;">
										<i class="fa-solid fa-dice"></i>
									</div>
								</div>
							</div>
						</div>
						<div class="row">
						<%	ArrayList<TruyenBean> ds = (ArrayList<TruyenBean>)request.getAttribute("dsTruyen");
							ArrayList<Integer> dsAllSoCmt = (ArrayList<Integer>) request.getAttribute("countAllCmt");
							ArrayList<Integer> dsAllSoChuong = (ArrayList<Integer>) request.getAttribute("countAllChuong");
							int m =ds.size();
							Random rand = new Random(); 
							for (int i = 0; i < 4; i++) { 
							int randomIndex = rand.nextInt(m); 
							int countCmt = dsAllSoCmt.get(randomIndex); 
							int countChapter = dsAllSoChuong.get(randomIndex);
							TruyenBean s = ds.get(randomIndex); 
						%> 

						<div class="col-lg-3 col-md-4 col-sm-6"> 
								<div class="product__item"> 
									<div class="product__item__pic set-bg" data-setbg=""> 
 										<a href="ChiTietTruyenController?mt=<%=s.getMaTruyen()%>"> 
											<img alt="" src="<%=s.getAnhTruyen()%>" 
											style="width: 300px; height: 335px; border-radius: 10px" 
											onerror="this.onerror=null; this.src='Avatar/default-image.jpg';"> 
										</a>
										<%
										if (s.isHoanThanh() == false) {
										%>
										<div class="ep"><%=countChapter%> / ?</div>
										<%
										} else {
										%>
										<div class="ep"><%=countChapter%> / <%=countChapter%></div>
										<%
										}
										%> 
										<div class="comment"><i class="fa fa-comments"></i><%=countCmt%></div> 
										<div class="view"> <i class="fa fa-eye"></i> <%=s.getLuotXem()%></div> 
									</div> 
									<div class="product__item__text"> 
										<ul> 
											<li><%=s.getMaTheLoai()%></li> 
 										</ul> 
										<h5>
 											<a href="ChiTietTruyenController?mt=<%=s.getMaTruyen()%>"><%=s.getTenTruyen()%></a> 
										</h5> 
								</div> 
								</div> 
							</div> 

							<% 
								}
							%> 
						</div>
						<div class="row" style="justify-content: center;">
							<div class="">
								<div class="pagination">
									<a href="#">&laquo;</a> 
									<% 	int soTrang = (int)request.getAttribute("soTrang");
										String TenTruyen = (String)request.getAttribute("TenTruyen");
										String MaTheLoai = (String)request.getAttribute("MaTheLoai");
										for(int i = 1; i<=soTrang; i++){%>
									  <a class="" href="HienThiTruyenController?index=<%=i%>&TenTruyen=<%=TenTruyen%>&MaTheLoai=<%=MaTheLoai%>"> <%=i %> </a>
									 <%} %>
									<a href="#">&raquo;</a>
								</div>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
	</section>
	
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