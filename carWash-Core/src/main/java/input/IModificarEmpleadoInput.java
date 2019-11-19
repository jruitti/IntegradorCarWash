package input;

import excepciones.EmpleadoExisteException;
import modelo.Empleado;

public interface IModificarEmpleadoInput {
    boolean modificarEmpleado(Empleado empleado) throws EmpleadoExisteException;
}
