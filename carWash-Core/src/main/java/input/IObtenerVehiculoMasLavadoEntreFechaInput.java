package input;

import modelo.Vehiculo;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;

public interface IObtenerVehiculoMasLavadoEntreFechaInput {
    Vehiculo obtenerVehiculoMasLavadoEntreFecha(LocalDate fechaInicio, LocalDate fechaFin);
}
