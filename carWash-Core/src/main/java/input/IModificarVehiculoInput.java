package input;

import excepciones.VehiculoExisteException;
import modelo.Vehiculo;

public interface IModificarVehiculoInput {

    boolean modificarVehiculo(Vehiculo elVehiculo) throws VehiculoExisteException;
}
