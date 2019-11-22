package repositorio;

import modelo.Turno;
import modelo.Vehiculo;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;

public interface IModificarTurnoRepo {

    Turno findByVehiculoAndFecha(Vehiculo vehiculo, LocalDate fecha);
    boolean modificarTurno(Turno turnoDatosNuevo);

}
