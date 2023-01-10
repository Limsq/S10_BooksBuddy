<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<link
	href="https://fonts.googleapis.com/css2?family=Nanum+Gothic&family=Noto+Sans:wght@100&display=swap"
	rel="stylesheet">
<!-- TODO: 이곳에 해당 jsp의 css 넣기 -->
<link href="css/notice.css" rel="stylesheet" type="text/css">
<script src="./js/jquery-3.6.1.js"></script>
<!-- TODO: 이곳에 해당 jsp의 js 넣기 -->
<!-- 전체공통 -->
<style>
@import
	url('https://fonts.googleapis.com/css2?family=Noto+Sans+KR&display=swap')
	;

html, button, input, select, textarea, span, a, p {
	font-family: "Noto Sans KR", "malgun gothic", /*AppleGothic*/ dotum,
		sans-serif;
}
</style>
<title>notice</title>
</head>
<body>
	<div>
		<%@include file="/WEB-INF/view/header.jsp"%>

					<!-- 가운데내용부분 -->
					<div class="notice">
						<div class="notice_header_wrapper">
							<div class="notice_header_text_wrapper">
								<button type="button" onclick="location.href='noticeWrite';">글쓰기</button>
							</div>
						</div>
						<c:choose>
							<c:when test="${empty boardlist}">
								<div class="notice_category_wrapper">
									<div class="title">게시글이 없습니다.</div>
								</div>
							</c:when>
							<c:otherwise>
								<div class="notice_category_wrapper">
									<!-- flex -->
									<div width="50" class="number">번호</div>
									<div class="title">제목</div>
									<div width="100" class="writer">작성자</div>
									<div width="100" class="date">작성일</div>
								</div>
								<ul class="notice_post_wrapper">
									<!-- flex -->
									<c:forEach items="${boardlist}" var="board">
										<li><a href="noticeRead?bno=${board.bno }">
												<div class="post_wrapper">
													<!-- flex -->
													<div class="post_number">${board.bno }</div>
													<div class="post_title">
														<c:forEach begin="1" end="${board.brelevel }">
                                        &#128761;
                                        </c:forEach>
														${board.btitle }
													</div>
													<div class="post_writer">${board.bwriter }</div>
													<div class="post_date">${board.bdate }</div>
												</div>
										</a></li>
									</c:forEach>
								</ul>
								<div class="button_wrapper">
									<!-- flex -->
									<div class="button">
										<button disabled type="button" class="button_previous">
											<div class="button_text">이전</div>
										</button>
										<c:if test="${startPage ne 1}">
											<a href="notice?pagenum=${startPage-1 }&search=${searchword}">이전</a>
										</c:if>
										<c:forEach begin="${startPage }" end="${endPage }" var="p"
											step="1">
											<a href="notice?pagenum=${p }&search=${searchword}">${p }</a>
										</c:forEach>
										<c:if test="${endPage < pageCnt}">
											<a href="notice?pagenum=${endPage+1 }&search=${searchword}">다음</a>
										</c:if>

										<button type="button" class="button_next">
											<div class="button_text">다음</div>
										</button>
									</div>
								</div>
							</c:otherwise>
						</c:choose>

					</div>
				</div>
			</div>

			<!-- 위로가기 버튼 -->
			<div id="scrollup">
				<a href="#"> <span></span>
				</a>
			</div>
		</div>

		<!-- footer -->
		<%@include file="/WEB-INF/view/footer.jsp"%>
	</div>
</body>
</html>