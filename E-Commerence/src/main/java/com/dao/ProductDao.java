package com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.model.Cart;
import com.model.Product;

public class ProductDao {
	private  Connection con;

	public ProductDao(Connection con) {
		super();
		this.con = con;
	}
	
	public List<Product> getAllProducts(){
		List<Product> products=new ArrayList<Product> ();
		
	
		try {
			String sql="select * from product";
			PreparedStatement ps=con.prepareStatement(sql);
			ResultSet rs=ps.executeQuery();
			
			while(rs.next()) {
				Product product=new Product();
				product.setId(rs.getInt("id"));
				product.setName(rs.getString("name"));
				product.setCategory(rs.getString("category"));
				product.setPrice(rs.getDouble("price"));
				product.setImage(rs.getString("image"));
				products.add(product);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return products;
		
	}
	
	public List<Cart> getCartProducts(ArrayList<Cart> cartList){
		List<Cart> products=new ArrayList<Cart>();
		
		try {
			if(cartList.size()>0) {
				for(Cart item:cartList) {
					String sql="select * from product where id=?";
					PreparedStatement ps=con.prepareStatement(sql);
					ps.setInt(1,item.getId());
					
					ResultSet rs=ps.executeQuery();
					
					while(rs.next()) {
						Cart c=new Cart();
						c.setId(rs.getInt("id"));
						c.setName(rs.getString("name"));
						c.setCategory(rs.getString("category"));
						c.setPrice(rs.getDouble("price")*item.getQuantity());
						c.setQuantity(item.getQuantity());
						
						products.add(c);
					}
					
					
				}
					
					
				}
					
		
	}catch(Exception e) {
		
	    System.out.println(e.getMessage());
		e.printStackTrace();
		
		
	}
		return products;
	
	
	

}
	

	public double getCartTotal(List<Cart> cartList) {
		double sum=0;
		
		try {
			if(cartList.size()>0) {
				for(Cart item:cartList) {
				
					String sql="select price from product where id=?";
					PreparedStatement ps=con.prepareStatement(sql);
					ps.setInt(1,item.getId());

					
					ResultSet rs=ps.executeQuery();
					System.out.println(rs);
					
					
					
					while(rs.next())
					{
						sum+=rs.getDouble("price")*item.getQuantity();		}
					System.out.print(sum);
				}
			}else {
				System.out.println("Ma shi buu");
			}
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		return sum;
		
		
		
		
	}
	
	public Product getSingleProduct(int id) {
		Product row=null;
		try {
			String sql="select * from product where id=?";
			PreparedStatement ps=con.prepareStatement(sql);
			ps.setInt(1, id);
			
			ResultSet rs=ps.executeQuery();
			
			while(rs.next()) {
				row=new Product();
				row.setId(rs.getInt("id"));
				row.setName(rs.getString("name"));
				row.setCategory(rs.getString("category"));
				row.setPrice(rs.getDouble("price"));
				row.setImage(rs.getString("image"));
			}
			
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		return row;
	}
}
