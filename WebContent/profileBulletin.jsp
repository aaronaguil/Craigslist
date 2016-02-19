
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link rel="stylesheet" type="text/css" href="user.css">
<link rel="stylesheet" type="text/css" href="header.css">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Profile</title>
</head>
<body>
	<div id="topBarLine"></div>
	<div id="topBar">
		<a href="universityLoggedIn.jsp" style="text-decoration: none;"><h1 style="color:#7200e6; margin-left: 40px; margin-top: 10px;">SkuMe</h1></a>
		<a href="index.jsp" style="text-decoration: none;"><h3 style="margin-top: -50px; margin-left: 1150px; text-decoration: none; color: black;">Logout</h3></a>	
	</div>
	<div id="searchBarLine"></div>
	<div id="searchBar">
		<form style="margin-top:10px; margin-left:470px;">
			<a id="search" href="profileList.jsp" style="text-decoration:none; color:white;"><h3>List</h3></a>
		</form>
	</div>
	<div id="line">
	<div id="sideBar">
	<form id="sideBarForm">
		<a id="sideBarLinks" href="user.jsp" style="text-decoration: none;">Books.</a><br/><br/><br/><br/><br/>
		<a id="sideBarLinks" href="user.jsp" style="text-decoration: none;">Personal.Stuff</a><br/><br/><br/><br/><br/>
		<a id="sideBarLinks" href="user.jsp" style="text-decoration: none;">House.Stuff</a><br/><br/><br/><br/><br/>
		<a id="sideBarLinks" href="user.jsp" style="text-decoration: none;">School.Stuff</a>
	</form>
	</div>
	<div id="lineBreak"></div>
	<div id="lineBreak1"></div>
	<div id="lineBreak2"></div>
</body>
</html>