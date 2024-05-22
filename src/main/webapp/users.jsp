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
	<c:set var="userid" scope="page" value="${users.getId()}"></c:set>
	<div class="status">
		<c:if test="${not empty successMsg }">
			<div class="alert alert-success" role="alert">${successMsg }</div>
			<c:remove var="successMsg" scope="session" />
		</c:if>
		<c:if test="${not empty failedMsg }">
			<div class="alert alert-danger" role="alert">${failedMsg }</div>
			<c:remove var="failedMsg" scope="session" />
		</c:if>
	</div>


	<main>
		<div class="container">
			<div class="row justify-content-md-center">
				<div class="card col-4" style="width: 24rem; margin-right: 15px;">
					<div class="card-body ">
						<h5 class="card-title">
							<i class="fa-solid fa-user"></i> ${users.username }
						</h5>
						<h6 class="card-subtitle mb-2 text-muted">Thông tin:</h6>
						<form method="post" action="updateUser" id="updateUser">
							<input type="hidden" name="id" value="${users.getId()}">
							<div class="input-box">
								<input type="email" name="email" id="email"
									value="${users.getEmail()}"> <label>Email</label>
							</div>
							<div class="input-box">
								<input type="text" name="username" id="username"
									value="${users.getUsername()}"> <label>Username</label>
							</div>
							<div class="input-box">
								<input type="password" name="newpassword" id="password">
								<label>Password mới</label>
							</div>
							<div class="input-box">
								<input type="password" name="prepassword" id="password">
								<label>Password cũ</label>
							</div>
							<button type="submit" class="btn_submit">Cập nhật</button>
						</form>
					</div>
				</div>
				<div class="card col-8" style="padding-bottom: 25px;">
					<div class="card-body">
						<h5 class="card-title">Đã lưu:</h5>
						<c:if test="${empty mgsavedObj }">
							<p class="text-center text-success text-muted">Bạn chưa lưu manga nào hết!!</p>
						</c:if>
						<c:if test="${not empty mgsavedObj }">
							<div class="list-story-in-category section-stories-save__list">
								<c:forEach items="${mgsavedObj}" var="manga" begin="0" end="11">
									<div class="story-item text-center">
										<a href="showManga?id=${manga.getId() }"
											class="d-block text-decoration-none">
											<div class="story-item__image">
												<img src="./assets/images/${manga.getMgImg() }"
													alt="${manga.getMgName() }" class="img-fluid" width="150"
													height="230" loading="lazy">
											</div>
											<h3 class="story-item__name text-one-row story-name">${manga.getMgName() }</h3>

										</a> <a href="delItem?iduser=${userid }&idmg=${manga.getId()}"
											class="btn d-inline btn-danger btn-sm ml-2">Xóa </a>
									</div>
								</c:forEach>
							</div>
						</c:if>
					</div>
				</div>
			</div>
			<div class="row">
				<div class="card">
					<div class="card-body">
						<h5 class="card-title">Đã đánh giá:</h5>
						<c:if test="${empty rateMap }">
							<p class="text-center text-success text-muted">Những manga bạn đánh giá
								sẽ hiễn thị ở đây. Và có vẻ là chưa có gì.</p>
						</c:if>
						<c:if test="${not empty rateMap }">
						<div class="section-stories-rate__list">
						<c:forEach items="${rateMap}" var="entry" begin="0" end="4">
							<div class="card mb-3 " style="max-width: 540px;">
								<div class="row g-0">
									<div class="col-md-2">
										<a href="showManga?id=${entry.getKey().getId() } "
											class="d-block text-decoration-none"> 
											<img src="./assets/images/${entry.getKey().getMgImg() }"
											alt="${entry.getKey().getMgName() }"
											class="img-fluid rounded-start" width="100" height="120"
											loading="lazy">
										</a>
									</div>
									<div class="col-md-10">
										<div class="card-body">
											<strong><h5 class="card-title">${entry.getKey().getMgName() }</h5></strong>
											<h6 class="card-title">${entry.getValue().getrPoint() } Điểm</h6>
											<p class="card-text">${entry.getValue().getrCmt() }</p>
											<a href="delRating?iduser=${userid }&idmg=${entry.getKey().getId()}"
												class="btn d-inline btn-danger btn-sm ml-2">Xóa </a>
										</div>
									</div>
								</div>
							</div>
						</c:forEach>
						</div>
						</c:if>
					</div>

				</div>
			</div>
		</div>
	</main>
	<%@include file="footer.jsp"%>
</body>
</html>