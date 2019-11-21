package ar.edu.undec.Data.RepositorioImplementacion;
import ar.edu.undec.Data.EntityMapper.EmpleadoEntityMapper;
import ar.edu.undec.Data.ModeloEntity.EmpleadoEntity;
import ar.edu.undec.Data.ModeloEntity.TurnoEntity;
import ar.edu.undec.Data.RepositorioCRUD.IObtenerEmpleadoPorIdCRUD;
import ar.edu.undec.Data.RepositorioCRUD.IObtenerTop3EmpleadosPorTurnoCRUD;
import modelo.Empleado;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import repositorio.IObtenerTop3EmpleadosPorTurnosRepo;

import java.util.*;

import static java.util.stream.Collectors.toMap;


@Service
public class ObtenerTop3EmpleadosPorTurnoRepoImple implements IObtenerTop3EmpleadosPorTurnosRepo {

    @Autowired
    IObtenerTop3EmpleadosPorTurnoCRUD iObtenerTop3EmpleadosPorTurnoCRUD;

    @Autowired
    IObtenerEmpleadoPorIdCRUD iObtenerEmpleadoPorIdCRUD;

    @Override
    public List<Empleado> obtenerTop3EmpleadosPorTurno() {
        List<Empleado> los3Empleados = new ArrayList<>();
        List<EmpleadoEntity> losEmpleadosEntity = new ArrayList<>();
        List<TurnoEntity> losTurnos = iObtenerTop3EmpleadosPorTurnoCRUD.findAll();
        List<Integer> idEmpleados = new ArrayList<>();
        //Obtiene todos los empleados de los turnos
        for(int i=0; i< losTurnos.size(); ++i) {
            idEmpleados.add(losTurnos.get(i).getEncargado().getIdEmpleado());
        }
        //Genera un map con los id de los empleados y la cantidad de ocurrencias en los turnos
        Map<Integer, Integer> hm = new HashMap<>();
        for (Integer i : idEmpleados) {
            Integer j = hm.get(i);
            hm.put(i, (j == null) ? 1 : j + 1);
        }

        //Ordena el map en órden descendente
        Map<Integer, Integer> sorted = hm.entrySet().stream().sorted(Collections.reverseOrder(Map.Entry.comparingByValue())).collect(toMap(Map.Entry::getKey, Map.Entry::getValue, (e1, e2) -> e2,LinkedHashMap::new));
        //Asigna los ids a un arrayList
        List<Integer> idEmp = new ArrayList<>(sorted.keySet());
        //Busca los empleados con los ids y los asigna
        losEmpleadosEntity.add(iObtenerEmpleadoPorIdCRUD.findByIdEmpleado(idEmp.get(0)));
        losEmpleadosEntity.add(iObtenerEmpleadoPorIdCRUD.findByIdEmpleado(idEmp.get(1)));
        losEmpleadosEntity.add(iObtenerEmpleadoPorIdCRUD.findByIdEmpleado(idEmp.get(2)));

        for (EmpleadoEntity et: losEmpleadosEntity) {
            los3Empleados.add(new EmpleadoEntityMapper().mapeoDataCore(et));
        }

        return los3Empleados;
    }
}
