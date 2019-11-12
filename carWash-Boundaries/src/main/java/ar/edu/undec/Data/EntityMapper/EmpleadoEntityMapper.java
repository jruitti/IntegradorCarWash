package ar.edu.undec.Data.EntityMapper;

import ar.edu.undec.Data.ModeloEntity.EmpleadoEntity;
import excepciones.EmpleadoIncompletoException;
import modelo.Empleado;

public class EmpleadoEntityMapper {

    public EmpleadoEntity mapeoCoreData(Empleado empleadoCore){
        EmpleadoEntity empleadoEntity = new EmpleadoEntity();
        empleadoEntity.setIdEmpleado(empleadoCore.getIdEmpleado());
        empleadoEntity.setNombre(empleadoCore.getNombre());
        empleadoEntity.setLegajo(empleadoCore.getLegajo());

        return empleadoEntity;
    }

    public Empleado mapeoDataCore(EmpleadoEntity empleadoEntity){
        try {
            if(empleadoEntity != null){
                return Empleado.factoryEmpleado(empleadoEntity.getIdEmpleado(),empleadoEntity.getNombre(),empleadoEntity.getLegajo());
            }
            return null;
        }
        catch (EmpleadoIncompletoException e){
            e.printStackTrace();
            return null;
        }
    }
}
