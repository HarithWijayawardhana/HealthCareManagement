package s1142_5.appointment.controllers;

import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

import s1142_5.appointment.db.MySqlDBConf;
import s1142_5.appointment.model.Apointment;

@Path("getAppointments")
public class getAppointments {

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<Apointment> getAppointments(@QueryParam("timeSlotID") int timeSlotID)
	{
		MySqlDBConf.makeJDBCConnection();
		return MySqlDBConf.getAppointments(timeSlotID);
	}
	
}
