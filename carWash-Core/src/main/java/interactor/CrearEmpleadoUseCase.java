package interactor;

import excepciones.EmpleadoExisteException;
import modelo.Empleado;
import repositorio.ICrearEmpleadoRepo;

public class CrearEmpleadoUseCase {

    private ICrearEmpleadoRepo crearEmpleadoRepo;
    public CrearEmpleadoUseCase(ICrearEmpleadoRepo crearEmpleadoRepo) {
        this.crearEmpleadoRepo=crearEmpleadoRepo;
    }

    public boolean crearEmpleado(Empleado empleadoNuevo) throws EmpleadoExisteException {
        if(this.crearEmpleadoRepo.findByLegajo(empleadoNuevo.getLegajo())==null){
            return this.crearEmpleadoRepo.guardarEmpleado(empleadoNuevo);
        }else throw new EmpleadoExisteException("El empleado ya existe ");
    }
}
