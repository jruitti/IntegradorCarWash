package input;

import modelo.Empleado;

import java.util.List;

public interface IObtenerEmpleadoPorNombreInput {
    List<Empleado> buscarEmpleadoPorNombre(String nombre);
}
