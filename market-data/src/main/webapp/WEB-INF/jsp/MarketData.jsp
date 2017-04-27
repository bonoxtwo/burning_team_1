<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"
    import="org.json.JSONArray,org.json.JSONException"%>
<!DOCTYPE html>
<html lang="ko">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>first page</title>
</head>
<body>
<c:forEach var="item" items="${marketList}" varStatus="status">

</c:forEach>
</body>
</html>