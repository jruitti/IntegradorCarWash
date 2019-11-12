package repositorio;

import modelo.Vehiculo;

public interface IRepositorioCrearVehiculo {

    boolean guardar (Vehiculo vehiculoNuevo);
    Vehiculo findByMatricula(String matricula);
}
