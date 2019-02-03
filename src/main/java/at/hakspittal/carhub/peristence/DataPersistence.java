package at.hakspittal.carhub.peristence;

import java.util.List;

import at.hakspittal.carhub.Car;
import at.hakspittal.carhub.User;

public interface DataPersistence {
	
	/**
	 * Stores a new user
	 * 
	 * @param user the user to be stored
	 * @return {@code true} if the user could be stored, otherwiese {@code false}
	 */
	boolean storeUser(User user);
	
	/**
	 * Checks if user with the given username is available
	 * 
	 * @param username
	 * @return {@code true} if the user name already exists, otherwise {@code false}
	 */
	boolean userExists(String username);
	
	/**
	 * Checks if the provided password matches the user name
	 * 
	 * @param username
	 * @param password
	 * @return {@code true} if username and password is correct, otherwise {@code false}
	 */
	boolean login(String username, String password);
	
	/**
	 * Returns a list of all stored cars
	 * 
	 * @return list of cars
	 */
	List<Car> getCars();
	
	/**
	 * Stores a new car and returns the id
	 * 
	 * @param car the car to be stored
	 * @return the id the of the stored car
	 */
	int storeCar(Car car);
	
	/**
	 * Removes the car with the given {@code carId}
	 * 
	 * @param carId the id of the car
	 * @return {@code true} if the car could be removed, otherwise {@code false}
	 */
	boolean removeCar(int carId);
	
	/**
	 * Gets a list of all stored categories
	 * 
	 * @return list of categories
	 */
	List<String> getCategories();
}
