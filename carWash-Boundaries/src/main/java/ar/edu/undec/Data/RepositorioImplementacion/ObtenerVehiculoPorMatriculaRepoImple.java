package ar.edu.undec.Data.RepositorioImplementacion;

import ar.edu.undec.Data.EntityMapper.VehiculoEntityMapper;
import ar.edu.undec.Data.ModeloEntity.VehiculoEntity;
import ar.edu.undec.Data.RepositorioCRUD.IBuscarVehiculoPorMatriculaCRUD;
import modelo.Vehiculo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import repositorio.IObtenerVehiculoPorMatriculaRepo;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Service
public class ObtenerVehiculoPorMatriculaRepoImple implements IObtenerVehiculoPorMatriculaRepo {
    @Autowired
    IBuscarVehiculoPorMatriculaCRUD iBuscarVehiculoPorMatriculaCRUD;

    public Collection<Vehiculo> buscarVehiculoPorMatricula(String matricula){
        List<Vehiculo> vehiculosBuscados = new ArrayList<>();
        for(VehiculoEntity elVehiculo : iBuscarVehiculoPorMatriculaCRUD.findByMatriculaContains(matricula)) {
            Vehiculo vehiculo = new VehiculoEntityMapper().mapeoDataCore(elVehiculo);
            vehiculosBuscados.add(vehiculo);
        }
        return vehiculosBuscados;
    }
}
