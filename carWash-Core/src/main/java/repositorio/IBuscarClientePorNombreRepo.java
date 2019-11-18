package repositorio;

import modelo.Cliente;

import java.util.Collection;


public interface IBuscarClientePorNombreRepo {

    Collection<Cliente> buscarClientePorNombre(String nombreCliente);

}
