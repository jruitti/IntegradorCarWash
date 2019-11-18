package input;

import modelo.Vehiculo;
import java.util.List;

public interface IObtenerVehiculoPorMatriculaImput {

    List<Vehiculo> buscarVehiculoPorMatricula(String matricula);
}
