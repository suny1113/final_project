<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>비밀번호 재설정</title>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
<c:set var="path" value="${pageContext.request.contextPath}"/>
<link rel="stylesheet" href="${path}/resources/css/home.css">
<link rel="stylesheet" href="${path}/resources/css/find_id_password.css">
<link rel="stylesheet" href="${path}/resources/css/find_id.css">
<script type="text/javascript" src="${path }/resources/js/find_password.js"></script>
<style type="text/css">
	#a-pw{
		border-bottom: 1px solid skyblue;
	}
	#span-pw{
		color: skyblue;
	}
</style>
</head>
<body>
<div class="nav-color-width"></div>
	<header>
		<div class="header">
			<div class="nav">
				<a href="../register/register" class="nav-a">회원가입</a>
				<a href="login" class="nav-a">로그인</a>
				<a href="../myPage/myInfo" class="nav-a">마이페이지</a>
				<a href="../help/notice" class="nav-a">고객센터</a>
				<a href="admin/reportList" class="nav-a">관리자페이지</a>
			</div>
			<div class="logo-container">
				<a href="../home"><img src="../resources/img/logo.png" alt="" /></a>
			</div>
		</div>
	</header>

	<h1>아이디/비밀번호 찾기</h1>
	
	<div id="container">
		<div id="find-form">
			<div id="btn-form">
				<a href="find" class="a-find" id="a-id"><span id="span-id" class="span-find">아이디찾기</span></a>
				<a href="findPassword" class="a-find" id="a-pw"><span id="span-pw" class="span-find">비밀번호 재설정</span></a>
			</div>
			
			<h2>휴대전화로 찾기</h2>
			<h4>가입 당시 입력한 휴대전화 번호를 통해 비밀번호를 재설정해주세요.</h4>
			<form action="findPasswordResult" method="post" id="frm">
				<div id="input-form">
					<label for="input-name"></label>
					<input type="text" name="mem_id" class="input-name-tel" id="input-id" placeholder="아이디" autocomplete="off"  /><br>
					<span class="warn" id="warn-id">아이디를 입력하세요.</span>
					<label for="input-name"></label>
					<input type="text" name="mem_name" class="input-name-tel" id="input-name" placeholder="이름" autocomplete="off"  /><br>
					<span class="warn" id="warn-name">이름을 입력하세요.</span>
					<label for="input-tel"></label>
					<input type="tel" name="mem_phone" class="input-name-tel" id="input-tel" placeholder="전화번호 입력(숫자만)" autocomplete="off" /><br>
					<span class="warn" id="warn-tel">휴대전화 번호를 다시 확인해주세요.</span>
					<div id="auth-form">
						<input type="button" id="accept-authNum" value="인증번호 받기" />
						<input type="text" name="" id="chk-authNum" placeholder="인증번호입력" autocomplete="off"  />
						<input type="button" id="chk-btn" value="인증번호 확인"  />
					</div>
					<input type="hidden" name="" id="doubleChk" value=""  />
					<input type="button" id="submit-btn" value="확인"  /><br>
					<span class="warn" id="warn-btn">휴대전화 번호를 인증하세요.</span>
				</div>
			</form>
		
		</div>
	</div>
	
	<jsp:include page="../home/footer.jsp" />
</body>
</html>