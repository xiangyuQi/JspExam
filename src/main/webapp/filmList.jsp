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
<%
	if (request.getAttribute("msg") != null) {
%>
<script type="text/javascript">
	alert("<%=request.getAttribute("msg").toString()%>");
</script>
<%
	}
%>
</head>
<%@page isELIgnored="false"%> 
<body>
	<center>
		<h2>FILM</h2>
		<hr>
		<table border="1" cellpadding="5" cellspacing="0"
				bordercolor="silver" align="center" width="70%" height="70%">
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
					<td><a href="/FilmAction/delete?filmId=${f.filmId}&pageNo=${pageNo}">del</a>
						<a href="/FilmAction/modify?filmId=${f.filmId}&pageNo=${pageNo}">modify</a>
					</td>
				</tr>
			</c:forEach>
			<tr>
					<td colspan="6" align="center">
						<a href="/FilmAction/list?pageNo=1">第一页</a>
						<a href="/FilmAction/list?pageNo=${pageNo-1>0?pageNo-1:1}">上一页</a>
						<a href="/FilmAction/list?pageNo=${pageNo+1<pageTotal?pageNo+1:pageTotal}">下一页</a>
						<a href="/FilmAction/list?pageNo=${pageTotal}">最末页</a>
					</td>
				</tr>
				
			<tr>
					<td colspan="6" align="center">
						<a href="/index.jsp">返回主页</a>
						
					</td>
			</tr>
		</table>
	</center>
</body>
</html>