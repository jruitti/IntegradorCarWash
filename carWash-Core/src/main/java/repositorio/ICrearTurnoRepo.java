package repositorio;

import modelo.Turno;
import modelo.Vehiculo;

import java.time.LocalDate;

public interface ICrearTurnoRepo {
    boolean guardar(Turno turnoNuevo);

    Turno findBFecha(LocalDate fecha);

}
