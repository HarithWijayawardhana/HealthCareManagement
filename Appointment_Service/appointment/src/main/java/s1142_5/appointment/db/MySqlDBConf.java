package s1142_5.appointment.db;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import s1142_5.appointment.model.TimeSlot;

public class MySqlDBConf {
	
	static Connection Conn = null;
	static PreparedStatement PrepareStat = null;
 
//	public static void main(String[] argv) {
// 
//		try {
//			log("-------- Simple Crunchify Tutorial on how to make JDBC connection to MySQL DB locally on macOS ------------");
//			makeJDBCConnection();
// 
//			log("\n---------- Adding company 'Crunchify LLC' to DB ----------");
//			addDataToDB("Crunchify, LLC.", "NYC, US", 5, "https://crunchify.com");
//			addDataToDB("Google Inc.", "Mountain View, CA, US", 50000, "https://google.com");
//			addDataToDB("Apple Inc.", "Cupertino, CA, US", 30000, "http://apple.com");
// 
//			log("\n---------- Let's get Data from DB ----------");
//			getDataFromDB();
// 
//			crunchifyPrepareStat.close();
//			crunchifyConn.close(); // connection close
// 
//		} catch (SQLException e) {
// 
//			e.printStackTrace();
//		}
//	}
 
	public static void makeJDBCConnection() {
 
		try {
			Class.forName("com.mysql.jdbc.Driver");
			System.out.println("Congrats - Seems your MySQL JDBC Driver Registered!");
		} catch (ClassNotFoundException e) {
			System.out.println("Sorry, couldn't found JDBC driver. Make sure you have added JDBC Maven Dependency Correctly");
			e.printStackTrace();
			return;
		}
 
		try {
			// DriverManager: The basic service for managing a set of JDBC drivers.
			Conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/mydb", "root", "password");
			if (Conn != null) {
				System.out.println("Connection Successful! Enjoy. Now it's time to push data");
			} else {
				System.out.println("Failed to make connection!");
			}
		} catch (SQLException e) {
			System.out.println("MySQL Connection Failed!");
			e.printStackTrace();
			return;
		}
		
	}
	
	public static void registerTimeSlot(TimeSlot ts) 
	{
		String insertQueryStatement = "INSERT  INTO  Employee  (`docID`, `startTime`, `endTime`, `wardID`, `patientLimit`, `date`) VALUES  (?,?,?,?,?,?)";
		
		try {
			PrepareStat = Conn.prepareStatement("INSERT  INTO  timeslot  (`docID`, `startTime`, `endTime`, `wardID`, `patientLimit`, `date`) VALUES  (?,?,?,?,?,?)");
			PrepareStat.setInt(1, ts.getDocID());
			PrepareStat.setString(2, ts.getStartTime());
			PrepareStat.setString(3, ts.getEndTime());
			PrepareStat.setInt(4, ts.getWardID());
			PrepareStat.setInt(5, ts.getPatientLinit());
			PrepareStat.setString(6, ts.getDate());
			
			PrepareStat.executeUpdate();
			log(" added successfully");
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			log(" Adding Failed successfully");
			e.printStackTrace();
		}
		
		
		
	}
	
	
// 
//	private static void addDataToDB(String companyName, String address, int totalEmployee, String webSite) {
// 
//		try {
//			String insertQueryStatement = "INSERT  INTO  Employee  VALUES  (?,?,?,?)";
// 
//			crunchifyPrepareStat = crunchifyConn.prepareStatement(insertQueryStatement);
//			crunchifyPrepareStat.setString(1, companyName);
//			crunchifyPrepareStat.setString(2, address);
//			crunchifyPrepareStat.setInt(3, totalEmployee);
//			crunchifyPrepareStat.setString(4, webSite);
// 
//			// execute insert SQL statement
//			crunchifyPrepareStat.executeUpdate();
//			log(companyName + " added successfully");
//		} catch (
// 
//		SQLException e) {
//			e.printStackTrace();
//		}
//	}
// 
//	private static void getDataFromDB() {
// 
//		try {
//			// MySQL Select Query Tutorial
//			String getQueryStatement = "SELECT * FROM employee";
// 
//			crunchifyPrepareStat = crunchifyConn.prepareStatement(getQueryStatement);
// 
//			// Execute the Query, and get a java ResultSet
//			ResultSet rs = crunchifyPrepareStat.executeQuery();
// 
//			// Let's iterate through the java ResultSet
//			while (rs.next()) {
//				String name = rs.getString("Name");
//				String address = rs.getString("Address");
//				int employeeCount = rs.getInt("EmployeeCount");
//				String website = rs.getString("Website");
// 
//				// Simply Print the results
//				System.out.format("%s, %s, %s, %s\n", name, address, employeeCount, website);
//			}
// 
//		} catch (
// 
//		SQLException e) {
//			e.printStackTrace();
//		}
// 
//	}
 
	// Simple log utility
	private static void log(String string) {
		System.out.println(string);
 
	}

}
