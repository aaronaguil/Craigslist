
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link rel="stylesheet" type="text/css" href="universityLoggedIn.css">
<link rel="stylesheet" type="text/css" href="header.css">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>University</title>
</head>
<body>
	<div id="topBarLine">
	<div id="topBar">
		<a href="getUniversityPosts.do" style="text-decoration: none;"><h1 style="color:#7200e6; margin-left: 40px; margin-right:1150px; margin-top: 10px;">SkuMe</h1></a>
		<a href="index.jsp" style="text-decoration: none;"><h3 style="margin-top: -50px; margin-left: 1150px; text-decoration: none; color: black;">Logout</h3></a>
	</div></div>
	<div class="tester">
		<c:forEach items="${university}" var="university">
		<a id="sideBarLinks" href="getUniversityPosts.do" style="text-decoration: none;">${university.university_name}</a>
		<br/>
		</c:forEach>
	</div>
</body>
</html>