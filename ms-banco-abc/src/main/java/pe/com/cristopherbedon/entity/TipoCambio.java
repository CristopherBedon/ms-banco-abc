package pe.com.cristopherbedon.entity;

import io.quarkus.hibernate.orm.panache.PanacheEntity;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@Table(name = "tipoCambioDolares")
public class TipoCambio extends PanacheEntity {

    public Long id;
    public String dni;
    public LocalDate queryDate;
    public LocalDateTime queriedAt;
}
