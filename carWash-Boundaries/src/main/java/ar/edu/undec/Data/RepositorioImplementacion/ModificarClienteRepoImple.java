package ar.edu.undec.Data.RepositorioImplementacion;

import ar.edu.undec.Data.EntityMapper.ClienteEntityMapper;
import ar.edu.undec.Data.ModeloEntity.ClienteEntity;
import ar.edu.undec.Data.RepositorioCRUD.IModificarClienteCRUD;
import modelo.Cliente;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import repositorio.IModificarClienteRepo;

@Service
public class ModificarClienteRepoImple implements IModificarClienteRepo {

    @Autowired
    IModificarClienteCRUD modificarClienteCRUD;


    @Override
    public boolean modificarCliente(Cliente clienteDatosNuevo) {
        ClienteEntity elClienteAGuardar= new ClienteEntityMapper().mapeoCoreData(clienteDatosNuevo);
        return modificarClienteCRUD.save(elClienteAGuardar)!=null;
    }
    @Override
    public Cliente findByDocumento(String documento) {
        Cliente elCliente=new ClienteEntityMapper().mapeoDataCore(modificarClienteCRUD.findByDocumento(documento));
        if(elCliente!=null){
            return elCliente;
        }
        return null;
    }
}
