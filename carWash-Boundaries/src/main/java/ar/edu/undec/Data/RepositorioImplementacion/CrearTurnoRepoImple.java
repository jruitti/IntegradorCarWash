package ar.edu.undec.Data.RepositorioImplementacion;

import ar.edu.undec.Data.EntityMapper.TurnoEntityMapper;
import ar.edu.undec.Data.ModeloEntity.TurnoEntity;
import ar.edu.undec.Data.RepositorioCRUD.IBuscarTurnoPorVehiculoYFechaCRUD;
import ar.edu.undec.Data.RepositorioCRUD.ICrearTurnoCRUD;
import modelo.Turno;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import repositorio.IRepositorioCrearTurno;

import java.time.LocalDate;

@Repository
public class CrearTurnoRepoImple implements IRepositorioCrearTurno {
    @Autowired
    ICrearTurnoCRUD crearTurnoCRUD;
    @Autowired
    IBuscarTurnoPorVehiculoYFechaCRUD buscarTurnoPorVehiculoYFechaCRUD;

    public boolean guardar(Turno turnoNuevo){
        TurnoEntity elTurnoAGuardar = new TurnoEntityMapper().mapeoCoreData(turnoNuevo);
        return crearTurnoCRUD.save(elTurnoAGuardar).getIdPedido()!=null;
    }

    @Override
    public Turno findByVehiculoAndFecha(String matricula, LocalDate fecha) {
        Turno elTurno = new TurnoEntityMapper().mapeoDataCore(buscarTurnoPorVehiculoYFechaCRUD.findByVehiculoAndFecha(matricula, fecha));
        if (elTurno != null) {
            return elTurno;
        }
        return null;
    }
}
