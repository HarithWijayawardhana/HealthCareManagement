package s1142_5.appointment.db;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import s1142_5.appointment.model.Apointment;
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
	
	
	public static ArrayList<Apointment> getAppointments(int timeSlotID)
	{
		ArrayList<Apointment> list  = new ArrayList<Apointment>();
		try {
			
			String query = "SELECT * FROM mydb.appointment WHERE timeSlot = '"+ String.valueOf(timeSlotID) +"'";
			
			PrepareStat = Conn.prepareStatement(query);
			//PrepareStat.setInt(0,123);
			
			//System.out.println(PrepareStat.toString());
			
			ResultSet rs = PrepareStat.executeQuery();
			
			while(rs.next()) 
			{
				Apointment ap = new Apointment(
						rs.getInt("number"),
						rs.getInt("timeSlot"),
						rs.getInt("patientID")
						);
				list.add(ap);
			}

			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		return list;
	} 
	
	
	public static ArrayList<TimeSlot> getTimeSlots(int docID)
	{
		
		ArrayList<TimeSlot> list  = new ArrayList<TimeSlot>();
		try {
			
			String query = "SELECT * FROM mydb.timeslot WHERE docID = '"+ String.valueOf(docID) +"'";
			
			PrepareStat = Conn.prepareStatement(query);
			//PrepareStat.setInt(0,123);
			
			//System.out.println(PrepareStat.toString());
			
			ResultSet rs = PrepareStat.executeQuery();
			
			while(rs.next()) 
			{
				TimeSlot ts = new TimeSlot(
						rs.getInt("timeSlotID"),
						rs.getInt("docID"),
						rs.getString("startTime"),
						rs.getString("endTime"),
						rs.getInt("wardID"),
						rs.getInt("patientLimit"),
						rs.getString("date")
						);
				list.add(ts);
			}
			// 
//						// Let's iterate through the java ResultSet
//						while (rs.next()) {
//							String name = rs.getString("Name");
//							String address = rs.getString("Address");
//							int employeeCount = rs.getInt("EmployeeCount");
//							String website = rs.getString("Website");
			// 
//							// Simply Print the results
//							System.out.format("%s, %s, %s, %s\n", name, address, employeeCount, website);
//						}
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		return list;
		
		
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

	public static void addApoitment(Apointment app) {
		
		try {
			PrepareStat = Conn.prepareStatement("INSERT INTO `mydb`.`appointment` (`number`, `timeSlot`, `patientID`) VALUES ('"+app.getNumber()+
					"', '"+app.getTimeSlot()+"', '"+app.getPatientID()+"');");
//			PrepareStat.setInt(1, app.getNumber());
//			PrepareStat.setInt(2, app.getTimeSlot());
//			PrepareStat.setInt(3, app.getPatientID());
			
			PrepareStat.executeUpdate();
			
		
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		
	}

	public static void deleteAppointment(int number, int timeSlot) {
		
		//DELETE FROM `mydb`.`appointment` WHERE (`timeSlot` = '1') and (`number` = '3');
		String query = "DELETE FROM `mydb`.`appointment` WHERE `timeSlot` = '"+timeSlot+"' and `number` = '"+number+"'";
		try {
			
			PrepareStat = Conn.prepareStatement("DELETE FROM `mydb`.`appointment` WHERE (`timeSlot` = '"+timeSlot+"') and (`number` = '"+number+"')");
			int n = PrepareStat.executeUpdate();
			
			System.out.println("Running" + query + " "+  n);
			Conn.close();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("Error");
			e.printStackTrace();
			
		}
		
		
		
	}
	
	
	public static void updateAppointment(int oldTimeSlot , int oldNumber , int newTimeSlot , int newNumber) 
	{
		String query = "UPDATE `mydb`.`appointment` SET `number` = '"+newNumber+"', `timeSlot` = '"+newTimeSlot+"' WHERE (`timeSlot` = '"
				+oldTimeSlot+"') and (`number` = '"+oldNumber+"');";

		try {
			
			PrepareStat = Conn.prepareStatement(query);
			int n = PrepareStat.executeUpdate();
			
			System.out.println("Running" + query + " "+  n);
			Conn.close();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("Error");
			e.printStackTrace();
			
		}
	}
	

}
