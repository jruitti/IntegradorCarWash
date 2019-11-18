package ar.edu.undec.Data.RepositorioCRUD;

import ar.edu.undec.Data.ModeloEntity.EmpleadoEntity;
import org.springframework.data.repository.CrudRepository;

public interface IModificarEmpleadoCRUD extends CrudRepository<EmpleadoEntity, Integer> {
    EmpleadoEntity findBYLegajo(Integer legajo);
}
