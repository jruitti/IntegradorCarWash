package input;

import excepciones.VehiculoExisteException;
import modelo.Vehiculo;

public interface ICrearVehiculoInput {
    public boolean crearVehiculo(Vehiculo vehiculoCrear) throws VehiculoExisteException;
}
