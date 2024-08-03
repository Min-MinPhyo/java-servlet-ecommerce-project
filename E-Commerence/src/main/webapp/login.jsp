<%@page import="com.model.*" %>
<%@page import="java.util.ArrayList" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
        
     <%
    
     User auth= (User) request.getSession().getAttribute("auth");
    
    if(auth !=null){
    	request.setAttribute("auth",auth);
    	response.sendRedirect("index.jsp");
    }
    
    ArrayList<Cart> cart_list=(ArrayList<Cart>)session.getAttribute("cart-ist");
    
    
    if(cart_list !=null){
    	request.setAttribute("cart_list",cart_list);
    }
    
    
    %>
    
    
    
   
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style type="text/css">
.container{
 backgrounnd-color:"green";
}

</style>
<%@include file="includes/header.jsp"%>


</head>
<body>
	<%@include file="includes/navbar.jsp"%>

	<div class="container">

		<div class="card w-50 my-auto mt-5 mx-auto">


			<div class="card-title text-center">Login Page</div>


			<div class="card-body">


				<form action="userLogin" method="post">

					<div class="form-group">
						<label>Enter Your Email</label> <input type="email"
							class="form-control" name="email" placeholder="enter u email"
							required="required" />

					</div>


					<div class="form-group">
						<label>Password</label> <input type="password"
							class="form-control" name="password" placeholder="******"
							required="required" />
					</div>
					
					
					<div class="form-group mt-2">
					<button class="btn btn-info foem-control" type="submit" >Login</button>
					
					</div>




				</form>

			</div>







		</div>








	</div>



	<%@include file="includes/footer.jsp"%>
</body>
</html>