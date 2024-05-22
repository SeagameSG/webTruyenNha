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
		<div class="chapter-wrapper container my-5">
			<h1 class="text-center text-success">${mangaObj.getMgName()} - ${chapter.getCtName() }</h1>
			<p class="text-center text-dark"></p>
			<c:set var="idmg" scope="page" value="${mangaObj.getId()}"></c:set>


			<hr class="chapter-start container-fluid">
			<div class="chapter-nav text-center">
				<div
					class="chapter-actions chapter-actions-origin d-flex align-items-center justify-content-center">

					<c:if test="${not empty hasPrevChapter }">
						<a class="btn btn-success me-1 chapter-prev"
							href="showchapter?stt=${chapter.getCtOrdN() - 1}&idmg=${idmg}">
							Chương trước </a>
					</c:if>

					<c:if test="${empty hasPrevChapter }">
						<a class="btn btn-success me-1 chapter-prev disabled" href="#"
							aria-disabled="true">Chương trước </a>
					</c:if>


					<div class="dropup-center dropup m-3">
						<button class="btn btn-success dropdown-toggle" type="button"
							data-bs-toggle="dropdown" aria-expanded="false">Tìm Chương</button>
						<div class="dropdown-menu">
							<div class="d-flex text-center">
								<form action="showchapter" method="get">
									<p class="text-center text-muted" style="font-size: 1rem;">Nhập số:</p>
									<div class="invalid-feedback" data-validation-message="Chỉ nhập số"></div>
									<input type="number" name="stt" id="number" class="form-control" value="1" pattern="^[0-9]+$" required />
									<button type="submit" class="btn btn-success m-1">Đi</button>
									<input type="hidden" name="idmg" value="${idmg}">
								</form>
							</div>
						</div>
					</div>

					<c:if test="${not empty hasNextChapter }">
						<a class="btn btn-success chapter-next"
							href="showchapter?stt=${chapter.getCtOrdN() + 1 }&idmg=${idmg}"
							title="">Chương tiếp</a>
					</c:if>

					<c:if test="${empty hasNextChapter }">
						<a class="btn btn-success chapter-next disabled" href="#"
							aria-disabled="true">Chương tiếp
						</a>
					</c:if>
					
				</div>
			</div>
			<hr class="chapter-start container-fluid">

			<div class="chapter-content mb-3">
				<c:set var="imgpack" value="${chapter.getCtImgPack() }"></c:set>
				<c:forEach var="i" varStatus="status" step="1" begin="1"
					end="${chapter.getCtImgN() }">
					<div id="page_${status.index }" class="page-chapter text-center">
						<img alt="content" src="./mgpack/${imgpack}/${status.index }.jpg">
					</div>
				</c:forEach>
			</div>

			<hr class="chapter-end container-fluid">
			<div class="chapter-nav text-center">
				<div
					class="chapter-actions chapter-actions-origin d-flex align-items-center justify-content-center">
					<c:if test="${empty hasPrevChapter }">
						<a class="btn btn-success me-1 chapter-prev disabled" href="#"
							aria-disabled="true">Chương trước
						</a>
					</c:if>
					<c:if test="${not empty hasPrevChapter }">
						<a class="btn btn-success me-1 chapter-prev"
							href="showchapter?stt=${chapter.getCtOrdN() - 1}&idmg=${idmg}">
							Chương trước
						</a>
						<c:remove var="hasPrevChapter" scope="session"/>
					</c:if>
					<div class="dropup-center dropup m-3">
						<button class="btn btn-success dropdown-toggle" type="button"
							data-bs-toggle="dropdown" aria-expanded="false">Tìm Chương</button>
						<div class="dropdown-menu">
							<div class="d-flex text-center">
								<form action="showchapter" method="get">
									<p class="text-center text-muted" style="font-size: 1rem;">Nhập số:</p>
									<div class="invalid-feedback" data-validation-message="Chỉ nhập số"></div>
									<input type="number" name="stt" id="number" class="form-control" value="1" pattern="^[0-9]+$" required />
									<button type="submit" class="btn btn-success m-1">Đi</button>
									<input type="hidden" name="idmg" value="${idmg}">
								</form>
							</div>
						</div>
					</div>
					<c:if test="${empty hasNextChapter }">
						<a class="btn btn-success chapter-next disabled" href="#"
							aria-disabled="true">Chương tiếp
						</a>

					</c:if>
					<c:if test="${not empty hasNextChapter }">
						<a class="btn btn-success chapter-next"
							href="showchapter?stt=${chapter.getCtOrdN() + 1}&idmg=${idmg}"
							title="">Chương tiếp</a>
						<c:remove var="hasNextChapter" scope="session"/>
					</c:if>
				</div>
			</div>
			<hr class="chapter-end container-fluid">
		</div>

	</main>
	<%@include file="footer.jsp"%>
</body>
</html>