package ar.edu.undec.Service.ServiceMapper;

import ar.edu.undec.Service.ModeloService.ClienteDTO;
import excepciones.ClienteIncompletoException;
import modelo.Cliente;

public class ClienteDTOMapper {
    public ClienteDTO mapeoCoreDTO(Cliente clienteCore){
        ClienteDTO clienteDTO=new ClienteDTO(clienteCore.getIdCliente(),clienteCore.getNombre(),clienteCore.getDomicilio(),clienteCore.getBarrio(),clienteCore.getDocumento());
        return clienteDTO;
    }

    public Cliente mapeoDTOCore(ClienteDTO clienteDTO){
        try {
            return Cliente.factoryCliente(clienteDTO.getIdCliente(),clienteDTO.getNombre(),clienteDTO.getDomicilio(),clienteDTO.getBarrio(),clienteDTO.getDocumento());
        } catch (ClienteIncompletoException e) {
            e.printStackTrace();
            return null;
        }
    }
}
