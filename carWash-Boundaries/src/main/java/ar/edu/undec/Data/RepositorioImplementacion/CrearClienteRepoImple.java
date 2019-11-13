package ar.edu.undec.Data.RepositorioImplementacion;

import ar.edu.undec.Data.EntityMapper.ClienteEntityMapper;
import ar.edu.undec.Data.ModeloEntity.ClienteEntity;
import ar.edu.undec.Data.RepositorioCRUD.IBuscarClientePorDniCRUD;
import ar.edu.undec.Data.RepositorioCRUD.ICrearClienteCRUD;
import modelo.Cliente;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import repositorio.IRepositorioCrearCliente;
@Repository
public class CrearClienteRepoImple implements IRepositorioCrearCliente {

    @Autowired
    ICrearClienteCRUD crearClienteCRUD;
    @Autowired
    IBuscarClientePorDniCRUD buscarClientePorDniCRUD;

    @Override
    public boolean guardar(Cliente clienteNuevo) {
        ClienteEntity elClienteAGuardar = new ClienteEntityMapper().mapeoCoreData(clienteNuevo);
        return crearClienteCRUD.save(elClienteAGuardar).getIdCliente()!=null;
    }

    @Override
    public Cliente findByDocumento(String documento) {
        Cliente elCliente= new ClienteEntityMapper().mapeoDataCore(buscarClientePorDniCRUD.findByDocumento(documento));
        if(elCliente!=null){
            return elCliente;
        }
        return null;
    }

}
