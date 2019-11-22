package ar.edu.undec.ServiceIntegrationTest;

import ar.edu.undec.Service.Controller.ObtenerMontoIngresadoPorTurnoEntreFechasController;
import ar.edu.undec.Service.ModeloService.ClienteDTO;
import ar.edu.undec.Service.ModeloService.EmpleadoDTO;
import ar.edu.undec.Service.ModeloService.TurnoDTO;
import ar.edu.undec.Service.ModeloService.VehiculoDTO;
import excepciones.FechaIncorrectaException;
import input.IObtenerMontoIngresadoPorTurnoEntreFechasInpu;
import org.apache.http.HttpStatus;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ObtenerMontoIngresadoPorTunoEntreFechasIT {

    @Mock
    IObtenerMontoIngresadoPorTurnoEntreFechasInpu obtenerMontoIngresadoPorTurnoEntreFechasInpu;

    @Test
    public void obtenerMontoIngresadoPorTunoEntreFechas_fechaCorrecta_ok200() throws FechaIncorrectaException {
        ClienteDTO lucas= new ClienteDTO(1,"Lucas", "Davila San roman 124","B° El Asfalto","32458305");
        ClienteDTO bautista=new ClienteDTO(1,"Bautista", "San roman 124","B° Las Torres","20458098");
        ClienteDTO daniel=new ClienteDTO(1,"Daniel", "Davila 124","B° Paiman Sur","30987789");

        List<TurnoDTO> losTurnos=new ArrayList<>();
        TurnoDTO turnoUno= new TurnoDTO(1, new VehiculoDTO(1,"IXI056","Ford","2019", bautista), LocalDate.of(2019, 11, 9), new EmpleadoDTO(1,"Pedro",234),100);
        TurnoDTO turnoDos=new TurnoDTO(2, new VehiculoDTO(2,"GFH987","Toyota","2019", lucas), LocalDate.of(2019, 11, 11), new EmpleadoDTO(2,"Luis",235),350);
        TurnoDTO turnoTres=new TurnoDTO(3, new VehiculoDTO(3,"ADS208","Renult","2010", daniel), LocalDate.of(2019, 11, 15), new EmpleadoDTO(2,"Luis",235),450);
        TurnoDTO turnoCuatros=new TurnoDTO(4, new VehiculoDTO(4,"POI123","Fiat","2018", lucas), LocalDate.of(2019, 11, 20), new EmpleadoDTO(1,"Pedro",234),200);
        when(obtenerMontoIngresadoPorTurnoEntreFechasInpu.montoObtenidoEntreFechas(LocalDate.of(2019, 11, 9),LocalDate.of(2019, 11, 20))).thenReturn(1.100);
        ObtenerMontoIngresadoPorTurnoEntreFechasController obtenerMontoIngresadoPorTurnoEntreFechasController=new ObtenerMontoIngresadoPorTurnoEntreFechasController(obtenerMontoIngresadoPorTurnoEntreFechasInpu);
        assertEquals(obtenerMontoIngresadoPorTurnoEntreFechasController.obtenerMonto(LocalDate.of(2019,11,9).toString(),LocalDate.of(2019,11,20).toString()).getStatusCodeValue(), HttpStatus.SC_OK);
    }

    @Test
    public void obtenerMontoIngresadoPorTunoEntreFechas_NoContieneElMonto_Error204() throws FechaIncorrectaException {
        ClienteDTO lucas= new ClienteDTO(1,"Lucas", "Davila San roman 124","B° El Asfalto","32458305");
        ClienteDTO bautista=new ClienteDTO(1,"Bautista", "San roman 124","B° Las Torres","20458098");
        ClienteDTO daniel=new ClienteDTO(1,"Daniel", "Davila 124","B° Paiman Sur","30987789");

        List<TurnoDTO> losTurnos=new ArrayList<>();
        TurnoDTO turnoUno= new TurnoDTO(1, new VehiculoDTO(1,"IXI056","Ford","2019", bautista), LocalDate.of(2019, 11, 9), new EmpleadoDTO(1,"Pedro",234),100);
        TurnoDTO turnoDos=new TurnoDTO(2, new VehiculoDTO(2,"GFH987","Toyota","2019", lucas), LocalDate.of(2019, 11, 11), new EmpleadoDTO(2,"Luis",235),350);
        TurnoDTO turnoTres=new TurnoDTO(3, new VehiculoDTO(3,"ADS208","Renult","2010", daniel), LocalDate.of(2019, 11, 15), new EmpleadoDTO(2,"Luis",235),450);
        TurnoDTO turnoCuatros=new TurnoDTO(4, new VehiculoDTO(4,"POI123","Fiat","2018", lucas), LocalDate.of(2019, 11, 20), new EmpleadoDTO(1,"Pedro",234),200);
        when(obtenerMontoIngresadoPorTurnoEntreFechasInpu.montoObtenidoEntreFechas(LocalDate.of(2019, 11, 9),LocalDate.of(2019, 11, 20))).thenReturn(-1.100);
        ObtenerMontoIngresadoPorTurnoEntreFechasController obtenerMontoIngresadoPorTurnoEntreFechasController=new ObtenerMontoIngresadoPorTurnoEntreFechasController(obtenerMontoIngresadoPorTurnoEntreFechasInpu);
        assertEquals(obtenerMontoIngresadoPorTurnoEntreFechasController.obtenerMonto(LocalDate.of(2019,11,9).toString(),LocalDate.of(2019,11,20).toString()).getStatusCodeValue(), HttpStatus.SC_NO_CONTENT);
    }


}
