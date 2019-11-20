package interactor;

import excepciones.EmpleadoIncompletoException;
import modelo.Empleado;
import modelo.Turno;
import repositorio.IObtenerTop3EmpleadosPorTurnosRepo;

import java.util.List;

public class ObtenerTop3EmpleadosPorTurnoUseCase {
    private IObtenerTop3EmpleadosPorTurnosRepo obtenerTop3EmpleadosPorTurnosRepo;

    public ObtenerTop3EmpleadosPorTurnoUseCase(IObtenerTop3EmpleadosPorTurnosRepo obtenerTop3EmpleadosPorTurnosRepo){
        this.obtenerTop3EmpleadosPorTurnosRepo = obtenerTop3EmpleadosPorTurnosRepo;
    }

    public List<Empleado> obtenerTop3EmpleadosPorTurno(List<Turno> losTurnos, List<Empleado> losEmpleados){
        return obtenerTop3EmpleadosPorTurnosRepo.findByEmpleadoAndTurno(losTurnos, losEmpleados);
    }

}
