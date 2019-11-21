package ar.edu.undec.Data.RepositorioCRUD;

import ar.edu.undec.Data.ModeloEntity.EmpleadoEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IObtenerEmpleadoPorIdCRUD extends CrudRepository<EmpleadoEntity, Integer> {
    EmpleadoEntity findByIdEmpleado(Integer idEmpleado);
}
