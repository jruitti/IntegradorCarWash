package interactor;

import excepciones.TurnoExisteException;
import modelo.Turno;
import repositorio.IRepositorioCrearTurno;

public class CrearTurnoUseCase {
<<<<<<< HEAD
    private IRepositorioCrearTurno crearTurnoGateway;
=======
    private ICrearTurnoRepo crearTurnoRepo;
    private IRepositorioCrearVehiculo repositorioCrearVehiculo;

    public CrearTurnoUseCase(ICrearTurnoRepo crearTurnoRepo,IRepositorioCrearVehiculo repositorioCrearVehiculo) {
        this.crearTurnoRepo=crearTurnoRepo;
        this.repositorioCrearVehiculo=repositorioCrearVehiculo;
>>>>>>> master

    public CrearTurnoUseCase(IRepositorioCrearTurno crearTurnoGateway) {
        this.crearTurnoGateway= crearTurnoGateway;
    }

    public boolean crearTurno(Turno turnoNuevo) throws TurnoExisteException {
<<<<<<< HEAD
        if(this.crearTurnoGateway.findByVehiculoYFecha(turnoNuevo.getVehiculo().getMatricula(), turnoNuevo.getFecha()) == null) {
            return this.crearTurnoGateway.guardar(turnoNuevo);
        }else throw new TurnoExisteException("Turno no disponible");
=======
        if((repositorioCrearVehiculo.findByMatricula(turnoNuevo.getVehiculo().getMatricula())==null)||(crearTurnoRepo.findBFecha(turnoNuevo.getFecha())==null)) {
            return this.crearTurnoRepo.guardar(turnoNuevo);
        }else  throw new TurnoExisteException("El turno no disponible");
>>>>>>> master
    }
}
