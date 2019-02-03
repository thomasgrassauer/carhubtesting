package at.hakspittal.carhub.peristence;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import at.hakspittal.carhub.Car;
import at.hakspittal.carhub.User;

public class MySqlDataPersistence implements DataPersistence {

	public MySqlDataPersistence() {
		try{
			Class.forName("com.mysql.cj.jdbc.Driver");
		}
		catch (ClassNotFoundException e){
			System.err.println("Treiber wurde nicht gefunden");
			e.printStackTrace();
		}
	}
	
	@Override
	public boolean storeUser(User user) {
		try(Connection con = getConnection()) {
			String query =  "INSERT INTO `user`(username, password, zipcode, city,  firstname, lastname) VALUES ("  +
				       "'" + user.getUsername()+"'" + "," +"'" + user.getPassword() +"'" + "," +"'" + user.getZipcode() +
				       "'" + "," +"'" + user.getCity() +"'" + "," +"'" + user.getFirstname() +"'" + "," +"'" + user.getSurname() +"'" + ")";
			PreparedStatement stmt = con.prepareStatement(query);
			stmt.executeUpdate();
			
			return stmt.getUpdateCount() == 0;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return false;
	}

	@Override
	public boolean userExists(String username) {
		try(Connection con = getConnection()) {
			String query =  "SELECT COUNT(username) as UserCount FROM `user` "
					+ "WHERE username='" + username + "'";
			PreparedStatement stmt = con.prepareStatement(query);
			ResultSet result = stmt.executeQuery();
			
			if (result.next()) {
				return result.getInt(1) > 0;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return false;
	}

	@Override
	public boolean login(String username, String password) {
		try(Connection con = getConnection()) {
			String query =  "SELECT username,password, count(username) as usercount FROM user "
					+ "WHERE username = '" + username + "' and password = '" + password + "'";
			PreparedStatement stmt = con.prepareStatement(query);
			ResultSet result = stmt.executeQuery();
			
			if (result.next()) {
				return result.getInt(1) == 1;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return false;
	}

	@Override
	public List<Car> getCars() {
		List<Car> cars = new ArrayList<>();
		
		try(Connection con = getConnection()) {
			String query = "SELECT * FROM `fahrzeuge`";
			PreparedStatement stmt = con.prepareStatement(query);	
			ResultSet result = stmt.executeQuery();
			
			while(result.next()){
				Car car= new Car(
						result.getInt(1),		// id
						result.getString(2),	// category
						result.getString(3),	// make
						result.getString(4),	// model
						result.getDate(5),		// dateOfRegistration
						result.getString(6),	// typeOfFuel
						result.getInt(7),		// mileage
						result.getString(8));	// description
				cars.add(car);
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return cars;
	}

	@Override
	public int storeCar(Car car) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public boolean removeCar(int carId) {
		try(Connection con = getConnection()) {
			String query = "DELETE FROM `fahrzeuge` WHERE id = " + carId;
			//System.out.println(query);
			PreparedStatement stmt = con.prepareStatement(query);
			stmt.executeUpdate();
			
			return stmt.getUpdateCount() == 1;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return false;
	}
	
	@Override
	public List<String> getCategories() {
		List<String> categories = new ArrayList<>();
		
		try(Connection con = getConnection()) {
			String query = "SELECT * FROM `category`";
					
			PreparedStatement stmt = con.prepareStatement(query);
			ResultSet result = stmt.executeQuery();
			
			while(result.next()) {
				categories.add(result.getString(2));
			}
		}  catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return categories;
	}

	private Connection getConnection() throws SQLException {
		return DriverManager.getConnection("jdbc:mysql://localhost:3306/carhub", "carhub", "carhub");
	}
}
