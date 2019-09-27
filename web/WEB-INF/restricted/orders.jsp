<%@ page import="domain.ShoppingCart" %>
<%@ page import="java.util.List" %>
<%@ page import="domain.ShoppingCartItem" %>
<%@ page import="java.text.DecimalFormat" %><%--
  Created by IntelliJ IDEA.
  User: rael0
  Date: 27/09/2019
  Time: 19:31
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
	<title>Orders</title>
	<link rel="stylesheet" href="${pageContext.request.contextPath}/wwwroot/css/orders.css">
	<%@include file="../head.jsp" %>
</head>
<body>
<%@include file="header.jsp" %>
<section class="orders">
	<h1>Commandes effectuées</h1>
	<div class="carts">
		<% for (ShoppingCart sc : (List<ShoppingCart>) request.getAttribute("shoppingCarts")) { %>
		<div class="cart">
			<h2>Commande n°<%= sc.getOrderId() %></h2>
			<h3>Contenu de la commande : </h3>
			<% for (ShoppingCartItem item : sc.getShoppingCartItems()) { %>
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
							</div>
						</div>
					</article>
				</div>
				<% } %>
			</div>
		<% } %>
	</div>
	<a href="${pageContext.request.contextPath}/restricted/search" class="goBack button is-primary">
		Retour
	</a>
</section>

</body>
</html>
