<%@ page import="domain.Menu" %>
<%@ page import="java.text.DecimalFormat" %>
<%@ page import="java.util.List" %><%--
  Created by IntelliJ IDEA.
  User: rael0
  Date: 20/09/2019
  Time: 16:47
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
	<title>Menu</title>
	<link rel="stylesheet" href="${pageContext.request.contextPath}/wwwroot/css/menu.css">
	<%@include file="../head.jsp" %>
</head>
<body>
<%@include file="header.jsp" %>
<section class="menu">
	<div class="boxes">
	<% for (Menu m : ((List<Menu>) request.getAttribute("menus"))) { %>

		<div class="box">
			<article class="media">
				<div class="media-content">
					<div class="content restaurant">
						<figure class="image is-128x128">
							<img src="https://versions.bulma.io/0.7.0/images/placeholders/640x360.png" alt="Image">
						</figure>
						<div>
							<h3><strong><%= m.getName() %>
							</strong></h3>
							<p><%= new DecimalFormat("0.00").format(Double.parseDouble(m.getPrice())) %> €</p>
							<div class="menuContent">
								<h4>Contenu</h4>
								<% for (String c : m.getContent()) {%>
								<p class="contentP"><%= c %>
								</p>
								<% } %>
							</div>
						</div>
						<form action="" method="get">
							<button class="button is-primary orderButton" name="order"
									value="<%= m.getId() %>">Commander
							</button>
						</form>
					</div>
				</div>
			</article>
		</div>
		<% } %>
	</div>
	<a href="${pageContext.request.contextPath}/restricted/search" class="goBack button is-primary">
		Retour
	</a>
</section>
</body>
</html>
