package ar.edu.undec.Data.RepositorioImplementacion;
import ar.edu.undec.Data.EntityMapper.EmpleadoEntityMapper;
import ar.edu.undec.Data.ModeloEntity.EmpleadoEntity;
import ar.edu.undec.Data.ModeloEntity.TurnoEntity;
import ar.edu.undec.Data.RepositorioCRUD.IObtenerTop3EmpleadosPorTurnoCRUD;
import modelo.Empleado;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import repositorio.IObtenerTop3EmpleadosPorTurnosRepo;
import java.util.ArrayList;
import java.util.List;


@Service
public class ObtenerTop3EmpleadosPorTurnoRepoImple implements IObtenerTop3EmpleadosPorTurnosRepo {

    @Autowired
    IObtenerTop3EmpleadosPorTurnoCRUD iObtenerTop3EmpleadosPorTurnoCRUD;

    @Override
    public List<Empleado> obtenerTop3EmpleadosPorTurno() {
        Integer contador;
        List<Empleado> los3Empleados = new ArrayList<>();
        List<EmpleadoEntity> los3EmpleadosEntity = new ArrayList<>();
        List<TurnoEntity> losTurnos = iObtenerTop3EmpleadosPorTurnoCRUD.findAll();

        los3EmpleadosEntity.add(losTurnos.get(0).getEncargado());
        los3EmpleadosEntity.add(losTurnos.get(1).getEncargado());
        los3EmpleadosEntity.add(losTurnos.get(2).getEncargado());
        for (EmpleadoEntity et: los3EmpleadosEntity) {
            los3Empleados.add(new EmpleadoEntityMapper().mapeoDataCore(et));
        }
        return los3Empleados;
    }
}
