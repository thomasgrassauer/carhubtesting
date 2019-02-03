package at.hakspittal.carhub;

public class User {

	private String username;
	private String password;
	private String zipcode;
	private String city;
	private String firstname;
	private String surname;
	
	public User(String username) {
		this.username = username;
	}
	
	public User(String username, String password, String zipcode, String city, String firstname, String surname) {
		this(username);
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

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((username == null) ? 0 : username.hashCode());
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
		User other = (User) obj;
		if (username == null) {
			if (other.username != null)
				return false;
		} else if (!username.equals(other.username))
			return false;
		return true;
	}
}
