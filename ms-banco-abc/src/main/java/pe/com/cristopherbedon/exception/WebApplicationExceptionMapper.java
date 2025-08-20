package pe.com.cristopherbedon.exception;

import jakarta.ws.rs.WebApplicationException;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import jakarta.ws.rs.ext.ExceptionMapper;
import jakarta.ws.rs.ext.Provider;

import java.util.Map;

@Provider
public class WebApplicationExceptionMapper implements ExceptionMapper<WebApplicationException> {
    @Override
    public Response toResponse(WebApplicationException ex) {
        String message = ex.getMessage();
        return Response.status(ex.getResponse().getStatus())
                .entity(Map.of("error", message))
                .type(MediaType.APPLICATION_JSON)
                .build();
    }
}
