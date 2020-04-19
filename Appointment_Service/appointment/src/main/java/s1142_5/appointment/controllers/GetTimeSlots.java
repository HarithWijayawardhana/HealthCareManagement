package s1142_5.appointment.controllers;

import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

import s1142_5.appointment.db.MySqlDBConf;
import s1142_5.appointment.model.TimeSlot;

@Path("getTimeSlot")
@Produces(MediaType.APPLICATION_JSON)
public class GetTimeSlots {

	@GET
	public List<TimeSlot> getTimeSlots( @QueryParam("docID") int docID)
	{
		List<TimeSlot> list = new ArrayList<TimeSlot>();
		
		list.add(new TimeSlot(12,"2:33","4:33",12,14,"20/2/2020"));
		list.add(new TimeSlot(13,"2:33","4:33",12,14,"20/2/2020"));
		
		MySqlDBConf.makeJDBCConnection();
		list = MySqlDBConf.getTimeSlots(docID);
		
		return list;
		
	}
	
	
}
