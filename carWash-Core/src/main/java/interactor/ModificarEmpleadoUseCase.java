package interactor;

import excepciones.EmpleadoExisteException;
import modelo.Empleado;
import repositorio.IModificarEmpleadoRepo;

import java.util.List;

public class ModificarEmpleadoUseCase {
    private IModificarEmpleadoRepo modificarEmpleadoRepo;
    public ModificarEmpleadoUseCase(IModificarEmpleadoRepo modificarEmpleadoRepo) {
        this.modificarEmpleadoRepo=modificarEmpleadoRepo;
    }

    public boolean modificarEmpleado(Empleado empleadoNuevo) throws EmpleadoExisteException {
        Empleado legajo=modificarEmpleadoRepo.findByLegajo(empleadoNuevo.getLegajo());
        if(legajo==null){
            return this.modificarEmpleadoRepo.modificarEmpleado(empleadoNuevo);
        }else if(legajo.getIdEmpleado()!=empleadoNuevo.getIdEmpleado()){
            throw new EmpleadoExisteException("Ids Distintos No se Puede Actualizar Empleado");
        }else return this.modificarEmpleadoRepo.modificarEmpleado(empleadoNuevo);
    }
}
