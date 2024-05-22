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
			<div class="row align-items-start">
				<div class="col-12 col-md-7 col-lg-8">
					<div class="head-title-global d-flex justify-content-between mb-4">
						<div
							class="col-12 col-md-12 col-lg-4 head-title-global__left d-flex">
							<h2 class="me-2 mb-0 border-bottom border-secondary pb-1">
								<span
									class="d-block text-decoration-none text-dark fs-4 title-head-name"
									title="Thông tin truyện">Thông tin truyện</span>
							</h2>
						</div>
					</div>

					<div class="story-detail">
						<div class="story-detail__top d-flex align-items-start">
							<div class="row align-items-start">
								<div class="col-12 col-md-12 col-lg-3 story-detail__top--image">
									<div class="book_avatar">
										<img src="./assets/images/${mangaObj.getMgImg() }"
											alt="${mangaObj.getMgName() }" class="img-fluid w-100"
											width="200" height="300" loading="lazy">
									</div>
								</div>
								<div class="col-12 col-md-12 col-lg-9">
									<h3 class="text-center story-name">${mangaObj.getMgName() }</h3>
									<div class="rate-story mb-2">
										<div class="rate-story__holder">

											<c:set var="rating" value="${mangaObj.getMgPoint() }" />
											<c:forEach var="i" begin="1" end="${rating / 1 }">
												<img alt="star-on" src="./assets/images/star-on.png">
											</c:forEach>
											<c:if test="${rating % 1 > 0}">
												<img alt="star-half" src="./assets/images/star-half.png">
												<c:forEach var="i" begin="${(rating / 1) + 2}" end="10">
													<img alt="star-off" src="./assets/images/star-off.png">
												</c:forEach>
											</c:if>
											<c:if test="${rating % 1 == 0}">
												<c:forEach var="i" begin="${(rating / 1) + 1}" end="10">
													<img alt="star-off" src="./assets/images/star-off.png">
												</c:forEach>
											</c:if>
										</div>
										<em class="rate-story__text"></em>
										<div class="rate-story__value">
											<em>Điểm Đánh giá: <strong> <span
													itemprop="ratingValue">${mangaObj.getMgPoint() }</span>
											</strong> / <strong> <span itemprop="ratingCount">${mangaObj.getMgRateNum() }</span>
													lượt
											</strong>
											</em>
										</div>
									</div>

									<div class="story-detail__top--desc px-3"
										style="max-height: 285px;">${mangaObj.getMgDetail() }</div>

								</div>
							</div>
						</div>

						<div class="story-detail__bottom m-3">
							<div class="row">
								<div
									class="col-12 col-md-12 col-lg-3 story-detail__bottom--info">

									<div class="d-flex align-items-center mb-1 flex-wrap">
										<strong class="me-1">Thể loại:</strong>
										<div class="d-flex align-items-center flex-warp">
											<c:forEach items="${mangaObj.getEachCategory() }" var="ct">
												<a href="category?ct=${ct }"
													class="text-decoration-none text-dark hover-title  me-1 "
													style="width: max-content;">${ct }</a>
											</c:forEach>
										</div>
									</div>

									<p class="mb-1">
										<strong>Trạng thái:</strong> <span class="text-info">${mangaObj.getMgStatus() }</span>
									</p>
									<c:if test="${not empty users}">
										<a
											href="save?iduser=${users.getId()}&idmg=${mangaObj.getId()}"
											class="btn btn-danger m-1">Lưu Manga</a>
										<a
											href="rating?iduser=${users.getId()}&idmg=${mangaObj.getId()}"
											class="btn btn-success m-1">Đánh giá</a>
									</c:if>
									<c:if test="${empty users}">
										<a href="login.jsp" class="btn btn-danger m-1">Lưu Manga</a>
										<a href="login.jsp" class="btn btn-success m-1">Đánh giá</a>
									</c:if>

								</div>

							</div>
						</div>

						<div class="story-detail__list-chapter">
							<div
								class="head-title-global d-flex justify-content-between mb-4">
								<div
									class="col-6 col-md-12 col-lg-4 head-title-global__left d-flex">
									<h2 class="me-2 mb-0 border-bottom border-secondary pb-1">
										<span
											class="d-block text-decoration-none text-dark fs-4 title-head-name"
											title="Truyện">Danh sách chương</span>
									</h2>
								</div>
							</div>

							<div class="story-detail__list-chapter--list">
								<div class="row">
									<div
										class="col-12 col-sm-6 col-lg-6 story-detail__list-chapter--list__item">
										<ul>
											<c:set var="idmg" scope="page" value="${mangaObj.getId()}"></c:set>
											<c:forEach items="${mangaObj.getMgChapter() }" var="chapter"
												begin="0" end="20">
												<li><a
													href="showchapter?stt=${chapter.getCtOrdN() }&idmg=${idmg}"
													class="text-decoration-none text-dark hover-title">${chapter.getCtName() }</a>
												</li>
											</c:forEach>
										</ul>

									</div>
									<div
										class="col-12 col-sm-6 col-lg-6 story-detail__list-chapter--list__item">
										<ul>
											<c:forEach items="${mangaObj.getMgChapter() }" var="chapter"
												begin="21" end="41">
												<li><a
													href="showchapter?stt=${chapter.getCtOrdN() }&idmg=${idmg}"
													class="text-decoration-none text-dark hover-title">${chapter.getCtName() }</a>
												</li>
											</c:forEach>
										</ul>
									</div>
								</div>
								<div class="row">
									<div class="dropup-center dropup m-3">
										<button class="btn btn-success dropdown-toggle" type="button"
											data-bs-toggle="dropdown" aria-expanded="false">Tìm
											Chương Cũ</button>
										<div class="dropdown-menu">
											<div class="d-flex text-center">
												<form action="showchapter" method="get">
													<p class="text-center text-muted" style="font-size: .8rem;">Nhập
														số:</p>
													<div class="invalid-feedback"
														data-validation-message="Chỉ nhập số"></div>
													<input type="number" name="stt" id="number"
														class="form-control" value="1" pattern="^[0-9]+$" required />
													<button type="submit" class="btn btn-success m-1">Đi</button>
													<input type="hidden" name="idmg" value="${idmg}">
												</form>
											</div>
										</div>
									</div>
								</div>
							</div>
						</div>
						<div class="row">
							<div class="card">
								<div class="card-body">
									<h5 class="card-title">Các đánh giá:</h5>
									<c:if test="${empty rateList }">
										<p class="text-center text-success text-muted">Chưa có
											đánh giá nào!</p>
									</c:if>
									<c:if test="${not empty rateList }">
										<div class="section-stories-rate__list">
											<c:forEach items="${rateList}" var="entry" begin="0" end="9">
												<div class="card mb-3" style="max-width: 540px;">
													<div class="row g-0">
														<div class="col-md-12">
															<div class="card-body">
																<strong><h5 class="card-title">
																		<i class="fa-solid fa-user"></i> ${entry.getKey() }
																	</h5></strong>
																<h6 class="card-title">${entry.getValue().getrPoint() }
																	Điểm</h6>
																<p class="card-text">${entry.getValue().getrCmt() }</p>
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
				</div>

				<div class="col-12 col-md-5 col-lg-4 sticky-md-top">

					<div class="row top-ratings">
						<div class="col-12 top-ratings__content">
							<div class="content">
								<h4 class="me-2 mb-0 border-bottom border-secondary pb-1">
									<span
										class="d-block text-decoration-none text-dark fs-4 title-head-name">Top
										Rating:</span>
								</h4>
								<ul>
									<c:forEach items="${toprt }" var="manga" varStatus="status"
										step="1" begin="0" end="9">
										<li>
											<div class="rating-item d-flex align-items-center">
												<c:if test="${status.index eq 0 }">
												<div class="rating-item__number bg-danger rounded-circle">
														<span class="text-light">${status.index + 1 }</span>
												</div>
												</c:if>
												<c:if test="${status.index eq 1 }">
												<div class="rating-item__number bg-success rounded-circle">
														<span class="text-light">${status.index + 1 }</span>
												</div>
												</c:if>
												<c:if test="${status.index eq 2 }">
												<div class="rating-item__number bg-info rounded-circle">
														<span class="text-light">${status.index + 1 }</span>
												</div>
												</c:if>
												<c:if test="${status.index > 2  }">
												<div class="rating-item__number bg-light rounded-circle">
														<span class="text-dark">${status.index + 1 }</span>
												</div>
												</c:if>
												
												<div class="rating-item__story">
													<a href="showManga?id=${manga.getId() }"
														class="text-decoration-none hover-title rating-item__story--name text-one-row">${manga.getMgName()}:
														${manga.getMgPoint()}</a>
													<div
														class="d-flex flex-wrap rating-item__story--categories">
														<c:forEach items="${manga.getEachCategory() }" var="ctmgr">
															<a href="category?ct=${ctmgr }"
																class="text-decoration-none text-dark hover-title  me-1 "
																style="width: max-content;">${ctmgr }</a>
														</c:forEach>
													</div>
												</div>
											</div>
										</li>
									</c:forEach>
								</ul>

							</div>
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