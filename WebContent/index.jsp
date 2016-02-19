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
		<form id="login" action="login.do">
			<i style="margin:10px;">username</i>
			<input type="text" name="username"/>
			<i style="margin:10px;">password</i>
			<input type="text" name="password"/>
			<input type="submit" value="Login"/>
		</form>
	</div>
	<div id="belowHeader"></div>
	<form id="belowHeaderLinks" action="createNewAccount.do">
		<input type="submit"  name="Login" style="text-decoration: none; color: black;" value="Login"/>
		<input type="submit" name="createNewAccount" style="text-decoration: none; color: black" value="Create New Account"/>
	</form>
	<div id="info">
	<form action="newUser.do">
			<fieldset style="background-color:#EBF0EF;width:200px;">
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
  				<input id="signUpButton" type="submit" value="SignUp"/>
			</fieldset>
		</form>

	</div>
</body>
</html>