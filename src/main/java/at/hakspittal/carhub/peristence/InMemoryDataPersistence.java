package at.hakspittal.carhub.peristence;

import java.util.ArrayList;
import java.util.List;

import at.hakspittal.carhub.Car;
import at.hakspittal.carhub.User;

public class InMemoryDataPersistence implements DataPersistence {
	private int nextCarId = 1; // id should start with 1 
	
	private final List<Car> cars = new ArrayList<>();
	private final List<User> users = new ArrayList<>();
	
	public InMemoryDataPersistence() {
		// add admin user
		this.users.add(new User("admin", "admin", "1000", "city", "ad", "min"));
	}
	
	@Override
	public boolean storeUser(User user) {
		this.users.add(user);
		return true;
	}

	@Override
	public boolean userExists(String username) {
		return this.users.contains(new User(username));
	}

	@Override
	public boolean login(String username, String password) {
		int userIndex = this.users.indexOf(new User(username));
		
		if (userIndex == -1) {
			// user not found
			return false;
		}
		
		return this.users.get(userIndex).getPassword().equals(password);
	}

	@Override
	public List<Car> getCars() {
		return this.cars;
	}

	@Override
	public int storeCar(Car car) {
		int carId = this.nextCarId;
		this.nextCarId++;
		
		// now that we know the index we need to create a new car instance
		Car carToStore = new Car(
				carId,
				car.getCategory(),
				car.getMake(),
				car.getModel(),
				car.getDateOfRegistration(),
				car.getTypeOfFuel(),
				car.getMileage(),
				car.getDescription());
		
		// store car
		this.cars.add(carToStore);
		
		// return id of stored car
		return carId;
	}

	@Override
	public boolean removeCar(int carId) {
		int carIndex = this.cars.indexOf(new Car(carId));
		
		if (carIndex == -1) {
			return false;
		}
		
		this.cars.remove(new Car(carId));
		return true;
	}
	
	@Override
	public List<String> getCategories() {
		List<String> categories = new ArrayList<>();
		
		categories.add("Category 1");
		categories.add("Category 2");
		categories.add("Category 3");
		
		return categories;
	}
}
