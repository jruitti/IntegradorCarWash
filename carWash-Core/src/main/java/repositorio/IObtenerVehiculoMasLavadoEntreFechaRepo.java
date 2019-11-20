package repositorio;

import modelo.Vehiculo;

import java.time.LocalDate;


public interface IObtenerVehiculoMasLavadoEntreFechaRepo {
    Vehiculo  obtenerVehiculoMasLavadoEntreFecha(LocalDate fechaInicio, LocalDate fechaFin);
}
