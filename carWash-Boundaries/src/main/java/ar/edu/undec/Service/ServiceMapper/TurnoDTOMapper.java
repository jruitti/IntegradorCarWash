package ar.edu.undec.Service.ServiceMapper;

import ar.edu.undec.Service.ModeloService.EmpleadoDTO;
import ar.edu.undec.Service.ModeloService.TurnoDTO;
import ar.edu.undec.Service.ModeloService.VehiculoDTO;
import excepciones.TurnoIncompletoException;
import modelo.Empleado;
import modelo.Turno;
import modelo.Vehiculo;

public class TurnoDTOMapper {

    public TurnoDTO mapeoCoreDTO(Turno turnoCore) {
        VehiculoDTO elVehiculODTO = new VehiculoDTOMapper().mapeoCoreDTO(turnoCore.getVehiculo());
        EmpleadoDTO elEmpleadoDTO = new EmpleadoDTOMapper().mapeoCoreDTO(turnoCore.getEncargado());
        TurnoDTO elTurnoDTO = new TurnoDTO(turnoCore.getIdPedido(), elVehiculODTO, turnoCore.getFecha(), elEmpleadoDTO, turnoCore.getPrecio());
        return elTurnoDTO;
    }

    public Turno mapeoDTOCore(TurnoDTO turnoDTO) {
        try {
            Vehiculo vehiculoCore= new VehiculoDTOMapper().mapeoDTOCore(turnoDTO.getVehiculo());
            Empleado empleadoCore = new EmpleadoDTOMapper().mapeoDTOCore(turnoDTO.getEncargado());
            return Turno.factoryTurno(turnoDTO.getIdPedido(),vehiculoCore,turnoDTO.getFecha(),empleadoCore,turnoDTO.getPrecio());
        }catch (TurnoIncompletoException e) {
            e.printStackTrace();
            return null;
        }
    }
}
