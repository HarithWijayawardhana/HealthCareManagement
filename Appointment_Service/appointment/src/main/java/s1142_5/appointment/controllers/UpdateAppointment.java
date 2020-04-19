package s1142_5.appointment.controllers;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Response;

import s1142_5.appointment.db.MySqlDBConf;

@Path("updateAppointment")
public class UpdateAppointment {
	
	@GET
	public Response updateAppointment(
			@QueryParam("oldTimeSlot") int oldTimeSlot,
			@QueryParam("oldNumber") int oldNumber,
			@QueryParam("newTimeSlot") int newTimeSlot,
			@QueryParam("newNumber") int newNumber
			) 
	{
		
		MySqlDBConf.makeJDBCConnection();
		MySqlDBConf.updateAppointment(oldTimeSlot, oldNumber, newTimeSlot, newNumber);
		
		return Response.status(201).entity("Registered Successfully").build();
		
	}
	
	

}
