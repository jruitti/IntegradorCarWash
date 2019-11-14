package input;

import excepciones.EmpleadoExisteException;
import modelo.Empleado;

public interface ICrearEmpleadoInput {
    boolean crearEmpleado(Empleado empleado) throws EmpleadoExisteException;
}
