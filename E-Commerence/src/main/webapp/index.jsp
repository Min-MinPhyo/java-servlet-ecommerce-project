<%@page import="com.model.*"%>
<%@page import="com.db.*"%>
<%@page import="com.dao.*"%>
<%@page import="java.util.List"%>
<%@page import="java.util.ArrayList" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="ISO-8859-1"%>


<%
    

     User auth= (User) request.getSession().getAttribute("auth");
    
    if(auth !=null){
    	request.setAttribute("auth",auth);
    }
    
  ProductDao dao=new ProductDao(dbConnect.getConnection());
  List<Product> products=dao.getAllProducts();
  
  ArrayList<Cart> cart_list=(ArrayList<Cart>)session.getAttribute("cart-ist");
  
  
    if(cart_list !=null){
    	request.setAttribute("cart_list",cart_list);
    }
    
    
    
    %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>E-Commerence Shopping Site</title>
<%@include file="includes/header.jsp"%>

</head>
<body>
	<%@include file="includes/navbar.jsp"%>

	<div class="container">
		<div class="card-header my-3 " id="allP">All Products</div>

		<div class="row">

			<% 
		
		
		if(!products.isEmpty()){
			
			for(Product product:products) { %>

			<div class="col-12 col-md-4 ">
				<div class="card w-100 m-2 p-2">
				
				
 
				<img class="image-fluid rounded  rounded-5 border border-info" id="allImg" src="images/<%=product.getImage()%>" alt="Card Image"  > 
					<div class="card-body">

						<h5 class="card-title">
							<%=product.getName() %>
						</h5>
						<h6 class="category">
							Category :<span><%=product.getCategory() %></span></h6>

						<div class="m-3 d-flex justify-content-between">
							<a href="addToCart?id=<%=product.getId() %>"
								class="btn btn-success" id="btnAdd"><i class="fa-light fa-cart-circle-arrow-down"></i>Add Cart</a> 
								<a href="orderNow?quantity=1&id=<%=product.getId() %>"
								class="btn btn-info" id="btnClick"><i class="fa-sharp fa-solid fa-bag-shopping"></i>Buy Now</a>


						</div>
					</div>

				</div>


			</div>





			<%}}%>




		</div>
		
		<!-- Scrollable modal -->
<!-- Button trigger modal -->
<!-- <button type="button" class="btn btn-primary" data-bs-toggle="modal" data-bs-target="#data">
  Launch static backdrop modal
</button> -->

<!-- Modal -->
<div class="modal fade" id="data" data-bs-backdrop="static" data-bs-keyboard="false" tabindex="-1" aria-labelledby="staticBackdropLabel" aria-hidden="true">
  <div class="modal-dialog">
    <div class="modal-content">
      <div class="modal-header">
        <h5 class="modal-title" id="staticBackdropLabel">Modal title</h5>
        <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
      </div>
      <div class="modal-body">
        ...
      </div>
      <div class="modal-footer">
        <button type="button" class="btn btn-secondary" data-bs-dismiss="modal">Close</button>
        <button type="button" class="btn btn-primary">Understood</button>
      </div>
    </div>
  </div>
</div>

	</div>
	<script
  src="https://code.jquery.com/jquery-2.2.4.js"
  integrity="sha256-iT6Q9iMJYuQiMWNd9lDyBUStIq/8PuOW33aOqmvFpqI="
  crossorigin="anonymous"></script>
	<script type="text/javascript">
	
	$(document).ready(function(){
		 $("#allP").css({"color":"green","font-size":"30px"}).slideUp(2000).slideDown(2000);
		 
		 
		 $("#allImg").click(function(){
			$("#data").modal();
		 })
		 
		 
		/*  
		 $("#btnAdd").filter(this).on("click",()=>{
			 alert("hello");
		 })
			  */

			 
		 })
		 
		 
	
	
	</script>




</body>
</html>