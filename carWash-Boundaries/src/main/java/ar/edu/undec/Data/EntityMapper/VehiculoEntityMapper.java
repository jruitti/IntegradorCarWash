package ar.edu.undec.Data.EntityMapper;

import ar.edu.undec.Data.ModeloEntity.VehiculoEntity;
import excepciones.VehiculoIncompletoException;
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
                return Vehiculo.factoryVehiculo(elVehiculo.getIdVehiculo(), elVehiculo.getMatricula(), elVehiculo.getMarca(), elVehiculo.getModelo(), elVehiculo.getCliente());
            return null;
        } catch (VehiculoIncompletoException e) {
            e.printStackTrace();
            return null;
        }
    }
}
