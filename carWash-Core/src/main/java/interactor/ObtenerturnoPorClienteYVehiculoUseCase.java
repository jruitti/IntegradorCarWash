package interactor;

import modelo.Turno;
import repositorio.IObtenerTurnoPorClienteYVehiculoRepo;

import java.util.List;

public class ObtenerturnoPorClienteYVehiculoUseCase {

    private IObtenerTurnoPorClienteYVehiculoRepo obtenerTurnoPorClienteYVehiculoRepo;

    public ObtenerturnoPorClienteYVehiculoUseCase(IObtenerTurnoPorClienteYVehiculoRepo obtenerTurnoPorClienteYVehiculoRepo) {
        this.obtenerTurnoPorClienteYVehiculoRepo=obtenerTurnoPorClienteYVehiculoRepo;
    }

    public List<Turno> obtenerturnoPorClienteYVehiculo(String documento, String matricula) {
        return (List<Turno>) obtenerTurnoPorClienteYVehiculoRepo.obtenerTurnoPorClienteyVehiculo("32458305","IXI056");
    }
}
