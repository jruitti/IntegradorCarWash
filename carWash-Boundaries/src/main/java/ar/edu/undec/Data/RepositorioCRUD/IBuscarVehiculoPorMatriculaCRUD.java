package ar.edu.undec.Data.RepositorioCRUD;

import ar.edu.undec.Data.ModeloEntity.VehiculoEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IBuscarVehiculoPorMatriculaCRUD extends CrudRepository<VehiculoEntity, Integer> {
    List<VehiculoEntity> findByMatriculaContains(String matricula);
}
