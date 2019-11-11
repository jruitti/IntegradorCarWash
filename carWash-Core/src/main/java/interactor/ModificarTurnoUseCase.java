package interactor;

import excepciones.TurnoExisteException;
import modelo.Turno;
import modelo.Vehiculo;

import repositorio.IModificarTurnoRepo;

import java.time.LocalDate;

public class ModificarTurnoUseCase {

    private IModificarTurnoRepo modificarTurnoRepo;

    public ModificarTurnoUseCase(IModificarTurnoRepo modificarTurnoRepo) {
        this.modificarTurnoRepo=modificarTurnoRepo;
    }

    public boolean modificarTurno(Turno turnoDatosNuevo) throws TurnoExisteException {

        Vehiculo vehiculo =modificarTurnoRepo.findMatricula(turnoDatosNuevo.getVehiculo().getMatricula());
        Turno fecha = modificarTurnoRepo.findBFecha(turnoDatosNuevo.getFecha());
       // Turno turno=modificarTurnoRepo.optenerId();
        if(vehiculo==null||fecha==null){
            return this.modificarTurnoRepo.modificarTurno(turnoDatosNuevo);
        }else if(fecha.getIdPedido()!=turnoDatosNuevo.getIdPedido()){
            throw new TurnoExisteException("Id distintos no se puede modificar el turno");
        }else return this.modificarTurnoRepo.modificarTurno(turnoDatosNuevo);

    }
}
