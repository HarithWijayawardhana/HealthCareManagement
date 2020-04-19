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
import org.jsoup.parser.Parser;

import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import model.Payment;


@Path("/Payment")

public class PaymentService {
	
	Payment paymentObj = new Payment();

	@GET
	@Path("/")
	@Produces(MediaType.TEXT_HTML)
	public String readDoctor() {
		return paymentObj.readPayment();
	}

	@POST
	@Path("/")
	@Consumes(MediaType.APPLICATION_FORM_URLENCODED)
	@Produces(MediaType.TEXT_PLAIN)
	public String insertPayment(@FormParam("payDate") String payDate,
			@FormParam("payTime") String payTime, @FormParam("payMethod") String payMethod,
			@FormParam("payDuDate") String payDuDate) {
		String output = paymentObj.insertPayment( payDate, payTime, payMethod, payDuDate);
		return output;
	}

	@PUT
	@Path("/")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.TEXT_PLAIN)
	public String updatePayment(String paymentData) {
		// Convert the input string to a JSON object
		JsonObject payObj = new JsonParser().parse(paymentData).getAsJsonObject();
		// Read the values from the JSON object
		String payID = payObj.get("payID").getAsString();
		String payDate = payObj.get("payDate").getAsString();
		String payTime = payObj.get("payTime").getAsString();
		String payMethod = payObj.get("payMethod").getAsString();
		String payDuDate = payObj.get("payDuDate").getAsString();
		
		String output = paymentObj.updatePayment(payID, payDate, payTime, payMethod, payDuDate);
		return output;
	}


	
	
	@DELETE
	@Path("/")
	@Consumes(MediaType.APPLICATION_XML)
	@Produces(MediaType.TEXT_PLAIN)
	public String deletePayment(String payData)
	{
	//Convert the input string to an XML document
	org.jsoup.nodes.Document doc = Jsoup.parse(payData, "", Parser.xmlParser());
	//Read the value from the element <itemID>
	String payID = doc.select("docid").text();
		String output = paymentObj.deletePayment(payID); 
		return output;
	}

}
