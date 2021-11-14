package com.btc.app;

import java.sql.SQLException;
import java.util.Scanner;

import com.btc.app.model.Restaurant;


public class RestaurantAppRunner {
	public static void main(String[] args) throws SQLException {
		Scanner scanner =new Scanner(System.in);
		Restaurant appUI = new Restaurant();
		
		while (true) {
			System.out.println("Enter a option :\n [1 - Add Restaurant] \n [2 - Search Id] \n [0 - Exit]");
			int option = scanner.nextInt();

			switch (option) {
			case 1:
				appUI.addRestauran();
				break;
			case 2:
				appUI.showRestauran();
				break;

			case 0:
				System.exit(1);
				break;

			default:
				throw new IllegalArgumentException("Invalid Option: " + option);
			}

			System.out.println("\n");

		}
	}


}
