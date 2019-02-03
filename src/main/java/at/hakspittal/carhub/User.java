package at.hakspittal.carhub;

public class User {

	private String username;
	private String password;
	private String zipcode;
	private String city;
	private String firstname;
	private String surname;
	
	public User(String username, String password, String zipcode, String city, String firstname, String surname) {
		super();
		this.username = username;
		this.password = password;
		this.zipcode = zipcode;
		this.city = city;
		this.firstname = firstname;
		this.surname = surname;
	}
	
	
	public String getUsername() {
		return username;
	}
	
	public String getPassword() {
		return password;
	}
	
	public String getZipcode() {
		return zipcode;
	}
	
	public String getCity() {
		return city;
	}
	
	public String getFirstname() {
		return firstname;
	}
	
	public String getSurname() {
		return surname;
	}
	
	
}
