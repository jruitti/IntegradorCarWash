package ar.edu.undec.Data.RepositorioImplementacion;

import ar.edu.undec.Data.EntityMapper.VehiculoEntityMapper;
import ar.edu.undec.Data.ModeloEntity.TurnoEntity;
import ar.edu.undec.Data.ModeloEntity.VehiculoEntity;
import ar.edu.undec.Data.RepositorioCRUD.IObtenerTurnoPorFechaCRUD;
import ar.edu.undec.Data.RepositorioCRUD.IObtenerVehiculoMasLavadoEntreFechaCRUD;
import modelo.Vehiculo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Service;
import repositorio.IObtenerVehiculoMasLavadoEntreFechaRepo;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
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

        List<TurnoEntity> turnoEntity = iObtenerTurnoPorFechaCRUD.findAllByFechaBetween(fechaInicio, fechaFin);
        for (TurnoEntity t: turnoEntity) {
            System.out.println("fechas:"+ t.getFecha());
        }

        List<Integer> indiceVehiculo = new ArrayList<>();

        for (TurnoEntity turno: turnoEntity) {
            indiceVehiculo.add(turno.getVehiculo().getIdVehiculo());
        }

        Map<Integer, Integer> p = new HashMap<>();
        for (Integer i: indiceVehiculo) {
            Integer j = p.get(i);
            p.put(i, (j == null) ? 1 : j + 1);
        }

        Map<Integer, Integer> sorted = p.entrySet().stream().sorted(Collections.reverseOrder(Map.Entry.comparingByValue())).collect(toMap(Map.Entry::getKey, Map.Entry::getValue, (e1, e2) -> e2,LinkedHashMap::new));

        List<Integer> idVeh = new ArrayList<>(sorted.keySet());

        VehiculoEntity vehiculoEntity = obtenerVehiculoMasLavadoEntreFechaCRUD.findByIdVehiculo(idVeh.get(0));
        Vehiculo vehiculo = new VehiculoEntityMapper().mapeoDataCore(vehiculoEntity);

        return vehiculo;
    }
}
