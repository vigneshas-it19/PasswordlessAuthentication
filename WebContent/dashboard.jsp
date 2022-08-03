<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title id="title">
		<%
				String s=(String)session.getAttribute("user");  
				if(s!=null && !s.equals("")){  
					out.print(s);
				}
		%>
	</title>
	
	<link rel="stylesheet" href="CSS/dashboard.css">
    <script src="JS/jquery-3.6.0.min.js"></script>
	<script src="JS/dashboard.js"></script>
</head>
<body>
	<div id="header">
		<h1 id="name"></h1>
		<input type="button" onclick="window.location.href='logout'" value="Logout" id="logoutBtn">
	</div>
	
</body>
</html>