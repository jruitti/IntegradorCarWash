package interactor;

import input.IBuscarClientePorNombreImput;
import modelo.Cliente;
import repositorio.IBuscarClientePorNombreRepo;

import java.util.List;

public class BuscarClientesPorNombreUseCase implements  IBuscarClientePorNombreImput{
    IBuscarClientePorNombreRepo buscarClientePorNombreRepo;
    public BuscarClientesPorNombreUseCase(IBuscarClientePorNombreRepo buscarClientePorNombreRepo) {
        this.buscarClientePorNombreRepo=buscarClientePorNombreRepo;
    }

    @Override
    public List<Cliente> buscarClientePorNombre(String nombre) {

        return (List<Cliente>) buscarClientePorNombreRepo.buscarClientePorNombre(nombre);
    }



}
