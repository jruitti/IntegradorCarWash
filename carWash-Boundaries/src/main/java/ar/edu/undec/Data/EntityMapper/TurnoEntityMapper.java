package ar.edu.undec.Data.EntityMapper;

import ar.edu.undec.Data.ModeloEntity.TurnoEntity;
import excepciones.ClienteIncompletoException;
import excepciones.EmpleadoIncompletoException;
import excepciones.TurnoIncompletoException;
import excepciones.VehiculoIncompletoException;
import modelo.Cliente;
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
        try {
            if (elTurno != null){
                return Turno.factoryTurno(elTurno.getIdPedido(), Vehiculo.factoryVehiculo(elTurno.getVehiculo().getIdVehiculo(),
                        elTurno.getVehiculo().getMatricula(), elTurno.getVehiculo().getMarca(), elTurno.getVehiculo().getModelo(),
                        Cliente.factoryCliente(elTurno.getVehiculo().getCliente().getIdCliente(), elTurno.getVehiculo().getCliente().getNombre(),
                                elTurno.getVehiculo().getCliente().getDomicilio(), elTurno.getVehiculo().getCliente().getBarrio(), elTurno.getVehiculo().getCliente().getDocumento())),
                        elTurno.getFecha(), Empleado.factoryEmpleado(elTurno.getEncargado().getIdEmpleado(), elTurno.getEncargado().getNombre(), elTurno.getEncargado().getLegajo()), elTurno.getPrecio());
            }
            return null;
        }catch (TurnoIncompletoException | VehiculoIncompletoException | EmpleadoIncompletoException | ClienteIncompletoException e) {
            e.printStackTrace();
            return null;
        }
    }
}
