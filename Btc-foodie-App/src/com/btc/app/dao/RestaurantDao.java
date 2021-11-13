package com.btc.app.dao;

import java.sql.SQLException;
import java.util.List;

import com.btc.app.model.Restaurant;

public interface RestaurantDao {
	 public Restaurant addRestaurant(Restaurant restaurant) throws SQLException;
		
		public Restaurant searchRestaurantById(int restaurantID) throws SQLException ;
		
		public boolean deleteRestaurantById(int restaurantID)throws SQLException;
		
		public Restaurant updateRestaurant(Restaurant restaurant) throws SQLException;
		
		public List<Restaurant> getAllRestaurant() throws SQLException;

}
