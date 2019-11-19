package interactor;

import excepciones.EmpleadoExisteException;
import input.IModificarEmpleadoInput;
import modelo.Empleado;
import repositorio.IModificarEmpleadoRepo;

public class ModificarEmpleadoUseCase implements IModificarEmpleadoInput {
    private IModificarEmpleadoRepo modificarEmpleadoRepo;
    public ModificarEmpleadoUseCase(IModificarEmpleadoRepo modificarEmpleadoRepo) {
        this.modificarEmpleadoRepo=modificarEmpleadoRepo;
    }

    public Boolean modificarEmpleado(Empleado empleadoNuevo) throws EmpleadoExisteException {
        Empleado legajo=modificarEmpleadoRepo.findByLegajo(empleadoNuevo.getLegajo());
        if(legajo==null){
            return this.modificarEmpleadoRepo.modificarEmpleado(empleadoNuevo);
        }else if(legajo.getIdEmpleado()!=empleadoNuevo.getIdEmpleado()){
            throw new EmpleadoExisteException("Ids Distintos No se Puede Actualizar Empleado");
        }else return this.modificarEmpleadoRepo.modificarEmpleado(empleadoNuevo);
    }
}
