package pe.com.cristopherbedon.controller;

import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import pe.com.cristopherbedon.service.TipoCambioService;

import java.time.LocalDate;
import java.util.Map;

@Path("/v1/tipo-cambio")
@Produces(MediaType.APPLICATION_JSON)
public class TipoCambioController {

    @Inject
    TipoCambioService service;

    @GET
    public Response getToday(@QueryParam("dni") String dni) {
        if (dni == null || dni.isBlank()) {
            throw new BadRequestException("El parámetro 'dni' es obligatorio");
        }
        Map<String, Object> result = service.getTodayRateAndRegister(dni.trim());
        return Response.ok(result).build();
    }

    @GET
    @Path("/usage/{dni}")
    public Response getUsage(@PathParam("dni") String dni, @QueryParam("date") String dateStr) {
        LocalDate date = (dateStr == null || dateStr.isBlank()) ? LocalDate.now() : LocalDate.parse(dateStr);
        long usage = service.usageFor(dni, date);
        return Response.ok(Map.of(
                "dni", dni,
                "date", date.toString(),
                "usage", usage
        )).build();
    }
}
