package interactor;

import excepciones.TurnoExisteException;
import input.IModificarTurnoInput;
import modelo.Turno;
import modelo.Vehiculo;

import repositorio.IModificarTurnoRepo;
import repositorio.IRepositorioCrearVehiculo;

import java.time.LocalDate;

public class ModificarTurnoUseCase implements IModificarTurnoInput {

    private IModificarTurnoRepo modificarTurnoRepo;

    public ModificarTurnoUseCase(IModificarTurnoRepo modificarTurnoRepo) {
        this.modificarTurnoRepo=modificarTurnoRepo;

    }

    public boolean modificarTurno(Turno turnoDatosNuevo) throws TurnoExisteException {


        Turno turnoAModificar=modificarTurnoRepo.findByVehiculoAndFecha(turnoDatosNuevo.getVehiculo().getMatricula(),turnoDatosNuevo.getFecha());
        if(turnoAModificar==null){
            return this.modificarTurnoRepo.modificarTurno(turnoDatosNuevo);
        }else if(turnoAModificar.getIdPedido()!=turnoDatosNuevo.getIdPedido()){
            throw new TurnoExisteException("Id distintos no se puede modificar el turno");
        }else return this.modificarTurnoRepo.modificarTurno(turnoDatosNuevo);

    }
}
