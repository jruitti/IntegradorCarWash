package ar.edu.undec.Data.RepositorioCRUD;

import ar.edu.undec.Data.ModeloEntity.TurnoEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface IObtenerTurnoPorFechaCRUD extends CrudRepository<TurnoEntity,Integer> {
    List<TurnoEntity> findAllByFechaBetween(LocalDate fechaInicio, LocalDate fechaFin);
}
