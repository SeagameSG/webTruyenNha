<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core"%>
<%@ page isELIgnored="false"%>
<!DOCTYPE html>
<html lang="en">

<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

<%@include file="cssLink.jsp"%>

<title>Truyện Nha</title>
<meta name="description" content="Đọc truyện online">
</head>

<body>
	<%@include file="navbar.jsp"%>
	<main>
		<div class="container">
			<div class="d-flex justify-content-center align-items-center">
				<form action="postRate" method="get" style="width: 60%;">
					<h1>${mgName }</h1>
					<h2>Form Đánh giá:</h2>
					<select class="form-select" aria-label="Point" name="point">
						<option selected value="0">Điểm Đánh giá</option>
						<option value="1">1</option>
						<option value="2">2</option>
						<option value="3">3</option>
						<option value="4">4</option>
						<option value="5">5</option>
						<option value="6">6</option>
						<option value="7">7</option>
						<option value="8">8</option>
						<option value="9">9</option>
						<option value="10">10</option>
					</select>
					<div class="form-floating">
						<textarea name="comment" class="form-control" placeholder="Bình luận đánh giá"
							id="floatingTextarea2" style="height: 100px"></textarea>
						<label for="floatingTextarea2">Comments</label>
					</div>
					<button type="submit" class="btn btn-success m-1">Đánh giá</button>
					<input type="hidden" value="${iduser }" name="iduser">
					<input type="hidden" value="${idmg }" name="idmg">
				</form>
			</div>
		</div>
	</main>
	<%@include file="footer.jsp"%>
</body>
</html>