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
<form action="LoginController" method="post">
	<table border="1">
	<tbody><h2>Lütfen Giriş Yapınız</h2></tbody>
	
		
		<tr>
			<td>Kullanıcı Adı:</td>
			<td><input type="text" name="kAdi" /></td>
		
		</tr>
		
		<tr>
			<td>Parola:</td>
			<td><input type="password" name="kParola" /></td>
		
		</tr>
		
		<tr>
		
		<td><input type="submit" value="GİRİŞ" /></td>
		<td><input type="reset" value="TEMİZLE" /></td>
		
		</tr>
	



</form>
</div>
</body>
</html>