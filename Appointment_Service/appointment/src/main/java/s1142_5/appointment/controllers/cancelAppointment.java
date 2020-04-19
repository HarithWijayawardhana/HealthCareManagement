package s1142_5.appointment.controllers;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Response;

import s1142_5.appointment.db.MySqlDBConf;

@Path("cancelAppointment")
public class cancelAppointment {

	@GET
	public Response cancelAppointments(@QueryParam("timeSlot") int timeSlot, @QueryParam("number") int number) {

		MySqlDBConf.makeJDBCConnection();
		MySqlDBConf.deleteAppointment(timeSlot, number);

		return Response.status(201).entity("Registered Successfully").build();
	}

}
