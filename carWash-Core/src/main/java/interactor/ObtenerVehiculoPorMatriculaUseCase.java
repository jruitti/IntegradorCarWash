package interactor;

import modelo.Vehiculo;
import repositorio.IObtenerVehiculoPorMatriculaRepo;

import java.util.List;

public class ObtenerVehiculoPorMatriculaUseCase {
    private IObtenerVehiculoPorMatriculaRepo obtenerVehiculoPorMatriculaRepo;
    public ObtenerVehiculoPorMatriculaUseCase(IObtenerVehiculoPorMatriculaRepo obtenerVehiculoPorMatriculaRepo) {
        this.obtenerVehiculoPorMatriculaRepo=obtenerVehiculoPorMatriculaRepo;
    }

    public List<Vehiculo> buscarVehiculoPorMatricula(String matricula) {
        return (List<Vehiculo>) obtenerVehiculoPorMatriculaRepo.buscarVehiculoPorMatricula(matricula);
    }
}
