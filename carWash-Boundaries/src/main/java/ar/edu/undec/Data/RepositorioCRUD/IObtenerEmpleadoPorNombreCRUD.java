package ar.edu.undec.Data.RepositorioCRUD;

import ar.edu.undec.Data.ModeloEntity.EmpleadoEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IObtenerEmpleadoPorNombreCRUD extends CrudRepository<EmpleadoEntity, Integer> {
    List<EmpleadoEntity> findByNombreContains(String nombreEmpleado);
}
