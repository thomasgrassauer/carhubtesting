package at.hakspittal.carhub;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection {
	
	private Connection  con;

	public DBConnection(){
		try{
			Class.forName("com.mysql.jdbc.Driver");
		}
		catch (ClassNotFoundException e){
			System.err.println("Treiber wurde nicht gefunden");
			e.printStackTrace();
		}
	}
	
	public Connection getConnection() {
		return this.con;
	}

	public void connectDB(){
		try{
			//System.out.println("Baue Verbindung auf");
			con = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/carhub", "carhub", "carhub");
			
		}
		catch (SQLException e){
			e.printStackTrace();
			
		}
	}

}
