<%@page import="com.model.*"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.text.DecimalFormat" %>
<%@page import="java.util.List" %>
<%@page import="com.db.*" %>
<%@page import="com.dao.*" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<% 
     DecimalFormat dFormat=new DecimalFormat("#.##");
     request.setAttribute("dFormat",dFormat);
    
    
     User auth=(User)
     request.getSession().getAttribute("auth");
    List<Order> orders=null;
    
    if(auth !=null){
    	request.setAttribute("auth",auth);
    	orders=(List<Order>)new OrderDao(dbConnect.getConnection()).userOrders(auth.getId());
    	
    	
    }
    
    ArrayList<Cart> cart_list=(ArrayList<Cart>)session.getAttribute("cart-ist");
    
    
    if(cart_list !=null){
    	request.setAttribute("cart_list",cart_list);
    }
    
    %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<%@include file="includes/header.jsp"%>
</head>

<body>
	<%@include file="includes/navbar.jsp"%>
	
	<div class="container">
	
	<div class="card-header my-4">All  Orders</div>
	
	<table class="table table-success">

   <thead>
   <tr>
   <td scope="col">Date</td>
   <td scope="col">Name</td>
   <td scope="col">Category</td>
   <td scope="col">Quantity</td>
   <td scope="col">Price</td>
   <td class="col">Canel</td>
   
   
   </tr>
   
   
   </thead>	
	<tbody>
	
	
	
	   <% if(orders !=null){
		   
		   for(Order o:orders){%>
		   <tr>
		   <td><%=o.getDate() %></td>
		   <td><%=o.getName() %></td>
		   <td><%=o.getCategory() %></td>
		   <td><%=o.getQuantity() %></td>
		   <td><%=o.getPrice() %></td> 
		   <td><a class="btn btn-danger" href="cancelOrder?id=<%=o.getOrderId()%>">Cannel</a></td>
		   
		   </tr>
		   
		<% }}  %>
	   
	  
	</table>
	   
	
	
	
	</div>


</body>
</html>