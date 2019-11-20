package repositorio;

import modelo.Empleado;
import modelo.Turno;

import java.util.List;

public interface IObtenerTop3EmpleadosPorTurnosRepo {

    List<Empleado> findByEmpleadoAndTurno(List<Turno> listaTurnos, List<Empleado> losEmpleados);
}
