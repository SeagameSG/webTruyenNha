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
			<div class="row align-items-start">
				<div class="col-12">
					<div class="head-title-global d-flex justify-content-between mb-2">
						<div
							class="col-12 col-md-12 col-lg-12 head-title-global__left d-flex">
							<h2 class="me-2 mb-0 border-bottom border-secondary pb-1">
								<span
									class="d-block text-decoration-none text-dark fs-4 category-name"
									title="Title">${category }</span>
							</h2>
						</div>
					</div>
					<div class="list-story-in-category section-stories-save__list">
						<c:if test="${empty mangaObj}">
							<p class="text-center text-success">Không tìm thấy!!</p>
						</c:if>
						<c:forEach items="${mangaObj }" var="manga">
							<div class="story-item">
								<a href="showManga?id=${manga.getId() }"
									class="d-block text-decoration-none">
									<div class="story-item__image">
										<img src="./assets/images/${manga.getMgImg() }"
											alt="${manga.getMgName() }" class="img-fluid" width="150"
											height="230" loading="lazy">
									</div>
									<h3 class="story-item__name text-one-row story-name">${manga.getMgName() }</h3>

									<div class="list-badge">
										<c:forEach items="${manga.getEachStatus() }" var="mgstatus">
											<c:choose>
												<c:when test="${mgstatus eq \"FULL\"}">
													<span class="story-item__badge badge text-bg-success">Full</span>
												</c:when>
												<c:when test="${mgstatus eq \"HOT\"}">
													<span
														class="story-item__badge story-item__badge-hot badge text-bg-danger">Hot</span>
												</c:when>
												<c:when test="${mgstatus eq \"NEW\"}">
													<span
														class="story-item__badge story-item__badge-new badge text-bg-info text-light">New</span>
												</c:when>
											</c:choose>
										</c:forEach>
									</div>
								</a>
							</div>
						</c:forEach>
					</div>
				</div>
			</div>
		</div>
	</main>
	<%@include file="footer.jsp"%>
</body>
</html>