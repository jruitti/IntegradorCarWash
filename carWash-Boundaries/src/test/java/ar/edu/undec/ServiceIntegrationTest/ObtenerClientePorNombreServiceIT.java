package ar.edu.undec.ServiceIntegrationTest;

import ar.edu.undec.Service.Controller.ObtenerClientePorNombreController;
import ar.edu.undec.Service.ModeloService.ClienteDTO;
import input.IBuscarClientePorNombreImput;
import interactor.BuscarClientesPorNombreUseCase;
import modelo.Cliente;
import org.apache.http.HttpStatus;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyList;
import static org.mockito.Mockito.when;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ObtenerClientePorNombreServiceIT {
    @Mock
    IBuscarClientePorNombreImput buscarClientePorNombreImput;

    @Test
    public void obtenerClientePorNombre_ElClientexiste_Devuelve200() throws Exception {
        List<ClienteDTO> losClientes=new ArrayList<>();
        ClienteDTO cliente1= new ClienteDTO(null,"Bautista", "Davila San roman 124","B° El Asfalto","32458305");
        ClienteDTO cliente2= new ClienteDTO(null,"Bautista", "Chilecito","Paiman Sur","20897654");
        ClienteDTO cliente3= new ClienteDTO(null,"Lucas", "Cordoba","Leandro Alem","45098345");
        losClientes.add(cliente1);
        losClientes.add(cliente2);
        losClientes.add(cliente3);

        List<Cliente> elClienteModelo=new ArrayList<>();
        Cliente bautistaPeña= Cliente.factoryCliente(1,"Bautista", "Davila San roman 124","B° El Asfalto","32458305");
        Cliente bautistaPerez= Cliente.factoryCliente(2,"Bautista", "Chilecito","Paiman Sur","20897654");
        Cliente bautistaBarboza= Cliente.factoryCliente(3,"Bautista", "Cordoba","Leandro Alem","45098345");
        elClienteModelo.add(bautistaPeña);
        elClienteModelo.add(bautistaPerez);
        elClienteModelo.add(bautistaBarboza);

        when(buscarClientePorNombreImput.buscarClientePorNombre("Bautista")).thenReturn(elClienteModelo);
        ObtenerClientePorNombreController obtenerClientePorNombreController=new ObtenerClientePorNombreController(buscarClientePorNombreImput);
        List<Cliente> resultado= (List<Cliente>) obtenerClientePorNombreController.consultarClientePorNombre("Bautista");
        //assertEquals(crearClienteController.crearCliente(elCliente).getStatusCodeValue(),HttpStatus.SC_OK);
        //assertEquals(((List<ClienteDTO>) ((List<ClienteDTO>) obtenerClientePorNombreController.consultarClientePorNombre("Bautista").));
        assertEquals(3,resultado.size());

    }
}
