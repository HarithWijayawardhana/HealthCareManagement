package s1142_5.appointment.controllers;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import s1142_5.appointment.db.MySqlDBConf;
import s1142_5.appointment.model.Apointment;

@Path("addAppointment")
@Consumes(MediaType.APPLICATION_JSON)
public class AddAppointment {
	
	@POST
	public Response addPointment(Apointment app) 
	{
		
		MySqlDBConf.makeJDBCConnection();
		MySqlDBConf.addApoitment(app);
		
		return Response.status(201).entity("Added Successfully").build();
		
	}
	

}
