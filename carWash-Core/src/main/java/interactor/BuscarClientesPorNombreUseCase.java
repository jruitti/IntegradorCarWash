package interactor;

import modelo.Cliente;
import repositorio.IBuscarClientePorNombreRepo;

import java.util.ArrayList;
import java.util.List;

public class BuscarClientesPorNombreUseCase {
    IBuscarClientePorNombreRepo buscarClientePorNombreRepo;
    public BuscarClientesPorNombreUseCase(IBuscarClientePorNombreRepo buscarClientePorNombreRepo) {
        this.buscarClientePorNombreRepo=buscarClientePorNombreRepo;
    }

    public List<Cliente> buscarClientePorNombre(String nombre) {

        return (List<Cliente>) buscarClientePorNombreRepo.buscarClientePorNombre(nombre);
    }


}
