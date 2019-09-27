<%@ page import="java.util.List" %>
<%@ page import="domain.ShoppingCartItem" %><%--
  Created by IntelliJ IDEA.
  User: rael0
  Date: 27/09/2019
  Time: 12:28
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
	<head>
		<title>Panier</title>
		<link rel="stylesheet" href="${pageContext.request.contextPath}/wwwroot/css/panier.css">
		<%@include file="../head.jsp" %>
	</head>
<body>
<%@include file="header.jsp" %>
<section class="cart">
	<p>Quantité : <%= ((List<ShoppingCartItem>) request.getSession().getAttribute("cart")).size() %></p>
</section>

</body>
</html>
