package interactor;

import modelo.Empleado;
import repositorio.IObtenerVehiculoPorMatriculaRepo;
import repositorio.IObtnerEmpleadoPorNombreRepo;

import java.util.List;

public class ObtenerEmpleadoPorNombreUseCase {
    private IObtnerEmpleadoPorNombreRepo obtnerEmpleadoPorNombreRepo;
    public ObtenerEmpleadoPorNombreUseCase(IObtnerEmpleadoPorNombreRepo obtnerEmpleadoPorNombreRepo) {
        this.obtnerEmpleadoPorNombreRepo=obtnerEmpleadoPorNombreRepo;
    }

    public List<Empleado> buscarEmpleadoPorNombre(String nombre) {
        return (List<Empleado>) obtnerEmpleadoPorNombreRepo.buscarEmpleadoPorNombre(nombre);
    }
}
