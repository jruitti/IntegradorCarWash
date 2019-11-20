package input;

import modelo.Vehiculo;

import java.time.LocalDate;

public interface IObtenerVehiculoMasLavadoEntreFechaInput {
    Vehiculo obtenerVehiculoMasLavadoEntreFecha(LocalDate fechaInicio, LocalDate fechaFin);
}
