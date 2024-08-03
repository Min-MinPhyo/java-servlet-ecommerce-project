package com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.db.dbConnect;
import com.model.Order;
import com.model.Product;

public class OrderDao {

	private Connection conn;

	public OrderDao(Connection con) {
		super();
		this.conn = con;

	}

	public boolean insertOrder(Order model) {
		boolean result = false;

	
		try {
			String sql="insert into ordering(product_id,user_id,order_quantity,order_date) values(?,?,?,?)";
		
			PreparedStatement ps=conn.prepareStatement(sql);
			ps.setInt(1,model.getId());
			ps.setInt(2, model.getUid());
			ps.setInt(3,model.getQuantity());
			ps.setString(4,model.getDate());
			int i=ps.executeUpdate();
			System.out.println("Ps is "+i);
			
			result=true;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return result;
			
	}
	
public List<Order> userOrders(int id){
	List<Order> list=new ArrayList<>();
	
	try {
		
		
		String query="select * from ordering where user_id=? order by ordering.order_id desc";
		PreparedStatement ps=conn.prepareStatement(query);
		
		ps.setInt(1, id);
		ResultSet rs=ps.executeQuery();
		
		
		while(rs.next()) {
			Order order=new Order();
			ProductDao productDao =new ProductDao(this.conn);
			
			int pId=rs.getInt("product_id");
			
			
			Product product=productDao.getSingleProduct(pId);
			 order.setOrderId(rs.getInt("order_id"));
			 order.setId(pId);
			 order.setName(product.getName());
			 order.setCategory(product.getCategory());
			 order.setQuantity(rs.getInt("order_quantity"));
			 order.setPrice(product.getPrice()*rs.getInt("order_quantity"));
			 order.setDate(rs.getString("order_date"));
			 list.add(order);
			 
			 
			 
		
		}
		
		
	}catch(Exception e) {
		e.printStackTrace();
	}
	
	
	
	return list;
}
public void canelOrder(int id) {
	try {
		String query="delete from ordering where order_id=?";
		
		PreparedStatement ps=conn.prepareStatement(query);
		ps.setInt(1,id);
		ps.execute();
		
	
}catch(Exception e) {
	e.printStackTrace();
}
}
}
