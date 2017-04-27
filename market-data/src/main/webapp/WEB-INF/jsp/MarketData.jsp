<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html lang="ko">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>first page</title>
</head>
<body>
<div id="view">
	<!-- 종목 리스트 -->
	<div id="stocksList">
		<ul>
			<li class="fRow">
				<span class="no">No.</span>
				<span class="isuKor">종목명</span>
			</li>
			<c:forEach begin="0" end="${marketList.length() -1}" var="index">
						<c:set var="data" value="${marketList.getJSONObject(index)}"></c:set>
						<li>
							<span class="no">${index+1 } </span>
							<span class="isuKor">${data.getString("isuKorAbbr")}</span>
						</li>
			</c:forEach>
			</ul>
	</div>
	<!-- //종목 리스트 -->
</div>
</body>
</html>