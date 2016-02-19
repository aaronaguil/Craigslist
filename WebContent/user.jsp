
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link rel="stylesheet" type="text/css" href="user.css">
<link rel="stylesheet" type="text/css" href="header.css">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>User</title>
</head>
<body style="overflow:auto;">
	<div id="topBarLine"></div>
	
	<div id="topBar">
		<a href="getUniversityPosts.do" style="text-decoration: none;"><h1 style="color:#7200e6; margin-left: 40px; margin-right:1150px; margin-top: 10px;">SkuMe</h1></a>
		<a href="createNewPost.jsp" style="text-decoration: none;"><h4 style="margin-top: -50px; margin-left: 550px; text-decoration: none; color: black;">Create New Post</h4></a>
		<a href="index.jsp" style="text-decoration: none;"><h3 style="margin-top: -50px; margin-left: 1150px; text-decoration: none; color: black;">Logout</h3></a>
	</div>
	
	<div id="searchBarLine"></div>
	
	<div id="searchBar">
	<form style="margin-left:85px; margin-top:-5px; margin-right:300px;">	
		Title:<input type="text" style="width:150px;margin:20px;"/>
		Author:<input type="text" style="width:150px;margin:20px;"/>
		Year:<input type="text" style="width:50px;margin:20px;"/>
		ISBN:<input type="text" style="width:50px;margin:20px;"/>
		<a id="search" href="user.jsp" style="text-decoration:none; color:white;">Search</a>
	</form>
	</div>
	
	<div id="line">
	
	<div id="sideBar">
	<a href="displayUniversities.do" style="text-decoration: none;"><h2 style="margin-top: 100px; margin-left: 30px; text-decoration: none; color: gray;">Universities</h2></a>
	<form id="sideBarForm">
		<a id="sideBarLinks" href="getBookPosts.do" style="text-decoration: none;">Books.</a><br/><br/><br/><br/><br/>
		<a id="sideBarLinks" href="getPersonalPosts.do" style="text-decoration: none;">Personal.Stuff</a><br/><br/><br/><br/><br/>
		<a id="sideBarLinks" href="getHousePosts.do" style="text-decoration: none;">House.Stuff</a><br/><br/><br/><br/><br/>
		<a id="sideBarLinks" href="getSchoolPosts.do" style="text-decoration: none;">School.Stuff</a>
	</form>
	</div>
	
	<div id="lineBreak"></div>
	
	<div id="lineBreak1"></div>
	
	<div id="lineBreak2"></div>
	
 	<div id="posts">
		<c:forEach items="${posts}" var="post">
		<div style="margin-top: 10px; font-size:22px;font-family:Courier New, Courier, monospace;">${post.title}</div>
		<div id="message" style="margin-top: 10px;font-size: 18px;font-family:Courier New, Courier, monospace;"><b>${post.message}</b></div>
		<div id="price" style="margin-top: 5px;font-size:18px; color:red;"><b><i>Price: $${post.price}</i></b>
		<input type="submit" value="contact"/>
		</div>
		<hr style="width:875px;"/>
		</c:forEach>
	</div>
	
</body>
</html>