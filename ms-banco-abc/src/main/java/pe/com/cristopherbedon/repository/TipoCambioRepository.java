package pe.com.cristopherbedon.repository;

import io.quarkus.hibernate.orm.panache.PanacheRepository;
import jakarta.enterprise.context.ApplicationScoped;
import pe.com.cristopherbedon.entity.TipoCambio;

import java.time.LocalDate;

@ApplicationScoped
public class TipoCambioRepository implements PanacheRepository<TipoCambio> {

    public long countByDniAndDate(String dni, LocalDate date) {
        return count("dni = ?1 and queryDate = ?2", dni, date);
    }

}
