package interactor;

import excepciones.VehiculoExisteException;
import input.IModificarVehiculoInput;
import modelo.Vehiculo;
import repositorio.IModificarVehiculoRepo;

public class ModificarVehiculoUseCase implements IModificarVehiculoInput {
    private  IModificarVehiculoRepo modificarVehiculoRepo;
    public ModificarVehiculoUseCase(IModificarVehiculoRepo modificarVehiculoRepo) {
        this.modificarVehiculoRepo=modificarVehiculoRepo;
    }

    public boolean modificarVehiculo(Vehiculo vehiculoNuevo) throws VehiculoExisteException {
        Vehiculo vehiculo = modificarVehiculoRepo.findByMatricula(vehiculoNuevo.getMatricula());
        if(vehiculo==null){
            return this.modificarVehiculoRepo.modificarVehiculo(vehiculoNuevo);
        }else if(vehiculo.getIdVehiculo()!=vehiculoNuevo.getIdVehiculo()){
            throw new VehiculoExisteException("No se Puede Actualizar Ids diferentes");
        }else return this.modificarVehiculoRepo.modificarVehiculo(vehiculoNuevo);
    }
}
