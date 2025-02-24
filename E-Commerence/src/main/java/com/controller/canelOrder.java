package com.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dao.OrderDao;
import com.db.dbConnect;

/**
 * Servlet implementation class canelOrder
 */
@WebServlet("/cancelOrder")
public class canelOrder extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public canelOrder() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	try {
		
		response.setContentType("text/html,charEncoding=utf8");
		PrintWriter out=response.getWriter();
		
	    String id=request.getParameter("id");
	    
	    if(id !=null) {
	    	OrderDao oDao=new OrderDao(dbConnect.getConnection());
	    	oDao.canelOrder(Integer.parseInt(id));
	    	
	    }
		response.sendRedirect("orders.jsp");
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
