package repositorio;
import modelo.Turno;
import modelo.Vehiculo;

import java.time.LocalDate;

public interface IRepositorioCrearTurno {
    boolean guardar(Turno turnoNuevo);
    Turno findByVehiculoAndFecha(Vehiculo elVehiculo, LocalDate fecha);
}
