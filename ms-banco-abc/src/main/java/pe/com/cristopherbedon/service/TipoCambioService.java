package pe.com.cristopherbedon.service;

import com.fasterxml.jackson.databind.JsonNode;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import jakarta.ws.rs.WebApplicationException;
import jakarta.ws.rs.core.Response;
import org.eclipse.microprofile.rest.client.inject.RestClient;
import pe.com.cristopherbedon.client.EApiClient;
import pe.com.cristopherbedon.entity.TipoCambio;
import pe.com.cristopherbedon.repository.TipoCambioRepository;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

@ApplicationScoped
public class TipoCambioService {

    private static final int DAILY_LIMIT = 10;

    @Inject
    @RestClient
    EApiClient eApiClient;

    @Inject
    TipoCambioRepository repository;

    public long usageFor(String dni, LocalDate date) {
        return repository.countByDniAndDate(dni, date);
    }

    @Transactional
    public Map<String, Object> getTodayRateAndRegister(String dni) {
        LocalDate today = LocalDate.now();
        long used = usageFor(dni, today);
        if (used >= DAILY_LIMIT) {
            throw new WebApplicationException("El usuario " + dni + " ha llegado al máximo de consultas diarias.",
                    Response.Status.TOO_MANY_REQUESTS);
        }

        JsonNode external = eApiClient.getToday();

        TipoCambio q = new TipoCambio();
        q.dni = dni;
        q.queryDate = today;
        q.queriedAt = LocalDateTime.now();
        repository.persist(q);

        Map<String, Object> payload = new HashMap<>();
        payload.put("dni", dni);
        payload.put("date", today.toString());
        payload.put("usageToday", used + 1);
        payload.put("limit", DAILY_LIMIT);
        payload.put("rate", external);
        return payload;
    }

}
