package interactor;

import excepciones.ClienteExisteException;
import modelo.Cliente;
import repositorio.IModificarClienteRepo;

public class ModificarClienteUseCase {
    IModificarClienteRepo modificarClienteRepo;
    public ModificarClienteUseCase(IModificarClienteRepo modificarClienteRepo) {
        this.modificarClienteRepo=modificarClienteRepo;
    }

    public boolean modificarCliente(Cliente clienteDatosNuevo)throws ClienteExisteException {
        Cliente cliente = modificarClienteRepo.findByDNI(clienteDatosNuevo.getDocumento());
        if(cliente==null){
            return this.modificarClienteRepo.modificarCliente(clienteDatosNuevo);
        }else if(cliente.getIdCliente()!=clienteDatosNuevo.getIdCliente()){
            throw new ClienteExisteException("el Id del Cliente a Modificar no es igual al existente");
        }else return this.modificarClienteRepo.modificarCliente(clienteDatosNuevo);
    }
}
