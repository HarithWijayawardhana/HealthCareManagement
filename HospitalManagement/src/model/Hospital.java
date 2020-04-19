package model;

import java.sql.*;

public class Hospital {

	// Connect to DB
	private Connection connect() {

		Connection con = null;

		try {
			Class.forName("com.mysql.jdbc.Driver");

			con = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/healthcare", "root", "");

		} catch (Exception e) {
			e.printStackTrace();
		}

		return con;

	}

	// Insert
	public String insertHospital(String name, String password, String address, String mobile, String email,
			String webAddress) {

		String output = "";

		try {

			Connection con = connect();

			if (con == null) {
				return "Error while connecting to the database for inserting.";
			}

			// Create a prepared statement
			String query = " insert into hospital_t('hosID','hosName','password','address','mobile','email','webAddress')"
					+ " values (?, ?, ?, ?, ?, ?, ?)";

			PreparedStatement preparedStmt = con.prepareStatement(query);

			// binding values
			preparedStmt.setInt(1, 0);
			preparedStmt.setString(2, name);
			preparedStmt.setString(3, password);
			preparedStmt.setString(4, address);
			preparedStmt.setString(5, mobile);
			preparedStmt.setString(6, email);
			preparedStmt.setString(7, webAddress);

			// execute the statement
			preparedStmt.execute();
			con.close();
			output = "Inserted successfully";

		} catch (Exception e) {

			output = "Error while inserting the hospital.";
			System.err.println(e.getMessage());

		}

		return output;

	}

	// Read
	public String readHospital() {

		String output = "";

		try {

			Connection con = connect();

			if (con == null) {
				return "Error while connecting to the database for reading.";
			}

			// Prepare the html table to be displayed
			output = "<table border=\"1\"><tr>" + "<th>hospitalName</th>" + "<th>password</th>" + "<th>address</th>"
					+ "<th>mobile</th>" + "<th>email</th>" + "<th>webAddress</th>"
					+ "<th>Update</th><th>Remove</th></tr>";

			String query = "select * from hospital_t";

			Statement stmt = con.createStatement();

			ResultSet rs = stmt.executeQuery(query);

			// iterate through the rows in the result set
			while (rs.next()) {

				String hosID = Integer.toString(rs.getInt("hosID"));
				String hosName = rs.getString("hosName");
				String password = rs.getString("password");
				String address = rs.getString("address");
				String mobile = rs.getString("mobile");
				String email = rs.getString("email");
				String webAddress = rs.getString("webAddress");

				// Add into the html table
				output += "<tr><td>" + hosName + "</td>";
				output += "<td>" + password + "</td>";
				output += "<td>" + address + "</td>";
				output += "<td>" + mobile + "</td>";
				output += "<td>" + email + "</td>";
				output += "<td>" + webAddress + "</td>";

				// buttons
				output += "<td><input name=\"btnUpdate\" type=\"button\"value=\"Update\" class=\"btn btn-secondary\"></td>"
						+ "<td><form method=\"post\" action=\"hospitals.jsp\">"
						+ "<input name=\"btnRemove\" type=\"submit\" value=\"Remove\"class=\"btn btn-danger\">"
						+ "<input name=\"hosID\" type=\"hidden\" value=\"" + hosID + "\">" + "</form></td></tr>";
			}

			con.close();
			// Complete the html table
			output += "</table>";

		} catch (Exception e) {

			output = "Error while reading the hospitals.";
			System.err.println(e.getMessage());

		}

		return output;

	}

	// Update
	public String updateHospital(String id, String name, String password, String address, String mobile, String email,
			String webAddress) {

		String output = "";

		try {

			Connection con = connect();

			if (con == null) {
				return "Error while connecting to the database for updating.";
			}

			// create a prepared statement
			String query = "UPDATE hospital_t SET hosName=?,password=?,address=?,mobile=?,email=?,webAddress=? WHERE hosID=?";

			PreparedStatement preparedStmt = con.prepareStatement(query);

			// binding values
			preparedStmt.setString(1, name);
			preparedStmt.setString(2, password);
			preparedStmt.setString(3, address);
			preparedStmt.setString(4, mobile);
			preparedStmt.setString(5, email);
			preparedStmt.setString(6, webAddress);
			preparedStmt.setInt(7, Integer.parseInt(id));

			// execute the statement
			preparedStmt.execute();
			con.close();

			output = "Updated successfully";

		} catch (Exception e) {

			output = "Error while updating the hospital.";
			System.err.println(e.getMessage());

		}

		return output;

	}

	// Delete
	public String deleteHospital(String hosID) {

		String output = "";

		try {

			Connection con = connect();

			if (con == null) {
				return "Error while connecting to the database for deleting.";
			}

			// create a prepared statement
			String query = "delete from hospital_t where hosID=?";

			PreparedStatement preparedStmt = con.prepareStatement(query);

			// binding values
			preparedStmt.setInt(1, Integer.parseInt(hosID));

			// execute the statement
			preparedStmt.execute();
			con.close();

			output = "Deleted successfully";

		} catch (Exception e) {

			output = "Error while deleting the hospital.";
			System.err.println(e.getMessage());

		}

		return output;

	}
}