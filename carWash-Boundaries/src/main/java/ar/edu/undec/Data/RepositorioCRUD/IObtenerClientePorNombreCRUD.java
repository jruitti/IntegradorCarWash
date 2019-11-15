package ar.edu.undec.Data.RepositorioCRUD;

import ar.edu.undec.Data.ModeloEntity.ClienteEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface IObtenerClientePorNombreCRUD  extends CrudRepository<ClienteEntity,Integer> {
    List<ClienteEntity> findByNombreContains(String nombreCliente);
}
