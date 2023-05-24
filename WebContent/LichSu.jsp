<!DOCTYPE html>
<%@page import="java.util.Date"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="bean.LichSuBean"%>
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

</head>

<style>
body{
	background: #aca9a9;
}
.fa {
	font-size: 20px;
	padding-right: 4px;
	padding-top: 1px;
}

table {
	width: 60%;
	margin: 50px auto;
	border-collapse: collapse;
	border-radius: 10px;
	overflow: hidden;
	box-shadow: 0 0 20px rgba(0, 0, 0, 0.15);
	background: lightgoldenrodyellow;
}

tr:nth-of-type(even) {
	background-color: #f3f3f3;
}
td {
	text-align: center;
	padding: 10px;
}

td:nth-of-type(1),
td:nth-of-type(3),
td:nth-of-type(5) {
	font-weight: bold;
}
table tr:first-child {
	background-color: #5b5b6d;
	color: white;
	font-size: 20px;
}

table td:nth-child(2n) {
	color: #999;
}
.form-history {
	background: #0b0c2a;
	padding-bottom: 1px;
	padding-top: 16px;
	min-height: 600px;
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

	<br>
	<div class="form-history">
		<table>
			<tr style="border: 1">
				<td><b style="color: white;">Truyện</b></td>
				<td></td>
				<td><b style="color: white;">Chương</b></td>
				<td></td>
				<td><b style="color: white;">Ngày xem</b></td>
			</tr>
			<%
			ArrayList<LichSuBean> dsLichSu = (ArrayList<LichSuBean>) request.getAttribute("lichsu");
				SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
				for (int i = 0; i < dsLichSu.size(); i++) {
					LichSuBean item = dsLichSu.get(i);
					Date thoiGian = item.getNgayXem();
					String thoiGianStr = sdf.format(thoiGian);
			%>
			<tr>
				<td>
					<span> <a style="color: #5d5d5d;" href="ChiTietTruyenController?mt=<%=item.getMaTruyen()%>"><%=item.getTruyen().getTenTruyen()%></a></span>
				</td>
				<td></td>
				<td>
				<span><a style="color: #5d5d5d;" href="HienThiAnhController?mt=<%=item.getMaTruyen()%>&mc=<%=item.getMaChuong()%>"><%=item.getChuong().getTenChuong()%></a></span>
				</td>
				<td></td>
				<td><span style="color: #5d5d5d;"><%=thoiGianStr%></span></td>
			</tr>
			<%
			}
			%>
		</table>
	</div>
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