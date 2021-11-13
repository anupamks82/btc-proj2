package com.btc.app.service;

import java.sql.SQLException;
import java.util.List;

import com.btc.app.model.Restaurant;

public interface RestaurantService {
public Restaurant addRestaurant(Restaurant restaurant) throws SQLException;
	
	public Restaurant searchRestaurantById(int restaurantId) throws SQLException;
	
	public boolean deleteRestaurantById(int restaurantId) throws SQLException;
		
	public Restaurant updateRestaurant(Restaurant restaurant) throws SQLException;
	
	public List<Restaurant> getAllRestaurant() throws SQLException;

}
