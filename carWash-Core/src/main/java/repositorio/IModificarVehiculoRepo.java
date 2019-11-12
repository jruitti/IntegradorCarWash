package repositorio;

import modelo.Vehiculo;

public interface IModificarVehiculoRepo {
    Vehiculo findByMatricula(String ixi056);

    boolean modificarVehiculo(Vehiculo vehiculoNuevo);
}
