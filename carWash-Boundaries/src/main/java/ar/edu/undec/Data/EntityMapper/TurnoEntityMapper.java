package ar.edu.undec.Data.EntityMapper;

import ar.edu.undec.Data.ModeloEntity.TurnoEntity;
import excepciones.EmpleadoIncompletoException;
import excepciones.TurnoIncompletoException;
import excepciones.VehiculoIncompletoException;
import modelo.Empleado;
import modelo.Turno;
import modelo.Vehiculo;

public class TurnoEntityMapper {

    public TurnoEntity mapeoCoreData(Turno turnoCore ){
        TurnoEntity turnoEntity = new TurnoEntity();
        turnoEntity.setIdPedido(turnoCore.getIdPedido());
        turnoEntity.setEncargado(new EmpleadoEntityMapper().mapeoCoreData(turnoCore.getEncargado()));
        turnoEntity.setFecha(turnoCore.getFecha());
        turnoEntity.setPrecio(turnoCore.getPrecio());
        turnoEntity.setVehiculo(new VehiculoEntityMapper().mapeoCoreData(turnoCore.getVehiculo()));
        return turnoEntity;
    }

    public Turno mapeoDataCore(TurnoEntity elTurno){
        try{
            return Turno.factoryTurno(elTurno.getIdPedido(), Vehiculo.factoryVehiculo(elTurno.getVehiculo().getIdVehiculo(),
                        elTurno.getVehiculo().getMatricula(),elTurno.getVehiculo().getMarca(), elTurno.getVehiculo().getModelo(), elTurno.getVehiculo().getCliente()),
                        elTurno.getFecha(), Empleado.factoryEmpleado(elTurno.getEncargado().getIdEmpleado(),elTurno.getEncargado().getNombre(),elTurno.getEncargado().getLegajo()), elTurno.getPrecio());
        }catch (TurnoIncompletoException | VehiculoIncompletoException | EmpleadoIncompletoException e) {
            e.printStackTrace();
            return null;
        }

    }
}
