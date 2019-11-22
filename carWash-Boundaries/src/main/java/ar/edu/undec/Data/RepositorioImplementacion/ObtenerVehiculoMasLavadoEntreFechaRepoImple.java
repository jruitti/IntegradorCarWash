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
import java.util.*;

import static java.util.stream.Collectors.toMap;

@Service
public class ObtenerVehiculoMasLavadoEntreFechaRepoImple implements IObtenerVehiculoMasLavadoEntreFechaRepo {

    @Autowired
    IObtenerVehiculoMasLavadoEntreFechaCRUD obtenerVehiculoMasLavadoEntreFechaCRUD;
    @Autowired
    IObtenerTurnoPorFechaCRUD iObtenerTurnoPorFechaCRUD;

    @Override
    public Vehiculo obtenerVehiculoMasLavadoEntreFecha(LocalDate fechaInicio, LocalDate fechaFin) {

        List<TurnoEntity> turnoEntity = new ArrayList<>();
        List<VehiculoEntity> vehiculoEntityList = new ArrayList<>();
        List<Integer> indiceVehiculo = new ArrayList<>();

        turnoEntity = (List<TurnoEntity>) iObtenerTurnoPorFechaCRUD.findByFechaBetween(fechaInicio,fechaFin);

        for (TurnoEntity turno: turnoEntity) {
            indiceVehiculo.add(turno.getVehiculo().getIdVehiculo());
        }

        Map<Integer, Integer> p = new HashMap<>();
        for (Integer indice: indiceVehiculo) {
            Integer cont = p.get(indice);
            p.put(indice, (cont == null) ? 1 : cont + 1);
        }

        Map<Integer, Integer> sorted = p.entrySet().stream().sorted(Collections.reverseOrder(Map.Entry.comparingByValue())).collect(toMap(Map.Entry::getKey, Map.Entry::getValue, (e1, e2) -> e2,LinkedHashMap::new));

        List<Integer> idVeh = new ArrayList<>(sorted.keySet());


        VehiculoEntity vehiculoEntity = obtenerVehiculoMasLavadoEntreFechaCRUD.findByIdVehiculo(idVeh.get(0).intValue());
        Vehiculo vehiculo = new VehiculoEntityMapper().mapeoDataCore(vehiculoEntity);

        return vehiculo;
    }
}
