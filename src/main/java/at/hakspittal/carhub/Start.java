package at.hakspittal.carhub;

import at.hakspittal.carhub.peristence.DataPersistence;
import at.hakspittal.carhub.peristence.InMemoryDataPersistence;
import at.hakspittal.carhub.ui.LogIn;

public class Start {

	private static DataPersistence PERSISTENCE;
	
	static {
		PERSISTENCE = new InMemoryDataPersistence();
	}
	
	public static void main(String[] args) {
		LogIn start = new LogIn();
		start.setVisible(true);
	}

	/**
	 * @return singleton instance for data persistence
	 */
	public static DataPersistence getPersistance() {
		return PERSISTENCE;
	}
}