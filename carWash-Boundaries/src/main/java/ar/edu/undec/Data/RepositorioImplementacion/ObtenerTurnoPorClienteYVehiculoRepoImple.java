package ar.edu.undec.Data.RepositorioImplementacion;

import ar.edu.undec.Data.EntityMapper.TurnoEntityMapper;
import ar.edu.undec.Data.ModeloEntity.TurnoEntity;
import ar.edu.undec.Data.RepositorioCRUD.IObtenerTurnoPorClienteYVehiculoCRUD;
import modelo.Turno;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import repositorio.IObtenerTurnoPorClienteYVehiculoRepo;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;


@Service
public class ObtenerTurnoPorClienteYVehiculoRepoImple implements IObtenerTurnoPorClienteYVehiculoRepo {

    @Autowired
    IObtenerTurnoPorClienteYVehiculoCRUD obtenerTurnoPorClienteYVehiculoCRUD;


    @Override
    public Collection<Turno> obtenerTurnoPorClienteyVehiculo(String documento, String matricula) {
        List<Turno> turnos= new ArrayList<>();
        List<TurnoEntity> losTurnos = obtenerTurnoPorClienteYVehiculoCRUD.findTurnoEntityByVehiculo_MatriculaAndVehiculo_Cliente_Documento(matricula, documento);
        for (TurnoEntity t: losTurnos) {
            Turno turno = new TurnoEntityMapper().mapeoDataCore(t);
            turnos.add(turno);
        }
        return turnos;
    }
}

