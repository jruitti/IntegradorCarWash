package input;

import modelo.Cliente;

import java.util.List;

public interface IBuscarClientePorNombreImput {

    List<Cliente> buscarClientePorNombre(String nombre);
}
