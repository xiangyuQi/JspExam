<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<style type="text/css">
body {
	color: #000;
	font-size: 15px;
	margin: 20px auto;
}
</style>
<script type="text/javascript">
	function check() {
		if (document.forms.loginForm.name.value == "") {
			alert("用户名不能为空")
			document.forms.loginForm.name.focus();
			return false;
		}
		
	}
</script>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>用户登录</title>
</head>
<body>
	<%
		if(request.getAttribute("msg")!=null){
	%>
	<script type="text/javascript">
		alert("<%=request.getAttribute("msg").toString()%>");
	</script>
	<%
		}
	%>
	<div align="center">
		<h1>登录</h1>
		<form  name="loginForm" action="/LoginServlet" method="post">
			<table border="1" cellpadding="5" cellspacing="0"
				bordercolor="silver" align="center">
				<tr>
					<td colspan="2" bgcolor="#E8E8E8" align="center">用户登录</td>
				</tr>
				<tr>
					<td>用户名</td>
					<td><input type="text" name="name" /></td>
				</tr>
				
				<tr>
					<td colspan="2" align="center"><input type="submit"
						name="submit" value="提交" onclick="return check();" /></td>
				</tr>
			</table>
		</form>
	</div>

</body>
</html>