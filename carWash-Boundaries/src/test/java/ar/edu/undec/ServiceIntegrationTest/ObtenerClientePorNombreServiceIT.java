package ar.edu.undec.ServiceIntegrationTest;

import ar.edu.undec.Service.Controller.ObtenerClientePorNombreController;
import ar.edu.undec.Service.ModeloService.ClienteDTO;
import ar.edu.undec.Service.ServiceMapper.ClienteDTOMapper;
import excepciones.ClienteExisteException;
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
        List<Cliente> elClienteModelo=new ArrayList<>();
        ClienteDTO cliente1= new ClienteDTO(null,"Bautista", "Chilecito","Paiman Sur","20897654");
        ClienteDTO cliente2= new ClienteDTO(null,"Lucas", "Cordoba","Leandro Alem","45098345");
        elClienteModelo.add(new ClienteDTOMapper().mapeoDTOCore(cliente1));
        elClienteModelo.add(new  ClienteDTOMapper().mapeoDTOCore(cliente2));
        when(buscarClientePorNombreImput.buscarClientePorNombre(any(String.class))).thenReturn(elClienteModelo);
        ObtenerClientePorNombreController obtenerClientePorNombreController=new ObtenerClientePorNombreController(buscarClientePorNombreImput);
        assertEquals(obtenerClientePorNombreController.consultarClientePorNombre("Bautista").getStatusCodeValue(),HttpStatus.SC_OK);
    }
    @Test
    public void obtenerClientePorNombre_ElClientnoExiste_Devuelve204() throws Exception {
        List<Cliente> elClienteModelo=new ArrayList<>();
        when(buscarClientePorNombreImput.buscarClientePorNombre(any(String.class))).thenReturn(elClienteModelo);
        ObtenerClientePorNombreController obtenerClientePorNombreController=new ObtenerClientePorNombreController(buscarClientePorNombreImput);
        assertEquals(obtenerClientePorNombreController.consultarClientePorNombre("Bautista").getStatusCodeValue(),HttpStatus.SC_NO_CONTENT);
    }

    @Test
    public void obtenerClientePorNombre_ElClientnoExiste_Devuelve500() throws Exception {
        when(buscarClientePorNombreImput.buscarClientePorNombre(any(String.class))).thenReturn(null);
        ObtenerClientePorNombreController obtenerClientePorNombreController=new ObtenerClientePorNombreController(buscarClientePorNombreImput);
        assertEquals(obtenerClientePorNombreController.consultarClientePorNombre("Bautista").getStatusCodeValue(),HttpStatus.SC_INTERNAL_SERVER_ERROR);
    }


}
