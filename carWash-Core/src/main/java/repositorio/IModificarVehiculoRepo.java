package repositorio;

import modelo.Vehiculo;

public interface IModificarVehiculoRepo {

    boolean modificarVehiculo(Vehiculo vehiculoDatosNuevo);

    Vehiculo findByMatricula(String matricula);
}
