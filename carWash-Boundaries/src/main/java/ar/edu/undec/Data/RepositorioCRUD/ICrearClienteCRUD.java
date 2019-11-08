package ar.edu.undec.Data.RepositorioCRUD;

import ar.edu.undec.Data.ModeloEntity.ClienteEntity;
import org.springframework.data.repository.CrudRepository;

public interface ICrearClienteCRUD extends CrudRepository<ClienteEntity,Integer> {
}
