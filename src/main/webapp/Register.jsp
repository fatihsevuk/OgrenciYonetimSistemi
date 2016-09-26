<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>

<div align="center">
<form action="RegisterController" method="POST">

<input type="hidden" name="command" value="REGISTER"/>
	<table border="1">
	<tbody><h2>Lütfen Kayıt Olunuz</h2></tbody>
	
		
		<tr>
			<td>Kullanıcı Adı:</td>
			<td><input type="text" name="kAdi" /></td>
		
		</tr>
		
		<tr>
			<td>Email</td>
			<td><input type="text" name="kEmail" /></td>
		
		</tr>
		
		<tr>
			<td>Parola</td>
			<td><input type="password" name="kParola" /></td>
		
		</tr>
		
		<tr>
		
		<td><input type="submit" value="KAYIT" /></td>
		<td><input type="reset" value="TEMİZLE" /></td>
		
		</tr>
	



</form>
</div>





</body>
</html>