package input;

import excepciones.ClienteExisteException;
import modelo.Cliente;

public interface IModificarClienteInput {
    boolean modificarCliente(Cliente cliente) throws ClienteExisteException;
}
