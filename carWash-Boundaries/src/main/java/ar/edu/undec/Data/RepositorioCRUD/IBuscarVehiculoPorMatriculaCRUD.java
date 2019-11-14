package ar.edu.undec.Data.RepositorioCRUD;

import ar.edu.undec.Data.ModeloEntity.VehiculoEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IBuscarVehiculoPorMatriculaCRUD extends CrudRepository<VehiculoEntity, Integer> {
    VehiculoEntity findByMatriculaContains(String matricula);
}
