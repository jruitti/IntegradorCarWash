package input;

import excepciones.TurnoIncompletoException;
import modelo.Cliente;
import modelo.Turno;
import modelo.Vehiculo;

import java.util.List;

public interface IObtenerTurnoPorClienteYVehiculoInput {
    List<Turno> obtenerturnoPorClienteYVehiculo(Cliente cliente, Vehiculo vehiculo);
}
