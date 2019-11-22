package ar.edu.undec.Data.RepositorioCRUD;

import ar.edu.undec.Data.ModeloEntity.TurnoEntity;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.time.LocalDate;
import java.util.List;

import static org.hibernate.loader.Loader.SELECT;

public interface IObtenerMontoIngresadoPorTurnoEntreFechasCRUD extends CrudRepository<TurnoEntity,Integer> {
    List<TurnoEntity> findAllByFechaBetween(LocalDate inicio, LocalDate fin);

}