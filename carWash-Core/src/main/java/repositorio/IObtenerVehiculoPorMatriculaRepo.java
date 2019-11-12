package repositorio;

import modelo.Vehiculo;

import java.util.Collection;

public interface IObtenerVehiculoPorMatriculaRepo {

    Collection<Vehiculo> buscarVehiculoPorMatricula(String matricula);
}
