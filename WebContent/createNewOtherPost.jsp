
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link rel="stylesheet" type="text/css" href="universityLoggedIn.css">
<link rel="stylesheet" type="text/css" href="header.css">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>SkuMe</title>
</head>
<body>
	<div id="topBarLine">
		<div id="topBar">
			<a href="user.jsp" style="text-decoration: none;"><h1 style="color:#7200e6; margin-left: 40px; margin-right:1150px; margin-top: 10px;">SkuMe</h1></a>
			<a href="index.jsp" style="text-decoration: none;"><h3 style="margin-top: -50px; margin-left: 1150px; text-decoration: none; color: black;">Logout</h3></a>
		</div>
	</div>
	<div id="newPostForm">
	<form action="newBookPost.do">
			<fieldset style="background-color:#EBF0EF;width:1170px;">
				<legend>Create New Post</legend>
  				<em>Title</em><br>
  				<input id="signUpField" type="text" name="email" style="width: 300px;"/>
 				<br><br>
  				<em>Image:</em><br>
				<input type="file" accept="image/jpeg, image/png, image/gif, image/jpg" path="avatar" id="avatarInput" cssClass="btn btn-default btn-file" /> 				
				<br><br>
  				<em>Message:</em><br>
  				<textarea id="signUpField" rows="4" cols="50" name="username" style="width: 300px;"></textarea>
 				<br><br>
  				<em>Price:</em><br>
  				<input id="signUpField" type="text" name="password" style="width: 300px;"/>
  				<br><br>
  				<input id="signUpButton" type="submit" value="SignUp"/>
			</fieldset>
		</form>
	</div>
</body>
</html>




