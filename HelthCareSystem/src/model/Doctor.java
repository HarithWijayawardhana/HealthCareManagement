package model;
import java.sql.*;
//import java.util.ArrayList;
//import java.util.List;
import bean.docBean;


public class Doctor
{ 
	//A common method to connect to the DB
	private Connection connect()
	{
		Connection con = null;
		try
		{
			Class.forName("com.mysql.cj.jdbc.Driver");
			//Provide the correct details: DBServer/DBName, username, password
			con = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/hospital_mgt?autoReconnect=true&serverTimezone=UTC&useSSL=False&allowPublicKeyRetrieval=true", "root", "");
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
		return con;
	}
	public String insertDoctor(String fname, String lname, String specialization, String gender, String email, String contactno, String fees, String password)
	{
		String output = "";
		try
		{
			Connection con = connect();
			if (con == null)
			{
				return "Error while connecting to the database for inserting."; 
			}
			// create a prepared statement
			String query = " insert into doctor (`docId`,`FirstName`,`LastName`,`Specialization`,`Gender`,`Email`,`ContactNo`,`StandardFees`,`Password`)"
							+ " values (?, ?, ?, ?, ?, ?, ?, ?, ?)";
			PreparedStatement preparedStmt = con.prepareStatement(query);
			
			// binding values
			preparedStmt.setInt(1, 0);
			preparedStmt.setString(2, fname);
			preparedStmt.setString(3, lname);
			preparedStmt.setString(4, specialization);
			preparedStmt.setString(5, gender);
			preparedStmt.setString(6, email);
			preparedStmt.setString(7, contactno);
			preparedStmt.setDouble(8, Double.parseDouble(fees));
			preparedStmt.setString(9, password);
			
	// execute the statement
	preparedStmt.execute();
	con.close();
	output = "Inserted successfully";
	}
	catch (Exception e)
	{
	output = "Error while inserting the doctor.";
	System.err.println(e.getMessage());
	}
	return output;
	}
	
	public String readDoctors()
	{
		String output = "";
		try
		{
			Connection con = connect();
			if (con == null)
			{
				return "Error while connecting to the database for reading."; 
			}
			
	// Prepare the html table to be displayed
	output = "<table border=\"1\"><tr><th>First Name</th><th>Last Name</th><th>Specialization</th><th>Gender</th><th>Email</th><th>ContactNo</th><th>Standard Fees</th><th>Password</th><th>Update</th><th>Remove</th></tr>";
	String query = "select * from doctor";
	Statement stmt = con.createStatement();
	ResultSet rs = stmt.executeQuery(query);
	// iterate through the rows in the result set
	while (rs.next())
	{
	String docId = Integer.toString(rs.getInt("docId"));
	String FirstName = rs.getString("FirstName");
	String LastName = rs.getString("LastName");
	String Specialization = rs.getString("Specialization");
	String Gender = rs.getString("Gender");
	String Email = rs.getString("Email");
	String ContactNo = rs.getString("ContactNo");
	String StandardFees = Double.toString(rs.getDouble("StandardFees"));
	String Password = rs.getString("Password");
	
	// Add into the html table
	output += "<tr><td>" + FirstName + "</td>";
	output += "<td>" + LastName + "</td>";
	output += "<td>" + Specialization + "</td>";
	output += "<td>" + Gender + "</td>";
	output += "<td>" + Email + "</td>";
	output += "<td>" + ContactNo + "</td>";
	output += "<td>" + StandardFees + "</td>";
	output += "<td>" + Password + "</td>";
	
	// buttons
	output += "<td><input name=\"btnUpdate\" type=\"button\"value=\"Update\" class=\"btn btn-secondary\"></td>"
	+ "<td><form method=\"post\" action=\"index.jsp\">"
	+ "<input name=\"btnRemove\" type=\"submit\" value=\"Remove\"class=\"btn btn-danger\">"
	+ "<input name=\"docId\" type=\"hidden\" value=\"" + docId
	+ "\">" + "</form></td></tr>";
	}
	con.close();
	// Complete the html table
	output += "</table>";
	}
	catch (Exception e)
	{
	output = "Error while reading the doctors.";
	System.err.println(e.getMessage());
	}
	return output;
	}

	public String updateDoctor(String docid, String fname, String lname, String specialization, String gender, String email, String contactno, String fees, String password)
	{
		String output = "";
		try
		{
			Connection con = connect();
			if (con == null)
			{return "Error while connecting to the database for updating."; }
			
			// create a prepared statement
			String query = "UPDATE doctor SET FirstName=?,LastName=?,Specialization=?,Gender=?,Email=?,ContactNo=?,StandardFees=?,Password=?WHERE docId=?";
			PreparedStatement preparedStmt = con.prepareStatement(query);
			
			// binding values
			preparedStmt.setString(1, fname);
			preparedStmt.setString(2, lname);
			preparedStmt.setString(3, specialization);
			preparedStmt.setString(4, gender);
			preparedStmt.setString(5, email);
			preparedStmt.setString(6, contactno);
			preparedStmt.setDouble(7, Double.parseDouble(fees));
			preparedStmt.setString(8, password);
			preparedStmt.setInt(9, Integer.parseInt(docid));
			// execute the statement
			preparedStmt.execute();
			con.close();
			output = "Updated successfully";
			}
	catch (Exception e)
	{
	output = "Error while updating the doctor.";
	System.err.println(e.getMessage());
	}
	return output;
	}
	
	public String deleteDoctor(String docId)
	{
		String output = "";
		try
		{
			Connection con = connect();
			if (con == null)
			{return "Error while connecting to the database for deleting."; }
			
			// create a prepared statement
			String query = "delete from doctor where docId=?";
			PreparedStatement preparedStmt = con.prepareStatement(query);
			// binding values
			preparedStmt.setInt(1, Integer.parseInt(docId));
			// execute the statement
			preparedStmt.execute();
			con.close();
			output = "Deleted successfully";
			}
			catch (Exception e)
			{
			output = "Error while deleting the doctor.";
			System.err.println(e.getMessage());
			}
			return output;
	}
	
	public String doctorLogin(docBean docBean)
	{
 
		String email = docBean.getEmail(); //Keeping user entered values in temporary variables.
		String password = docBean.getPassword();
		
		String EmailDB = "";
		String passwordDB = "";
		
		String sql = "SELECT Email, Password FROM Doctor";
 
		try
		{
			Connection con = connect();
			if (con == null)
			{return "Error while connecting to the database for updating."; }
			
			PreparedStatement preparedStmt = con.prepareStatement(sql);
			ResultSet resultSet =preparedStmt.executeQuery();
			
			
			while(resultSet.next()) // Until next row is present otherwise it return false
			{
				EmailDB = resultSet.getString("Email"); //fetch the values present in database
				passwordDB = resultSet.getString("Password");
 
				if(email.equals(EmailDB) && password.equals(passwordDB)) 
				{
					return "SUCCESS"; ////If the user entered values are already present in database, which means user has already registered so I will return SUCCESS message.
				}			
			}con.close();
		}
		catch(SQLException e)
		{
			e.printStackTrace();
		}
		finally {
			
		 } 
		return "Invalid user credentials"; // Just returning appropriate message otherwise
		}

	


}
