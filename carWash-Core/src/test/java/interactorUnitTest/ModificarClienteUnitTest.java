package interactorUnitTest;

import excepciones.ClienteExisteException;
import excepciones.ClienteIncompletoException;
import interactor.ModificarClienteUseCase;
import mockito.MockitoExtension;
import modelo.Cliente;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import repositorio.IModificarClienteRepo;

import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class ModificarClienteUnitTest {
    @Mock
    IModificarClienteRepo modificarClienteRepo;

    @Test
    public void modificarCliente_ClienteExistente_GuardaCorrectamente() throws ClienteIncompletoException, ClienteExisteException {

        Cliente clienteDatosNuevo=Cliente.factoryCliente(1,"Bautista", "Davila San roman 124","B° El Asfalto","32458305");
        when(modificarClienteRepo.findByDocumento("32458305")).thenReturn(null);
        when(modificarClienteRepo.modificarCliente(clienteDatosNuevo)).thenReturn(true);
        ModificarClienteUseCase modificarClienteUseCase = new ModificarClienteUseCase(modificarClienteRepo);
        boolean resultado= modificarClienteUseCase.modificarCliente(clienteDatosNuevo);
        Assertions.assertTrue(resultado);
    }

    @Test
    public void ModificarCliente_ConflictoEnId_ClienteExistente() throws ClienteIncompletoException {
        Cliente clienteDatosNuevo=Cliente.factoryCliente(1,"Bautista", "Davila San roman 124","B° El Asfalto","32458305");
        when(modificarClienteRepo.findByDocumento("32458305")).thenReturn(Cliente.factoryCliente(2,"Bautista", "Davila San roman 124","B° El Asfalto","32458305"));
        ModificarClienteUseCase modificarClienteUseCase = new ModificarClienteUseCase(modificarClienteRepo);
        Assertions.assertThrows(ClienteExisteException.class, () -> modificarClienteUseCase.modificarCliente(clienteDatosNuevo));

    }

    @Test
    public void modificarCliente_ConflictoConClienteExistentePeroEsElMismo_GuardaCorrectamente() throws ClienteIncompletoException,ClienteExisteException {

        Cliente clienteDatosNuevo=Cliente.factoryCliente(1,"Bautista", "Davila San roman 124","B° El Asfalto","32458305");
        when(modificarClienteRepo.findByDocumento("32458305")).thenReturn(Cliente.factoryCliente(1,"Lucas", "Davila San roman 124","B° Las Torres","32458305"));
        when(modificarClienteRepo.modificarCliente(clienteDatosNuevo)).thenReturn(true);
        ModificarClienteUseCase modificarClienteUseCase = new ModificarClienteUseCase(modificarClienteRepo);
        boolean resultado= modificarClienteUseCase.modificarCliente(clienteDatosNuevo);
        Assertions.assertTrue(resultado);

    }
}
