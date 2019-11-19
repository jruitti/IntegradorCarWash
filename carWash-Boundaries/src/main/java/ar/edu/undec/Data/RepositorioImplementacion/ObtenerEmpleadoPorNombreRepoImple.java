package ar.edu.undec.Data.RepositorioImplementacion;

import ar.edu.undec.Data.EntityMapper.EmpleadoEntityMapper;
import ar.edu.undec.Data.ModeloEntity.EmpleadoEntity;
import ar.edu.undec.Data.RepositorioCRUD.IObtenerEmpleadoPorNombreCRUD;
import modelo.Empleado;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import repositorio.IObtnerEmpleadoPorNombreRepo;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Service
public class ObtenerEmpleadoPorNombreRepoImple implements IObtnerEmpleadoPorNombreRepo {

    @Autowired
    IObtenerEmpleadoPorNombreCRUD obtenerEmpleadoPorNombreCRUD;

    @Override
    public Collection<Empleado> buscarEmpleadoPorNombre(String nombre) {
        List<Empleado> empleadoList = new ArrayList<>();
        for (EmpleadoEntity empleado: obtenerEmpleadoPorNombreCRUD.findByNombreContains(nombre)) {
            Empleado empleado1 = new EmpleadoEntityMapper().mapeoDataCore(empleado);
            empleadoList.add(empleado1);
        }
        return empleadoList;
    }
}
