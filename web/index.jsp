<%--
  Created by IntelliJ IDEA.
  User: rael0
  Date: 18/09/2019
  Time: 15:06
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
	<title>Login</title>
	<link rel="stylesheet" href="${pageContext.request.contextPath}/wwwroot/css/login.css">
	<%@include file="WEB-INF/head.jsp" %>
</head>

<body>
<section class="login">
	<form action="./login" method="post">
<%--		<% if (request.setAttribute("error") != null) { %>--%>
<%--		<div class="notification is-danger">--%>
<%--			${error}--%>
<%--		</div>--%>
<%--		<% } %>--%>
		<div class="field">
			<div class="control">
				<input class="input is-primary" value="${param.email}" type="email" name="email" placeholder="Email">
			</div>
		</div>
		<div class="field">
			<div class="control">
				<input class="input is-info" value="${param.password}" type="password" name="password"
					   placeholder="Password">
			</div>
		</div>
		<div class="control">
			<button class="button is-primary" name="loginButton" value="true">Submit</button>
		</div>
	</form>
</section>

</body>
</html>
