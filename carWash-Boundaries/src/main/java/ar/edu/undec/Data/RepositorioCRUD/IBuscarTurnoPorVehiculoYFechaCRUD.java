package ar.edu.undec.Data.RepositorioCRUD;

import ar.edu.undec.Data.ModeloEntity.TurnoEntity;
import modelo.Vehiculo;
import org.springframework.data.repository.CrudRepository;

import java.time.LocalDate;

public interface IBuscarTurnoPorVehiculoYFechaCRUD extends CrudRepository<TurnoEntity, Integer> {
    TurnoEntity findByVehiculoAndFecha(Vehiculo elVehiculo, LocalDate fecha);
}
