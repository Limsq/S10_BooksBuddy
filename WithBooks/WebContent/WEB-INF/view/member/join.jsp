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
	<link rel="stylesheet" href="./css/main_share_section.css" type="text/css">
	<!-- TODO: 이곳에 해당 jsp의 css 넣기 -->
	<link rel="stylesheet" href="./css/join.css">
	
    <script src="./js/jquery-3.6.1.js"></script>
    <script src="./js/main_header.js"></script>
    <!-- TODO: 이곳에 해당 jsp의 js 넣기 -->
    <script src="./js/join.js"></script>

    <!-- 전체공통 -->
    <style>
        @import url('https://fonts.googleapis.com/css2?family=Noto+Sans+KR&display=swap');
        html, button, input, select, textarea, span, a, p {
            font-family: "Noto Sans KR", "malgun gothic", /*AppleGothic*/dotum, sans-serif;
        }
    </style>
    <title>회원가입</title>
</head>
<body>
    <div>
        <div id="section">
            <div>
                <div id="section_child_1">
                    <span>회원가입</span>
                </div>
                <div id="section_child_2">
                    <div id="form_area">
                        <form action="./join.do" method="post">
                            <div id="login_tbl_frame">
                                <table id="login_tbl">
                                    <tr>
                                        <td><label>아이디<span>*</span></label></td>
                                        <td><input type="text" id="input_id" name="id" placeholder="아이디를 입력해주세요" autocomplete="off" oninput="id_script(this, 6, 17)" maxlength="16"><p id="input_id_p"></p></td>
                                        <td><button type="button" class="info_check_button" onclick="open_pop_up_1()"><span>중복확인</span></button></td>
                                    </tr>
                                    <tr>
                                        <td><label>비밀번호<span>*</span></label></td>
                                        <td><input type="password" id="input_pw" name="pw" placeholder="비밀번호를 입력해주세요" autocomplete="off" oninput="input_pw_script(this, 10)" maxlength="16"><p id="input_pw_p"></p></td>
                                    </tr>
                                    <tr>
                                        <td><label>비밀번호확인<span>*</span></label></td>
                                        <td><input type="password" id="input_pw_check" name="pw_check" placeholder="비밀번호를 한번 더 입력해주세요" autocomplete="off" maxlength="16" oninput="input_pw_check_script(this)"  maxlength="16"><p id="input_pw_check_p"></p></td>
                                    </tr>
                                    <tr>
                                        <td><label>이름<span>*</span></label></td>
                                        <td><input type="text" id="input_user_name" name="user_name" placeholder="이름을 입력해 주세요" autocomplete="off" oninput="input_user_name_script(this)"><p id="input_user_name_p"></p></td>
                                    </tr>
                                    <tr>
                                        <td><label>이메일<span>*</span></label></td>
                                        <td><input type="text" id="input_mail" name="mail" placeholder="예: marketkurly@kurly.com" autocomplete="off" oninput="input_mail_script(this)"><p id="input_mail_p"></p></td>
                                        <td><button type="button"><span>인증번호 전송</span></button></td>
                                    </tr>
                                </table>
                            </div>
                               <div id="submit_area">
                                <button type="submit">
                                    <span>가입하기</span>
                                </button>
                            </div>
                        </form>
                    </div>
                </div> 
            </div>
        </div>
    </div>
</body>
</html>