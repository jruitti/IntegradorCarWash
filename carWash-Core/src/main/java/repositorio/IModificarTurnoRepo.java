package repositorio;

import modelo.Turno;
import modelo.Vehiculo;

import java.time.LocalDate;

public interface IModificarTurnoRepo {

    Turno findByVehiculoAndFecha(String matricula, LocalDate fecha);
    boolean modificarTurno(Turno turnoDatosNuevo);

}
