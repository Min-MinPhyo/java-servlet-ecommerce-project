<%@page import="com.model.*"%>
<%@page import="java.util.*"%>
<%@page import="com.dao.*"%>
<%@page import="com.db.*"%>
<%@page import="java.text.DecimalFormat"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%
DecimalFormat d = new DecimalFormat("#.##");
request.setAttribute("deci", d);

User auth = (User) request.getSession().getAttribute("auth");

if (auth != null) {
	request.setAttribute("auth", auth);

}

ArrayList<Cart> cart_list = (ArrayList<Cart>) session.getAttribute("cart-list");

List<Cart> cartProduct = null;

if (cart_list != null) {
	ProductDao pDao = new ProductDao(dbConnect.getConnection());
	cartProduct = pDao.getCartProducts(cart_list);

	double total = pDao.getCartTotal(cartProduct);

	request.setAttribute("cart_list", cart_list);
	request.setAttribute("total", total);
}
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Cart Page</title>

<style type="text/css">
.table tbody td {
	vertical-align: middle;
}

.btn-incre, .btn-decre {
	box-shodow: none;
	font-size: 20px;
}
</style>
<%@include file="includes/header.jsp"%>
</head>
<body>
	<%@include file="includes/navbar.jsp"%>

	<div class="container">
		<div class="d-flex py-4">
			<h5>Total Price :$ ${(total >0)?deci.format(total):0 }</h5>
			<a href="checkOut" class="mx-4 btn btn-info mb-2">Check Out</a>
		</div>

		<!-- <table class="table table-dark table-striped">  -->
		<!-- table class="table table-success table-striped"> -->
		<table class="table table-dark table-striped">
			<thead class="thead-dark">

				<tr>
					<th>Name :</th>
					<th>Category :</th>
					<th>Price :</th>
					<th>Buy Now</th>
					<th>Cancel</th>
				</tr>

			</thead>

			<tbody>





				<%
				if (cart_list != null) {

					for (Cart c : cartProduct) {
				%>
				<tr class="table-secondary">


					<td><%=c.getName()%></td>
					<td><%=c.getCategory()%></td>
					<td>$<%=c.getPrice()%></td>
					<td>
						<form action="orderNow" method="post" class="form-inline ">

							<input type="hidden" name="id" value="<%=c.getId()%>"
								class="form-input">

							<div class="form-group d-flex justify-content-center w-75 mx-2">

								<a class="btn btn-info  btn-sm btn-incre pr-2 mx-2"
									href="cartIncDec?action=inc&id=<%=c.getId()%>"> <i
									class="fa-solid fa-plus"></i></a> <input type="text"
									name="quantity" class="form-control"
									value="<%=c.getQuantity()%>" readonly> <a
									class="btn btn-danger btn-sm btn-decre mx-2"
									href="cartIncDec?action=dec&id=<%=c.getId()%>"> <i
									class="fa-solid fa-minus"></i></a>



								<button class="btn btn-sm btn-secondary mr-2">Buy</button>


							</div>



						</form>


					</td>

					<td><a class="btn btn-sm btn-danger"
					href="removeFromCart?id=<%=c.getId()%>">Remove</a></td>

				</tr>
				<%
				}
				}
				%>

			</tbody>



		</table>


	</div>

</body>
</html>