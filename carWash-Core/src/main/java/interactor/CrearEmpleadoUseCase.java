package interactor;

import excepciones.EmpleadoExisteException;
import input.ICrearEmpleadoInput;
import modelo.Empleado;
import repositorio.IRepositorioCrearEmpleado;

public class CrearEmpleadoUseCase implements ICrearEmpleadoInput {

    private IRepositorioCrearEmpleado crearEmpleadoRepo;
    public CrearEmpleadoUseCase(IRepositorioCrearEmpleado crearEmpleadoRepo) {
        this.crearEmpleadoRepo=crearEmpleadoRepo;
    }

    public boolean crearEmpleado(Empleado empleadoNuevo) throws EmpleadoExisteException {
        if(this.crearEmpleadoRepo.findByLegajo(empleadoNuevo.getLegajo())==null){
            return this.crearEmpleadoRepo.guardarEmpleado(empleadoNuevo);
        }else throw new EmpleadoExisteException("El empleado ya existe ");
    }
}
