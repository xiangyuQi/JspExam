<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@page isELIgnored="false"%> 
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>FilmList</title>
</head>
<%@page isELIgnored="false"%> 
<body>
	<center>
		<h1>FILM</h1>
		<hr>
		<table border="1" cellpadding="5" cellspacing="0"
				bordercolor="silver" align="center">
			<tr>
				<td>ID</td>
				<td>TITLE</td>
				<td>DESCRIPTION</td>
				<td>LANGUAGE</td>
				<td>DO</td>
			</tr>
			<c:forEach var="f" items="${films}" varStatus="ind">
				<tr>
					<td>${f.filmId}</td>
					<td>${f.title}</td>
					<td>${f.description}</td>
					<td>${f.language.name}</td>
					<td><a href="/DeleteFilm">del</a>
				</tr>
			</c:forEach>
			<tr>
					<td colspan="6" align="center">
						<a href="/FilmList?pageNo=1">第一页</a>
						<a href="/FilmList?pageNo=${pageNo-1}">上一页</a>
						<a href="/FilmList?pageNo=${pageNo+1}">下一页</a>
						<a href="/FilmList?pageNo=${pageTotal}">最末页</a>
					</td>
				</tr>
				
			<tr>
					<td colspan="6" align="center">
						<a href="index.jsp">index.jsp</a>
						
					</td>
			</tr>
		</table>
	</center>
</body>
</html>