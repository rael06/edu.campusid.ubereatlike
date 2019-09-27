<%@ page import="domain.ShoppingCart" %><%--
  Created by IntelliJ IDEA.
  User: rael0
  Date: 27/09/2019
  Time: 14:12
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
	<title>Paiement</title>
	<link rel="stylesheet" href="${pageContext.request.contextPath}/wwwroot/css/pay.css">
	<%@include file="../head.jsp" %>
</head>
<body>
<%@include file="header.jsp" %>
<section class="pay">
	<p>Commande n°<%= ((ShoppingCart) request.getSession().getAttribute("lastCart")).getOrderId() %> confirmée</p>
	<a href="${pageContext.request.contextPath}/restricted/search" class="button is-primary">
		Retour à l'accueil
	</a>
</section>

</body>
</html>
