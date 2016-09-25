<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
    
<%@ page import="java.util.* " %>
<%@ page import="com.fatih.model.* " %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>



<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>

<link type="text/css" rel="stylesheet" href="css/style.css"/>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Ögrenci Kayıt Sistemi </title>
</head>
<body>


<div id="wrapper">
	<div id="header">
		<h2>Kayıtlı Öğrenciler</h2>
	
	</div>
<div id="container">
	<div id="content"> 
	
	<input type="submit" value="Öğrenci Ekle" onclick="window.location.href='OgrenciEkle.jsp'; return false; " class="add-student-button"/>
		
		<table>
			<tr>
				<th>No</th>
				<th>Ad</th>
				<th>Soyad</th>
				<th>Email</th>
				<th>Action</th>
			</tr>
			
			<c:forEach var="temp" items="${ogrenciListesi}">
			
				<c:url var="tempLink" value="OgrenciController">
					<c:param name="command" value="LOAD"/>
					<c:param name="ogrenciId" value="${temp.id}"></c:param>
				
				</c:url>
				
				<tr>
				
					 <td>${temp.id}</td>
					 <td>${temp.ad}</td>
					 <td>${temp.soyad}</td>
					 <td>${temp.email}</td>
					 <td><input type="submit" value="GÜNCELLE" onclick="window.location.href='${tempLink }'; return false; " class="update-student-button"/></td>
				
				</tr>
			
			</c:forEach>
		
		</table>
	
	
	</div>


</div>


</div>





</body>
</html>