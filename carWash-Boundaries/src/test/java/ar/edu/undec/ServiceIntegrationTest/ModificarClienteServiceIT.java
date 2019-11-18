package ar.edu.undec.ServiceIntegrationTest;

import ar.edu.undec.Service.Controller.ModificarClienteController;
import ar.edu.undec.Service.ModeloService.ClienteDTO;
import excepciones.ClienteExisteException;
import input.IModificarClienteInput;
import modelo.Cliente;
import org.apache.http.HttpStatus;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static junit.framework.TestCase.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ModificarClienteServiceIT {
 ClienteDTO elCliente = new ClienteDTO(null,"Baista","Davila San Roman","El Asfalto","32458305");
    @Mock
    IModificarClienteInput modificarClienteInput;

    @Test
    public void modificarCliente_ClienteModificado_DevuelveTrue200() throws ClienteExisteException {
        ClienteDTO elClienteAModificar = new ClienteDTO(null,"Baista","Davila San Roman","El Asfalto","32458305");
        when(modificarClienteInput.modificarCliente(any(Cliente.class))).thenReturn(true);
        ModificarClienteController modificarClienteController = new ModificarClienteController(modificarClienteInput);
        assertEquals(modificarClienteController.modificarCliente(elClienteAModificar).getStatusCodeValue(), org.apache.http.HttpStatus.SC_OK);

    }
    @Test
    public void modificarCliente_ClienteModificado_DevuelveFalseError412() throws ClienteExisteException {
        ClienteDTO elClienteAModificar = new ClienteDTO(null,"Baista","Davila San Roman","El Asfalto","32458305");
        when(modificarClienteInput.modificarCliente(any(Cliente.class))).thenThrow(new ClienteExisteException("Error Al Modificar El cliente"));
        ModificarClienteController modificarClienteController = new ModificarClienteController(modificarClienteInput);
        assertEquals(modificarClienteController.modificarCliente(elClienteAModificar).getStatusCodeValue(), HttpStatus.SC_PRECONDITION_FAILED);

    }


}
