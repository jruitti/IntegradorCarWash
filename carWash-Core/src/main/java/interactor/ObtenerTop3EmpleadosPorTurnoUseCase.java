package interactor;

import input.IObtenerTop3EmpleadosPorTurnoInput;
import modelo.Empleado;
import repositorio.IObtenerTop3EmpleadosPorTurnosRepo;

import java.util.List;

public class ObtenerTop3EmpleadosPorTurnoUseCase implements IObtenerTop3EmpleadosPorTurnoInput {
    private IObtenerTop3EmpleadosPorTurnosRepo iObtenerTop3EmpleadosPorTurnosRepo;

    public ObtenerTop3EmpleadosPorTurnoUseCase(IObtenerTop3EmpleadosPorTurnosRepo obtenerTop3EmpleadosPorTurnosRepo){
        this.iObtenerTop3EmpleadosPorTurnosRepo= obtenerTop3EmpleadosPorTurnosRepo;
    }


    public List<Empleado> obtenerTop3EmpleadosPorTurno(){
        return iObtenerTop3EmpleadosPorTurnosRepo.obtenerTop3EmpleadosPorTurno();
    }

}
