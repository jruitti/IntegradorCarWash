package ar.edu.undec.Service.ServiceMapper;

import ar.edu.undec.Service.ModeloService.ClienteDTO;
import ar.edu.undec.Service.ModeloService.VehiculoDTO;
import excepciones.VehiculoIncompletoException;
import modelo.Cliente;
import modelo.Vehiculo;

public class VehiculoDTOMapper {
    public VehiculoDTO mapeoCoreDTO(Vehiculo vehiculoCore){
        ClienteDTO elClienteDTO = new ClienteDTOMapper().mapeoCoreDTO(vehiculoCore.getCliente());
        VehiculoDTO elVehiculo = new VehiculoDTO(vehiculoCore.getIdVehiculo(), vehiculoCore.getMatricula(), vehiculoCore.getMarca(), vehiculoCore.getModelo(), elClienteDTO);
        return elVehiculo;
    }

    public Vehiculo mapeoDTOCore(VehiculoDTO elVehiculoDTO) {
        try {
            Cliente elClienteCore = new ClienteDTOMapper().mapeoDTOCore(elVehiculoDTO.getCliente());
            return Vehiculo.factoryVehiculo(elVehiculoDTO.getIdVehiculo(), elVehiculoDTO.getMatricula(), elVehiculoDTO.getMarca(), elVehiculoDTO.getModelo(), elClienteCore);
        } catch (VehiculoIncompletoException e) {
            e.printStackTrace();
            return null;
        }
    }
}
