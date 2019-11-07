package interactorUnitTest;

import excepciones.ClienteExisteException;
import excepciones.ClienteIncompletoException;
import interactor.CrearClienteUseCase;
import mockito.MockitoExtension;
import modelo.Cliente;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import repositorio.IRepositorioCrearCliente;

import static org.mockito.Mockito.when;
@ExtendWith(MockitoExtension.class)
public class CrearClienteUnitTest {
    @Mock
    IRepositorioCrearCliente crearClienteGateway;


    @Test
    public void crearCliente_ClienteNoExiste_GuardaCorrectamente() throws ClienteIncompletoException, ClienteExisteException {
        Cliente ClienteNuevo=Cliente.factoryCliente(1,"Bautista", "Davila San roman 124","B° El Asfalto","32458305");
        when(crearClienteGateway.guardar(ClienteNuevo)).thenReturn(true);
        CrearClienteUseCase crearClienteUseCase = new CrearClienteUseCase(crearClienteGateway);
        boolean resultado = crearClienteUseCase.crearCliente(ClienteNuevo);
        Assertions.assertTrue(resultado);
    }

    @Test
    public void crearCliente_ClienteExiste_ClienteExisteException() throws ClienteIncompletoException,ClienteExisteException {
        Cliente ClienteNuevo=Cliente.factoryCliente(1,"Bautista", "Davila San roman 124","B° El Asfalto","32458305");
        when(crearClienteGateway.findByDNI("32458305")).thenReturn(Cliente.factoryCliente(1,"Valentin", "Los Sarmientos 124","B° El Puquial","32458305"));
        CrearClienteUseCase crearClienteUseCase = new CrearClienteUseCase(crearClienteGateway);
        Assertions.assertThrows(ClienteExisteException.class, () -> crearClienteUseCase.crearCliente(ClienteNuevo));

    }
}
