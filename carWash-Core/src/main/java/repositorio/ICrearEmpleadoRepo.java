package repositorio;

import modelo.Empleado;

public interface ICrearEmpleadoRepo {
    boolean guardarEmpleado(Empleado empleadoNuevo);

    Empleado findByLegajo(Integer legajo);
}
