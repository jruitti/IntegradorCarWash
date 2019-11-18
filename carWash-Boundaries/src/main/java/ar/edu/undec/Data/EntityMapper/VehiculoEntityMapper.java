package ar.edu.undec.Data.EntityMapper;

import ar.edu.undec.Data.ModeloEntity.VehiculoEntity;
import excepciones.ClienteIncompletoException;
import excepciones.VehiculoIncompletoException;
import modelo.Cliente;
import modelo.Vehiculo;

public class VehiculoEntityMapper {

    public VehiculoEntity mapeoCoreData(Vehiculo vehiculoCore) {
        VehiculoEntity vehiculoEntity = new VehiculoEntity();
        vehiculoEntity.setIdVehiculo(vehiculoCore.getIdVehiculo());
        vehiculoEntity.setMatricula(vehiculoCore.getMatricula());
        vehiculoEntity.setMarca(vehiculoCore.getMarca());
        vehiculoEntity.setModelo(vehiculoCore.getModelo());
        vehiculoEntity.setCliente(new ClienteEntityMapper().mapeoCoreData(vehiculoCore.getCliente()));
        return vehiculoEntity;
    }

    public Vehiculo mapeoDataCore(VehiculoEntity elVehiculo){
        try{
            if(elVehiculo != null)
                return Vehiculo.factoryVehiculo(elVehiculo.getIdVehiculo(), elVehiculo.getMatricula(), elVehiculo.getMarca(), elVehiculo.getModelo(),
                        Cliente.factoryCliente(elVehiculo.getCliente().getIdCliente(), elVehiculo.getCliente().getNombre(),
                        elVehiculo.getCliente().getDomicilio(), elVehiculo.getCliente().getBarrio(), elVehiculo.getCliente().getDocumento()));
            return null;
        } catch (VehiculoIncompletoException | ClienteIncompletoException e) {
            e.printStackTrace();
            return null;
        }
    }
}
