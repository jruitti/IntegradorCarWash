package ar.edu.undec.Data.RepositorioCRUD;

import ar.edu.undec.Data.ModeloEntity.ClienteEntity;
import org.springframework.data.repository.CrudRepository;

public interface IBuscarClientePorDniCRUD extends CrudRepository<ClienteEntity,Integer> {
    ClienteEntity findByDni(String documento);
}
