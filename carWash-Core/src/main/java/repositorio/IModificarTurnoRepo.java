package repositorio;

import modelo.Turno;
import modelo.Vehiculo;

import java.time.LocalDate;

public interface IModificarTurnoRepo {
    Vehiculo findMatricula(String nrp374);
    Turno findBFecha(LocalDate fecha);
    boolean modificarTurno(Turno turnoDatosNuevo);
   // Turno optenerId();
}
