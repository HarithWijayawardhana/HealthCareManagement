package s1142_5.appointment.controllers;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import s1142_5.appointment.db.MySqlDBConf;
import s1142_5.appointment.model.TimeSlot;



@Path("registerTimeSlot")
public class regitserTimeSlot {
	
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	//@Produces(MediaType.APPLICATION_JSON)
	public Response RegisterTimeSlot(TimeSlot ts) 
	{
		TimeSlot timeSlot = ts;
		System.out.println(ts.getPatientLinit());
		
		MySqlDBConf.makeJDBCConnection();
		MySqlDBConf.registerTimeSlot(timeSlot);
		
		return Response.status(201).entity("Registered Successfully").build();
	}

}
