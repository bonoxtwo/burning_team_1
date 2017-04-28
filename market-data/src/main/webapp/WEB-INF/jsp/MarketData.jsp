<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html lang="ko">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>first page</title>
<style type="text/css">
* { margin: 0px; padding: 0px; }
li { list-style-type: none; }
#searchForm li {text-align: left; }
#searchForm li .search {
    width: 80px;
    display: inline-block;
    padding: 10px;
    background-color: #940111;
    color: #ffffff;
    text-align: center;
}
#searchForm li input{ 
    display: inline-block;
    padding: 10px 5px;
    text-align: center;
    box-sizing: content-box;
}
#button {
	width : 60px;
	display: inline-block;
    padding: 10px 5px;
    text-align: center;
    box-sizing: content-box;
}

#topWrap {
    padding: 10px;
    font-size: 20pt;
    background-color: #4e4e4e;
    color: #ffffff;
    text-align: center;
}
#view { margin: 0px; }
#stocksList li {
    padding: 10px 0px;
    text-align: center;
    overflow: hidden;
}
#stocksList li.fRow { background-color: #ba0216; color: #ffffff; }
#stocksList li .no { float: left; width: 15%; }
#stocksList li .name { float: left; width: 45%; }
#stocksList li .stockCode { float: left; width: 20%; }
#stocksList li .money { float: left; width: 20%; }
#stocksList li.listRow1 { background-color: #e7e7e7; color: #000000; padding: 5px; }
#stocksList li.listRow2 { background-color: #d2d2d2; color: #000000; padding: 5px; }

.plus { color: red; }
.minus { color: blue; }
</style>
<title>1조</title>
</head>
<body>
<div id="topWrap">
	<span>반도체 기업 순위</span>
</div>
<div id="searchForm">
	<ul>		
		<li>
			<span class = "search">종목 검색</span>		
			<input type="text" size = "30"/>
			<input type="button" id = "button" value="검색" />	
		</li>
	</ul>
</div>

<div id="view">
	<!-- 종목 리스트 -->
	<div id="stocksList">
		<ul>
			<li class="fRow">
				<span class="no">No.</span>
				<span class="name">Name</span>
				<span class="stockCode">종목코드</span>
				<span class="money">시세</span>
			</li>
			</ul>
			<ul>
			<c:forEach begin="0" end="${marketList.length() -1}" var="index">
			<c:choose>
			<c:when test = "${index mod 2 == 0}">
						<c:set var="data" value="${marketList.getJSONObject(index)}"></c:set>
						<li class = "listRow1">
							<span class="no">${index+1 } </span>
							<span class="name">${data.getString("isuKorAbbr")}</span>
							<span class="stockCode">${data.getString("isuSrtCd")}</span>
							<span class="money">1,000,000</span>
						</li>
						</c:when>
						<c:otherwise>
						<c:set var="data" value="${marketList.getJSONObject(index)}"></c:set>
						<li class = "listRow2">
							<span class="no">${index+1 } </span>
							<span class="name">${data.getString("isuKorAbbr")}</span>
							<span class="stockCode">${data.getString("isuSrtCd")}</span>
							<span class="money">1,000,000</span>
						</li>
						</c:otherwise>
						</c:choose>
			</c:forEach>
			</ul>
	</div>
	<!-- //종목 리스트 -->
</div>
</body>
</html>