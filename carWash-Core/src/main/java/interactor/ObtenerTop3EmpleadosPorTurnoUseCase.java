package interactor;

import excepciones.EmpleadoIncompletoException;
import modelo.Empleado;
import modelo.Turno;
import repositorio.IObtenerTop3EmpleadosPorTurnosRepo;

import java.util.List;

public class ObtenerTop3EmpleadosPorTurno {
    private IObtenerTop3EmpleadosPorTurnosRepo obtenerTop3EmpleadosPorTurnosRepo;

    public ObtenerTop3EmpleadosPorTurno(IObtenerTop3EmpleadosPorTurnosRepo obtenerTop3EmpleadosPorTurnosRepo){
        this.obtenerTop3EmpleadosPorTurnosRepo = obtenerTop3EmpleadosPorTurnosRepo;
    }

    public List<Empleado> obtenerTop3EmpleadosPorTurno(List<Turno> losTurnos, List<Empleado> losEmpleados){

    }

}
