package interactor;

import modelo.Cliente;
import modelo.Turno;
import repositorio.IBuscarClientePorNombreRepo;
import repositorio.IObtenerTurnoPorClienteYVehiculoRepo;

import java.util.List;

public class ObtenerTurnoPorNombreYVehiculoUseCase {
    private IObtenerTurnoPorClienteYVehiculoRepo obtenerTurnoPorClienteYVehiculoRepo;
    private IBuscarClientePorNombreRepo buscarClientePorNombreRepo;

    public ObtenerTurnoPorNombreYVehiculoUseCase(IObtenerTurnoPorClienteYVehiculoRepo obtenerTurnoPorClienteYVehiculoRepo) {
        this.obtenerTurnoPorClienteYVehiculoRepo=obtenerTurnoPorClienteYVehiculoRepo;
      //  this.buscarClientePorNombreRepo=buscarClientePorNombreRepo;
    }

    public List<Cliente> obtenerTurnoPorCliente(String nombre) {
        return (List<Cliente>) obtenerTurnoPorClienteYVehiculoRepo.obtenerTurnosPorCLiente(nombre);

    }

    public List<Turno> obtenerTurnoPorVehiculo(String matricula) {
        return (List<Turno>) obtenerTurnoPorClienteYVehiculoRepo.obtenerTurnosPorVehiculo(matricula);
    }
}
