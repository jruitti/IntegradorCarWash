package interactorUnitTest;

import excepciones.ClienteIncompletoException;
import interactor.BuscarClientesPorNombreUseCase;
import mockito.MockitoExtension;
import modelo.Cliente;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Spy;
import repositorio.IBuscarClientePorNombreRepo;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.reset;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class ObtenerClientePorNombreUnitTest {
    @Mock
    IBuscarClientePorNombreRepo buscarClientePorNombreRepo;

    @Test
    public void buscarClientePorNombre_ExistenClientes_devuelveLista() throws ClienteIncompletoException {
        List<Cliente> losClientes=new ArrayList<>();
        Cliente bautistaPeña= Cliente.factoryCliente(1,"Bautista", "Davila San roman 124","B° El Asfalto","32458305");
        Cliente bautistaPerez= Cliente.factoryCliente(2,"Bautista", "Chilecito","Paiman Sur","20897654");
        Cliente bautistaBarboza= Cliente.factoryCliente(3,"Bautista", "Cordoba","Leandro Alem","45098345");
        losClientes.add(bautistaPeña);
        losClientes.add(bautistaPerez);
        losClientes.add(bautistaBarboza);
        
        when(buscarClientePorNombreRepo.buscarClientePorNombre("Bautista")).thenReturn(losClientes);
        BuscarClientesPorNombreUseCase buscarClientePorNombreUseCase = new BuscarClientesPorNombreUseCase(buscarClientePorNombreRepo);
        List<Cliente> result=buscarClientePorNombreUseCase.buscarClientePorNombre("Bautista");
        Assertions.assertEquals(3,result.size());
    }



}
