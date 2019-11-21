package ar.edu.undec.Data.RepositorioCRUD;

import ar.edu.undec.Data.ModeloEntity.TurnoEntity;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface IObtenerTop3EmpleadosPorTurnoCRUD extends CrudRepository<TurnoEntity, Integer>{
    List<TurnoEntity> findAll();
}
