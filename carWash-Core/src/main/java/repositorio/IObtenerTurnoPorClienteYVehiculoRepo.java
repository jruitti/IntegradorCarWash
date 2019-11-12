package repositorio;

import modelo.Cliente;
import modelo.Turno;
import modelo.Vehiculo;

import java.util.Collection;

public interface IObtenerTurnoPorClienteYVehiculoRepo {
    Collection<Cliente> obtenerTurnosPorCLiente(String nombre);

    Collection<Turno> obtenerTurnosPorVehiculo(String matricula);
}
