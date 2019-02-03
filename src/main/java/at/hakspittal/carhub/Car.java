package at.hakspittal.carhub;

import java.util.Date;

public class Car {

	private final int id;
	private final String category;
	private final String make;
	private final String model;
	private final Date dateOfRegistration;
	private final String typeOfFuel;
	private final int mileage;
	private final String description;
	
	public Car(int id) {
		this(id, null, null, null, null, null, 0, null);
	}
	
	public Car (String category, String make, String model, Date dateOfRegistration, 
			String typeOfFuel, int mileage, String description) {
		this(0, category, make, model, dateOfRegistration, typeOfFuel, mileage, description);
	}
	
	public Car(int id, String category, String make, String model, 
			Date dateOfRegistration, String typeOfFuel,	int mileage, String description) {
		this.id = id;
		this.category = category;
		this.make = make;
		this.model = model;
		this.dateOfRegistration = dateOfRegistration;
		this.typeOfFuel = typeOfFuel;
		this.mileage = mileage;
		this.description = description;
	}
	
	public int getId() {
		return id;
	}
	public String getCategory() {
		return category;
	}
	public String getMake() {
		return make;
	}
	public String getModel() {
		return model;
	}
	public Date getDateOfRegistration() {
		return dateOfRegistration;
	}
	public String getTypeOfFuel() {
		return typeOfFuel;
	}
	public int getMileage() {
		return mileage;
	}
	public String getDescription() {
		return description;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + id;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Car other = (Car) obj;
		if (id != other.id)
			return false;
		return true;
	}
	
	
}
