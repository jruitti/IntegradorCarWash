package ar.edu.undec.Service.ServiceMapper;

import ar.edu.undec.Service.ModeloService.VehiculoDTO;
import excepciones.VehiculoIncompletoException;
import modelo.Vehiculo;

public class VehiculoDTOMapper {
    public VehiculoDTO mapeoCoreDTO(Vehiculo vehiculoCore){
        VehiculoDTO elVehiculo = new VehiculoDTO(vehiculoCore.getIdVehiculo(), vehiculoCore.getMatricula(), vehiculoCore.getMarca(), vehiculoCore.getModelo(), vehiculoCore.getCliente());
        return elVehiculo;
    }

    public Vehiculo mapeoDTOCore(VehiculoDTO elVehiculo) {
        try {
            return Vehiculo.factoryVehiculo(elVehiculo.getIdVehiculo(), elVehiculo.getMatricula(), elVehiculo.getMarca(), elVehiculo.getModelo(), elVehiculo.getCliente());
        } catch (VehiculoIncompletoException e) {
            e.printStackTrace();
            return null;
        }
    }
}
