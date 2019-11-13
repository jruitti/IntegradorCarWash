package interactor;

import excepciones.TurnoExisteException;
import modelo.Turno;
import repositorio.IRepositorioCrearTurno;

public class CrearTurnoUseCase {
    private IRepositorioCrearTurno crearTurnoGateway;

    public CrearTurnoUseCase(IRepositorioCrearTurno crearTurnoGateway) {
        this.crearTurnoGateway= crearTurnoGateway;
    }

    public boolean crearTurno(Turno turnoNuevo) throws TurnoExisteException {
        if(this.crearTurnoGateway.findByVehiculoYFecha(turnoNuevo.getVehiculo().getMatricula(), turnoNuevo.getFecha()) == null) {
            return this.crearTurnoGateway.guardar(turnoNuevo);
        }else throw new TurnoExisteException("Turno no disponible");
    }
}
