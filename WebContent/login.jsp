<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Login</title>

    <link rel="stylesheet" href="CSS/style.css">
    <link rel="stylesheet" href="CSS/login.css">
    <script src="JS/jquery-3.6.0.min.js"></script>
    <script src="JS/login.js"></script>
</head>
<body>
    <div id="empty1"></div>
    <div id="empty2"></div>
    <div id="empty3"></div>
    <div id="empty4"></div>
    <div id="empty5"></div>

    <img src="IMAGES/unlock.png" id="icon">
	<%
		String s=(String)session.getAttribute("user");  
		if(s!=null && !s.equals("")){  
			response.sendRedirect("dashboard");
		}  
	%>
    <p id="heading">PasswordLess Authentication</p>
    <div id="container1">
        <h1>Login</h1>
        <input type="text" placeholder="Email ID" id="emailid">
        <input type="button" value="Login" onclick="login()" id="submitbtn">
        <p>Don't have an account? <a href="register.jsp">Register</a></p>
    </div>
    <div id="container2">
        <h1>OTP</h1>
        <div id="otpinputs">
            <input type="text" maxlength="1" onkeyup="document.getElementById('otp2').focus();" id="otp1">
            <input type="text" maxlength="1" onkeyup="document.getElementById('otp3').focus();" id="otp2">
            <input type="text" maxlength="1" onkeyup="document.getElementById('otp4').focus();" id="otp3">
            <input type="text" maxlength="1" onkeyup="document.getElementById('otp5').focus();" id="otp4">
            <input type="text" maxlength="1" onkeyup="document.getElementById('otp6').focus();" id="otp5">
            <input type="text" maxlength="1" onkeyup="validateOtp()" id="otp6">
        </div>
    </div>

</body>
</html>