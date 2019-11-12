package ar.edu.undec.Data.RepositorioCRUD;

import ar.edu.undec.Data.ModeloEntity.VehiculoEntity;
import org.springframework.data.repository.CrudRepository;

public interface IBuscarVehiculoPorMatriculaCRUD extends CrudRepository<VehiculoEntity, Integer> {
    VehiculoEntity findByMatricula(String matricula);
}
