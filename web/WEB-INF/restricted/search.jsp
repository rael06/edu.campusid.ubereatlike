<%@ page import="domain.Customer" %>
<%@ page import="java.util.Optional" %>
<%@ page import="domain.Restaurant" %>
<%@ page import="java.util.List" %><%--
  Created by IntelliJ IDEA.
  User: rael0
  Date: 18/09/2019
  Time: 16:55
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
	<title>Search</title>
	<link rel="stylesheet" href="${pageContext.request.contextPath}/wwwroot/css/search.css">
	<%@include file="../head.jsp" %>
</head>
<body>
<section class="search">
	<div class="filter">
		<form action="" id="form" method="post">
			<div class="field">
				<div class="control">
					<input class="input is-primary" value="<%= request.getSession().getAttribute("search") != null ? request.getSession().getAttribute("search") : "" %>"
						   type="text" name="type" placeholder="Votre recherche">
				</div>
			</div>

			<div class="control">
				<button class="button is-primary" name="searched" value=true>Submit</button>
			</div>
		</form>
	</div>

	<div class="restaurants">

		<% if (request.getAttribute("restaurants") != null) {
			for (Restaurant restaurant : (List<Restaurant>) request.getAttribute("restaurants")) { %>

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
							<p><strong><%= restaurant.getName() %>
							</strong></p>
							<p><%= restaurant.getShippingTime() %>
							</p>
						</div>
						<a href="${pageContext.request.contextPath}/restricted/menu?restaurant=<%= restaurant.getId() %>"
						   class="button is-primary">
							Voir menu
						</a>
					</div>
				</div>
			</article>
		</div>
		<% }
		} %>
	</div>

</section>
</body>
</html>
