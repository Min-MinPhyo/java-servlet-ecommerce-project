package com.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dao.OrderDao;
import com.db.dbConnect;
import com.model.Cart;
import com.model.Order;
import com.model.User;

/**
 * Servlet implementation class checkOut
 */
@WebServlet("/checkOut")
public class checkOut extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public checkOut() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		try{response.setContentType("text/html,charEncoding=utf8");
		PrintWriter out=response.getWriter();
		SimpleDateFormat formatter=new SimpleDateFormat("yyyy-mm-dd");
		
		Date d=new Date();
		
		
		ArrayList<Cart> cart_list=(ArrayList<Cart>)request.getSession().getAttribute("cart-list");
		User auth=(User)request.getSession().getAttribute("auth");
		
		
		if(cart_list !=null && auth !=null) {
			for(Cart c:cart_list) {
				
				Order order=new Order();
				order.setId(c.getId());
				order.setUid(auth.getId());
				order.setQuantity(c.getQuantity());
				order.setDate(formatter.format(d));
			   OrderDao oDao=new OrderDao(dbConnect.getConnection());
					
					boolean result=oDao.insertOrder(order);
					
					   if(!result) {
						   break;
					   }
					   cart_list.clear();
					   response.sendRedirect("orders.jsp");
					   
		
				
				
				
			}
		}else {
			if(auth ==null)
				response.sendRedirect("login.jsp");
			    //response.sendRedirect("cart.jsp");
			    
			
		}
		}catch(Exception e) {
			e.printStackTrace();
		}
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
