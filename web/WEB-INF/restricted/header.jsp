<%@ page import="domain.Customer" %>
<header>
	<h1>UberEatLike</h1>
	<div class="userInfo">
		<p><%= ((Customer) request.getSession().getAttribute("customer")).getEmail() %></p>
		<button><a href="cart">Panier</a></button>
	</div>
</header>
