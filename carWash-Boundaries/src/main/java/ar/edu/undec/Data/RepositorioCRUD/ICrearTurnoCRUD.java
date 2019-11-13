package ar.edu.undec.Data.RepositorioCRUD;

import ar.edu.undec.Data.ModeloEntity.TurnoEntity;
import org.springframework.data.repository.CrudRepository;

public interface ICrearTurnoCRUD extends CrudRepository<TurnoEntity, Integer> {
}
