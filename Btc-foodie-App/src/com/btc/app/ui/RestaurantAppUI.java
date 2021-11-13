package com.btc.app.ui;

import java.sql.SQLException;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

import com.btc.app.exception.InvalidRestaurantID;
import com.btc.app.exception.InvalidRestaurantNameException;
import com.btc.app.exception.InvalidTypeException;
import com.btc.app.exception.NotFoundException;
import com.btc.app.model.Restaurant;
import com.btc.app.service.RestaurantService;
import com.btc.app.service.RestaurantServiceImpl;

public class RestaurantAppUI {
	private Scanner scanner=new Scanner(System.in);
	private static RestaurantService service=new RestaurantServiceImpl();

	public void addRestaurant()  {
		Restaurant restaurant= new Restaurant();
		System.out.println("Enter Restaurant Details :  ");
		System.out.print("Restaurant ID : ");
		int restaurantId=scanner.nextInt();
		try {
			
			if(restaurantId<1000)
			{
				throw new InvalidRestaurantID("Enter four digit Restaurant Id : "+restaurantId);
			}
			restaurant.setRestaurantID(restaurantId);
		} catch (InputMismatchException e) {
			// TODO: handle exception
			e.getMessage();
			System.out.println("Enter the Integer Value ");
		}
		
			System.out.print("Restaurant Name : ");
			String restaurantName=scanner.next()+scanner.nextLine();
			try {
				if(restaurantName.length()<2)
				{
					throw new InvalidRestaurantNameException("Enter correct User Name :"+restaurantName);
				}
				restaurant.setRestaurantName(restaurantName);
			} catch (InputMismatchException e) {
				// TODO: handle exception
				e.getMessage();
				System.out.println("Enter the correct name : "+restaurantName);
			}
			
			System.out.print("Location : ");
			String resturantlocation=scanner.next()+scanner.nextLine();
			String regex="^[a-zA-Z0-9+_.-]+@[a-zA-Z0-9.-]+$";
			
				if(resturantlocation.matches(regex)) {
					System.out.println("Correct Address");
					restaurant.setRestaurantLocation(resturantlocation);
				}
				else {
					throw new InvalidRestaurantNameException("Enter Location :");
				}
			
	
			System.out.print("Type : ");
			String Type = scanner.next();
			if(Type.length()<8)
			{
				throw new InvalidTypeException("Enter valid Type");
			}
			else {
				restaurant.setType(Type);
			}
			
			Restaurant savedRestaurant;
			try {
			savedRestaurant = service.addRestaurant(restaurant);
				System.out.println("User Added Successfully..");
				System.out.println(savedRestaurant);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			

		
	}
	
	
	public void showUserById() {
		System.out.print("Resturant ID : ");
		int ResturantID=0;
		try {
			ResturantID=scanner.nextInt();
			if(ResturantID<1000)
			{
				throw new InvalidEmployeeId("Enter four digit UserId : "+resturantId); 
("Enter four digit UserId : "+ResturantID);
			}
		} catch (InputMismatchException e) {
			// TODO: handle exception
			e.getMessage();
			System.out.println("Enter the Integer Value ");
		}
		
		Restaurant restaurant;
		try {
			restaurant = service.searchRestaurantById(RestaurantID);
			if(restaurant==null)
			{
				throw new NotFoundException("User ID Not Found : "+RestaurantID);
			}
			
			System.out.println(user); 
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
	
	public void deleteRestaurantById() 
	{
		System.out.print("Resturant ID : ");
		int ResturantID=0;
		try {
			ResturantID=scanner.nextInt();
			if(ResturantID<1000)
			{
				throw new InvalidRestaurantID("Enter four digit UserId : "+ResturantID);
			}
		} catch (InputMismatchException e) {
			// TODO: handle exception
			e.getMessage();
			System.out.println("Enter the Integer Value ");
		}
		
		try {
			boolean value = service.deleteRestaurantById(ResturantID);
			if(value==false)
			{
				throw new NotFoundException("User ID Not Found : "+ResturantID);
			}
			else {
				System.out.println("Deleted Successfully");
				
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
	
	public void updateUser()
	{
		System.out.println("Enter Resturant Details :  ");
		System.out.print("Resturant ID : ");
		int ResturantID=scanner.nextInt();
		try {
			
			if(ResturantID<1000)
			{
				throw new InvalidRestaurantID("Enter four digit restaurantId : "+ResturantID);
			}
		} catch (InputMismatchException e) {
			// TODO: handle exception
			e.getMessage();
			System.out.println("Enter the Integer Value ");
		}
		
		try {
				System.out.print("Resturant Name : ");
				String restaurantName=scanner.next()+scanner.nextLine();
				System.out.print("Location  : ");
				String Location=scanner.next()+scanner.nextLine();
				System.out.print("type : ");
				String type=scanner.next()+scanner.nextLine();
				System.out.print("RestaurantID : ");
				int RestaurantID=scanner.nextInt();
				System.out.print("Category : ");
				String Category=scanner.next();
				Restaurant restaurant= new  Restaurant(RestaurantID, restaurantName,Location, type, Category );
				 service.updateRestaurant(restaurant);
				 System.out.println("Update Successfully");
						
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}


	public void showAllRestaurantDetails() {
		// TODO Auto-generated method stub
		List<Restaurant> rList;
		try {
			rList=service.getAllRestaurant();
			for (Restaurant restaurant :rList) {
				System.out.println(restaurant.toString());
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
}


