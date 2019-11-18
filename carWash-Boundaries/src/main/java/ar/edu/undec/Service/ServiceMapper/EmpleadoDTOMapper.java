package ar.edu.undec.Service.ServiceMapper;


import ar.edu.undec.Service.ModeloService.EmpleadoDTO;
import excepciones.EmpleadoIncompletoException;
import modelo.Empleado;

public class EmpleadoDTOMapper {
    public EmpleadoDTO mapeoCoreDTO(Empleado empleado){
        EmpleadoDTO empleadoDTO = new EmpleadoDTO(empleado.getIdEmpleado(),empleado.getNombre(),empleado.getLegajo());
        return empleadoDTO;
    }

    public Empleado mapeoDTOCore(EmpleadoDTO empleadoDTO){
         try {
             return Empleado.factoryEmpleado(empleadoDTO.getIdEmpleado(),empleadoDTO.getNombre(),empleadoDTO.getLegajo());
         }catch (EmpleadoIncompletoException e){
             e.printStackTrace();
             return null;
         }

    }
}
