package com.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.model.Cart;


@WebServlet("/removeFromCart")
public class removeFromCart extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
    public removeFromCart() {
        super();
        // TODO Auto-generated constructor stub
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.setContentType("text/html;charSet=UTF-8");
		PrintWriter out=response.getWriter();
		
		try {
			String id=request.getParameter("id");
			
			if(id != null) {
				ArrayList<Cart> cart_list=(ArrayList<Cart>)request.getSession().getAttribute("cart-list");	
				
				  if(cart_list !=null) {
					  for(Cart c:cart_list) {
						  if(c.getId()==Integer.parseInt(id)) {
							  cart_list.remove(cart_list.indexOf(c));
							  break;
						  }
					  }
					  response.sendRedirect("cart.jsp");
					  
				  }
			}else {
			response.sendRedirect("cart.jsp");
			}
			
		}catch(Exception e) {
			e.printStackTrace();
	       
		}
	}

}
