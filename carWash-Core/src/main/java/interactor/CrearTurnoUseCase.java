package interactor;

import excepciones.TurnoExisteException;
import modelo.Turno;
import repositorio.IRepositorioCrearTurno;
import repositorio.IRepositorioCrearVehiculo;

public class CrearTurnoUseCase {
    private IRepositorioCrearTurno crearTurnoGateway;
    private IRepositorioCrearVehiculo repositorioCrearVehiculo;

    public CrearTurnoUseCase(IRepositorioCrearTurno crearTurnoGateway,IRepositorioCrearVehiculo repositorioCrearVehiculo) {
        this.crearTurnoGateway=crearTurnoGateway;
        this.repositorioCrearVehiculo=repositorioCrearVehiculo;


    }

    public boolean crearTurno(Turno turnoNuevo) throws TurnoExisteException {
        if(this.crearTurnoGateway.findByVehiculoAndFecha(turnoNuevo.getVehiculo().getMatricula(), turnoNuevo.getFecha()) == null) {
            return this.crearTurnoGateway.guardar(turnoNuevo);
        }else throw new TurnoExisteException("Turno no disponible");
    }
}
