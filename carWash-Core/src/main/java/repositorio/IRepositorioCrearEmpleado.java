package repositorio;

import modelo.Empleado;

public interface IRepositorioCrearEmpleado {
    boolean guardarEmpleado(Empleado empleadoNuevo);

    Empleado findByLegajo(Integer legajo);
}
