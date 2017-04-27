<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html lang="ko">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>first page</title>
</head>
<body>
<div id="topWrap">
	<span>반도체 기업 순위</span>
</div>

<div id="view">
	<!-- 종목 리스트 -->
	<div id="stocksList">
		<ul>
			<li class="fRow">
				<span class="no">No.</span>
				<span class="isuKor">Name</span>
				<span class="stockCode">종목코드</span>
				<span class="money">시세</span>
			</li>
			<c:forEach begin="0" end="${marketList.length() -1}" var="index">
						<c:set var="data" value="${marketList.getJSONObject(index)}"></c:set>
						<li>
							<span class="no">${index+1 } </span>
							<span class="isuKor">${data.getString("isuKorAbbr")}</span>
							<span class="stockCode">${data.getString("isuSrtCd")}</span>
							<span class="money">1,000,000</span>
						</li>
			</c:forEach>
			</ul>
	</div>
	<!-- //종목 리스트 -->
</div>
</body>
</html>