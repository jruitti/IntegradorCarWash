package repositorio;

import modelo.Empleado;

public interface ICrearEmpleadoRepo {
    boolean guardarEmpleado(Empleado empleadoNuevo);

    Empleado findByLegajo(int legajo);
}
