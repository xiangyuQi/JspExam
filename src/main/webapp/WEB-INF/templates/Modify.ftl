<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>FilmModify</title>
</head>
<body>

	<div align="center">
		<h1>修改</h1>
		<form action="/FilmAction/modify" method="post">
			<input type="hidden" name="filmId" value="${filmId}">
			<input type="hidden" name="pageNo" value="${pageNo}">
			<table border="1" cellpadding="5" cellspacing="0"
				bordercolor="silver" align="center">
				<tr>
					<td colspan="2" bgcolor="#E8E8E8" align="center">修改电影</td>
				</tr>
				<tr>
					<td>Title</td>
					<td><input type="text" name="title" value="${title}"/></td>
				</tr>
				<tr>
					<td>Description</td>
					<td><textarea rows="5" cols="20" name="description" >
						${description}
					</textarea>
					</td>
				</tr>
				<tr>
					<td colspan="2" align="center"><input type="submit"
						name="submit" value="提交" onclick="return check();" /></td>
				</tr>
				<tr>
					<td>Language</td>
					<td><select name="languageId" >
						<#list languages as l >
								<option value="${l.languageId}" 
								<#if languageId == l.languageId>
									selected
								</#if>
								>${l.name}</option>
						</#list>
					</select></td>
				</tr>
				<tr>
					<td colspan="2" align="center">
						<a href="index.jsp">返回主页</a>
					</td>
				</tr>
			</table>
		</form>
	</div>

</body>
</html>