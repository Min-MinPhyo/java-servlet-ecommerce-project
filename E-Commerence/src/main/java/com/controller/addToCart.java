package com.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.model.Cart;


@WebServlet("/addToCart")
public class addToCart extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public addToCart() {
        super();
        // TODO Auto-generated constructor stub
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		
		ArrayList<Cart> cartList=new ArrayList<>();
		int id=Integer.parseInt(request.getParameter("id"));
		
		//add so set tar bae
		Cart cm=new Cart();
		cm.setId(id);
		cm.setQuantity(1);
		
		HttpSession session=request.getSession();
	    ArrayList<Cart> cart_list = (ArrayList<Cart>) session.getAttribute("cart-list");
	    
	    if(cart_list ==null) {
	    	cartList.add(cm);
	    	session.setAttribute("cart-list", cartList);
			response.sendRedirect("index.jsp");
	    	out.println("Add List Cart!");
	    	
	    	
	    }else {
			/* out.println("Ready To add List Cart!"); */
			 cartList=cart_list;
	    	boolean exit=false;
	    	
	    	for(Cart c:cart_list) {
	    		if(c.getId() == id) {
	    			exit=true;
	    			out.print("<h3>product ready in exit <a href='cart.jsp'>Cart Page</a></h3>");
	    		}
	    	}
	    		
	    		if(!exit) {
	    			cartList.add(cm);
	    			out.println("Product Added !");
	    			response.sendRedirect("index.jsp");
	    			
	    		}
	    	}
	    }
	    
	 


}


