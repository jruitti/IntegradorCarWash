package interactor;

import excepciones.TurnoExisteException;
import modelo.Turno;
import modelo.Vehiculo;
import repositorio.ICrearTurnoRepo;
import repositorio.IRepositorioCrearVehiculo;

public class CrearTurnoUseCase {
    private ICrearTurnoRepo crearTurnoRepo;
    private IRepositorioCrearVehiculo repositorioCrearVehiculo;

    public CrearTurnoUseCase(ICrearTurnoRepo crearTurnoRepo,IRepositorioCrearVehiculo repositorioCrearVehiculo) {
        this.crearTurnoRepo=crearTurnoRepo;
        this.repositorioCrearVehiculo=repositorioCrearVehiculo;

    }



    public boolean crearTurno(Turno turnoNuevo) throws TurnoExisteException {
        if((repositorioCrearVehiculo.findByMatricula(turnoNuevo.getVehiculo().getMatricula())==null)||(crearTurnoRepo.findBFecha(turnoNuevo.getFecha())==null)) {
            return this.crearTurnoRepo.guardar(turnoNuevo);
        }else  throw new TurnoExisteException("El turno no disponible");
    }
}
