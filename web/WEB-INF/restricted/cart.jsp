<%@ page import="domain.ShoppingCart" %>
<%@ page import="java.text.DecimalFormat" %>
<%@ page import="domain.Menu" %>
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
		<link rel="stylesheet" href="${pageContext.request.contextPath}/wwwroot/css/cart.css">
		<%@include file="../head.jsp" %>
	</head>
<body>
<%@include file="header.jsp" %>
<section class="cart">
	<div class="cartInfo">
		<p>Quantité : <%= request.getAttribute("nbItemsStr") %></p>
		<p>Total : <%= request.getAttribute("price") %> €</p>
			<a style="visibility:<%= (int) request.getAttribute("nbItems") > 0 ? "visible" : "hidden" %>"
					href="${pageContext.request.contextPath}/restricted/pay?orderId=
					<%= ((ShoppingCart) request.getAttribute("cart")).getOrderId() %>"
					class="button is-primary">
				Payer
			</a>
	</div>
	<div class="cartMenus">
		<% for (ShoppingCartItem item : (List<ShoppingCartItem>) request.getAttribute("items")) { %>
		<div class="box">
			<article class="media">
				<div class="media-content">
					<div class="content item">
						<figure class="image is-64x64">
							<img src="https://versions.bulma.io/0.7.0/images/placeholders/64x64.png" alt="Image">
						</figure>
						<div>
							<h3><strong><%= item.getName() %>
							</strong></h3>
							<p><%= new DecimalFormat("0.00").format(item.getPrice()) %> €</p>
						</div>
						<form action="" method="post">
							<button class="button is-primary" name="remove"
									value="<%= item.getId() %>">Retirer
							</button>
						</form>
					</div>
				</div>
			</article>
		</div>
		<% } %>
	</div>
	<a href="${pageContext.request.contextPath}/restricted/menu" class="goBack button is-primary">
		Retour
	</a>
</section>

</body>
</html>
