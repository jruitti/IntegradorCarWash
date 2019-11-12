package ar.edu.undec.Data.RepositorioCRUD;

import ar.edu.undec.Data.ModeloEntity.EmpleadoEntity;
import org.springframework.data.repository.CrudRepository;


public interface ICrearEmpleadoCRUD extends CrudRepository<EmpleadoEntity, Integer> {
}
