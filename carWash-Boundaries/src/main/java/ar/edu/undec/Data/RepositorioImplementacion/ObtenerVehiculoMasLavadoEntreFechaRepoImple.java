package ar.edu.undec.Data.RepositorioImplementacion;

import ar.edu.undec.Data.EntityMapper.VehiculoEntityMapper;
import ar.edu.undec.Data.ModeloEntity.TurnoEntity;
import ar.edu.undec.Data.ModeloEntity.VehiculoEntity;
import ar.edu.undec.Data.RepositorioCRUD.IObtenerTurnoPorFechaCRUD;
import ar.edu.undec.Data.RepositorioCRUD.IObtenerVehiculoMasLavadoEntreFechaCRUD;
import modelo.Vehiculo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import repositorio.IObtenerVehiculoMasLavadoEntreFechaRepo;

import java.time.LocalDate;
import java.util.List;

@Service
public class ObtenerVehiculoMasLavadoEntreFechaRepoImple implements IObtenerVehiculoMasLavadoEntreFechaRepo {

    @Autowired
    IObtenerVehiculoMasLavadoEntreFechaCRUD obtenerVehiculoMasLavadoEntreFechaCRUD;
    @Autowired
    IObtenerTurnoPorFechaCRUD iObtenerTurnoPorFechaCRUD;

    @Override
    public Vehiculo obtenerVehiculoMasLavadoEntreFecha(LocalDate fechaInicio, LocalDate fechaFin) {

        List<TurnoEntity> turnoEntity = (List<TurnoEntity>) iObtenerTurnoPorFechaCRUD.findByFechaBetween(fechaInicio,fechaFin);
        VehiculoEntity vehiculoEntity = obtenerVehiculoMasLavadoEntreFechaCRUD.findByMatricula(turnoEntity.get(0).getVehiculo().getMatricula());
        Vehiculo vehiculo = new VehiculoEntityMapper().mapeoDataCore(vehiculoEntity);

        return vehiculo;
    }
}
