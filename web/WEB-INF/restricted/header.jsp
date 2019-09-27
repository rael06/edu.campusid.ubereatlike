<%@ page import="domain.Customer" %>
<header>
	<h2>UberEatLike</h2>
	<div class="userInfo">
		<a href="orders"><%= ((Customer) request.getSession().getAttribute("customer")).getEmail() %></a>
		<a class="button is-primary" href="cart">Panier</a>
	</div>
</header>
