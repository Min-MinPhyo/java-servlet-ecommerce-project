
<div class="container-fluid bg-primary">

<div class="row">


<div class="container">
<div class="row">

<div class="col-12">



<nav class="navbar navbar-expand-lg navbar-dark">
	<div class="container">
		<a class="navbar-brand" href="index.jsp"><i class="fa-solid fa-cart-arrow-down"></i>
		Shopping Cart</a>
		<button class="navbar-toggler" type="button" data-bs-toggle="collapse"
			data-bs-target="#navbarSupportedContent"
			aria-controls="navbarSupportedContent" aria-expanded="false"
			aria-label="Toggle navigation">
			<span class="navbar-toggler-icon"></span>
		</button>

		<div class="collapse navbar-collapse justify-content-end" id="navbarSupportedContent">

			<!--      <ul class="navbar-nav "> -->


			<ul class="navbar-nav">


				<li class="nav-item"><a class="nav-link active"
					href="index.jsp">Home</a></li>


				<li class="nav-item"><a class="nav-link" href="cart.jsp">Cart<span class="badge bg-success">${cart_list.size()}</span></a></li>



				<%
				if (auth != null) {
				%>



				<li class="nav-item"><a class="nav-link" href="orders.jsp">Order</a>
				</li>

				<li class="nav-item"><a class="nav-link" href="userLogout">Logout</a>
				</li>


				<%
				} else {
				%>




				<li class="nav-item"><a class="nav-link" href="login.jsp"><i class="fa-solid fa-right-to-bracket"></i>Login</a>
				</li>

				<%
				}
				%>




			</ul>


		</div>
		
	
	</div>
</nav>
</div>

</div>




</div>
</div>





</div>

 