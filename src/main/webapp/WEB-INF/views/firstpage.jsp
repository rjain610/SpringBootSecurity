<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>


<!DOCTYPE html>

<html>

<head>
<script src="<c:url value="js/jquery.js" />"></script>

<title>Hello World!</title>

</head>

<body>

	<h1>
		Hello <b><c:out value="${pageContext.request.remoteUser}" /></b>
	</h1>

	<form action="/logout" method="post">

		<input type="submit" value="Sign Out" /> <input type="hidden"
			name="${_csrf.parameterName}" value="${_csrf.token}" />

	</form>
	<p id="user-data">test</p>
</body>
<script src="<c:url value="js/user.js?app=1" />"></script>
</html>