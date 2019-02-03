package at.hakspittal.carhub.services;

import at.hakspittal.carhub.User;
import at.hakspittal.carhub.peristence.DataPersistence;

public class UserService {
	public enum RegistrationResult {
		OK,
		USER_EXISTS,
		ERROR
	}
	
	private final DataPersistence persistence;
	
	public UserService(DataPersistence persistence) {
		this.persistence = persistence;
	}
	
	/**
	 * Register a new users if the username was not used before.
	 * 
	 * @param user
	 * @return
	 */
	public RegistrationResult registerUser(User user) {
		// check if username already exists
		boolean userExists = persistence.userExists(user.getUsername());
		
		if (userExists) {
			// user name not available
			return RegistrationResult.USER_EXISTS;
		}
		
		if (persistence.storeUser(user)) {
			return RegistrationResult.OK;
		}
		
		return RegistrationResult.ERROR;
	}
	
	/**
	 * Checks whether the provided credentials are valid or not
	 * 
	 * @param username
	 * @param password
	 * @return
	 */
	public boolean login(String username, String password) {
		return this.persistence.login(username, password);
	}
}
