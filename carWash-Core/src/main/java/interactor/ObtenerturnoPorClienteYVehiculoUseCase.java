package interactor;

import modelo.Cliente;
import modelo.Turno;
import modelo.Vehiculo;
import repositorio.IObtenerTurnoPorClienteYVehiculoRepo;

import java.util.List;

public class ObtenerturnoPorClienteYVehiculoUseCase {

    private IObtenerTurnoPorClienteYVehiculoRepo obtenerTurnoPorClienteYVehiculoRepo;

    public ObtenerturnoPorClienteYVehiculoUseCase(IObtenerTurnoPorClienteYVehiculoRepo obtenerTurnoPorClienteYVehiculoRepo) {
        this.obtenerTurnoPorClienteYVehiculoRepo=obtenerTurnoPorClienteYVehiculoRepo;
    }

    public List<Turno> obtenerturnoPorClienteYVehiculo(Cliente cliente, Vehiculo vehiculo) {
        return (List<Turno>) obtenerTurnoPorClienteYVehiculoRepo.obtenerTurnoPorClienteyVehiculo(cliente,vehiculo);
    }
}
