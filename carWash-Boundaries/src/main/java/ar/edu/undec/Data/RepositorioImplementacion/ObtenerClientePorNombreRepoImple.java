package ar.edu.undec.Data.RepositorioImplementacion;

import ar.edu.undec.Data.EntityMapper.ClienteEntityMapper;
import ar.edu.undec.Data.ModeloEntity.ClienteEntity;
import ar.edu.undec.Data.RepositorioCRUD.IObtenerClientePorNombreCRUD;
import modelo.Cliente;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import repositorio.IBuscarClientePorNombreRepo;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Service
public class ObtenerClientePorNombreRepoImple implements IBuscarClientePorNombreRepo {
    @Autowired
    IObtenerClientePorNombreCRUD iObtenerClientePorNombreCRUD;

    @Override
    public Collection<Cliente> buscarClientePorNombre(String nombreCliente) {
        List<Cliente> clientesBuscados=new ArrayList<>();
        for(ClienteEntity elCliente: iObtenerClientePorNombreCRUD.findByNombreContains(nombreCliente)){
            Cliente cliente = new ClienteEntityMapper().mapeoDataCore(elCliente);
            clientesBuscados.add(cliente);
        }
        return clientesBuscados;
    }
}
