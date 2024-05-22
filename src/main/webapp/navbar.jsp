<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%@ taglib prefix="c" uri="jakarta.tags.core"%>
<%@ page isELIgnored="false"%>
<header class="header d-none d-lg-block">
	<!-- place navbar here -->
	<nav class="navbar navbar-expand-lg navbar-dark header__navbar p-md-0">
		<div class="container">
			<a class="navbar-brand" href="default.jsp"> <img
				src="./assets/images/t_logo.png" alt="Logo"
				class="img-fluid" style="width: 200px;">
			</a>
			<button class="navbar-toggler" type="button"
				data-bs-toggle="collapse" data-bs-target="#navbarSupportedContent"
				aria-controls="navbarSupportedContent" aria-expanded="false"
				aria-label="Toggle navigation">
				<span class="navbar-toggler-icon"></span>
			</button>
			<div class="collapse navbar-collapse" id="navbarSupportedContent">
				<ul class="navbar-nav me-auto mb-2 mb-lg-0">
					<li class="nav-item dropdown"><a
						class="nav-link dropdown-toggle" role="button"
						data-bs-toggle="dropdown" aria-expanded="false"> Thể loại </a>
						<ul class="dropdown-menu dropdown-menu-custom">
								<li><a class="dropdown-item" href="category?ct=Action">Action</a></li>
								<li><a class="dropdown-item" href="category?ct=Adventure">Adventure</a></li>
								<li><a class="dropdown-item" href="category?ct=Comedy">Comedy</a></li>
								<li><a class="dropdown-item" href="category?ct=Doujinshi">Doujinshi</a></li>
								<li><a class="dropdown-item" href="category?ct=Fantasy">Fantasy</a></li>
								<li><a class="dropdown-item" href="category?ct=Historical">Historical</a></li>
								<li><a class="dropdown-item" href="category?ct=Isekai">Isekai</a></li>
								<li><a class="dropdown-item" href="category?ct=Josei">Josei</a></li>
								<li><a class="dropdown-item" href="category?ct=Romance">Romance</a></li>
								<li><a class="dropdown-item" href="category?ct=Shonen">Shonen</a></li>
								<li><a class="dropdown-item" href="category?ct=Shoujo">Shoujo</a></li>
								<li><a class="dropdown-item" href="category?ct=Slice Of Life">Slice Of Life</a></li>
						</ul></li>
				</ul>

				<form class="d-flex header__form-search mx-1" action="searchByName" method="GET">
					<input class="form-control search-story" type="text"
						placeholder="Tìm kiếm theo tên" name="keyWord">
					<button class="btn" type="submit">
						<i class="fa-solid fa-magnifying-glass"></i>
					</button>
				</form>

			</div>
			<c:choose>
  			<c:when test="${not empty users}">
   			<a href="showsavedlist?id=${users.getId() }" class="users-icon">
   			<i class="fa-solid fa-user"></i> ${users.username }
   			</a>
   			<a href="logout" class="users-icon">
   			<i class="fa-solid fa-arrow-right-from-bracket fa-lg"></i>
   			</a>
  			</c:when>
  			<c:when test="${empty users}">
    		<a href="login.jsp">
			<button class="btnLogin-popup">Đăng nhập</button>
			</a>
  			</c:when>
  			<c:otherwise>
   			<a href="login.jsp">
			<button class="btnLogin-popup">Đăng nhập</button>
			</a>
  			</c:otherwise>
			</c:choose>
		</div>
	</nav>
</header>

<div class="bg-light header-bottom">
	<div class="container py-1">
		<p class="mb-0">Web Đọc Truyện Manga</p>
	</div>
</div>

