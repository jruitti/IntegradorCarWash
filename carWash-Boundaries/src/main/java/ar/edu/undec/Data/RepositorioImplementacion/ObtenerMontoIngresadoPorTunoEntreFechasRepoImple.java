package ar.edu.undec.Data.RepositorioImplementacion;

import ar.edu.undec.Data.ModeloEntity.TurnoEntity;
import ar.edu.undec.Data.RepositorioCRUD.IObtenerMontoIngresadoPorTurnoEntreFechasCRUD;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import repositorio.IObtenerMontoIngresadoPorTurnosEntreFechasRepo;

import java.time.LocalDate;
import java.util.List;

@Service
public class ObtenerMontoIngresadoPorTunoEntreFechasRepoImple  implements IObtenerMontoIngresadoPorTurnosEntreFechasRepo {
    @Autowired
    IObtenerMontoIngresadoPorTurnoEntreFechasCRUD obtenerMontoIngresadoPorTurnoEntreFechasCRUD;

    public Double obtenerMonto(LocalDate fechaInicio, LocalDate fechaFin) {
        List<TurnoEntity> turnos=(List<TurnoEntity>) obtenerMontoIngresadoPorTurnoEntreFechasCRUD.findAll();
        Double total=0.0;
        for (TurnoEntity turno:turnos){
            if(fechaInicio.isBefore(fechaFin)){
                total+=turno.getPrecio();
            }
        }
        return total;
    }


}
