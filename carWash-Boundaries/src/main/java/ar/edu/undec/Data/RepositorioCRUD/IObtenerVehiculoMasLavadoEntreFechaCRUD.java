package ar.edu.undec.Data.RepositorioCRUD;

import ar.edu.undec.Data.ModeloEntity.VehiculoEntity;
import modelo.Vehiculo;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;

@Repository
public interface IObtenerVehiculoMasLavadoEntreFechaCRUD extends CrudRepository<VehiculoEntity, Integer> {
    VehiculoEntity findByMatricula(String matricula);
}
