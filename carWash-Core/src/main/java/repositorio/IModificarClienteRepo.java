package repositorio;

import modelo.Cliente;

public interface IModificarClienteRepo {

    boolean modificarCliente(Cliente clienteDatosNuevo);

    Cliente findByDocumento(String documento);
}
