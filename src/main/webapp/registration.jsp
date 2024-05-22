<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core"%>
<%@ page isELIgnored="false" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Register</title>
<%@include file="cssLink.jsp"%>
</head>
<body>
	<div class="form-container">
		<div class="wrapper">
			<div class="form-box register">
				<h2>Đăng ký</h2>
				<form method="post" action="register" id="register">
					<div class="input-box">
						<input type="email" name="email" id="email" required> <label>Email</label>
					</div>
					<div class="input-box">
						<input type="text" name="username" id="username" required>
						<label>Username</label>
					</div>
					<div class="input-box">
						<input type="password" name="password" id="password" required>
						<label>Password</label>
					</div>
					<button type="submit" class="btn_submit">Đăng ký</button>
					<div class="login-register">
						<p>
							Bạn đã có tài khoản? <a href="login.jsp" class="login-link">Đăng
								nhập</a>
						</p>
					</div>
				</form>
				<div class="status">
					<c:if test="${not empty successMsg }">
						<p class="text-center text-success">${successMsg }</p>
						<c:remove var="successMsg" scope="session"/>
					</c:if>
					<c:if test="${not empty failedMsg }">
						<p class="text-center text-danger">${failedMsg }</p>
						<c:remove var="failedMsg" scope="session"/>
					</c:if>
				</div>
			</div>
		</div>
	</div>

</body>
</html>