<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link rel="stylesheet" type="text/css" href="header.css">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>SkuMe</title>
</head>
<body>
<!-- 	<div id="headerBarLine"></div> -->
	<div id="header">
		<h1 style="color: black; margin-left: 40px; margin-top: 50px;">SkuMe</h1>
		<hr style="width:100%; margin-top:112px;"/>
		<hr style="width:100%; margin-top:49px;"/>
	</div>
	<div id="belowHeader"></div>
	<form id="belowHeaderLinks">
		<a href="login.jsp" names="Login"
			style="text-decoration: none; color: black;">Login</a> <a
			href="createNewAccount.jsp" name="createNewAccount"
			style="text-decoration: none; color: black">Create New Account</a>
	</form>
	<div id="info">
	<form action="newUser.do">
			<fieldset style="background-color:#EBF0EF;">
				<legend>Create Account</legend>
  				<em>Email:</em><br>
  				<input id="signUpField" type="text" name="email"/>
 				<br><br>
  				<em>Username:</em><br>
  				<input id="signUpField" type="text" name="username"/>
 				<br><br>
  				<em>Password:</em><br>
  				<input id="signUpField" type="text" name="password"/>
  				<br><br>
  				<em>Confirm Password:</em><br>
  				<input id="signUpField" type="text" name="confirmPassword"/>
  				<br><br>
  				<em>Select University:</em><br/>
  				<select style="width:150px;" name="university">
  					<c:forEach items="${university}" var="university">
  					<option>${university.university_name}</option>
  					</c:forEach>
				</select>
				<br><br>
  				<em>Select Major:</em><br/>
  				<select style="width:150px;"  name="major">
  					<c:forEach items="${major}" var="major">
  					<option>${major.name}</option>
  					</c:forEach>
				</select>
				<br><br>
  				<select style="width:150px;" name="semester">
  					<c:forEach items="${semester}" var="semester">
  					<option >${semester.semester}</option>
  					</c:forEach>
				</select>
				<br><br>
  				<input id="signUpButton" type="submit" value="SignUp"/>
			</fieldset>
		</form>
	</div>
</body>
</html>