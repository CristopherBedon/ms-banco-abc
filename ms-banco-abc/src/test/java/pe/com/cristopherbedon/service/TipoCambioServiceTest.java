// src/test/java/pe/com/cristopherbedon/service/TipoCambioServiceTest.java
package pe.com.cristopherbedon.service;

//import com.fasterxml.jackson.databind.JsonNode;
//import io.quarkus.test.junit.QuarkusTest;
//import io.quarkus.test.junit.mockito.InjectMock;
//import jakarta.inject.Inject;
//import jakarta.ws.rs.WebApplicationException;
//import org.junit.jupiter.api.Test;
//import pe.com.cristopherbedon.client.EApiClient;
//import pe.com.cristopherbedon.entity.TipoCambio;
//import pe.com.cristopherbedon.repository.TipoCambioRepository;
//
//import java.time.LocalDate;
//import java.util.Map;
//
//import static org.junit.jupiter.api.Assertions.*;
//import static org.mockito.ArgumentMatchers.*;
//import static org.mockito.Mockito.*;

//@QuarkusTest
class TipoCambioServiceTest {

//    @Inject
//    TipoCambioService service;
//
//    @InjectMock
//    EApiClient eApiClient;
//
//    @InjectMock
//    TipoCambioRepository repository;
//
//    @Test
//    void testLimiteDiarioExcedido() {
//        String dni = "12345678";
//        LocalDate today = LocalDate.now();
//        when(repository.countByDniAndDate(eq(dni), eq(today))).thenReturn(10L);
//
//        WebApplicationException ex = assertThrows(WebApplicationException.class, () -> {
//            service.getTodayRateAndRegister(dni);
//        });
//
//        assertEquals(429, ex.getResponse().getStatus());
//        assertTrue(ex.getMessage().contains(dni));
//    }
//
//    @Test
//    void testRegistroExitoso() {
//        String dni = "87654321";
//        LocalDate today = LocalDate.now();
//        when(repository.countByDniAndDate(eq(dni), eq(today))).thenReturn(2L);
//
//        JsonNode mockNode = mock(JsonNode.class);
//        when(eApiClient.getToday()).thenReturn(mockNode);
//
//        Map<String, Object> result = service.getTodayRateAndRegister(dni);
//
//        assertEquals(dni, result.get("dni"));
//        assertEquals(today.toString(), result.get("date"));
//        assertEquals(3L, result.get("usageToday"));
//        assertEquals(10, result.get("limit"));
//        assertEquals(mockNode, result.get("rate"));
//        verify(repository).persist(any(TipoCambio.class));
//    }
}