package ar.edu.undec.Data.RepositorioCRUD;

import ar.edu.undec.Data.ModeloEntity.EmpleadoEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IModificarEmpleadoCRUD extends CrudRepository<EmpleadoEntity, Integer> {
    EmpleadoEntity findByLegajo(Integer legajo);
}
