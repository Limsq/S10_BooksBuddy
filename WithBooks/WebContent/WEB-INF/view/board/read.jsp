<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="ko">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
	<link href="https://fonts.googleapis.com/css2?family=Nanum+Gothic&family=Noto+Sans:wght@100&display=swap" rel="stylesheet">
    <link rel="stylesheet" href="./css/reset.css" type="text/css">
	<link rel="stylesheet" href="./css/main.css" type="text/css">
	<!-- TODO: 이곳에 해당 jsp의 css 넣기 -->
    <link href="css/notice.css" rel="stylesheet" type="text/css">
    <script src="./js/jquery-3.6.1.js"></script>
    <script src="./js/header.js"></script>
    <!-- TODO: 이곳에 해당 jsp의 js 넣기 -->
    

    <!-- 전체공통 -->
    <style>
        @import url('https://fonts.googleapis.com/css2?family=Noto+Sans+KR&display=swap');
        html, button, input, select, textarea, span, a, p {
            font-family: "Noto Sans KR", "malgun gothic", /*AppleGothic*/dotum, sans-serif;
        }
    </style>
    <title>글목록</title>
</head>
<body>
    <div>
    <%@include file="/WEB-INF/view/header.jsp" %>
             <div class="notice">
                 <div class="notice_header_wrapper"> <!-- flex -->
                     <div class="notice_header_text_wrapper"> <!-- flex -->
                         <h2 class="notice_header_text_1">${board.rpno }</h2>
                         <span class="notice_header_text_2">${board.rpdate }</span>
                         <button type="button" onclick="location.href='noticeWrite?bno=${board.bno }'">답글쓰기</button>
                     </div>
                 </div>
				<ul class="notice_post_wrapper"> <!-- flex -->
					<li>
					        <div class="post_wrapper"> <!-- flex -->
					<div >제목</div>
					   <div class="post_content">${board.btitle }</div>
					         </div>
					</li>
					<li>
					         <div class="post_wrapper"> <!-- flex -->
					<div >내용</div>
					   <div class="post_content">${board.rpcontent }</div>
					         </div>
					</li>
				</ul>
    <%@include file="/WEB-INF/view/footer.jsp" %>
    </div>
    </div>
</body>
</html>