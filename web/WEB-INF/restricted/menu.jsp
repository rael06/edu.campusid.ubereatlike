<%@ page import="domain.Menu" %>
<%@ page import="java.text.DecimalFormat" %><%--
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
<section class="menu">
		<div class="box">
			<article class="media">
				<div class="media-left">
					<figure class="image is-64x64">
						<img src="https://versions.bulma.io/0.7.0/images/placeholders/128x128.png" alt="Image">
					</figure>
				</div>
				<div class="media-content">
					<div class="content restaurant">
						<div>
							<p>Menu : <strong>
								<%= ((Menu) request.getAttribute("menu")).getName() %>
							</strong></p>
							<p>Prix : <%= new DecimalFormat("0.00").format(Double.parseDouble(((Menu) request.getAttribute("menu"))
									.getPrice())) %> €
							</p>
						</div>
					</div>
				</div>
			</article>
		</div>
		<a href="${pageContext.request.contextPath}/restricted/search" class="goBack button is-primary">
			Retour
		</a>
</section>
</body>
</html>
