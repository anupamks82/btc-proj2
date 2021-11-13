package com.btc.app.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLDataException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.btc.app.model.Restaurant;

public class RestaurantDaoJdbcImpl implements RestaurantDao {
	
	 private Connection con;
		
		private PreparedStatement smt;

	@Override
	public Restaurant addRestaurant(Restaurant restaurant) throws SQLException {
		String query = "insert into user values(?,?,?,?,?,?)";
		try {
		   con=ConnectionUtil.getDbConnection();
		   smt= con.prepareStatement(query);
		
			smt.setInt(1, restaurant.getRestaurantID());
			smt.setString(2, restaurant.getRestaurantName());
			smt.setString(3, restaurant.getRestaurantLocation());
			smt.setString(4, restaurant.getRestaurantType());
			smt.setString(5, restaurant.getRestaurantCategory());
			
			int insertedRowCount = smt.executeUpdate();
			if(insertedRowCount>0) {
				return restaurant;
			}
		}catch (DuplicateDataException | SQLException e) {
			// TODO: handle exception
			   throw new DuplicateDataException("Already Exists");
			}
		
		return null;
	}

	@Override
	public Restaurant searchRestaurantById(int restaurantID) throws SQLException {
		String query="select * from user where uid=?";
		smt=con.prepareStatement(query);
		
		smt.setInt(1, restaurantID);	
		
		ResultSet queryResult = smt.executeQuery();
		
		Restaurant rt=null;
		
		if(queryResult.next()) {
			rt=new Restaurant();
			rt.setRestaurantID(restaurantID);
			rt.setRestaurantName(queryResult.getString("Rname"));
			rt.setRestaurantLocation(queryResult.getString("Location"));
			rt.setRestaurantType(queryResult.getString("Resturant Type"));
			rt.setRestaurantCategory(queryResult.getString("Resturant Category"));
		}
		
		return rt;

	}

	@Override
	public boolean deleteRestaurantById(int restaurantID) throws SQLException {
		 String query = "delete from user where uid=?";
		   con=ConnectionUtil.getDbConnection();
		   smt= con.prepareStatement(query);
		   smt.setInt(1, restaurantID);
		   int deleted = smt.executeUpdate();
		   if(deleted==0)
		   {
			   return false;
		   }else {
			   return true;
		   }
	
	}

	@Override
	public Restaurant updateRestaurant(Restaurant restaurant) throws SQLException {
		String query = "UPDATE user SET rid = ?,rname=? ,location=?,type =?,Category =?,WHERE rid =?";
		
		con=ConnectionUtil.getDbConnection();
		smt= con.prepareStatement(query);
		
		smt.setInt(1, restaurant.getRestaurantID());
		smt.setString(2, restaurant.getRestaurantName());
		smt.setString(3, restaurant.getRestaurantLocation());
		smt.setString(4, restaurant.getRestaurantType());
		smt.setString(5, restaurant.getRestaurantCategory());
		
		int insertedRowCount = smt.executeUpdate();
		if(insertedRowCount>0) {
			return restaurant;
		}  
		return null;
	}
		// TODO Auto-generated method stub

	@Override
	public List<Restaurant> getAllRestaurant() throws SQLException {
		String query="select * from user";
		con=ConnectionUtil.getDbConnection();
		smt= con.prepareStatement(query);
		
		ResultSet rst = smt.executeQuery();
		
		List<Restaurant> restaurant=new ArrayList<Restaurant>();
		
		while(rst.next()) {
			Restaurant rt = new Restaurant();
			rt.setRestaurantID(rst.getInt("rid"));
			rt.setRestaurantName(rst.getString("rname"));
			rt.setRestaurantLocation(rst.getString("Location"));
			rt.setRestaurantType(rst.getString("Type"));
			rt.setRestaurantCategory(rst.getString("Category"));
			restaurant.add(rt);
		}
		
		return restaurant;
		}

}
