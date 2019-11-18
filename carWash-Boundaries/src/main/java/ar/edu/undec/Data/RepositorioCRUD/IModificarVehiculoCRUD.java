package ar.edu.undec.Data.RepositorioCRUD;

import ar.edu.undec.Data.ModeloEntity.VehiculoEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IModificarVehiculoCRUD extends CrudRepository<VehiculoEntity, Integer> {

    VehiculoEntity findByMatricula(String matricula);
}
