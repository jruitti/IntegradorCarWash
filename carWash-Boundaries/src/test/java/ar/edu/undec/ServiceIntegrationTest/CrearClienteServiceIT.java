package ar.edu.undec.ServiceIntegrationTest;

import ar.edu.undec.Service.Controller.CrearClienteController;
import ar.edu.undec.Service.ModeloService.ClienteDTO;
import excepciones.ClienteExisteException;
import input.ICrearClienteInput;
import modelo.Cliente;
import org.apache.http.HttpStatus;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.omg.CORBA.Any;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@RunWith(SpringRunner.class)
@SpringBootTest
public class CrearClienteServiceIT {

    @Mock
    ICrearClienteInput crearClienteInput;

    @Test
    public void crearCliente_ClienteNoExiste_Devuelve200() throws Exception {
        ClienteDTO elCliente = new ClienteDTO(null,"Baista","Davila San Roman","El Asfalto","32458305");
        when(crearClienteInput.crearCliente(any(Cliente.class))).thenReturn(true);
        CrearClienteController crearClienteController = new CrearClienteController(crearClienteInput);
        assertEquals(crearClienteController.crearCliente(elCliente).getStatusCodeValue(),HttpStatus.SC_OK);

    }

    @Test
    public void crearCliente_ClienteExiste_Devuelve412() throws Exception {
        ClienteDTO elCliente=new ClienteDTO(null,"Baista","Davila San Roman","El Asfalto","32458305");
        when(crearClienteInput.crearCliente(any(Cliente.class))).thenThrow(new ClienteExisteException("El Cliente Existe"));
        CrearClienteController crearClienteController=new CrearClienteController(crearClienteInput);
        assertEquals(crearClienteController.crearCliente(elCliente).getStatusCodeValue(),HttpStatus.SC_PRECONDITION_FAILED);

    }
}
