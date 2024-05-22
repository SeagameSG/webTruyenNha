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
		<div class="section-stories-hot mb-3">
			<div class="container">
				<div class="row">
					<div class="head-title-global d-flex justify-content-between mb-2">
						<div
							class="col-6 col-md-4 col-lg-4 head-title-global__left d-flex align-items-center">
							<h2 class="me-2 mb-0 border-bottom border-secondary pb-1">
								<a href="#"
									class="d-block text-decoration-none text-dark fs-4 story-name"
									title="Truyện Hot">Truyện Hot</a>
							</h2>
							<i class="fa-solid fa-fire-flame-curved"></i>
						</div>
					</div>
				</div>
				<div class="row">
					<div class="col-12">
						<div class="section-stories-hot__list">
							<c:forEach var="manga" items="${hotmgObj }" begin="0" end="15">
								<div class="story-item">
									<div class="story-item__image">
										<a href="showManga?id=${manga.getId() }"
											class="d-block text-decoration-none"> <img
											src="./assets/images/${manga.getMgImg() }"
											alt="${manga.getMgName() }" class="img-fluid" width="150"
											height="230" loading="lazy">
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
								</div>
							</c:forEach>
						</div>

						<div class="section-stories-hot__list wrapper-skeleton d-none">
							<div class="skeleton"
								style="max-width: 150px; width: 100%; height: 230px;"></div>
							<div class="skeleton"
								style="max-width: 150px; width: 100%; height: 230px;"></div>
							<div class="skeleton"
								style="max-width: 150px; width: 100%; height: 230px;"></div>
							<div class="skeleton"
								style="max-width: 150px; width: 100%; height: 230px;"></div>
							<div class="skeleton"
								style="max-width: 150px; width: 100%; height: 230px;"></div>
							<div class="skeleton"
								style="max-width: 150px; width: 100%; height: 230px;"></div>
							<div class="skeleton"
								style="max-width: 150px; width: 100%; height: 230px;"></div>
							<div class="skeleton"
								style="max-width: 150px; width: 100%; height: 230px;"></div>
							<div class="skeleton"
								style="max-width: 150px; width: 100%; height: 230px;"></div>
							<div class="skeleton"
								style="max-width: 150px; width: 100%; height: 230px;"></div>
							<div class="skeleton"
								style="max-width: 150px; width: 100%; height: 230px;"></div>
							<div class="skeleton"
								style="max-width: 150px; width: 100%; height: 230px;"></div>
							<div class="skeleton"
								style="max-width: 150px; width: 100%; height: 230px;"></div>
							<div class="skeleton"
								style="max-width: 150px; width: 100%; height: 230px;"></div>
							<div class="skeleton"
								style="max-width: 150px; width: 100%; height: 230px;"></div>
							<div class="skeleton"
								style="max-width: 150px; width: 100%; height: 230px;"></div>
						</div>
					</div>
				</div>
			</div>
		</div>
		<div class="container">
			<div class="row align-items-start">
				<div class="col-12 col-md-8 col-lg-9">
					<div class="section-stories-new mb-3">
						<div class="row">
							<div
								class="head-title-global d-flex justify-content-between mb-2">
								<div
									class="col-6 col-md-4 col-lg-4 head-title-global__left d-flex align-items-center">
									<h2 class="me-2 mb-0 border-bottom border-secondary pb-1">
										<a href="#"
											class="d-block text-decoration-none text-dark fs-4 story-name"
											title="Truyện Mới">Truyện Mới</a>
									</h2>
								</div>

							</div>
						</div>

						<div class="row">
							<div class="col-12">
								<div class="section-stories-new__list">
								<c:forEach var="entry" items="${newmgMap }" begin="0" end="7">
									<div class="story-item-no-image">
										<div class="story-item-no-image__name d-flex align-items-center">
											<h3 class="me-1 mb-0 d-flex align-items-center">
												<svg style="width: 10px; margin-right: 5px;"
													xmlns="http://www.w3.org/2000/svg" height="1em"
													viewBox="0 0 320 512">
													<!--! Font Awesome Free 6.4.2 by @fontawesome - https://fontawesome.com License - https://fontawesome.com/license (Commercial License) Copyright 2023 Fonticons, Inc. -->
													<path
														d="M278.6 233.4c12.5 12.5 12.5 32.8 0 45.3l-160 160c-12.5 12.5-32.8 12.5-45.3 0s-12.5-32.8 0-45.3L210.7 256 73.4 118.6c-12.5-12.5-12.5-32.8 0-45.3s32.8-12.5 45.3 0l160 160z">
													</path>
												</svg>
												<a href="showManga?id=${entry.getKey().getId() }"
													class="text-decoration-none text-dark fs-6 hover-title text-one-row story-name">${entry.getKey().getMgName() }</a>
											</h3>
											<c:forEach items="${entry.getKey().getEachStatus() }" var="mgstatus">
													<c:choose>
														<c:when test="${mgstatus eq \"FULL\"}">
															<span class="badge text-bg-success text-light me-1">Full</span>
														</c:when>
														<c:when test="${mgstatus eq \"HOT\"}">
															<span
																class="badge text-bg-danger text-light me-1">Hot</span>
														</c:when>
														<c:when test="${mgstatus eq \"NEW\"}">
															<span class="badge text-bg-info text-light me-1">New</span>
														</c:when>
													</c:choose>
											</c:forEach>
										</div>

										<div
											class="story-item-no-image__categories ms-2 d-none d-lg-block">
											<p class="mb-0">
											<c:forEach items="${entry.getKey().getEachCategory() }" var="ct">
												<a href="category?ct=${ct }"
													class="hover-title text-decoration-none text-dark category-name">${ct } </a>
											</c:forEach>
											</p>
										</div>
										<div class="story-item-no-image__chapters ms-2">
											<a href="showchapter?stt=${entry.getValue().getCtOrdN() }&idmg=${entry.getKey().getId()}"
												class="hover-title text-decoration-none text-info">${entry.getValue().getCtName() }</a>
										</div>
									</div>
									</c:forEach>
								</div>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>

		<div class="section-stories-full mb-3 mt-3">
			<div class="container">
				<div class="row">
					<div class="head-title-global d-flex justify-content-between mb-2">
						<div class="col-12 col-md-4 head-title-global__left d-flex">
							<h2 class="me-2 mb-0 border-bottom border-secondary pb-1">
								<span
									class="d-block text-decoration-none text-dark fs-4 title-head-name"
									title="Truyện đã hoàn thành">Truyện đã hoàn thành</span>
							</h2>
						</div>
					</div>
				</div>

				<div class="row">
					<div class="col-12">
						<div class="section-stories-full__list">
							<c:forEach var="manga" items="${fullmgObj }" begin="0" end="15">
								<div class="story-item-full text-center">
									<a href="showManga?id=${manga.getId() }" class="d-block story-item-full__image"> <img
										src="./assets/images/${manga.getMgImg() }"
										alt="${manga.getMgName() }" class="img-fluid w-100"
										width="150" height="230" loading="lazy">
									</a>
									<h3 class="fs-6 story-item-full__name fw-bold text-center mb-0">
										<a href="showManga?id=${manga.getId() }"
											class="text-decoration-none text-one-row story-name">
											${manga.getMgName() } </a>
									</h3>
									<span class="story-item-full__badge badge text-bg-success">Full</span>
								</div>
							</c:forEach>
						</div>
					</div>
				</div>
			</div>
		</div>
	</main>

	<%@include file="footer.jsp"%>

	<div id="loadingPage" class="loading-full">
		<div class="loading-full_icon">
			<div class="spinner-grow">
				<span class="visually-hidden">Loading...</span>
			</div>
		</div>
	</div>



</body>

</html>