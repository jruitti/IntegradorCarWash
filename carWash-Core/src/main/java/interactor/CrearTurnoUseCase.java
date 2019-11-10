package interactor;

import excepciones.TurnoExisteException;
import modelo.Turno;
import modelo.Vehiculo;
import repositorio.ICrearTurnoRepo;
import repositorio.IRepositorioCrearVehiculo;

public class CrearTurnoUseCase {
    private ICrearTurnoRepo crearTurnoRepo;


    public CrearTurnoUseCase(ICrearTurnoRepo crearTurnoRepo) {
        this.crearTurnoRepo=crearTurnoRepo;

    }



    public boolean crearTurno(Turno turnoNuevo) throws TurnoExisteException {
        if((crearTurnoRepo.findVehiculo(turnoNuevo.getVehiculo().getMatricula())==null)||(crearTurnoRepo.findBFecha(turnoNuevo.getFecha())==null)) {
            return this.crearTurnoRepo.guardar(turnoNuevo);
        }else throw new TurnoExisteException("El turno no disponible");
    }
}
