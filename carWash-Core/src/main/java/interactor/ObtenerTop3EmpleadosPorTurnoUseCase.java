package interactor;

import modelo.Empleado;
import modelo.Turno;
import repositorio.IObtenerTop3EmpleadosPorTurnosRepo;

import java.util.List;

public class ObtenerTop3EmpleadosPorTurnoUseCase {
    private IObtenerTop3EmpleadosPorTurnosRepo iObtenerTop3EmpleadosPorTurnosRepo;

    public ObtenerTop3EmpleadosPorTurnoUseCase(IObtenerTop3EmpleadosPorTurnosRepo obtenerTop3EmpleadosPorTurnosRepo){
        this.iObtenerTop3EmpleadosPorTurnosRepo= obtenerTop3EmpleadosPorTurnosRepo;
    }


    public List<Empleado> obtenerTop3EmpleadosPorTurno(){
        return iObtenerTop3EmpleadosPorTurnosRepo.obtenerTop3EmpleadosPorTurno();
    }

}
