<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core"%>
<%@ page isELIgnored="false"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">

<%@ include file="cssLink.jsp"%>
<title>Login</title>
</head>
<body>
	<div class="form-container">
		<div class="wrapper">
			<div class="form-box login">
				<h2>Đăng nhập</h2>
				<form method="post" action="login" id="login">
					<div class="input-box">
						<input type="text" name="username" id="username" required>
						<label>Username</label>

					</div>
					<div class="input-box">
						<input type="password" name="password" id="password" required>
						<label>Password</label>
					</div>
					<button type="submit" class="btn_submit">Đăng nhập</button>
					<div class="login-register">
						<p>
							Bạn chưa có tài khoản? <a href="registration.jsp"
								class="register-link">Đăng ký</a>
						</p>
					</div>
				</form>
				<div class="status">
					<c:if test="${not empty failedMsg }">
						<p class="text-center text-danger">${failedMsg }</p>
						<c:remove var="failedMsg" scope="session" />
					</c:if>
				</div>
			</div>
		</div>
	</div>
</body>
</html>