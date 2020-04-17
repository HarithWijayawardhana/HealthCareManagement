package com;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.parser.Parser;

import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import model.patient;

@Path("/patient")
public class PatientRegsiterService {

	patient patientObj = new patient();

	@GET
	@Path("/")
	@Produces(MediaType.TEXT_PLAIN)
	public String hello() {
		return patientObj.readPatient();
	}

	@POST
	@Path("/")
	@Consumes(MediaType.APPLICATION_FORM_URLENCODED)
	@Produces(MediaType.TEXT_PLAIN)
	public String insertPatient(@FormParam("userId") String userId, @FormParam("name") String name,
			@FormParam("password") String password,@FormParam("mobile") String mobile, @FormParam("email") String email,
			@FormParam("address") String address) {
		String output = patientObj.insertPatient(name, password, mobile, email, address);
		return output;
	}

	@PUT
	@Path("/")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.TEXT_PLAIN)
	public String updatePatient(String patientData) {
		// Convert the input string to a JSON object
		JsonObject patientObject = new JsonParser().parse(patientData).getAsJsonObject();
		// Read the values from the JSON object
		String userId = patientObject.get("userId").getAsString();
		String name = patientObject.get("userName").getAsString();
		String password = patientObject.get("password").getAsString();
		String mobile = patientObject.get("mobile").getAsString();
		String email = patientObject.get("email").getAsString();
		String address = patientObject.get("address").getAsString();
		String output = patientObj.updatePatient(userId,name,password,mobile, email, address);
		return output;
	}
	
	@DELETE
	@Path("/")
	@Consumes(MediaType.APPLICATION_XML)
	@Produces(MediaType.TEXT_PLAIN)
	public String deletePatient(String patientData)
	{
	//Convert the input string to an XML document
	 Document doc = Jsoup.parse(patientData, "", Parser.xmlParser());

	//Read the value from the element <itemID>
	 String userId = doc.select("userId").text();
	 String output = patientObj.deletePatient(userId);
	return output;
	}
	

	
	
	
	

}