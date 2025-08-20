package pe.com.cristopherbedon.client;

import com.fasterxml.jackson.databind.JsonNode;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import org.eclipse.microprofile.rest.client.inject.RegisterRestClient;

@Path("/tipo-cambio")
@RegisterRestClient(configKey = "eapi")
public interface EApiClient {

    @GET
    @Path("/today.json")
    @Produces(MediaType.APPLICATION_JSON)
    JsonNode getToday();
}
