package repositorio;

import modelo.Empleado;

public interface IModificarEmpleadoRepo {
    Empleado findByLegajo(int legajo);

    boolean modificarEmpleado(Empleado empleadoNuevo);
}
