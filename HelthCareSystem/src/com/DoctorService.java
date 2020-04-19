package com;
import model.Doctor;

//For REST Service
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;

//For JSON
import com.google.gson.*;
//For XML
import org.jsoup.*;
import org.jsoup.parser.*;
import org.jsoup.nodes.Document;

@Path("/Doctors")

public class DoctorService {
	

	Doctor doctorObj = new Doctor();
	@GET
	@Path("/")
	@Produces({MediaType.TEXT_HTML,MediaType.APPLICATION_JSON,MediaType.APPLICATION_XML})
	public String readDoctors()
	{
		return doctorObj.readDoctors();
	}
	
	@GET
	@Path("DocLogin")
	@Produces({MediaType.TEXT_HTML,MediaType.APPLICATION_JSON,MediaType.APPLICATION_XML})
	public String doctorLogin()
	{
		return doctorObj.doctorLogin(null);
	}
	
	@POST
	@Path("/")
	@Consumes(MediaType.APPLICATION_FORM_URLENCODED)
	@Produces(MediaType.TEXT_PLAIN)
	public String insertDoctor
	(
		@FormParam("FirstName") String FirstName,
		@FormParam("LastName") String LastName,
		@FormParam("Specialization") String Specialization,
		@FormParam("Gender") String Gender,
		@FormParam("Email") String Email,
		@FormParam("ContactNo") String ContactNo,
		@FormParam("StandardFees") String StandardFees,
		@FormParam("Password") String Password)
	{
		String output = doctorObj.insertDoctor(FirstName, LastName, Specialization, Gender,Email,ContactNo,StandardFees,Password);
		return output;
	}
	
	@PUT
	@Path("/")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.TEXT_PLAIN)
	public String updateDoctor(String docData)
	{
	//Convert the input string to a JSON object
	JsonObject docObject = new JsonParser().parse(docData).getAsJsonObject();
	//Read the values from the JSON object
	String docId = docObject.get("docId").getAsString();
	String FirstName = docObject.get("FirstName").getAsString();
	String LastName = docObject.get("LastName").getAsString();
	String Specialization = docObject.get("Specialization").getAsString();
	String Gender = docObject.get("Gender").getAsString();
	String Email = docObject.get("Email").getAsString();
	String ContactNo = docObject.get("ContactNo").getAsString();
	String StandardFees = docObject.get("StandardFees").getAsString();
	String Password = docObject.get("Password").getAsString();
	String output = doctorObj.updateDoctor(docId, FirstName, LastName, Specialization, Gender,Email,ContactNo,StandardFees,Password);
	return output;
	}
	
	@DELETE
	@Path("/")
	@Consumes(MediaType.APPLICATION_XML)
	@Produces(MediaType.TEXT_PLAIN)
	public String deleteDoctor(String docData)
	{
	//Convert the input string to an XML document
	Document doc = Jsoup.parse(docData, "", Parser.xmlParser());
	//Read the value from the element <docId>
	String docId = doc.select("docId").text();
	String output = doctorObj.deleteDoctor(docId);
	return output;
	}
	
}
