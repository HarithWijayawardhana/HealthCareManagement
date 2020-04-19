package s1142_5.appointment;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import s1142_5.appointment.db.MySqlDBConf;



@Path("hello")
public class HelloResource {
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public HelloModel getGreeting() 
	{
		//MySqlDBConf dbConf = new MySqlDBConf();
		MySqlDBConf.makeJDBCConnection();
		
		System.out.println("get Greeting");
		return new HelloModel("Good Morning", "Aqeel");
	}
	

}
