package ar.edu.undec.Data.RepositorioCRUD;

import ar.edu.undec.Data.ModeloEntity.EmpleadoEntity;
import org.springframework.data.repository.CrudRepository;

public interface IBuscarEmpleadoPorLegajoCRUD extends CrudRepository<EmpleadoEntity, Integer> {
    EmpleadoEntity findByLegajo(Integer legajo);
}
