<%@page import="com.hand.entity.Language"%>
<%@page import="java.util.List"%>
<%@page isELIgnored="false"%>
<%@page import="com.hand.service.LanguageService"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%
	if (session.getAttribute("languages") == null) {
		LanguageService service = new LanguageService();
		session.setAttribute("languages", service.getAll());
	}
	Object obj = request.getAttribute("addMsg");
%>
<html>
<style type="text/css">
body {
	color: #000;
	font-size: 15px;
	margin: 20px auto;
}
</style>
<%
	if (request.getAttribute("msg") != null) {
%>
<script type="text/javascript">
	alert("<%=request.getAttribute("msg").toString()%>");
</script>
<%
	}
%>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>添加电影</title>
</head>
<body>

	<div align="center">
		<h1>添加</h1>
		<form action="/FilmAction/add" method="post">
			<table border="1" cellpadding="5" cellspacing="0"
				bordercolor="silver" align="center">
				<tr>
					<td colspan="2" bgcolor="#E8E8E8" align="center">添加电影</td>
				</tr>
				<tr>
					<td>Title</td>
					<td><input type="text" name="title" /></td>
				</tr>
				<tr>
					<td>Description</td>
					<td><textarea rows="5" cols="20" name="description"></textarea>
					</td>
				</tr>
				<tr>
					<td colspan="2" align="center"><input type="submit"
						name="submit" value="提交" onclick="return check();" /></td>
				</tr>
				<tr>
					<td>Language</td>
					<td><select name="languageId">
							<c:forEach var="l" items="${languages}" varStatus="ind">
								<option value="${l.languageId}">${l.name}</option>
							</c:forEach>
					</select></td>
				</tr>
				<tr>
					<td colspan="2" align="center">
						<a href="/index.jsp">返回主页</a>
					</td>
				</tr>
			</table>
		</form>
	</div>

</body>
</html>