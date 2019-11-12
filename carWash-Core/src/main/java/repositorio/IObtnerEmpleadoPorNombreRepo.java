package repositorio;

import modelo.Empleado;

import java.util.Collection;

public interface IObtnerEmpleadoPorNombreRepo {
    Collection<Empleado> buscarEmpleadoPorNombre(String nombre);
}
