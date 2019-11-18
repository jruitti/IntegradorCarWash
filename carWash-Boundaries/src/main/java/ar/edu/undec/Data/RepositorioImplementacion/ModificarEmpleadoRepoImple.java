package ar.edu.undec.Data.RepositorioImplementacion;

import ar.edu.undec.Data.EntityMapper.EmpleadoEntityMapper;
import ar.edu.undec.Data.ModeloEntity.EmpleadoEntity;
import ar.edu.undec.Data.RepositorioCRUD.IModificarEmpleadoCRUD;
import modelo.Empleado;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import repositorio.IModificarEmpleadoRepo;

@Service
public class ModificarEmpleadoRepoImple implements IModificarEmpleadoRepo {

    @Autowired
    IModificarEmpleadoCRUD modificarEmpleadoCRUD;

    @Override
    public Empleado findByLegajo(Integer legajo) {
        Empleado empleado = new EmpleadoEntityMapper().mapeoDataCore(modificarEmpleadoCRUD.findBYLegajo(legajo));
        if(empleado != null){
            return empleado;
        }
        return null;
    }

    @Override
    public boolean modificarEmpleado(Empleado empleadoNuevo) {
        EmpleadoEntity empleadoEntity = new EmpleadoEntityMapper().mapeoCoreData(empleadoNuevo);
        return modificarEmpleadoCRUD.save(empleadoEntity) != null;
    }
}
