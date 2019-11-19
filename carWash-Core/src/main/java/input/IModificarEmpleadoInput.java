package input;

import excepciones.EmpleadoExisteException;
import modelo.Empleado;

public interface IModificarEmpleadoInput {
    Boolean modificarEmpleado(Empleado empleado) throws EmpleadoExisteException;
}
