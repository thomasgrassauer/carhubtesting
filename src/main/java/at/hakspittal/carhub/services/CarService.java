package at.hakspittal.carhub.services;

import java.util.List;

import at.hakspittal.carhub.Car;
import at.hakspittal.carhub.peristence.DataPersistence;

public class CarService {
	private final DataPersistence persistence;
	
	public CarService(DataPersistence persistence) {
		this.persistence = persistence;
	}
	
	public List<Car> getCars() {
		return this.persistence.getCars();
	}
	
	/**
	 * Removes the information of the car
	 * 
	 * @param car
	 * @return
	 */
	public boolean buyCar(Car car) {
		return this.persistence.removeCar(car.getId());
	}
	
	/**
	 * Stores the information for the sold car
	 * 
	 * @param car
	 * @return
	 */
	public boolean sellCar(Car car) {
		// a car with an existing id cannot be sold
		if (car.getId() != 0) {
			return false;
		}
		
		// the operation was valid if and id > 0 was set
		return this.persistence.storeCar(car) > 0;
	}
}
