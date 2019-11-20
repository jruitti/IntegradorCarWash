package repositorio;

import modelo.Empleado;
import modelo.Turno;

import java.util.List;

public interface IObtenerTop3EmpleadosPorTurnos {

    List<Empleado> obtenerTop3EmpleadosPorTurnos(List<Turno> listaTurnos);
}
