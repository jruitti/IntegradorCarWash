package interactor;

import input.IObtenerVehiculoPorMatriculaImput;
import modelo.Vehiculo;
import repositorio.IObtenerVehiculoPorMatriculaRepo;

import java.util.List;

public class ObtenerVehiculoPorMatriculaUseCase implements IObtenerVehiculoPorMatriculaImput {
    private IObtenerVehiculoPorMatriculaRepo obtenerVehiculoPorMatriculaRepo;
    public ObtenerVehiculoPorMatriculaUseCase(IObtenerVehiculoPorMatriculaRepo obtenerVehiculoPorMatriculaRepo) {
        this.obtenerVehiculoPorMatriculaRepo=obtenerVehiculoPorMatriculaRepo;
    }

    @Override
    public List<Vehiculo> buscarVehiculoPorMatricula(String matricula) {
        return (List<Vehiculo>) obtenerVehiculoPorMatriculaRepo.buscarVehiculoPorMatricula(matricula);
    }
}
