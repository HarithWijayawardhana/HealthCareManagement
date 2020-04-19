package com;

import javax.ws.rs.Consumes;
import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.DELETE;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.parser.Parser;

import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import model.Hospital;

@Path("/Hospitals")
public class HospitalService {

	Hospital hospitalObj = new Hospital();

	// Read Hospitals
	@GET
	@Path("/")
	@Produces(MediaType.TEXT_HTML)
	public String readHospital() {

		return hospitalObj.readHospital();

	}

	// Insert Hospitals
	@POST
	@Path("/")
	@Consumes(MediaType.APPLICATION_FORM_URLENCODED)
	@Produces(MediaType.TEXT_PLAIN)
	public String insertHospital(@FormParam("hosName") String hosName, @FormParam("password") String password,
			@FormParam("address") String address, @FormParam("mobile") String mobile, @FormParam("email") String email,
			@FormParam("webAddress") String webAddress) {

		String output = hospitalObj.insertHospital(hosName, password, address, mobile, email, webAddress);

		return output;

	}

	// Update Hospitals
	@PUT
	@Path("/")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.TEXT_PLAIN)
	public String updateHospital(String hospitalData) {

		// Convert the input string to a JSON object
		JsonObject hospitalJsonObject = new JsonParser().parse(hospitalData).getAsJsonObject();

		// Read the values from the JSON object
		String hosID = hospitalJsonObject.get("hosID").getAsString();
		String hosName = hospitalJsonObject.get("hosName").getAsString();
		String password = hospitalJsonObject.get("password").getAsString();
		String address = hospitalJsonObject.get("address").getAsString();
		String mobile = hospitalJsonObject.get("mobile").getAsString();
		String email = hospitalJsonObject.get("email").getAsString();
		String webAddress = hospitalJsonObject.get("webAddress").getAsString();

		String output = hospitalObj.updateHospital(hosID, hosName, password, address, mobile, email, webAddress);

		return output;

	}

	// Delete Hospitals
	@DELETE
	@Path("/")
	@Consumes(MediaType.APPLICATION_XML)
	@Produces(MediaType.TEXT_PLAIN)
	public String deleteHospital(String hospitalData) {

		// Convert the input string to an XML document
		Document doc = Jsoup.parse(hospitalData, "", Parser.xmlParser());

		// Read the value from the element <hosID>
		String hosID = doc.select("hosID").text();

		String output = hospitalObj.deleteHospital(hosID);

		return output;

	}
}
