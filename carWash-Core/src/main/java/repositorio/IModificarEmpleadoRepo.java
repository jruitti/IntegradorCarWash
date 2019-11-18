package repositorio;

import modelo.Empleado;

public interface IModificarEmpleadoRepo {
    Empleado findByLegajo(Integer legajo);

    boolean modificarEmpleado(Empleado empleadoNuevo);
}
