package route;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
 
@Path("/hello")
public class MyRestWebService  {
	
	
	@GET
	@Path("/getData")
	@Consumes(MediaType.APPLICATION_JSON)
	public Response crunchifyREST(String incomingData) {
		System.out.println(incomingData);
		System.out.println("Get request");
		// return HTTP response 200 in case of success
		return Response.status(200).entity(incomingData).build();
	}
	
	@GET
	@Path("/getMessage")
	@Produces(MediaType.APPLICATION_JSON)
	public Response verifyRESTService(String lol) {
		GetMessageFromUser temp = new GetMessageFromUser();
		temp.callGcm();
		System.out.println("Good");
		return Response.status(200).entity("good Games").build();
	}
}
