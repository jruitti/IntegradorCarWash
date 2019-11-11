package repositorio;

import modelo.Cliente;

public interface IModificarClienteRepo {
    Cliente findByDNI(String documento);

    boolean modificarCliente(Cliente clienteDatosNuevo);
}
