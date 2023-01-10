<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="ko">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<link
	href="https://fonts.googleapis.com/css2?family=Nanum+Gothic&family=Noto+Sans:wght@100&display=swap"
	rel="stylesheet">
<link rel="stylesheet" href="./css/reset.css">
<link rel="stylesheet" href="./css/login.css">
<!-- TODO: 이곳에 해당 jsp의 css 넣기 -->

<script src="./js/jquery-3.6.1.js"></script>
<!-- TODO: 이곳에 해당 jsp의 js 넣기 -->


<!-- 전체공통 -->
<style>
@import
	url('https://fonts.googleapis.com/css2?family=Noto+Sans+KR&display=swap')
	;

html, button, input, select, textarea, span, a, p {
	font-family: "Noto Sans KR", "malgun gothic", /*AppleGothic*/  dotum,
		sans-serif;
}
</style>
<title>로그인</title>
</head>
<body>
	<div class="main">
		<h1 class="logo">WithBooks</h1>
		<form action="login.do" method="post">
			<div class="container">
				<input type="text" placeholder="ID" id="mid" class="account">
				<input type="password" placeholder="Password" id="upw"
					class="account"> <input type="checkbox" id="saveid"><span>아이디
					저장</span> <a href="./findpw">비밀번호 찾기</a>
				<button type="submit" id="login_btn">
					<span>로그인</span>
				</button>
				<button type="button" id="join_btn" onclick="location.href='./join'">
					<span>회원가입</span>
				</button>
				<p id="alert" class=account></p>
			</div>
		</form>
	</div>
</body>
</html>