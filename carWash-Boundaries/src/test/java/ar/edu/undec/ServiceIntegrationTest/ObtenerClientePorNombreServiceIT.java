package ar.edu.undec.ServiceIntegrationTest;
/*
import ar.edu.undec.Service.Controller.ObtenerClientePorNombreController;
import ar.edu.undec.Service.ModeloService.ClienteDTO;
import input.IBuscarClientePorNombreImput;
import interactor.BuscarClientesPorNombreUseCase;
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

        when(buscarClientePorNombreImput.buscarClientePorNombre("Bautista")).thenReturn(losClientes);
        ObtenerClientePorNombreController obtenerClientePorNombreController=new ObtenerClientePorNombreController(buscarClientePorNombreImput);
        List<ClienteDTO> resultado= obtenerClientePorNombreController.consultarClientePorNombre("Bautista");

        when(buscarClientePorNombreRepo.buscarClientePorNombre("Bautista")).thenReturn(losClientes);
        BuscarClientesPorNombreUseCase buscarClientePorNombreUseCase = new BuscarClientesPorNombreUseCase(buscarClientePorNombreRepo);
        List<Cliente> result=buscarClientePorNombreUseCase.buscarClientePorNombre("Bautista");
        Assertions.assertEquals(3,result.size());

        assertEquals(3,resultado.size());


        TipoPilotoDTO elTipoPiloto=new TipoPilotoDTO(null,"Comandante");
        when(crearTipoPilotoInput.crearTipoPiloto(any(TipoPiloto.class))).thenReturn(true);
        CrearTipoPilotoController crearTipoPilotoController=new CrearTipoPilotoController(crearTipoPilotoInput);
        assertEquals(crearTipoPilotoController.crearTipoPiloto(elTipoPiloto).getStatusCodeValue(), HttpStatus.SC_OK);
    }
}*/
