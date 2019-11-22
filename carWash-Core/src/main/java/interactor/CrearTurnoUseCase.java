package interactor;

import excepciones.TurnoExisteException;
import input.ICrearTurnoImput;
import modelo.Turno;
import repositorio.IRepositorioCrearTurno;
import repositorio.IRepositorioCrearVehiculo;

public class CrearTurnoUseCase implements ICrearTurnoImput {
    private IRepositorioCrearTurno crearTurnoGateway;

    public CrearTurnoUseCase(IRepositorioCrearTurno crearTurnoGateway) {
        this.crearTurnoGateway=crearTurnoGateway;
    }

    public boolean crearTurno(Turno turnoNuevo) throws TurnoExisteException {
        if(this.crearTurnoGateway.findByVehiculoAndFecha(turnoNuevo.getVehiculo().getMatricula(), turnoNuevo.getFecha()) == null) {
            return this.crearTurnoGateway.guardar(turnoNuevo);
        }else throw new TurnoExisteException("Turno no disponible");
    }
}
