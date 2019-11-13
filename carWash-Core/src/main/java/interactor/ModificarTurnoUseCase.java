package interactor;

import excepciones.TurnoExisteException;
import modelo.Turno;
import modelo.Vehiculo;

import repositorio.IModificarTurnoRepo;
import repositorio.IRepositorioCrearVehiculo;

import java.time.LocalDate;

public class ModificarTurnoUseCase {

    private IModificarTurnoRepo modificarTurnoRepo;
    private IRepositorioCrearVehiculo repositorioCrearVehiculo;

    public ModificarTurnoUseCase(IModificarTurnoRepo modificarTurnoRepo, IRepositorioCrearVehiculo repositorioCrearVehiculo) {
        this.modificarTurnoRepo=modificarTurnoRepo;
        this.repositorioCrearVehiculo=repositorioCrearVehiculo;
    }

    public boolean modificarTurno(Turno turnoDatosNuevo) throws TurnoExisteException {

        //Vehiculo vehiculo =modificarTurnoRepo.findMatricula(turnoDatosNuevo.getVehiculo().getMatricula());

        Vehiculo vehiculo = repositorioCrearVehiculo.findByMatricula(turnoDatosNuevo.getVehiculo().getMatricula());
        Turno fecha = modificarTurnoRepo.findBFecha(turnoDatosNuevo.getFecha());
       // Turno turno=modificarTurnoRepo.optenerId();
        if(vehiculo==null||fecha==null){
            return this.modificarTurnoRepo.modificarTurno(turnoDatosNuevo);
        }else if(fecha.getIdPedido()!=turnoDatosNuevo.getIdPedido()){
            throw new TurnoExisteException("Id distintos no se puede modificar el turno");
        }else return this.modificarTurnoRepo.modificarTurno(turnoDatosNuevo);

    }
}
