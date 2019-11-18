package ar.edu.undec.Data.RepositorioImplementacion;

import ar.edu.undec.Data.EntityMapper.TurnoEntityMapper;
import ar.edu.undec.Data.ModeloEntity.TurnoEntity;
import ar.edu.undec.Data.RepositorioCRUD.IModificarTurnoCRUD;
import modelo.Turno;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import repositorio.IModificarTurnoRepo;

import java.time.LocalDate;

@Service
public class ModificarTurnoRepoImple implements IModificarTurnoRepo {

    @Autowired
    IModificarTurnoCRUD modificarTurnoCRUD;

    @Override
    public boolean modificarTurno(Turno turnoDatosNuevo) {
        TurnoEntity turnoAGuardar = new TurnoEntityMapper().mapeoCoreData(turnoDatosNuevo);
        return modificarTurnoCRUD.save(turnoAGuardar)!=null;
    }

    @Override
    public Turno findByVehiculoAndFecha(String matricula, LocalDate fecha) {
        Turno turno = new TurnoEntityMapper().mapeoDataCore(modificarTurnoCRUD.findByVehiculoAndFecha(matricula,fecha));
        if(turno!=null){
            return turno;
        }
        return null;
    }
}
